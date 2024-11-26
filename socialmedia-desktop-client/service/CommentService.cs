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
    internal class CommentService
    {

        private string commentBaseURL = "http://localhost:8080/comments";
        private HttpClient httpClient = new HttpClient();


        public async Task<List<CommentDto>> getAllComments()
        {
            HttpResponseMessage response = await httpClient.GetAsync(commentBaseURL);
            response.EnsureSuccessStatusCode();

            string json = await response.Content.ReadAsStringAsync();

            Console.WriteLine(JsonConvert.DeserializeObject<List<CommentDto>>(json));

            return JsonConvert.DeserializeObject<List<CommentDto>>(json);
        }

        public async Task<List<CommentDto>> getCommentsWithKeyword(string keyword)
        {
            HttpResponseMessage response = await httpClient.GetAsync(commentBaseURL + "/params?keyword=" + keyword);
            response.EnsureSuccessStatusCode();

            string json = await response.Content.ReadAsStringAsync();

            Console.WriteLine(JsonConvert.DeserializeObject<List<CommentDto>>(json));

            return JsonConvert.DeserializeObject<List<CommentDto>>(json);
        }

        public async void deleteCommentById(string id)
        {
            HttpResponseMessage response = await httpClient.DeleteAsync(commentBaseURL + "/" + id);
            response.EnsureSuccessStatusCode();
        }

    }
}
