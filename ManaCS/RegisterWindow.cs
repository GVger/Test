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
    public partial class RegisterWindow : Form
    {
        private LoginWindow login;
        private Register register;

        public RegisterWindow(Form login)
        {
            InitializeComponent();
            this.login = (LoginWindow)login;
        }

        private void RegisterWindow_FormClosing(object sender, FormClosingEventArgs e)
        {
            login.Show();
            this.Dispose();
        }

        private void Btn_OK_Click(object sender, EventArgs e)
        {
            string userName = this.UserNameText.Text;
            string psw = this.PswText.Text;
            string confirmPsw = this.ConfirmPswText.Text;

            if (userName == null || userName == "")
            {
                MessageBox.Show("请输入用户名");
            }
            else
            {
                if (psw == null || psw == "")
                {
                    MessageBox.Show("请输入密码");
                }
                else
                {
                    if (confirmPsw == null || confirmPsw == "")
                    {
                        MessageBox.Show("请输入确认密码");
                    }
                    else
                    {
                        if (!psw.Equals(confirmPsw))
                        {
                            MessageBox.Show("两次输入的密码不相符");
                        }
                        else
                        {
                            register = new Register(userName, psw);
                            MessageBox.Show(register.getStrResult());
                            //注册成功
                            if (register.getBoolResult())
                            {
                                login.Show();
                                this.Dispose();
                            } 
                        }
                    }
                }
            }
        }

        private void Btn_Cancel_Click(object sender, EventArgs e)
        {
            login.Show();
            this.Dispose();
        }
    }
}
