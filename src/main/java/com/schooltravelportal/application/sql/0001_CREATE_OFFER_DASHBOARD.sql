create table offer_dashboard (
    id bigint auto_increment primary key,
    internal_code varchar(36) unique,
    start_journey date,
    end_journey date,
    title varchar(200),
    subtitle varchar(200),
    country varchar(30),
    price double,
    currency_per_person varchar(200),
    user_id bigint,
    foreign key(user_id) references user(id),
    admin_id bigint,
    foreign key(admin_id) references admin(id)
);