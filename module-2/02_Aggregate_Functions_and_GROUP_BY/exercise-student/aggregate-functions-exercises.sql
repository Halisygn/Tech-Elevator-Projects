-- The following queries utilize the "world" database.
-- Write queries for the following problems. 
-- Notes:
--   GNP is expressed in units of one million US Dollars
--   The value immediately after the problem statement is the expected number 
--   of rows that should be returned by the query.

-- 1. The name and state plus population of all cities in states that border Ohio 
-- (i.e. cities located in Pennsylvania, West Virginia, Kentucky, Indiana, and 
-- Michigan).  
-- The name and state should be returned as a single column called 
-- name_and_state and should contain values such as ‘Detroit, Michigan’.  
-- The results should be ordered alphabetically by state name and then by city 
-- name. 
-- (19 rows)
SELECT (name || ', ' || district) as name_and_state, population
FROM city
WHERE district IN ('Pennsylvania', 'West Virginia', 'Kentucky', 'Indiana', 'Michigan')
ORDER BY district, name;
-- 2. The name, country code, and region of all countries in Africa.  The name and
-- country code should be returned as a single column named country_and_code 
-- and should contain values such as ‘Angola (AGO)’ 
-- (58 rows)
SELECT (name || ', ' || code) as country_and_code, region
FROM country
WHERE continent = 'Africa';
-- 3. The per capita GNP (i.e. GNP multipled by 1000000 then divided by population) of all countries in the 
-- world sorted from highest to lowest. Recall: GNP is express in units of one million US Dollars 
-- (highest per capita GNP in world: 37459.26)
SELECT name, ROUND(((gnp * 1000000)/population), 2) AS per_capita_gnp
FROM country
WHERE population != 0 
ORDER BY per_capita_gnp DESC;
-- 4. The average life expectancy of countries in South America.
-- (average life expectancy in South America: 70.9461)
SELECT ROUND(CAST(AVG( lifeexpectancy) AS numeric), 4) 
FROM country
WHERE continent = 'South America';
-- 5. The sum of the population of all cities in California.
-- (total population of all cities in California: 16716706)
SELECT SUM(population)
FROM city
WHERE district = 'California';
-- 6. The sum of the population of all cities in China.
-- (total population of all cities in China: 175953614)
SELECT SUM(population)
FROM city
WHERE countrycode = 'CHN';
-- 7. The maximum population of all countries in the world.
-- (largest country population in world: 1277558000)
SELECT name, population
FROM country
ORDER BY population DESC
LIMIT 1;
-- 8. The maximum population of all cities in the world.
-- (largest city population in world: 10500000)
SELECT name, population
FROM city
ORDER BY population DESC
LIMIT 1;
-- 9. The maximum population of all cities in Australia.
-- (largest city population in Australia: 3276207)
SELECT name, population
FROM city
WHERE countrycode = 'AUS'
ORDER BY population DESC
LIMIT 1;
-- 10. The minimum population of all countries in the world.
-- (smallest_country_population in world: 50)
SELECT name, population
FROM country
WHERE population > 0
ORDER BY population ASC
LIMIT 1;
-- 11. The average population of cities in the United States.
-- (avgerage city population in USA: 286955.3795)
SELECT ROUND(AVG(population) :: numeric, 4)
FROM city
WHERE countrycode = 'USA';
-- 12. The average population of cities in China.
-- (average city population in China: 484720.6997 approx.)
SELECT ROUND(AVG(population) :: numeric, 4)
FROM city
WHERE countrycode = 'CHN';
-- 13. The surface area of each continent ordered from highest to lowest.
-- (largest continental surface area: 31881000, "Asia")
SELECT continent, SUM(surfacearea) AS surfacearea
FROM country
GROUP BY continent
ORDER BY surfacearea DESC
-- 14. The highest population density (population divided by surface area) of all 
-- countries in the world. 
-- (highest population density in world: 26277.7777)
SELECT name, (population/surfacearea) AS density
FROM country
ORDER BY density DESC
LIMIT 1;
-- 15. The population density and life expectancy of the top ten countries with the 
-- highest life expectancies in descending order. 
-- (highest life expectancies in world: 83.5, 166.6666, "Andorra")
SELECT name, lifeexpectancy, (population/surfacearea) AS density
FROM country
WhERE lifeexpectancy IS NOT NULL
ORDER BY lifeexpectancy DESC
LIMIT 10;
-- 16. The difference between the previous and current GNP of all the countries in 
-- the world ordered by the absolute value of the difference. Display both 
-- difference and absolute difference.
-- (smallest difference: 1.00, 1.00, "Ecuador")
SELECT name, (gnp - gnpold) as actul_difference, abs(gnpold - gnp) as absolute_gnp
FROM country
WHERE gnp IS NOT NULL or gnpold IS NOT NULL
ORDER BY absolute_gnp;
-- 17. The average population of cities in each country (hint: use city.countrycode)
-- ordered from highest to lowest.
-- (highest avg population: 4017733.0000, "SGP")
SELECT city.countrycode, AVG(population) AS avg_population
FROM city
GROUP BY city.countrycode
ORDER BY avg_population DESC;	
-- 18. The count of cities in each state in the USA, ordered by state name.
-- (45 rows)
SELECT district, COUNT(name)
FROM city
WHERE countrycode = 'USA'
GROUP BY district
ORDER BY district;
-- 19. The count of countries on each continent, ordered from highest to lowest.
-- (highest count: 58, "Africa")
SELECT continent, COUNT(name) as country_count
FROM country
GROUP BY continent
ORDER BY country_count DESC;
-- 20. The count of cities in each country ordered from highest to lowest.
-- (largest number of  cities ib a country: 363, "CHN")
SELECT countrycode, COUNT(name) as city_count
FROM city
GROUP BY countrycode
ORDER BY city_count DESC;
-- 21. The population of the largest city in each country ordered from highest to 
-- lowest.
-- (largest city population in world: 10500000, "IND")
SELECT countrycode, MAX(population) as max_count
FROM city
GROUP BY countrycode
ORDER BY max_count DESC;
-- 22. The average, minimum, and maximum non-null life expectancy of each continent 
-- ordered from lowest to highest average life expectancy. 
-- (lowest average life expectancy: 52.5719, 37.2, 76.8, "Africa")
SELECT AVG(lifeexpectancy), MIN(lifeexpectancy), MAX(lifeexpectancy), continent
FROM country
WHERE lifeexpectancy IS NOT NULL
GROUP BY continent
ORDER BY AVG;

