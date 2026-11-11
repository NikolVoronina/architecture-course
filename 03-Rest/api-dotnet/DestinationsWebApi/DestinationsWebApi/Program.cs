using DestinationsWebApi.Repositories;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container
builder.Services.AddControllers();
builder.Services.AddOpenApi();

// ===============================
// Build connection string from ENV VARS (Kubernetes ConfigMap/Secret)
// ===============================
var host = builder.Configuration["DB_HOST"];
var port = builder.Configuration["DB_PORT"];
var database = builder.Configuration["DB_DATABASE"];
var username = builder.Configuration["DB_USERNAME"];
var password = builder.Configuration["DB_PASSWORD"];

var connectionString =
    $"Server={host};Port={port};Database={database};User Id={username};Password={password};SslMode=Disabled;AllowPublicKeyRetrieval=True;";
Console.WriteLine($"**********{connectionString}*****************");

// Register DbContext
builder.Services.AddDbContext<AppDbContext>(options =>
    options.UseMySQL(connectionString));

builder.Services.AddScoped<IDestinationRepository, DestinationRepository>();

var app = builder.Build();

// Configure the HTTP request pipeline
if (app.Environment.IsDevelopment())
{
    app.MapOpenApi();
}

app.UseHttpsRedirection();
app.UseAuthorization();
app.MapControllers();

app.Run();