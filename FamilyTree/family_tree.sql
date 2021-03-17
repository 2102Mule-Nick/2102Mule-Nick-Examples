--drop table family_tree

create table family_tree(
	user_id serial primary key,
	father_name text,
	mother_name text,
	first_name text,
	last_name text
);

select * from family_tree;

insert into family_tree (father_name, mother_name, first_name, last_name) 
	values
	(Null, Null, 'Joe', 'Bob'),
	(Null, Null, 'Jill', 'Bob'),
	('joe', 'Jill', 'Jim', 'Bob'),
	('joe', 'Jill', 'Jess', 'Bob'),
	('joe', 'Jill', 'John', 'Bob'),
	('joe', 'Jill', 'Jane', 'Bob'),
	('joe', 'Jill', 'Josh', 'Bob'),
	('Jim', 'Jess', 'James', 'Bob'),
	('Jim', 'Jess', 'Jamie', 'Bob'),
	('John', 'Jane', 'Jack', 'Bob'),
	('John', 'Jane', 'Julie', 'Bob'),
	('James', 'Jamie', 'Joshuau', 'Bob');
	

select * from user_sm us;