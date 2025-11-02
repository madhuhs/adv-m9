CREATE TABLE `users` (
                         `userid` int NOT NULL AUTO_INCREMENT,
                         `name` varchar(45) NOT NULL,
                         `mobile` varchar(10) NOT NULL,
                         `password` varchar(20) NOT NULL,
                         PRIMARY KEY (`userid`),
                         UNIQUE KEY `userid_UNIQUE` (`userid`),
                         UNIQUE KEY `mobile_UNIQUE` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


select * from appusers.users;


insert into appusers.users values (0,'Virat','9876543210','pass123');

update appusers.users set mobile = '9876543210' where userid = 1;

Delete from appusers.users where mobile = '7654543210';