-- V2 Migration adiciona coluna Equipamento na tabela cadastro

ALTER TABLE tb_cadastro
ADD COLUMN equipamento VARCHAR(255);