using socialmedia_desktop_client.objects;
using socialmedia_desktop_client.service;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace socialmedia_desktop_client
{
    public partial class Form1 : Form
    {
        private PostService postService = new PostService();
        private CommentService commentService = new CommentService();
        private UserService userService = new UserService();
        private List<UserDto> users = new List<UserDto>();
        private List<PostDto> postList = new List<PostDto>();
        private List<CommentDto> commentList = new List<CommentDto>();
        private List<PostDto> pendingPostList = new List<PostDto>();
        public Form1()
        {
            InitializeComponent();
        }

        private void menuStrip1_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private async void Form1_Load(object sender, EventArgs e)
        {
            this.postList = await postService.getAllPublishedPosts();
            publishedPostsList.Items.Clear();
            foreach (PostDto post in postList)
            {
                var item = new ListViewItem(post.id.ToString());
                item.SubItems.Add(post.title);
                item.SubItems.Add(post.content);
                item.SubItems.Add(post.userName);
                publishedPostsList.Items.Add(item);
            }
            this.commentList = await commentService.getAllComments();
            commentsList.Items.Clear();
            foreach (CommentDto comment in commentList)
            {
                var item = new ListViewItem(comment.Id.ToString());
                item.SubItems.Add(comment.PostTitle);
                item.SubItems.Add(comment.Content);
                item.SubItems.Add(comment.UserName);
                commentsList.Items.Add(item);
            }
        }

        private async void FindButton_Click(object sender, EventArgs e)
        {
            string keyword = keywordInput.Text;
            if (!string.IsNullOrEmpty(keyword))
            {
                this.postList = null;
                this.commentList = null;
                this.postList = await postService.getPostsWithKeyword(keyword);
                this.commentList = await commentService.getCommentsWithKeyword(keyword);
                commentsList.Items.Clear();
                publishedPostsList.Items.Clear();
                foreach (CommentDto comment in this.commentList)
                {
                    var item = new ListViewItem(comment.Id.ToString());
                    item.SubItems.Add(comment.PostTitle);
                    item.SubItems.Add(comment.Content);
                    item.SubItems.Add(comment.UserName);
                    commentsList.Items.Add(item);
                }
                foreach (PostDto post in this.postList)
                {
                    var item = new ListViewItem(post.id.ToString());
                    item.SubItems.Add(post.title);
                    item.SubItems.Add(post.content);
                    item.SubItems.Add(post.userName);
                    publishedPostsList.Items.Add(item);
                }
            }
        }

        private async void findAll_Click(object sender, EventArgs e)
        {
            this.postList = null;
            this.commentList = null;
            this.postList = await postService.getAllPublishedPosts();
            publishedPostsList.Items.Clear();
            foreach (PostDto post in postList)
            {
                var item = new ListViewItem(post.id.ToString());
                item.SubItems.Add(post.title);
                item.SubItems.Add(post.content);
                item.SubItems.Add(post.userName);
                publishedPostsList.Items.Add(item);
            }
            this.commentList = await commentService.getAllComments();
            commentsList.Items.Clear();
            foreach (CommentDto comment in commentList)
            {
                var item = new ListViewItem(comment.Id.ToString());
                item.SubItems.Add(comment.PostTitle);
                item.SubItems.Add(comment.Content);
                item.SubItems.Add(comment.UserName);
                commentsList.Items.Add(item);
            }
        }

        private async void button3_Click(object sender, EventArgs e)
        {
            foreach(ListViewItem item in publishedPostsList.Items)
            {
                if (item.Checked)
                {
                    postService.deletePostById(item.SubItems[0].Text);
                }
            }
            foreach(ListViewItem item in commentsList.Items)
            {
                if (item.Checked)
                {
                    commentService.deleteCommentById(item.SubItems[0].Text);
                }
            }

            this.postList = null;
            this.commentList = null;
            this.postList = await postService.getAllPublishedPosts();
            publishedPostsList.Items.Clear();
            foreach (PostDto post in postList)
            {
                var item = new ListViewItem(post.id.ToString());
                item.SubItems.Add(post.title);
                item.SubItems.Add(post.content);
                item.SubItems.Add(post.userName);
                publishedPostsList.Items.Add(item);
            }
            this.commentList = await commentService.getAllComments();
            commentsList.Items.Clear();
            foreach (CommentDto comment in commentList)
            {
                var item = new ListViewItem(comment.Id.ToString());
                item.SubItems.Add(comment.PostTitle);
                item.SubItems.Add(comment.Content);
                item.SubItems.Add(comment.UserName);
                commentsList.Items.Add(item);
            }
        }

        private void tabPage2_Click(object sender, EventArgs e)
        {

        }

        private async void button1_Click(object sender, EventArgs e)
        {
            this.pendingPostList = await postService.getAllPendingPosts();
            pendingList.Items.Clear();
            foreach (PostDto post in pendingPostList)
            {
                var item = new ListViewItem(post.id.ToString());
                item.SubItems.Add(post.title);
                item.SubItems.Add(post.content);
                item.SubItems.Add(post.userName);
                pendingList.Items.Add(item);
            }
        }

        private async void button5_Click(object sender, EventArgs e)
        {
            foreach (ListViewItem item in pendingList.Items)
            {
                if (item.Checked)
                {
                    postService.deletePostById(item.SubItems[0].Text);
                }
            }
            this.pendingPostList = await postService.getAllPendingPosts();
            pendingList.Items.Clear();
            foreach (PostDto post in pendingPostList)
            {
                var item = new ListViewItem(post.id.ToString());
                item.SubItems.Add(post.title);
                item.SubItems.Add(post.content);
                item.SubItems.Add(post.userName);
                pendingList.Items.Add(item);
            }
        }

        private async void button4_Click(object sender, EventArgs e)
        {
            foreach (ListViewItem item in pendingList.Items)
            {
                if (item.Checked)
                {
                    postService.approvePost(item.SubItems[0].Text);
                }
            }
            this.pendingPostList = await postService.getAllPendingPosts();
            pendingList.Items.Clear();
            foreach (PostDto post in pendingPostList)
            {
                var item = new ListViewItem(post.id.ToString());
                item.SubItems.Add(post.title);
                item.SubItems.Add(post.content);
                item.SubItems.Add(post.userName);
                pendingList.Items.Add(item);
            }
        }

        private async void button6_Click(object sender, EventArgs e)
        {
            userList.Items.Clear();
            this.users = await userService.getAllUsers();
            foreach (UserDto user in users)
            {
                var item = new ListViewItem(user.id.ToString());
                item.SubItems.Add(user.name);
                item.SubItems.Add(user.email);
                userList.Items.Add(item);
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            foreach (ListViewItem item in userList.Items)
            {
                if (item.Checked)
                {
                    string subject = SubjectInput.Text;
                    string content = ContentInput.Text;
                    if (!string.IsNullOrEmpty(subject) && !string.IsNullOrEmpty(content))
                    {
                        string to = item.SubItems[2].Text;
                        userService.sendMail(to, subject, content);
                    }
                    item.Checked = false;
                }
            }
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
