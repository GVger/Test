namespace ManaCS
{
    partial class LoginWindow
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(LoginWindow));
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.UserNameText = new System.Windows.Forms.TextBox();
            this.PassWordText = new System.Windows.Forms.TextBox();
            this.CheckCodeText = new System.Windows.Forms.TextBox();
            this.Login = new System.Windows.Forms.Button();
            this.Cancel = new System.Windows.Forms.Button();
            this.CodePicBox = new System.Windows.Forms.PictureBox();
            this.Register = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.CodePicBox)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("宋体", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label1.Location = new System.Drawing.Point(23, 40);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(94, 21);
            this.label1.TabIndex = 0;
            this.label1.Text = "用户名：";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("宋体", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label2.Location = new System.Drawing.Point(23, 77);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(95, 21);
            this.label2.TabIndex = 1;
            this.label2.Text = "密  码：";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("宋体", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label3.Location = new System.Drawing.Point(23, 122);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(84, 21);
            this.label3.TabIndex = 2;
            this.label3.Text = "验证码:";
            // 
            // UserNameText
            // 
            this.UserNameText.Font = new System.Drawing.Font("宋体", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.UserNameText.Location = new System.Drawing.Point(123, 32);
            this.UserNameText.Name = "UserNameText";
            this.UserNameText.Size = new System.Drawing.Size(174, 29);
            this.UserNameText.TabIndex = 3;
            // 
            // PassWordText
            // 
            this.PassWordText.Font = new System.Drawing.Font("宋体", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.PassWordText.Location = new System.Drawing.Point(123, 69);
            this.PassWordText.Name = "PassWordText";
            this.PassWordText.PasswordChar = '●';
            this.PassWordText.Size = new System.Drawing.Size(174, 29);
            this.PassWordText.TabIndex = 4;
            // 
            // CheckCodeText
            // 
            this.CheckCodeText.Font = new System.Drawing.Font("宋体", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.CheckCodeText.Location = new System.Drawing.Point(123, 114);
            this.CheckCodeText.Name = "CheckCodeText";
            this.CheckCodeText.Size = new System.Drawing.Size(174, 29);
            this.CheckCodeText.TabIndex = 5;
            // 
            // Login
            // 
            this.Login.Font = new System.Drawing.Font("宋体", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Login.Location = new System.Drawing.Point(185, 175);
            this.Login.Name = "Login";
            this.Login.Size = new System.Drawing.Size(101, 34);
            this.Login.TabIndex = 6;
            this.Login.Text = "登录";
            this.Login.UseVisualStyleBackColor = true;
            this.Login.Click += new System.EventHandler(this.Login_Click);
            // 
            // Cancel
            // 
            this.Cancel.Font = new System.Drawing.Font("宋体", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Cancel.Location = new System.Drawing.Point(336, 175);
            this.Cancel.Name = "Cancel";
            this.Cancel.Size = new System.Drawing.Size(101, 34);
            this.Cancel.TabIndex = 7;
            this.Cancel.Text = "取消";
            this.Cancel.UseVisualStyleBackColor = true;
            this.Cancel.Click += new System.EventHandler(this.Cancel_Click);
            // 
            // CodePicBox
            // 
            this.CodePicBox.Location = new System.Drawing.Point(318, 92);
            this.CodePicBox.Name = "CodePicBox";
            this.CodePicBox.Size = new System.Drawing.Size(119, 52);
            this.CodePicBox.TabIndex = 10;
            this.CodePicBox.TabStop = false;
            this.CodePicBox.Click += new System.EventHandler(this.codePicBox_Click);
            // 
            // Register
            // 
            this.Register.Font = new System.Drawing.Font("宋体", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Register.Location = new System.Drawing.Point(27, 175);
            this.Register.Name = "Register";
            this.Register.Size = new System.Drawing.Size(101, 34);
            this.Register.TabIndex = 11;
            this.Register.Text = "注册";
            this.Register.UseVisualStyleBackColor = true;
            this.Register.Click += new System.EventHandler(this.Register_Click);
            // 
            // LoginWindow
            // 
            this.AcceptButton = this.Login;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(476, 235);
            this.Controls.Add(this.Register);
            this.Controls.Add(this.CodePicBox);
            this.Controls.Add(this.Cancel);
            this.Controls.Add(this.Login);
            this.Controls.Add(this.CheckCodeText);
            this.Controls.Add(this.PassWordText);
            this.Controls.Add(this.UserNameText);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.Name = "LoginWindow";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "登录";
            ((System.ComponentModel.ISupportInitialize)(this.CodePicBox)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox UserNameText;
        private System.Windows.Forms.TextBox PassWordText;
        private System.Windows.Forms.TextBox CheckCodeText;
        private System.Windows.Forms.Button Login;
        private System.Windows.Forms.Button Cancel;
        private System.Windows.Forms.PictureBox CodePicBox;
        private System.Windows.Forms.Button Register;
    }
}

