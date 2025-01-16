
INSERT INTO `Credential` VALUES
(1,"RedMario","mario","USER",1),
(2,"GreenLuigi","luigi","USER",1),
(3,"YellowMarco","marco","USER",1),
(4,"PurpleFabio","fabio","USER",1),
(5,"Argonaut","andrea","ADMIN",1);

INSERT INTO `User`(`user_id`,`firstname`,`lastname`,`email`,`username`,`nametag`,`pic_path`,`cover_path`,`follower`,`following`) VALUES
(1,"Mario","Rossi","mariorossi@gmail.com","RedMario","@mariorossi","assets/img/pics/mariorossi_pic.png","assets/img/covers/mariorossi_cover.png",2,4),
(2,"Luigi","Verdi","luigiverdi@gmail.com","GreenLuigi","@luigiverdi","assets/img/pics/luigiverdi_pic.png","assets/img/covers/luigiverdi_cover.png",2,4),
(3,"Marco","Gialli","marcogialli@gmail.com","YellowMarco","@marcogialli","assets/img/pics/marcogialli_pic.png","assets/img/covers/marcogialli_cover.png",3,3),
(4,"Fabio","Violi","fabiovioli@gmail.com","PurpleFabio","@fabiovioli","assets/img/pics/fabiovioli_pic.png","assets/img/covers/fabiovioli_cover.png",3,3),
(5,"Andrea","Spinelli","andreaspinelli@gmail.com","Argonaut","@andreaspinelli","assets/img/pics/argonaut_pic.png","assets/img/covers/argonaut_cover.png",4,0);

INSERT INTO `Post`(`date`,`content`,`image_path`,`likes`,`comments`,`user_id`) VALUES
("2025-01-01","Welcome everybody to @Channel, this is the first post!",NULL,5,3,1),
("2025-01-01","Hello to everybody, this instead is the first post with an image!","assets/img/posts/a.png",5,3,2),
("2025-01-02","Lorem ipsum odor amet, consectetuer adipiscing elit. Ante sodales ornare integer leo per. Non vestibulum nec aenean primis suspendisse nascetur. Per pharetra natoque ipsum orci sem. Habitasse malesuada imperdiet; semper per augue dolor sollicitudin ipsum varius.",NULL,3,2,3),
("2025-01-02","Guys! Do you like my new drawing?","assets/img/posts/b.png",5,2,4),
("2025-01-03","Yoh, if you see this post it's because you click the button 'More...'",NULL,3,1,5),
("2025-01-03","We need to use all the assets in the server's storage, so... look this!","assets/img/posts/c.png",4,2,1),
("2025-01-04","I have no idea for this post so I'll tell a short story: 'Once upon a time there was a person who have no idea for a post, so him tell a short story: 'Once upon a time...''",NULL,2,2,2),
("2025-01-04","That's enough, this is the last post with a reupload of the first image","assets/img/posts/a.png",4,5,5);

INSERT INTO `Comment`(`date`,`content`,`image_path`,`likes`,`comments`,`user_id`,`post_id`) VALUES
("2025-01-01","Hello world!",NULL,3,0,2,1),
("2025-01-01","Hi to all!",NULL,3,0,3,1),
("2025-01-01","We are all new!",NULL,3,1,4,1),
("2025-01-01","Wow can we share images?!",NULL,2,0,1,2),
("2025-01-01","Yeah, also in the comments, look","assets/img/posts/c.png",4,2,3,2),
("2025-01-01","No way, it's incredible!",NULL,3,0,4,2),
("2025-01-02","So meaningful...",NULL,3,1,1,3),
("2025-01-02","Damn bro, that's so deep...",NULL,3,2,2,3),
("2025-01-02","Really good. Do you like my drawing too?","assets/img/posts/a.png",4,1,1,4),
("2025-01-02","Both the drawings are fantastic!",NULL,2,3,2,4),
("2025-01-03","Damn, you fooled me",NULL,3,1,1,5),
("2025-01-03","I guess to have already seen this drawing before...",NULL,1,0,1,6),
("2025-01-03","Yeah you have, check it out the third comment in the second post!",NULL,2,1,3,6),
("2025-01-04","Eh eh, is that a 'The Amazing World of Gumball' reference?",NULL,3,3,5,7),
("2025-01-04","Ok, bye bye!",NULL,3,4,1,8),
("2025-01-04","See you next time everybody",NULL,5,2,2,8);

INSERT INTO `Follow` VALUES
(1,2),
(1,4),
(2,1),
(2,3),
(3,1),
(3,2),
(3,4),
(4,1),
(4,2),
(4,3),
(5,1),
(5,2),
(5,3),
(5,4);

-- SELECT * FROM `User`;
-- SELECT * FROM `Credential`;
-- SELECT * FROM `Post`;
-- SELECT * FROM `Comment`;
-- SELECT * FROM `Follow`;