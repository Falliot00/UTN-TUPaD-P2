-- 03_verify.sql — Checks de integridad y 1→1

USE tfi_prog2;

-- a) Unique del valor de CodigoBarras
SELECT valor, COUNT(*) c
FROM CodigoBarras
GROUP BY valor
HAVING c > 1;

-- b) Unique de la relación 1→1 (Producto.codigo_barras_id)
SELECT codigo_barras_id, COUNT(*) c
FROM Producto
WHERE codigo_barras_id IS NOT NULL
GROUP BY codigo_barras_id
HAVING c > 1;

-- c) Conteos básicos
SELECT (SELECT COUNT(*) FROM CodigoBarras) AS cb_count,
       (SELECT COUNT(*) FROM Producto) AS p_count;

-- d) Productos sin CB asociado (permitido por el modelo)
SELECT id, nombre FROM Producto WHERE codigo_barras_id IS NULL;

-- e) Join de validación
SELECT p.id, p.nombre, cb.valor, cb.tipo
FROM Producto p LEFT JOIN CodigoBarras cb ON p.codigo_barras_id = cb.id
ORDER BY p.id;
