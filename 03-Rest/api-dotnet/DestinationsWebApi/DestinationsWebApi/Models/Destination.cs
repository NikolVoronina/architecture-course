using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace DestinationsWebApi.Models
{
    [Table("destinations")]
    public class Destination
    {
        [Key]
        [Column("id")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }

        [Column("place")]
        public required string Place { get; set; }

        [Column("country")]
        public required string Country { get; set; }

        [Column("latitude")]
        public double Latitude { get; set; }

        [Column("longitude")]
        public double Longitude { get; set; }

        [Column("info")]
        public required string Info { get; set; }

        [Column("image")]
        public required string Image { get; set; }

        public List<Review> Reviews { get; set; } = new();

        public void AddReview(Review review)
        {
            review.DestinationId = Id;
            Reviews.Add(review);
        }
    }
}