/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  madave91
 * Created: 09-Oct-2018
 */

CREATE TABLE IF NOT EXISTS USERS(
    ID int,
    VERSION int, 
    USERNAME varchar(255),
    EMAIL varchar(255), 
    PASSWORD varchar(255), 
    ROLE varchar(255)
);