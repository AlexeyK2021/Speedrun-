-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tea_ind
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tea_ind
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tea_ind` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `tea_ind` ;

-- -----------------------------------------------------
-- Table `tea_ind`.`equipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tea_ind`.`equipment` (
  `id_equip` INT NOT NULL AUTO_INCREMENT,
  `name_equip` TEXT NOT NULL,
  `serial_num_equip` TEXT NOT NULL,
  PRIMARY KEY (`id_equip`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tea_ind`.`current_params`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tea_ind`.`current_params` (
  `id_cur_param` INT NOT NULL AUTO_INCREMENT,
  `name_cur_param` TEXT NOT NULL,
  `value_cur_param` FLOAT NOT NULL,
  `equip_id` INT NOT NULL,
  PRIMARY KEY (`id_cur_param`),
  INDEX `equip_id` (`equip_id` ASC) VISIBLE,
  CONSTRAINT `current_params_ibfk_1`
    FOREIGN KEY (`equip_id`)
    REFERENCES `tea_ind`.`equipment` (`id_equip`))
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tea_ind`.`deviations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tea_ind`.`deviations` (
  `id_deviation` INT NOT NULL AUTO_INCREMENT,
  `value_dev` FLOAT NULL DEFAULT NULL,
  `cur_param_id` INT NOT NULL,
  PRIMARY KEY (`id_deviation`),
  INDEX `cur_param_id` (`cur_param_id` ASC) VISIBLE,
  CONSTRAINT `deviations_ibfk_1`
    FOREIGN KEY (`cur_param_id`)
    REFERENCES `tea_ind`.`current_params` (`id_cur_param`))
