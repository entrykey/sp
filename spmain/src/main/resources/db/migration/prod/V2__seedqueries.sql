INSERT INTO sp9.user (id, enabled, gender, name, password, username) VALUES ('1', b'1', 'M', 'admin', 'admin', 'admin');
INSERT INTO sp9.role (id, name)VALUES (1,'ROLE_ADMIN');
INSERT INTO sp9.users_roles (user_id, role_id)VALUES (1,1);