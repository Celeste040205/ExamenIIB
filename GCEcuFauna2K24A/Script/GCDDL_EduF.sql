-- database: ../DataBase/GCEcuFauna.sqlite
/*
|---------------------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved.            |
| maria.gallardo01@epn.edu.ec     Celeste Gallardo  |
|--------------------------------------------------|
Autor : Celeste Gallardo 
Fecha : 14.agosto.2k24
Script: Creacion de la estructura de datos para GCEcuFauna
*/

DROP TABLE IF EXISTS GCUbicacion;
DROP TABLE IF EXISTS GCHormiga;
DROP TABLE IF EXISTS GCGenoAlimentoSexo;
DROP TABLE IF EXISTS GCSexo;
DROP TABLE IF EXISTS GCGenoAlimento;
DROP TABLE IF EXISTS GCIngestaNativa;
DROP TABLE IF EXISTS GCAlimento;

CREATE TABLE GCUbicacion (
     IdUbicacion    INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Pais           VARCHAR(10) NOT NULL DEFAULT ('Ecuador') 
    ,Region         VARCHAR(10)  
    ,Provincia      VARCHAR(20)  
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion  DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica  DATETIME
); 

CREATE TABLE GCIngestaNativa (
     IdIngestaNativa    INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,TipoIngesta        VARCHAR(10) UNIQUE
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion  DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica  DATETIME
);

CREATE TABLE GCGenoAlimento (
     IdGenoAlimento    INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,TipoGeno           VARCHAR(10) UNIQUE
    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica      DATETIME
);

CREATE TABLE GCSexo (
     IdSexo            INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,TipoSexo          VARCHAR(10) 
    ,Estado            VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion     DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica     DATETIME
);


CREATE TABLE GCAlimento (
     IdAlimento             INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdIngestaNativa        INTEGER     NOT NULL REFERENCES GCIngestaNativa(IdIngestaNativa)
    ,IdGenoAlimento         INTEGER     NOT NULL REFERENCES GCGenoAlimento(IdGenoAlimento)
    ,Estado                 VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion          DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica          DATETIME
);

CREATE TABLE GCHormiga (
    IdHormiga              INTEGER         NOT NULL PRIMARY KEY AUTOINCREMENT
    ,TipoHormiga            VARCHAR(10)     NOT NULL 
    ,IdIngestaNativa        INTEGER         NOT NULL REFERENCES GCIngestaNativa(IdIngestaNativa)
    ,IdGenoAlimento         INTEGER         NOT NULL REFERENCES GCGenoAlimento(IdGenoAlimento)
    ,IdSexo                 INTEGER         NOT NULL REFERENCES GCSexo(IdSexo)
    ,IdUbicacion            INTEGER         NOT NULL REFERENCES MJUbicacion(IdUbicacion)
    ,Estado                 VARCHAR(1)      NOT NULL DEFAULT('A')
    ,FechaCreacion          DATETIME        DEFAULT(datetime('now','localtime'))
    ,FechaModifica          DATETIME

    );


