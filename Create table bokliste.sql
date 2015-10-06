-- Database: `pg3100`
-- --------------------------------------------------------

-- Create table `bokliste`
CREATE TABLE IF NOT EXISTS `bokliste` (
	`isbn` char(20),
	`forfatter` char(20),
	`tittel` char(80),
	PRIMARY KEY (isbn)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Insert data for table `bokliste`
INSERT INTO `bokliste` (`isbn`, `forfatter`, `tittel`) VALUES
	('111-62-74-96761-2', 'JAMES JOYCE', 'ULYSSES'),
	('142-17-64-87689-9', 'BERTHA M. CLARK', 'GENERAL SCIENCE'),
	('367-52-28-62634-6', 'EDGAR ALLAN POE', 'BEST OF'),
	('468-49-82-16489-8', 'HENRY ERNEST DUDENEY', 'AMUSEMENTS IN MATHEMATICS'),
	('564-52-28-12334-6', 'ERLEND LOE', 'DOPPLER'),
	('613-98-83-55929-1', 'JANE AUSTEN', 'PRIDE AND PREJUDICE'),
	('723-91-79-15133-7', 'EDWARD R. SHAW', 'DISCOVERERS AND EXPLORERS');