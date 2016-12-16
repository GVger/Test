using System.Drawing;
namespace ManaCS
{
    partial class RegisterWindow
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(RegisterWindow));
            this.UserNameLabel = new System.Windows.Forms.Label();
            this.PswLabel = new System.Windows.Forms.Label();
            this.ConfirmLabel = new System.Windows.Forms.Label();
            this.UserNameText = new System.Windows.Forms.TextBox();
            this.PswText = new System.Windows.Forms.TextBox();
            this.ConfirmPswText = new System.Windows.Forms.TextBox();
            this.Btn_OK = new System.Windows.Forms.Button();
            this.Btn_Cancel = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // UserNameLabel
            // 
            this.UserNameLabel.AutoSize = true;
            this.UserNameLabel.BackColor = System.Drawing.Color.Transparent;
            this.UserNameLabel.Font = new System.Drawing.Font("黑体", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.UserNameLabel.Location = new System.Drawing.Point(34, 56);
            this.UserNameLabel.Name = "UserNameLabel";
            this.UserNameLabel.Size = new System.Drawing.Size(110, 24);
            this.UserNameLabel.TabIndex = 0;
            this.UserNameLabel.Text = "用户名：";
            // 
            // PswLabel
            // 
            this.PswLabel.AutoSize = true;
            this.PswLabel.BackColor = System.Drawing.Color.Transparent;
            this.PswLabel.Font = new System.Drawing.Font("黑体", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.PswLabel.Location = new System.Drawing.Point(34, 133);
            this.PswLabel.Name = "PswLabel";
            this.PswLabel.Size = new System.Drawing.Size(111, 24);
            this.PswLabel.TabIndex = 1;
            this.PswLabel.Text = "密  码：";
            // 
            // ConfirmLabel
            // 
            this.ConfirmLabel.AutoSize = true;
            this.ConfirmLabel.BackColor = System.Drawing.Color.Transparent;
            this.ConfirmLabel.Font = new System.Drawing.Font("黑体", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.ConfirmLabel.Location = new System.Drawing.Point(34, 219);
            this.ConfirmLabel.Name = "ConfirmLabel";
            this.ConfirmLabel.Size = new System.Drawing.Size(135, 24);
            this.ConfirmLabel.TabIndex = 2;
            this.ConfirmLabel.Text = "确认密码：";
            // 
            // UserNameText
            // 
            this.UserNameText.Font = new System.Drawing.Font("宋体", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.UserNameText.Location = new System.Drawing.Point(173, 51);
            this.UserNameText.Name = "UserNameText";
            this.UserNameText.Size = new System.Drawing.Size(231, 29);
            this.UserNameText.TabIndex = 3;
            // 
            // PswText
            // 
            this.PswText.Font = new System.Drawing.Font("宋体", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.PswText.Location = new System.Drawing.Point(173, 128);
            this.PswText.Name = "PswText";
            this.PswText.PasswordChar = '●';
            this.PswText.Size = new System.Drawing.Size(231, 29);
            this.PswText.TabIndex = 4;
            // 
            // ConfirmPswText
            // 
            this.ConfirmPswText.Font = new System.Drawing.Font("宋体", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.ConfirmPswText.Location = new System.Drawing.Point(173, 214);
            this.ConfirmPswText.Name = "ConfirmPswText";
            this.ConfirmPswText.PasswordChar = '●';
            this.ConfirmPswText.Size = new System.Drawing.Size(231, 29);
            this.ConfirmPswText.TabIndex = 5;
            // 
            // Btn_OK
            // 
            this.Btn_OK.Font = new System.Drawing.Font("宋体", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Btn_OK.Location = new System.Drawing.Point(38, 296);
            this.Btn_OK.Name = "Btn_OK";
            this.Btn_OK.Size = new System.Drawing.Size(141, 54);
            this.Btn_OK.TabIndex = 6;
            this.Btn_OK.Text = "确认";
            this.Btn_OK.UseVisualStyleBackColor = true;
            this.Btn_OK.Click += new System.EventHandler(this.Btn_OK_Click);
            // 
            // Btn_Cancel
            // 
            this.Btn_Cancel.Font = new System.Drawing.Font("宋体", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Btn_Cancel.Location = new System.Drawing.Point(274, 296);
            this.Btn_Cancel.Name = "Btn_Cancel";
            this.Btn_Cancel.Size = new System.Drawing.Size(141, 54);
            this.Btn_Cancel.TabIndex = 7;
            this.Btn_Cancel.Text = "取消";
            this.Btn_Cancel.UseVisualStyleBackColor = true;
            this.Btn_Cancel.Click += new System.EventHandler(this.Btn_Cancel_Click);
            // 
            // RegisterWindow
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(461, 384);
            this.Controls.Add(this.Btn_Cancel);
            this.Controls.Add(this.Btn_OK);
            this.Controls.Add(this.ConfirmPswText);
            this.Controls.Add(this.PswText);
            this.Controls.Add(this.UserNameText);
            this.Controls.Add(this.ConfirmLabel);
            this.Controls.Add(this.PswLabel);
            this.Controls.Add(this.UserNameLabel);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.Name = "RegisterWindow";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "注册";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.RegisterWindow_FormClosing);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label UserNameLabel;
        private System.Windows.Forms.Label PswLabel;
        private System.Windows.Forms.Label ConfirmLabel;
        private System.Windows.Forms.TextBox UserNameText;
        private System.Windows.Forms.TextBox PswText;
        private System.Windows.Forms.TextBox ConfirmPswText;
        private System.Windows.Forms.Button Btn_OK;
        private System.Windows.Forms.Button Btn_Cancel;

    }
}