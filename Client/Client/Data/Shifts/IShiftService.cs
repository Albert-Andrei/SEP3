using System.Collections.Generic;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data.Shifts
{
    public interface IShiftService
    {
        Task<IList<Shift>> GetAllShiftsOneUser(string username);
        Task AddShiftAsync(Shift shift);
        Task RemoveShiftAsync(int shiftId);
        Task UpdateShiftAsync(Shift shift);
    }
}