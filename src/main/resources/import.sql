insert into roles (name, description) values ("ROLE_SYSTEM", "The usr for system activities");
insert into roles (name, description) values ("ROLE_ADMIN", "The ADMIN usr for the system");
insert into roles (name, description) values ("ROLE_USER", "A regular user of the system");

insert into descriptions (description_text) values("description a");
insert into descriptions (description_text) values("description b");
insert into descriptions (description_text) values("description c");

insert into user (username, description_id, role_id) values ("joshua", 1, 3);
insert into user (username, description_id, role_id) values ("warren.cuccurullo", 2, 3);
insert into user (username, description_id, role_id) values ("frank.zappa", 3, 2);
