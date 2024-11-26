using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace socialmedia_desktop_client.objects
{
    internal class MailDto
    {
        public string to {  get; set; }
        public string subject { get; set; }
        public string content { get; set; }

        public MailDto() { }

        public MailDto(string to, string subject, string content)
        {
            this.to = to;
            this.subject = subject;
            this.content = content;
        }
    }
}
