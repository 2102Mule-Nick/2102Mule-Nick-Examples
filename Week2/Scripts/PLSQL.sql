--Functions
	-- 2 types: aggregate & scalar
	-- aggregate: sum, avg, count, max, min
		-- takes in multiple rows and returns a single value
	-- scalar: round, uppercase, lowercase, length, most date functions
		-- returns a value for each row applied to

select sum(total) from cart;

select count(cart_id) from cart;

select round(sum(total)) from cart;

select sum(round(total)) from cart;

select round(total) from cart;

select * from cart;

select sum(ci.quantity * i.item_cost) 
	from cart_item ci 
		inner join item i 
		on ci.product_id = i.product_id
	where ci.cart_id = 7;
	
update cart set total = (select sum(ci.quantity * i.item_cost) 
	from cart_item ci 
		inner join item i 
		on ci.product_id = i.product_id
	where ci.cart_id = 7)
	where cart.cart_id = 7;
	
select * from cart;

--sub-routine: a way in SQL for us to save and use some logic
	-- writen in PL/SQL (procedural language sql)
	
--anonymous subroutine
-- has no name, not actually stored in the db, has to be run each time
-- starts with `do`
do $$ --delimeter, tells sql when the entire piece of code is finished
declare
	item_cost float;
	t decimal;
	item_quantity int;
	c_id int;
begin
	c_id := 13;
	select into t sum(ci.quantity * i.item_cost) 
	from cart_item ci 
		inner join item i 
		on ci.product_id = i.product_id
	where ci.cart_id = c_id;
	update cart set total = t where cart_id = c_id;
end;
$$ language plpgsql;

-- We also have functions and procedures
--these subroutines allow us to save and reuse our logic inside our DB
create or replace function getTotal(c_id int)
	returns decimal as $$
declare
	t decimal;
begin
	select sum(ci.quantity * i.item_cost) into t
	from cart_item ci 
		inner join item i 
		on ci.product_id = i.product_id
	where ci.cart_id = c_id;
	return t;
end;
$$ language plpgsql;

select getTotal(20);

update cart set total = getTotal(20) where cart_id = 20;

select * from employee;

insert into employee (employeeid, firstname, lastname) values ((select nextval('employee_id_seq')), 'Brian', 'C');

--sequence
create sequence employee_id_seq start 9;

--trigger
create or replace function insert_into_employee()
	returns trigger as $$
	begin
		if(TG_OP = 'INSERT') then
			new.employeeid = (select nextval('employee_id_seq'));
		end if;
	return new;
	end;
$$ language plpgsql;


	