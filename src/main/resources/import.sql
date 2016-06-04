/** admin user **/
insert into admin(admin_id, email, name, password, create_date) values ('admin', 'admin@moaplex.com', 'kimminjong', 'admin', now())


/** admin menu **/
insert into menu(id, depth, icon, name, parent, role, sort, url, useyn) values (1, 1, 'icon-users', '회원관리', 1, 'M', 1, '/admin/members', 'Y')
insert into menu(id, depth, icon, name, parent, role, sort, url, useyn) values (2, 1, 'icon-puzzle', '카테고리관리', 2, 'M', 2, '/admin/categorys', 'Y')
insert into menu(id, depth, icon, name, parent, role, sort, url, useyn) values (3, 1, 'icon-diamond', '이벤트관리', 3, 'M', 3, '/admin/events', 'Y')



/** category **/
insert into category (id, depth, name, parent, sort, type) values (1, 1, '페이스북',  0,  1, '')
insert into category (id, depth, name, parent, sort, type) values (2, 1, '트위터',   0,  2, '')
insert into category (id, depth, name, parent, sort, type) values (3, 1, '카테고리1', 0,  3, '')
insert into category (id, depth, name, parent, sort, type) values (4, 1, '신세계',   0,  4, '')

insert into category (id, depth, name, parent, sort, type) values (5, 2, '페이스북 하위-1',   1,  1, '')
insert into category (id, depth, name, parent, sort, type) values (6, 2, '페이스북 하위-2',   1,  1, '')
insert into category (id, depth, name, parent, sort, type) values (7, 2, '페이스북 하위-3',   1,  1, '')
insert into category (id, depth, name, parent, sort, type) values (8, 2, '페이스북 하위-4',   1,  1, '')

/** user **/
insert into user(email, name) values ('test01@gmail.com', '김태민');
insert into user(email, name) values ('test02@gmail.com', 'Hibaby');




