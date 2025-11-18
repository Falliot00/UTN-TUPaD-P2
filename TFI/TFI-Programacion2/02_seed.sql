-- 02_seed.sql — Datos de prueba
USE tfi_prog2;

INSERT INTO CodigoBarras (valor, tipo) VALUES
('7791234567890','EAN13'),
('7790001112223','EAN13'),
('1234567890123','EAN13');

INSERT INTO Producto (nombre, marca, precio, unidad_medida, codigo_barras_id) VALUES
('Yerba Mate 1kg','Taragui', 4900.00,'kg', 1),
('Aceite Girasol 1lt','Natura', 3500.00,'lt', 2);

-- Producto sin CB asociado (permitido por el modelo)
INSERT INTO Producto (nombre, marca, precio, unidad_medida) VALUES
('Bolsa de basura','Genérica', 1200.00,'pz');
