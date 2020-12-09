CREATE EXTENSION unaccent;

CREATE TABLE "curso"
(
	"id" integer NOT NULL DEFAULT nextval(('"curso_id_seq"'::text)::regclass),
	"nom_curso" varchar(50)	 NOT NULL,
	"id_pessoa" integer,
	"flg_ativo" varchar(50)
)
;

CREATE TABLE "fase"
(
	"id" integer NOT NULL,
	"nom_fase" varchar(50)	,
	"flg_ativo" boolean NOT NULL
)
;

CREATE TABLE "formulario"
(
	"id" integer NOT NULL DEFAULT nextval(('"formulario_id_seq"'::text)::regclass),
	"nom_formulario" varchar(256)	 NOT NULL,
	"des_formulario" varchar(512)	,
	"des_situacao" varchar(50)	 NOT NULL,
	"id_pessoa" integer NOT NULL,
	"dat_inicio" timestamp(6)	 NOT NULL,
	"dat_fim" timestamp(6)	,
	"flg_ativo" boolean NOT NULL
)
;

CREATE TABLE "formulario_pergunta"
(
	"id" integer NOT NULL DEFAULT nextval(('"formulario_pergunta_id_seq"'::text)::regclass),
	"nom_pergunta" varchar(150)	 NOT NULL,
	"des_pergunta" varchar(256)	 NOT NULL,
	"tip_pergunta" varchar(50)	 NOT NULL,
	"flg_multipla_escolha" boolean NOT NULL,
	"id_formulario" integer NOT NULL
)
;

CREATE TABLE "formulario_pergunta_alternativa"
(
	"id" integer NOT NULL DEFAULT nextval(('"formulario_pergunta_alternativa_id_seq"'::text)::regclass),
	"nom_pergunta_alternativa" varchar(150)	 NOT NULL,
	"des_pergunta_alternativa" varchar(256)	,
	"id_formulario_pergunta" integer
)
;

CREATE TABLE "formulario_pergunta_resposta"
(
	"id" integer NOT NULL,
	"des_resposta" varchar(150)	 NOT NULL,
	"des_situacao" varchar(50)	 NOT NULL,
	"id_formulario_pergunta" integer NOT NULL,
	"id_pessoa" integer NOT NULL
)
;

CREATE TABLE "grupo_acesso"
(
	"id" integer NOT NULL DEFAULT nextval(('"grupo_acesso_id_seq"'::text)::regclass),
	"nom_grupo" varchar(50)	 NOT NULL,
	"tip_acesso" varchar(50)	 NOT NULL
)
;

CREATE TABLE "pessoa"
(
	"id" integer NOT NULL DEFAULT nextval(('"pessoa_id_seq"'::text)::regclass),
	"nom_pessoa" varchar(150)	 NOT NULL,
	"cpf_pessoa" varchar(50)	 NOT NULL,
	"cod_univerdade" varchar(20)	 NOT NULL,
	"des_email" varchar(150)	,
	"des_telefone" varchar(150)	,
	"tip_pessoa" varchar(50)	 NOT NULL,
	"id_fase" integer,
	"id_curso" integer NOT NULL,
	"dat_nascimento" timestamp(6)	 NOT NULL,
	"flg_ativo" boolean NOT NULL
)
;

CREATE TABLE "usuario"
(
	"id" integer NOT NULL DEFAULT nextval(('"usuario_id_seq"'::text)::regclass),
	"nom_login" varchar(150)	 NOT NULL,
	"des_senha" varchar(512)	 NOT NULL,
	"flg_ativo" boolean NOT NULL,
	"id_pessoa" integer NOT NULL
)
;

CREATE TABLE "usuario_grupo"
(
	"id" integer NOT NULL DEFAULT nextval(('"usuario_grupo_id_seq"'::text)::regclass),
	"id_usuario" integer NOT NULL,
	"id_grupo_acesso" integer NOT NULL
)
;

CREATE SEQUENCE "curso_id_seq" INCREMENT 1 START 1
;

CREATE SEQUENCE "formulario_id_seq" INCREMENT 1 START 1
;

CREATE SEQUENCE "formulario_pergunta_id_seq" INCREMENT 1 START 1
;

CREATE SEQUENCE "formulario_pergunta_alternativa_id_seq" INCREMENT 1 START 1
;

CREATE SEQUENCE "grupo_acesso_id_seq" INCREMENT 1 START 1
;

CREATE SEQUENCE "pessoa_id_seq" INCREMENT 1 START 1
;

CREATE SEQUENCE "usuario_id_seq" INCREMENT 1 START 1
;

