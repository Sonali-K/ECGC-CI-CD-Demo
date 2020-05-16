--
-- PostgreSQL database dump
--

-- Dumped from database version 10.12 (Ubuntu 10.12-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.12 (Ubuntu 10.12-0ubuntu0.18.04.1)

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

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: Employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Employee" (
    emp_id integer,
    emp_fname character varying,
    emp_mname character varying,
    emp_lname character varying,
    designation character varying,
    dob date,
    doj date,
    emp_type character varying
);


ALTER TABLE public."Employee" OWNER TO postgres;

--
-- Data for Name: Employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Employee" (emp_id, emp_fname, emp_mname, emp_lname, designation, dob, doj, emp_type) FROM stdin;
1	Ram	M	Chavan	Developer	1996-04-01	2018-04-03	Regular
2	Raju	Y	Shinde	Developer	1993-04-07	2016-04-07	Regular
3	Shreya	U	Gaikwad	Tester	1992-03-17	2018-03-27	Contractual
0	Sonali	\N	K	\N	1999-09-09	1995-08-08	\N
9	Arun	\N	K	\N	1999-09-09	1995-08-08	\N
5	Sona	d	k	pe	1999-09-09	1999-09-09	regular
4	Arun	\N	K	\N	1999-09-09	1995-08-08	\N
\.


--
-- PostgreSQL database dump complete
--

