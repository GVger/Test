using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;

namespace ManaCS
{
    class Export
    {
        private Microsoft.Office.Interop.Excel.Application app;
        private Microsoft.Office.Interop.Excel._Workbook workbook;
        private Microsoft.Office.Interop.Excel._Worksheet worksheet;
        private bool result = false;

        public Export(System.Data.DataTable dt, int type)
        {
            app = new Microsoft.Office.Interop.Excel.Application();
            app.Application.Workbooks.Add(true);//不存在文件则新建文件
            workbook = app.ActiveWorkbook;//激活工作簿
            worksheet = workbook.ActiveSheet;
            exportData(dt, type);
        }

        public bool getResult()
        {
            return result;
        }

        private void exportData(System.Data.DataTable dt, int type)
        {
            worksheet.Cells[1,1] = "序号";
            worksheet.Cells[1,2] = "日期";
            worksheet.Cells[1,3] = "金额";

            for (int i = 0; i < dt.Rows.Count; i++ )
            {
                worksheet.Cells[i + 2, 1] = i + 1;
                worksheet.Cells[i + 2, 2] = dt.Rows[i][0];
                worksheet.Cells[i + 2, 3] = dt.Rows[i][1];
            }
            worksheet.Columns.EntireColumn.AutoFit();
            try
            {
                if (type == 0)
                {
                    worksheet.Name = "收入详细表";
                    workbook.SaveAs(@"F:\工作区\CSharp\ManaCS\ManaCS\export\收入详细.xlsx", System.Reflection.Missing.Value,
                        System.Reflection.Missing.Value, System.Reflection.Missing.Value,
                        System.Reflection.Missing.Value, System.Reflection.Missing.Value,
                        Microsoft.Office.Interop.Excel.XlSaveAsAccessMode.xlNoChange,
                        System.Reflection.Missing.Value, System.Reflection.Missing.Value,
                        System.Reflection.Missing.Value, System.Reflection.Missing.Value,
                        System.Reflection.Missing.Value);
                }
                else
                {
                    worksheet.Name = "支出详细表";
                    workbook.SaveAs(@"F:\工作区\CSharp\ManaCS\ManaCS\export\支出详细.xlsx", System.Reflection.Missing.Value,
                        System.Reflection.Missing.Value, System.Reflection.Missing.Value,
                        System.Reflection.Missing.Value, System.Reflection.Missing.Value,
                        Microsoft.Office.Interop.Excel.XlSaveAsAccessMode.xlNoChange,
                        System.Reflection.Missing.Value, System.Reflection.Missing.Value,
                        System.Reflection.Missing.Value, System.Reflection.Missing.Value,
                        System.Reflection.Missing.Value);
                }
                workbook.Close(null, null, null);
                app.Quit();
                app = null;
                result = true;
                return;
            }
            catch (System.Exception ex)
            {
            	//输出工作日志
            }
            result = false;
        }
    }
}
