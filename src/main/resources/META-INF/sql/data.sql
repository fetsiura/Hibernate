-- insert into publishers (id, name) values (1, 'Helios');
-- insert into publishers (id, name) values (2, 'Nowa Era');
-- insert into publishers (id, name) values (3, 'New York Times');
--
-- insert into authors (id, firstName, lastName,email, pesel) values (1, 'Karol', 'Nowicki','afa@gmail.com','66010123333');
-- insert into authors (id, firstName, lastName,email, pesel) values (2, 'Stephen', 'King','afaaa@gmail.com','86010123333');
-- insert into authors (id, firstName, lastName,email, pesel) values (3, 'Bruce', 'Eckel','lol@gmail.com','96010123333');
--
-- insert into categories (name)values ('History');
-- insert into categories (name)values ('Sport');
-- insert into categories (name)values ('Science');
-- insert into categories (name)values ('Money');
--
-- insert into books ( title, rating, description, pages, publisher_id,category_id) values ( 'Harry Potter', 5, 'some',12,1,1)
-- insert into books (title, rating, description, pages,publisher_id,category_id) values ( 'Clean Code', 4, 'interesting',8,2,2)
-- insert into books (title, rating, description, pages,publisher_id,category_id) values ( 'The Five O''Clock Express', 6, 'interesting',8,3,3)
-- insert into books (title, rating, description, pages,publisher_id,category_id) values ( 'About our world', 3, 'interesting',5,1,1)
-- insert into books (title, rating, description, pages,publisher_id,category_id) values ('The Summer of Lost and Found', 3, 'interesting',8,1,4)
-- insert into books (title, rating, description, pages,publisher_id,category_id) values ( 'Six of Crows', 2, 'interesting',9,2,1)
-- insert into books (title, rating, description, pages,publisher_id,category_id) values ( 'The Bomber Mafia', 6, 'interesting',5,3,2)
-- insert into books (title, rating, description, pages,publisher_id,category_id) values ('Trouble at the Wedding', 7, 'interesting',3,1,3)
-- insert into books (title, rating, description, pages,publisher_id,category_id) values ('Just Friends', 8, 'interesting',2,2,4)
-- insert into books (title, rating, description, pages,publisher_id,category_id) values ('That Summer', 9, 'interesting',11,3,1)
--

--
insert into authors (firstName, lastName) values ( 'Karol', 'Nowicki');
insert into authors (firstName, lastName) values ( 'Michał', 'Duda');
insert into authors (firstName, lastName) values ( 'Jarek', 'Garw');

insert into publishers (id,name) values (1,'New Era');
insert into publishers (id,name) values (2,'Brooklin');
insert into publishers (id,name) values (3,'Dayli');


insert into books (title, rating, description,publisher_id) values ('That Summer', 9, 'interesting',1)
insert into books (title, rating, description,publisher_id) values ('Black Pirat', 5, 'amazing',2)
insert into books (title, rating, description,publisher_id) values ('Ciber Wars', 4, 'not bad',3)


insert into books_authors(Book_id, authors_id) values (1,1);
insert into books_authors(Book_id, authors_id) values (1,2);
insert into books_authors(Book_id, authors_id) values (2,2);
insert into books_authors(Book_id, authors_id) values (2,3);
insert into books_authors(Book_id, authors_id) values (3,3);