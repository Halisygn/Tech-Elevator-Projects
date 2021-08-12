SELECT *
FROM city
WHERE countrycode='AFG';

SELECT DISTINCT name
FROM city;

SELECT * 
FROM city
WHERE district='Ohio';

SELECT name, continent 
FROM country 
WHERE continent <> 'Asia';

SELECT name, population 
FROM city
WHERE population <= 700;

SELECT name, indepyear
FROM country
WHERE indepyear IS NULL;

SELECT name, indepyear
FROM country
WHERE indepyear IS NOT NULL;

SELECT name
FROM city
WHERE district = 'Ohio' or district = 'Gergio';

SELECT name
FROM city
WHERE district = 'Ohio' or district = 'Georgia';

SELECT name, continent
FROM country
WHERE continent IN ('South America', 'Asia');