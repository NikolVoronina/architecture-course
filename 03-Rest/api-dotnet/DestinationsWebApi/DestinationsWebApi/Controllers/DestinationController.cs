using DestinationsWebApi.Repositories;
using DestinationsWebApi.Models;
using Microsoft.AspNetCore.Mvc;

namespace DemoFullstackApp.Controllers
{
    [ApiController]
    [Route("destinations")]
    public class DestinationController : ControllerBase
    {
        private readonly IDestinationRepository _repository;

        public DestinationController(IDestinationRepository repository)
        {
            _repository = repository;
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<Destination>>> GetAll()
        {
            var result = await _repository.GetAllAsync();
            return Ok(result);
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<Destination>> GetById(long id)
        {
            var destination = await _repository.GetByIdAsync(id);

            if (destination == null)
                return NotFound();

            return Ok(destination);
        }

        [HttpPut("addReviewForDestination/{destinationId}")]
        public async Task<IActionResult> AddReview(long destinationId, [FromBody] Review review)
        {
            var destination = await _repository.GetByIdAsync(destinationId);

            if (destination == null)
                return NotFound();

            destination.AddReview(review);
            await _repository.SaveAsync(destination);

            return Ok();
        }
    }
}