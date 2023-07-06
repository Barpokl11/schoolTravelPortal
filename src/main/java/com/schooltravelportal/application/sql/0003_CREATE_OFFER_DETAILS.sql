create table offer_details(
        id bigint auto_increment primary key,
        internal_code varchar(36) unique,
        start_journey date,
        end_journey date,
        title varchar(200),
        subtitle varchar(200),
        country varchar(30),
        price double,
        currency_per_person varchar(200),
        limit_person int,
        offer_dashboard_id bigint,
        foreign key (offer_dashboard_id) references offer_dashboard(id) unique
);