ENGINE = InnoDB
AUTO_INCREMENT = 30
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tea_ind`.`jobtitles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tea_ind`.`jobtitles` (
  `id_jobtitle` INT NOT NULL,
  `describe_jobtitle` TEXT NOT NULL,
  `name_jobtitle` TEXT NOT NULL,
  PRIMARY KEY (`id_jobtitle`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tea_ind`.`type_log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tea_ind`.`type_log` (
  `id_type_log` INT NOT NULL,
  `name_log` TEXT NOT NULL,
  `describe_log` TEXT NOT NULL,
  PRIMARY KEY (`id_type_log`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tea_ind`.`logi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tea_ind`.`logi` (
  `id_log` INT NOT NULL AUTO_INCREMENT,
  `datetime_log` DATETIME NOT NULL,
  `deviation_id` INT NOT NULL,
  `type_log_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_log`),
  INDEX `deviation_id` (`deviation_id` ASC) VISIBLE,
  INDEX `type_log_id` (`type_log_id` ASC) VISIBLE,
  CONSTRAINT `logi_ibfk_3`
    FOREIGN KEY (`deviation_id`)
    REFERENCES `tea_ind`.`deviations` (`id_deviation`),
  CONSTRAINT `logi_ibfk_4`
    FOREIGN KEY (`type_log_id`)
    REFERENCES `tea_ind`.`type_log` (`id_type_log`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tea_ind`.`type_param`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tea_ind`.`type_param` (
  `id_type_param` INT NOT NULL,
  `name_type_param` TEXT NOT NULL,
  `equip_id` INT NOT NULL,
  PRIMARY KEY (`id_type_param`),
  INDEX `equip_id_idx` (`equip_id` ASC) VISIBLE,
  CONSTRAINT `type_param_ibfk_1`
    FOREIGN KEY (`equip_id`)
    REFERENCES `tea_ind`.`equipment` (`id_equip`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tea_ind`.`reference_params_tech`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tea_ind`.`reference_params_tech` (
  `id_ref_equip` INT NOT NULL,
  `name_ref_equip` TEXT NOT NULL,
  `describe_ref_equip` TEXT NOT NULL,
  `value_ref_equip` FLOAT NOT NULL,
  `type_param_id` INT NOT NULL,
  PRIMARY KEY (`id_ref_equip`),
  INDEX `type_param_id` (`type_param_id` ASC) VISIBLE,
  CONSTRAINT `reference_params_tech_ibfk_1`
    FOREIGN KEY (`type_param_id`)
    REFERENCES `tea_ind`.`type_param` (`id_type_param`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tea_ind`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tea_ind`.`roles` (
  `id_roles` INT NOT NULL,
  `name_role` TEXT NOT NULL,
  `describe_role` TEXT NOT NULL,
  PRIMARY KEY (`id_roles`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tea_ind`.`supplements`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tea_ind`.`supplements` (
  `id_supp` INT NOT NULL,
  `name_supp` TEXT NULL DEFAULT NULL,
  `decs_supp` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id_supp`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tea_ind`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tea_ind`.`users` (
  `id_user` INT NOT NULL,
  `name_user` VARCHAR(25) NOT NULL,
  `familyname_user` VARCHAR(25) NOT NULL,
  `surname_user` VARCHAR(25) NULL DEFAULT NULL,
  `jobtitle_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`id_user`),
  INDEX `jobtitle_id` (`jobtitle_id` ASC) VISIBLE,
  INDEX `role_id` (`role_id` ASC) VISIBLE,
  CONSTRAINT `users_ibfk_1`
    FOREIGN KEY (`jobtitle_id`)
    REFERENCES `tea_ind`.`jobtitles` (`id_jobtitle`),
  CONSTRAINT `users_ibfk_2`
    FOREIGN KEY (`role_id`)
    REFERENCES `tea_ind`.`roles` (`id_roles`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `tea_ind` ;

-- -----------------------------------------------------
-- function check_temperature
-- -----------------------------------------------------

DELIMITER $$
USE `tea_ind`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `check_temperature`(value_param FLOAT, name_equip TEXT) RETURNS int
BEGIN
declare ref float;
declare dev float;
declare temp INT;
declare datetime_now DATETIME;
SELECT sysdate() into datetime_now;
if (name_equip = 'Смеситель') then
	insert into current_params (name_cur_param, value_cur_param, equip_id) VALUES (
		'Температура', value_param, 1);
        select value_ref_equip into ref from reference_params_tech where id_ref_equip = '1';
select id_cur_param into temp from current_params order by id_cur_param DESC limit 1;
insert into deviations (value_dev, cur_param_id) VALUES (
	value_param - ref, temp);
    SELECT id_deviation into temp from deviations order by id_deviation DESC limit 1;
    SELECT value_dev into dev from deviations where id_deviation = temp;
if (dev > 20) then 
	insert into logi (datetime_log, type_log_id, deviation_id) VALUES (
    datetime_now, 3, temp);
elseif (dev < -20) then 
	insert into logi (datetime_log, type_log_id, deviation_id) VALUES (
    datetime_now, 4, temp);
else insert into logi (datetime_log, type_log_id, deviation_id) VALUES (
    datetime_now, 7, temp);
end if;

        
elseif(name_equip = 'Сироповарочный котел') then
	insert into current_params (name_cur_param, value_cur_param, equip_id) VALUES (
		'Температура', value_param, 5);
        select value_ref_equip into ref from reference_params_tech where id_ref_equip = '6';
select id_cur_param into temp from current_params order by id_cur_param DESC limit 1;
insert into deviations (value_dev, cur_param_id) VALUES (
	ref - value_param, temp);
    SELECT id_deviation into temp from deviations order by id_deviation DESC limit 1;
    SELECT value_dev into dev from deviations where id_deviation = temp;
if (dev > 25) then 
	insert into logi (datetime_log, type_log_id, deviation_id) VALUES (
    datetime_now, 3, temp);
elseif (dev < -25) then 
	insert into logi (datetime_log, type_log_id, deviation_id) VALUES (
    datetime_now, 4, temp);
else insert into logi (datetime_log, type_log_id, deviation_id) VALUES (
    datetime_now, 7, temp);
end if;
end if;
RETURN 1;
END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
