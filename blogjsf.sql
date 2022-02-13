CREATE DATABASE BLOGJSF;
USE BLOGJSF;

select * from user;
select * from post;
select * from category;

insert into category(description)
value ('tecnologia');
insert into user(name, email, senha, role) 
values ('danilo','danilo@imd.com','danilo','DANILO');
insert into post(date, subtitle, text, title, category, user)
values ('13/02/2022', 'Venda da Oi:', 'Veja se seu número vai para a Vivo, Claro ou Tim', 'Telecomunicação', 1, 1);

insert into category(description)
value ('saude');
insert into user(name, email, senha, role) 
values ('Hagliberto','hagliberto@imd.com','Hagliberto','HAGLIBERTO');
insert into post(date, subtitle, text, title, category, user)
values ('13/02/2022', 'Covid19:', 'Média móvel de mortes por Covid no Brasil é a maior em 6 meses e se aproxima de 900 por dia', 'Coronavirus', 2, 2);

insert into category(description)
value ('educacao');
insert into user(name, email, senha, role) 
values ('Jean','jean@imd.com','Jean','JEAN');
insert into post(date, subtitle, text, title, category, user)
values ('13/02/2022', 'Hibernate:', 'O Hibernate é um framework para o mapeamento objeto-relacional escrito na linguagem Java.', 'Software', 3, 3);











 
CREATE TABLE IF NOT EXISTS author (
	id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(80) NOT NULL
);

INSERT INTO author (
 name, email, password
 ) values (
 'Hagliberto', 'hagliberto@imd.com', "123"
 );

CREATE TABLE IF NOT EXISTS category (
	id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,    
    description VARCHAR(30)
);
 
INSERT INTO category (
description) VALUES (
'Tecnologia');

CREATE TABLE IF NOT EXISTS post (
	id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    author INTEGER,
    category INTEGER,
    title VARCHAR(100),
    subtitle VARCHAR(100),
    text TEXT,
    date TIMESTAMP,
    FOREIGN KEY(author) REFERENCES author(id),
    FOREIGN KEY(category) REFERENCES category(id)
);


DROP DATABASE blogjsf;
SHOW DATABASES;

