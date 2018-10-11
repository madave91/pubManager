/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  madave91
 * Created: 09-Oct-2018
 */

insert into user (username, password, enabled, role) values ('admin', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', true, 'ROLE_ADMIN');
insert into user (username, password, enabled, role) values ('madave91', '$2y$12$g3PilyzRRcyUB19/D4kEcuzU1Xc4TaHP75DCMelXu1F0Va/E1MsRa', true, 'ROLE_ADMIN');
insert into user (username, password, enabled, role) values ('user', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', true, 'ROLE_USER');

insert into issue (user_id, title, description, place, created_at, updated_at) values (1, 'issue1', 'description1', 'place1', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into issue (user_id, title, description, place, created_at, updated_at) values (1, 'issue2', 'description2', 'place2', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into issue (user_id, title, description, place, created_at, updated_at) values (2, 'issue3', 'description3', 'place3', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into issue (user_id, title, description, place, created_at, updated_at) values (2, 'issue4', 'description4', 'place4', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());

insert into message (issue_id, text, created_at, updated_at) values (1, 'message1', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into message (issue_id, text, created_at, updated_at) values (1, 'message2', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into message (issue_id, text, created_at, updated_at) values (2, 'message3', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into message (issue_id, text, created_at, updated_at) values (3, 'message4', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());

insert into label (text, created_at, updated_at) values ('label1', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into label (text, created_at, updated_at) values ('label2', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into label (text, created_at, updated_at) values ('label3', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into label (text, created_at, updated_at) values ('label4', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());

insert into issue_labels (issues_id, labels_id) values (1, 1);
insert into issue_labels (issues_id, labels_id) values (1, 2);
insert into issue_labels (issues_id, labels_id) values (2, 1);
insert into issue_labels (issues_id, labels_id) values (2, 4);
insert into issue_labels (issues_id, labels_id) values (3, 3);
insert into issue_labels (issues_id, labels_id) values (3, 4);

/*CREATE TABLE IF NOT EXISTS USERS(
    ID int,
    VERSION int, 
    USERNAME varchar(255),
    EMAIL varchar(255), 
    PASSWORD varchar(255), 
    ROLE varchar(255)
);*/