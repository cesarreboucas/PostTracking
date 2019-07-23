-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 16, 2019 at 01:50 AM
-- Server version: 5.7.24
-- PHP Version: 7.2.14



/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `posttracking`
--
CREATE DATABASE IF NOT EXISTS `posttracking` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `posttracking`;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `emailAddress` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `zipCode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `active`, `address`, `city`, `emailAddress`, `firstName`, `lastName`, `phoneNumber`, `province`, `zipCode`) VALUES
(1, b'1', 'Castle Black', 'The Wall', 'jon.snow@winter.com', 'Jon', 'Snow', '123-456-7890', 'Westeros', 'S0o-F4R'),
(2, b'1', 'Winterfell', 'The North', 'ned.stark@winterfell.com', 'Ned', 'Stark', '898-569-6700', 'Westeros', 'P1P-0I3'),
(3, b'1', 'Winterfell', 'The North', 'catelyn.stark@winterfell.com', 'Catelyn', 'Stark', '898-569-6701', 'Westeros', 'P1P-0I3'),
(4, b'1', 'Winterfell', 'The North', 'robb.stark@winterfell.com', 'Robb', 'Stark', '898-569-6702', 'Westeros', 'P1P-0I3'),
(5, b'1', 'Winterfell', 'The North', 'sansa.stark@winterfell.com', 'Sansa', 'Stark', '898-569-6703', 'Westeros', 'P1P-0I3'),
(6, b'1', 'Winterfell', 'The North', 'arya.stark@winterfell.com', 'Arya', 'Stark', '898-569-6704', 'Westeros', 'P1P-0I3'),
(7, b'1', 'Winterfell', 'The North', 'brandon.stark@winterfell.com', 'Brandon', 'Stark', '898-569-6705', 'Westeros', 'P1P-0I3'),
(8, b'1', 'Casterly Rock', 'The Reach', 'tyrion.lann@casterlyrock.com', 'Tyrion', 'Lannister', '605-284-5565', 'Westeros', 'M0N-3Y0'),
(9, b'1', 'Casterly Rock', 'The Reach', 'jaime.lann@casterlyrock.com', 'Jaime', 'Lannister', '605-284-5566', 'Westeros', 'M0N-3Y0'),
(10, b'1', 'Casterly Rock', 'The Reach', 'tyrion.lann@casterlyrock.com', 'Tyrion', 'Lannister', '605-284-5567', 'Westeros', 'M0N-3Y0'),
(11, b'1', 'Red Keep', 'King\'s Landing', 'robert.barat@kl.com', 'Robert', 'Baratheon', '620-146-8343', 'Westeros', 'K1N-0G0'),
(12, b'1', 'Red Keep', 'King\'s Landing', 'cersei@kl.com', 'Cersei', 'Baratheon', '620-146-8344', 'Westeros', 'K1N-0G0'),
(13, b'1', 'Red Keep', 'King\'s Landing', 'joffrey.barat@kl.com', 'Joffrey', 'Baratheon', '620-146-8345', 'Westeros', 'K1N-0G0'),
(14, b'1', 'Red Keep', 'King\'s Landing', 'myrcella.barat@kl.com', 'Myrcella', 'Baratheon', '620-146-8346', 'Westeros', 'K1N-0G0'),
(15, b'1', 'Red Keep', 'King\'s Landing', 'tommen.barat@kl.com', 'Tommen', 'Baratheon', '620-146-8347', 'Westeros', 'K1N-0G0'),
(16, b'1', 'Pyke Castle', 'Iron Lands', 'yara.greyjoy@ironlands.com', 'Yara', 'Greyjoy', '710-112-4220', 'The Sunset Sea', 'I3L-4N0'),
(17, b'1', 'Pyke Castle', 'Iron Lands', 'theon.greyjoy@ironlands.com', 'Theon', 'Greyjoy', '710-112-4221', 'The Sunset Sea', 'I3L-4N0'),
(18, b'1', 'Highgarden', 'The Reach', 'olenna.tyrell@highgarden.com', 'Olenna', 'Tyrell', '371-971-6380', 'Westeros', 'G4R-0e5'),
(19, b'1', 'Highgarden', 'The Reach', 'margaery.tyrell@highgarden.com', 'Margaery', 'Tyrell', '371-971-6381', 'Westeros', 'G4R-0e5'),
(20, b'1', 'Highgarden', 'The Reach', 'loras.tyrell@highgarden.com', 'Loras', 'Tyrell', '371-971-6382', 'Westeros', 'G4R-0e5'),
(21, b'1', 'Vaes Dothrak', 'Dothraki Sea', 'khal.drogo@dothraki.com', 'Khal', 'Drogo', '767-914-3600', 'Essos', 'D0T-H4K'),
(22, b'1', 'Vaes Dothrak', 'Dothraki Sea', 'dany.targ@dragons.com', 'Daenerys', 'Targaryen', '767-914-3601', 'Essos', 'D0T-H4K'),
(23, b'1', 'Vaes Dothrak', 'Dothraki Sea', 'viserys.targ@targ.com', 'Viserys', 'Targaryen', '767-914-3602', 'Essos', 'D0T-H4K'),
(24, b'1', 'Storm\'s End', 'The Stormlands', 'renly.barat@stormsend.com', 'Renly', 'Baratheon', '111-486-1930', 'Westeros', 'S1I-R5S'),
(25, b'1', 'Dragonstone Castle', 'Dragonstone', 'stannis.barat@dragonstone.com', 'Stannis', 'Baratheon', '890-897-4809', 'Blackwater Bay', 'D5A-6O2'),
(26, b'1', 'Riverrun', 'The Riverlands', 'brynden.tully@riverrun.com', 'Brynden', 'Tully', '205-933-7071', 'Westeros', 'V9G-4F6'),
(27, b'1', 'Riverrun', 'The Riverlands', 'edmure.tully@riverrun.com', 'Edmure', 'Tully', '205-933-7072', 'Westeros', 'V9G-4F6'),
(28, b'1', 'The Eyrie', 'Mountains of the Moon', 'jon.arryn@eyrie.com', 'Jon', 'Arryn', '349-877-4588', 'The Vale', 'V4L-E4E'),
(29, b'1', 'The Eyrie', 'Mountains of the Moon', 'lysa.arryn@eyrie.com', 'Lysa', 'Arryn', '349-877-4589', 'The Vale', 'V4L-E4E');

-- --------------------------------------------------------

--
-- Table structure for table `distribution_center`
--

DROP TABLE IF EXISTS `distribution_center`;
CREATE TABLE IF NOT EXISTS `distribution_center` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `zipCode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `distribution_center`
--

