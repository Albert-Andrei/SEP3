using System.Threading.Tasks;
using Client.Models;

namespace Client.Data
{
    public interface IUserService
    {
        Task<User> GetUserAsync(string? username, string? password);
        Task CreateUserAsync(User user);
    }
}