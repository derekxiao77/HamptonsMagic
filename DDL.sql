drop table if exists student;
drop table if exists schedule;

create table student (
  student_id integer,
	first_name varchar,
  last_name varchar,
  first_major varchar,
  second_major varchar,
  third_major varchar,
  gpa numeric(4,3), -- four total digits, 3 to right of decimal
	primary key (student_id)
);

create table schedule (
  student_id varchar(15),
  class_id varchar(15),
  semester varchar(15) -- fall, winter, spring, fall
);
