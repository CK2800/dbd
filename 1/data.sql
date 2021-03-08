-- ten caretakers, some with common pets.
-- twenty pets
-- two vets
delete from caretakers_pets;
delete from cats;
delete from dogs;
delete from pets;
delete from caretakers;
delete from vets;
delete from addresses;
delete  from cities;

-- some cities
insert into cities (zip, name) values (3320, 'Skævinge');
insert into cities (zip, name) values (2800, 'Lyngby');
insert into cities (zip, name) values (2900, 'Hellerup');
insert into cities (zip, name) values (3400, 'Hillerød');
insert into cities (zip, name) values (1964, 'Brøndby');
insert into cities (zip, name) values (2730, 'Herlev');
insert into cities (zip, name) values (3000, 'Helsingør');
insert into cities (zip, name) values (5000, 'Odense');
insert into cities (zip, name) values (4300, 'Holbæk');

-- some addresses
insert into addresses (street, cities_zip) values ('V. marken 20', 3320);
insert into addresses (street, cities_zip) values ('Hovedgaden 1', 2800);
insert into addresses (street, cities_zip) values ('Strandvejen 20', 2900);
insert into addresses (street, cities_zip) values ('Kongevejen 2', 3400);
insert into addresses (street, cities_zip) values ('Vilfort Park 1', 1964);
insert into addresses (street, cities_zip) values ('Vinkelvej 8', 2800);
insert into addresses (street, cities_zip) values ('Chr X Alle 30', 2800);
insert into addresses (street, cities_zip) values ('Meløsevej 40', 3320);
insert into addresses (street, cities_zip) values ('Generatorvej 2', 2730);
insert into addresses (street, cities_zip) values ('Helsingør Plads 23', 3000);
insert into addresses (street, cities_zip) values ('Kronborgvej 12', 3000);
insert into addresses (street, cities_zip) values ('Stengade 23', 3000);
insert into addresses (street, cities_zip) values ('Frederiksborgvej 76', 3400);
insert into addresses (street, cities_zip) values ('Kalundborgvej 45', 4300);
insert into addresses (street, cities_zip) values ('HC Andersens kvarter 4', 5000);
insert into addresses (street, cities_zip) values ('Skrænten 7', 3400);
 
-- two vets
insert into vets (cvr, name, phone, address_id) select '77777777', 'Dr. dyrs klinik', '+4512345678', id from addresses where street like '%marken%';
insert into vets (cvr, name, phone, address_id) select '88888888', 'Dyr lægeklinik', '+4587654321', id from addresses where street like '%Vilfort%';

-- ten caretakers
insert into caretakers (name, phone, address_id) select 'Kurt', '+4555443322', id from addresses where street like '%Hovedgaden%';
insert into caretakers (name, phone, address_id) select 'Sonja', '+411223344', id from addresses where street like '%Hovedgaden%';
insert into caretakers (name, phone, address_id) select 'Nick H', '+413223344', id from addresses where street like '%Skræ%';
insert into caretakers (name, phone, address_id) select 'Mads', '+411223344', id from addresses where street like '%Mel%';
insert into caretakers (name, phone, address_id) select 'Claus', '+413223544', id from addresses where street like '%X%';
insert into caretakers (name, phone, address_id) select 'Jesper', '+511223344', id from addresses where street like '%Stenga%';
insert into caretakers (name, phone, address_id) select 'Henrik', '+411224544', id from addresses where street like '%Freder%';
insert into caretakers (name, phone, address_id) select 'Mr Black', '+454223344', id from addresses where street like '%HC%';
insert into caretakers (name, phone, address_id) select 'Mrs Red', '+413323344', id from addresses where street like '%HC%';
insert into caretakers (name, phone, address_id) select 'Torben', '+411224444', id from addresses where street like '%Gen%';
 
