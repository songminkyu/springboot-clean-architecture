CREATE TABLE IF NOT EXISTS `user`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `user_name` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `address` VARCHAR(255) NOT NULL,
    `admin` BOOL NOT NULL,
    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL,
    PRIMARY KEY (`id`))ENGINE=InnoDB DEFAULT CHARSET=utf8;