INSERT INTO `distribution_center` (`id`, `active`, `address`, `city`, `name`, `province`, `zipCode`) VALUES
(1, b'1', 'Street s', 'The North', 'Winterfell', 'Westeros', 'XNX NXN'),
(2, b'1', 'Street s', 'The Wall', 'Castle Black', 'Westeros', 'XNX NXN'),
(3, b'1', 'Street s', 'The Reach', 'Casterly Rock', 'Westeros', 'XNX NXN'),
(4, b'1', 'Street s', 'King\'s Landing', 'King\'s Landing', 'Westeros', 'XNX NXN'),
(5, b'1', 'Street s', 'The Stormlands', 'Storm\'s End', 'Westeros', 'XNX NXN'),
(6, b'1', 'Street s', 'Dragonstone', 'Dragonstone', 'Blackwater Bay', 'XNX NXN'),
(7, b'1', 'Street s', 'Iron Lands', 'Iron Lands', 'The Sunset Sea', 'XNX NXN'),
(8, b'1', 'Street s', 'The Reach', 'Highgarden', 'Westeros', 'XNX NXN'),
(9, b'1', 'Street s', 'The Riverlands', 'Riverrun', 'Westeros', 'XNX NXN'),
(10, b'1', 'UpperCitty s', 'Mountains of the Moon', 'The Eyrie', 'The Vale', 'XNX NXN'),
(11, b'1', 'WestCity s', 'Dothraki Sea', 'Vaes Dothrak', 'Essos', 'XNX NXN'),
(12, b'1', 'Street s', 'Westerlands', 'The Crag', 'Westeros', 'XNX NXN'),
(13, b'1', 'Street s', 'The Flatlands', 'Pentos', 'Essos', 'XNX NXN'),
(14, b'1', 'Street s', 'The Disputed Lands', 'Myr', 'Essos', 'XNX NXN'),
(15, b'1', 'Street s', 'Volantis', 'Volantis', 'Essos', 'XNX NXN'),
(16, b'1', 'Street s', 'Dothraki Sea', 'Mereen', 'Essos', 'XNX NXN'),
(17, b'1', 'Street s', 'Hills of Norvos', 'Norvos', 'Essos', 'XNX NXN'),
(18, b'1', 'Street s', 'Dothraki Sea', 'Vaes Khadokh', 'Essos', 'XNX NXN');

