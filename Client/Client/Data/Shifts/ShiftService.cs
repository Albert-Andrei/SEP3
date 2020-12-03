using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data.Shifts
{
    public class ShiftService : IShiftService
    {
        
        private HttpClient client;
        
        public ShiftService()
        {
            client = new HttpClient();
        }
        
        public async Task<IList<Shift>> GetAllShiftsOneUser(string username)
        {
            string uri = "http://localhost:6969/users/post";
            string userSerialized = JsonSerializer.Serialize(username);
            Console.Out.WriteLine(username);
            
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
            IList<Shift> shiftsFromDB = JsonSerializer.Deserialize<IList<Shift>>(cont);
            return shiftsFromDB; 
        }

        public async Task AddShiftAsync(Shift shift)
        {
            string todoSerialized = JsonSerializer.Serialize(shift);

            StringContent content = new StringContent(
                todoSerialized,
                Encoding.UTF8,
                "application/json"
            );
            Console.Out.WriteLine(todoSerialized);

            HttpResponseMessage response = await client.PostAsync("http://localhost:6969/shifts/create", content);
            Console.Out.WriteLine(response.ToString());
        }

        public Task RemoveShiftAsync(int shiftId)
        {
            throw new System.NotImplementedException();
        }

        public Task UpdateShiftAsync(Shift shift)
        {
            throw new System.NotImplementedException();
        }
    }
}