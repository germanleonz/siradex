--	Usuario
INSERT INTO usuario VALUES ('08-10611', '123456', 'German', 'Leon', '08-10611@usb.ve', 'Root');
INSERT INTO usuario VALUES ('09-10309', 'gamundi', 'Francisco', 'Gamundi', '09-10309@usb.ve', 'Administrador');
INSERT INTO usuario VALUES ('09-10000', 'patricia', 'Patricia', 'Wilthew', '09-10000@usb.ve', 'Administrador');
INSERT INTO usuario VALUES ('kdoming', 'kdoming', 'Kenyer', 'Dominguez', 'kdoming@usb.ve', 'Profesor');
INSERT INTO usuario VALUES ('corniel', 'corniel', 'Marla', 'Corniel', 'corniel@usb.ve', 'Profesor');
INSERT INTO usuario VALUES ('07-10000', 'pedro', 'Pedro', 'Perez', '07-10000@usb.ve', 'Estudiante');
INSERT INTO usuario VALUES ('mrodrig', 'mrodrig', 'Maria', 'Rodriguez', 'mrodrig@usb.ve', 'Administrativo');
INSERT INTO usuario VALUES ('jf', 'jf', 'Jose', 'Fernandez', 'jf@usb.ve', 'Obrero');

-- --	Catalogos
INSERT INTO catalogo (nombre_catalogo, num_campos) VALUES ('Coordinaciones', 2);
INSERT INTO catalogo (nombre_catalogo, num_campos) VALUES ('Programas', 1);
INSERT INTO catalogo (nombre_catalogo, num_campos) VALUES ('Estudiantes', 1);
INSERT INTO catalogo (nombre_catalogo, num_campos) VALUES ('Carreras', 1);
INSERT INTO catalogo (nombre_catalogo, num_campos) VALUES ('Departamentos', 1);
INSERT INTO catalogo (nombre_catalogo, num_campos) VALUES ('Profesores', 1);

--	Campos de coordinaciones
INSERT INTO campos_catalogo (id_catalogo, nombre_campo, tipo_campo) VALUES (1, 'Nombre coordinacion', 'Texto');
INSERT INTO campos_catalogo (id_catalogo, nombre_campo, tipo_campo) VALUES (1, 'Id coordinador', 'Texto');
--	Campos de programas
INSERT INTO campos_catalogo (id_catalogo, nombre_campo, tipo_campo) VALUES (1, 'Nombre programa', 'Texto');
--	Campos de estudiante
-- INSERT INTO campos_catalogo (id_catalogo, nombre_campo, tipo_campo) VALUES (1, 'Id coordinador', 'Texto');

--	Valores de los elementos de los catalogos cada valor corresponde a un campo y a un catalogo
--	Valores para los nombres de las coordinaciones (asumiendo que 1 es el id campo catalogo de "Nombre de coordinacion"
INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (1, 1, 'Coordinacion de Extension Sede Litoral');
INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (1, 1, 'Coordinacion de Cooperacion Tecnica');
INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (1, 1, 'BPDex');
INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (1, 1, 'Funindes USB');
INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (1, 1, 'Coordinacion de Educacion Permanente');

INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (1, 2, 'kdoming');
INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (1, 2, 'mcorniel');
INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (1, 2, 'mpepe');
INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (1, 2, 'mmijares');
INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (1, 2, 'kdoming');
--	Valores de los nombre de los programas asumiendo que 3 es el codigo de "Nombre de Programa"
INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (2, 3, 'Educacion Permanente');
INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (2, 3, 'Desarrollo Comunitario');
INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (2, 3, 'Asistencia tecnica a los Sectores Productivos y de Servicios Publicos y Privados');
INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (2, 3, 'Fomento y la Proyeccion Artistica, Cultural y Deportiva');
INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (2, 3, 'Divulgacion y Promocion del quehacer universitario');
INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (2, 3, 'Nivelacion Academica Preuniversitaria Igualdad de oportunidades');
INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (2, 3, 'Emprendimiento y Seguimiento de Egresados');
INSERT INTO valor_catalogo (id_catalogo, id_campo_catalogo, value) VALUES (2, 3, 'Formacion Complementaria');
