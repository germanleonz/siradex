DROP TABLE usuario CASCADE;
-- DROP TABLE usuario_estudiante CASCADE;
-- DROP TABLE usuario_profesor CASCADE;
-- DROP TABLE usuario_administrativo CASCADE;
-- DROP TABLE usuario_obrero CASCADE;
DROP TABLE rol CASCADE;
DROP TABLE tipo_actividad CASCADE;
DROP TABLE campos_tipo_actividad CASCADE;
DROP TABLE valor CASCADE;
DROP TABLE actividad CASCADE;
-- DROP TABLE departamento;
DROP TABLE catalogo CASCADE;
DROP TABLE campos_catalogo CASCADE;
DROP TABLE valor_catalogo CASCADE;

CREATE TABLE usuario (
    usbid       VARCHAR NOT NULL,
    contrasena  VARCHAR NOT NULL,
    nombre      VARCHAR NOT NULL,
    apellido    VARCHAR NOT NULL,
    email       VARCHAR NOT NULL,
    rol         VARCHAR NOT NULL,
    CONSTRAINT PK_USUARIO PRIMARY KEY (usbid)
); 

CREATE TABLE rol(
    usbid       VARCHAR NOT NULL,
    nombre_rol  VARCHAR NOT NULL,
    nombre      VARCHAR NOT NULL,
    apellido    VARCHAR NOT NULL,
    CONSTRAINT PK_ROL PRIMARY KEY (usbid)
);

CREATE TABLE tipo_actividad (
    id_tipo_act		   	SERIAL,
    nombre_tipo_act		VARCHAR NOT NULL,
    num_campos			INTEGER, 
    tipo_pr                 	CHAR    NOT NULL,
    id_validador		VARCHAR,
    id_programa			VARCHAR,
    descripcion			VARCHAR,
    realizable_por		VARCHAR[],
    CONSTRAINT PK_TIPO_ACT PRIMARY KEY (id_tipo_act)
);

CREATE TABLE campos_tipo_actividad (
	id_cta			SERIAL,
	id_ta			INTEGER,
	nombre_campo		VARCHAR NOT NULL,
	tipo_campo		VARCHAR NOT NULL,
	obligatorio		BOOLEAN,
	longitud		INTEGER,
	id_catalogo		INTEGER,
	CONSTRAINT pk_campos_tipo_act PRIMARY KEY (id_cta)	
);

CREATE TABLE valor (
	id_valor	SERIAL,
	id_act		INTEGER,
	id_cta		INTEGER,
	value		VARCHAR NOT NULL,
	CONSTRAINT PK_valor_campo PRIMARY KEY (id_valor)
);

CREATE TABLE actividad (
	id_act 	SERIAL,
	id_ta 	INTEGER,
	usbid	VARCHAR NOT NULL,
	CONSTRAINT PK_actividad PRIMARY KEY (id_act)
);


CREATE TABLE catalogo (
	id_catalogo		SERIAL,
	nombre_catalogo		VARCHAR UNIQUE,
	num_campos		INTEGER,
	CONSTRAINT PK_catalogo 	PRIMARY KEY (id_catalogo)
);

CREATE TABLE campos_catalogo (
	id_campo_catalogo	SERIAL,
	id_catalogo		INTEGER,
	nombre_campo		VARCHAR NOT NULL,
	tipo_campo		VARCHAR NOT NULL,
	CONSTRAINT pk_campos_catalogo PRIMARY KEY (id_campo_catalogo)	
);

CREATE TABLE valor_catalogo (
	id_valor		SERIAL,
	id_catalogo		INTEGER,
	id_campo_catalogo	INTEGER,
	id_elemento		INTEGER,
	value			VARCHAR NOT NULL,
	CONSTRAINT PK_valor_catalogo PRIMARY KEY (id_valor)
);

CREATE TABLE elemento_catalogo (
	id_elemento	SERIAL,
	id_catalogo	INTEGER,
	CONSTRAINT PK_elemento_catalogo PRIMARY KEY (id_elemento)
);

-- 
-- CREATE TABLE coordinacion (
-- 	id_coordinacion			SERIAL,
-- 	nombre_coordinacion		VARCHAR NOT NULL,
-- 	id_coordinador			VARCHAR,
-- 	CONSTRAINT PK_coordinacion	PRIMARY KEY (id_coordinacion)
-- );
-- 
-- -- Estos seran catalogos hechos con insert
-- CREATE TABLE usuario_estudiante (
--     carnet              VARCHAR NOT NULL,
--     carrera             VARCHAR NOT NULL,
--     cohorte             VARCHAR NOT NULL,
--     email_secundario    VARCHAR NOT NULL,
--     CONSTRAINT PK_ESTUDIANTE PRIMARY KEY (carnet)
-- );
-- 
-- CREATE TABLE usuario_profesor (
--     usbid               VARCHAR NOT NULL,
--     id_departamento     VARCHAR NOT NULL,
--     email_secundario    VARCHAR,
--     telefono            VARCHAR,
--     CONSTRAINT PK_PROFESOR PRIMARY KEY (usbid)
-- );
-- 
-- CREATE TABLE usuario_obrero (
--     usbid       VARCHAR NOT NULL,
--     CONSTRAINT PK_OBRERO PRIMARY KEY (usbid)
-- );
-- 
-- CREATE TABLE usuario_administrativo (
--     usbid       VARCHAR NOT NULL,
--     CONSTRAINT PK_ADMINISTRATIVO PRIMARY KEY (usbid)
-- );
-- CREATE TABLE programa (
-- 	id_programa		SERIAL,
-- 	nombre_programa		VARCHAR,
-- 	CONSTRAINT PK_programa PRIMARY KEY (id_programa)
-- );
