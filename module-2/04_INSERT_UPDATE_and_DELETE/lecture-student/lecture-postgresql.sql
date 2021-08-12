-- INSERT

-- 1. Add Klingon as a spoken language in the USA
-- 2. Add Klingon as a spoken language in Great Britain (GBR)
INSERT INTO countrylanguage(countrycode, language, isofficial, percentage)
VALUES ('USA', 'Klingon', true, 99)
INSERT INTO countrylanguage(countrycode, language, isofficial, percentage)
VALUES ('GBR', 'Klingon', true, 99)
-- UPDATE

-- 1. Update the capital of the USA to Houston
SELECT * 
FROM city 
WHERE district = 'Washington DC';

UPDATE country
SET capital = 3796
WHERE code = 'USA';
-- 2. Update the capital of the USA to Washington DC and the head of state
UPDATE country
SET capital = 'Washington DC' , headofstate = 'Donald Duck'
WHERE code = 'USA';

-- DELETE

-- 1. Delete English as a spoken language in the USA
-- 2. Delete all occurrences of the Klingon language 


-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?

-- 3. Try deleting the country USA. What happens?


-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA

-- 2. Try again. What happens?

-- 3. Let's relocate the USA to the continent - 'Outer Space'


-- How to view all of the constraints

SELECT pg_constraint.*
FROM pg_catalog.pg_constraint
INNER JOIN pg_catalog.pg_class ON pg_class.oid = pg_constraint.conrelid
INNER JOIN pg_catalog.pg_namespace ON pg_namespace.oid = connamespace;


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.

-- 2. Try updating all of the cities to be in the USA and roll it back

-- 3. Demonstrate two different SQL connections trying to access the same table where one happens to be inside of a transaction but hasn't committed yet.