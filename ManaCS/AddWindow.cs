using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace ManaCS
{
    public partial class AddWindow : Form
    {
        private int userId = 0;
        private Add add = null;

        public AddWindow(int userId)
        {
            InitializeComponent();
            this.userId = userId;
        }

        private void Btn_Cancel_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }


        //判断字符串是否所有都是数字
        private bool isNum(string str)
        {
            char[] ch=new char[str.Length];
            ch=str.ToCharArray();
            for (int i = 0; i < str.Length; i++ )
            {
                if (ch[i] < 48 || ch[i] > 57)
                    return false;
            }
            return true;
        }

        private void Btn_OK_Click(object sender, EventArgs e)
        {
            DateTime dTime = this.dateTime.Value;
            RadioButton rIn = this.NewIn;
            string text = this.moneyTextBox.Text;
            bool isIn = true;

            if (!isNum(text) || text == "")
            {
                MessageBox.Show("金额请输入数字");
                return;
            }
            int money = int.Parse(text);

            if (rIn.Checked)
            {
                isIn = true;
            } 
            else
            {
                isIn = false;
            }
            add = new Add(userId, money, dTime,isIn);
            if (add.getResult())
            {
                MessageBox.Show("添加成功");
            } 
            else
            {
                MessageBox.Show("添加失败");
            }
        }
    }
}
