namespace socialmedia_desktop_client
{
    partial class Form1
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
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.findAll = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.commentsList = new System.Windows.Forms.ListView();
            this.columnHeader10 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader1 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader2 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader3 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.publishedPostsList = new System.Windows.Forms.ListView();
            this.Id = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Title = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Content = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Author = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.FindButton = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.keywordInput = new System.Windows.Forms.TextBox();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.button5 = new System.Windows.Forms.Button();
            this.button4 = new System.Windows.Forms.Button();
            this.label6 = new System.Windows.Forms.Label();
            this.pendingList = new System.Windows.Forms.ListView();
            this.columnHeader7 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader8 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader9 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.tabPage3 = new System.Windows.Forms.TabPage();
            this.button2 = new System.Windows.Forms.Button();
            this.label5 = new System.Windows.Forms.Label();
            this.ContentInput = new System.Windows.Forms.RichTextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.userList = new System.Windows.Forms.ListView();
            this.columnHeader6 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader4 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader5 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.SubjectInput = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.columnHeader11 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.button6 = new System.Windows.Forms.Button();
            this.tabControl1.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.tabPage2.SuspendLayout();
            this.tabPage3.SuspendLayout();
            this.SuspendLayout();
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tabPage1);
            this.tabControl1.Controls.Add(this.tabPage2);
            this.tabControl1.Controls.Add(this.tabPage3);
            this.tabControl1.Location = new System.Drawing.Point(2, 0);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(811, 548);
            this.tabControl1.TabIndex = 0;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.findAll);
            this.tabPage1.Controls.Add(this.button3);
            this.tabPage1.Controls.Add(this.label3);
            this.tabPage1.Controls.Add(this.label2);
            this.tabPage1.Controls.Add(this.commentsList);
            this.tabPage1.Controls.Add(this.publishedPostsList);
            this.tabPage1.Controls.Add(this.FindButton);
            this.tabPage1.Controls.Add(this.label1);
            this.tabPage1.Controls.Add(this.keywordInput);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(803, 522);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "Search";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // findAll
            // 
            this.findAll.Location = new System.Drawing.Point(317, 57);
            this.findAll.Name = "findAll";
            this.findAll.Size = new System.Drawing.Size(75, 23);
            this.findAll.TabIndex = 8;
            this.findAll.Text = "Find All";
            this.findAll.UseVisualStyleBackColor = true;
            this.findAll.Click += new System.EventHandler(this.findAll_Click);
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(647, 25);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(127, 30);
            this.button3.TabIndex = 7;
            this.button3.Text = "Delete selected";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(398, 91);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(56, 13);
            this.label3.TabIndex = 6;
            this.label3.Text = "Comments";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(19, 92);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(82, 13);
            this.label2.TabIndex = 5;
            this.label2.Text = "Published Posts";
            this.label2.Click += new System.EventHandler(this.label2_Click);
            // 
            // commentsList
            // 
            this.commentsList.CheckBoxes = true;
            this.commentsList.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader10,
            this.columnHeader1,
            this.columnHeader2,
            this.columnHeader3});
            this.commentsList.HideSelection = false;
            this.commentsList.Location = new System.Drawing.Point(398, 111);
            this.commentsList.Name = "commentsList";
            this.commentsList.Size = new System.Drawing.Size(376, 384);
            this.commentsList.TabIndex = 4;
            this.commentsList.UseCompatibleStateImageBehavior = false;
            this.commentsList.View = System.Windows.Forms.View.Details;
            // 
            // columnHeader10
            // 
            this.columnHeader10.Text = "Comment ID";
            // 
            // columnHeader1
            // 
            this.columnHeader1.Text = "Post Title";
            this.columnHeader1.Width = 100;
            // 
            // columnHeader2
            // 
            this.columnHeader2.Text = "Comment content";
            this.columnHeader2.Width = 180;
            // 
            // columnHeader3
            // 
            this.columnHeader3.Text = "Comment Author";
            this.columnHeader3.Width = 100;
            // 
            // publishedPostsList
            // 
            this.publishedPostsList.CheckBoxes = true;
            this.publishedPostsList.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.Id,
            this.Title,
            this.Content,
            this.Author});
            this.publishedPostsList.HideSelection = false;
            this.publishedPostsList.Location = new System.Drawing.Point(19, 111);
            this.publishedPostsList.Name = "publishedPostsList";
            this.publishedPostsList.Size = new System.Drawing.Size(360, 384);
            this.publishedPostsList.TabIndex = 3;
            this.publishedPostsList.UseCompatibleStateImageBehavior = false;
            this.publishedPostsList.View = System.Windows.Forms.View.Details;
            this.publishedPostsList.SelectedIndexChanged += new System.EventHandler(this.listView1_SelectedIndexChanged);
            // 
            // Id
            // 
            this.Id.Text = "Post Id";
            // 
            // Title
            // 
            this.Title.Text = "Title";
            this.Title.Width = 94;
            // 
            // Content
            // 
            this.Content.Text = "Content";
            this.Content.Width = 150;
            // 
            // Author
            // 
            this.Author.Text = "Author";
            this.Author.Width = 90;
            // 
            // FindButton
            // 
            this.FindButton.Location = new System.Drawing.Point(317, 28);
            this.FindButton.Name = "FindButton";
            this.FindButton.Size = new System.Drawing.Size(75, 23);
            this.FindButton.TabIndex = 2;
            this.FindButton.Text = "Find";
            this.FindButton.UseVisualStyleBackColor = true;
            this.FindButton.Click += new System.EventHandler(this.FindButton_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(19, 15);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(60, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Search Bar";
            // 
            // keywordInput
            // 
            this.keywordInput.Location = new System.Drawing.Point(19, 31);
            this.keywordInput.Name = "keywordInput";
            this.keywordInput.Size = new System.Drawing.Size(292, 20);
            this.keywordInput.TabIndex = 0;
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.button1);
            this.tabPage2.Controls.Add(this.button5);
            this.tabPage2.Controls.Add(this.button4);
            this.tabPage2.Controls.Add(this.label6);
            this.tabPage2.Controls.Add(this.pendingList);
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(803, 522);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "Approve Posts";
            this.tabPage2.UseVisualStyleBackColor = true;
            this.tabPage2.Click += new System.EventHandler(this.tabPage2_Click);
            // 
            // button5
            // 
            this.button5.Location = new System.Drawing.Point(295, 6);
            this.button5.Name = "button5";
            this.button5.Size = new System.Drawing.Size(241, 102);
            this.button5.TabIndex = 8;
            this.button5.Text = "Delete Selected";
            this.button5.UseVisualStyleBackColor = true;
            this.button5.Click += new System.EventHandler(this.button5_Click);
            // 
            // button4
            // 
            this.button4.Location = new System.Drawing.Point(9, 6);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(248, 102);
            this.button4.TabIndex = 7;
            this.button4.Text = "Approve Selected";
            this.button4.UseVisualStyleBackColor = true;
            this.button4.Click += new System.EventHandler(this.button4_Click);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(6, 111);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(75, 13);
            this.label6.TabIndex = 6;
            this.label6.Text = "Pending Posts";
            // 
            // pendingList
            // 
            this.pendingList.CheckBoxes = true;
            this.pendingList.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader11,
            this.columnHeader7,
            this.columnHeader8,
            this.columnHeader9});
            this.pendingList.HideSelection = false;
            this.pendingList.Location = new System.Drawing.Point(6, 127);
            this.pendingList.Name = "pendingList";
            this.pendingList.Size = new System.Drawing.Size(786, 384);
            this.pendingList.TabIndex = 4;
            this.pendingList.UseCompatibleStateImageBehavior = false;
            this.pendingList.View = System.Windows.Forms.View.Details;
            // 
            // columnHeader7
            // 
            this.columnHeader7.Text = "Title";
            this.columnHeader7.Width = 200;
            // 
            // columnHeader8
            // 
            this.columnHeader8.Text = "Content";
            this.columnHeader8.Width = 390;
            // 
            // columnHeader9
            // 
            this.columnHeader9.Text = "Author";
            this.columnHeader9.Width = 200;
            // 
            // tabPage3
            // 
            this.tabPage3.Controls.Add(this.button6);
            this.tabPage3.Controls.Add(this.button2);
            this.tabPage3.Controls.Add(this.label5);
            this.tabPage3.Controls.Add(this.ContentInput);
            this.tabPage3.Controls.Add(this.label4);
            this.tabPage3.Controls.Add(this.userList);
            this.tabPage3.Controls.Add(this.SubjectInput);
            this.tabPage3.Location = new System.Drawing.Point(4, 22);
            this.tabPage3.Name = "tabPage3";
            this.tabPage3.Size = new System.Drawing.Size(803, 522);
            this.tabPage3.TabIndex = 2;
            this.tabPage3.Text = "Send mail";
            this.tabPage3.UseVisualStyleBackColor = true;
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(181, 478);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(412, 33);
            this.button2.TabIndex = 5;
            this.button2.Text = "Send email to selected users";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(6, 301);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(71, 13);
            this.label5.TabIndex = 4;
            this.label5.Text = "Email content";
            // 
            // ContentInput
            // 
            this.ContentInput.Location = new System.Drawing.Point(6, 317);
            this.ContentInput.Name = "ContentInput";
            this.ContentInput.Size = new System.Drawing.Size(786, 146);
            this.ContentInput.TabIndex = 3;
            this.ContentInput.Text = "";
            this.ContentInput.TextChanged += new System.EventHandler(this.richTextBox1_TextChanged);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(6, 254);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(43, 13);
            this.label4.TabIndex = 2;
            this.label4.Text = "Subject";
            // 
            // userList
            // 
            this.userList.CheckBoxes = true;
            this.userList.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader6,
            this.columnHeader4,
            this.columnHeader5});
            this.userList.HideSelection = false;
            this.userList.Location = new System.Drawing.Point(6, 3);
            this.userList.Name = "userList";
            this.userList.Size = new System.Drawing.Size(786, 239);
            this.userList.TabIndex = 1;
            this.userList.UseCompatibleStateImageBehavior = false;
            this.userList.View = System.Windows.Forms.View.Details;
            // 
            // columnHeader6
            // 
            this.columnHeader6.Text = "User ID";
            this.columnHeader6.Width = 100;
            // 
            // columnHeader4
            // 
            this.columnHeader4.Text = "User Name";
            this.columnHeader4.Width = 350;
            // 
            // columnHeader5
            // 
            this.columnHeader5.Text = "User Email";
            this.columnHeader5.Width = 350;
            // 
            // SubjectInput
            // 
            this.SubjectInput.Location = new System.Drawing.Point(6, 270);
            this.SubjectInput.Name = "SubjectInput";
            this.SubjectInput.Size = new System.Drawing.Size(284, 20);
            this.SubjectInput.TabIndex = 0;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(583, 6);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(209, 102);
            this.button1.TabIndex = 9;
            this.button1.Text = "Refresh List";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // columnHeader11
            // 
            this.columnHeader11.Text = "Id";
            // 
            // button6
            // 
            this.button6.Location = new System.Drawing.Point(646, 248);
            this.button6.Name = "button6";
            this.button6.Size = new System.Drawing.Size(146, 33);
            this.button6.TabIndex = 6;
            this.button6.Text = "Refresh List";
            this.button6.UseVisualStyleBackColor = true;
            this.button6.Click += new System.EventHandler(this.button6_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(810, 545);
            this.Controls.Add(this.tabControl1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.Name = "Form1";
            this.Text = "Admin Tools";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.tabControl1.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage1.PerformLayout();
            this.tabPage2.ResumeLayout(false);
            this.tabPage2.PerformLayout();
            this.tabPage3.ResumeLayout(false);
            this.tabPage3.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.TabPage tabPage3;
        private System.Windows.Forms.ListView publishedPostsList;
        private System.Windows.Forms.Button FindButton;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox keywordInput;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ListView commentsList;
        private System.Windows.Forms.ColumnHeader Title;
        private System.Windows.Forms.ColumnHeader Content;
        private System.Windows.Forms.ColumnHeader Author;
        private System.Windows.Forms.ColumnHeader columnHeader1;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.ColumnHeader columnHeader3;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.RichTextBox ContentInput;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.ListView userList;
        private System.Windows.Forms.TextBox SubjectInput;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.ColumnHeader columnHeader6;
        private System.Windows.Forms.ColumnHeader columnHeader4;
        private System.Windows.Forms.ColumnHeader columnHeader5;
        private System.Windows.Forms.Button button4;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.ListView pendingList;
        private System.Windows.Forms.ColumnHeader columnHeader7;
        private System.Windows.Forms.ColumnHeader columnHeader8;
        private System.Windows.Forms.ColumnHeader columnHeader9;
        private System.Windows.Forms.ColumnHeader columnHeader10;
        private System.Windows.Forms.ColumnHeader Id;
        private System.Windows.Forms.Button button5;
        private System.Windows.Forms.Button findAll;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.ColumnHeader columnHeader11;
        private System.Windows.Forms.Button button6;
    }
}

