# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table agua (
  id                        bigint auto_increment not null,
  persona_id                bigint,
  monto                     double,
  fecha_pago                varchar(255),
  mes_correspondiente       varchar(255),
  constraint pk_agua primary key (id))
;

create table alimentacion (
  id                        bigint auto_increment not null,
  persona_id                bigint,
  denuncia                  varchar(255),
  fecha                     datetime,
  denunciado                varchar(255),
  constraint pk_alimentacion primary key (id))
;

create table cultura (
  id                        bigint auto_increment not null,
  hijos_id                  bigint,
  t_pantalon                varchar(255),
  t_franelas                varchar(255),
  t_zapatos                 varchar(255),
  utiles                    varchar(255),
  fecha                     varchar(255),
  constraint pk_cultura primary key (id))
;

create table economia (
  id                        bigint auto_increment not null,
  persona_id                bigint,
  fecha                     varchar(255),
  solicitud                 varchar(255),
  tipo_sol                  varchar(255),
  empresa                   varchar(255),
  turno                     varchar(255),
  dias                      varchar(255),
  constraint pk_economia primary key (id))
;

create table hijos (
  id                        bigint auto_increment not null,
  persona_id                bigint,
  cedula_h                  integer,
  nombre_h                  varchar(255),
  apellido_h                varchar(255),
  fecha_nac                 varchar(255),
  sexo                      varchar(255),
  discapacidad              varchar(255),
  grado                     varchar(255),
  constraint pk_hijos primary key (id))
;

create table igualdad_social (
  id                        bigint auto_increment not null,
  persona_id                bigint,
  tipo_ayuda                varchar(255),
  fecha                     varchar(255),
  constraint pk_igualdad_social primary key (id))
;

create table persona (
  id                        bigint auto_increment not null,
  cedula                    integer,
  nombre                    varchar(255),
  apellido                  varchar(255),
  fecha_nac                 varchar(255),
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
  id                        bigint auto_increment not null,
  persona_id                bigint,
  fecha                     varchar(255),
  enfermedad                varchar(255),
  medicamentos              varchar(255),
  tipo_op                   varchar(255),
  tiempo_enf                varchar(255),
  constraint pk_salud primary key (id))
;

create table transporte (
  id                        bigint auto_increment not null,
  hijos_id                  bigint,
  monto                     double,
  fecha_pago                varchar(255),
  mes_correspondiente       varchar(255),
  constraint pk_transporte primary key (id))
;

create table vivienda (
  id                        bigint auto_increment not null,
  persona_id                bigint,
  solicitud                 varchar(255),
  fecha_sol                 varchar(255),
  rehabilitacion            varchar(255),
  constraint pk_vivienda primary key (id))
;

alter table agua add constraint fk_agua_persona_1 foreign key (persona_id) references persona (id) on delete restrict on update restrict;
create index ix_agua_persona_1 on agua (persona_id);
alter table alimentacion add constraint fk_alimentacion_persona_2 foreign key (persona_id) references persona (id) on delete restrict on update restrict;
create index ix_alimentacion_persona_2 on alimentacion (persona_id);
alter table cultura add constraint fk_cultura_hijos_3 foreign key (hijos_id) references hijos (id) on delete restrict on update restrict;
create index ix_cultura_hijos_3 on cultura (hijos_id);
alter table economia add constraint fk_economia_persona_4 foreign key (persona_id) references persona (id) on delete restrict on update restrict;
create index ix_economia_persona_4 on economia (persona_id);
alter table hijos add constraint fk_hijos_persona_5 foreign key (persona_id) references persona (id) on delete restrict on update restrict;
create index ix_hijos_persona_5 on hijos (persona_id);
alter table igualdad_social add constraint fk_igualdad_social_persona_6 foreign key (persona_id) references persona (id) on delete restrict on update restrict;
create index ix_igualdad_social_persona_6 on igualdad_social (persona_id);
alter table salud add constraint fk_salud_persona_7 foreign key (persona_id) references persona (id) on delete restrict on update restrict;
create index ix_salud_persona_7 on salud (persona_id);
alter table transporte add constraint fk_transporte_hijos_8 foreign key (hijos_id) references hijos (id) on delete restrict on update restrict;
create index ix_transporte_hijos_8 on transporte (hijos_id);
alter table vivienda add constraint fk_vivienda_persona_9 foreign key (persona_id) references persona (id) on delete restrict on update restrict;
create index ix_vivienda_persona_9 on vivienda (persona_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table agua;

drop table alimentacion;

drop table cultura;

drop table economia;

drop table hijos;

drop table igualdad_social;

drop table persona;

drop table salud;

drop table transporte;

drop table vivienda;

SET FOREIGN_KEY_CHECKS=1;

