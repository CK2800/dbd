revoke all privileges on all_pets, cats_view, dogs_view from test;
revoke execute on procedure update_cat, update_dog, create_cat, create_dog from test;
drop user if exists test;
create user test with password 'test';
grant select on all_pets, cats_view, dogs_view to test;
grant execute on procedure update_cat, update_dog, create_cat, create_dog to test;