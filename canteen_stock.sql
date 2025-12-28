-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 26, 2025 at 04:45 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `canteen_stock`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `category` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `min_stock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `category`, `price`, `stock`, `min_stock`) VALUES
(4, 'pakora', 'fastfood', 10.00, 88, 20),
(8, 'samosa', 'snack', 30.00, 63, 8),
(9, 'kurkure', 'snacks', 30.00, 100, 5),
(10, 'cake', 'baked', 40.00, 90, 5),
(11, 'pepsi', 'cold drink', 85.00, 195, 10),
(12, 'cocacola', 'cold drink', 100.00, 120, 5);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `sale_date` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`id`, `product_id`, `quantity`, `total_price`, `sale_date`) VALUES
(1, 1, 2, 60.00, '2025-11-03 11:08:19'),
(2, 1, 2, 60.00, '2025-11-03 11:43:50'),
(3, 2, 1, 25.00, '2025-11-16 14:01:40'),
(4, 2, 1, 25.00, '2025-11-16 14:03:03'),
(5, 2, 1, 25.00, '2025-11-16 14:06:39'),
(6, 3, 2, 100.00, '2025-11-16 14:11:03'),
(7, 4, 4, 40.00, '2025-11-16 15:00:18'),
(8, 4, 4, 40.00, '2025-11-16 15:00:57'),
(9, 4, 2, 20.00, '2025-11-16 15:13:07'),
(10, 6, 3, 90.00, '2025-11-16 15:22:49'),
(11, 4, 2, 20.00, '2025-11-17 15:29:58'),
(12, 6, 3, 90.00, '2025-11-17 15:31:29'),
(13, 6, 3, 90.00, '2025-11-17 15:31:41'),
(14, 3, 1, 50.00, '2025-11-27 19:35:10'),
(15, 3, 1, 50.00, '2025-12-06 15:13:14'),
(16, 8, 5, 150.00, '2025-12-06 15:31:58'),
(17, 11, 5, 425.00, '2025-12-06 15:38:01');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
