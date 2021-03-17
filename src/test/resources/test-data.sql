INSERT INTO `plane_processtype` VALUES (1,'Taxi ankomst','00:12:00','00:10:00','00:15:00',NULL),(2,'Passagerer ud','00:05:00','00:10:00','00:15:00',NULL),(3,'Bagage ud','00:10:00','00:15:00','00:20:00',NULL),(4,'Brændstof påfyldning','00:10:00','00:20:00','00:30:00',NULL),(5,'Rengøring / Vareopfyldning','00:30:00','00:40:00','01:00:00',NULL),(6,'Bagage ind','00:15:00','00:25:00','00:35:00',NULL),(7,'Passagerer ind','00:15:00','00:20:00','00:35:00',NULL),(8,'Taxi afgang','00:10:00','00:10:00','00:10:00',NULL),(9,'Personale til/fra naboplads','00:00:00','00:00:00','00:00:00',NULL),(10,'Personale til/fra øvrige i samme terminal','00:05:00','00:05:00','00:05:00',NULL),(11,'Personale til/fra anden terminal','00:10:00','00:10:00','00:10:00',NULL),(13,'Taxi til & fra ventepladser','00:08:00','00:05:00','00:05:00',NULL);

INSERT INTO `role` VALUES (1,'Lufthavns administration'),(2,'Flyveleder - jordkontrol'),(3,'Flyveleder - luftkontrol'),(4,'Flyselskaber'),(5,'Bagagehåndtering'),(6,'Rengøring'),(7,'Brændstofpåfyldning'),(8,'Taxi');

INSERT INTO `User` VALUES (2,'123','hans',1),(3,'123','jeppe',2),(4,'123','sigurd',3),(5,'123','bo',4),(6,'123','anne',5),(7,'123','hugo',6),(8,'123','mani',7),(9,'123','jonas',8);

--
-- Dumping data for table `airport_name`
--
INSERT INTO `airport_name` VALUES (1,'Aarhus','Denmark','AAR'),(2,'Abadan','Iran','ABD'),(3,'Abeche','Chad','AEH');

--
-- Dumping data for table `arrival`
--
INSERT INTO `arrival` VALUES (1,'2019-09-19','D8 3563 ','00:10:00','73H','AAR ',0),(2,'2019-09-19','JTG360  ','00:10:00','73H','ABD ',0),(3,'2019-09-19','SK 9250 ','00:10:00','CR9','AEH',0),(4,'2019-09-19','SK 1546 ','00:35:00','CR9','ABD',0);

--
-- Dumping data for table `departure`
--

INSERT INTO `departure` VALUES (1,'2019-09-19','SU 2497 ','00:10:00','73H','AAR',0),(2,'2019-09-19','QY 179','02:35:00','75V','ABD',0),(3,'2019-09-19','QY 3848 ','05:30:00','73P','AEH',0),(4,'2019-09-19','QY 3264 ','05:40:00','ABY','ABD',0);

--
-- Dumping data for table `gate`
--

INSERT INTO `terminal` VALUES (1,'Terminal 1'),(2,'Terminal 2'),(3,'Terminal 3');

INSERT INTO `gate` VALUES (1,2,'M'),(2,2,'M'),(3,2,'L'),(4,2,'L'),(5,2,'L'),(6,2,'L'),(7,2,'L'),(8,2,'L'),(9,2,'H'),(10,2,'H'),(11,2,'H'),(12,2,'H'),(15,3,'M'),(16,3,'M'),(17,3,'L'),(18,3,'L'),(19,3,'L'),(20,3,'L'),(21,3,'L'),(22,3,'L'),(23,3,'H'),(24,3,'H'),(25,3,'H'),(26,3,'H');

--
-- Dumping data for table `plane`
--

INSERT INTO `plane` VALUES ('100','Fokker 100','M'),('141','BAe 146-100 Pax','M'),('142','BAe 146-200 Pax','M');

--
-- Dumping data for table `terminal`
--

