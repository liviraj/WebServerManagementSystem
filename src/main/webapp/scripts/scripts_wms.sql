create database wms;

use wms;

CREATE TABLE `wms`.`server` (
  `serverId` INT NOT NULL AUTO_INCREMENT,
  `serverName` VARCHAR(255) NULL,
  `operatingSystem` VARCHAR(255) NULL,
  `ram` VARCHAR(255) NULL,
  `hardDiskSize` VARCHAR(255) NULL,
  `availability` VARCHAR(255) NULL,
  `expiryDate` DATE NULL,
  PRIMARY KEY (`serverId`));

  
  CREATE TABLE `wms`.`login` (
  `loginId` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  PRIMARY KEY (`loginId`));
  
  insert into login(username,password) values('admin','admin');