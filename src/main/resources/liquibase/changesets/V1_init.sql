-- liquibase formatted sql
-- changeset eve:1

-- Table: employees
create table if not exists users
(
    id       bigserial,
    name     varchar(255) not null,
    course     varchar(255) not null,
    primary key (id)
);

-- changeset eve:2

INSERT INTO users (name, course)
VALUES ('John Doe', 'Math'),
       ('Mary Smith', 'History'),
       ('Alex Johnson', 'Physics');


