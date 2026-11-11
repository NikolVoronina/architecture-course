-- Create myschema schema.
CREATE SCHEMA IF NOT EXISTS myschema;

CREATE TABLE IF NOT EXISTS myschema.destinations (
    id INT NOT NULL AUTO_INCREMENT,
    place VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL,
    info VARCHAR(255) NOT NULL,
    image VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS myschema.reviews (
    id INT NOT NULL AUTO_INCREMENT,
	destination_id INT NOT NULL,
    rating INT NOT NULL,
    comment VARCHAR(255) NOT NULL,
    `by` VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (destination_id) REFERENCES myschema.destinations(id)
);

-- Populate tables.
USE myschema;

-- Populate destinations table.
insert into destinations (place, country, latitude, longitude, info, image) values 
(
	"Alesund", 
	"Norway", 
	62.5, 
	2.3,
	"Alesund is a sea port on the west coast of Norway, noted for its beautiful Art Nouveau architecture and spectacular mountain scenery.",
	"alesund.jpg"
);


insert into destinations (place, country, latitude, longitude, info, image) values 
(
	"Andalsnes", "Norway", 62.5, 7.5,
	"Andalsnes is a pretty town located on the banks of Isfjorden in Norway, famed for its Trollstigen Road with 11-hairpin corners.",
	"andalsnes.jpg"
);


insert into destinations (place, country, latitude, longitude, info, image) values 
(
	"Belfast", "Northern Ireland", 54.5, -6.0,
	"Belfast is the capital city of Northern Ireland, and is home of the famous Harland and Wolff shipyard where the Titanic was built.",
	"belfast.jpg"
);


insert into destinations (place, country, latitude, longitude, info, image) values 
(
	"Bronnoysund", "Norway", 65.8, 12.3,
	"Bronnoysund is a small town on the west coast of Norway with a population of approx 5000, and home of the legendary Torghatten mountain.",
	"bronnoysund.jpg"
);


insert into destinations (place, country, latitude, longitude, info, image) values 
(
	"Budapest", "Hungary", 47.5, 19.0,
	"Budapest is the capital city of Hungary, with the Duna (Danube) flowing majestically between Buda on the west and Pest on the east.",
	"budapest.jpg"
);


insert into destinations (place, country, latitude, longitude, info, image) values 
(
	"Cape Town", "South Africa", -33.9, 18.5,
	"Voted several times the best place in the world to visit, Cape Town is the second largest city in South Africa and is home of Table Mountain.",
	"capetown.jpg"
);


insert into destinations (place, country, latitude, longitude, info, image) values 
(
	"Copenhagen", "Denmark", 55.7, 12.5,
	"Copenhagen is the capital city of Denmark, home of the famous Little Mermaid statue and beautiful Nyhavn.",
	"copenhagen.jpg"
);


insert into destinations (place, country, latitude, longitude, info, image) values 
(
	"Cork", "Ireland", 51.9, -8.5,
	"Cork is the second biggest city in Ireland and was originally a monastic settlement.",
	"cork.jpg"
);


insert into destinations (place, country, latitude, longitude, info, image) values 
(
	"Grimstad", "Norway", 58.3, 8.5,
	"Located on the south coast of Norway, Grimstad is a pretty town with a lovely harbour.",
	"grimstad.jpg"
);


insert into destinations (place, country, latitude, longitude, info, image) values 
(
	"Johannesburg", "South Africa", -26.2, 28.0,
	"Joburg is the capital city of South Africa, located in Guateng province and more than 1 mile above sea level. There are a lot of hadedas in Joburg!",
	"johannesburg.jpg"
);


insert into destinations (place, country, latitude, longitude, info, image) values 
(
	"Oslo", "Norway", 59.9, 10.8,
	"Oslo is the capital city of Norway, in a beautiful setting nestling between Oslo fjord and Marka forest.",
	"oslo.jpg"
);


insert into destinations (place, country, latitude, longitude, info, image) values 
(
	"Rome", "Italy", 41.8, 12.5,
	"Rome is the capital city of Italy, steeped in history and one of the most visted cities on the planet.",
	"rome.jpg"
);


insert into destinations (place, country, latitude, longitude, info, image) values 
(
	"Singapore", "Singapore", 1.2, 103.9,
	"Singapore is a city-state with a strong history as a trading route and a thriving centre for commerce.",
	"singapore.jpg"
);


insert into destinations (place, country, latitude, longitude, info, image) values 
(
	"Swansea", "Wales!!!", 51.6, -3.9,
	"Swansea is the 2nd largest city in Wales, with an important history in copper and a pleasant seaside location.",
	"swansea.jpg"
);


insert into reviews (destination_id, rating, comment, `by`) values 
(
	1, 5, "What an incredibly beautiful place", "J. Smith"
);


insert into reviews (destination_id, rating, comment, `by`) values 
(
	1, 4, "Spectacular natural beauty, with snow-peaked mountains and crystal sea", "O. Nordmann"
);


insert into reviews (destination_id, rating, comment, `by`) values 
(
	1, 5, "I wanna go back!", "A. Olsen"
);


insert into reviews (destination_id, rating, comment, `by`) values 
(
	6, 5, "What an incredible place - I loved the V&A Waterfront", "P. Lafayette"
);