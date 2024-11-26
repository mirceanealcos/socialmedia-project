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
    internal class PostService
    {
        private string postBaseURL = "http://localhost:8080/posts";
        private HttpClient httpClient = new HttpClient();


        public async Task<List<PostDto>> getAllPublishedPosts()
        {
            HttpResponseMessage response = await httpClient.GetAsync(postBaseURL + "/published");
            response.EnsureSuccessStatusCode();

            string json = await response.Content.ReadAsStringAsync();

            Console.WriteLine(JsonConvert.DeserializeObject<List<PostDto>>(json));

            return JsonConvert.DeserializeObject<List<PostDto>>(json);
        }

        public async Task<List<PostDto>> getAllPendingPosts()
        {
            HttpResponseMessage response = await httpClient.GetAsync(postBaseURL + "/pending");
            response.EnsureSuccessStatusCode();

            string json = await response.Content.ReadAsStringAsync();

            Console.WriteLine(JsonConvert.DeserializeObject<List<PostDto>>(json));

            return JsonConvert.DeserializeObject<List<PostDto>>(json);
        }

        public async Task<List<PostDto>> getPostsWithKeyword(string keyword)
        {
            HttpResponseMessage response = await httpClient.GetAsync(postBaseURL + "/params?keyword=" + keyword);
            response.EnsureSuccessStatusCode();

            string json = await response.Content.ReadAsStringAsync();

            Console.WriteLine(JsonConvert.DeserializeObject<List<PostDto>>(json));

            return JsonConvert.DeserializeObject<List<PostDto>>(json);
        }

        public async void deletePostById(string id)
        {
            HttpResponseMessage response = await httpClient.DeleteAsync(postBaseURL + "/" + id);
            response.EnsureSuccessStatusCode();
        }

        public async void approvePost(string id)
        {
            HttpResponseMessage response = await httpClient.PutAsync(postBaseURL + "/approve/" + id, null);
            response.EnsureSuccessStatusCode();
        }
    }
}
