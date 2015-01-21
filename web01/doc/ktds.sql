/* 데이터베이스 생성*/
create database ktds character set utf8 collate utf8_general_ci;

/* 테이블 생성*/
create table boards(
  bno int not null primary key auto_increment,
  title varchar(255) not null,
  contents text not null,
  cnt int null default 0,
  create_date datetime
);

/* 테스트를 위한 예제 게시물을 입력 */
insert into boards(title, contents, create_date)
values('제목1','내용....',now());
insert into boards(title, contents, create_date)
values('제목2','내용....',now());
insert into boards(title, contents, create_date)
values('제목3','내용....',now());
insert into boards(title, contents, create_date)
values('제목4','내용....',now());
insert into boards(title, contents, create_date)
values('제목5','내용....',now());
insert into boards(title, contents, create_date)
values('제목6','내용....',now());
insert into boards(title, contents, create_date)
values('제목7','내용....',now());
insert into boards(title, contents, create_date)
values('제목8','내용....',now());
insert into boards(title, contents, create_date)
values('제목9','내용....',now());
insert into boards(title, contents, create_date)
values('제목10','내용....',now());

select * from boards;

delete from boards 
where bno=1; 

update boards set
  title='okok',
  contents='아하... 변경되었네'
where bno=5;












