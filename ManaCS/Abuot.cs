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
    public partial class Abuot : Form
    {
        public Abuot()
        {
            InitializeComponent();
        }

        private void Abuot_Paint(object sender, PaintEventArgs e)
        {
            Image img_About = Image.FromFile("../../pic/about.jpg");//上上级的pic文件夹中的about图片
            Graphics g = this.CreateGraphics();
            g.DrawImage(img_About, 10, 10, 200, (int)(200*1.33));
        }
    }
}
