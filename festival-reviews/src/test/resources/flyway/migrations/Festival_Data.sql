-- Venues
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('NOS Events Center', '689 S East St', 'San Bernandino', 'CA', '92408');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Empire Polo Club', '81-800 Avenue 51', 'Indio', 'CA', '92201');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Grant Park', '337 E Randolph St', 'Chicago', 'IL', '60601');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Rawhide Western Town & Event Center', '5700 W North Loop Rd', 'Chandler', 'AZ', '85226');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Las Vegas Motor Speedway', '7000 N Las Vegas Blvd', 'Las Vegas', 'NV', '89115');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Zilker Park', '2207 Lou Neff Rd', 'Austin', 'TX', '78746');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Bayfront Park', '301 Biscayne Blvd', 'Miami', 'FL', '33132');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Citi Field', '41 Seaver Way', 'Queens', 'NY', '11368');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Downtown Las Vegas', '206 N 3rd St', 'Las Vegas', 'NV', '89101');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Harvard Athletic Complex', '65 N Harvard St', 'Allston', 'MA', '02134');
INSERT INTO venues (venue_name, city, state) VALUES('Black Rock Desert', 'Black Rock City', 'NV');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Great Stage Park', '1560 New Bushy Branch Rd', 'Manchester', 'TN', '37355');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Las Vegas Festival Grounds', '311 W Sahara Ave', 'Las Vegas', 'NV', '89101');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Atlantic Station Pinnacle Lot', '240 20th Street NW', 'Atlanta', 'GA', '30363');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Mana Wynwood', '2217 NW 5th Ave', 'Miami', 'FL', '33127');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Dover Motor Speedway', '1131 N Dupont Hwy', 'Dover', 'DE', '19901');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Lake Perris State Recreation Area', '17801 Lake Perris Drive', 'Perris', 'CA', '92571');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Austin Convention Center', '500 E Cesar Chavez St', 'Austin', 'TX', '78701');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Union Park', '1501 W Randolph St', 'Chicago', 'IL', '60606');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Fair Grounds Race Course', '1751 Gentilly Blvd', 'New Orleans', 'LA', '70119');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Pima County Fairgrounds', '11300 South Houghton Road', 'Tucson', 'AZ', '85747');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Marina Green Park', '386 E Shoreline Dr', 'Long Beach', 'CA', '90803');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Waterfront Park', '1600 Pacific Hwy', 'San Diego', 'CA', '92101');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Mardi Gras World', '1380 Port of New Orleans Pl', 'New Orleans', 'LA', '70130');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Pensacola Interstate Fair', '6655 Mobile Highway', 'Pensacola', 'FL', '32526');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Daytona Intrenational Speedway', '1801 West International Speedway Boulevard', 'Daytona Beach', 'FL', '32114');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Buena Vista Lake', '13601 Ironbark Rd', 'Bakersfield', 'CA', '93311');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('The Hangout Gulf Shores', '101 E Beach Blvd', 'Gulf Shores', 'AL', '36542');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Sherwood Forest', '7100 South Water Road', 'Rothbury', 'MI', '49437');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Golden Gate Park', '501 Stanyan Street', 'San Francisco', 'CA', '94117');
INSERT INTO venues (venue_name, street, city, state, zip) VALUES('Legend Valley', '7585 Kindle Rd', 'Thornville', 'OH', '43076');

-- Concerts 
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Hard Summer', 1, '2022-07-29', 'HARD Events');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Coachella', 2, '2022-04-15', 'Goldenvoice');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Lollapalooza', 3, '2022-07-28', 'C3 Presents');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Decadence AZ', 4, '2021-12-30', 'Relentless Beats');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('EDC Las Vegas', 5, '2022-05-20', 'Insomniac Events');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Austin City Limits', 6, '2022-10-07', 'C3 Presents');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Ultra Music Festival', 7, '2022-03-25', 'Ultra Enterprises');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('The Governors Ball', 8, '2022-06-10', 'Founders Entertainment');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Life Is Beautiful', 9, '2022-09-16', 'WENDOH Media');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Boston Calling Music Festival', 10, '2022-05-27', 'Crash Line Productions');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Burning Man', 11, '2022-08-28', 'Burning Man Project');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Bonnaroo', 12, '2022-06-16', 'Superfly Presents');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Day N Vegas', 13, '2021-11-12', 'Goldenvoice');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('AFROPUNK', 14, '2021-09-25', 'AFROPUNK LLC');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('III Points Festival', 15, '2021-10-22', 'III Points LLC');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Firefly Music Festival', 16, '2021-09-23', 'AEG Presents');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Desert Daze', 17, '2022-09-30', 'Phil Pirrone');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Stagecoach', 2, '2022-04-29', 'Goldenvoice');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('South By South West', 18, '2022-03-11', 'SXSW LLC');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Pitchfork Music Festival', 19, '2022-09-10', 'Pitchfork Media');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('New Orleans Jazz & Heritage Festival', 20, '2022-04-29', 'The New Orleans Jazz & Heritage Foundation');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Gem & Jam Festival', 21, '2022-02-04', 'Josh Pollack');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('California Vibrations', 22, '2022-02-04', 'AEG Presents');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('CRSSD Festival', 23, '2022-03-05', 'FNGRS CRSSD');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('BUKU Music + Art Project', 24, '2022-03-25', 'Winter Circle Productions');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Thunder Beats Music Festival', 25, '2022-04-24', 'Thunder Ranch Entertainment Holdings');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Welcome to Rockville', 26, '2022-05-19', 'Danny Wimmer Presents');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Lighting in a Bottle Festival', 27, '2022-05-25', 'Do LaB');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Hangout Music Festival', 28, '2022-05-20', 'Huka Entertainment');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Electric Forest', 29, '2022-06-23', 'Madison House Presents');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Outside Lands Festival', 30, '2022-08-05', 'Planet Entertainment');
INSERT INTO concerts (concert_name, venue_id, date_id, organizer) VALUES('Lost Lands Music Festival', 31, '2022-09-23', 'Excision');

-- Attendees
INSERT INTO attendees (first_name, last_name, username, email) VALUES('Test', 'User', 'testuser', 'test@example.com');

-- Reviews
INSERT INTO reviews (concert_id, attendee_id, comments) VALUES('Decadence AZ', 1, 'Example Review Test');









