CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `picture_url` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB
AUTO_INCREMENT=1
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_turkish_ci;

--
-- Data for table `employee`
--

    INSERT INTO `book` (`id`, `title`, `author`, `picture_url`) VALUES
    (1, 'Sefiller', 'Victor Hugo', 'sefiller.jpg'),
    (2, 'Suç ve Ceza', 'Fyodor Dostoyevski', 'suc_ve_ceza.jpg'),
    (3, '1984', 'George Orwell', '1984.jpg'),
    (4, 'Kürk Mantolu Madonna', 'Sabahattin Ali', 'kurk_mantolu_madonna.jpg'),
    (5, 'Simyacı', 'Paulo Coelho', 'simyaci.jpg');


