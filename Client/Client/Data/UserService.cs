using System;
using System.Net.Http;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data
{
    public class UserService : IUserService
    {
        private HttpClient client;
        private static SHA256 sha256Hash;
        
        public UserService()
        {
            sha256Hash = SHA256.Create();
            client = new HttpClient();
        }
        
        public async Task<User> GetUserAsync(string? username, string? password)
        {
            string uri = "http://localhost:6969/users/post";
            User userToCheck = new User();
            userToCheck.UserName = username;
            
            string hash = GetHash(password);
            Console.Out.WriteLine(hash + " < Hashed password " + password);

            userToCheck.Password = hash;
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
            string hash = GetHash(user.Password);
            Console.Out.WriteLine(hash + " Hashed password");

            user.Password = hash;

            string todoSerialized = JsonSerializer.Serialize(user);

            StringContent content = new StringContent(
                todoSerialized,
                Encoding.UTF8,
                "application/json"
            );
            Console.Out.WriteLine(todoSerialized);

            var response = await client.PostAsync("http://localhost:6969/users/create", content);
            string cont = await  response.Content.ReadAsStringAsync();
            if (cont.Equals(""))
            {
                throw new Exception("Username already used");
            }
        }
        
        private static string GetHash(string input)
        {

            // Convert the input string to a byte array and compute the hash.
            byte[] data = sha256Hash.ComputeHash(Encoding.UTF8.GetBytes(input));

            // Create a new Stringbuilder to collect the bytes
            // and create a string.
            var sBuilder = new StringBuilder();

            // Loop through each byte of the hashed data
            // and format each one as a hexadecimal string.
            for (int i = 0; i < data.Length; i++)
            {
                sBuilder.Append(data[i].ToString("x2"));
            }

            // Return the hexadecimal string.
            return sBuilder.ToString();
        }
    }
}