using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Runtime.Serialization;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Client.Models;
using Microsoft.AspNetCore.Components;

namespace Client.Data
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
            string uri = "http://localhost:6969/application/all";
            string message = await client.GetStringAsync(uri);
            Console.Out.WriteLine(message + "< result from getAllApplications");
            List<Application> result = JsonSerializer.Deserialize<List<Application>>(message);
            return result;
        }

        public async Task<Application> GetApplicationAsync(string applicationId)
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
        
        public async Task UpdateApplicationAsync(Application application)
        {
            string applicationAsJson = JsonSerializer.Serialize(application);
            HttpContent content = new StringContent(applicationAsJson,
                Encoding.UTF8,
                "application/json");
            await client.PutAsync($"http://localhost:6969/application/update/{application.User}", content);
        }

        public async Task<Application> GetMyApplicationAsync(string user)
        {
            Task<string> stringAsync =
                    client.GetStringAsync($"http://localhost:6969/application/get-by-user/{user}");
                string message = await stringAsync;
                Console.Out.WriteLine("result" + message);
                Application result = JsonSerializer.Deserialize<Application>(message);
                return result;
            
        }
        
    }
}