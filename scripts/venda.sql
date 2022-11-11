--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-06-16 21:29:23

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
-- TOC entry 203 (class 1259 OID 32900)
-- Name: venda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.venda (
    id integer NOT NULL,
    numerodeseriearma integer,
    idusuario integer,
    notafiscal integer,
    datavenda date
);


ALTER TABLE public.venda OWNER TO postgres;

--
-- TOC entry 2992 (class 0 OID 32900)
-- Dependencies: 203
-- Data for Name: venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.venda (id, numerodeseriearma, idusuario, notafiscal, datavenda) FROM stdin;
\.


--
-- TOC entry 2857 (class 2606 OID 32904)
-- Name: venda id_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT id_pk PRIMARY KEY (id);


--
-- TOC entry 2860 (class 2620 OID 32918)
-- Name: venda temarmaestoque; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER temarmaestoque BEFORE INSERT ON public.venda FOR EACH ROW EXECUTE FUNCTION public.temestoque();


--
-- TOC entry 2861 (class 2620 OID 32916)
-- Name: venda vendarealizada; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER vendarealizada AFTER INSERT ON public.venda FOR EACH ROW EXECUTE FUNCTION public.decrementarestoque();


--
-- TOC entry 2859 (class 2606 OID 32910)
-- Name: venda venda_idusuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_idusuario_fkey FOREIGN KEY (idusuario) REFERENCES public.usuario(id);


--
-- TOC entry 2858 (class 2606 OID 32905)
-- Name: venda venda_numerodeseriearma_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_numerodeseriearma_fkey FOREIGN KEY (numerodeseriearma) REFERENCES public.arma(numerodeserie);


-- Completed on 2021-06-16 21:29:23

--
-- PostgreSQL database dump complete
--

