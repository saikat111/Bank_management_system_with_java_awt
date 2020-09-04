-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2019 at 07:48 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `account`
--

-- --------------------------------------------------------

--
-- Table structure for table `accountinfo`
--

CREATE TABLE `accountinfo` (
  `sno` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `nid` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `accountno` varchar(50) NOT NULL,
  `cardno` varchar(50) NOT NULL,
  `any` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accountinfo`
--

INSERT INTO `accountinfo` (`sno`, `name`, `nid`, `address`, `email`, `accountno`, `cardno`, `any`) VALUES
(1, 'rakib', '54654', 'tmss', 'mafiacode20@gmail.com', '544452180', '561018338', '543435'),
(2, 'saikat', '65465462', 'bogra', 'mafiacode20@gmail.com', '355619932', '292469907', '4534435'),
(3, 'al rakin', '546516', 'bogra', 'mafiacode20@gmail.com', '232962115', '246875790', '435435453'),
(4, 'al rakib sorder', '545652652', 'bogra bangladesh', 'mafiacode20@gmail.com', '795676677', '296928778', '455343'),
(5, 'FVSDV', '63453', 'fxghdxzhj', 'mafiacode20@gmail.com', '766920754', '836875426', '5363'),
(6, 'SHAT', '6546', 'AFD', 'mafiacode20@gmail.com', '115948578', '153343641', '150'),
(7, 'x', '64654', 'jdcnkj', 'mafiacode20@gmail.com', '55555', '666666', '1015000'),
(9, 'soder saikat', '6969', 'bogra', 'mafiacode20@gmail.com', '753399960', '763565226', '2400'),
(10, 'umma kulsom nahar', '1234567889', 'tmsss, bogra', 'mafiacode20@gmail.com', '1979093391', '768620351', '500100'),
(11, 'qegqe', '85456', 'kjsabcjhb', 'mafiacode20@gmail.com', '15321566', '44035189', '500'),
(12, 'qegqe', '85456', 'kjsabcjhb', 'mafiacode20@gmail.com', '385302064', '445735253', '500');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accountinfo`
--
ALTER TABLE `accountinfo`
  ADD PRIMARY KEY (`sno`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accountinfo`
--
ALTER TABLE `accountinfo`
  MODIFY `sno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
