using Microsoft.EntityFrameworkCore;
using DestinationsWebApi.Models;

namespace DestinationsWebApi.Repositories
{
    public class DestinationRepository : IDestinationRepository
    {
        private readonly AppDbContext _context;

        public DestinationRepository(AppDbContext context)
        {
            _context = context;
        }

        public async Task<IEnumerable<Destination>> GetAllAsync()
        {
            return await _context.Destinations
                .Include(d => d.Reviews)
                .ToListAsync();
        }

        public async Task<Destination?> GetByIdAsync(long id)
        {
            return await _context.Destinations
                .Include(d => d.Reviews)
                .FirstOrDefaultAsync(d => d.Id == id);
        }

        public async Task SaveAsync(Destination destination)
        {
            _context.Update(destination);
            await _context.SaveChangesAsync();
        }
    }
}