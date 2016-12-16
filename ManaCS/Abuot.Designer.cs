namespace ManaCS
{
    partial class Abuot
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Abuot));
            this.sysLabel = new System.Windows.Forms.Label();
            this.sysLabel2 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // sysLabel
            // 
            this.sysLabel.Font = new System.Drawing.Font("宋体", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.sysLabel.Location = new System.Drawing.Point(228, 21);
            this.sysLabel.Name = "sysLabel";
            this.sysLabel.Size = new System.Drawing.Size(96, 82);
            this.sysLabel.TabIndex = 0;
            this.sysLabel.Text = "学生收支管理系统V1.0";
            // 
            // sysLabel2
            // 
            this.sysLabel2.Font = new System.Drawing.Font("宋体", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.sysLabel2.Location = new System.Drawing.Point(219, 139);
            this.sysLabel2.Name = "sysLabel2";
            this.sysLabel2.Size = new System.Drawing.Size(105, 21);
            this.sysLabel2.TabIndex = 1;
            this.sysLabel2.Text = "作者：郭健伟";
            // 
            // Abuot
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(337, 282);
            this.Controls.Add(this.sysLabel2);
            this.Controls.Add(this.sysLabel);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Abuot";
            this.StartPosition = System.Windows.Forms.FormStartPosition.Manual;
            this.Text = "Abuot";
            this.Paint += new System.Windows.Forms.PaintEventHandler(this.Abuot_Paint);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Label sysLabel;
        private System.Windows.Forms.Label sysLabel2;
    }
}