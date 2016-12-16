using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.OleDb;

namespace ManaCS
{
    class Register
    {
        private DBOperation dbO = DBOperation.getDBOperation();
        private OleDbDataReader reader = null;
        private string strResult = "";
        private bool bResult = false;

        public Register(string userName, string psw)
        {
            dbO.connectDB();
            dbO.openDB();
            if (hasUser(userName))
            {
                strResult = "已存在该用户";
                bResult = false;
            }
            else
            {
                if (insertUser(userName, psw))
                {
                    strResult = "注册成功";
                    bResult = true;
                }
                else
                {
                    strResult = "注册失败";
                    bResult = false;
                }
                
            }
            dbO.closeDB();
        }

        public string getStrResult()
        {
            return strResult;
        }

        public bool getBoolResult()
        {
            return bResult;
        }

        //如果存在用户返回true，不存在就返回false
        private bool hasUser(string userName)
        {
            dbO.sqlOperation("select user_id from tab_user where user_name=" + "'" + userName + "'");
            try
            {
                reader = dbO.getReader();
                if (!reader.Read())
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            catch (System.Exception ex)
            {
            	//输出日志
            }
            return true;
        }

        //插入成功返回true
        private bool insertUser(string userName, string psw)
        {
            try
            {
                dbO.sqlNonQueryOperation("insert into tab_user(user_name,user_psw) values ('"+ userName+ "','"+ psw+ "')");
                if (dbO.getInfectRow() == 0)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            catch (System.Exception ex)
            {
            	//输出日志
            }
            return false;
        }
    }
}
