using System;
using System.Net.Http;
using System.Runtime.Serialization;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using AndriuhaAssignment.Models;

namespace AndriuhaAssignment.Data
{
    public class ApplicationService : IApplicationService
    {
        private HttpClient client;
        private string uri = "https://localhost:6969";
        public ApplicationService()
        {
            client = new HttpClient();
        }

        public Task<Application> GetApplicationAsync(Application application)
        {
            throw new System.NotImplementedException();
        }

        public async Task<Application> CreateApplicationAsync(Application application)
        {
            HttpResponseMessage response = await client.PostAsync("http://localhost:6969/users/create", content);
                Console.Out.WriteLine(response.ToString());
                
                string applicationAsJson = JsonSerializer.Serialize(application);
                HttpContent content = new StringContent(applicationAsJson,
                    Encoding.UTF8,
                    "application/json");
                await client.PostAsync(uri+"/Adult", content);
                Console.Out.WriteLine(response.ToString());

        }

        public Task<Application> RemoveApplicationAsync(ObjectIDGenerator applicationId)
        {
            throw new System.NotImplementedException();
        }

        public Task<Application> UpdateApplicationAsync(Application application)
        {
            throw new System.NotImplementedException();
        }
    }
}