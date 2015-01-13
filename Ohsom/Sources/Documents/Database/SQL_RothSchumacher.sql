-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 27. Jun 2014 um 20:13
-- Server Version: 5.6.11
-- PHP-Version: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `tamagotchi`
--
CREATE DATABASE IF NOT EXISTS `tamagotchi` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `tamagotchi`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `highscore`
--

CREATE TABLE IF NOT EXISTS `highscore` (
  `idHighscore` int(11) NOT NULL AUTO_INCREMENT,
  `Punkte` int(11) DEFAULT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idHighscore`),
  KEY `fk_Highscore_User1_idx` (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Daten für Tabelle `highscore`
--

INSERT INTO `highscore` (`idHighscore`, `Punkte`, `idUser`) VALUES
(1, 110, 19),
(2, 0, 20),
(3, 0, 21),
(4, 0, 22),
(5, 0, 23),
(6, 0, 24);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `inventar`
--

CREATE TABLE IF NOT EXISTS `inventar` (
  `idShop` int(11) NOT NULL,
  `idTamagotchi` int(11) NOT NULL,
  `Kaufdatum` datetime NOT NULL,
  `verwendet` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idShop`,`idTamagotchi`,`Kaufdatum`),
  KEY `fk_Shopartikel_has_Tamagotchi_Tamagotchi1_idx` (`idTamagotchi`),
  KEY `fk_Shopartikel_has_Tamagotchi_Shopartikel1_idx` (`idShop`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `inventar`
--

INSERT INTO `inventar` (`idShop`, `idTamagotchi`, `Kaufdatum`, `verwendet`) VALUES
(3, 4, '2014-06-23 16:25:54', 1),
(3, 4, '2014-06-23 16:33:19', 1),
(3, 4, '2014-06-25 18:08:45', 1),
(3, 4, '2014-06-25 20:01:44', 1),
(3, 4, '2014-06-25 20:01:46', 1),
(3, 4, '2014-06-27 13:22:13', 0),
(3, 4, '2014-06-27 13:22:15', 0),
(3, 5, '2014-06-26 19:25:02', 1),
(4, 4, '2014-06-23 16:25:54', 1),
(4, 4, '2014-06-23 16:33:19', 1),
(4, 4, '2014-06-25 18:08:45', 1),
(4, 4, '2014-06-26 21:45:24', 1),
(4, 4, '2014-06-27 13:22:14', 0),
(4, 5, '2014-06-26 19:25:05', 0),
(5, 4, '2014-06-23 16:25:50', 1),
(5, 4, '2014-06-23 16:25:54', 1),
(5, 4, '2014-06-23 16:33:23', 1),
(5, 4, '2014-06-25 18:08:55', 1),
(5, 4, '2014-06-25 18:08:56', 1),
(5, 4, '2014-06-26 19:59:10', 1),
(5, 4, '2014-06-26 21:45:14', 0),
(5, 4, '2014-06-26 21:45:19', 0),
(5, 5, '2014-06-26 19:24:56', 0),
(5, 5, '2014-06-26 19:25:02', 0),
(5, 5, '2014-06-26 19:25:05', 1),
(6, 4, '2014-06-23 16:25:49', 1),
(6, 4, '2014-06-23 16:25:54', 1),
(6, 4, '2014-06-26 23:23:21', 0),
(7, 4, '2014-06-23 16:25:54', 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `nachrichten`
--

CREATE TABLE IF NOT EXISTS `nachrichten` (
  `idNachricht` int(11) NOT NULL AUTO_INCREMENT,
  `Titel` varchar(100) DEFAULT NULL,
  `Nachricht` text,
  `Zeitpunkt` datetime DEFAULT NULL,
  `gelesen` tinyint(1) DEFAULT '0',
  `idUser_Empfaenger` int(11) NOT NULL,
  `idUser_Sender` int(11) NOT NULL,
  PRIMARY KEY (`idNachricht`),
  KEY `fk_Nachrichten_User1_idx` (`idUser_Empfaenger`),
  KEY `fk_Nachrichten_User2_idx` (`idUser_Sender`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=23 ;

--
-- Daten für Tabelle `nachrichten`
--

INSERT INTO `nachrichten` (`idNachricht`, `Titel`, `Nachricht`, `Zeitpunkt`, `gelesen`, `idUser_Empfaenger`, `idUser_Sender`) VALUES
(2, 'Hallo', 'Test :)', '2014-06-23 17:47:57', 0, 21, 19),
(12, 'Test Test', 'Test :)', '2014-06-26 19:45:13', 1, 20, 19),
(22, 'Hallo', 'Hallo', '2014-06-27 19:54:19', 0, 23, 19);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `shopartikel`
--

CREATE TABLE IF NOT EXISTS `shopartikel` (
  `idShop` int(11) NOT NULL AUTO_INCREMENT,
  `Artikelname` varchar(50) DEFAULT NULL,
  `ArtikelImage` varchar(100) NOT NULL,
  `Preis` int(11) DEFAULT NULL,
  `Kategorie` enum('Spielzeug','Medizin','Getraenk','Futter') DEFAULT NULL,
  PRIMARY KEY (`idShop`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Daten für Tabelle `shopartikel`
--

INSERT INTO `shopartikel` (`idShop`, `Artikelname`, `ArtikelImage`, `Preis`, `Kategorie`) VALUES
(2, 'Medizin', '', 50, 'Medizin'),
(3, 'Fanta', 'fanta.png', 10, 'Getraenk'),
(4, 'Cola', 'coca-cola.png', 20, 'Getraenk'),
(5, 'Cheeseburger', 'cheeseburger.png', 15, 'Futter'),
(6, 'Donut', 'donut.png', 1000, 'Futter'),
(7, 'Bier', 'bier.png', 100, 'Getraenk'),
(8, 'Pizza', 'Pizza.png', 50, 'Futter'),
(9, 'Kekse', 'Kekse.png', 150, 'Futter');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `tamagotchi`
--

CREATE TABLE IF NOT EXISTS `tamagotchi` (
  `idTamagotchi` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(10) DEFAULT NULL,
  `Geschlechtw` tinyint(1) DEFAULT NULL,
  `Geburtsdatum` datetime DEFAULT NULL,
  `Geld` int(11) DEFAULT '100',
  `Medizin` int(11) DEFAULT '1',
  `Gesundheitszustand` enum('gesund','krank','tot') DEFAULT NULL,
  `letzteFuetterungszeit` datetime DEFAULT NULL,
  `letzteSchlafenszeit` datetime DEFAULT NULL,
  `letzteWaschzeit` datetime DEFAULT NULL,
  `letzteTrinkzeit` datetime DEFAULT NULL,
  `letzteSpielzeit` datetime DEFAULT NULL,
  `Custom_IMG` longblob,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idTamagotchi`),
  KEY `fk_Tamagotchi_Account1_idx` (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Daten für Tabelle `tamagotchi`
--

INSERT INTO `tamagotchi` (`idTamagotchi`, `Name`, `Geschlechtw`, `Geburtsdatum`, `Geld`, `Medizin`, `Gesundheitszustand`, `letzteFuetterungszeit`, `letzteSchlafenszeit`, `letzteWaschzeit`, `letzteTrinkzeit`, `letzteSpielzeit`, `Custom_IMG`, `idUser`) VALUES
(4, 'Snatsch', 0, '2014-06-27 00:00:00', 230, 2, 'krank', '2014-06-27 13:19:40', '2014-06-27 13:19:40', '2014-06-27 13:19:40', '2014-06-27 13:19:40', '2014-06-27 20:05:52', NULL, 19),
(5, 'Theo', 0, '2014-06-01 00:00:00', 195, 0, 'tot', '2014-06-27 01:52:10', '2014-06-26 19:22:37', '2014-06-26 19:22:37', '2014-06-27 01:52:05', '2014-06-27 01:52:34', NULL, 20),
(6, 'test', 1, '2014-06-25 00:00:00', 100, 1, 'gesund', '2014-06-25 18:16:20', '2014-06-25 18:16:20', '2014-06-25 18:16:20', '2014-06-25 18:16:20', '2014-06-25 18:16:20', NULL, 24),
(7, 'Kirby', 0, '2014-06-26 00:00:00', 100, 1, 'gesund', '2014-06-26 21:51:27', '2014-06-26 21:51:27', '2014-06-26 21:51:27', '2014-06-26 21:51:27', '2014-06-26 21:51:27', NULL, 21);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `tamagotchiconfig`
--

CREATE TABLE IF NOT EXISTS `tamagotchiconfig` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` enum('FUETTERN','WASCHEN','SCHLAFENLEGEN','TRINKEN','WERTE','INVENTAR','SHOP','SPIELEN','MEDIZIN') DEFAULT NULL,
  `Hotkey` varchar(20) DEFAULT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_UserConfig_User1_idx` (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

--
-- Daten für Tabelle `tamagotchiconfig`
--

INSERT INTO `tamagotchiconfig` (`id`, `code`, `Hotkey`, `idUser`) VALUES
(1, 'TRINKEN', 'D', 19),
(2, 'INVENTAR', '\0', 19),
(3, 'WERTE', 'A', 19),
(4, 'SHOP', 'Z', 19),
(5, 'SCHLAFENLEGEN', 'C', 19),
(6, 'WASCHEN', '\0', 19),
(7, 'FUETTERN', '\0', 19),
(8, 'SPIELEN', '\0', 19),
(10, 'SPIELEN', '\0', 20),
(11, 'FUETTERN', '\0', 20),
(12, 'SHOP', 's', 20),
(13, 'WERTE', '\0', 20),
(14, 'INVENTAR', '\0', 20),
(15, 'TRINKEN', '\0', 20),
(16, 'SCHLAFENLEGEN', '\0', 20),
(17, 'WASCHEN', '\0', 20);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `Passwort` varchar(22) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Nickname` varchar(40) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=26 ;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`idUser`, `Passwort`, `Email`, `Nickname`) VALUES
(19, 'hallo2', 'natalie@judosch.ch', 'Snatsch'),
(20, '4747', 'judith@judosch.ch', 'Larsipulami'),
(21, 'callofduty', 'david.roth@gibmit.ch', 'David'),
(22, 'lol', 'yannick@judosch.ch', 'Yannick'),
(23, 'mama', 'lajuna@gmx.ch', 'Mama'),
(24, 'papa', 'donat@judosch.ch', 'Papa'),
(25, 'leichtesPasswort', 'test@email.ch', 'TestUser');

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `highscore`
--
ALTER TABLE `highscore`
  ADD CONSTRAINT `fk_Highscore_User1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints der Tabelle `inventar`
--
ALTER TABLE `inventar`
  ADD CONSTRAINT `fk_Shopartikel_has_Tamagotchi_Shopartikel1` FOREIGN KEY (`idShop`) REFERENCES `shopartikel` (`idShop`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Shopartikel_has_Tamagotchi_Tamagotchi1` FOREIGN KEY (`idTamagotchi`) REFERENCES `tamagotchi` (`idTamagotchi`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints der Tabelle `nachrichten`
--
ALTER TABLE `nachrichten`
  ADD CONSTRAINT `fk_Nachrichten_User1` FOREIGN KEY (`idUser_Empfaenger`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Nachrichten_User2` FOREIGN KEY (`idUser_Sender`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints der Tabelle `tamagotchi`
--
ALTER TABLE `tamagotchi`
  ADD CONSTRAINT `fk_Tamagotchi_Account1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints der Tabelle `tamagotchiconfig`
--
ALTER TABLE `tamagotchiconfig`
  ADD CONSTRAINT `fk_UserConfig_User1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
