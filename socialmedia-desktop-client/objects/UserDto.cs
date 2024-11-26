using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace socialmedia_desktop_client.objects
{
    internal class UserDto
    {
        public int id { get; set; }
        public string name { get; set; }
        public string email { get; set; }

        public UserDto() { }

        public UserDto(int id, string name, string email)
        {
            this.id = id;
            this.name = name;
            this.email = email;
        }
    }
}
