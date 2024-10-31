INSERT INTO product_category (category_id, name, description) VALUES
(nextval('product_category_seq'), 'Periféricos', 'Dispositivos externos para interactuar con una computadora'),
(nextval('product_category_seq'), 'Almacenamiento', 'Dispositivos para guardar y transferir datos'),
(nextval('product_category_seq'), 'Componentes', 'Piezas internas que forman parte del hardware de una computadora'),
(nextval('product_category_seq'), 'Redes', 'Dispositivos relacionados con la conectividad y redes informáticas'),
(nextval('product_category_seq'), 'Software', 'Programas y sistemas operativos para computadoras');

INSERT INTO product (product_id, name, description, unit_price, stock, image_url, category_id) VALUES
(nextval('product_seq'), 'Teclado Mecánico', 'Teclado con interruptores mecánicos para mayor durabilidad', 75.99, 150, 'https://example.com/teclado-mecanico.jpg', (SELECT category_id FROM product_category WHERE name = 'Periféricos')),
(nextval('product_seq'), 'Mouse Inalámbrico', 'Mouse ergonómico con conexión inalámbrica', 49.99, 200, 'https://example.com/mouse-inalambrico.jpg', (SELECT category_id FROM product_category WHERE name = 'Periféricos')),
(nextval('product_seq'), 'Monitor 24" LED', 'Monitor Full HD con panel LED de 24 pulgadas', 180.00, 75, 'https://example.com/monitor-24.jpg', (SELECT category_id FROM product_category WHERE name = 'Periféricos')),
(nextval('product_seq'), 'Impresora Multifunción', 'Impresora con escáner y fotocopiadora integrada', 130.50, 40, 'https://example.com/impresora-multifuncion.jpg', (SELECT category_id FROM product_category WHERE name = 'Periféricos')),
(nextval('product_seq'), 'Disco SSD 1TB', 'Unidad de almacenamiento sólido con alta velocidad de lectura/escritura', 120.00, 80, 'https://example.com/ssd-1tb.jpg', (SELECT category_id FROM product_category WHERE name = 'Almacenamiento')),
(nextval('product_seq'), 'Disco Duro Externo 2TB', 'Disco duro externo con USB 3.0 y capacidad de 2TB', 95.99, 100, 'https://example.com/disco-duro-externo.jpg', (SELECT category_id FROM product_category WHERE name = 'Almacenamiento')),
(nextval('product_seq'), 'Pendrive 64GB', 'Unidad flash USB de 64GB de alta velocidad', 25.00, 300, 'https://example.com/pendrive-64gb.jpg', (SELECT category_id FROM product_category WHERE name = 'Almacenamiento')),
(nextval('product_seq'), 'Placa Madre ATX', 'Placa madre con soporte para procesadores Intel y AMD', 210.00, 50, 'https://example.com/placa-madre-atx.jpg', (SELECT category_id FROM product_category WHERE name = 'Componentes')),
(nextval('product_seq'), 'Procesador Intel Core i7', 'Procesador de octava generación con 8 núcleos y alta eficiencia', 320.00, 30, 'https://example.com/procesador-i7.jpg', (SELECT category_id FROM product_category WHERE name = 'Componentes')),
(nextval('product_seq'), 'Tarjeta Gráfica NVIDIA GTX 1660', 'Tarjeta gráfica con 6GB de VRAM GDDR5', 350.00, 25, 'https://example.com/tarjeta-grafica-gtx1660.jpg', (SELECT category_id FROM product_category WHERE name = 'Componentes')),
(nextval('product_seq'), 'Fuente de Poder 750W', 'Fuente de alimentación certificada 80 Plus Gold de 750W', 110.00, 45, 'https://example.com/fuente-poder-750w.jpg', (SELECT category_id FROM product_category WHERE name = 'Componentes')),
(nextval('product_seq'), 'Memoria RAM 16GB DDR4', 'Kit de 2 módulos de 8GB cada uno con frecuencia de 3200MHz', 95.00, 70, 'https://example.com/ram-16gb.jpg', (SELECT category_id FROM product_category WHERE name = 'Componentes')),
(nextval('product_seq'), 'Router Wi-Fi 6', 'Router de última generación con soporte para Wi-Fi 6', 95.50, 60, 'https://example.com/router-wifi6.jpg', (SELECT category_id FROM product_category WHERE name = 'Redes')),
(nextval('product_seq'), 'Switch Ethernet 8 Puertos', 'Switch de red con 8 puertos Gigabit Ethernet', 45.99, 90, 'https://example.com/switch-ethernet.jpg', (SELECT category_id FROM product_category WHERE name = 'Redes')),
(nextval('product_seq'), 'Adaptador USB a Ethernet', 'Adaptador para conectar un puerto USB a una red Ethernet', 19.99, 120, 'https://example.com/adaptador-usb-ethernet.jpg', (SELECT category_id FROM product_category WHERE name = 'Redes')),
(nextval('product_seq'), 'Cámara Web Full HD', 'Cámara web con resolución 1080p para videollamadas', 55.99, 80, 'https://example.com/camara-web.jpg', (SELECT category_id FROM product_category WHERE name = 'Periféricos')),
(nextval('product_seq'), 'Antivirus Pro', 'Software de protección contra virus y malware con licencia de 1 año', 35.00, 500, 'https://example.com/antivirus-pro.jpg', (SELECT category_id FROM product_category WHERE name = 'Software')),
(nextval('product_seq'), 'Sistema Operativo Windows 11', 'Licencia original de Windows 11 Home', 140.00, 200, 'https://example.com/windows11.jpg', (SELECT category_id FROM product_category WHERE name = 'Software')),
(nextval('product_seq'), 'Paquete Microsoft Office 365', 'Licencia anual para Office 365', 99.99, 250, 'https://example.com/office365.jpg', (SELECT category_id FROM product_category WHERE name = 'Software')),
(nextval('product_seq'), 'Software de Diseño Gráfico', 'Suite profesional de herramientas para diseño gráfico', 299.99, 120, 'https://example.com/software-diseno.jpg', (SELECT category_id FROM product_category WHERE name = 'Software'));