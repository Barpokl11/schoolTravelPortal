create table schedule(
    id bigint auto_increment primary key,
    title varchar(30),
    description varchar (1000),
    offer_details_id bigint,
    foreign key (offer_details_id) references offer_details(id)
);