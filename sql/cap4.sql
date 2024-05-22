CREATE TABLE director (
    id_director  NUMBER(10) PRIMARY KEY,
    nombre       VARCHAR2(100),
    nacionalidad VARCHAR2(100)
);

CREATE TABLE productora (
    id_productora NUMBER(10) PRIMARY KEY,
    nombre        VARCHAR2(100),
    pais          VARCHAR2(100)
);

CREATE TABLE pelicula (
    id_pelicula NUMBER(10) PRIMARY KEY,
    titulo      VARCHAR2(100),
    año         NUMBER(5),
    genero      VARCHAR2(100),
    director    NUMBER(10),
    productora  NUMBER(10),
    recaudacion NUMBER(10, 2),
    presupuesto NUMBER(10, 2)
);

ALTER TABLE pelicula
    ADD CONSTRAINT director FOREIGN KEY ( director )
        REFERENCES director ( id_director );

ALTER TABLE pelicula
    ADD CONSTRAINT productora FOREIGN KEY ( productora )
        REFERENCES productora ( id_productora );

INSERT INTO director VALUES (
    1,
    'Steven Spielberg',
    'Estadounidense'
);

INSERT INTO director VALUES (
    2,
    'Patty Jenkins',
    'Estadounidense'
);

INSERT INTO director VALUES (
    3,
    'Julius Avery',
    'Australiano'
);

INSERT INTO director VALUES (
    4,
    'Guy Ritchie',
    'Británico'
);

INSERT INTO director VALUES (
    5,
    'Hermanas Wachowski',
    'Estadounidense'
);

INSERT INTO director VALUES (
    6,
    'Santiago Segura',
    'Española'
);

INSERT INTO productora VALUES (
    1,
    'Warner Bros',
    'Estados Unidos'
);

INSERT INTO productora VALUES (
    2,
    'Paramount Pictures',
    'California'
);

INSERT INTO productora VALUES (
    3,
    '20th Century Fox',
    'Estados Unidos'
);

INSERT INTO pelicula VALUES (
    1,
    'Ready Player One: Comienza el juego',
    2018,
    'Ciencia Ficción',
    1,
    1,
    582,
    175
);

INSERT INTO pelicula VALUES (
    2,
    'Mujer Maravilla',
    2017,
    'Ciencia Ficción',
    2,
    1,
    822,
    149
);

INSERT INTO pelicula VALUES (
    3,
    'Overlord',
    2018,
    'Terror',
    3,
    2,
    84.7,
    38
);

INSERT INTO pelicula VALUES (
    4,
    'Snatch, cerdos y diamantes',
    2000,
    'Acción',
    4,
    3,
    93.6,
    6
);

INSERT INTO pelicula VALUES (
    5,
    'Pruebas Varias',
    1982,
    'Comedia',
    2,
    3,
    35.2,
    10
);

INSERT INTO pelicula VALUES (
    6,
    'Otras Pruebas',
    2018,
    'Comedia',
    4,
    2,
    94.5,
    15
);

INSERT INTO pelicula VALUES (
    7,
    'Torrente',
    1998,
    'Comedia',
    6,
    NULL,
    10.9,
    12.7
);

INSERT INTO pelicula VALUES (
    8,
    'Pruebas Null',
    2018,
    'Comedia',
    NULL,
    NULL,
    100,
    30
);

INSERT INTO pelicula VALUES (
    9,
    'E.T',
    1982,
    'Ciencia Ficción',
    1,
    1,
    730,
    10.5
);

INSERT INTO pelicula VALUES (
    10,
    'Matrix',
    1999,
    'Ciencia Ficción',
    5,
    1,
    464.5,
    63
);

INSERT INTO pelicula VALUES (
    11,
    'Jurassic Park',
    1993,
    'Ciencia Ficción',
    1,
    1,
    1029,
    63
);
commit;

SELECT p.* FROM pelicula p;