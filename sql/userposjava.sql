-- Table: public.userposjava

-- DROP TABLE public.userposjava;

CREATE TABLE public.userposjava
(
  id bigint NOT NULL DEFAULT nextval('usersequence'::regclass),
  nome character varying(255),
  email character varying(255),
  CONSTRAINT user_pk PRIMARY KEY (id),
  CONSTRAINT userposjava_id_key UNIQUE (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.userposjava
  OWNER TO postgres;