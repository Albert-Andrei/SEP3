using System.Threading.Tasks;
using AndriuhaAssignment.Models;

namespace AndriuhaAssignment.Data
{
    public interface IUserService
    {
        Task<User> GetUserAsync(string? username, string? password);
        Task CreateUserAsync(User user);
    }
}