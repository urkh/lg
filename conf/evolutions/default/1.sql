# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table agua (
  id                        bigint not null,
  persona_id                bigint,
  monto                     double,
  fecha_pago                timestamp,
  mes_correspondiente       timestamp,
  constraint pk_agua primary key (id))
;

create table alimentacion (
  id                        bigint not null,
  persona_id                bigint,
  denuncia                  varchar(255),
  fecha                     timestamp,
  denunciado                varchar(255),
  constraint pk_alimentacion primary key (id))
;

create table cultura (
  id                        bigint not null,
  h_personas_id             bigint,
  t_pantalon                varchar(255),
  t_franelas                varchar(255),
  t_zapatos                 varchar(255),
  utiles                    varchar(255),
  fecha                     timestamp,
  constraint pk_cultura primary key (id))
;

create table economia (
  id                        bigint not null,
  persona_id                bigint,
  fecha                     timestamp,
  solicitud                 varchar(255),
  tipo_sol                  varchar(255),
  empresa                   varchar(255),
  turno                     varchar(255),
  dias                      varchar(255),
  constraint pk_economia primary key (id))
;

create table hijos_personas (
  id                        bigint not null,
  persona_id                bigint,
  cedula                    integer,
  nombre                    varchar(255),
  apellido                  varchar(255),
  fecha_nac                 timestamp,
  sexo                      varchar(255),
  discapacidad              varchar(255),
  grado                     varchar(255),
  constraint pk_hijos_personas primary key (id))
;

create table igualdad_social (
  id                        bigint not null,
  persona_id                bigint,
  tipo_ayuda                varchar(255),
  fecha                     timestamp,
  constraint pk_igualdad_social primary key (id))
;

create table persona (
  id                        bigint not null,
  cedula                    integer,
  nombre                    varchar(255),
  apellido                  varchar(255),
  fecha_nac                 timestamp,
  sexo                      varchar(255),
  direccion                 varchar(255),
  telefono                  varchar(255),
  grado_instruccion         varchar(255),
  ingreso_mensual           double,
  estado_civil              varchar(255),
  tipo_vivienda             varchar(255),
  constraint pk_persona primary key (id))
;

create table salud (
  id                        bigint not null,
  persona_id                bigint,
  fecha                     timestamp,
  enfermedad                varchar(255),
  medicamentos              varchar(255),
  tipo_op                   varchar(255),
  tiempo_enf                varchar(255),
  constraint pk_salud primary key (id))
;

create table transporte (
  id                        bigint not null,
  h_personas_id             bigint,
  monto                     double,
  fecha_pago                timestamp,
  mes_correspondiente       timestamp,
  constraint pk_transporte primary key (id))
;

create table vivienda (
  id                        bigint not null,
  persona_id                bigint,
  solicitud                 varchar(255),
  fecha_sol                 timestamp,
  rehabilitacion            varchar(255),
  constraint pk_vivienda primary key (id))
;

create sequence agua_seq;

create sequence alimentacion_seq;

create sequence cultura_seq;

create sequence economia_seq;

create sequence hijos_personas_seq;

create sequence igualdad_social_seq;

create sequence persona_seq;

create sequence salud_seq;

create sequence transporte_seq;

create sequence vivienda_seq;

alter table agua add constraint fk_agua_persona_1 foreign key (persona_id) references persona (id) on delete restrict on update restrict;
create index ix_agua_persona_1 on agua (persona_id);
alter table alimentacion add constraint fk_alimentacion_persona_2 foreign key (persona_id) references persona (id) on delete restrict on update restrict;
create index ix_alimentacion_persona_2 on alimentacion (persona_id);
alter table cultura add constraint fk_cultura_hPersonas_3 foreign key (h_personas_id) references hijos_personas (id) on delete restrict on update restrict;
create index ix_cultura_hPersonas_3 on cultura (h_personas_id);
alter table economia add constraint fk_economia_persona_4 foreign key (persona_id) references persona (id) on delete restrict on update restrict;
create index ix_economia_persona_4 on economia (persona_id);
alter table hijos_personas add constraint fk_hijos_personas_persona_5 foreign key (persona_id) references persona (id) on delete restrict on update restrict;
create index ix_hijos_personas_persona_5 on hijos_personas (persona_id);
alter table igualdad_social add constraint fk_igualdad_social_persona_6 foreign key (persona_id) references persona (id) on delete restrict on update restrict;
create index ix_igualdad_social_persona_6 on igualdad_social (persona_id);
alter table salud add constraint fk_salud_persona_7 foreign key (persona_id) references persona (id) on delete restrict on update restrict;
create index ix_salud_persona_7 on salud (persona_id);
alter table transporte add constraint fk_transporte_hPersonas_8 foreign key (h_personas_id) references hijos_personas (id) on delete restrict on update restrict;
create index ix_transporte_hPersonas_8 on transporte (h_personas_id);
alter table vivienda add constraint fk_vivienda_persona_9 foreign key (persona_id) references persona (id) on delete restrict on update restrict;
create index ix_vivienda_persona_9 on vivienda (persona_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists agua;

drop table if exists alimentacion;

drop table if exists cultura;

drop table if exists economia;

drop table if exists hijos_personas;

drop table if exists igualdad_social;

drop table if exists persona;

drop table if exists salud;

drop table if exists transporte;

drop table if exists vivienda;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists agua_seq;

drop sequence if exists alimentacion_seq;

drop sequence if exists cultura_seq;

drop sequence if exists economia_seq;

drop sequence if exists hijos_personas_seq;

drop sequence if exists igualdad_social_seq;

drop sequence if exists persona_seq;

drop sequence if exists salud_seq;

drop sequence if exists transporte_seq;

drop sequence if exists vivienda_seq;