-- --------------------------------------------------------

--
-- Table structure for table `journey`
--

DROP TABLE IF EXISTS `journey`;
CREATE TABLE IF NOT EXISTS `journey` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available` bit(1) NOT NULL,
  `duration` int(11) NOT NULL,
  `restart` bigint(20) NOT NULL,
  `start` datetime DEFAULT NULL,
  `fk_destination` int(11) DEFAULT NULL,
  `fk_origin` int(11) DEFAULT NULL,
  `fk_vehicle` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKct0gk3mmpxo0ccp54jiyksavd` (`fk_destination`),
  KEY `FKjcsdtj8i3wjjlc01rhuv8rs9f` (`fk_origin`),
  KEY `FKense9jbyojyecvlghb6jlr9lt` (`fk_vehicle`)
) ENGINE=InnoDB AUTO_INCREMENT=188 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `journey`
--

INSERT INTO `journey` (`id`, `available`, `duration`, `restart`, `start`, `fk_destination`, `fk_origin`, `fk_vehicle`) VALUES
(1, b'1', 7200000, 86400000, '2019-05-17 03:00:00', 1, 2, 1),
(2, b'1', 7200000, 86400000, '2019-05-17 06:00:00', 2, 1, 1),
(3, b'1', 7200000, 86400000, '2019-05-17 03:00:00', 4, 1, 2),
(4, b'1', 7200000, 86400000, '2019-05-17 06:00:00', 1, 4, 2),
(5, b'1', 7200000, 86400000, '2019-05-17 03:00:00', 3, 8, 3),
(6, b'1', 7200000, 86400000, '2019-05-17 06:00:00', 4, 3, 3),
(7, b'1', 7200000, 86400000, '2019-05-17 09:00:00', 8, 4, 3),
(8, b'1', 7200000, 86400000, '2019-05-17 03:00:00', 9, 3, 4),
(9, b'1', 7200000, 86400000, '2019-05-17 06:00:00', 12, 9, 4),
(10, b'1', 7200000, 86400000, '2019-05-17 09:00:00', 3, 12, 4),
(11, b'1', 7200000, 86400000, '2019-05-17 03:00:00', 7, 12, 5),
(12, b'1', 7200000, 86400000, '2019-05-17 06:00:00', 12, 7, 5),
(13, b'1', 7200000, 86400000, '2019-05-17 03:00:00', 9, 10, 6),
(14, b'1', 7200000, 86400000, '2019-05-17 06:00:00', 4, 9, 6),
(15, b'1', 7200000, 86400000, '2019-05-17 09:00:00', 10, 4, 6),
(16, b'1', 7200000, 86400000, '2019-05-17 03:00:00', 8, 5, 7),
(17, b'1', 7200000, 86400000, '2019-05-17 06:00:00', 4, 8, 7),
(18, b'1', 7200000, 86400000, '2019-05-17 09:00:00', 5, 4, 7),
(19, b'1', 7200000, 86400000, '2019-05-17 03:00:00', 6, 4, 8),
(20, b'1', 7200000, 86400000, '2019-05-17 06:00:00', 13, 6, 8),
(21, b'1', 7200000, 86400000, '2019-05-17 09:00:00', 4, 13, 8),
(22, b'1', 7200000, 86400000, '2019-05-17 03:00:00', 14, 5, 9),
(23, b'1', 7200000, 86400000, '2019-05-17 06:00:00', 15, 14, 9),
(24, b'1', 7200000, 86400000, '2019-05-17 09:00:00', 5, 15, 9),
(25, b'1', 7200000, 86400000, '2019-05-17 03:00:00', 13, 14, 10),
(26, b'1', 7200000, 86400000, '2019-05-17 06:00:00', 15, 13, 10),
(27, b'1', 7200000, 86400000, '2019-05-17 09:00:00', 14, 15, 10),
(28, b'1', 7200000, 86400000, '2019-05-17 03:00:00', 16, 15, 11),
(29, b'1', 7200000, 86400000, '2019-05-17 06:00:00', 15, 16, 11),
(30, b'1', 7200000, 86400000, '2019-05-17 03:00:00', 11, 16, 12),
(31, b'1', 7200000, 86400000, '2019-05-17 06:00:00', 18, 11, 12),
(32, b'1', 7200000, 86400000, '2019-05-17 09:00:00', 16, 18, 12),
(33, b'1', 7200000, 86400000, '2019-05-17 03:00:00', 18, 11, 13),
(34, b'1', 7200000, 86400000, '2019-05-17 06:00:00', 11, 18, 13),
(35, b'1', 7200000, 86400000, '2019-05-17 03:00:00', 15, 18, 14),
(36, b'1', 7200000, 86400000, '2019-05-17 06:00:00', 17, 15, 14),
(37, b'1', 7200000, 86400000, '2019-05-17 09:00:00', 18, 17, 14),
(38, b'1', 7200000, 86400000, '2019-05-17 03:00:00', 17, 13, 15),
(39, b'1', 7200000, 86400000, '2019-05-17 06:00:00', 14, 17, 15),
(40, b'1', 7200000, 86400000, '2019-05-17 09:00:00', 13, 14, 15),
(41, b'1', 7200000, 86400000, '2019-05-17 03:00:00', 14, 6, 16),
(42, b'1', 7200000, 86400000, '2019-05-17 06:00:00', 4, 14, 16),
(43, b'1', 7200000, 86400000, '2019-05-17 09:00:00', 6, 4, 16),
(44, b'1', 7200000, 86400000, '2019-05-17 03:00:00', 10, 9, 17),
(45, b'1', 7200000, 86400000, '2019-05-17 06:00:00', 1, 10, 17),
(46, b'1', 7200000, 86400000, '2019-05-17 09:00:00', 9, 1, 17),
(47, b'1', 7200000, 86400000, '2019-07-16 06:00:00', 4, 3, 3),
(48, b'1', 7200000, 86400000, '2019-07-17 06:00:00', 1, 4, 2),
(49, b'1', 7200000, 86400000, '2019-07-16 09:00:00', 10, 4, 6),
(50, b'1', 7200000, 86400000, '2019-07-17 06:00:00', 1, 10, 17),
(51, b'1', 7200000, 86400000, '2019-07-16 03:00:00', 9, 3, 4),
(52, b'1', 7200000, 86400000, '2019-07-16 06:00:00', 4, 9, 6),
(53, b'1', 7200000, 86400000, '2019-07-17 03:00:00', 10, 9, 17),
(54, b'1', 7200000, 86400000, '2019-07-16 03:00:00', 4, 1, 2),
(55, b'1', 7200000, 86400000, '2019-07-16 09:00:00', 8, 4, 3),
(56, b'1', 7200000, 86400000, '2019-07-17 03:00:00', 3, 8, 3),
(57, b'1', 7200000, 86400000, '2019-07-16 09:00:00', 9, 1, 17),
(58, b'1', 7200000, 86400000, '2019-07-17 06:00:00', 12, 9, 4),
(59, b'1', 7200000, 86400000, '2019-07-17 09:00:00', 3, 12, 4),
(60, b'1', 7200000, 86400000, '2019-07-16 09:00:00', 5, 4, 7),
(61, b'1', 7200000, 86400000, '2019-07-17 03:00:00', 8, 5, 7),
(62, b'1', 7200000, 86400000, '2019-07-18 03:00:00', 3, 8, 3),
(63, b'1', 7200000, 86400000, '2019-07-17 06:00:00', 4, 9, 6),
(64, b'1', 7200000, 86400000, '2019-07-17 09:00:00', 8, 4, 3),
(65, b'1', 7200000, 86400000, '2019-07-17 03:00:00', 9, 10, 6),
(66, b'1', 7200000, 86400000, '2019-07-17 09:00:00', 5, 4, 7),
(67, b'1', 7200000, 86400000, '2019-07-18 03:00:00', 8, 5, 7),
(68, b'1', 7200000, 86400000, '2019-07-19 03:00:00', 3, 8, 3),
(69, b'1', 7200000, 86400000, '2019-07-17 03:00:00', 6, 4, 8),
(70, b'1', 7200000, 86400000, '2019-07-17 06:00:00', 13, 6, 8),
(71, b'1', 7200000, 86400000, '2019-07-18 06:00:00', 15, 13, 10),
(72, b'1', 7200000, 86400000, '2019-07-18 09:00:00', 5, 15, 9),
(73, b'1', 7200000, 86400000, '2019-07-19 03:00:00', 8, 5, 7),
(74, b'1', 7200000, 86400000, '2019-07-20 03:00:00', 3, 8, 3),
(75, b'1', 7200000, 86400000, '2019-07-18 03:00:00', 14, 6, 16),
(76, b'1', 7200000, 86400000, '2019-07-18 06:00:00', 15, 14, 9),
(77, b'1', 7200000, 86400000, '2019-07-16 09:00:00', 6, 4, 16),
(78, b'1', 7200000, 86400000, '2019-07-17 03:00:00', 14, 6, 16),
(79, b'1', 7200000, 86400000, '2019-07-17 06:00:00', 15, 14, 9),
(80, b'1', 7200000, 86400000, '2019-07-17 09:00:00', 5, 15, 9),
(81, b'1', 7200000, 86400000, '2019-07-19 03:00:00', 13, 14, 10),
(82, b'1', 7200000, 86400000, '2019-07-19 06:00:00', 15, 13, 10),
(83, b'1', 7200000, 86400000, '2019-07-19 09:00:00', 5, 15, 9),
(84, b'1', 7200000, 86400000, '2019-07-20 03:00:00', 8, 5, 7),
(85, b'1', 7200000, 86400000, '2019-07-21 03:00:00', 3, 8, 3),
(86, b'1', 7200000, 86400000, '2019-07-18 09:00:00', 13, 14, 15),
(87, b'1', 7200000, 86400000, '2019-07-18 03:00:00', 13, 14, 10),
(88, b'1', 7200000, 86400000, '2019-07-17 09:00:00', 13, 14, 15),
(89, b'1', 7200000, 86400000, '2019-07-18 03:00:00', 6, 4, 8),
(90, b'1', 7200000, 86400000, '2019-07-18 06:00:00', 13, 6, 8),
(91, b'1', 7200000, 86400000, '2019-07-19 03:00:00', 14, 6, 16),
(92, b'1', 7200000, 86400000, '2019-07-19 06:00:00', 15, 14, 9),
(93, b'1', 7200000, 86400000, '2019-07-17 09:00:00', 6, 4, 16),
(94, b'1', 7200000, 86400000, '2019-07-18 03:00:00', 17, 13, 15),
(95, b'1', 7200000, 86400000, '2019-07-18 09:00:00', 18, 17, 14),
(96, b'1', 7200000, 86400000, '2019-07-19 03:00:00', 15, 18, 14),
(97, b'1', 7200000, 86400000, '2019-07-18 06:00:00', 14, 17, 15),
(98, b'1', 7200000, 86400000, '2019-07-20 03:00:00', 13, 14, 10),
(99, b'1', 7200000, 86400000, '2019-07-20 06:00:00', 15, 13, 10),
(100, b'1', 7200000, 86400000, '2019-07-20 09:00:00', 5, 15, 9),
(101, b'1', 7200000, 86400000, '2019-07-21 03:00:00', 8, 5, 7),
(102, b'1', 7200000, 86400000, '2019-07-22 03:00:00', 3, 8, 3),
(103, b'1', 7200000, 86400000, '2019-07-19 09:00:00', 13, 14, 15),
(104, b'1', 7200000, 86400000, '2019-07-19 09:00:00', 16, 18, 12),
(105, b'1', 7200000, 86400000, '2019-07-20 06:00:00', 15, 16, 11),
(106, b'1', 7200000, 86400000, '2019-07-20 03:00:00', 17, 13, 15),
(107, b'1', 7200000, 86400000, '2019-07-20 09:00:00', 18, 17, 14),
(108, b'1', 7200000, 86400000, '2019-07-21 03:00:00', 15, 18, 14),
(109, b'1', 7200000, 86400000, '2019-07-21 09:00:00', 5, 15, 9),
(110, b'1', 7200000, 86400000, '2019-07-22 03:00:00', 8, 5, 7),
(111, b'1', 7200000, 86400000, '2019-07-23 03:00:00', 3, 8, 3),
(112, b'1', 7200000, 86400000, '2019-07-19 03:00:00', 17, 13, 15),
(113, b'1', 7200000, 86400000, '2019-07-19 09:00:00', 18, 17, 14),
(114, b'1', 7200000, 86400000, '2019-07-20 03:00:00', 15, 18, 14),
(115, b'1', 7200000, 86400000, '2019-07-19 06:00:00', 14, 17, 15),
(116, b'1', 7200000, 86400000, '2019-07-20 06:00:00', 15, 14, 9),
(117, b'1', 7200000, 86400000, '2019-07-21 09:00:00', 16, 18, 12),
(118, b'1', 7200000, 86400000, '2019-07-22 06:00:00', 15, 16, 11),
(119, b'1', 7200000, 86400000, '2019-07-22 09:00:00', 5, 15, 9),
(120, b'1', 7200000, 86400000, '2019-07-23 03:00:00', 8, 5, 7),
(121, b'1', 7200000, 86400000, '2019-07-24 03:00:00', 3, 8, 3),
(122, b'1', 7200000, 86400000, '2019-07-20 09:00:00', 16, 18, 12),
(123, b'1', 7200000, 86400000, '2019-07-21 06:00:00', 15, 16, 11),
(124, b'1', 7200000, 86400000, '2019-07-21 03:00:00', 17, 13, 15),
(125, b'1', 7200000, 86400000, '2019-07-21 09:00:00', 18, 17, 14),
(126, b'1', 7200000, 86400000, '2019-07-22 03:00:00', 15, 18, 14),
(127, b'1', 7200000, 86400000, '2019-07-22 09:00:00', 16, 18, 12),
(128, b'1', 7200000, 86400000, '2019-07-23 06:00:00', 15, 16, 11),
(129, b'1', 7200000, 86400000, '2019-07-23 09:00:00', 5, 15, 9),
(130, b'1', 7200000, 86400000, '2019-07-24 03:00:00', 8, 5, 7),
(131, b'1', 7200000, 86400000, '2019-07-25 03:00:00', 3, 8, 3),
(132, b'1', 7200000, 86400000, '2019-07-18 06:00:00', 4, 3, 3),
(133, b'1', 7200000, 86400000, '2019-07-17 06:00:00', 4, 3, 3),
(134, b'1', 7200000, 86400000, '2019-07-17 09:00:00', 10, 4, 6),
(135, b'1', 7200000, 86400000, '2019-07-18 06:00:00', 1, 10, 17),
(136, b'1', 7200000, 86400000, '2019-07-18 06:00:00', 1, 4, 2),
(137, b'1', 7200000, 86400000, '2019-07-17 03:00:00', 14, 5, 9),
(138, b'1', 7200000, 86400000, '2019-07-18 03:00:00', 4, 1, 2),
(139, b'1', 7200000, 86400000, '2019-07-18 03:00:00', 14, 5, 9),
(140, b'1', 7200000, 86400000, '2019-07-19 03:00:00', 6, 4, 8),
(141, b'1', 7200000, 86400000, '2019-07-20 03:00:00', 14, 6, 16),
(142, b'1', 7200000, 86400000, '2019-07-18 09:00:00', 6, 4, 16),
(143, b'1', 7200000, 86400000, '2019-07-18 09:00:00', 5, 4, 7),
(144, b'1', 7200000, 86400000, '2019-07-19 03:00:00', 14, 5, 9),
(145, b'1', 7200000, 86400000, '2019-07-21 03:00:00', 13, 14, 10),
(146, b'1', 7200000, 86400000, '2019-07-20 09:00:00', 13, 14, 15),
(147, b'1', 7200000, 86400000, '2019-07-19 06:00:00', 13, 6, 8),
(148, b'1', 7200000, 86400000, '2019-07-20 06:00:00', 14, 17, 15),
(149, b'1', 7200000, 86400000, '2019-07-21 06:00:00', 15, 14, 9),
(150, b'1', 7200000, 86400000, '2019-07-22 03:00:00', 17, 13, 15),
(151, b'1', 7200000, 86400000, '2019-07-22 09:00:00', 18, 17, 14),
(152, b'1', 7200000, 86400000, '2019-07-21 06:00:00', 15, 13, 10),
(153, b'1', 7200000, 86400000, '2019-07-23 03:00:00', 15, 18, 14),
(154, b'1', 7200000, 86400000, '2019-07-23 09:00:00', 16, 18, 12),
(155, b'1', 7200000, 86400000, '2019-07-24 06:00:00', 15, 16, 11),
(156, b'1', 7200000, 86400000, '2019-07-18 03:00:00', 16, 15, 11),
(157, b'1', 7200000, 86400000, '2019-07-18 03:00:00', 11, 16, 12),
(158, b'1', 7200000, 86400000, '2019-07-19 03:00:00', 16, 15, 11),
(159, b'1', 7200000, 86400000, '2019-07-19 03:00:00', 11, 16, 12),
(160, b'1', 7200000, 86400000, '2019-07-19 06:00:00', 11, 18, 13),
(161, b'1', 7200000, 86400000, '2019-07-20 03:00:00', 11, 16, 12),
(162, b'1', 7200000, 86400000, '2019-07-18 06:00:00', 17, 15, 14),
(163, b'1', 7200000, 86400000, '2019-07-17 09:00:00', 18, 17, 14),
(164, b'1', 7200000, 86400000, '2019-07-18 06:00:00', 11, 18, 13),
(165, b'1', 7200000, 86400000, '2019-07-20 06:00:00', 11, 18, 13),
(166, b'1', 7200000, 86400000, '2019-07-19 06:00:00', 17, 15, 14),
(167, b'1', 7200000, 86400000, '2019-07-20 03:00:00', 16, 15, 11),
(168, b'1', 7200000, 86400000, '2019-07-21 06:00:00', 11, 18, 13),
(169, b'1', 7200000, 86400000, '2019-07-21 03:00:00', 11, 16, 12),
(170, b'1', 7200000, 86400000, '2019-07-20 06:00:00', 17, 15, 14),
(171, b'1', 7200000, 86400000, '2019-07-22 03:00:00', 11, 16, 12),
(172, b'1', 7200000, 86400000, '2019-07-21 03:00:00', 16, 15, 11),
(173, b'1', 7200000, 86400000, '2019-07-22 03:00:00', 16, 15, 11),
(174, b'1', 7200000, 86400000, '2019-07-23 03:00:00', 11, 16, 12),
(175, b'1', 7200000, 86400000, '2019-07-22 06:00:00', 11, 18, 13),
(176, b'1', 7200000, 86400000, '2019-07-21 06:00:00', 17, 15, 14),
(177, b'1', 7200000, 86400000, '2019-07-23 06:00:00', 11, 18, 13),
(178, b'1', 7200000, 86400000, '2019-07-22 06:00:00', 17, 15, 14),
(179, b'1', 7200000, 86400000, '2019-07-24 03:00:00', 11, 16, 12),
(180, b'1', 7200000, 86400000, '2019-07-23 03:00:00', 16, 15, 11),
(181, b'1', 7200000, 86400000, '2019-07-24 03:00:00', 16, 15, 11),
(182, b'1', 7200000, 86400000, '2019-07-16 06:00:00', 12, 9, 4),
(183, b'1', 7200000, 86400000, '2019-07-17 03:00:00', 7, 12, 5),
(184, b'1', 7200000, 86400000, '2019-07-17 09:00:00', 9, 1, 17),
(185, b'1', 7200000, 86400000, '2019-07-18 06:00:00', 12, 9, 4),
(186, b'1', 7200000, 86400000, '2019-07-18 03:00:00', 7, 12, 5),
(187, b'1', 7200000, 86400000, '2019-07-19 03:00:00', 7, 12, 5);

