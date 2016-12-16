namespace ManaCS
{
    partial class MainWindow
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MainWindow));
            this.menuBar = new System.Windows.Forms.MenuStrip();
            this.add = new System.Windows.Forms.ToolStripMenuItem();
            this.query = new System.Windows.Forms.ToolStripMenuItem();
            this.aboutMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.statusBar = new System.Windows.Forms.StatusStrip();
            this.loginStatus = new System.Windows.Forms.ToolStripStatusLabel();
            this.fengefu = new System.Windows.Forms.ToolStripStatusLabel();
            this.cancelStatus = new System.Windows.Forms.ToolStripStatusLabel();
            this.ToolBar = new System.Windows.Forms.ToolStrip();
            this.dontTouchMe = new System.Windows.Forms.ToolStripButton();
            this.menuBar.SuspendLayout();
            this.statusBar.SuspendLayout();
            this.ToolBar.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuBar
            // 
            this.menuBar.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.add,
            this.query,
            this.aboutMenuItem});
            this.menuBar.Location = new System.Drawing.Point(0, 0);
            this.menuBar.Name = "menuBar";
            this.menuBar.Size = new System.Drawing.Size(784, 25);
            this.menuBar.TabIndex = 1;
            this.menuBar.Text = "menuStrip1";
            // 
            // add
            // 
            this.add.Name = "add";
            this.add.Size = new System.Drawing.Size(68, 21);
            this.add.Text = "添加记录";
            this.add.Click += new System.EventHandler(this.add_Click);
            // 
            // query
            // 
            this.query.Name = "query";
            this.query.Size = new System.Drawing.Size(44, 21);
            this.query.Text = "查询";
            this.query.Click += new System.EventHandler(this.query_Click);
            // 
            // aboutMenuItem
            // 
            this.aboutMenuItem.Name = "aboutMenuItem";
            this.aboutMenuItem.Size = new System.Drawing.Size(55, 21);
            this.aboutMenuItem.Text = "Abuot";
            this.aboutMenuItem.Click += new System.EventHandler(this.aboutMenuItem_Click);
            // 
            // statusBar
            // 
            this.statusBar.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.loginStatus,
            this.fengefu,
            this.cancelStatus});
            this.statusBar.Location = new System.Drawing.Point(0, 540);
            this.statusBar.Name = "statusBar";
            this.statusBar.Size = new System.Drawing.Size(784, 22);
            this.statusBar.TabIndex = 4;
            this.statusBar.Text = "statusStrip1";
            // 
            // loginStatus
            // 
            this.loginStatus.Name = "loginStatus";
            this.loginStatus.Size = new System.Drawing.Size(40, 17);
            this.loginStatus.Text = " 登录 ";
            this.loginStatus.Click += new System.EventHandler(this.loginStatus_Click);
            // 
            // fengefu
            // 
            this.fengefu.Name = "fengefu";
            this.fengefu.Size = new System.Drawing.Size(26, 17);
            this.fengefu.Text = " | | ";
            // 
            // cancelStatus
            // 
            this.cancelStatus.Name = "cancelStatus";
            this.cancelStatus.Size = new System.Drawing.Size(32, 17);
            this.cancelStatus.Text = "注销";
            this.cancelStatus.Click += new System.EventHandler(this.cancelStatus_Click);
            // 
            // ToolBar
            // 
            this.ToolBar.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.dontTouchMe});
            this.ToolBar.Location = new System.Drawing.Point(0, 25);
            this.ToolBar.Name = "ToolBar";
            this.ToolBar.Size = new System.Drawing.Size(784, 25);
            this.ToolBar.TabIndex = 8;
            this.ToolBar.Text = "toolStrip1";
            // 
            // dontTouchMe
            // 
            this.dontTouchMe.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.dontTouchMe.Image = ((System.Drawing.Image)(resources.GetObject("dontTouchMe.Image")));
            this.dontTouchMe.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.dontTouchMe.Name = "dontTouchMe";
            this.dontTouchMe.Size = new System.Drawing.Size(23, 22);
            this.dontTouchMe.Text = "别点我";
            this.dontTouchMe.Click += new System.EventHandler(this.dontTouchMe_Click);
            // 
            // MainWindow
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(784, 562);
            this.Controls.Add(this.ToolBar);
            this.Controls.Add(this.statusBar);
            this.Controls.Add(this.menuBar);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.IsMdiContainer = true;
            this.MainMenuStrip = this.menuBar;
            this.Name = "MainWindow";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "学生收支管理系统";
            this.Resize += new System.EventHandler(this.MainWindow_Resize);
            this.menuBar.ResumeLayout(false);
            this.menuBar.PerformLayout();
            this.statusBar.ResumeLayout(false);
            this.statusBar.PerformLayout();
            this.ToolBar.ResumeLayout(false);
            this.ToolBar.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuBar;
        private System.Windows.Forms.StatusStrip statusBar;
        private System.Windows.Forms.ToolStripStatusLabel loginStatus;
        private System.Windows.Forms.ToolStripStatusLabel fengefu;
        private System.Windows.Forms.ToolStripMenuItem aboutMenuItem;
        private System.Windows.Forms.ToolStripStatusLabel cancelStatus;
        private System.Windows.Forms.ToolStripMenuItem query;
        private System.Windows.Forms.ToolStrip ToolBar;
        private System.Windows.Forms.ToolStripMenuItem add;
        private System.Windows.Forms.ToolStripButton dontTouchMe;
    }
}