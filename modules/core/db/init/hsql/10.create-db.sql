-- begin SPEEDYPIZZA_ORDER
create table SPEEDYPIZZA_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_TIME timestamp not null,
    CLIENT_NAME varchar(255),
    CLIENT_PHONE varchar(255),
    CLIENT_ORDER_ADDRESS varchar(255),
    TOTAL_PRICE decimal(19, 2),
    DELIVERY_TIME timestamp,
    ORDER_CURRENT_DICOUNT decimal(19, 2),
    CUSTOMER_ID varchar(36),
    TOTAL_DISH_COUNT integer,
    SPECIAL_DELIVERY_INSTRUCTIONS varchar(255),
    --
    primary key (ID)
)^
-- end SPEEDYPIZZA_ORDER
-- begin SPEEDYPIZZA_CUSTOMER
create table SPEEDYPIZZA_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    IS_REGISTERED boolean,
    ORDERED_TIMES_COUNT integer,
    CUSTOMER_CURRENT_DISCOUNT decimal(19, 2),
    CUSTOMER_NAME varchar(255),
    CUSTOMER_PHONE varchar(255),
    --
    primary key (ID)
)^
-- end SPEEDYPIZZA_CUSTOMER
-- begin SPEEDYPIZZA_DISH_TYPES
create table SPEEDYPIZZA_DISH_TYPES (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DISH_TYPE varchar(255) not null,
    --
    primary key (ID)
)^
-- end SPEEDYPIZZA_DISH_TYPES
-- begin SPEEDYPIZZA_INGREDIENTS
create table SPEEDYPIZZA_INGREDIENTS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    INGREDIENT_TYPE varchar(255),
    DISH_TYPES_ID varchar(36),
    --
    primary key (ID)
)^
-- end SPEEDYPIZZA_INGREDIENTS
-- begin SPEEDYPIZZA_DISHES
create table SPEEDYPIZZA_DISHES (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PRICE decimal(19, 2),
    DISH_TYPE_ID varchar(36) not null,
    DISH_NAME varchar(255),
    DISH_COUNT_PER_ORDER integer,
    --
    primary key (ID)
)^
-- end SPEEDYPIZZA_DISHES
-- begin SPEEDYPIZZA_DISHES_INGREDIENTS_LINK
create table SPEEDYPIZZA_DISHES_INGREDIENTS_LINK (
    DISHES_ID varchar(36) not null,
    INGREDIENTS_ID varchar(36) not null,
    primary key (DISHES_ID, INGREDIENTS_ID)
)^
-- end SPEEDYPIZZA_DISHES_INGREDIENTS_LINK
-- begin SPEEDYPIZZA_ORDER_DISHES_LINK
create table SPEEDYPIZZA_ORDER_DISHES_LINK (
    DISHES_ID varchar(36) not null,
    ORDER_ID varchar(36) not null,
    primary key (DISHES_ID, ORDER_ID)
)^
-- end SPEEDYPIZZA_ORDER_DISHES_LINK
