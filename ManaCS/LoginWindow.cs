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
    public partial class LoginWindow : Form
    {
        private string code = null;
        Login login = null;


        public LoginWindow()
        {
            InitializeComponent();
            code = paintCode();
        }

        //生成随机验证码
        private char[] produceCode()
        {
            //60个字符的字符表
            int charCount = 60;
            char[] charTab = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                               'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                               '我','是','最','帅','的','郭','健','伟'
                             };

            //获取随机字符
            Random r = new Random((int)DateTime.Now.Ticks);
            int index1 = r.Next(0, charCount);
            int index2 = r.Next(0, charCount);
            int index3 = r.Next(0, charCount);
            int index4 = r.Next(0, charCount);
            //生成字符数组
            char[] chResult = new char[4];
            chResult[0] = charTab[index1];
            chResult[1] = charTab[index2];
            chResult[2] = charTab[index3];
            chResult[3] = charTab[index4];
            return chResult;
        }

        //画出验证码，返回验证码
        private string paintCode()
        {
            //生成string的验证码
            string str = new string(produceCode());
            //创建Graphics
            Bitmap image = new Bitmap(150,50);
            Graphics g = Graphics.FromImage(image);

            //生成验证码的步骤
            //填充背景,输出字体，生成干扰
            g.Clear(Color.White);
            Font font = new Font("宋体", 30, FontStyle.Bold);
            g.DrawString(str, font, new SolidBrush(Color.Red), 2, 2);

            //生成随机线
            Random random = new Random();
            for (int i = 0; i < 6; i++)
            {
                int x1 = random.Next(image.Width);
                int x2 = random.Next(image.Width);
                int y1 = random.Next(image.Height);
                int y2 = random.Next(image.Height);
                g.DrawLine(new Pen(Color.Blue), x1, y1, x2, y2);
            }
            
            //生成随机点
            for (int i = 0; i < 2000; i++)
            {
                int x = random.Next(image.Width);
                int y = random.Next(image.Height);
                image.SetPixel(x, y, Color.FromArgb(random.Next()));
            }

            //画出矩形框
            g.DrawRectangle(new Pen(Color.Silver), 0, 0, image.Width - 1, image.Height - 1);
            this.CodePicBox.Width = image.Width;
            this.CodePicBox.Height = image.Height;
            this.CodePicBox.BackgroundImage = image;

            return str;

        }

        //切换验证码
        private void codePicBox_Click(object sender, EventArgs e)
        {
            code = paintCode();
        }

        //登录按钮事件
        private void Login_Click(object sender, EventArgs e)
        {
            if (this.CheckCodeText.Text == code)
            {
                string userName = this.UserNameText.Text;
                string psw = this.PassWordText.Text;

                //判断用户名，密码时候为空，是否正确
                if ((userName == null) || (userName == ""))
                {
                    MessageBox.Show("请输入用户名");
                }
                else
                {
                    if ((psw == null) || (psw == ""))
                    {
                        MessageBox.Show("请输入密码");
                    }
                    else
                    {
                        login = new Login(userName, psw);
                        if (login.getResult())
                        {
                            if (Application.OpenForms["MainWindow"] == null) //检测是否打开过主窗口
                            {
                                MainWindow mainWindow = new MainWindow(userName, login.getUserId(),this);
                                this.Hide();
                                DialogResult d = mainWindow.ShowDialog();
                                if ( d == DialogResult.Cancel)
                                {
                                    this.Close();
                                } 
                                //判断主界面是否是再次登录
                                if (d == DialogResult.OK)
                                {
                                    this.UserNameText.Text = null;
                                    this.PassWordText.Text = null;
                                    this.CheckCodeText.Text = null;
                                    code = paintCode();

                                }
                            }     
                        } 
                        else
                        {
                            MessageBox.Show("用户或者密码错误");
                            code = paintCode();
                        }
                    }
                }
            } 
            //验证码输入错误
            else
            {
                MessageBox.Show("验证码错误");
                code = paintCode();
            }
        }

        private void Cancel_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void Register_Click(object sender, EventArgs e)
        {
            RegisterWindow registerWnd = new RegisterWindow(this);
            this.Hide();
            registerWnd.ShowDialog();
        }
    }
}
