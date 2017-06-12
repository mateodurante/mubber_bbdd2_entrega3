-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: mysql_bbdd2
-- Generation Time: Jun 12, 2017 at 09:10 PM
-- Server version: 5.6.36
-- PHP Version: 7.0.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `grupo23`
--
CREATE DATABASE IF NOT EXISTS `grupo23` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `grupo23`;

-- --------------------------------------------------------

--
-- Table structure for table `DRIVER`
--

DROP TABLE IF EXISTS `DRIVER`;
CREATE TABLE `DRIVER` (
  `IDUSER` bigint(20) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `ADMISSIONDATE` datetime DEFAULT NULL,
  `LICENCEEXPIRATION` datetime DEFAULT NULL,
  `IDMUBER` bigint(20) DEFAULT NULL,
  `drivers_ORDER` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `DRIVER`
--

INSERT INTO `DRIVER` (`IDUSER`, `USERNAME`, `PASSWORD`, `ADMISSIONDATE`, `LICENCEEXPIRATION`, `IDMUBER`, `drivers_ORDER`) VALUES
(15, 'roberto', 'redificil', '2017-06-12 18:10:12', '2020-03-20 00:00:00', NULL, NULL),
(17, 'abierto', 'redificil', '2017-06-12 18:10:12', '2020-03-20 00:00:00', NULL, NULL),
(19, 'agueda', 'facil', '2017-06-12 18:10:12', '2020-03-20 00:00:00', NULL, NULL),
(21, 'lihuen', 'redificil', '2017-06-12 18:10:12', '2018-05-22 00:00:00', NULL, NULL),
(22, 'cristian', 'redificil', '2017-06-12 18:10:12', '2020-03-20 00:00:00', NULL, NULL),
(23, 'tito', 'tito', '2017-06-12 18:10:12', '2021-03-21 00:00:00', NULL, NULL),
(24, 'daniel', 'redificil', '2017-06-12 18:10:12', '2020-03-20 00:00:00', NULL, NULL),
(25, 'barbaro', 'redificil', '2017-06-12 18:10:12', '2020-03-20 00:00:00', NULL, NULL),
(26, 'jonsnow', 'no sabes nada, amigo', '2017-06-12 18:10:12', '2020-03-20 00:00:00', NULL, NULL),
(27, 'thor', 'dame el martillo', '2017-06-12 18:10:12', '2020-03-20 00:00:00', NULL, NULL),
(28, 'loki', 'mucho', '2017-06-12 18:10:12', '2020-03-20 00:00:00', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `MUBER`
--

DROP TABLE IF EXISTS `MUBER`;
CREATE TABLE `MUBER` (
  `IDMUBER` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `PASSENGER`
--

DROP TABLE IF EXISTS `PASSENGER`;
CREATE TABLE `PASSENGER` (
  `IDUSER` bigint(20) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `ADMISSIONDATE` datetime DEFAULT NULL,
  `TOTALCREDIT` float DEFAULT NULL,
  `IDMUBER` bigint(20) DEFAULT NULL,
  `passengers_ORDER` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `PASSENGER`
--

INSERT INTO `PASSENGER` (`IDUSER`, `USERNAME`, `PASSWORD`, `ADMISSIONDATE`, `TOTALCREDIT`, `IDMUBER`, `passengers_ORDER`) VALUES
(16, 'german', 'ger', '2017-06-12 18:10:12', 15466.7, NULL, NULL),
(18, 'alicia', 'ali', '2017-06-12 18:10:12', 4566.67, NULL, NULL),
(20, 'margarita', 'mar', '2017-06-12 18:10:12', 3366.67, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `QUALIFICATION`
--

DROP TABLE IF EXISTS `QUALIFICATION`;
CREATE TABLE `QUALIFICATION` (
  `IDQUALIFICATION` bigint(20) NOT NULL,
  `POINTS` int(11) DEFAULT NULL,
  `COMMENT` varchar(255) DEFAULT NULL,
  `IDPASSENGER` bigint(20) DEFAULT NULL,
  `IDTRAVEL` bigint(20) DEFAULT NULL,
  `IDDRIVER` bigint(20) NOT NULL,
  `qualifications_ORDER` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `QUALIFICATION`
--

INSERT INTO `QUALIFICATION` (`IDQUALIFICATION`, `POINTS`, `COMMENT`, `IDPASSENGER`, `IDTRAVEL`, `IDDRIVER`, `qualifications_ORDER`) VALUES
(10, 4, 'los mates eran dulces', 20, 15, 21, 0),
(11, 2, 'todo bien pero el chofer durmio todo el viaje', 18, 16, 19, 0),
(12, 4, 'los mates eran dulces', 20, 14, 19, 1),
(13, 3, 'todo bien pero el chofer durmio todo el viaje', 18, 17, 22, 0),
(14, 1, 'viajamos solo, creo que le cabe la soledad', 16, 18, 23, 0),
(15, 5, 'alto viaje, me re cabio', 16, 19, 24, 0),
(16, 5, 'alto viaje, me re cabio', 16, 12, 15, 0),
(17, 4, 'todo bien pero el chofer durmio todo el viaje', 18, 12, 15, 1),
(18, 4, 'los mates eran dulces', 20, 12, 15, 2);

-- --------------------------------------------------------

--
-- Table structure for table `TRAVEL`
--

DROP TABLE IF EXISTS `TRAVEL`;
CREATE TABLE `TRAVEL` (
  `IDTRAVEL` bigint(20) NOT NULL,
  `DESTINY` varchar(255) DEFAULT NULL,
  `ORIGIN` varchar(255) DEFAULT NULL,
  `TOTALCOST` float DEFAULT NULL,
  `DATE` datetime DEFAULT NULL,
  `MAXPASSENGERS` int(11) DEFAULT NULL,
  `FINALIZED` bit(1) DEFAULT NULL,
  `IDDRIVER` bigint(20) DEFAULT NULL,
  `IDMUBER` bigint(20) DEFAULT NULL,
  `travels_ORDER` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `TRAVEL`
--

INSERT INTO `TRAVEL` (`IDTRAVEL`, `DESTINY`, `ORIGIN`, `TOTALCOST`, `DATE`, `MAXPASSENGERS`, `FINALIZED`, `IDDRIVER`, `IDMUBER`, `travels_ORDER`) VALUES
(12, 'Tres Arroyos', 'La Plata', 1900, '2017-06-12 18:10:12', 4, b'1', 15, NULL, 0),
(13, 'La Plata', 'Ensenada', 300, '2017-06-12 18:10:12', 3, b'0', 17, NULL, 0),
(14, 'Bariloche', 'Buenos Aires', 9000, '2017-06-12 18:10:12', 5, b'1', 19, NULL, 1),
(15, 'Tres Arroyos', 'La Plata', 2000, '2017-06-12 18:10:12', 6, b'1', 21, NULL, 0),
(16, 'El Pato', 'El Peligro', 800, '2017-06-12 18:10:12', 4, b'1', 19, NULL, 0),
(17, 'Bariloche', 'La Plata', 9000, '2017-06-12 18:10:12', 5, b'1', 22, NULL, 0),
(18, 'El Pato', 'El Peligro', 900, '2017-06-12 18:10:12', 4, b'1', 23, NULL, 0),
(19, 'Tres Arroyos', 'La Plata', 3000, '2017-06-12 18:10:12', 3, b'1', 24, NULL, 0),
(20, 'King\'s Landing', 'The Wall', 100000, '2017-06-12 18:10:12', 2, b'1', 26, NULL, 0),
(21, 'Montevideo', 'Buenos Aires', 100000, '2017-06-12 18:10:12', 3, b'1', 27, NULL, 0),
(22, 'Ragnarok', 'New York', 100000, '2017-06-12 18:10:12', 3, b'1', 28, NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `TRAVEL_PASSENGER`
--

DROP TABLE IF EXISTS `TRAVEL_PASSENGER`;
CREATE TABLE `TRAVEL_PASSENGER` (
  `IDTRAVEL` bigint(20) NOT NULL,
  `passengers_ORDER` int(11) NOT NULL DEFAULT '0',
  `IDPASSENGER` bigint(20) NOT NULL,
  `travels_ORDER` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `TRAVEL_PASSENGER`
--

INSERT INTO `TRAVEL_PASSENGER` (`IDTRAVEL`, `passengers_ORDER`, `IDPASSENGER`, `travels_ORDER`) VALUES
(12, 0, 16, NULL),
(12, 1, 18, NULL),
(12, 2, 20, NULL),
(13, 0, 16, NULL),
(13, 1, 18, NULL),
(13, 2, 20, NULL),
(14, 0, 20, NULL),
(15, 0, 20, NULL),
(16, 0, 18, NULL),
(17, 0, 18, NULL),
(18, 0, 16, NULL),
(19, 0, 16, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `DRIVER`
--
ALTER TABLE `DRIVER`
  ADD PRIMARY KEY (`IDUSER`),
  ADD KEY `FKl4ciu2jo4i0i4rxmfo4gume2v` (`IDMUBER`);

--
-- Indexes for table `MUBER`
--
ALTER TABLE `MUBER`
  ADD PRIMARY KEY (`IDMUBER`);

--
-- Indexes for table `PASSENGER`
--
ALTER TABLE `PASSENGER`
  ADD PRIMARY KEY (`IDUSER`),
  ADD KEY `FK473wmdqe7dh3ghhs096tl2gvn` (`IDMUBER`);

--
-- Indexes for table `QUALIFICATION`
--
ALTER TABLE `QUALIFICATION`
  ADD PRIMARY KEY (`IDQUALIFICATION`),
  ADD KEY `FKfvf2j6npcmir6gcgmmq26jxvt` (`IDPASSENGER`),
  ADD KEY `FKnnvdxh71ca68my3je2f1y5hka` (`IDTRAVEL`),
  ADD KEY `FKj5sp7ow48e8e70vi5pqm5lab7` (`IDDRIVER`);

--
-- Indexes for table `TRAVEL`
--
ALTER TABLE `TRAVEL`
  ADD PRIMARY KEY (`IDTRAVEL`),
  ADD KEY `FKekj5kvbqkva07vvr7npwffg8o` (`IDDRIVER`),
  ADD KEY `FK56yh0grvdu1m6kvs049cwfewb` (`IDMUBER`);

--
-- Indexes for table `TRAVEL_PASSENGER`
--
ALTER TABLE `TRAVEL_PASSENGER`
  ADD PRIMARY KEY (`IDTRAVEL`,`passengers_ORDER`),
  ADD KEY `FKk8mup0i01l64aw779cs60vvtp` (`IDPASSENGER`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `MUBER`
--
ALTER TABLE `MUBER`
  MODIFY `IDMUBER` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `QUALIFICATION`
--
ALTER TABLE `QUALIFICATION`
  MODIFY `IDQUALIFICATION` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `TRAVEL`
--
ALTER TABLE `TRAVEL`
  MODIFY `IDTRAVEL` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `DRIVER`
--
ALTER TABLE `DRIVER`
  ADD CONSTRAINT `FKl4ciu2jo4i0i4rxmfo4gume2v` FOREIGN KEY (`IDMUBER`) REFERENCES `MUBER` (`IDMUBER`);

--
-- Constraints for table `PASSENGER`
--
ALTER TABLE `PASSENGER`
  ADD CONSTRAINT `FK473wmdqe7dh3ghhs096tl2gvn` FOREIGN KEY (`IDMUBER`) REFERENCES `MUBER` (`IDMUBER`);

--
-- Constraints for table `QUALIFICATION`
--
ALTER TABLE `QUALIFICATION`
  ADD CONSTRAINT `FKfvf2j6npcmir6gcgmmq26jxvt` FOREIGN KEY (`IDPASSENGER`) REFERENCES `PASSENGER` (`IDUSER`),
  ADD CONSTRAINT `FKj5sp7ow48e8e70vi5pqm5lab7` FOREIGN KEY (`IDDRIVER`) REFERENCES `DRIVER` (`IDUSER`),
  ADD CONSTRAINT `FKnnvdxh71ca68my3je2f1y5hka` FOREIGN KEY (`IDTRAVEL`) REFERENCES `TRAVEL` (`IDTRAVEL`);

--
-- Constraints for table `TRAVEL`
--
ALTER TABLE `TRAVEL`
  ADD CONSTRAINT `FK56yh0grvdu1m6kvs049cwfewb` FOREIGN KEY (`IDMUBER`) REFERENCES `MUBER` (`IDMUBER`),
  ADD CONSTRAINT `FKekj5kvbqkva07vvr7npwffg8o` FOREIGN KEY (`IDDRIVER`) REFERENCES `DRIVER` (`IDUSER`);

--
-- Constraints for table `TRAVEL_PASSENGER`
--
ALTER TABLE `TRAVEL_PASSENGER`
  ADD CONSTRAINT `FK5oh7a4qps9xeukrnctgkra3c1` FOREIGN KEY (`IDTRAVEL`) REFERENCES `TRAVEL` (`IDTRAVEL`),
  ADD CONSTRAINT `FKk8mup0i01l64aw779cs60vvtp` FOREIGN KEY (`IDPASSENGER`) REFERENCES `PASSENGER` (`IDUSER`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
