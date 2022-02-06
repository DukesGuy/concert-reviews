DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS attendees;
DROP TABLE IF EXISTS concerts;
DROP TABLE IF EXISTS venues;
   
CREATE TABLE venues (
	venue_pk int(11) unsigned NOT NULL AUTO_INCREMENT,
    venue_name varchar(40) NOT NULL,
    street varchar(50),
    city varchar(40),
    state char(2) NOT NULL,
    zip char(5),
    PRIMARY KEY (venue_pk)
    );
   
CREATE TABLE concerts (
    concert_name varchar(40) NOT NULL,
    venue_id int(11) unsigned NOT NULL,
    date_id date NOT NULL,
    organizer varchar(50),
    PRIMARY KEY (concert_name),
    FOREIGN KEY (venue_id) REFERENCES venues (venue_pk)
    );
   
CREATE TABLE attendees (
	attendee_pk int(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(40) NOT NULL,
    last_name varchar(40) NOT NULL,
    username varchar(20) NOT NULL,
    email varchar(255) NOT NULL,
    PRIMARY KEY (attendee_pk)
    );
    
CREATE TABLE reviews (
	review_pk int(11) unsigned NOT NULL AUTO_INCREMENT,
    concert_id varchar(40) NOT NULL,
    attendee_id int(11) unsigned NOT NULL,
    date_posted datetime default current_timestamp,
    production_rating tinyint unsigned,
    sound_rating tinyint unsigned,
    food_rating tinyint unsigned,
    restroom_rating tinyint unsigned,
    merch_rating tinyint unsigned,
    parking_rating tinyint unsigned,
    security_rating tinyint unsigned,
    attractions_rating tinyint unsigned,
    comments varchar(255) NOT NULL,
    PRIMARY KEY (review_pk),
    FOREIGN KEY (concert_id) REFERENCES concerts (concert_name),
    FOREIGN KEY (attendee_id) REFERENCES attendees (attendee_pk)
    );
