create database if not exists PERSON_DATA character set utf8 collate utf8_unicode_ci;
use PERSON_DATA;
create table if not exists PERSON(PERSON_ID int not null auto_increment, NAME VARCHAR(35) NOT NULL, POSITION VARCHAR(35) NULL, PRIMARY KEY(PERSON_ID)) engine = InnoDB;
insert into PERSON(NAME, POSITION) values('Mauricio Leal', 'Director');
