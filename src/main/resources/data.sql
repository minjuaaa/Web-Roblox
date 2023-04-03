insert into game (`gameTitle`, `gameCode`) values
	('1회 예술퀴즈대회', 'artquiz'),
	('테스트대회', 'test');

INSERT INTO quiz (`gameCode`, `num`, `title`, `ex1`, `ex2`, `ex3`, `ex4`, `imageCode`, `correct`) VALUES
	('artquiz','1','모나리자는 달리가 그린 그림이다', 'O', 'X', '', '','1436662788', 'X'),
	('artquiz','2','다음 그림과 관련있는 미술사조는?', '인상주의', '신고전주의', '모더니즘', '로코코','6845282249', '인상주의'),
	('artquiz','3','다음 그림을 그린 화가는?', '', '', '', '','1475763326', '뱅크시'),
	('artquiz','4','보기 중 화가가 다른 그림 하나는?', '해바라기', '별이 빛나는 밤', '진주귀걸이를 한 소녀', '자화상','5564845787', '진주귀걸이를 한 소녀'),
	('artquiz','5','피카소는 정확한 수치와 원근법에 근거하여 그림을 그렸다.', 'O', 'X', '', '','5413114980', 'X'),
	('test','1','테스트문제', '해바라기', '별이 빛나는 밤', '진주귀걸이를 한 소녀', '자화상','5564845787', '진주귀걸이를 한 소녀'),
	('test','2','테스트문제', 'O', 'X', '', '','5413114980', 'X');

insert into answer (`gameCode`, `num`, `answers`) values
	('artquiz', '1', 'X'),
	('artquiz', '1', 'O');




--insert into gameinfo (`gameId`, `quizId`) values
--	(1, 3),
--	(1, 4),
--	(1, 2);
--
--insert into answer (`gameinfoId`, `robloxId`, `answerImage`, `result`) values
--	(1, 'apple12', '1_apple12.jpg', 1),
--	(1, 'book3', '1_book3.jpg', 1),
--	(1, 'minju', '1_minju.jpg', 0);