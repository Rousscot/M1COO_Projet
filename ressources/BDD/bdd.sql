-- I am a script to create the database

/* We can't use this with alwaysdata.
CREATE DATABASE "Agency"
  WITH OWNER = postgres
  ENCODING = 'UTF8'
  TABLESPACE = pg_default
  LC_COLLATE = 'French_France.1252'
  LC_CTYPE = 'French_France.1252'
  CONNECTION LIMIT = -1;
*/

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET default_tablespace = '';

SET default_with_oids = false;

-- CUSTOMER

CREATE SEQUENCE customer_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

CREATE TABLE "Customer" (
  cust_id INTEGER PRIMARY KEY NOT NULL DEFAULT nextval('customer_id_seq'::regclass),
  first_name character varying(64) NOT NULL,
  last_name character varying(64) NOT NULL,
  birthday DATE NOT NULL,
  city character varying(64) NOT NULL
);

ALTER SEQUENCE customer_id_seq OWNED BY "Customer".cust_id;














