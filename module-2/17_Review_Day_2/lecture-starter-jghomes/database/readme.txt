1. Drop any previous versions of the jghomes database (this one has new tables)

winpty dropdb -U postgres jghomes

2. Recreate it

winpty createdb -U postgres jghomes

3. Load sql tables:

psql -U postgres -d jghomes -f jghomes.sql