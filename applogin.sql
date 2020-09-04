-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2019 at 07:49 PM
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
-- Database: `applogin`
--

-- --------------------------------------------------------

--
-- Table structure for table `logindatabase`
--

CREATE TABLE `logindatabase` (
  `sno` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `keyu` varchar(50) NOT NULL,
  `id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `logindatabase`
--

INSERT INTO `logindatabase` (`sno`, `username`, `password`, `keyu`, `id`) VALUES
(1, 'rakib', '2019', '20018', '13'),
(12, 'al rakib sorder saikat', 'saikat22', '489375969', '420'),
(13, 'rock star', '1445', '28905596', '14'),
(14, 'al rakib sorder saikat', '111', '302457038', '999'),
(15, 'kulsom', '123', '731436989', '56562'),
(16, 'omor', '444', '924134470', '654654'),
(17, 'k;jihip', '6546', '714806107', '689464'),
(18, 'k;jihip', '6546', '122772513', '689464'),
(19, 'khgfyuf', 'jhgkyj', '421885187', '6545645'),
(20, 'shiam', '1234', '354612602', '4211');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `logindatabase`
--
ALTER TABLE `logindatabase`
  ADD PRIMARY KEY (`sno`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `logindatabase`
--
ALTER TABLE `logindatabase`
  MODIFY `sno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
