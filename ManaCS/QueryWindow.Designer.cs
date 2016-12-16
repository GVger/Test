namespace ManaCS
{
    partial class QueryWindow
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(QueryWindow));
            this.Btn_Query = new System.Windows.Forms.Button();
            this.tabCtrl = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.dateInView = new System.Windows.Forms.DataGridView();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.dateOutView = new System.Windows.Forms.DataGridView();
            this.Btn_Expor = new System.Windows.Forms.Button();
            this.tabCtrl.SuspendLayout();
            this.tabPage1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dateInView)).BeginInit();
            this.tabPage2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dateOutView)).BeginInit();
            this.SuspendLayout();
            // 
            // Btn_Query
            // 
            this.Btn_Query.Font = new System.Drawing.Font("黑体", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Btn_Query.Location = new System.Drawing.Point(169, 12);
            this.Btn_Query.Name = "Btn_Query";
            this.Btn_Query.Size = new System.Drawing.Size(83, 40);
            this.Btn_Query.TabIndex = 4;
            this.Btn_Query.Text = "查询";
            this.Btn_Query.UseVisualStyleBackColor = true;
            this.Btn_Query.Click += new System.EventHandler(this.Btn_Query_Click);
            // 
            // tabCtrl
            // 
            this.tabCtrl.Controls.Add(this.tabPage1);
            this.tabCtrl.Controls.Add(this.tabPage2);
            this.tabCtrl.Location = new System.Drawing.Point(10, 72);
            this.tabCtrl.Name = "tabCtrl";
            this.tabCtrl.SelectedIndex = 0;
            this.tabCtrl.Size = new System.Drawing.Size(443, 296);
            this.tabCtrl.TabIndex = 5;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.dateInView);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(435, 270);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "收入";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // dateInView
            // 
            this.dateInView.AllowUserToAddRows = false;
            this.dateInView.AllowUserToDeleteRows = false;
            this.dateInView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dateInView.Location = new System.Drawing.Point(1, 1);
            this.dateInView.Name = "dateInView";
            this.dateInView.ReadOnly = true;
            this.dateInView.RowTemplate.Height = 23;
            this.dateInView.Size = new System.Drawing.Size(433, 385);
            this.dateInView.TabIndex = 0;
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.dateOutView);
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(435, 270);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "支出";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // dateOutView
            // 
            this.dateOutView.AllowUserToAddRows = false;
            this.dateOutView.AllowUserToDeleteRows = false;
            this.dateOutView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dateOutView.Location = new System.Drawing.Point(0, 0);
            this.dateOutView.Name = "dateOutView";
            this.dateOutView.ReadOnly = true;
            this.dateOutView.RowTemplate.Height = 23;
            this.dateOutView.Size = new System.Drawing.Size(433, 385);
            this.dateOutView.TabIndex = 1;
            // 
            // Btn_Expor
            // 
            this.Btn_Expor.Font = new System.Drawing.Font("宋体", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Btn_Expor.Location = new System.Drawing.Point(155, 374);
            this.Btn_Expor.Name = "Btn_Expor";
            this.Btn_Expor.Size = new System.Drawing.Size(136, 39);
            this.Btn_Expor.TabIndex = 6;
            this.Btn_Expor.Text = "导出";
            this.Btn_Expor.UseVisualStyleBackColor = true;
            this.Btn_Expor.Click += new System.EventHandler(this.Btn_Expor_Click);
            // 
            // QueryWindow
            // 
            this.AcceptButton = this.Btn_Query;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(470, 417);
            this.Controls.Add(this.Btn_Expor);
            this.Controls.Add(this.tabCtrl);
            this.Controls.Add(this.Btn_Query);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.Name = "QueryWindow";
            this.Text = "查询";
            this.tabCtrl.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dateInView)).EndInit();
            this.tabPage2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dateOutView)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button Btn_Query;
        private System.Windows.Forms.TabControl tabCtrl;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.DataGridView dateInView;
        private System.Windows.Forms.DataGridView dateOutView;
        private System.Windows.Forms.Button Btn_Expor;
    }
}