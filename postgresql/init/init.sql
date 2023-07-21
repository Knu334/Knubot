SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

CREATE SCHEMA IF NOT EXISTS knubot;

CREATE TABLE IF NOT EXISTS knubot.tweets (
    id bigint NOT NULL,
    tweet character varying(1024) NOT NULL,
    "timestamp" timestamp with time zone
);

CREATE TABLE IF NOT EXISTS knubot.exec_history (
    userid bigint NOT NULL,
    exec_date date NOT NULL,
    tweet character varying(1024)
);

COPY knubot.tweets (id, tweet, "timestamp") FROM stdin;
1	SAMPLE	1999-01-01 00:00:00+00
\.

ALTER TABLE ONLY knubot.tweets
    ADD CONSTRAINT tweets_pkey PRIMARY KEY (id);

ALTER TABLE ONLY knubot.exec_history
    ADD CONSTRAINT exec_history_pkey PRIMARY KEY (userid, exec_date);
