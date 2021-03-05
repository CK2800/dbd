-- ten caretakers, some with common pets.
-- twenty pets
-- two vets
delete  from cities;
delete from addresses;
-- cities
insert into cities (zip, name) values (3320, 'Skævinge');
insert into cities (zip, name) values (2800, 'Lyngby');
insert into cities (zip, name) values (2900, 'Hellerup');
insert into cities (zip, name) values (3400, 'Hillerød');
insert into cities (zip, name) values (1964, 'Brøndby');
-- addresses
insert into addresses (street, cities_zip) values ('V. marken 20', 3320);
insert into addresses (street, cities_zip) values ('Hovedgaden 1', 2800);
insert into addresses (street, cities_zip) values ('Strandvejen 20', 2900);
insert into addresses (street, cities_zip) values ('Kongevejen 2', 3400);
insert into addresses (street, cities_zip) values ('Vilfort Park 1', 1964);

