BEGIN;


CREATE TABLE IF NOT EXISTS public.employees
(
    id integer NOT NULL,
    fio character varying(60) COLLATE pg_catalog."default" NOT NULL,
    post character varying(30) COLLATE pg_catalog."default",
    experience real,
    CONSTRAINT employees_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.films
(
    id integer NOT NULL,
    title character varying(50) COLLATE pg_catalog."default" NOT NULL,
    year integer,
    country character varying(15) COLLATE pg_catalog."default",
    CONSTRAINT films_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.visitors
(
    id integer NOT NULL,
    fio character varying(60) COLLATE pg_catalog."default" NOT NULL,
    age integer NOT NULL,
    CONSTRAINT visitors_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.seanses
(
    id integer NOT NULL,
    date date NOT NULL,
    price real NOT NULL,
    duration integer,
    film_id integer,
    hall_id integer,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.seanses_employees
(
    seanses_id serial NOT NULL,
    employees_id serial NOT NULL
);

CREATE TABLE IF NOT EXISTS public.seanses_visitors
(
    seanses_id serial NOT NULL,
    visitors_id serial NOT NULL
);

CREATE TABLE IF NOT EXISTS public.halls
(
    id integer NOT NULL,
    type character varying(10) NOT NULL,
    seats_count integer,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.seanses
    ADD FOREIGN KEY (film_id)
    REFERENCES public.films (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.seanses
    ADD FOREIGN KEY (hall_id)
    REFERENCES public.halls (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.seanses
    ADD FOREIGN KEY (film_id)
    REFERENCES public.films (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.seanses_employees
    ADD FOREIGN KEY (seanses_id)
    REFERENCES public.seanses (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.seanses_employees
    ADD FOREIGN KEY (employees_id)
    REFERENCES public.employees (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.seanses_visitors
    ADD FOREIGN KEY (seanses_id)
    REFERENCES public.seanses (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.seanses_visitors
    ADD FOREIGN KEY (visitors_id)
    REFERENCES public.visitors (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

END;