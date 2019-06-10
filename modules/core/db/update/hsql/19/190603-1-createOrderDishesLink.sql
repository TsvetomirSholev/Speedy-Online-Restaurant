create table SPEEDYPIZZA_ORDER_DISHES_LINK (
    DISHES_ID varchar(36) not null,
    ORDER_ID varchar(36) not null,
    primary key (DISHES_ID, ORDER_ID)
);
