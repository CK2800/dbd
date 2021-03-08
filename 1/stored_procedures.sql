create or replace procedure update_cat(
	-- parameters
	petid int,
	petname varchar(64),
	petage int,
	vetcvr varchar(16),
	life_count int
)
as $cat_update$
declare
begin
	update pets set name = petname, age = petage, vet_cvr = vetcvr where id = petid;
	update cats set lifecount = life_count where pet_id = petid;
end;
$cat_update$ language plpgsql security definer; -- needed to be able to update underlying tables through procedure. https://stackoverflow.com/questions/56168299/how-to-allow-user-call-stored-procedure-in-postgresql-without-granting-additiona
--call update_cat(200, 'Garfield', 40, '88888888', 400);

create or replace procedure update_dog(
	-- parameters
	petid int,
	petname varchar(64),
	petage int,
	vetcvr varchar(16),
	barkpitch varchar(2)
)
as $dog_update$
declare
begin
	update pets set name = petname, age = petage, vet_cvr = vetcvr where id = petid;
	update dogs set bark_pitch = barkpitch where pet_id = petid;
end;
$dog_update$ language plpgsql security definer; -- needed to be able to update underlying tables through procedure. https://stackoverflow.com/questions/56168299/how-to-allow-user-call-stored-procedure-in-postgresql-without-granting-additiona
--call update_dog(188, 'Bonnie', 2, '77777777', '2D');

create or replace procedure create_dog(
	-- parameters	
	petname varchar(64),
	petage int,
	vetcvr varchar(16),
	barkpitch varchar(2)
)
as $dog_create$
declare
begin
	WITH new_dog as 
	(
		insert into pets(name, age, vet_cvr)  values (petname, petage, vetcvr) returning id
	)	
	insert into dogs(pet_id, bark_pitch) select id, barkpitch from new_dog;
end;
$dog_create$ language plpgsql security definer; -- needed to be able to update underlying tables through procedure. https://stackoverflow.com/questions/56168299/how-to-allow-user-call-stored-procedure-in-postgresql-without-granting-additiona
--call create_dog('Bent', 32, '77777777', '2D');

create or replace procedure create_cat(
	-- parameters	
	petname varchar(64),
	petage int,
	vetcvr varchar(16),
	life_count int
)
as $cat_create$
declare
begin
	WITH new_cat as 
	(
		insert into pets(name, age, vet_cvr)  values (petname, petage, vetcvr) returning id
	)	
	insert into cats(pet_id, lifecount) select id, life_count from new_cat;
end;
$cat_create$ language plpgsql security definer; -- needed to be able to update underlying tables through procedure. https://stackoverflow.com/questions/56168299/how-to-allow-user-call-stored-procedure-in-postgresql-without-granting-additiona
--call create_cat('Snowball 2', 132, '88888888', 1);


create or replace procedure create_pet(
	-- parameters	
	petname varchar(64),
	petage int,
	vetcvr varchar(16)	
)
as $pet_create$
declare
begin
	insert into pets(name, age, vet_cvr)  values (petname, petage, vetcvr);
end;
$pet_create$ language plpgsql security definer; -- needed to be able to update underlying tables through procedure. https://stackoverflow.com/questions/56168299/how-to-allow-user-call-stored-procedure-in-postgresql-without-granting-additiona


