-- database: ../DataBase/GCEcuAFauna.sqlite


DROP TABLE IF EXISTS GCHormiga;
DROP TABLE IF EXISTS GCUbicacion;
DROP TABLE IF EXISTS GCCatalogo;
DROP TABLE IF EXISTS GCCatalogoTipo;


CREATE TABLE GCCatalogoTipo (
     IdCatalogoTipo INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre         VARCHAR(10) NOT NULL UNIQUE
    ,Descripcion    VARCHAR(90)  

    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion  DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica  DATETIME
); 


CREATE TABLE GCCatalogo (
     IdCatalogo     INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdCatalogoTipo INTEGER     NOT NULL REFERENCES GCCatalogoTipo (IdCatalogoTipo)
    ,Nombre         VARCHAR(10) NOT NULL UNIQUE
    ,Descripcion    VARCHAR(90)   

    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion  DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica  DATETIME
); 


CREATE TABLE GCUbicacion (
     IdUbicacion    INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Pais           VARCHAR(10) NOT NULL DEFAULT ('Ecuador') 
    ,Region         VARCHAR(10)  
    ,Provincia      VARCHAR(20)  
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion  DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica  DATETIME
); 


    CREATE TABLE GCHormiga (
        IdHormiga                  INTEGER         NOT NULL PRIMARY KEY AUTOINCREMENT
        ,IdClgTipoHormiga          INTEGER         NOT NULL REFERENCES GCCatalogo(IdCatalogo)
        ,IdClgIngestaNativa        INTEGER         NOT NULL REFERENCES GCCatalogo(IdCatalogo) 
        ,IdClgGenoAlimento         INTEGER         NOT NULL REFERENCES GCCatalogo(IdCatalogo)
        ,IdclgSexo                 INTEGER         NOT NULL REFERENCES GCCatalogo(IdCatalogo)
        ,IdUbicacion               INTEGER         NOT NULL REFERENCES GCUbicacion(IdUbicacion)
        ,Estado                    VARCHAR(1)      NOT NULL DEFAULT('A')
        ,FechaCreacion             DATETIME        DEFAULT(datetime('now','localtime'))
        ,FechaModifica             DATETIME

    );

