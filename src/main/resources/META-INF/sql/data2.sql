insert into publishers (id, name) values (1, 'Helios');
insert into publishers (id, name) values (2, 'Nowa Era');
insert into publishers (id, name) values (3, 'New York Times');

insert into authors (id, firstName, lastName,email, pesel) values (1, 'Karol', 'Nowicki','afa@gmail.com','66010123333');
insert into authors (id, firstName, lastName,email, pesel) values (2, 'Stephen', 'King','afaaa@gmail.com','86010123333');
insert into authors (id, firstName, lastName,email, pesel) values (3, 'Bruce', 'Eckel','lol@gmail.com','96010123333');

insert into categories (name)values ('History');
insert into categories (name)values ('Sport');
insert into categories (name)values ('Science');
insert into categories (name)values ('Money');


insert into books ( title, rating, description, pages, publisher_id,category_id) values ( 'Harry Potter', 5, 'some',12,1,1)
insert into books (title, rating, description, pages,publisher_id,category_id) values ( 'Clean Code', 4, 'interesting',8,2,2)
insert into books (title, rating, description, pages,publisher_id,category_id) values ( 'The Five O''Clock Express', 6, 'interesting',8,3,3)
insert into books (title, rating, description, pages,publisher_id,category_id) values ( 'About our world', 3, 'interesting',5,1,1)
insert into books (title, rating, description, pages,publisher_id,category_id) values ('The Summer of Lost and Found', 3, 'interesting',8,1,4)
insert into books (title, rating, description, pages,publisher_id,category_id) values ( 'Six of Crows', 2, 'interesting',9,2,1)
insert into books (title, rating, description, pages,publisher_id,category_id) values ( 'The Bomber Mafia', 6, 'interesting',5,3,2)
insert into books (title, rating, description, pages,publisher_id,category_id) values ('Trouble at the Wedding', 7, 'interesting',3,1,3)
insert into books (title, rating, description, pages,publisher_id,category_id) values ('Just Friends', 8, 'interesting',2,2,4)
insert into books (title, rating, description, pages,publisher_id,category_id) values ('That Summer', 9, 'interesting',11,3,1)

insert into persons (login, password, email) values ('linux', '1234', 'jaro@gmail.com')
insert into persons (login, password, email) values ('windows', '4321', 'win@gmail.com')



