using DestinationsWebApi.Models;

namespace DestinationsWebApi.Repositories
{
    public interface IDestinationRepository
    {
        Task<IEnumerable<Destination>> GetAllAsync();
        Task<Destination?> GetByIdAsync(long id);
        Task SaveAsync(Destination destination);
    }
}