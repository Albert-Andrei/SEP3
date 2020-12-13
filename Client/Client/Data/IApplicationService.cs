using System.Collections.Generic;
using System.Runtime.Serialization;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data
{
    public interface IApplicationService
    {
        Task<List<Application>> GetAllApplicationsAsync();
        Task<Application> GetApplicationAsync(string applicationId);
        Task CreateApplicationAsync(Application application);
        Task UpdateApplicationAsync(Application application);
        Task<Application> GetMyApplicationAsync(string user);

        
    }
}