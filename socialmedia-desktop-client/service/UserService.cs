using Newtonsoft.Json;
using socialmedia_desktop_client.objects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace socialmedia_desktop_client.service
{
    internal class UserService
    {
        private string userBaseURL = "http://localhost:8080/users";
        private HttpClient httpClient = new HttpClient();

        public async Task<List<UserDto>> getAllUsers()
        {
            HttpResponseMessage response = await httpClient.GetAsync(userBaseURL);
            response.EnsureSuccessStatusCode();

            string json = await response.Content.ReadAsStringAsync();

            Console.WriteLine(JsonConvert.DeserializeObject<List<UserDto>>(json));

            return JsonConvert.DeserializeObject<List<UserDto>>(json);
        }

        public async void sendMail(string to, string subject, string content)
        {
            MailDto mailDto = new MailDto(to, subject, content);
            string json = JsonConvert.SerializeObject(mailDto);
            HttpContent body = new StringContent(json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await httpClient.PostAsync(userBaseURL + "/sendMail", body);
        }
    }

    
}
