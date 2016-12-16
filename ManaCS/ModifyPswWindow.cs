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
    public partial class ModifyPswWindow : Form
    {
        private string userName = null;
        ModifyPsw mdPsw = null;

        public ModifyPswWindow(string userName)
        {
            InitializeComponent();
            this.userName = userName;
        }

        private void Btn_Cancel_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void Btn_OK_Click(object sender, EventArgs e)
        {
            string psw = this.PswTextBox.Text;
            string confirmPsw = this.ConfirmPswTextBox.Text;
            if (psw == null || psw == "")
            {
                MessageBox.Show("请输入要修改成的密码");
            } 
            else
            {
                if (confirmPsw == null || confirmPsw == "")
                {
                    MessageBox.Show("请输入去确认修改的密码");
                } 
                else
                {
                    if (!psw.Equals(confirmPsw))
                    {
                        MessageBox.Show("请确认两次的密码一致");
                    } 
                    else
                    {
                        mdPsw = new ModifyPsw(userName,psw);
                        if (mdPsw.getResult())
                        {
                            MessageBox.Show("修改密码成功");
                            this.Dispose();
                        }
                        else 
                        {
                            MessageBox.Show("修改密码失败");
                        }
                    }
                }
            }
        }
    }
}
