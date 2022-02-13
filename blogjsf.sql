USE BLOGJSF;

select * from user;
select * from post;
select * from category;

insert into category(description)
value 	('tecnologia'),
				('saude'),
        ('educacao');

insert into user(name, email, senha, role) 
values 	('danilo','danilo@imd.com','danilo','DANILO'),
				('Hagliberto','hagliberto@imd.com','Hagliberto','HAGLIBERTO'),
        ('Jean','jean@imd.com','Jean','JEAN');
        
insert into post(date, subtitle, text, title, category, user)
values 	('2022-02-13', 'Venda da Oi:', 'Veja se seu número vai para a Vivo, Claro ou Tim', 'Telecomunicação', 1, 1),
				('2022-02-13', 'Covid19:', 'Média móvel de mortes por Covid no Brasil é a maior em 6 meses e se aproxima de 900 por dia', 'Coronavirus', 2, 2),
				('2022-02-13', 'Hibernate:', 'O Hibernate é um framework para o mapeamento objeto-relacional escrito na linguagem Java.', 'Software', 3, 3);
