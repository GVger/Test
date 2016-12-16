namespace ManaCS
{
    partial class ModifyPswWindow
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(ModifyPswWindow));
            this.PswLabel = new System.Windows.Forms.Label();
            this.ConfirmPsw = new System.Windows.Forms.Label();
            this.PswTextBox = new System.Windows.Forms.TextBox();
            this.ConfirmPswTextBox = new System.Windows.Forms.TextBox();
            this.Btn_OK = new System.Windows.Forms.Button();
            this.Btn_Cancel = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // PswLabel
            // 
            this.PswLabel.AutoSize = true;
            this.PswLabel.Font = new System.Drawing.Font("宋体", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.PswLabel.Location = new System.Drawing.Point(12, 50);
            this.PswLabel.Name = "PswLabel";
            this.PswLabel.Size = new System.Drawing.Size(91, 19);
            this.PswLabel.TabIndex = 0;
            this.PswLabel.Text = "密  码：";
            // 
            // ConfirmPsw
            // 
            this.ConfirmPsw.AutoSize = true;
            this.ConfirmPsw.Font = new System.Drawing.Font("宋体", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.ConfirmPsw.Location = new System.Drawing.Point(12, 111);
            this.ConfirmPsw.Name = "ConfirmPsw";
            this.ConfirmPsw.Size = new System.Drawing.Size(109, 19);
            this.ConfirmPsw.TabIndex = 1;
            this.ConfirmPsw.Text = "确认密码：";
            // 
            // PswTextBox
            // 
            this.PswTextBox.Font = new System.Drawing.Font("宋体", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.PswTextBox.Location = new System.Drawing.Point(158, 47);
            this.PswTextBox.Name = "PswTextBox";
            this.PswTextBox.PasswordChar = '●';
            this.PswTextBox.Size = new System.Drawing.Size(156, 29);
            this.PswTextBox.TabIndex = 2;
            // 
            // ConfirmPswTextBox
            // 
            this.ConfirmPswTextBox.Font = new System.Drawing.Font("宋体", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.ConfirmPswTextBox.Location = new System.Drawing.Point(158, 108);
            this.ConfirmPswTextBox.Name = "ConfirmPswTextBox";
            this.ConfirmPswTextBox.PasswordChar = '●';
            this.ConfirmPswTextBox.Size = new System.Drawing.Size(156, 29);
            this.ConfirmPswTextBox.TabIndex = 3;
            // 
            // Btn_OK
            // 
            this.Btn_OK.Font = new System.Drawing.Font("黑体", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Btn_OK.Location = new System.Drawing.Point(29, 178);
            this.Btn_OK.Name = "Btn_OK";
            this.Btn_OK.Size = new System.Drawing.Size(110, 44);
            this.Btn_OK.TabIndex = 4;
            this.Btn_OK.Text = "确定";
            this.Btn_OK.UseVisualStyleBackColor = true;
            this.Btn_OK.Click += new System.EventHandler(this.Btn_OK_Click);
            // 
            // Btn_Cancel
            // 
            this.Btn_Cancel.Font = new System.Drawing.Font("黑体", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Btn_Cancel.Location = new System.Drawing.Point(244, 178);
            this.Btn_Cancel.Name = "Btn_Cancel";
            this.Btn_Cancel.Size = new System.Drawing.Size(110, 44);
            this.Btn_Cancel.TabIndex = 5;
            this.Btn_Cancel.Text = "取消";
            this.Btn_Cancel.UseVisualStyleBackColor = true;
            this.Btn_Cancel.Click += new System.EventHandler(this.Btn_Cancel_Click);
            // 
            // ModifyPswWindow
            // 
            this.AcceptButton = this.Btn_OK;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(401, 254);
            this.Controls.Add(this.Btn_Cancel);
            this.Controls.Add(this.Btn_OK);
            this.Controls.Add(this.ConfirmPswTextBox);
            this.Controls.Add(this.PswTextBox);
            this.Controls.Add(this.ConfirmPsw);
            this.Controls.Add(this.PswLabel);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.Name = "ModifyPswWindow";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "修改密码";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label PswLabel;
        private System.Windows.Forms.Label ConfirmPsw;
        private System.Windows.Forms.TextBox PswTextBox;
        private System.Windows.Forms.TextBox ConfirmPswTextBox;
        private System.Windows.Forms.Button Btn_OK;
        private System.Windows.Forms.Button Btn_Cancel;
    }
}