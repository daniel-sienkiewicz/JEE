-- login: bolek password: bolek
INSERT INTO myuser(id, username, password) VALUES (1, 'bolek', 'd78668d007a8731e20426b4354a53598a9d2df7d4c28d8eb52357719ad8cc081');

-- login: lolek password: lolek
INSERT INTO myuser(id, username, password) VALUES (2, 'lolek', 'a504c2a724298691bce98ec2c3ef6176863796550d198df0f061c4f2105d64ea');

-- login: henio password: henio
INSERT INTO myuser(id, username, password) VALUES (3, 'henio', '1489f2f6a48751e058c76af17b4353910b6e9688324a0e36c0eb63fdf2a4e113');

INSERT INTO "PUBLIC"."MYGROUP" ( "ID", "GROUPNAME", "USERNAME" ) VALUES (1, 'ADMIN', 'bolek');
INSERT INTO "PUBLIC"."MYGROUP" ( "ID", "GROUPNAME", "USERNAME" ) VALUES (2, 'MANAGER', 'lolek');
INSERT INTO "PUBLIC"."MYGROUP" ( "ID", "GROUPNAME", "USERNAME" ) VALUES (3, 'ADMIN', 'henio');
