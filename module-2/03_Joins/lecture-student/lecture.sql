-- ********* INNER JOIN ***********

-- Let's find out who made payment 16666:
SELECT *
FROM payment
WHERE p.payment_id = 16666;

-- Ok, that gives us a customer_id, but not the name. We can use the customer_id to get the name FROM the customer table
SELECT *
FROM payment as p
JOIN customer as c
ON p.customer_id = c.customer_id
WHERE p.payment_id = 16666;

-- We can see that the * pulls back everything from both tables. We just want everything from payment and then the first and last name of the customer:
SELECT p.*, c.first_name, c.last_name
FROM payment as p
JOIN customer as c
ON p.customer_id = c.customer_id
WHERE p.payment_id = 16666;

-- But when did they return the rental? Where would that data come from? From the rental table, so let’s join that.
SELECT p.*, c.first_name, c.last_name, r.return_date
FROM payment as p
JOIN customer as c ON p.customer_id = c.customer_id
JOIN rental as r ON p.rental_id = r.rental_id
WHERE p.payment_id = 16666;

-- What did they rent? Film id can be gotten through inventory.
SELECT p.*, c.first_name, c.last_name, r.return_date, f.title
FROM payment as p
JOIN customer as c ON p.customer_id = c.customer_id
JOIN rental as r ON p.rental_id = r.rental_id
JOIN inventory as i ON i.inventory_id=r.inventory_id
JOIN film as f ON i.film_id = f.film_id
WHERE p.payment_id = 16666;
-- What if we wanted to know who acted in that film?
SELECT f.title, ARRAY_AGG(ac.first_name || ', ' || ac.last_name) AS actors
FROM film as f
JOIN film_actor AS f_a ON f_a.film_id = f.film_id
JOIN actor as ac ON ac.actor_id = f_a.actor_id
WHERE f.film_id = 948
GROUP BY f.film_id;
-- What if we wanted a list of all the films and their categories ordered by film title
SELECT f.title, c.name film_category
FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
ORDER BY f.title;

-- Show all the 'Comedy' films ordered by film title
SELECT f.title, c.name film_category
FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
WHERE c.name = 'Comedy'
ORDER BY f.title;

-- Finally, let's count the number of films under each category
SELECT c.name film_category, COUNT(f.title)
FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
GROUP BY c.name
ORDER BY COUNT DESC;

-- ********* LEFT JOIN ***********

-- (There aren't any great examples of left joins in the "dvdstore" database, so the following queries are for the "world" database)

-- A Left join, selects all records from the "left" table and matches them with records from the "right" table if a matching record exists.

-- Let's display a list of all countries and their capitals, if they have some.
SELECT country.name, city.name
FROM country
JOIN city ON country.capital = city.id;

-- Only 232 rows
-- But we’re missing entries:
SELECT country.name, city.name
FROM country
LEFT JOIN city ON country.capital = city.id;
-- There are 239 countries. So how do we show them all even if they don’t have a capital?
-- That’s because if the rows don’t exist in both tables, we won’t show any information for it. If we want to show data FROM the left side table everytime, we can use a different join:

-- *********** UNION *************

-- Back to the "dvdstore" database...

-- Gathers a list of all first names used by actors and customers
-- By default removes duplicates
SELECT first_name, 'A' AS source
FROM actor
UNION 
SELECT first_name, 'C' AS source
FROM customer
ORDER BY first_name;
-- Gather the list, but this time note the source table with 'A' for actor and 'C' for customer
