DROP TABLE IF EXISTS `regiao`;

CREATE TABLE `regiao` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_unique` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `sub_regiao`;

CREATE TABLE `sub_regiao` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regiao_id` int(10) unsigned DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_unique` (`nome`),
  KEY `fk_regiao_id` (`regiao_id`),
  CONSTRAINT `fk_regiao_id` FOREIGN KEY (`regiao_id`) REFERENCES `regiao` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `pais`;

CREATE TABLE `pais` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sub_regiao_id` int(10) unsigned DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `capital` varchar(100) DEFAULT NULL,
  `area` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_unique` (`nome`),
  KEY `fk_sub_regiao_id` (`sub_regiao_id`),
  CONSTRAINT `fk_sub_regiao_id` FOREIGN KEY (`sub_regiao_id`) REFERENCES `sub_regiao` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
