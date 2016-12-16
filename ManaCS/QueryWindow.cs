using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.OleDb;

namespace ManaCS
{
    public partial class QueryWindow : Form
    {
        private Query query = null;
        private int userId = 0;
        private OleDbDataReader reader = null;
        private DataTable dt = null;

        private int i = 0;
        private Export export = null;

        public QueryWindow(int userId)
        {
            InitializeComponent();
            this.userId = userId;
        }

        private void Btn_Query_Click(object sender, EventArgs e)
        {
            i = this.tabCtrl.SelectedIndex;
            dt = new DataTable("Query");
            DataRow dr = null;
            dt.Clear();

            query = new Query(userId,i);
            reader = query.getReader();
           
            if(!reader.Read())
            {
                MessageBox.Show("没有数据");
                query.closeReader();
                return;
            }
            else
            {
                //i=0,收入。i=1，支出
                if (i == 0)
                {
                    dt.Columns.Add("日期", typeof(DateTime));
                    dt.Columns.Add("收入的金额", typeof(int));
                    
                    //无法读取第一行，原因不明
                    while (reader.Read())
                    {
                        dr = dt.NewRow();
                        dr[0] = reader.GetDateTime(reader.GetOrdinal("date_in"));
                        dr[1] = reader.GetInt32(reader.GetOrdinal("money_in"));
                        dt.Rows.Add(dr);
                    }
                    this.dateInView.DataSource = dt;
                }
                else if (i == 1)
                {
                    dt.Columns.Add("日期", typeof(DateTime));
                    dt.Columns.Add("支出的金额", typeof(int));

                    //无法读取第一行，原因不明
                    while (reader.Read())
                    {
                        dr = dt.NewRow();
                        dr[0] = reader.GetDateTime(reader.GetOrdinal("date_out"));
                        dr[1] = reader.GetInt32(reader.GetOrdinal("money_out"));
                        dt.Rows.Add(dr);
                    }
                    this.dateOutView.DataSource = dt;

                }
            }
            query.closeReader();
        }

        private void Btn_Expor_Click(object sender, EventArgs e)
        {
            if (dt == null || dt.Rows.Count == 0)
            {
                MessageBox.Show("请先查询出结果");
            } 
            else
            {
                export = new Export(dt, i);
                if (export.getResult())
                {
                    MessageBox.Show("导出成功");
                } 
                else
                {
                    MessageBox.Show("导出失败");
                }
                
            }
        }
    }
}
