ALTER TABLE IF EXISTS dog DROP CONSTRAINT IF EXISTS dog_owner_fkey;
DROP TABLE IF EXISTS dog CASCADE;
DROP TABLE IF EXISTS owner CASCADE;
CREATE TABLE dog (id BIGINT NOT NULL, name VARCHAR(255), owner_id BIGINT, PRIMARY KEY (id));
CREATE TABLE owner (id BIGINT NOT NULL, name VARCHAR(255), PRIMARY KEY (id));
ALTER TABLE IF EXISTS dog ADD CONSTRAINT dog_owner_fkey FOREIGN KEY (owner_id) REFERENCES owner;