-- --------------------------------------------------------

--
-- Table structure for table `package`
--

DROP TABLE IF EXISTS `package`;
CREATE TABLE IF NOT EXISTS `package` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `recipient` varchar(255) DEFAULT NULL,
  `volume` double NOT NULL,
  `weight` double NOT NULL,
  `zipCode` varchar(255) DEFAULT NULL,
  `fk_customer` int(11) DEFAULT NULL,
  `fk_destination` int(11) DEFAULT NULL,
  `fk_origin` int(11) DEFAULT NULL,
  `fk_position` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsh69b5k14x2f4an6xctuka5k5` (`fk_customer`),
  KEY `FKh3wyv976g879o5mufnuxsmea` (`fk_destination`),
  KEY `FK82hnylegmfbkwocg4ld8rrtrr` (`fk_origin`),
  KEY `FKt2kqm8gc471olgcl4c8gljuv8` (`fk_position`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `package`
--

INSERT INTO `package` (`id`, `address`, `city`, `province`, `recipient`, `volume`, `weight`, `zipCode`, `fk_customer`, `fk_destination`, `fk_origin`, `fk_position`) VALUES
(1, '', '', '', '', 59, 59, '', 1, 1, 3, 3),
(2, '', '', '', '', 70, 70, '', 2, 1, 3, 3),
(3, '', '', '', '', 90, 90, '', 5, 1, 3, 3),
(4, '', '', '', '', 38, 38, '', 1, 1, 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `package_journey`
--

DROP TABLE IF EXISTS `package_journey`;
CREATE TABLE IF NOT EXISTS `package_journey` (
  `journey_id` bigint(20) NOT NULL,
  `package_id` int(11) NOT NULL,
  PRIMARY KEY (`package_id`,`journey_id`),
  KEY `FK27p0cukm89seo24mkl6o1c6lk` (`journey_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `package_journey`
