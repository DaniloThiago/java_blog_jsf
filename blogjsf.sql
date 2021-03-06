DROP DATABASE blogjsf;
DROP TABLE IF EXISTS postagem;
create database blogjsf;
USE BLOGJSF;

select * from usuario;
select * from postagem;
select * from categoria;

insert into usuario(nome, email, senha, tipo) 
values 	('Hagliberto','hagliberto@imd.com','Hagliberto','admin'),
		('Danilo','danilo@imd.com','Danilo','admin'),
	    ('Jean','jean@imd.com','Jean','user');
        
        
insert into categoria(descricao)
value 	('Tecnologia'),
		('Saúde'),
        ('Educação');

        
insert into postagem(data, subtitulo, texto, titulo, categoriaId, usuarioId)
values 	('2022-02-13', 'Venda da Oi:', 'Veja se seu número vai para a Vivo, Claro ou Tim', 'Telecomunicação', 1, 1),
		('2022-02-13', 'Covid19:', 'Média móvel de mortes por Covid no Brasil é a maior em 6 meses e se aproxima de 900 por dia', 'Coronavirus', 2, 2);

insert into postagem(data, subtitulo, texto, titulo, categoriaId, usuarioId)
values 	('2022-02-13', 'Hibernate:', 'O Hibernate é um framework para o mapeamento objeto-relacional escrito na linguagem Java.', 'Software', 3, 3);
