# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table `ATS` (`create_at` VARCHAR(254) NOT NULL,`ip` VARCHAR(254) NOT NULL,`action_type` VARCHAR(254) NOT NULL,`goalId` VARCHAR(254) NOT NULL,`url` varchar(1024) NOT NULL,`headers` varchar(2048) NOT NULL);
create table `CAT` (`create_at` VARCHAR(254) NOT NULL,`uid` VARCHAR(254) NOT NULL,`bala` VARCHAR(254) NOT NULL,`ip` VARCHAR(254) NOT NULL,`url` varchar(1024) NOT NULL,`headers` varchar(2048) NOT NULL);
create table `CONV` (`create_at` VARCHAR(254) NOT NULL,`uid` VARCHAR(254) NOT NULL,`ip` VARCHAR(254) NOT NULL);

# --- !Downs

drop table `ATS`;
drop table `CAT`;
drop table `CONV`;