--

INSERT INTO `package_journey` (`journey_id`, `package_id`) VALUES
(47, 1),
(47, 2),
(47, 3),
(47, 4),
(49, 1),
(49, 2),
(49, 3),
(49, 4),
(50, 1),
(50, 2),
(50, 3),
(50, 4);

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
CREATE TABLE IF NOT EXISTS `route` (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`id`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(16),
(17),
(18),
(19),
(20),
(21),
(22),
(23),
(24),
(25),
(26),
(27),
(28),
(29),
(30),
(31),
(32),
(33),
(34),
(35),
(36),
(37),
(38),
(39),
(40),
(41),
(42),
(43),
(44),
(45),
(46);

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE IF NOT EXISTS `vehicle` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `available` bit(1) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `maxVolume` int(11) NOT NULL,
  `maxWeight` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`Id`, `available`, `description`, `maxVolume`, `maxWeight`) VALUES
(1, b'1', 'Frederiksborg Horse', 2500, 2500),
(2, b'1', 'Mustang Horse', 2500, 2500),
(3, b'1', 'Shire Horse', 2500, 2500),
(4, b'1', 'Samolaco Horse', 2500, 2500),
(5, b'1', 'Salty Sea Mare Ship', 1000000, 1000000),
(6, b'1', 'Mangalarga Horse', 2500, 2500),
(7, b'1', 'Dongola Horse', 2500, 2500),
(8, b'1', 'Sea Queen Ship', 1000000, 1000000),
(9, b'1', 'Aurora Ship', 1000000, 1000000),
(10, b'1', 'Haflinger Horse', 2500, 2500),
(11, b'1', 'Giara Horse', 2500, 2500),
(12, b'1', 'Karabair Horse', 2500, 2500),
(13, b'1', 'Pampa Horse', 2500, 2500),
(14, b'1', 'Appaloosa Horse', 2500, 2500),
(15, b'1', 'Campolina Horse', 2500, 2500),
(16, b'1', 'Ghost Ship', 1000000, 1000000),
(17, b'1', 'Spiti Horse', 2500, 2500);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `journey`
--
ALTER TABLE `journey`
  ADD CONSTRAINT `FKct0gk3mmpxo0ccp54jiyksavd` FOREIGN KEY (`fk_destination`) REFERENCES `distribution_center` (`id`),
  ADD CONSTRAINT `FKense9jbyojyecvlghb6jlr9lt` FOREIGN KEY (`fk_vehicle`) REFERENCES `vehicle` (`Id`),
  ADD CONSTRAINT `FKjcsdtj8i3wjjlc01rhuv8rs9f` FOREIGN KEY (`fk_origin`) REFERENCES `distribution_center` (`id`);

