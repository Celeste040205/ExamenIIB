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


INSERT INTO GCIngestaNativa
(TipoIngesta) VALUES
("Carnivoro"),
("Herbivoro"),
("Omnivoro"),
("Insectivoro");


INSERT INTO GCGenoAlimento
(TipoGeno) VALUES
("X"),
("XX"),
("XY");


INSERT INTO GCSexo
(TipoSexo) VALUES
("Asexual"),
("Macho"),
("Hembra");

INSERT INTO GCAlimento (IdIngestaNativa, IdGenoAlimento)
SELECT 
    i.IdIngestaNativa,
    g.IdGenoAlimento
FROM 
    GCIngestaNativa i,
    GCGenoAlimento g;

INSERT INTO GCHormiga (TipoHormiga, IdIngestaNativa, IdGenoAlimento, IdSexo, IdUbicacion) VALUES
   ( ('Reina'), 1,1,1,4 );







