using System.Collections.Generic;
using System.Runtime.Serialization;
using System.Threading.Tasks;
using AndriuhaAssignment.Models;

namespace AndriuhaAssignment.Data
{
    public interface IApplicationService
    {
        Task<Application> GetApplicationAsync(ObjectIDGenerator applicationId);
        Task CreateApplicationAsync(Application application);
        Task<Application> RemoveApplicationAsync(ObjectIDGenerator applicationId);
        Task<Application> UpdateApplicationAsync(Application application);
        
    }
}