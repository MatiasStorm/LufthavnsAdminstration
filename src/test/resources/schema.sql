--
-- Table structure for table `role`
--
DROP TABLE IF EXISTS `User`;
DROP TABLE IF EXISTS `gate`;
DROP TABLE IF EXISTS `plane_processing`;

DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `terminal`;
DROP TABLE IF EXISTS `arrival`;
DROP TABLE IF EXISTS `departure`;
DROP TABLE IF EXISTS `airport_name`;
DROP TABLE IF EXISTS `plane_processtype`;
DROP TABLE IF EXISTS `plane`;

CREATE TABLE `role` (
                        `role_id` int NOT NULL AUTO_INCREMENT,
                        `role_name` varchar(45) NOT NULL,
                        PRIMARY KEY (`role_id`)
) ;

--
-- Table structure for table `terminal`
--
CREATE TABLE `terminal` (
                            `terminal_id` int NOT NULL,
                            `terminal_name` varchar(45) NOT NULL,
                            PRIMARY KEY (`terminal_id`)
) ;

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_password` varchar(45) NOT NULL,
  `user_username` varchar(45) NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_too_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ;

CREATE TABLE `airport_name` (
  `airport_id` bigint NOT NULL AUTO_INCREMENT,
  `city_airport` varchar(70) NOT NULL,
  `country` varchar(45) NOT NULL,
  `iata_code` char(3) NOT NULL,
  PRIMARY KEY (`airport_id`)
) ;

--
-- Table structure for table `arrival`
--

CREATE TABLE `arrival` (
  `arrival_id` int NOT NULL AUTO_INCREMENT,
  `arrival_date` date NOT NULL,
  `route_number` varchar(45) NOT NULL,
  `arrival_time` time NOT NULL,
  `arrival_ac` char(3) NOT NULL,
  `arrival_destination` varchar(45) NOT NULL,
  `is_arrived` tinyint NOT NULL,
  PRIMARY KEY (`arrival_id`)
) ;

--
-- Table structure for table `departure`
--

CREATE TABLE `departure` (
  `departure_id` int NOT NULL AUTO_INCREMENT,
  `departure_date` date NOT NULL,
  `route_number` varchar(45) NOT NULL,
  `departure_time` time NOT NULL,
  `departure_ac` char(3)  DEFAULT NULL,
  `departure_destination` varchar(45) NOT NULL,
  `is_departed` tinyint NOT NULL,
  PRIMARY KEY (`departure_id`)
) ;

--
-- Table structure for table `gate`
--

CREATE TABLE `gate` (
  `number` int NOT NULL,
  `terminal_id` int NOT NULL,
  `gate_size` char(1) NOT NULL,
  PRIMARY KEY (`number`),
  CONSTRAINT `gate_too_terminal_id` FOREIGN KEY (`terminal_id`) REFERENCES `terminal` (`terminal_id`)
) ;

--
-- Table structure for table `plane`
--

CREATE TABLE `plane` (
  `iata` char(3)  NOT NULL,
  `type` varchar(70) NOT NULL,
  `size` varchar(5) NOT NULL,
  PRIMARY KEY (`iata`)
) ;

--
-- Table structure for table `plane_processtype`
--

CREATE TABLE `plane_processtype` (
                 `work_id` int NOT NULL AUTO_INCREMENT,
                 `work_type` varchar(45) NOT NULL,
                 `time_small` time NOT NULL,
                 `time_standard` time NOT NULL,
                 `time_large` time NOT NULL,
                 `depends_on` int DEFAULT NULL,
                 PRIMARY KEY (`work_id`)
) ;

--
-- Table structure for table `plane_processing`
--

CREATE TABLE `plane_processing` (
  `plane_processing_id` int NOT NULL AUTO_INCREMENT,
  `work_id` int NOT NULL,
  `departure_id` int NOT NULL,
  `start` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  PRIMARY KEY (`plane_processing_id`),
  CONSTRAINT `plane_processing_too_plane_processtype_work_id` FOREIGN KEY (`work_id`) REFERENCES `plane_processtype` (`work_id`)
) ;



