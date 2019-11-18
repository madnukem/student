create table student (
   id bigint not null,
   firstname varchar(255) not null,
   middlename varchar(255) not null,
   lastname varchar(255) not null,
   course integer not null,
   primary key(id)
);
create sequence seq_student increment by 1 nocache;