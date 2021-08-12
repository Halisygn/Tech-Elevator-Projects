-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
INSERT INTO actor (first_name,last_name)
VALUES ('Hampton','Avenue');
INSERT INTO actor (first_name,last_name)
VALUES ('Lisa','Byway');

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.
INSERT INTO film (title, description, release_year, language_id, original_language_id, length)
VALUES ('Euclidean PI','The epic story of Euclid as a pizza delivery boy in
-- ancient Greecenue', 2008, 1, 1, 180);

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
INSERT INTO film_actor (actor_id, film_id)
VALUES (201, 1001);
INSERT INTO film_actor (actor_id, film_id)
VALUES (202, 1001);

-- 4. Add Mathmagical to the category table.
INSERT INTO category (name)
VALUES ('Mathmagical');

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
INSERT INTO film_category (category_id,film_id)
VALUES (17, 1001);

UPDATE film_category
SET category_id = (SELECT category_id FROM category WHERE category.name = 'Mathmagical')
FROM film
WHERE film.title in ('EGG IGBY', 'RANDOM GO','YOUNG LANGUAGE','KARATE MOON') AND film_category.film_id = film.film_id;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)
UPDATE film
SET rating = ('G')
FROM film_category
WHERE category_id = (SELECT category_id FROM category WHERE name = 'Mathmagical') AND film.film_id = film_category.film_id;

-- 7. Add a copy of "Euclidean PI" to all the stores.
INSERT INTO inventory (film_id, store_id)
VALUES (1001,1);

INSERT INTO inventory (film_id, store_id)
VALUES (1001,2);
-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
DELETE FROM film
WHERE title = 'Euclidean PI';

--No, it didn't. This film connected to film_actor and film_category tables.   

-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
DELETE FROM category
WHERE name = 'Mathmagical';

--No, it didn't. Category_id is a foreign key on film_category table. So we can not delate it.

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
DELETE FROM film_category
WHERE category_id = 17;

--Yes it is. Becaseu this category_id is not a foreign key of another table.

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <YOUR ANSWER HERE>
DELETE FROM category
WHERE name = 'Mathmagical';

--Yes it is, because we removed the foreign connection from film_category table.

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.

--I need to remove this film id from film_category, inventory and film_actor. So I can delete 'Euclidean PI'
DELETE FROM film_category
WHERE film_id = 1001;

DELETE FROM film_actor
WHERE film_id = 1001;

DELETE FROM inventory
WHERE film_id = 1001;

DELETE FROM film
WHERE film_id = 1001;

--After I removed form all tables which is foreign key. Then I deleted it.