CREATE TABLE IF NOT EXISTS `account` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `phone_number` varchar(20) NOT NULL,
    `valid` TINYINT(1) DEFAULT 0
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;