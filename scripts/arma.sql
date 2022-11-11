--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-06-16 21:28:44

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

--
-- TOC entry 201 (class 1259 OID 32890)
-- Name: arma; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.arma (
    numerodeserie integer NOT NULL,
    nome character varying(100),
    marca character varying(100),
    modelo character varying(50),
    valor numeric(5,2),
    estoque integer
);


ALTER TABLE public.arma OWNER TO postgres;

--
-- TOC entry 2988 (class 0 OID 32890)
-- Dependencies: 201
-- Data for Name: arma; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.arma (numerodeserie, nome, marca, modelo, valor, estoque) FROM stdin;
\.


--
-- TOC entry 2857 (class 2606 OID 32894)
-- Name: arma arma_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.arma
    ADD CONSTRAINT arma_pkey PRIMARY KEY (numerodeserie);


-- Completed on 2021-06-16 21:28:44

--
-- PostgreSQL database dump complete
--