CREATE SEQUENCE "usuario_grupo_id_seq" INCREMENT 1 START 1
;

ALTER TABLE "curso" ADD CONSTRAINT "PK_curso"
	PRIMARY KEY ("id")
;

ALTER TABLE "fase" ADD CONSTRAINT "PK_fase"
	PRIMARY KEY ("id")
;

CREATE INDEX "IXFK_formulario_pessoa" ON "formulario" ("id_pessoa" ASC)
;

ALTER TABLE "formulario" ADD CONSTRAINT "PK_formulario"
	PRIMARY KEY ("id")
;

CREATE INDEX "IXFK_formulario_pergunta_formulario" ON "formulario_pergunta" ("id_formulario" ASC)
;

ALTER TABLE "formulario_pergunta" ADD CONSTRAINT "PK_formulario_pergunta"
	PRIMARY KEY ("id")
;

CREATE INDEX "IXFK_formulario_pergunta_alternativa_formulario_pergunta" ON "formulario_pergunta_alternativa" ("id_formulario_pergunta" ASC)
;

ALTER TABLE "formulario_pergunta_alternativa" ADD CONSTRAINT "PK_formulario_pergunta_alternativa"
	PRIMARY KEY ("id")
;

CREATE INDEX "IXFK_formulario_pergunta_resposta_formulario_pergunta" ON "formulario_pergunta_resposta" ("id_formulario_pergunta" ASC)
;

ALTER TABLE "formulario_pergunta_resposta" ADD CONSTRAINT "PK_formulario_pergunta_resposta"
	PRIMARY KEY ("id")
;

ALTER TABLE "grupo_acesso" ADD CONSTRAINT "PK_grupo_acesso"
	PRIMARY KEY ("id")
;

CREATE INDEX "IXFK_pessoa_curso" ON "pessoa" ("id_curso" ASC)
;

CREATE INDEX "IXFK_pessoa_fase" ON "pessoa" ("id_fase" ASC)
;

ALTER TABLE "pessoa" ADD CONSTRAINT "PK_pessoa"
	PRIMARY KEY ("id")
;

CREATE INDEX "IXFK_usuario_pessoa" ON "usuario" ("id_pessoa" ASC)
;

ALTER TABLE "usuario" ADD CONSTRAINT "PK_usuario"
	PRIMARY KEY ("id")
;

CREATE INDEX "IXFK_usuario_grupo_grupo_acesso" ON "usuario_grupo" ("id_grupo_acesso" ASC)
;

CREATE INDEX "IXFK_usuario_grupo_usuario" ON "usuario_grupo" ("id_usuario" ASC)
;

ALTER TABLE "usuario_grupo" ADD CONSTRAINT "PK_usuario_grupo"
	PRIMARY KEY ("id")
;

ALTER TABLE "formulario" ADD CONSTRAINT "FK_formulario_pessoa"
	FOREIGN KEY ("id_pessoa") REFERENCES "pessoa" ("id") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "formulario_pergunta" ADD CONSTRAINT "FK_formulario_pergunta_formulario"
	FOREIGN KEY ("id_formulario") REFERENCES "formulario" ("id") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "formulario_pergunta_alternativa" ADD CONSTRAINT "FK_formulario_pergunta_alternativa_formulario_pergunta"
	FOREIGN KEY ("id_formulario_pergunta") REFERENCES "formulario_pergunta" ("id") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "formulario_pergunta_resposta" ADD CONSTRAINT "FK_formulario_pergunta_resposta_formulario_pergunta"
	FOREIGN KEY ("id_formulario_pergunta") REFERENCES "formulario_pergunta" ("id") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "pessoa" ADD CONSTRAINT "FK_pessoa_curso"
	FOREIGN KEY ("id_curso") REFERENCES "curso" ("id") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "pessoa" ADD CONSTRAINT "FK_pessoa_fase"
	FOREIGN KEY ("id_fase") REFERENCES "fase" ("id") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "usuario" ADD CONSTRAINT "FK_usuario_pessoa"
	FOREIGN KEY ("id_pessoa") REFERENCES "pessoa" ("id") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "usuario_grupo" ADD CONSTRAINT "FK_usuario_grupo_grupo_acesso"
	FOREIGN KEY ("id_grupo_acesso") REFERENCES "grupo_acesso" ("id") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "usuario_grupo" ADD CONSTRAINT "FK_usuario_grupo_usuario"
	FOREIGN KEY ("id_usuario") REFERENCES "usuario" ("id") ON DELETE No Action ON UPDATE No Action
;
