using System;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data
{
    public class UserService : IUserService
    {
        private HttpClient client;
        
        public UserService()
        {
            client = new HttpClient();
        }
        
        public async Task<User> GetUserAsync(string? username, string? password)
        {
            string uri = "http://localhost:6969/users/post";
            User userToCheck = new User();
            userToCheck.UserName = username;
            userToCheck.Password = password;
            string userSerialized = JsonSerializer.Serialize(userToCheck);
            Console.Out.WriteLine( userSerialized);
            
            StringContent content = new StringContent(
                userSerialized,
                Encoding.UTF8,
                "application/json"
            );
            
            Console.Out.WriteLine(uri);
            var response = await client.PostAsync(uri, content);
            Console.Out.WriteLine(response.ToString());
            string cont = await  response.Content.ReadAsStringAsync();
            Console.Out.WriteLine(cont);
            User userFromBd = JsonSerializer.Deserialize<User>(cont);
            return userFromBd; 
        }

        public async Task CreateUserAsync(User user)
        {
            string todoSerialized = JsonSerializer.Serialize(user);

            StringContent content = new StringContent(
                todoSerialized,
                Encoding.UTF8,
                "application/json"
            );
            Console.Out.WriteLine(todoSerialized);

            HttpResponseMessage response = await client.PostAsync("http://localhost:6969/users/create", content);
            Console.Out.WriteLine(response.ToString());
        }
    }
}