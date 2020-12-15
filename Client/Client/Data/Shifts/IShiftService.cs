using System.Collections.Generic;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data.Shifts
{
    public interface IShiftService
    {
        Task<IList<Shift>> GetAllShiftsOneUser(string username);
        Task<IList<Shift>> GetAllShifts();
        Task <Shift> GetShiftById(string id);
        Task AddShiftAsync(Shift shift);
        Task RemoveShiftAsync(string shiftId);
        Task ApplyToShiftAsync(string shiftId, string username);
        Task ApproveAsync(string shiftId, string username);
        Task RejectAsync(string shiftId, string username);
      
    }
}