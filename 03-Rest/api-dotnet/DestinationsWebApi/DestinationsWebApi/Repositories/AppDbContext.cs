using DestinationsWebApi.Models;
using Microsoft.EntityFrameworkCore;

namespace DestinationsWebApi.Repositories
{
    public class AppDbContext : DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> options)
            : base(options)
        {
        }

        public DbSet<Destination> Destinations { get; set; }
        public DbSet<Review> Reviews { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Destination>()
                .HasMany(d => d.Reviews)
                .WithOne()
                .HasForeignKey(r => r.DestinationId)
                .OnDelete(DeleteBehavior.Cascade);
        }
    }
}