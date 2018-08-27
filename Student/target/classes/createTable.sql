
MYSQL :

create table Student (
   id INT NOT NULL auto_increment,
   student_name VARCHAR(20) default NULL,
   father_name VARCHAR(20) default NULL,
   section VARCHAR(20) default NULL,
   type_of_student VARCHAR(20) default NULL,
   PRIMARY KEY (id)
);


PosgreSQL :

create table Student (
   id  SERIAL PRIMARY KEY,
   student_name VARCHAR(20) default NULL,
   father_name VARCHAR(20) default NULL,
   section VARCHAR(20) default NULL,
   type_of_student VARCHAR(20) default NULL,
   );
