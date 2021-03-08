create or replace view cats_view as (select * from pets inner join cats on pet_id = id);
create or replace view dogs_view as (select * from pets inner join dogs on pet_id = id);
create or replace view all_pets as (select p.*, c.lifecount, d.bark_pitch from pets p left outer join cats c on c.pet_id = id left outer join dogs d on d.pet_id = id);