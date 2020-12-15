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
            string uri = "http://localhost:6969/shifts?";
            
            if (username != null)
            {
                uri += $"&username={username}";
            }
            
            // string message = await client.GetStringAsync($"http://localhost:6969/shifts/get?&username={username}");
            string message = await client.GetStringAsync(uri);
            Console.Out.WriteLine(message + "< result from getShift request");
            List<Shift> result = JsonSerializer.Deserialize<List<Shift>>(message);
            return result;
        }

        public async Task<IList<Shift>> GetAllShifts()
        {
            string uri = "http://localhost:6969/shifts/all";
            string message = await client.GetStringAsync(uri);
            Console.Out.WriteLine(message + "< result from getAllSfhits");
            List<Shift> result = JsonSerializer.Deserialize<List<Shift>>(message);
            return result;
        }

        public async Task<Shift> GetShiftById(string id)
        {
            string message = await client.GetStringAsync($"http://localhost:6969/shifts/one/{id}");
            Console.Out.WriteLine(message + "< result from getAllSfhits");
            Shift result = JsonSerializer.Deserialize<Shift>(message);
            return result;
        }

        public async Task AddShiftAsync(Shift shift)
        {
            string todoSerialized = JsonSerializer.Serialize(shift);

            Console.Out.WriteLine(todoSerialized + " < Shift to create");
            StringContent content = new StringContent(
                todoSerialized,
                Encoding.UTF8,
                "application/json"
            );
            Console.Out.WriteLine(todoSerialized);

            HttpResponseMessage response = await client.PostAsync("http://localhost:6969/shifts", content);
            Console.Out.WriteLine(response.ToString());
        }

        public async Task RemoveShiftAsync(string shiftId)
        {
            await client.DeleteAsync($"http://localhost:6969/shifts/{shiftId}");
        }

        public async Task ApplyToShiftAsync(string shiftId, string username)
        {
            await client.PutAsync($"http://localhost:6969/shifts/apply/{shiftId}/{username}", null);
        }

        public async Task ApproveAsync(string shiftId, string username)
        {
            await client.PutAsync($"http://localhost:6969/shifts/approve/{shiftId}/{username}", null);
        }

        public async Task RejectAsync(string shiftId, string username)
        {
            await client.PutAsync($"http://localhost:6969/shifts/reject/{shiftId}/{username}", null);
        }
    }
}