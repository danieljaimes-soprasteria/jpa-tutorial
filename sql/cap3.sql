CREATE TABLE leaf_type (
    leaf_id   INT PRIMARY KEY,
    leaf_name VARCHAR2(32)
);

CREATE TABLE habitat (
    habitat_id   INT PRIMARY KEY,
    habitat_name VARCHAR2(32)
);

CREATE TABLE trees (
    tree_id   INT PRIMARY KEY,
    tree_name VARCHAR2(64),
    leaf_type INT
        REFERENCES leaf_type ( leaf_id ),
    habitat   INT
        REFERENCES habitat ( habitat_id )
);

CREATE TABLE bushes (
    bush_id          INT PRIMARY KEY,
    bush_name        VARCHAR2(64),
    leaf_id          INT
        REFERENCES leaf_type ( leaf_id ),
    habitat_id       INT
        REFERENCES habitat ( habitat_id ),
    bush_description CLOB
);

CREATE TABLE compatibles (
    compatible_id   INT PRIMARY KEY,
    tree_id         INT
        REFERENCES trees ( tree_id ),
    bush_id         INT
        REFERENCES bushes ( bush_id ),
    compatible_risk INT
);

INSERT INTO leaf_type VALUES (
    1,
    'PERENNE'
);

INSERT INTO leaf_type VALUES (
    2,
    'CADUCA'
);

INSERT INTO habitat VALUES (
    1,
    'TROPICAL'
);

INSERT INTO habitat VALUES (
    2,
    'HUMEDO'
);

INSERT INTO habitat VALUES (
    3,
    'SECO'
);

INSERT INTO habitat VALUES (
    4,
    'CALIDO'
);

INSERT INTO trees VALUES (
    1,
    'Abies pinsapo',
    1,
    1
);

INSERT INTO trees VALUES (
    2,
    'Acer campestre',
    2,
    2
);

INSERT INTO trees VALUES (
    3,
    'Betula pendula',
    2,
    2
);

INSERT INTO trees VALUES (
    4,
    'Ceratonia siliqua',
    2,
    3
);

INSERT INTO trees VALUES (
    5,
    'Citrus aurantium',
    1,
    4
);

CREATE TABLE located (
    located_id    INT PRIMARY KEY,
    located_name  VARCHAR2(64),
    located_coord VARCHAR2(32)
);

CREATE TABLE flora (
    flora_id      INT PRIMARY KEY,
    flora_type_id INT,
    flora_type    VARCHAR2(32),
    located_id    INT
        REFERENCES located ( located_id )
);

CREATE SEQUENCE seq MINVALUE 1 START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE seq2 MINVALUE 1 START WITH 1 INCREMENT BY 50;