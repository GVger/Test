using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.OleDb;

namespace ManaCS
{
    class Query
    {
        private DBOperation dbO = DBOperation.getDBOperation();
        private OleDbDataReader reader = null;

        //type为0的时候为收入，为1的时候为支出
        public Query(int userId,int type)
        {
            dbO.connectDB();
            dbO.openDB();
            queryData(userId, type);
        }

        public OleDbDataReader getReader()
        {
            return reader;
        }

        public void closeReader() 
        {
            dbO.closeDB();
        }

        private void queryData(int userId, int type)
        {
            string sql = "select ";

            //区分表格和行
            if (type == 0)
            {
                sql += "money_in,date_in from tab_in ";
            } 
            else if(type == 1)
            {
                sql += "money_out,date_out from tab_out ";
            }
            sql += "where user_id=" + userId /*+ "and "*/;
            /*
            //区分时间类型
            if (type == 0)
            {
                sql += "date_in>="+beginTime.ToShortDateString()+" and date_in<="+ endTime.ToShortDateString();
            }
            else if (type == 1)
            {
                sql += "date_out>=" + beginTime.ToShortDateString() + " and date_out<=" + endTime.ToShortDateString();
            }*/
            try
            {
                dbO.sqlOperation(sql);
                reader = dbO.getReader();
            }
            catch (System.Exception ex)
            {
            	//输出日志
            }
        }
    }
}
