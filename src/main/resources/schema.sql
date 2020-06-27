create table room(
room_id  serial primary key,
room_type varchar(10) not null,
room_number char(2) not null,
bed_info char(2) not null
);

create table guest(
guest_id  serial primary key,
first_name varchar(15),
last_name varchar(15),
email varchar(50),
address varchar(50),
country varchar(20),
state varchar(20),
phone_number varchar(15)
);

create table reservation(
reservation_id  serial primary key,
room_id int not null,
guest_id int not null,
reservation_date DATE
);


alter table reservation add foreign key(room_id) references room(room_id);
alter table reservation add foreign key(guest_id) references guest(guest_id);