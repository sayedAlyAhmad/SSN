# SSN
clone project 
mvn clean & install
java version 8
data base mysql 
DB Tables in order
1 
CREATE TABLE `city` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
2
CREATE TABLE `user` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `USER_FIRST_NAME` varchar(45) NOT NULL,
  `USER_LAST_NAME` varchar(45) NOT NULL,
  `USER_EMAIL_OR_PHONE` varchar(45) NOT NULL,
  `NEW_PASSWORD` varchar(45) NOT NULL,
  `CONFIRM_PASSWORD` varchar(45) NOT NULL,
  `USER_GENDER` varchar(45) NOT NULL,
  `CITY_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `CITY_ID_idx` (`CITY_ID`),
  CONSTRAINT `CITY_ID` FOREIGN KEY (`CITY_ID`) REFERENCES `city` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
3
CREATE TABLE `cvbuilder` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `OBJECTIVES` varchar(999) NOT NULL,
  `SKILLS` varchar(999) NOT NULL,
  `EXPERIENCE` varchar(999) NOT NULL,
  `EDUCATION` varchar(255) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
