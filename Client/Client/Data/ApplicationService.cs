using System;
using System.Collections.Generic;
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
        public ApplicationService()
        {
            client = new HttpClient();
        }

        public async Task<List<Application>> GetAllApplicationsAsync()
        {
            Task<string> stringAsync = client.GetStringAsync( $"http://localhost:6969/application/get/all");
            string message = await stringAsync;
            List<Application> result = JsonSerializer.Deserialize<List<Application>>(message);
            return result;
        }

        public async Task<Application> GetApplicationAsync(ObjectIDGenerator applicationId)
        {
            Task<string> stringAsync = client.GetStringAsync( $"http://localhost:6969/application/get/{applicationId}");
            string message = await stringAsync;
            Console.Out.WriteLine(message);
            Application result = JsonSerializer.Deserialize<Application>(message);
            Console.Write(result);
            return result; 
        }
   
        public async Task CreateApplicationAsync(Application application)
        {
            string applicationAsJson = JsonSerializer.Serialize(application);
                HttpContent content = new StringContent(applicationAsJson,
                    Encoding.UTF8,
                    "application/json");
                await client.PostAsync("http://localhost:6969/application/create", content);
        }

        public async Task<Application> RemoveApplicationAsync(ObjectIDGenerator applicationId)
        {
            throw new System.NotImplementedException();
        }

        public async Task<Application> UpdateApplicationAsync(Application application)
        {
            throw new System.NotImplementedException();
        }
    }
}