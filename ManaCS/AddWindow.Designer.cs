namespace ManaCS
{
    partial class AddWindow
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(AddWindow));
            this.dateTime = new System.Windows.Forms.DateTimePicker();
            this.NewIn = new System.Windows.Forms.RadioButton();
            this.NewOut = new System.Windows.Forms.RadioButton();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.label1 = new System.Windows.Forms.Label();
            this.moneyTextBox = new System.Windows.Forms.TextBox();
            this.Btn_OK = new System.Windows.Forms.Button();
            this.Btn_Cancel = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // dateTime
            // 
            this.dateTime.Font = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.dateTime.Location = new System.Drawing.Point(139, 21);
            this.dateTime.MaxDate = new System.DateTime(3000, 12, 31, 0, 0, 0, 0);
            this.dateTime.MinDate = new System.DateTime(2000, 1, 1, 0, 0, 0, 0);
            this.dateTime.Name = "dateTime";
            this.dateTime.Size = new System.Drawing.Size(164, 23);
            this.dateTime.TabIndex = 0;
            this.dateTime.Value = new System.DateTime(2016, 10, 1, 0, 0, 0, 0);
            // 
            // NewIn
            // 
            this.NewIn.AutoSize = true;
            this.NewIn.Checked = true;
            this.NewIn.Location = new System.Drawing.Point(22, 20);
            this.NewIn.Name = "NewIn";
            this.NewIn.Size = new System.Drawing.Size(55, 18);
            this.NewIn.TabIndex = 1;
            this.NewIn.TabStop = true;
            this.NewIn.Text = "收入";
            this.NewIn.UseVisualStyleBackColor = true;
            // 
            // NewOut
            // 
            this.NewOut.AutoSize = true;
            this.NewOut.Location = new System.Drawing.Point(119, 20);
            this.NewOut.Name = "NewOut";
            this.NewOut.Size = new System.Drawing.Size(55, 18);
            this.NewOut.TabIndex = 2;
            this.NewOut.Text = "支出";
            this.NewOut.UseVisualStyleBackColor = true;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.NewOut);
            this.groupBox1.Controls.Add(this.NewIn);
            this.groupBox1.Font = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.groupBox1.Location = new System.Drawing.Point(129, 74);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(193, 44);
            this.groupBox1.TabIndex = 3;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "添加的类型";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("宋体", 21.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label1.Location = new System.Drawing.Point(23, 167);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(103, 29);
            this.label1.TabIndex = 4;
            this.label1.Text = "金额：";
            // 
            // moneyTextBox
            // 
            this.moneyTextBox.Font = new System.Drawing.Font("宋体", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.moneyTextBox.Location = new System.Drawing.Point(112, 164);
            this.moneyTextBox.Name = "moneyTextBox";
            this.moneyTextBox.Size = new System.Drawing.Size(269, 41);
            this.moneyTextBox.TabIndex = 5;
            // 
            // Btn_OK
            // 
            this.Btn_OK.Font = new System.Drawing.Font("黑体", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Btn_OK.Location = new System.Drawing.Point(48, 253);
            this.Btn_OK.Name = "Btn_OK";
            this.Btn_OK.Size = new System.Drawing.Size(103, 37);
            this.Btn_OK.TabIndex = 6;
            this.Btn_OK.Text = "确定";
            this.Btn_OK.UseVisualStyleBackColor = true;
            this.Btn_OK.Click += new System.EventHandler(this.Btn_OK_Click);
            // 
            // Btn_Cancel
            // 
            this.Btn_Cancel.Font = new System.Drawing.Font("黑体", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Btn_Cancel.Location = new System.Drawing.Point(308, 253);
            this.Btn_Cancel.Name = "Btn_Cancel";
            this.Btn_Cancel.Size = new System.Drawing.Size(103, 37);
            this.Btn_Cancel.TabIndex = 7;
            this.Btn_Cancel.Text = "取消";
            this.Btn_Cancel.UseVisualStyleBackColor = true;
            this.Btn_Cancel.Click += new System.EventHandler(this.Btn_Cancel_Click);
            // 
            // AddWindow
            // 
            this.AcceptButton = this.Btn_OK;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(447, 325);
            this.Controls.Add(this.Btn_Cancel);
            this.Controls.Add(this.Btn_OK);
            this.Controls.Add(this.moneyTextBox);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.dateTime);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.Name = "AddWindow";
            this.Text = "添加新记录";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DateTimePicker dateTime;
        private System.Windows.Forms.RadioButton NewIn;
        private System.Windows.Forms.RadioButton NewOut;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox moneyTextBox;
        private System.Windows.Forms.Button Btn_OK;
        private System.Windows.Forms.Button Btn_Cancel;

    }
}