-- twenty pets, various kinds.
insert into pets(name, age, vet_cvr)  values ('Karla Kanin', 2, '77777777');
insert into pets(name, age, vet_cvr)  values ('Bjørka Bjørn', 19, '77777777');
insert into pets(name, age, vet_cvr)  values ('Giraffen Gumle', 1, '77777777');
insert into pets(name, age, vet_cvr)  values ('Gurli Gris', 5, '77777777');
insert into pets(name, age, vet_cvr)  values ('Far Gris', 12, '77777777');
insert into pets(name, age, vet_cvr)  values ('Kamæleonen Koda', 5, '77777777');
insert into pets(name, age, vet_cvr)  values ('Viggo Varan', 4, '77777777');
insert into pets(name, age, vet_cvr)  values ('Bonnie', 2, '77777777');
insert into pets(name, age, vet_cvr)  values ('Humle Hamster', 12, '77777777');
insert into pets(name, age, vet_cvr)  values ('Vædderen Vera', 213, '88888888');
insert into pets(name, age, vet_cvr)  values ('Biggie Blackie', 23, '88888888');
insert into pets(name, age, vet_cvr)  values ('Soja', 13, '88888888');
insert into pets(name, age, vet_cvr)  values ('Topper', 11, '88888888');
insert into pets(name, age, vet_cvr)  values ('Honning', 5, '88888888');
insert into pets(name, age, vet_cvr)  values ('Vaks', 7, '88888888');
insert into pets(name, age, vet_cvr)  values ('Yoda', 8, '88888888');
insert into pets(name, age, vet_cvr)  values ('Øffe', 9, '88888888');
insert into pets(name, age, vet_cvr)  values ('Tøsen', 4711, '88888888');
insert into pets(name, age, vet_cvr)  values ('Peanut', 21, '88888888');
insert into pets(name, age, vet_cvr)  values ('Garfield', 13, '88888888');

-- some pets are cats and dogs.
insert into dogs(bark_pitch, pet_id) select '2D', id from pets where name = 'Bonnie';
insert into dogs(bark_pitch, pet_id) select '1F', id from pets where name like '%Blackie';
insert into dogs(bark_pitch, pet_id) select '5V', id from pets where name = 'Vaks';
insert into cats(lifecount, pet_id) select 2, id from pets where name = 'Garfield';
insert into cats(lifecount, pet_id) select 7, id from pets where name = 'Tøsen';

-- pet-caretaker relations
insert into caretakers_pets (caretaker_id, pet_id) select c.id, p.id from caretakers c, pets p where c.name like '%Sonja' and p.name like '%Karla%';
insert into caretakers_pets (caretaker_id, pet_id) select c.id, p.id from caretakers c, pets p where c.name like '%Red' and p.name like '%Viggo%';
insert into caretakers_pets (caretaker_id, pet_id) select c.id, p.id from caretakers c, pets p where c.name like '%Red' and p.name like '%Bonnie%';
insert into caretakers_pets (caretaker_id, pet_id) select c.id, p.id from caretakers c, pets p where c.name like '%Black' and p.name like '%Bonnie%';
insert into caretakers_pets (caretaker_id, pet_id) select c.id, p.id from caretakers c, pets p where c.name like '%Henrik' and p.name like '%Tøsen%';
insert into caretakers_pets (caretaker_id, pet_id) select c.id, p.id from caretakers c, pets p where c.name like '%Henrik' and p.name like '%Honning%';
insert into caretakers_pets (caretaker_id, pet_id) select c.id, p.id from caretakers c, pets p where c.name like '%Red' and p.name like '%Koda%';
insert into caretakers_pets (caretaker_id, pet_id) select c.id, p.id from caretakers c, pets p where c.name like '%Henrik' and p.name like '%Peanut%';
insert into caretakers_pets (caretaker_id, pet_id) select c.id, p.id from caretakers c, pets p where c.name like '%Red' and p.name like '%Blackie%';
insert into caretakers_pets (caretaker_id, pet_id) select c.id, p.id from caretakers c, pets p where c.name like '%Kurt' and p.name like '%Peanut%';


