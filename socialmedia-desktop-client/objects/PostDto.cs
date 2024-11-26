using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace socialmedia_desktop_client.objects
{
    internal class PostDto
    {

        public long id {  get; set; }
        public string title { get; set; }
        public string content { get; set; }
        public string status {  get; set; }
        public string userName {  get; set; }
        public long userId { get; set; }


        public PostDto() { }

        public PostDto(long id, string title, string content, string status, string userName, long userId)
        {
            this.id = id;
            this.title = title;
            this.content = content;
            this.status = status;
            this.userName = userName;
            this.userId = userId;
        }
    }
}
