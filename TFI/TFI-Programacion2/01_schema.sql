-- 01_schema.sql — MySQL 8 — Producto -> CodigoBarras (1→1 unidireccional: A=Producto referencia B=CodigoBarras)
DROP DATABASE IF EXISTS tfi_prog2;
CREATE DATABASE tfi_prog2 CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE tfi_prog2;

-- Tabla B
CREATE TABLE CodigoBarras (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  valor CHAR(13) NOT NULL,
  tipo ENUM('EAN13','UPC','EAN8') NOT NULL DEFAULT 'EAN13',
  eliminado TINYINT(1) NOT NULL DEFAULT 0,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT uq_codigobarras_valor UNIQUE (valor),
  CONSTRAINT ck_codigobarras_valor_len CHECK (CHAR_LENGTH(valor) = 13),
  CONSTRAINT ck_codigobarras_valor_digits CHECK (valor REGEXP '^[0-9]{13}$')
);

-- Tabla A — A referencia a B (1→1)
CREATE TABLE Producto (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(120) NOT NULL,
  marca  VARCHAR(80),
  precio DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  unidad_medida VARCHAR(16) NOT NULL DEFAULT 'unidad',
  eliminado TINYINT(1) NOT NULL DEFAULT 0,
  codigo_barras_id BIGINT UNIQUE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_prod_cb FOREIGN KEY (codigo_barras_id) REFERENCES CodigoBarras(id)
    ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- Índices útiles
CREATE INDEX idx_producto_nombre ON Producto(nombre);
