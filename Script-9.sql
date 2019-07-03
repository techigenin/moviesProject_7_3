
--our table for movies
create table movie(
movieid serial primary key,
title varchar not null,
runtime time not null,
genre varchar not null
);

--adding year column
alter table movie add column year date; 

select * from movie;



--creating table for admin login
create table admins(
username varchar primary key,
pass_word varchar not null
);


 insert into admins values ('admin1', 'movie1'), ('admin2', 'movie2');

select * from admins;


create table movie_genre(
genre varchar primary key,
movieid integer references movie (movieid)
);

select * from movie_genre;


create table actor(
actorid serial primary key,
actorname varchar not null
);

create table movie_actors(
movieid integer not null,
actorid integer not null
);
