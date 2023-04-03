DROP TABLE IF EXISTS answer;
DROP TABLE IF EXISTS gameinfo;
DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS quiz;




CREATE TABLE game(
	gameTitle varchar(255),
	gameCode varchar(255),
	primary key (gameCode)
);

CREATE TABLE quiz(
	quizId int NOT NULL AUTO_INCREMENT,
	gameCode varchar(255),
	num varchar(255),
	title varchar(255) NOT NULL,
	ex1 varchar(255),
	ex2 varchar(255),
	ex3 varchar(255),
	ex4 varchar(255),
	imageCode varchar(255),
	correct varchar(255),
	primary key (quizId),
	foreign key (gameCode) references game(gameCode)
);

CREATE TABLE answer(
	answerId int NOT NULL AUTO_INCREMENT,
	gameCode varchar(255),
	num varchar(255),
	answers varchar(255),
	primary key (answerId),
	foreign key (gameCode) references game(gameCode)
);

--
--CREATE TABLE game(
--	gameId int NOT NULL AUTO_INCREMENT,
--	date date,
--	gameName varchar(255) NOT NULL,
--	primary key (gameId)
--);
--
--CREATE TABLE gameinfo(
--	gameinfoId int NOT NULL AUTO_INCREMENT,
--	gameId int NOT NULL,
--	quizId Int NOT NULL,
--	primary key (gameinfoId),
--
--	foreign key (gameId) references game(gameId),
--	foreign key (quizId) references quiz(quizId)
--);
--
--CREATE TABLE answer(
--	answerId int NOT NULL AUTO_INCREMENT,
--	gameinfoId int NOT NULL,
--	robloxId varchar(255) NOT NULL,
--	answerImage varchar(255) NOT NULL,
--	result int NOT NULL,
--	primary key (answerId),
--	foreign key (gameinfoId) references gameinfo(gameinfoId)
--);