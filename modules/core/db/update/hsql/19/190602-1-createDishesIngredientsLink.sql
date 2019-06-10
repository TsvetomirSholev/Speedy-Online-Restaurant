create table SPEEDYPIZZA_DISHES_INGREDIENTS_LINK (
    DISHES_ID varchar(36) not null,
    INGREDIENTS_ID varchar(36) not null,
    primary key (DISHES_ID, INGREDIENTS_ID)
);
