ALTER TABLE usuario_estudiante ADD CONSTRAINT FK_estudiante__usuario
FOREIGN KEY (carnet) REFERENCES usuario (usbid);

ALTER TABLE usuario_profesor ADD CONSTRAINT FK_profesor__usuario
FOREIGN KEY (usbid) REFERENCES usuario (usbid);

ALTER TABLE usuario_obrero ADD CONSTRAINT FK_obrero__usuario
FOREIGN KEY (usbid) REFERENCES usuario (usbid);

ALTER TABLE usuario_administrativo ADD CONSTRAINT FK_admin_usuario
FOREIGN KEY (usbid) REFERENCES usuario (usbid);

ALTER TABLE rol ADD CONSTRAINT FK_rol__usuario
FOREIGN KEY (usbid) REFERENCES usuario (usbid);

ALTER TABLE campos_tipo_actividad ADD CONSTRAINT FK_campos_tipo
FOREIGN KEY (id_ta) REFERENCES tipo_actividad(id_tipo_act);

ALTER TABLE valor ADD CONSTRAINT FK_valor__campos
FOREIGN KEY (id_cta) REFERENCES campos_tipo_actividad(id_cta);

-- ALTER TABLE coordinacion ADD CONSTRAINT FK_coordinacion_coordinador
-- FOREIGN KEY (id_coordinador) REFERENCES usuario (usbid);

ALTER TABLE valor ADD CONSTRAINT FK_valor__actividad
FOREIGN KEY (id_act) REFERENCES actividad(id_act);

ALTER TABLE valor_catalogo ADD CONSTRAINT FK_valor__catalogo
FOREIGN KEY (id_campo_catalogo) REFERENCES campos_catalogo(id_campo_catalogo);

ALTER TABLE campos_catalogo ADD CONSTRAINT FK_campos_catalogo
FOREIGN KEY (id_catalogo) REFERENCES catalogo(id_catalogo);

ALTER TABLE valor_catalogo ADD CONSTRAINT FK_valor_elemento
FOREIGN KEY (id_elemento) REFERENCES elemento_catalogo(id_elemento);

-- ALTER TABLE actividad ADD CONSTRAINT FK_actividad__tipo
-- FOREIGN KEY (id_ta) REFERENCES tipo_actividad(id_tipo_act);