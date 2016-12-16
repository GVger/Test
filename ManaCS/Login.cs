using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.OleDb;

namespace ManaCS
{
    class Login
    {
        private DBOperation dbO = DBOperation.getDBOperation();
        private OleDbDataReader reader = null;
        private int userId = 0;
        private bool result = false;

        public Login(string userName, string userPsw)
        {
            dbO.connectDB();
            dbO.openDB();
            dbO.sqlOperation("select user_psw from tab_user where user_name = "+"'"+ userName +"'");
            try
            {
                reader = dbO.getReader();
                reader.Read();
                string psw = (string)reader["user_psw"];
                if ((psw == userPsw) || psw.Equals(userPsw))
                {
                    result = true;
                    setUserId(userName);
                }
            }
            catch (System.Exception ex)
            {
            	//输出日志
            }
            dbO.closeDB();
        }

        private void setUserId(string userName)
        {
            dbO.sqlOperation("select user_id from tab_user where user_name = " + "'" + userName + "'");
            try
            {
                reader = dbO.getReader();
                reader.Read();
                userId = (int)reader["user_id"];
            }
            catch (System.Exception ex)
            {
                //输出日志
            }
        }

        public bool getResult()
        {
            return result;
        }

        public int getUserId()
        {
            return userId;
        }
    }
}
