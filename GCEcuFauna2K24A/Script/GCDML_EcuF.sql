-- database: ../DataBase/GCEcuAFauna.sqlite

INSERT INTO GCCatalogoTipo
 ( Nombre,               Descripcion )  VALUES
( "Tipo hormiga "       ,"larva, soldado...")
,( "Sexo"               ,"Macho, hembra...")
,( "Ingesta Nativa"     ,"Carnivoro, herbivoro...")
,( "GenoAlimento"       ,"XX,XY,X,,,");



INSERT INTO GCCatalogo
 ( IdCatalogoTipo ,Nombre         ,Descripcion   ) VALUES

 (  1             ,'Larva'      ,'Tipo de hormiga')  -- 1
,(  1             ,'Solado'     ,'Tipo de hormiga')  -- 2
,(  1             ,'Zangano'    ,'Tipo de hormiga')  -- 3
,(  1             ,'Reina'      ,'Tipo de hormiga')  -- 4

,(  2            ,'Masculino'   ,'tipos de sexualida')             -- 5
,(  2            ,'Femenino'    ,'tipos de sexualida')             -- 6
,(  2            ,'Asexual'     ,'tipos de sexualida')             -- 7

,(  3            ,'Carnivoro'     ,'Tipo de Dieta de la hormiga')       -- 9
,(  3            ,'Herbivoro'     ,'Tipo de Dieta de la hormiga')       -- 10
,(  3            ,'Omnivoro'      ,'Tipo de Dieta de la hormiga')       -- 11
,(  3            ,'Insectivoro'   ,'Tipo de Dieta de la hormiga')       -- 12

,(  4            ,'XX'       ,'Tipo de Genoalimento')
,(  4            ,'XY'       ,'Tipo de Genoalimento')
,(  4            ,'X'        ,'Tipo de Genoalimento');


INSERT INTO GCUbicacion 
(Region, provincia) VALUES
( "Costa", "Esmeraldas"),       
( "Costa", "Manabí"),           
( "Costa", "Los Ríos"),         
( "Costa", "Guayas"),           
( "Costa", "Santa Elena"),      
( "Costa", "Santo Domingo"),    


-- Provincias en la Sierra
("Sierra" , "Carchi"),           
("Sierra" , "Imbabura"),         
("Sierra" , "Pichincha"),        
("Sierra" , "Cotopaxi"),         
("Sierra" , "Tungurahua"),       
("Sierra" , "Bolívar"),          
("Sierra", "Chimborazo"),       
("Sierra" , "Cañar"),            
("Sierra" , "Azuay"),            
("Sierra" , "Loja"),             

-- Provincias en el Oriente
( "Oriente", "Sucumbíos"),        
( "Oriente", "Napo"),             
( "Oriente", "Orellana"),         
( "Oriente", "Pastaza"),          
( "Oriente", "Morona Santiago"),  
( "Oriente", "Zamora Chinchipe"), 

-- Provincias en la Región Insular
("Insular", "Galápagos");        


INSERT INTO GCHormiga 
(IdClgTipoHormiga, IdClgIngestaNativa, IdClgGenoAlimento, IdClgSexo, IdUbicacion) VALUES
   ( 2,                8,               13,                   5,                 1 ),
   ( 3,                10,              13,                   7,                 7 ),
   ( 1,                8,               14,                   5,                16 ),
   ( 4,                9,               12,                   6,                11 );


SELECT H.IdHormiga, GCC.Nombre AS Sexo, GCC.IdCatalogoTipo
FROM GCHormiga H
JOIN GCCatalogo GCC ON H.IdClgTipoHormiga = GCC.IdCatalogo;

DELETE FROM GCHormiga 
WHERE IdClgTipoHormiga IN (2, 3, 1, 4)
AND IdClgIngestaNativa IN (8, 10, 8, 9)
AND IdClgGenoAlimento IN (13, 13, 14, 12)
AND IdClgSexo IN (5, 7, 5, 6)
AND IdUbicacion IN (1, 7, 16, 11);


