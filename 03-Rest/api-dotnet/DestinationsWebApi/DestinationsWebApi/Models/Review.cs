using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace DestinationsWebApi.Models
{
    [Table("reviews")]
    public class Review
    {
        [Key]
        [Column("id")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }

        [Column("destination_id")]
        public long DestinationId { get; set; }

        [Column("rating")]
        public int Rating { get; set; }

        [Column("comment")]
        public required string Comment { get; set; }

        [Column("by")]
        public required string By { get; set; }
    }
}