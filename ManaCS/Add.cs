using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ManaCS
{
    class Add
    {
        private DBOperation dbO = DBOperation.getDBOperation();
        private bool result = false;

        public Add(int userId, int money, DateTime dt,bool isIn)
        {
            dbO.connectDB();
            dbO.openDB();
            result = addData(userId, money, dt, isIn);
            dbO.closeDB();
        }


        public bool getResult()
        {
            return result;
        }

        private bool addData(int userId, int money, DateTime dt,bool isIn)
        {
            string sql = "insert into ";
            if (isIn)
            {
                sql += "tab_in(user_id, money_in, date_in) ";
            } 
            else
            {
                sql += "tab_out(user_id, money_out, date_out) ";
            }
            sql += "values("+ userId+","+money+",'"+dt.ToShortDateString()+"')";
            try
            {
                dbO.sqlNonQueryOperation(sql);
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
