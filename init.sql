create database if not exists sach;
use sach;

create table if not exists sua (
    id int not null auto_increment,
    ten_sua varchar(255) not null,
    ma_sua varchar(255) not null,
    ngay_thanh_toan varchar(255) not null,
    ngay_thanh_toan_tiem varchar(255) not null,
    so_sach varchar(255) not null,
    primary key (id)
);