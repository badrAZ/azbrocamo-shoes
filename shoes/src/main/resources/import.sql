--
-- JBoss, Home of Professional Open Source
-- Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- This script initializes the database by creating tables and inserting data
-- Use only for a proof of concept

-- You can use this file to load seed data into the database using SQL statements

insert into Modele (nomModele, note,prix,photo,description) values ('A200',20,20,"http://www.chausport.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/8/0/8078-chaussures-converse-chuck-taylor-all-star-haute-vue-interieure.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."); 
insert into Modele (nomModele, note,prix,photo,description) values ('A400',30,1000,"http://imworld.aufeminin.com/manage/bloc/D20150601/Chaussure-femme-Escarpin-Dior-112213-XL-163723_XL.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."); 
insert into Modele (nomModele, note,prix,photo,description) values ('A300',20,800,"http://www.grandes-chaussures.com/Files/21851/Img/01/Chaussures-grandes-pointures-hommes-Romika-R10L01B2-DxN.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."); 
insert into Modele (nomModele, note,prix,photo,description) values ('A800',20,60,"http://www.chemises-chaussures-hommes.com/330-969/chaussures-habillees-homme.jpg","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."); 
insert into Modele (nomModele, note,prix,photo,description) values ('A500',20,2000,"http://azure.sarenza.net/static/_img/productsV4/0000053483/HD_0000053483_91562_09.jpg?201202171658","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."); 

insert into Categorie (nomCategorie) values('Classiques');
insert into Categorie (nomCategorie) values('Marche');
insert into Categorie (nomCategorie) values('Pantoufles');
insert into Categorie (nomCategorie) values('Ville');
insert into Categorie (nomCategorie) values('Sport');

insert into ModeleCategorie (nomModele,nomCategorie) values('A200','Sport');
insert into ModeleCategorie (nomModele,nomCategorie) values('A200','Marche');
insert into ModeleCategorie (nomModele,nomCategorie) values('A400','Ville');
insert into ModeleCategorie (nomModele,nomCategorie) values('A400','Marche');
insert into ModeleCategorie (nomModele,nomCategorie) values('A300','Classiques');
insert into ModeleCategorie (nomModele,nomCategorie) values('A500','Classiques');
insert into ModeleCategorie (nomModele,nomCategorie) values('A800','Classiques');