--
-- Constraints for table `package`
--
ALTER TABLE `package`
  ADD CONSTRAINT `FK82hnylegmfbkwocg4ld8rrtrr` FOREIGN KEY (`fk_origin`) REFERENCES `distribution_center` (`id`),
  ADD CONSTRAINT `FKh3wyv976g879o5mufnuxsmea` FOREIGN KEY (`fk_destination`) REFERENCES `distribution_center` (`id`),
  ADD CONSTRAINT `FKsh69b5k14x2f4an6xctuka5k5` FOREIGN KEY (`fk_customer`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `FKt2kqm8gc471olgcl4c8gljuv8` FOREIGN KEY (`fk_position`) REFERENCES `distribution_center` (`id`);

--
-- Constraints for table `package_journey`
--
ALTER TABLE `package_journey`
  ADD CONSTRAINT `FK27p0cukm89seo24mkl6o1c6lk` FOREIGN KEY (`journey_id`) REFERENCES `journey` (`id`),
  ADD CONSTRAINT `FKmavu8wvjgiwc939vrwyvid86e` FOREIGN KEY (`package_id`) REFERENCES `package` (`id`);

--
-- Constraints for table `route`
--
ALTER TABLE `route`
  ADD CONSTRAINT `FKboa145fespa2urvs9vm040qrv` FOREIGN KEY (`id`) REFERENCES `journey` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
