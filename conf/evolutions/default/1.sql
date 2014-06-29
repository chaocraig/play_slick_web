# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table `CAT` (`create_at` VARCHAR(254) NOT NULL,`userID` VARCHAR(254) NOT NULL,`bala` VARCHAR(254) NOT NULL,`url` varchar(1024) NOT NULL,`headers` varchar(2048) NOT NULL);

# --- !Downs

drop table `CAT`;

