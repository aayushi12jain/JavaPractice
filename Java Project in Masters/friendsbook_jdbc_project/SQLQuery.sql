

create table userProfile(
    username varchar(10) primary key,
    password varchar(20),
    gender varchar(6),
    school varchar(20)
);


create table post(
    postId int  primary key identity(1,1),
    content varchar(max),
    username varchar(10),
    postDateTime varchar(30),
    hashtag varchar(10)
);

create table comment(
    commentId int primary key identity(1,1),
    comment varchar(20),
    commentDateTime varchar(30),
    username varchar(10),
    postId int
);

create table notification(
    notificationId int PRIMARY KEY IDENTITY(1,1),
    n_type varchar(15),
    content varchar(30),
    notificationDateTime varchar(30),
    n_status varchar(10)
)

create table hashtag(
    hashtag varchar(10) PRIMARY key,
    appearanceCount int
);

create table friendRelationship(
    relationId int PRIMARY KEY IDENTITY(1,1),
    username1 varchar(10),
    username2 varchar(10)
);