create table QUESTIONS(
	id_question serial primary key, 
	vl_question varchar(1000) not null
);

create table ANSWERS (
	id_answer serial  primary key, 
	vl_answer varchar(1000) not null, 
	iscorrect bool not null, 
	id_question int references QUESTIONS(id_question)
);

insert into QUESTIONS (vl_question) values ('В файл с каким расширением компилируется java-файл?');
insert into ANSWERS (vl_answer, iscorrect, id_question) values ('cs',false,1),('java',false,1),('class',true,1),('exe',false,1);

insert into QUESTIONS (vl_question) values ('С помощью какой команды git можно получить полную копию удаленного репозитория?');
insert into ANSWERS (vl_answer, iscorrect, id_question) values ('commit',false,2),('push',false,2),('clone',true,2),('copy',false,2);

insert into QUESTIONS (vl_question) values ('Какой применяется цикл, когда не известно количество итераций?');
insert into ANSWERS (vl_answer, iscorrect, id_question) values ('while',true,3),('for',false,3),('loop',true,3);


select * 
from QUESTIONS q
join ANSWERS a on q.id_question = a.id_question
order by q.id_question, a.id_answer