create database jv_crm;

CREATE TABLE employees(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	last_name VARCHAR(30) NOT NULL,
	first_name VARCHAR(30) NOT NULL,
	position VARCHAR(30) NOT NULL,
	office VARCHAR(30) NOT NULL,
	start_date TIMESTAMP NOT NULL,
	salary VARCHAR(30) NOT NULL
);
/*---------------------------------------------------------*/

INSERT INTO `jv_crm`.`employees` (`id`, `last_name`, `first_name`, `position`, `office`, `start_date`, `salary`) 
VALUES (NULL, 'Ramos', 'Angelica', 'Chief Executive Officer (CEO)', 'London', '2014-06-08', '$1,200,000');

INSERT INTO `jv_crm`.`employees` (`id`, `last_name`, `first_name`, `position`, `office`, `start_date`, `salary`) 
VALUES (NULL, 'Satou', 'Airi', 'Accountant', 'Tokyo', '2013-06-08', '$162,700');

INSERT INTO `jv_crm`.`employees` (`id`, `last_name`, `first_name`, `position`, `office`, `start_date`, `salary`) 
VALUES (NULL, 'Cox', 'Ashton', 'Junior Technical Author', 'San Francisco', '2013-02-08', '$86,000');

INSERT INTO `jv_crm`.`employees` (`id`, `last_name`, `first_name`, `position`, `office`, `start_date`, `salary`) 
VALUES (NULL, 'Greer', 'Bradley', 'Software Engineer', 'London', '2013-02-08', '$132,000');

INSERT INTO `jv_crm`.`employees` (`id`, `last_name`, `first_name`, `position`, `office`, `start_date`, `salary`) 
VALUES (NULL, 'Wagner', 'Brenden', 'Software Engineer', 'San Francisco', '2012-02-08', '$106,000');

INSERT INTO `jv_crm`.`employees` (`id`, `last_name`, `first_name`, `position`, `office`, `start_date`, `salary`) 
VALUES (NULL, 'Williamson', 'Brielle', 'Integration Specialist', 'New York', '2011-02-08', '$136,000');

INSERT INTO `jv_crm`.`employees` (`id`, `last_name`, `first_name`, `position`, `office`, `start_date`, `salary`) 
VALUES (NULL, 'Nash', 'Bruno', 'Software Engineer', 'London', '2013-07-08', '$101,000');

INSERT INTO `jv_crm`.`employees` (`id`, `last_name`, `first_name`, `position`, `office`, `start_date`, `salary`) 
VALUES (NULL, 'Vance', 'Caesar', 'Pre-Sales Support', 'New York', '2013-02-08', '$96,000');

INSERT INTO `jv_crm`.`employees` (`id`, `last_name`, `first_name`, `position`, `office`, `start_date`, `salary`) 
VALUES (NULL, 'Stevens', 'Cara', 'Sales Assistant', 'New York', '2013-02-08', '$96,000');

INSERT INTO `jv_crm`.`employees` (`id`, `last_name`, `first_name`, `position`, `office`, `start_date`, `salary`) 
VALUES (NULL, 'Kelly', 'Cedric', 'Senior Javascript  Developer', 'Edinburgh', '2013-02-08', '$96,000');


/*---------------------------------------------------------*/
INSERT INTO `jv_crm`.`employees` (`id`, `last_name`, `first_name`, `position`, `office`, `start_date`, `salary`) 
VALUES (NULL, 'testLast', 'testFirst', 'testPosition', 'testOffice', CURRENT_TIMESTAMP, '$100,000');

INSERT INTO `jv_crm`.`employees` (`id`, `last_name`, `first_name`, `position`, `office`, `start_date`, `salary`) 
VALUES (NULL, 'superName', 'superF', 'position', 'office', CURRENT_TIMESTAMP, '$120,000');

/*---------------------------------------------------------*/
INSERT INTO `jv_crm`.`employees` (`id`, `last_name`, `first_name`, `position`, `office`, `start_date`, `salary`) 
VALUES (NULL, 'eeee?', 'cio', 'cio', 'cio', NOW(), '2');		

/*-------All this update make the same result-------------*/
UPDATE  `employees` SET position =  'testPosition :)' WHERE id =  '22';
UPDATE employees SET position =  'testPosition :)' WHERE id =  '21';
UPDATE  `jv_crm`.`employees` SET  `salary` =  '$100,000' WHERE  `employees`.`id` =22;


table employee
id
last_name
first_name
position_id
office_id
start_date
salary
+ edit
+ update
+ delete

/*---------------------------------------------------------*/
SELECT `position`, count(*) AS `count` FROM `employees` GROUP BY `position`
SELECT `position`, MAX(`salary`) AS `max_salary`, count(*) AS `count` FROM `employees` GROUP BY `position`
SELECT `position`, MIN(`salary`) AS `min_salary`, MAX(`salary`) AS `max_salary`, count(*) AS `count` FROM `employees` GROUP BY `position`
UPDATE `employees` SET `salary`=FLOOR(RAND() * 500) WHERE 1

SELECT 
	`position`, 
	AVG(`salary`) AS `avg_salary`, 
	MIN(`salary`) AS `min_salary`, 
	MAX(`salary`) AS `max_salary`, 
	count(*) AS `count` 
FROM `employees` GROUP BY `position`

http://dev.mysql.com/doc/refman/5.0/en/group-by-functions.html#function_avg

/*---------------------------------------------------------*/







