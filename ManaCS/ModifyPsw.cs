using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ManaCS
{
    class ModifyPsw
    {
        private DBOperation dbO = DBOperation.getDBOperation();
        private bool result = false;

        public ModifyPsw(string userName, string mPsw)
        {
            dbO.connectDB();
            dbO.openDB();
            modifyPsw(userName, mPsw);
            dbO.closeDB();
        }

        private void modifyPsw(string userName, string mPsw)
        {
            try
            {
                dbO.sqlNonQueryOperation("update tab_user set user_psw = '" + mPsw + "' where user_name = '" + userName + "'");
                if (dbO.getInfectRow() != 0)
                {
                    result = true;
                } 
                else
                {
                    result = false;
                }
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

    }
}
