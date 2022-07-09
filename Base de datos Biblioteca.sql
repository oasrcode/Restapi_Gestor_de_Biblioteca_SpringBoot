-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-06-2022 a las 00:19:04
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplares`
--

CREATE TABLE `ejemplares` (
  `ID` bigint(11) NOT NULL,
  `Codigo` varchar(11) NOT NULL,
  `ID_Libro` bigint(11) NOT NULL,
  `Estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ejemplares`
--

INSERT INTO `ejemplares` (`ID`, `Codigo`, `ID_Libro`, `Estado`) VALUES
(14, 'HB02', 8, 0),
(15, 'RDR01', 3, 0),
(16, 'RDR02', 3, 0),
(17, 'SDA01', 1, 1),
(18, 'SDA02', 1, 0),
(19, 'LDT01', 2, 0),
(20, 'LDT02', 2, 0),
(22, 'HB03', 8, 0),
(23, 'ESMR01', 11, 0),
(24, 'HB01', 8, 0),
(26, 'HBAL01', 14, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `ID` bigint(11) NOT NULL,
  `Titulo` varchar(200) NOT NULL,
  `Autor` varchar(200) NOT NULL,
  `Genero` varchar(200) NOT NULL,
  `Editorial` varchar(200) NOT NULL,
  `ISBN` bigint(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`ID`, `Titulo`, `Autor`, `Genero`, `Editorial`, `ISBN`) VALUES
(1, 'Señor de los anillos', 'J.R.R Tolkien', 'Fantasía', 'Salamandra', 9788445003022),
(2, 'Las Dos torres', 'J.R.R Tolkien', 'Fantasía', 'Salamandra', 9788445071762),
(3, 'El Retorno del rey', 'J.R.R Tolkien', 'Fantasía', 'Minotauro', 9788445000687),
(8, 'El Hobbit', 'J.R.R Tolkien', 'Fantasía', 'Salamandra', 9780044403371),
(11, 'El Silmarillion', 'J.R.R Tolkien', 'Fantasía', 'Minotauro', 9780261103665),
(12, 'Cuentos inconclusos de Númenor y la Tierra Media', 'J.R.R Tolkien', 'Fantasía', 'Minotauro', 9780008387969),
(14, 'La historia de Beren y Lúthien', 'J. R. R. Tolkien', 'Fantasía', 'Minotauro', 9783608108880),
(16, 'EL CAMINO DEL FUEGO', 'MARIA ORUÑA', 'Aventura', 'Minotauro', 9788423361991);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `id` bigint(11) NOT NULL,
  `Fecha_Prestamo` date NOT NULL,
  `Fecha_Entraga` date NOT NULL,
  `ID_Ejemplar` bigint(11) NOT NULL,
  `ID_Usuario` bigint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `prestamos`
--

INSERT INTO `prestamos` (`id`, `Fecha_Prestamo`, `Fecha_Entraga`, `ID_Ejemplar`, `ID_Usuario`) VALUES
(42, '2022-06-29', '2022-06-26', 17, 10);

--
-- Disparadores `prestamos`
--
DELIMITER $$
CREATE TRIGGER `TR_ESTADO_LIBRE_EJEMPLAR` AFTER DELETE ON `prestamos` FOR EACH ROW BEGIN
  UPDATE ejemplares
  SET ejemplares.Estado=0
  WHERE ejemplares.ID=OLD.ID_EJEMPLAR;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `TR_ESTADO_OCUPADO_EJEMPLAR` AFTER INSERT ON `prestamos` FOR EACH ROW BEGIN
  UPDATE ejemplares
  SET ejemplares.Estado=1
  WHERE ejemplares.ID=NEW.ID_EJEMPLAR;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `ID` bigint(11) NOT NULL,
  `Nombre` varchar(200) NOT NULL,
  `Apellidos` varchar(200) NOT NULL,
  `N_Carnet` bigint(11) NOT NULL,
  `Telefono` varchar(9) NOT NULL,
  `Email` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ID`, `Nombre`, `Apellidos`, `N_Carnet`, `Telefono`, `Email`) VALUES
(1, 'Jéssica', 'Pérez Suarez', 452, '633789654', 'asr@gmail.com'),
(10, 'Omar Aythami', 'Santana Rodríguez', 123, '632452123', 'oasr@gmail.com'),
(11, 'Susana', 'Suarez Gómez', 3466, '630145874', 'sgomez@gmail.com'),
(13, 'Kilian', 'Santana Rubio', 96321, '623412032', 'asarub@gmail.com'),
(14, 'Ainhoa', 'Reyes García', 45712, '630128754', 'mdelngarcia@gmail.com'),
(22, 'x', 'x', 987, 'x', 'x');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `codigo_unico` (`Codigo`),
  ADD KEY `FK_IDLibro_Ejemplares` (`ID_Libro`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_IDUsuarios_Prestamos` (`ID_Usuario`),
  ADD KEY `FK_IDEjemplar_Prestamos` (`ID_Ejemplar`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  MODIFY `ID` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `ID` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `ID` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD CONSTRAINT `FK_IDLibro_Ejemplares` FOREIGN KEY (`ID_Libro`) REFERENCES `libros` (`ID`);

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `FK_IDEjemplar_Prestamos` FOREIGN KEY (`ID_Ejemplar`) REFERENCES `ejemplares` (`ID`),
  ADD CONSTRAINT `FK_IDUsuarios_Prestamos` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuarios` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
