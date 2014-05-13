# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table actualites (
  id                        bigint auto_increment not null,
  creation                  datetime,
  texte_court               varchar(255),
  texte_long                varchar(255),
  constraint pk_actualites primary key (id))
;

create table championnat (
  id                        bigint auto_increment not null,
  nom                       varchar(255),
  logo                      integer,
  creation                  varchar(255),
  site                      varchar(255),
  pays_id                   bigint,
  constraint pk_championnat primary key (id))
;

create table club (
  id                        bigint auto_increment not null,
  nom                       varchar(255),
  championnat_id            bigint,
  logo                      integer,
  premiere_saison           varchar(255),
  nombre_titres             integer,
  nom_complet               varchar(255),
  surnoms                   varchar(255),
  fondation                 varchar(255),
  couleurs                  varchar(255),
  siege                     varchar(255),
  site                      varchar(255),
  constraint pk_club primary key (id))
;

create table connaissance (
  id                        bigint auto_increment not null,
  type_connaissance_id      bigint not null,
  nom                       varchar(255),
  level                     integer,
  importance                integer,
  constraint pk_connaissance primary key (id))
;

create table emploi (
  id                        bigint auto_increment not null,
  nom                       varchar(255),
  logo                      varchar(255),
  debut                     varchar(255),
  fin                       varchar(255),
  constraint pk_emploi primary key (id))
;

create table experience (
  id                        bigint auto_increment not null,
  emploi_id                 bigint not null,
  ordre                     integer,
  logo                      varchar(255),
  contexte                  varchar(255),
  poste                     varchar(255),
  duree                     varchar(255),
  envtechnique              varchar(255),
  encre_id                  varchar(255),
  client                    varchar(255),
  debut                     varchar(255),
  fin                       varchar(255),
  constraint pk_experience primary key (id))
;

create table formation (
  id                        bigint auto_increment not null,
  titre                     varchar(255),
  description               varchar(255),
  enseignement              varchar(255),
  etablissement             varchar(255),
  ordre                     integer,
  id_map                    varchar(255),
  latitude                  double,
  longitude                 double,
  constraint pk_formation primary key (id))
;

create table image (
  id                        integer auto_increment not null,
  type                      varchar(255),
  contenu                   mediumblob,
  constraint pk_image primary key (id))
;

create table information (
  id                        bigint auto_increment not null,
  ordre                     integer,
  texte                     varchar(255),
  type_id                   bigint,
  constraint pk_information primary key (id))
;

create table joueur (
  id                        bigint auto_increment not null,
  nom                       varchar(255),
  prenom                    varchar(255),
  club_id                   bigint,
  constraint pk_joueur primary key (id))
;

create table pays (
  id                        bigint auto_increment not null,
  nom                       varchar(255),
  drapeau                   integer,
  constraint pk_pays primary key (id))
;

create table tache_experience (
  id                        bigint auto_increment not null,
  experience_id             bigint not null,
  description               varchar(255),
  constraint pk_tache_experience primary key (id))
;

create table type_connaissance (
  id                        bigint auto_increment not null,
  nom                       varchar(255),
  constraint pk_type_connaissance primary key (id))
;

create table type_information (
  id                        bigint auto_increment not null,
  nom                       varchar(255),
  prefix_image              varchar(255),
  constraint pk_type_information primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  login                     varchar(255),
  password                  varchar(255),
  constraint pk_user primary key (id))
;

alter table championnat add constraint fk_championnat_pays_1 foreign key (pays_id) references pays (id) on delete restrict on update restrict;
create index ix_championnat_pays_1 on championnat (pays_id);
alter table club add constraint fk_club_championnat_2 foreign key (championnat_id) references championnat (id) on delete restrict on update restrict;
create index ix_club_championnat_2 on club (championnat_id);
alter table connaissance add constraint fk_connaissance_type_connaissance_3 foreign key (type_connaissance_id) references type_connaissance (id) on delete restrict on update restrict;
create index ix_connaissance_type_connaissance_3 on connaissance (type_connaissance_id);
alter table experience add constraint fk_experience_emploi_4 foreign key (emploi_id) references emploi (id) on delete restrict on update restrict;
create index ix_experience_emploi_4 on experience (emploi_id);
alter table information add constraint fk_information_type_5 foreign key (type_id) references type_information (id) on delete restrict on update restrict;
create index ix_information_type_5 on information (type_id);
alter table joueur add constraint fk_joueur_club_6 foreign key (club_id) references club (id) on delete restrict on update restrict;
create index ix_joueur_club_6 on joueur (club_id);
alter table tache_experience add constraint fk_tache_experience_experience_7 foreign key (experience_id) references experience (id) on delete restrict on update restrict;
create index ix_tache_experience_experience_7 on tache_experience (experience_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table actualites;

drop table championnat;

drop table club;

drop table connaissance;

drop table emploi;

drop table experience;

drop table formation;

drop table image;

drop table information;

drop table joueur;

drop table pays;

drop table tache_experience;

drop table type_connaissance;

drop table type_information;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

