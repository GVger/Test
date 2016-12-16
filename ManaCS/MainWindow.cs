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
    public partial class MainWindow : Form
    {
        private string userName = "登录";
        private int userId = 0;
        private LoginWindow loginWnd;

        public MainWindow(string userName, int userId,Form loginWnd)
        {
            InitializeComponent();
            this.loginWnd = (LoginWindow)loginWnd;
            this.userName = userName;
            this.userId = userId;
            this.loginStatus.Text = "登录用户："+userName;
        }

        private void about_Click(object sender, EventArgs e)
        {
            Abuot aboutWnd = new Abuot();
            aboutWnd.Show();
        }

        private void aboutMenuItem_Click(object sender, EventArgs e)
        {
            if (Application.OpenForms["Abuot"] == null) //检测是否打开过Abuot的窗体
            {
                Abuot aboutWnd = new Abuot();
                aboutWnd.MdiParent = this;
                aboutWnd.Show();
            } 
            else
            {
                Application.OpenForms["Abuot"].Show();
            }
        }

        private void cancelStatus_Click(object sender, EventArgs e)
        {
            this.loginStatus.Text = "登录";
            userName = null;
            userId = 0;
        }

        private void loginStatus_Click(object sender, EventArgs e)
        {
            if (userName != null)
            {
                ModifyPswWindow mpWindow = new ModifyPswWindow(userName);
                mpWindow.ShowDialog();
            } 
            else
            {
                loginWnd.Show();
                this.DialogResult = DialogResult.OK;
                this.Dispose();
            }
        }

        private void add_Click(object sender, EventArgs e)
        {
            if (Application.OpenForms["AddWindow"] == null)
            {
                AddWindow addWindow = new AddWindow(userId);
                addWindow.MdiParent = this;
                addWindow.Show();
            } 
            else
            {
                Application.OpenForms["AddWindow"].Show();
            }
        }

        private void query_Click(object sender, EventArgs e)
        {
            if (Application.OpenForms["QueryInWindow"] == null)
            {
                QueryWindow qiWindow = new QueryWindow(userId);
                qiWindow.MdiParent = this;
                qiWindow.Show();
            }
            else
            {
                Application.OpenForms["QueryInWindow"].Show();
            }
        }

        private void dontTouchMe_Click(object sender, EventArgs e)
        {
            MessageBox.Show("别点我");
        }

        private void MainWindow_Resize(object sender, EventArgs e)
        {
            this.BackgroundImage = Bitmap.FromFile("../../pic/bg.jpg");
            this.BackgroundImageLayout = ImageLayout.Stretch;
        }
    }
}
