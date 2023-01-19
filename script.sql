CREATE DATABASE `providers` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `providers`.`provider` (
  `idProvider` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `dischargeDate` date DEFAULT NULL,
  `idClient` int DEFAULT NULL,
  PRIMARY KEY (`idProvider`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `providers`.`provider`
(`idProvider`,
`name`,
`dischargeDate`,
`idClient`)
VALUES
(1,
"Cocacola",
"2012-12-31",
5),
(2,
"Pepsi",
"2013-12-31",
5),
(3,
"Redbull",
"2014-12-31",
6);