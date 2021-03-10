select * from cart;

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

create or replace procedure updateTotal(c_id int)
	as $$
declare
	t decimal;
begin
	select into t getTotal(c_id);
	update cart set total = t where cart_id = c_id;
end;
$$ language plpgsql;

