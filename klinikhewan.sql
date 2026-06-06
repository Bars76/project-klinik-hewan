-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 06, 2026 at 02:25 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `klinikhewan`
--

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE `dokter` (
  `id_dokter` int(11) NOT NULL,
  `nama_dokter` varchar(100) NOT NULL,
  `spesialis` varchar(100) DEFAULT NULL,
  `no_hp` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`id_dokter`, `nama_dokter`, `spesialis`, `no_hp`) VALUES
(1, 'Dr. Sinta', 'Kucing', '081234567890'),
(2, 'Dr. Rian', 'Anjing', '081298765432'),
(3, 'Dr. Maya', 'Kelinci', '081355667788'),
(4, 'Dr. Budi', 'Burung', '081377889900'),
(5, 'Dr. Dewi', 'Hamster', '081388990011'),
(6, 'Dr. Eko', 'Ikan', '081399001122'),
(7, 'Dr. Fajar', 'Ayam', '081311223344'),
(8, 'Dr. Gina', 'Reptil', '081322334455'),
(9, 'Dr. Hendra', 'Umum', '081333445566'),
(10, 'Dr. Indah', 'Kucing', '081344556677');

-- --------------------------------------------------------

--
-- Table structure for table `hewan`
--

CREATE TABLE `hewan` (
  `id_hewan` int(11) NOT NULL,
  `nama_hewan` varchar(100) DEFAULT NULL,
  `jenis` varchar(100) DEFAULT NULL,
  `umur` int(11) DEFAULT NULL,
  `pemilik` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hewan`
--

INSERT INTO `hewan` (`id_hewan`, `nama_hewan`, `jenis`, `umur`, `pemilik`) VALUES
(1, 'Milo', 'Kucing', 2, 'Andi Saputra'),
(2, 'Buddy', 'Anjing', 3, 'Budi Santoso'),
(3, 'Cici', 'Kelinci', 1, 'Citra Dewi'),
(4, 'Dodo', 'Burung', 4, 'Dian Permata'),
(5, 'Ella', 'Kucing', 5, 'Eko Prasetyo'),
(6, 'Fifi', 'Hamster', 1, 'Fajar Nugroho'),
(7, 'Gigi', 'Anjing', 2, 'Gina Lestari'),
(8, 'Hoki', 'Ikan', 1, 'Hendra Wijaya'),
(9, 'Ica', 'Kucing', 3, 'Indah Sari'),
(10, 'Jago', 'Ayam', 2, 'Joko Widodo');

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE `jadwal` (
  `id_jadwal` int(11) NOT NULL,
  `id_dokter` int(11) DEFAULT NULL,
  `id_hewan` int(11) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `jam` time DEFAULT NULL,
  `status` enum('Menunggu','Selesai','Dibatalkan') DEFAULT 'Menunggu',
  `keluhan` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jadwal`
--

INSERT INTO `jadwal` (`id_jadwal`, `id_dokter`, `id_hewan`, `tanggal`, `jam`, `status`, `keluhan`, `created_at`) VALUES
(1, 1, 1, '2026-06-10', '09:00:00', 'Menunggu', 'Demam dan batuk', '2026-06-05 23:57:00'),
(2, 2, 2, '2026-06-10', '10:30:00', 'Selesai', 'Luka di kaki', '2026-06-05 23:57:00'),
(3, 3, 3, '2026-06-11', '13:00:00', 'Dibatalkan', 'Pemilik membatalkan', '2026-06-05 23:57:00'),
(4, 4, 4, '2026-06-11', '14:30:00', 'Menunggu', 'Sayap patah', '2026-06-05 23:57:00'),
(5, 5, 6, '2026-06-12', '09:00:00', 'Menunggu', 'Keracunan makanan', '2026-06-05 23:57:00'),
(6, 6, 8, '2026-06-12', '11:00:00', 'Selesai', 'Kutu parah', '2026-06-05 23:57:00'),
(7, 7, 7, '2026-06-13', '08:30:00', 'Menunggu', 'Radang telinga', '2026-06-05 23:57:00'),
(8, 6, 8, '2026-06-13', '15:00:00', 'Dibatalkan', 'Jamur kulit', '2026-06-05 23:57:00'),
(9, 10, 9, '2026-06-14', '10:00:00', 'Menunggu', 'Diare', '2026-06-05 23:57:00'),
(10, 7, 10, '2026-06-14', '16:00:00', 'Selesai', 'Flu burung', '2026-06-05 23:57:00');

-- --------------------------------------------------------

--
-- Table structure for table `rekam_medis`
--

CREATE TABLE `rekam_medis` (
  `id_rekam` int(11) NOT NULL,
  `nama_hewan` varchar(100) DEFAULT NULL,
  `diagnosa` text DEFAULT NULL,
  `tindakan` text DEFAULT NULL,
  `obat` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rekam_medis`
--

INSERT INTO `rekam_medis` (`id_rekam`, `nama_hewan`, `diagnosa`, `tindakan`, `obat`) VALUES
(1, 'Milo', 'Demam dan batuk', 'Pemberian antibiotik', 'Amoksisilin 50mg'),
(2, 'Buddy', 'Luka di kaki', 'Pembersihan luka dan jahit', 'Betadine & Salep'),
(3, 'Cici', 'Mata merah', 'Tetes mata', 'Ofloxacin tetes'),
(4, 'Dodo', 'Sayap patah', 'Pemasangan bidai', 'Vitamin B kompleks'),
(5, 'Ella', 'Keracunan makanan', 'Pembersihan usus', 'Aktif charcoal'),
(6, 'Fifi', 'Kutu', 'Mandi obat', 'Frontline'),
(7, 'Gigi', 'Radang telinga', 'Pembersihan telinga', 'Otodex'),
(8, 'Hoki', 'Jamur kulit', 'Salep anti jamur', 'Ketoconazole'),
(9, 'Ica', 'Diare', 'Pemberian oralit', 'Probiotik'),
(10, 'Jago', 'Flu burung', 'Isolasi dan vitamin', 'Vitamin C & Antibiotik');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(20) DEFAULT 'Admin'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `role`) VALUES
(1, 'admin', 'admin123', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dokter`
--
ALTER TABLE `dokter`
  ADD PRIMARY KEY (`id_dokter`);

--
-- Indexes for table `hewan`
--
ALTER TABLE `hewan`
  ADD PRIMARY KEY (`id_hewan`);

--
-- Indexes for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD PRIMARY KEY (`id_jadwal`),
  ADD KEY `id_dokter` (`id_dokter`),
  ADD KEY `id_hewan` (`id_hewan`);

--
-- Indexes for table `rekam_medis`
--
ALTER TABLE `rekam_medis`
  ADD PRIMARY KEY (`id_rekam`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dokter`
--
ALTER TABLE `dokter`
  MODIFY `id_dokter` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `hewan`
--
ALTER TABLE `hewan`
  MODIFY `id_hewan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `jadwal`
--
ALTER TABLE `jadwal`
  MODIFY `id_jadwal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `rekam_medis`
--
ALTER TABLE `rekam_medis`
  MODIFY `id_rekam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD CONSTRAINT `jadwal_ibfk_1` FOREIGN KEY (`id_dokter`) REFERENCES `dokter` (`id_dokter`) ON DELETE CASCADE,
  ADD CONSTRAINT `jadwal_ibfk_2` FOREIGN KEY (`id_hewan`) REFERENCES `hewan` (`id_hewan`) ON DELETE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
