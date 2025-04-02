insert into publisher(id,name) values (nextval('pub_seq2'),'Oreily');
insert into publisher(id,name) values (nextval('pub_seq2'),'Tata Mcgraw Hill');
insert into publisher(id,name) values (nextval('pub_seq2'),'Pegion');


insert into book(id,name,price,year,publisher_id) values (nextval('book_seq'),'Java book',120,1997,2);
insert into book(id,name,price,year,publisher_id) values (nextval('book_seq'),'Spring book',120,2011,3);
insert into book(id,name,price,year,publisher_id) values (nextval('book_seq'),'IKIGAI',150,2011,1);
insert into book(id,name,price,year,publisher_id) values (nextval('book_seq'),'IKIGAI',150,2011,3);
insert into book(id,name,price,year,publisher_id) values (nextval('book_seq'),'IKIGAI',150,2011,2);
insert into book(id,name,price,year,publisher_id) values (nextval('book_seq'),'IKIGAI',150,2011,1);




insert into author (id,name,address) values(nextval('author_seq'),'Rod Johnson','Europe');
insert into author (id,name,address) values(nextval('author_seq'),'Jurgeon Holler','Europe');
insert into author (id,name,address) values(nextval('author_seq'),'James Goshling','US');
insert into author (id,name,address) values(nextval('author_seq'),'Gavin King','US');
insert into author (id,name,address) values(nextval('author_seq'),'Fedrick Backman','Australia');
insert into author (id,name,address) values(nextval('author_seq'),'Khalid Hussaini','Afghanisthan');

insert into book_author(book_id,author_id) values(1,3);
insert into book_author(book_id,author_id) values(1,5);
insert into book_author(book_id,author_id) values(3,6);
insert into book_author(book_id,author_id) values(4,1);
insert into book_author(book_id,author_id) values(4,2);
insert into book_author(book_id,author_id) values(5,1);
insert into book_author(book_id,author_id) values(5,2);
insert into book_author(book_id,author_id) values(6,4);


