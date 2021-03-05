drop table if exists dogs;
drop table if exists cats;
drop table if exists caretakers_pets;
drop table if exists pets;
drop table if exists vets;
drop table if exists caretakers;
drop table if exists addresses;
drop table if exists cities;


create table cities (
	zip int primary key,
	name varchar(64) not null
	);

create table addresses (
	id serial primary key,
	street varchar(64) not null,
	cities_zip int references cities
	);

create table caretakers (
	id serial primary key,
	name varchar(64) not null,
	phone varchar(16) not null,
	address_id serial references addresses
);

create table vets (
	cvr varchar(16) primary key,
	name varchar(64) not null,
	phone varchar(16) not null,
	address_id serial references addresses
);

create table pets (
	id serial primary key,
	name varchar(64) not null,
	age int not null,
	vet_cvr varchar(16) references vets
);

create table caretakers_pets (
	caretaker_id serial references caretakers,
	pet_id serial references pets
);

create table cats (
	pet_id serial references pets,
	lifecount int not null default 9
);

create table dogs (
	pet_id serial references pets,
	bark_pitch varchar(2) not null
);