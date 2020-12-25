CREATE DATABASE  IF NOT EXISTS `reportintelligence` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `reportintelligence`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: reportintelligence
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `application_details`
--

DROP TABLE IF EXISTS `application_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `application_details` (
  `project_name` varchar(64) DEFAULT NULL,
  `application_id` varchar(100) NOT NULL,
  `application_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`application_id`),
  KEY `inx_application_details_application_id` (`application_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bug_details`
--

DROP TABLE IF EXISTS `bug_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bug_details` (
  `parent_bug` varchar(64) NOT NULL,
  `child_bug` varchar(64) NOT NULL,
  `bug_priority` int(11) DEFAULT NULL,
  `application_id` varchar(100) NOT NULL,
  `bug_id` varchar(125) NOT NULL,
  `child_bug_abbreviation` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`bug_id`),
  KEY `inx_Bug_Details_child_bug` (`child_bug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `defect_details`
--

DROP TABLE IF EXISTS `defect_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `defect_details` (
  `tc_name` longtext NOT NULL,
  `error_msg` longtext NOT NULL,
  `comment` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `favoriteapp_details`
--

DROP TABLE IF EXISTS `favoriteapp_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `favoriteapp_details` (
  `appID` varchar(100) NOT NULL,
  `hostname` varchar(100) NOT NULL,
  PRIMARY KEY (`hostname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `job_details`
--

DROP TABLE IF EXISTS `job_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `job_details` (
  `job_name` varchar(100) NOT NULL,
  `application_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`job_name`),
  KEY `inx_job_details_job_id` (`job_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `keyword_details`
--

DROP TABLE IF EXISTS `keyword_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `keyword_details` (
  `error_pattern` varchar(500) DEFAULT NULL,
  `bugtype` varchar(64) NOT NULL,
  `error_id` varchar(60) NOT NULL,
  `application_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`error_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `run_details`
--

DROP TABLE IF EXISTS `run_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `run_details` (
  `job_name` varchar(100) NOT NULL,
  `run_id` varchar(100) NOT NULL,
  `run_name` varchar(45) DEFAULT NULL,
  `starttime` timestamp NULL DEFAULT NULL,
  `endtime` timestamp NULL DEFAULT NULL,
  `duration` varchar(45) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `passed` int(11) DEFAULT NULL,
  `failed` int(11) DEFAULT NULL,
  `notexecuted` int(11) DEFAULT NULL,
  `platform` varchar(64) DEFAULT NULL,
  `tool` varchar(64) DEFAULT NULL,
  `environment` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`run_id`),
  KEY `inx_run_details_run_id` (`run_id`),
  KEY `fk_job_name_idx` (`job_name`),
  CONSTRAINT `fk_job_name` FOREIGN KEY (`job_name`) REFERENCES `job_details` (`job_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `step_details`
--

DROP TABLE IF EXISTS `step_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `step_details` (
  `tc_id` varchar(500) NOT NULL,
  `step_no` int(11) NOT NULL,
  `executed_time` time NOT NULL,
  `action` longtext,
  `step_status` varchar(64) DEFAULT NULL,
  `screenshot_path` longtext,
  `screenshot` mediumblob,
  `failure_type` varchar(45) DEFAULT NULL,
  KEY `fk_tc_id_idx` (`tc_id`),
  KEY `inx_stepdetails_action` (`action`(255))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tc_details`
--

DROP TABLE IF EXISTS `tc_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tc_details` (
  `run_id` varchar(100) NOT NULL,
  `modulename` varchar(300) NOT NULL,
  `tc_id` varchar(500) NOT NULL,
  `tc_name` longtext,
  `starttime` timestamp NULL DEFAULT NULL,
  `endtime` timestamp NULL DEFAULT NULL,
  `duration` varchar(64) DEFAULT NULL,
  `tc_status` varchar(64) DEFAULT NULL,
  `error_msg` longtext,
  `bug_type` varchar(64) DEFAULT NULL,
  `comment` longtext,
  PRIMARY KEY (`tc_id`),
  KEY `inx_tc_details_tc_id` (`tc_id`),
  KEY `fk_run_id_idx` (`run_id`),
  KEY `fk_bug_type_idx` (`bug_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'reportintelligence'
--
/*!50003 DROP PROCEDURE IF EXISTS `insert_application_details` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_application_details`(
	IN 	project_name varchar(64),
    IN  application_id varchar(100),
    IN application_name varchar(64)
)
BEGIN
	insert into 

reportintelligence.application_details 
    values (project_name,application_id,application_name);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_bug_details` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_bug_details`(
	IN  parent_bug  varchar(64)  , 
	IN  child_bug   varchar(64)  , 
	IN  bug_priority  int(11)  , 
	IN  application_id  varchar(100)  , 
	IN  bug_id varchar(125) ,
	IN  child_bug_abbreviation  varchar(10)  

)
BEGIN
	insert reportintelligence.bug_details
    values (parent_bug, child_bug, bug_priority, application_id, bug_id, child_bug_abbreviation);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_favoriteapp_details` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_favoriteapp_details`(
	IN	app_ID	varchar(100),
    IN	host_name varchar(100)
)
BEGIN
	insert into reportintelligence.favoriteapp_details
    values( app_ID , host_name );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_job_details` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_job_details`(
	IN job_name varchar(100) ,
	IN application_id varchar(100)
)
BEGIN
	insert into reportintelligence.job_details
    values (job_name, application_id);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_keyword_details` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_keyword_details`(
	IN  error_id   varchar(60)  , 
    IN  error_pattern  varchar(500)  , 
	IN  bugtype  varchar(64)  , 	
	IN  application_id  varchar(100)  

)
BEGIN
	

insert into reportintelligence.keyword_details
    values (error_pattern, bugtype, error_id, application_id);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_parentBug_details` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_parentBug_details`(
	IN parent_bug_ varchar(64),
    IN child_bug_ varchar(64)
)
BEGIN
	insert reportintelligence.bug_details
    (parent_bug,child_bug) 
    values 

(parent_bug_,child_bug_);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_release_details` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_release_details`(
	IN  release_   varchar(45)  , 
	IN  start_date  date  , 
	IN  end_date  date  
)
BEGIN 
	insert into reportintelligence.release_details
    values

(release_,start_date,end_date); 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_release_job_details` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_release_job_details`(
	IN  release_   varchar(45) , 
	IN  jobname  varchar(45)  
)
BEGIN
	insert into release_job_details
    values(release_,jobname);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_run_details` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_run_details`(
	IN job_name varchar(100) ,
	IN run_id varchar(100) ,
	IN run_name varchar(45) ,
	IN starttime timestamp ,
	IN endtime timestamp ,
	IN 

duration varchar(45) ,
	IN total int(11) ,
	IN passed int(11) ,
	IN failed int(11) ,
	IN notexecuted int(11) ,
	IN platform varchar(64) ,
	IN tool varchar(64) ,
	IN environment varchar(64)
)
BEGIN
	insert into reportintelligence.run_details 
    values (job_name,run_id, run_name, starttime, endtime, duration, total, 
			passed, failed, notexecuted, platform, tool, 

environment);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_step_details` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_step_details`(
	IN  tc_id   varchar(500)  , 
	IN  step_no  int(11)  , 
	IN  executed_time  time  , 
	IN  action_  longtext  , 
	IN  step_status  varchar(64)  , 
	

IN  screenshot_path  longtext  , 
	IN  screenshot  mediumblob  , 
	IN  failure_type  varchar(45)  
)
BEGIN
	insert into reportintelligence.step_details
    values 

(tc_id,step_no,executed_time,action_,step_status,screenshot_path,screenshot,failure_type);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_tc_details` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_tc_details`(
	IN  run_id   varchar(100)  , 
IN  modulename  varchar(300)  , 
IN  tc_id   varchar(500)  , 
IN  tc_name  longtext  , 
IN  starttime  timestamp  , 
IN  endtime  timestamp  , 
IN  duration  varchar(64)  , 
IN  tc_status  varchar(64)  , 
IN  error_msg  longtext  , 
IN  bug_type   varchar(64)  , 
IN  comments  longtext  
)
BEGIN
	insert into reportintelligence.tc_details
    values (run_id, modulename, tc_id, tc_name, starttime, endtime, duration, tc_status, error_msg, bug_type, comments);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-21 11:46:02
