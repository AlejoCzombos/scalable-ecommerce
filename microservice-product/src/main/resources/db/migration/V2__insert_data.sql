INSERT INTO product_category (category_id, name, description) VALUES
(1, 'Periféricos', 'Dispositivos externos para interactuar con una computadora'),
(2, 'Almacenamiento', 'Dispositivos para guardar y transferir datos'),
(3, 'Componentes', 'Piezas internas que forman parte del hardware de una computadora'),
(4, 'Redes', 'Dispositivos relacionados con la conectividad y redes informáticas'),
(5, 'Software', 'Programas y sistemas operativos para computadoras');

INSERT INTO product (product_id, name, description, unit_price, stock, image_url, category_id) VALUES
(1, 'Teclado Mecánico', 'Teclado con interruptores mecánicos para mayor durabilidad', 75.99, 150, 'https://example.com/teclado-mecanico.jpg', 1),
(2, 'Mouse Inalámbrico', 'Mouse ergonómico con conexión inalámbrica', 49.99, 200, 'https://example.com/mouse-inalambrico.jpg', 1),
(3, 'Monitor 24" LED', 'Monitor Full HD con panel LED de 24 pulgadas', 180.00, 75, 'https://example.com/monitor-24.jpg', 1),
(4, 'Impresora Multifunción', 'Impresora con escáner y fotocopiadora integrada', 130.50, 40, 'https://example.com/impresora-multifuncion.jpg', 1),
(5, 'Disco SSD 1TB', 'Unidad de almacenamiento sólido con alta velocidad de lectura/escritura', 120.00, 80, 'https://example.com/ssd-1tb.jpg', 2),
(6, 'Disco Duro Externo 2TB', 'Disco duro externo con USB 3.0 y capacidad de 2TB', 95.99, 100, 'https://example.com/disco-duro-externo.jpg', 2),
(7, 'Pendrive 64GB', 'Unidad flash USB de 64GB de alta velocidad', 25.00, 300, 'https://example.com/pendrive-64gb.jpg', 2),
(8, 'Placa Madre ATX', 'Placa madre con soporte para procesadores Intel y AMD', 210.00, 50, 'https://example.com/placa-madre-atx.jpg', 3),
(9, 'Procesador Intel Core i7', 'Procesador de octava generación con 8 núcleos y alta eficiencia', 320.00, 30, 'https://example.com/procesador-i7.jpg', 3),
(10, 'Tarjeta Gráfica NVIDIA GTX 1660', 'Tarjeta gráfica con 6GB de VRAM GDDR5', 350.00, 25, 'https://example.com/tarjeta-grafica-gtx1660.jpg', 3),
(11, 'Fuente de Poder 750W', 'Fuente de alimentación certificada 80 Plus Gold de 750W', 110.00, 45, 'https://example.com/fuente-poder-750w.jpg', 3),
(12, 'Memoria RAM 16GB DDR4', 'Kit de 2 módulos de 8GB cada uno con frecuencia de 3200MHz', 95.00, 70, 'https://example.com/ram-16gb.jpg', 3),
(13, 'Router Wi-Fi 6', 'Router de última generación con soporte para Wi-Fi 6', 95.50, 60, 'https://example.com/router-wifi6.jpg', 4),
(14, 'Switch Ethernet 8 Puertos', 'Switch de red con 8 puertos Gigabit Ethernet', 45.99, 90, 'https://example.com/switch-ethernet.jpg', 4),
(15, 'Adaptador USB a Ethernet', 'Adaptador para conectar un puerto USB a una red Ethernet', 19.99, 120, 'https://example.com/adaptador-usb-ethernet.jpg', 4),
(16, 'Cámara Web Full HD', 'Cámara web con resolución 1080p para videollamadas', 55.99, 80, 'https://example.com/camara-web.jpg', 1),
(17, 'Antivirus Pro', 'Software de protección contra virus y malware con licencia de 1 año', 35.00, 500, 'https://example.com/antivirus-pro.jpg', 5),
(18, 'Sistema Operativo Windows 11', 'Licencia original de Windows 11 Home', 140.00, 200, 'https://example.com/windows11.jpg', 5),
(19, 'Paquete Microsoft Office 365', 'Licencia anual para Office 365', 99.99, 250, 'https://example.com/office365.jpg', 5),
(20, 'Software de Diseño Gráfico', 'Suite profesional de herramientas para diseño gráfico', 299.99, 120, 'https://example.com/software-diseno.jpg', 5);