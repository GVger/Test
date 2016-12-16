using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.OleDb;

namespace ManaCS
{
    class DBOperation
    {
        public static string strCon = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=../../accessDB/ManaCS.mdb";
        private OleDbConnection conn;
        private static DBOperation dbOperation;
        private OleDbDataReader oDReader;
        private int infectRow = 0;

        private DBOperation() { }

        public static DBOperation getDBOperation()
        {
              if (dbOperation == null)
              {
                  dbOperation = new DBOperation();
              }
              return dbOperation;
        }

        public int connectDB()
        {
            if (conn == null)
            {
                conn = new OleDbConnection(strCon);
            } 
            if (conn == null)
            {
                return -1;
            } 
            else
            {
                return 0;
            }
        }

        public void openDB()
        {
            if (conn != null)
            {
                conn.Open();
            }
        }

        public void sqlOperation(string sql)
        {
            OleDbCommand ODC = new OleDbCommand(sql, conn);
            oDReader = ODC.ExecuteReader();
        }

        public void sqlNonQueryOperation(string sql)
        {
            OleDbCommand ODC = new OleDbCommand(sql, conn);
            infectRow = ODC.ExecuteNonQuery();
        }

        public OleDbDataReader getReader()
        {
            return oDReader;
        }

        public int getInfectRow()
        {
            return infectRow;
        }

        public void closeDB()
        {
            if (oDReader != null)
            {
                oDReader.Close();
            }
            if (conn != null)
            {
                conn.Close();
            }
        }
    }

}
