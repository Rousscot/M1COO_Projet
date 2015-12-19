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
SET standard_conforming_strings = OFF;
SET check_function_bodies = FALSE;
SET client_min_messages = WARNING;
SET escape_string_warning = OFF;

SET default_tablespace = '';

SET default_with_oids = FALSE;

-- CUSTOMER

CREATE SEQUENCE customer_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

CREATE TABLE CUSTOMER (
  id_customer INTEGER PRIMARY KEY   NOT NULL DEFAULT nextval('customer_id_seq' :: REGCLASS),
  first_name  CHARACTER VARYING(64) NOT NULL,
  last_name   CHARACTER VARYING(64) NOT NULL,
  birthday    DATE                  NOT NULL,
  city        CHARACTER VARYING(64) NOT NULL
);

ALTER SEQUENCE customer_id_seq OWNED BY CUSTOMER.id_customer;

-- CITY

CREATE SEQUENCE city_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

CREATE TABLE CITY (
  id_city INTEGER PRIMARY KEY   NOT NULL DEFAULT nextval('city_id_seq' :: REGCLASS),
  name    CHARACTER VARYING(64) NOT NULL
);

ALTER SEQUENCE city_id_seq OWNED BY CITY.id_city;

-- HOTEL

CREATE SEQUENCE hotel_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

CREATE TABLE HOTEL (
  id_hotel        INTEGER PRIMARY KEY   NOT NULL DEFAULT nextval('hotel_id_seq' :: REGCLASS),
  name            CHARACTER VARYING(64) NOT NULL,
  resignationDays INTEGER               NOT NULL,
  id_city         INTEGER REFERENCES CITY (id_city)
);

ALTER SEQUENCE hotel_id_seq OWNED BY HOTEL.id_hotel;

-- CATEGORY

CREATE SEQUENCE category_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

CREATE TABLE CATEGORY (
  id_category INTEGER PRIMARY KEY   NOT NULL DEFAULT nextval('category_id_seq' :: REGCLASS),
  name        CHARACTER VARYING(64) NOT NULL,
  capacity    INTEGER               NOT NULL,
  price       INTEGER               NOT NULL,
  id_hotel    INTEGER REFERENCES HOTEL (id_hotel)
);

ALTER SEQUENCE category_id_seq OWNED BY CATEGORY.id_category;

-- ROOM

CREATE SEQUENCE room_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

CREATE TABLE ROOM (
  id_room     INTEGER PRIMARY KEY   NOT NULL DEFAULT nextval('room_id_seq' :: REGCLASS),
  room_number INTEGER               NOT NULL,
  isBusy      BOOLEAN               NOT NULL,
  id_category INTEGER REFERENCES CATEGORY (id_category)
);

ALTER SEQUENCE room_id_seq OWNED BY ROOM.id_room;














