/******************************
* Table for represent placess *
******************************/

CREATE TABLE IF NOT EXISTS `places`(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(30) NOT NULL,
  `departament`VARCHAR(30) NOT NULL,
  `province` VARCHAR(30) NOT NULL,
  created_at TIMESTAMP NULL,
  updated_at TIMESTAMP NULL,
  PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

/******************************
* Table for represent centers *
******************************/

CREATE TABLE IF NOT EXISTS `centers`(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `city` INT NOT NULL,
  created_at TIMESTAMP NULL,
  updated_at TIMESTAMP NULL,
  PRIMARY KEY(`id`),
  KEY `FK_CENTERS_1` (`city`),
  CONSTRAINT `FK_CENTERS_1`  FOREIGN KEY (`city`) REFERENCES `places` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

/******************************
* Table for represent doctors *
******************************/
-- CREATE TABLE ;

CREATE TABLE IF NOT EXISTS `doctors`(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*****************************
* Table for represent people *
*****************************/

CREATE TABLE IF NOT EXISTS `people`(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `DNI` INT (11) NOT NULL UNIQUE,
  `lastName` VARCHAR(40) NOT NULL,
  `firstName` VARCHAR(40) default NULL,
  `birthDay` DATE NOT NULL,
  `age` INT NOT NULL,
  `city` INT NOT NULL,
  created_at TIMESTAMP NULL,
  updated_at TIMESTAMP NULL,
  PRIMARY KEY(`id`),
  KEY `FK_PEOPLE_1` (`city`),
  CONSTRAINT `FK_PEOPLE_1`  FOREIGN KEY (`city`) REFERENCES `places` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

/************************************************
* Table for represents phones numbers of people *
************************************************/

CREATE TABLE IF NOT EXISTS `phones`(
  `id` INT(11) NOT NULL,
  `p` VARCHAR(15) NOT NULL,
  `pf` VARCHAR(15) NOT NULL,
  created_at TIMESTAMP NULL,
  updated_at TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PHONE_1` (`id`),
  CONSTRAINT `FK_PHONE_1` FOREIGN KEY (`id`) REFERENCES `people` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


/*********************************
* Table for represent companions *
*********************************/

CREATE TABLE IF NOT EXISTS `companions`(
  `id` INT(11) NOT NULL,
  created_at TIMESTAMP NULL,
  updated_at TIMESTAMP NULL,
  PRIMARY KEY(`id`),
  KEY `FK_COMPANIONS_1` (`id`),
  CONSTRAINT `FK_COMPANIONS_1` FOREIGN KEY (`id`) REFERENCES `people` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


/******************************
* Table for represent mothers *
******************************/

CREATE TABLE IF NOT EXISTS `mTel2`(
  `id` INT(11) NOT NULL,
  `phone` VARCHAR(15) NOT NULL,
  `pFamily` VARCHAR(15) NOT NULL,
  created_at TIMESTAMP NULL,
  updated_at TIMESTAMP NULL,
  KEY `FK_mTel2_1` (`id`),
  CONSTRAINT `FK_mTel2_1` FOREIGN KEY (`id`) REFERENCES `people` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `mothers`(
  `id` INT(11) NOT NULL,
  `educLevel` ENUM('Analfabeta','Primario_incompleto',
    'Primario_completo','Secundario_incompleto',
    'Secundario_completo','Otro'
  )NOT NULL,
  `job` ENUM('Ama_de_casa','Empleada','Cuentapropista',
    'Changarin','Desempleada'
  ) NOT NULL,
  `address` VARCHAR(40) NOT NULL,
  `numSons` INT NOT NULL,
  `numFamily` INT NOT NULL,
  `GP` INT(11) NOT NULL,
  `medCenter` INT(11) NOT NULL,
  created_at TIMESTAMP NULL,
  updated_at TIMESTAMP NULL,
  PRIMARY KEY(`id`),
  KEY `FK_MOTHERS_1` (`id`),
  CONSTRAINT `FK_MOTHERS_1` FOREIGN KEY (`id`) REFERENCES `people` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE,
  KEY `FK_MOTHERS_3` (`GP`),
  CONSTRAINT `FK_MOTHERS_3` FOREIGN KEY (`GP`) REFERENCES `doctors` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE,
  KEY `FK_MOTHERS_4` (`medCenter`),
  CONSTRAINT `FK_MOTHERS_4` FOREIGN KEY (`medCenter`) REFERENCES `centers` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

/****************************
* Table for represent birth *
****************************/

CREATE TABLE IF NOT EXISTS `births` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idMom` INT(11) NOT NULL,
  `idSon`INT(11) NOT NULL,
  `birth` BOOLEAN NOT NULL,
  `gestWeek` INT(2) NOT NULL,
  `pregControl` BOOLEAN NOT NULL,
  `tBirth` ENUM('Espontaneo', 'Asistido', 'Cesarea') NOT NULL,
  `birthWeigth` INT NOT NULL,
  `placesBirth` INT(11) NOT NULL,
  `medCenter` INT(11) NOT NULL,
  `idMed` INT(11) NOT NULL,
  created_at TIMESTAMP NULL,
  updated_at TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  KEY `FK_BIRTHS_1` (`idMom`),
  CONSTRAINT `FK_BIRTHS_1` FOREIGN KEY (`idMom`) REFERENCES `people` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE,
  KEY `FK_BIRTHS_2` (`idSon`),
  CONSTRAINT `FK_BIRTHS_2` FOREIGN KEY (`idSon`) REFERENCES `people` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE,
  KEY `FK_BIRTHS_3` (`placesBirth`),
  CONSTRAINT `FK_BIRTHS_3` FOREIGN KEY (`placesBirth`) REFERENCES `places` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE,
  KEY `FK_BIRTHS_4` (`medCenter`),
  CONSTRAINT `FK_BIRTHS_4` FOREIGN KEY (`medCenter`) REFERENCES `centers` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE,
  KEY `FK_MOTHERS_5` (`idMed`),
  CONSTRAINT `FK_BIRTHS_5` FOREIGN KEY (`idMed`) REFERENCES `doctors` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET=latin1;


/***************************
* Table for represent Sons *
***************************/

CREATE TABLE IF NOT EXISTS `children`(
  `id` INT(11) NOT NULL,
  `hospit` ENUM('Neonatologia','UTI','UCI') NOT NULL,
  `reasonHospit` VARCHAR(140) NOT NULL,
  `previousHospit` BOOLEAN NOT NULL,
  `datepreviousHospit` DATE,
  `reasonpreviousHospit` VARCHAR(140),
  `GP` INT(11) NOT NULL, -- General Practioner
  `medCenter` INT(11) NOT NULL,
  created_at TIMESTAMP NULL,
  updated_at TIMESTAMP NULL,
  PRIMARY KEY(`id`),
  KEY `FK_CHILDREN_1` (`id`),
  CONSTRAINT `FK_CHILDREN_1` FOREIGN KEY (`id`) REFERENCES `people` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  KEY `FK_CHILDREN_2` (`GP`),
  CONSTRAINT `FK_CHILDREN_2` FOREIGN KEY (`GP`) REFERENCES `doctors` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  KEY `FK_CHILDREN_3` (`medCenter`),
  CONSTRAINT `FK_CHILDREN_3` FOREIGN KEY (`medCenter`) REFERENCES `centers` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

/**********************************
* Table for represent derivations *
**********************************/

CREATE TABLE IF NOT EXISTS `derivations`(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idMom` INT(11) NOT NULL,
  `idMed` INT NOT NULL,
  `medCenter` INT NOT NULL,
  created_at TIMESTAMP NULL,
  updated_at TIMESTAMP NULL,
  PRIMARY KEY(`id`),
  KEY `FK_DERIVATIONS_1` (`idMom`),
  CONSTRAINT `FK_DERIVATIONS_1` FOREIGN KEY (`idMom`) REFERENCES `people` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE,
  KEY `FK_DERIVATIONS_2` (`idMed`),
  CONSTRAINT `FK_DERIVATIONS_2` FOREIGN KEY (`idMed`) REFERENCES `doctors` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE,
  KEY `FK_DERIVATIONS_3` (`medCenter`),
  CONSTRAINT `FK_DERIVATIONS_3` FOREIGN KEY (`medCenter`) REFERENCES `centers` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


/******************************
* Table for represent incomes *
******************************/

CREATE TABLE IF NOT EXISTS `incomes`(
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `idMom` INT NOT NULL,
  `reasonHospit` ENUM('ControlEmbarazo','Parto','ControlHijo','InterHijo')  NOT NULL,
  `idSon` INT,
  `companions` BOOLEAN NOT NULL,
  `idComp`INT,
  `registrant` VARCHAR(25) NOT NULL,
  created_at TIMESTAMP NULL,
  updated_at TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  KEY `FK_INCOMES_1` (`idMom`),
  CONSTRAINT `FK_INCOMES_1` FOREIGN KEY (`idMom`) REFERENCES `people` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE,
  KEY `FK_INCOMES_2` (`idSon`),
  CONSTRAINT `FK_INCOMES_2` FOREIGN KEY (`idSon`) REFERENCES `people` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE,
  KEY `FK_INCOMES_3` (`idComp`),
  CONSTRAINT `FK_INCOMES_3` FOREIGN KEY (`idComp`) REFERENCES `companions` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


/*****************************
* Table for represent egress *
*****************************/

CREATE TABLE IF NOT EXISTS `egress`(
  `incNum` INT NOT NULL,
  `duration` INT NOT NULL,
  `lactation` ENUM('Total','Complementaria'),
  `deliveryItems` BOOLEAN NOT NULL,
  `paid` BOOLEAN NOT NULL,
  `psychoAssis` BOOLEAN NOT NULL,
  `talks` ENUM('Lactancia', 'CADA', 'Alta_Segura', 'RCP', 'At._Temp'),
  `registrant` VARCHAR(25) NOT NULL,
  `Son` BOOLEAN,
  `pendingControl` DATE,
  created_at TIMESTAMP NULL,
  updated_at TIMESTAMP NULL,
  PRIMARY KEY (`incNum`),
  KEY `FK_EGRESS_1` (`incNum`),
  CONSTRAINT `FK_EGRESS_1` FOREIGN KEY (`incNum`) REFERENCES `incomes` (`id`)
  ON DELETE NO ACTION
  ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
