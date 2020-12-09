using System.Collections.Generic;
using System.Runtime.Serialization;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data
{
    public interface IApplicationService
    {
        Task<List<Application>> GetAllApplicationsAsync();
        Task<Application> GetApplicationAsync(ObjectIDGenerator applicationId);
        Task CreateApplicationAsync(Application application);
        Task<Application> RemoveApplicationAsync(ObjectIDGenerator applicationId);
        Task<Application> UpdateApplicationAsync(Application application);
        
    }
}