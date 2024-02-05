INSERT INTO client (username, email, password, name, phone, gender, birth_date)
VALUES 
('user1', 'user1@example.com', 'password1', 'User One', '111111111', 'Male', '1995-02-15 08:30:00'),
('user2', 'user2@example.com', 'password2', 'User Two', '222222222', 'Female', '1988-07-20 14:45:00'),
('user3', 'user3@example.com', 'password3', 'User Three', '333333333', 'Male', '2000-05-10 10:00:00'),
('user4', 'user4@example.com', 'password4', 'User Four', '444444444', 'Female', '1992-11-30 18:20:00'),
('user5', 'user5@example.com', 'password5', 'User Five', '555555555', 'Male', '1980-04-05 12:00:00'),
('user6', 'user6@example.com', 'password6', 'User Six', '666666666', 'Female', '1998-09-25 16:30:00'),
('user7', 'user7@example.com', 'password7', 'User Seven', '777777777', 'Male', '1985-06-15 22:15:00'),
('user8', 'user8@example.com', 'password8', 'User Eight', '888888888', 'Female', '1993-03-01 04:45:00'),
('user9', 'user9@example.com', 'password9', 'User Nine', '999999999', 'Male', '1996-08-10 07:00:00'),
('user10', 'user10@example.com', 'password10', 'User Ten', '1010101010', 'Female', '1982-12-20 19:30:00');

INSERT INTO club (name, foundation_date)
VALUES 
('Club A', '1995-05-15 08:30:00'),
('Club B', '1988-10-20 14:45:00'),
('Club C', '2005-03-10 10:00:00'),
('Club D', '1990-12-30 18:20:00'),
('Club E', '1975-07-05 12:00:00'),
('Club F', '2002-09-25 16:30:00'),
('Club G', '1983-06-15 22:15:00'),
('Club H', '1998-02-01 04:45:00'),
('Club I', '1987-08-10 07:00:00'),
('Club J', '2008-11-20 19:30:00');

INSERT INTO client_has_club (client_idclient, club_idclub, is_leader)
VALUES
(1, 1, 1),
(2, 1, 0),
(3, 1, 0),
(4, 5, 1),
(5, 5, 1);

INSERT INTO garage (client_idclient)
VALUES
(1),
(2),
(3),
(4),
(5);

INSERT INTO byke (brand,model,fecha,garage_idgarage)
VALUES
('Yamaha','MT-07','2008-11-20 19:30:00',1),
('Kawasaki','Z900','2008-11-20 19:30:00',1),
('Yamaha','MT-09','2008-11-20 19:30:00',3),
('Honda','CBR600','2008-11-20 19:30:00',4),
('KTM','790','2008-11-20 19:30:00',5);



