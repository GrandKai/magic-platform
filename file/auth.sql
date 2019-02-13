-- MySQL dump 10.13  Distrib 5.7.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: auth
-- ------------------------------------------------------
-- Server version	5.7.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority` (
  `id` varchar(50) NOT NULL COMMENT '权限id',
  `plat_id` varchar(50) DEFAULT NULL COMMENT '所属平台',
  `name` varchar(200) NOT NULL COMMENT '权限名称',
  `description` varchar(500) DEFAULT NULL COMMENT '权限描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `sort_number` smallint(6) DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`),
  KEY `IXFK_authority_plat` (`plat_id`),
  CONSTRAINT `FK_authority_plat` FOREIGN KEY (`plat_id`) REFERENCES `plat` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES ('1','5bcae4a6036f43709877191f3bcb4283','自定义权限1','自定义权限描述1','2018-09-02 14:49:29','2018-10-03 15:08:52',12),('1eccecf88d304aa3a93b329efca4ba4b','5bcae4a6036f43709877191f3bcb4283','权限系统权限','权限系统权限','2018-10-03 19:11:14','2018-11-09 15:21:49',10),('29e9d7a46f8b46e3b7bbf9c41612dd85','5bcae4a6036f43709877191f3bcb4283','测试多个权限','测试多个权限','2018-10-04 10:14:10','2018-10-04 10:14:10',10),('685aae4af6f34606a5c826b19f18d25e','c6124b229ba04562b79e96eec43f3a59','测试权限','测试权限','2018-10-03 14:59:59','2018-10-03 14:59:59',10),('f799dddad50844f0b429977f541f0e6d','5bcae4a6036f43709877191f3bcb4283','部分权限测试部分权限测试','部分权限测试','2018-10-04 01:03:23','2018-10-04 01:03:23',10);
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority_menu`
--

DROP TABLE IF EXISTS `authority_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority_menu` (
  `authority_id` varchar(50) DEFAULT NULL COMMENT '权限id',
  `menu_id` varchar(50) DEFAULT NULL COMMENT '菜单id',
  KEY `IXFK_authority_menu_authority` (`authority_id`),
  KEY `IXFK_authority_menu_menu` (`menu_id`),
  CONSTRAINT `FK_authority_menu_authority` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_authority_menu_menu` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority_menu`
--

LOCK TABLES `authority_menu` WRITE;
/*!40000 ALTER TABLE `authority_menu` DISABLE KEYS */;
INSERT INTO `authority_menu` VALUES ('29e9d7a46f8b46e3b7bbf9c41612dd85','469e3635a2ba462083da97a1fa8efb81'),('29e9d7a46f8b46e3b7bbf9c41612dd85','4ac97afeee0c403fb4740aa52b8bdd6a'),('29e9d7a46f8b46e3b7bbf9c41612dd85','0c5ab9cc4d5f4d9d8d688dacf8ec9b68'),('685aae4af6f34606a5c826b19f18d25e','3089c3af0d7047a28f4a1d9afeaee138'),('685aae4af6f34606a5c826b19f18d25e','93b29981cc664fb49290145c514749d8'),('685aae4af6f34606a5c826b19f18d25e','1dcb1e996690430080a0d57f3ac914bb'),('f799dddad50844f0b429977f541f0e6d','469e3635a2ba462083da97a1fa8efb81'),('f799dddad50844f0b429977f541f0e6d','0c5ab9cc4d5f4d9d8d688dacf8ec9b68'),('f799dddad50844f0b429977f541f0e6d','a1d06d13339443a380f72717c349e35f'),('f799dddad50844f0b429977f541f0e6d','d4522d64580645eaa04f412fa1883105'),('1eccecf88d304aa3a93b329efca4ba4b','bf84046c25684852afcb95c3c6d1dfcf'),('1eccecf88d304aa3a93b329efca4ba4b','e36e59ddaebc4f8fbf277d46aeeed3bc'),('1eccecf88d304aa3a93b329efca4ba4b','feff45e8254840588ac9802bca9509b9'),('1eccecf88d304aa3a93b329efca4ba4b','0630939b345645349e58dda5bc591756'),('1eccecf88d304aa3a93b329efca4ba4b','7c37e4695392493397ea708fd83e3ffb'),('1eccecf88d304aa3a93b329efca4ba4b','53b564e38c244aa5a004487b4c9cb7fa'),('1eccecf88d304aa3a93b329efca4ba4b','b7ccd70bde18437eb5babf71b18f0a9f'),('1eccecf88d304aa3a93b329efca4ba4b','a1d06d13339443a380f72717c349e35f'),('1eccecf88d304aa3a93b329efca4ba4b','18f5a38372d2418bab2aa2e14f126a17'),('1eccecf88d304aa3a93b329efca4ba4b','d4522d64580645eaa04f412fa1883105'),('1eccecf88d304aa3a93b329efca4ba4b','469e3635a2ba462083da97a1fa8efb81'),('1eccecf88d304aa3a93b329efca4ba4b','4ac97afeee0c403fb4740aa52b8bdd6a'),('1eccecf88d304aa3a93b329efca4ba4b','0c5ab9cc4d5f4d9d8d688dacf8ec9b68'),('1','bf84046c25684852afcb95c3c6d1dfcf'),('1','e36e59ddaebc4f8fbf277d46aeeed3bc'),('1','feff45e8254840588ac9802bca9509b9'),('1','0630939b345645349e58dda5bc591756'),('1','7c37e4695392493397ea708fd83e3ffb'),('1','53b564e38c244aa5a004487b4c9cb7fa'),('1','b7ccd70bde18437eb5babf71b18f0a9f'),('1','a1d06d13339443a380f72717c349e35f'),('1','18f5a38372d2418bab2aa2e14f126a17'),('1','d4522d64580645eaa04f412fa1883105'),('1','469e3635a2ba462083da97a1fa8efb81'),('1','4ac97afeee0c403fb4740aa52b8bdd6a'),('1','0c5ab9cc4d5f4d9d8d688dacf8ec9b68');
/*!40000 ALTER TABLE `authority_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority_operation`
--

DROP TABLE IF EXISTS `authority_operation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority_operation` (
  `authority_id` varchar(50) DEFAULT NULL COMMENT '权限id',
  `operation_id` varchar(50) DEFAULT NULL COMMENT '操作id',
  UNIQUE KEY `uni_authority_operation_id` (`authority_id`,`operation_id`),
  KEY `IXFK_authority_operation_authority` (`authority_id`),
  KEY `IXFK_authority_operation_operation` (`operation_id`),
  CONSTRAINT `FK_authority_operation_authority` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_authority_operation_operation` FOREIGN KEY (`operation_id`) REFERENCES `operation` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限操作表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority_operation`
--

LOCK TABLES `authority_operation` WRITE;
/*!40000 ALTER TABLE `authority_operation` DISABLE KEYS */;
INSERT INTO `authority_operation` VALUES ('1','04b04c92d1c949719348677d8c820382'),('1','069664a094d74be0bcf17da1b4babc24'),('1','09928098cf4d4fbe89389dd5ea5a7658'),('1','0a75baf5f18d41ccb1ad613301e3ff8e'),('1','0fb2d855c06c4b4abdbf0fb77c454910'),('1','173e2bf700844bc3a147f40b1313e4fc'),('1','179334afc02c481ab95d496f9af51f1b'),('1','350ce7ba50434f3db3be3b50634b5aa1'),('1','3c06beba7e1c4329b7baebae1102b5df'),('1','442dc45016dd40e395e4374d6260c596'),('1','45f0a6a8e1634eb785f635e3ffcc4e40'),('1','4c450aa8acf548cdac8c5fc8b4f8445f'),('1','4e5ad45c27f24c038d8753c42734068f'),('1','5707571ae258420594adb225ad75455e'),('1','6f818762568e4a9f8dda6e8fccbb3eed'),('1','7d890484af724a8386dca20d3877df11'),('1','8092054c4c5c482c80a913acd3107cff'),('1','83f5f14c8e9744299182aaf82196212c'),('1','8522d88bb2eb482cb53bfd6c5b7a320c'),('1','85d0241f3428437d875a314ca43307ae'),('1','8607815b98c64ab9bf52f907f61e646c'),('1','865b9d9fab994f99a9455d3b68f78a6c'),('1','86c8ef88f6f14f48997655304576d07e'),('1','8e5515ca2b014a6090af0a26ad18e175'),('1','8ec0f63133f448a1b1943a8d3f00f854'),('1','9c526a8fc8c94920a3858a78c2494ac3'),('1','a05d026e28584fd89f60531153f5ef4e'),('1','a0f45b70e0e449a29d84c27830dd31c7'),('1','abb41466a3e843f0a5cffb798bda4819'),('1','b36887dbb498464db3f3cb0c9fa6e268'),('1','bf9bcff3a5a94c28a654daa1cc690099'),('1','cca409f785284ff2829a7be3ed9c843e'),('1','cfee656c7fcb4e4383bb1c21e20d144c'),('1','d6f25958f41a4663b97d96c2b11300c2'),('1','dd2c44dce56e401c807372811d2c7a8b'),('1','e822cfde9d08499387099234c8b9e0ce'),('1','e8f7ea6e00014f89af26dbfa582b2735'),('1','f14c8b8b2bad401586522d3b5015f1e9'),('1','f3c808cd7c494117aad134a64302b8b3'),('1','f814b0f309d84fb3832b20c7e1b61d30'),('1eccecf88d304aa3a93b329efca4ba4b','04b04c92d1c949719348677d8c820382'),('1eccecf88d304aa3a93b329efca4ba4b','069664a094d74be0bcf17da1b4babc24'),('1eccecf88d304aa3a93b329efca4ba4b','09928098cf4d4fbe89389dd5ea5a7658'),('1eccecf88d304aa3a93b329efca4ba4b','0a75baf5f18d41ccb1ad613301e3ff8e'),('1eccecf88d304aa3a93b329efca4ba4b','0fb2d855c06c4b4abdbf0fb77c454910'),('1eccecf88d304aa3a93b329efca4ba4b','173e2bf700844bc3a147f40b1313e4fc'),('1eccecf88d304aa3a93b329efca4ba4b','179334afc02c481ab95d496f9af51f1b'),('1eccecf88d304aa3a93b329efca4ba4b','350ce7ba50434f3db3be3b50634b5aa1'),('1eccecf88d304aa3a93b329efca4ba4b','3c06beba7e1c4329b7baebae1102b5df'),('1eccecf88d304aa3a93b329efca4ba4b','45f0a6a8e1634eb785f635e3ffcc4e40'),('1eccecf88d304aa3a93b329efca4ba4b','4c450aa8acf548cdac8c5fc8b4f8445f'),('1eccecf88d304aa3a93b329efca4ba4b','4e5ad45c27f24c038d8753c42734068f'),('1eccecf88d304aa3a93b329efca4ba4b','6f818762568e4a9f8dda6e8fccbb3eed'),('1eccecf88d304aa3a93b329efca4ba4b','7d890484af724a8386dca20d3877df11'),('1eccecf88d304aa3a93b329efca4ba4b','83f5f14c8e9744299182aaf82196212c'),('1eccecf88d304aa3a93b329efca4ba4b','8522d88bb2eb482cb53bfd6c5b7a320c'),('1eccecf88d304aa3a93b329efca4ba4b','85d0241f3428437d875a314ca43307ae'),('1eccecf88d304aa3a93b329efca4ba4b','8607815b98c64ab9bf52f907f61e646c'),('1eccecf88d304aa3a93b329efca4ba4b','865b9d9fab994f99a9455d3b68f78a6c'),('1eccecf88d304aa3a93b329efca4ba4b','86c8ef88f6f14f48997655304576d07e'),('1eccecf88d304aa3a93b329efca4ba4b','8e5515ca2b014a6090af0a26ad18e175'),('1eccecf88d304aa3a93b329efca4ba4b','8ec0f63133f448a1b1943a8d3f00f854'),('1eccecf88d304aa3a93b329efca4ba4b','9c526a8fc8c94920a3858a78c2494ac3'),('1eccecf88d304aa3a93b329efca4ba4b','a05d026e28584fd89f60531153f5ef4e'),('1eccecf88d304aa3a93b329efca4ba4b','a0f45b70e0e449a29d84c27830dd31c7'),('1eccecf88d304aa3a93b329efca4ba4b','abb41466a3e843f0a5cffb798bda4819'),('1eccecf88d304aa3a93b329efca4ba4b','b36887dbb498464db3f3cb0c9fa6e268'),('1eccecf88d304aa3a93b329efca4ba4b','bf9bcff3a5a94c28a654daa1cc690099'),('1eccecf88d304aa3a93b329efca4ba4b','cca409f785284ff2829a7be3ed9c843e'),('1eccecf88d304aa3a93b329efca4ba4b','cfee656c7fcb4e4383bb1c21e20d144c'),('1eccecf88d304aa3a93b329efca4ba4b','d6f25958f41a4663b97d96c2b11300c2'),('1eccecf88d304aa3a93b329efca4ba4b','dd2c44dce56e401c807372811d2c7a8b'),('1eccecf88d304aa3a93b329efca4ba4b','e822cfde9d08499387099234c8b9e0ce'),('1eccecf88d304aa3a93b329efca4ba4b','e8f7ea6e00014f89af26dbfa582b2735'),('1eccecf88d304aa3a93b329efca4ba4b','f14c8b8b2bad401586522d3b5015f1e9'),('1eccecf88d304aa3a93b329efca4ba4b','f3c808cd7c494117aad134a64302b8b3'),('29e9d7a46f8b46e3b7bbf9c41612dd85','9c526a8fc8c94920a3858a78c2494ac3'),('29e9d7a46f8b46e3b7bbf9c41612dd85','f3c808cd7c494117aad134a64302b8b3'),('685aae4af6f34606a5c826b19f18d25e','b6b6ebba5bd947b1b39cc05901e5e1c9'),('f799dddad50844f0b429977f541f0e6d','09928098cf4d4fbe89389dd5ea5a7658'),('f799dddad50844f0b429977f541f0e6d','6f818762568e4a9f8dda6e8fccbb3eed'),('f799dddad50844f0b429977f541f0e6d','8e5515ca2b014a6090af0a26ad18e175'),('f799dddad50844f0b429977f541f0e6d','b36887dbb498464db3f3cb0c9fa6e268'),('f799dddad50844f0b429977f541f0e6d','e822cfde9d08499387099234c8b9e0ce'),('f799dddad50844f0b429977f541f0e6d','f3c808cd7c494117aad134a64302b8b3');
/*!40000 ALTER TABLE `authority_operation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dictionary_item`
--

DROP TABLE IF EXISTS `dictionary_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dictionary_item` (
  `id` varchar(50) NOT NULL COMMENT '数据项id',
  `name` varchar(50) DEFAULT NULL COMMENT '数据项名称',
  `code` varchar(50) DEFAULT NULL COMMENT '数据编码',
  `type_id` varchar(50) DEFAULT NULL COMMENT '数据类型id',
  `sort_number` smallint(6) DEFAULT NULL COMMENT '排序字段',
  `is_deleted` char(1) DEFAULT '0' COMMENT '是否删除',
  `is_show` char(1) DEFAULT '1' COMMENT '是否显示',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `IXFK_dictionary_item_dictionary_type` (`type_id`),
  CONSTRAINT `FK_dictionary_item_dictionary_type` FOREIGN KEY (`type_id`) REFERENCES `dictionary_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典项目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dictionary_item`
--

LOCK TABLES `dictionary_item` WRITE;
/*!40000 ALTER TABLE `dictionary_item` DISABLE KEYS */;
INSERT INTO `dictionary_item` VALUES ('0fc1c8de0d04436290207bfbedc5df2e','新增','ADD','fa4dbb6f9b9a4bc1a3ea3f51f3d9dbea',1,'0','1','2018-09-30 08:50:35','2018-10-05 07:00:37'),('45c262dc42ec467daabcccd3b61e663f','修改','UPDATE','fa4dbb6f9b9a4bc1a3ea3f51f3d9dbea',2,'0','1','2018-09-30 08:50:35','2018-10-05 07:00:43'),('6e3c964f26054b3cb3e3c1227aa261bc','删除','DELETE','fa4dbb6f9b9a4bc1a3ea3f51f3d9dbea',3,'0','1','2018-09-30 08:50:35',NULL),('77c69833c4b2487fbc4a24eb8e922d1a','查询','SELECT','fa4dbb6f9b9a4bc1a3ea3f51f3d9dbea',4,'0','1','2018-09-30 08:50:35',NULL),('791e9d7403cc40adb768cd519e75e888','222','2','df2f3796704c4bee9daa3c87e62b3386',10,'1','1','2018-10-05 08:00:04','2018-10-05 08:00:05'),('85300c9a1ed84a12971372ce882db7a7','启停','STOP','fa4dbb6f9b9a4bc1a3ea3f51f3d9dbea',5,'0','1','2018-09-30 08:50:35',NULL),('941359a3a0b7416aa56d1380ac2f3888','测试类型','1','df2f3796704c4bee9daa3c87e62b3386',10,'1','1','2018-10-05 07:59:25','2018-10-05 07:59:25'),('baf55a736631486ba8db2a6cdc17eae4','设置','SET','fa4dbb6f9b9a4bc1a3ea3f51f3d9dbea',6,'0','1','2018-09-30 08:50:35',NULL),('f59d9abe768f456b87b5095feeaa5dd7','重置','RESET','fa4dbb6f9b9a4bc1a3ea3f51f3d9dbea',7,'0','1','2018-09-30 08:50:35',NULL),('f7ea3504fb094322ba28fbb88dc8999d','上传','UPLOAD','fa4dbb6f9b9a4bc1a3ea3f51f3d9dbea',8,'0','1','2018-09-30 08:50:35',NULL),('fade9f9e7b0341f4b3e7b28707ce6abe','下载','DOWNLOAD','fa4dbb6f9b9a4bc1a3ea3f51f3d9dbea',9,'0','1','2018-09-30 08:50:35',NULL);
/*!40000 ALTER TABLE `dictionary_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dictionary_type`
--

DROP TABLE IF EXISTS `dictionary_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dictionary_type` (
  `id` varchar(50) NOT NULL COMMENT '编码类型id',
  `name` varchar(200) DEFAULT NULL COMMENT '编码类型说明',
  `code` varchar(50) DEFAULT NULL COMMENT '数据类型编码',
  `sort_number` smallint(6) DEFAULT NULL COMMENT '排序字段',
  `is_deleted` char(1) DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  `is_show` char(1) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dictionary_type`
--

LOCK TABLES `dictionary_type` WRITE;
/*!40000 ALTER TABLE `dictionary_type` DISABLE KEYS */;
INSERT INTO `dictionary_type` VALUES ('a4700e741d274af789740a5b6c6a1a17','test','test',10,'0','1','2018-10-04 11:17:17','2018-10-04 11:20:52'),('df2f3796704c4bee9daa3c87e62b3386','啊啊啊','test1',10,'0','1','2018-10-04 11:23:54','2018-10-04 11:23:54'),('fa4dbb6f9b9a4bc1a3ea3f51f3d9dbea','操作类型','operation',12,'0','1','2018-09-30 08:47:41','2018-10-04 08:49:34');
/*!40000 ALTER TABLE `dictionary_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` varchar(50) NOT NULL COMMENT '菜单id',
  `name` varchar(200) NOT NULL COMMENT '菜单名称',
  `plat_id` varchar(50) DEFAULT NULL COMMENT '所属平台',
  `parent_id` varchar(50) DEFAULT NULL COMMENT '父菜单id',
  `router` varchar(300) DEFAULT NULL COMMENT '菜单路由（页面跳转地址）',
  `image` varchar(500) DEFAULT NULL COMMENT '菜单图标',
  `is_leaf` char(1) DEFAULT NULL COMMENT '是否是叶子节点（1：是，0：否）',
  `is_deleted` char(1) DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `sort_number` smallint(6) DEFAULT NULL COMMENT '排序字段',
  `is_show` char(1) DEFAULT '1' COMMENT '是否显示（1：是，0：否）',
  PRIMARY KEY (`id`),
  KEY `IXFK_menu_plat` (`plat_id`),
  KEY `IXFK_menu_menu` (`parent_id`),
  CONSTRAINT `FK_menu_plat` FOREIGN KEY (`plat_id`) REFERENCES `plat` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES ('0630939b345645349e58dda5bc591756','通用管理','5bcae4a6036f43709877191f3bcb4283','5bcae4a6036f43709877191f3bcb4283','/','ele-icon-third-setting','','0','2018-09-27 10:05:06','2018-10-11 14:40:47',2,'1'),('0c5ab9cc4d5f4d9d8d688dacf8ec9b68','数据类型','5bcae4a6036f43709877191f3bcb4283','469e3635a2ba462083da97a1fa8efb81','/dictionary/type','','','0','2018-09-30 09:46:41','2018-09-30 09:47:04',10,'1'),('18f5a38372d2418bab2aa2e14f126a17','角色管理','5bcae4a6036f43709877191f3bcb4283','a1d06d13339443a380f72717c349e35f','/role','','','0','2018-09-27 14:46:50','2018-10-05 08:35:30',10,'1'),('1dcb1e996690430080a0d57f3ac914bb','默认菜单','c6124b229ba04562b79e96eec43f3a59','93b29981cc664fb49290145c514749d8','/','','','0','2018-10-02 08:51:57','2018-10-02 08:51:57',10,'1'),('3089c3af0d7047a28f4a1d9afeaee138','测试根菜单1','c6124b229ba04562b79e96eec43f3a59','c6124b229ba04562b79e96eec43f3a59','/','','','0','2018-09-29 10:15:21','2018-09-29 10:15:54',10,'1'),('469e3635a2ba462083da97a1fa8efb81','数据字典','5bcae4a6036f43709877191f3bcb4283','5bcae4a6036f43709877191f3bcb4283','/','ele-icon-third-dictionary','','0','2018-09-30 09:46:26','2018-10-11 14:40:56',4,'1'),('4911ed10fd1344408e1a41100427eff4','测试根菜单2','c6124b229ba04562b79e96eec43f3a59','c6124b229ba04562b79e96eec43f3a59','/','','','0','2018-09-29 10:15:40','2018-09-29 10:15:50',10,'1'),('4ac97afeee0c403fb4740aa52b8bdd6a','数据项目','5bcae4a6036f43709877191f3bcb4283','469e3635a2ba462083da97a1fa8efb81','/dictionary/item','','','0','2018-09-30 09:46:50','2018-10-05 08:43:50',10,'1'),('53b564e38c244aa5a004487b4c9cb7fa','操作管理','5bcae4a6036f43709877191f3bcb4283','0630939b345645349e58dda5bc591756','/operation','','','0','2018-09-27 10:08:40','2018-10-05 08:35:54',10,'1'),('5a7cc8d284724e318dcc29498097d74c','测试 权限菜单','5bcae4a6036f43709877191f3bcb4283','5bcae4a6036f43709877191f3bcb4283','/','','','1','2018-10-03 18:08:24','2018-10-05 10:03:06',10,'1'),('7c37e4695392493397ea708fd83e3ffb','系统管理','5bcae4a6036f43709877191f3bcb4283','0630939b345645349e58dda5bc591756','/plat','','','0','2018-09-27 10:20:59','2018-10-08 13:21:30',10,'1'),('93b29981cc664fb49290145c514749d8','测试根菜单2','c6124b229ba04562b79e96eec43f3a59','c6124b229ba04562b79e96eec43f3a59','/','','','0','2018-09-29 10:16:00','2018-10-02 09:16:00',11,'1'),('a1d06d13339443a380f72717c349e35f','权限管理','5bcae4a6036f43709877191f3bcb4283','5bcae4a6036f43709877191f3bcb4283','/','ele-icon-third-authority','','0','2018-09-27 11:12:42','2018-10-11 14:40:52',3,'1'),('b7ccd70bde18437eb5babf71b18f0a9f','菜单管理','5bcae4a6036f43709877191f3bcb4283','0630939b345645349e58dda5bc591756','/menu','','','0','2018-09-27 10:10:10','2018-10-05 08:35:45',10,'1'),('bf84046c25684852afcb95c3c6d1dfcf','用户管理','5bcae4a6036f43709877191f3bcb4283','5bcae4a6036f43709877191f3bcb4283','/','ele-icon-third-user-setting','','0','2018-09-27 09:59:43','2018-10-11 14:40:38',1,'1'),('d4522d64580645eaa04f412fa1883105','权限管理','5bcae4a6036f43709877191f3bcb4283','a1d06d13339443a380f72717c349e35f','/authority','','','0','2018-09-27 14:46:59','2018-10-05 08:35:26',10,'1'),('e36e59ddaebc4f8fbf277d46aeeed3bc','组织机构','5bcae4a6036f43709877191f3bcb4283','bf84046c25684852afcb95c3c6d1dfcf','/organization','','','0','2018-10-07 22:38:04','2018-10-08 11:31:53',10,'1'),('feff45e8254840588ac9802bca9509b9','用户信息','5bcae4a6036f43709877191f3bcb4283','bf84046c25684852afcb95c3c6d1dfcf','/user','','','0','2018-09-27 10:02:44','2018-10-05 08:36:01',10,'1');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operation`
--

DROP TABLE IF EXISTS `operation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operation` (
  `id` varchar(50) NOT NULL,
  `menu_id` varchar(50) DEFAULT NULL COMMENT '菜单id',
  `name` varchar(200) NOT NULL,
  `type` varchar(10) DEFAULT NULL COMMENT '操作类型（1：查询，2：新增，3：修改，4：删除，5：设置，6：启用/禁用）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `sort_number` smallint(6) DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`),
  KEY `IXFK_operation_menu` (`menu_id`),
  CONSTRAINT `FK_operation_menu` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作表（菜单页面所有科交互的操作）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operation`
--

LOCK TABLES `operation` WRITE;
/*!40000 ALTER TABLE `operation` DISABLE KEYS */;
INSERT INTO `operation` VALUES ('04b04c92d1c949719348677d8c820382','b7ccd70bde18437eb5babf71b18f0a9f','菜单修改','UPDATE','2018-09-30 15:55:44','2018-10-01 19:51:09',11),('069664a094d74be0bcf17da1b4babc24','b7ccd70bde18437eb5babf71b18f0a9f','菜单查询','SELECT','2018-09-30 15:56:15','2018-09-30 15:56:28',13),('09928098cf4d4fbe89389dd5ea5a7658','d4522d64580645eaa04f412fa1883105','权限操作设置','SET','2018-10-04 00:56:22','2018-10-04 00:56:38',10),('0a75baf5f18d41ccb1ad613301e3ff8e','18f5a38372d2418bab2aa2e14f126a17','角色分页查询','ADD','2018-10-02 00:05:11','2018-10-02 00:05:25',10),('0fb2d855c06c4b4abdbf0fb77c454910','feff45e8254840588ac9802bca9509b9','用户账号启停','STOP','2018-10-01 21:00:27','2018-10-01 21:01:55',10),('173e2bf700844bc3a147f40b1313e4fc','0c5ab9cc4d5f4d9d8d688dacf8ec9b68','数据类型删除','DELETE','2018-10-04 06:51:59','2018-10-04 06:52:15',10),('179334afc02c481ab95d496f9af51f1b','53b564e38c244aa5a004487b4c9cb7fa','操作删除','DELETE','2018-10-01 20:33:16','2018-10-01 20:34:54',10),('23648f5a833140c09ee96bc1de6a7fc1','5a7cc8d284724e318dcc29498097d74c','默认操作名称','','2018-10-04 08:59:02','2018-10-04 08:59:02',10),('350ce7ba50434f3db3be3b50634b5aa1','b7ccd70bde18437eb5babf71b18f0a9f','菜单删除','DELETE','2018-09-30 15:55:58','2018-09-30 15:56:11',12),('3c06beba7e1c4329b7baebae1102b5df','7c37e4695392493397ea708fd83e3ffb','系统启停','STOP','2018-10-01 20:21:33','2018-10-01 20:21:50',10),('442dc45016dd40e395e4374d6260c596','e36e59ddaebc4f8fbf277d46aeeed3bc','组织机构修改','UPDATE','2018-11-09 15:44:06','2018-11-09 15:44:26',12),('45f0a6a8e1634eb785f635e3ffcc4e40','53b564e38c244aa5a004487b4c9cb7fa','操作修改','UPDATE','2018-10-01 20:33:20','2018-10-01 20:34:40',10),('4c450aa8acf548cdac8c5fc8b4f8445f','7c37e4695392493397ea708fd83e3ffb','系统删除','DELETE','2018-10-01 19:52:53','2018-10-01 19:53:24',10),('4e5ad45c27f24c038d8753c42734068f','4ac97afeee0c403fb4740aa52b8bdd6a','数据项目修改','UPDATE','2018-10-05 06:10:02','2018-10-05 06:12:07',10),('5707571ae258420594adb225ad75455e','e36e59ddaebc4f8fbf277d46aeeed3bc','组织机构删除','DELETE','2018-11-09 15:44:31','2018-11-09 15:45:05',13),('6f818762568e4a9f8dda6e8fccbb3eed','d4522d64580645eaa04f412fa1883105','权限分页查询','SELECT','2018-10-02 00:04:19','2018-10-02 00:04:43',10),('7d890484af724a8386dca20d3877df11','18f5a38372d2418bab2aa2e14f126a17','角色删除','DELETE','2018-10-02 00:46:38','2018-10-02 00:46:50',10),('8092054c4c5c482c80a913acd3107cff','feff45e8254840588ac9802bca9509b9','用户角色设置','SET','2018-11-10 14:35:06','2018-11-10 14:35:29',12),('83f5f14c8e9744299182aaf82196212c','4ac97afeee0c403fb4740aa52b8bdd6a','数据项目添加','ADD','2018-10-05 06:10:05','2018-10-05 06:10:31',10),('8522d88bb2eb482cb53bfd6c5b7a320c','53b564e38c244aa5a004487b4c9cb7fa','操作添加','ADD','2018-10-01 20:33:25','2018-10-01 20:34:25',10),('85d0241f3428437d875a314ca43307ae','b7ccd70bde18437eb5babf71b18f0a9f','菜单添加','ADD','2018-09-30 15:55:29','2018-10-01 19:51:14',11),('8607815b98c64ab9bf52f907f61e646c','7c37e4695392493397ea708fd83e3ffb','系统查询','SELECT','2018-10-01 19:53:28','2018-10-01 19:53:40',10),('865b9d9fab994f99a9455d3b68f78a6c','0c5ab9cc4d5f4d9d8d688dacf8ec9b68','数据类型修改','UPDATE','2018-10-04 06:51:41','2018-10-04 06:51:55',10),('86c8ef88f6f14f48997655304576d07e','7c37e4695392493397ea708fd83e3ffb','系统添加','ADD','2018-10-01 19:52:12','2018-10-01 19:52:30',10),('8e5515ca2b014a6090af0a26ad18e175','d4522d64580645eaa04f412fa1883105','权限修改','UPDATE','2018-10-02 00:45:14','2018-10-02 00:45:25',10),('8ec0f63133f448a1b1943a8d3f00f854','feff45e8254840588ac9802bca9509b9','用户分页查询','SELECT','2018-10-01 20:54:15','2018-11-10 14:35:16',11),('9c526a8fc8c94920a3858a78c2494ac3','4ac97afeee0c403fb4740aa52b8bdd6a','分页查询','SELECT','2018-09-30 09:57:30','2018-09-30 09:57:30',10),('a05d026e28584fd89f60531153f5ef4e','0c5ab9cc4d5f4d9d8d688dacf8ec9b68','数据类型添加','ADD','2018-10-04 06:51:18','2018-10-04 06:51:37',10),('a0f45b70e0e449a29d84c27830dd31c7','4ac97afeee0c403fb4740aa52b8bdd6a','数据项目删除','DELETE','2018-10-05 06:10:00','2018-10-05 06:12:23',10),('aaada611c2294b078798ccb209295462','5a7cc8d284724e318dcc29498097d74c','测试操作','ADD','2018-10-03 18:08:55','2018-10-03 18:09:14',10),('abb41466a3e843f0a5cffb798bda4819','18f5a38372d2418bab2aa2e14f126a17','角色修改','UPDATE','2018-10-02 00:45:47','2018-10-02 00:46:34',10),('b36887dbb498464db3f3cb0c9fa6e268','d4522d64580645eaa04f412fa1883105','权限删除','DELETE','2018-10-02 00:45:29','2018-10-02 00:45:39',10),('b6b6ebba5bd947b1b39cc05901e5e1c9','3089c3af0d7047a28f4a1d9afeaee138','默认操作名称11111','UPDATE','2018-10-02 01:04:31','2018-10-02 01:04:47',10),('bf9bcff3a5a94c28a654daa1cc690099','e36e59ddaebc4f8fbf277d46aeeed3bc','组织机构查询','SELECT','2018-11-09 14:52:47','2018-11-09 14:54:31',10),('cca409f785284ff2829a7be3ed9c843e','53b564e38c244aa5a004487b4c9cb7fa','操作查询','SELECT','2018-10-01 20:41:12','2018-10-01 20:41:27',10),('cfee656c7fcb4e4383bb1c21e20d144c','4ac97afeee0c403fb4740aa52b8bdd6a','数据项目状态设置','SET','2018-10-05 06:09:57','2018-10-05 06:12:53',10),('d6f25958f41a4663b97d96c2b11300c2','18f5a38372d2418bab2aa2e14f126a17','角色权限设置','SET','2018-10-04 10:37:27','2018-10-04 11:13:37',10),('dd2c44dce56e401c807372811d2c7a8b','18f5a38372d2418bab2aa2e14f126a17','角色添加','ADD','2018-10-02 00:45:51','2018-10-02 00:46:20',10),('e822cfde9d08499387099234c8b9e0ce','d4522d64580645eaa04f412fa1883105','权限添加','ADD','2018-10-02 00:44:48','2018-10-02 00:45:10',10),('e8f7ea6e00014f89af26dbfa582b2735','0c5ab9cc4d5f4d9d8d688dacf8ec9b68','数据类型状态设置','SET','2018-10-04 08:53:48','2018-10-04 08:57:30',10),('f14c8b8b2bad401586522d3b5015f1e9','7c37e4695392493397ea708fd83e3ffb','系统修改','UPDATE','2018-10-01 19:52:34','2018-10-01 19:52:47',10),('f3c808cd7c494117aad134a64302b8b3','0c5ab9cc4d5f4d9d8d688dacf8ec9b68','数据类型分页查询','SELECT','2018-09-30 09:48:03','2018-10-04 07:23:31',10),('f814b0f309d84fb3832b20c7e1b61d30','e36e59ddaebc4f8fbf277d46aeeed3bc','组织机构添加','ADD','2018-11-09 15:43:39','2018-11-09 15:44:00',11);
/*!40000 ALTER TABLE `operation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organization` (
  `id` varchar(50) NOT NULL COMMENT '组织机构id',
  `name` varchar(200) DEFAULT NULL COMMENT '组织机构名称',
  `parent_id` varchar(50) DEFAULT NULL COMMENT '父节点id',
  `level` char(1) DEFAULT NULL COMMENT '组织结构目录深度',
  `is_leaf` char(1) DEFAULT NULL COMMENT '是否是叶子节点',
  `sort_number` smallint(6) DEFAULT NULL COMMENT '排序字段',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_deleted` char(1) DEFAULT NULL COMMENT '是否删除（1：是，0：否）',
  PRIMARY KEY (`id`),
  KEY `IXFK_organization_organization` (`parent_id`),
  CONSTRAINT `FK_organization_organization` FOREIGN KEY (`parent_id`) REFERENCES `organization` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织机构';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization`
--

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES ('3ff863898da74c7fa4e06bf492b80b00','默认组织机构2','abc',NULL,'',101,'2018-10-08 13:34:09','2018-11-09 18:16:26','1'),('4e828f4a31a04e41957c03c10cdb49a6','默认组织机构','abc',NULL,'',10,'2018-11-09 18:17:02','2018-11-09 18:17:02','0'),('51dbafd18c144c9c9fb3a489a565016a','默认组织机构','bf623a5df47d4893a5bc2e74d48cd042',NULL,'',10,'2018-11-09 15:51:58','2018-11-09 15:53:32','1'),('66ef829dd7a24232ab64e8f548da678d','默认组织机构','abc',NULL,'',10,'2018-11-09 18:16:32','2018-11-09 18:17:31','1'),('abc','xx有限公司3',NULL,'1','1',1,'2018-10-08 04:39:54','2018-11-09 18:16:28','1'),('bf623a5df47d4893a5bc2e74d48cd042','默认组织机构1','3ff863898da74c7fa4e06bf492b80b00',NULL,'',10,'2018-10-08 13:38:08','2018-11-09 15:53:40','1'),('c6aca82eddbe40938e4e3302d47e278c','默认组织机构','f08ce77319294938895c2b0fd799ef8b',NULL,'',10,'2018-11-09 15:55:38','2018-11-09 18:16:18','1'),('f08ce77319294938895c2b0fd799ef8b','默认组织机构','3ff863898da74c7fa4e06bf492b80b00',NULL,'',10,'2018-11-09 15:53:53','2018-11-09 18:16:23','1');
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `id` varchar(50) NOT NULL,
  `name` varchar(200) NOT NULL,
  `url` varchar(300) NOT NULL COMMENT '访问许可地址（即：api url 地址）',
  `operation_id` varchar(50) NOT NULL COMMENT '所属操作',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  `sort_number` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IXFK_permission_operation` (`operation_id`),
  CONSTRAINT `FK_permission_operation` FOREIGN KEY (`operation_id`) REFERENCES `operation` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='访问许可（可交互操作下的请求链接：可能存在一对多，一个操作请求多个 url 地址）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES ('00a5d99fcf7d44208fc637e78a80d52e','菜单添加','/menu/add','85d0241f3428437d875a314ca43307ae','2018-10-01 20:30:32','2018-10-01 20:30:58',10),('0643985c7f084ec9b8df9c6b0e8398a2','查询所有系统信息','/plat/list','e822cfde9d08499387099234c8b9e0ce','2018-10-03 13:27:27','2018-10-03 15:16:44',10),('073c603c028f4260afb53ad371e82337','角色修改','/role/update','abb41466a3e843f0a5cffb798bda4819','2018-10-02 11:42:27','2018-10-02 11:42:42',10),('0adb6a7da653407a966748cc3b543cf5','根据系统id查询所有操作集合','/operation/list','e822cfde9d08499387099234c8b9e0ce','2018-10-03 13:27:25','2018-10-03 21:27:29',10),('0b0143e4f23d407590b20cb77f856144','权限删除','/authority/delete','b36887dbb498464db3f3cb0c9fa6e268','2018-10-02 00:49:43','2018-10-02 00:49:59',10),('0fe0fda561344cf1bd56e15c935fc884','根据系统id查询权限列表','/authority/list','d6f25958f41a4663b97d96c2b11300c2','2018-10-04 10:37:46','2018-10-04 10:39:20',10),('1101b15c4a97452bb1b125bf14029cdb','权限添加','/authority/add','e822cfde9d08499387099234c8b9e0ce','2018-10-02 00:48:54','2018-10-02 00:49:11',10),('130b56e3e8aa4074a67ca1829d362db7','数据项目添加','/dictionary/item/add','83f5f14c8e9744299182aaf82196212c','2018-10-05 06:11:14','2018-10-05 06:11:33',10),('16a826a32f894bdc8e332c50ef39e44a','根据系统id查询权限列表','/authority/list','dd2c44dce56e401c807372811d2c7a8b','2018-10-02 20:15:55','2018-10-04 10:42:13',10),('223617bde2134eefb4867d37fa106283','角色权限添加','/role/authority/add','d6f25958f41a4663b97d96c2b11300c2','2018-10-04 11:13:41','2018-10-04 11:14:13',10),('296ce091375344f2ab218ff4321a6b53','子操作添加','/permission/add','85d0241f3428437d875a314ca43307ae','2018-10-01 20:44:15','2018-10-01 20:44:29',10),('303fe5a95e6f454f8113e46ff6c9c600','系统删除','/plat/delete','4c450aa8acf548cdac8c5fc8b4f8445f','2018-10-01 20:00:25','2018-10-01 20:00:43',10),('32f576258a3e4325a67dfefcb8e5f40b','查询组织机构是否可以删除','/org/check/status','5707571ae258420594adb225ad75455e','2018-11-09 15:52:50','2018-11-09 15:53:13',10),('34c90d685e2b42d5961977fa4671e5a3','子操作删除','/permission/delete','179334afc02c481ab95d496f9af51f1b','2018-10-01 20:43:39','2018-10-01 20:43:56',10),('352bf303896443138ca0fec7b468f91f','系统分页查询','/plat','8607815b98c64ab9bf52f907f61e646c','2018-10-01 19:53:47','2018-10-01 19:54:44',10),('38dc9e0f3bc94c988d86b8b5ec763504','查询所有系统信息','/plat/list','6f818762568e4a9f8dda6e8fccbb3eed','2018-10-03 15:16:48','2018-10-03 15:17:00',10),('3c67af72462e496eb38b2c0b7147cdc6','权限修改','/authority/update','8e5515ca2b014a6090af0a26ad18e175','2018-10-02 00:49:14','2018-10-02 00:49:39',10),('40eb11ed4b8d4c4e9613b7e60194ffb8','子操作修改','/permission/update','45f0a6a8e1634eb785f635e3ffcc4e40','2018-10-01 20:44:47','2018-10-01 20:44:59',10),('411ad4b028954219ae447407505cb9a3','检测角色名称是否存在','/role/check/update/exist','abb41466a3e843f0a5cffb798bda4819','2018-10-02 21:52:37','2018-10-02 21:52:59',10),('418506168b704663937d6f2cee05e5d5','权限分页查询','/authority','6f818762568e4a9f8dda6e8fccbb3eed','2018-10-02 00:04:46','2018-10-02 00:07:09',10),('4406b2808d3345c3a562f144147d81f0','数据类型状态设置','/dictionary/type/set','e8f7ea6e00014f89af26dbfa582b2735','2018-10-04 08:57:34','2018-10-04 08:58:02',10),('48ef6dc33a0e4694a35d0505ce4e7cb4','数据类型删除','/dictionary/type/delete','173e2bf700844bc3a147f40b1313e4fc','2018-10-04 06:52:57','2018-10-04 07:23:55',10),('49bf1b563521401aacde990a45e9861f','检测修改系统是否已经存在','/plat/check/update/exist','f14c8b8b2bad401586522d3b5015f1e9','2018-10-01 20:02:10','2018-10-01 20:02:35',10),('545c9587f95b4da0bbb885531c83be17','操作删除','/operation/delete','179334afc02c481ab95d496f9af51f1b','2018-10-01 20:36:15','2018-10-01 20:36:37',10),('54c9df7cf5a74dc6ab8d4d2651655a8d','分页查询','/dictionary/item','9c526a8fc8c94920a3858a78c2494ac3','2018-09-30 09:57:37','2018-09-30 15:04:34',11),('56a2ac37d3404179b2ec773063b52c76','组织机构删除','/org/delete','5707571ae258420594adb225ad75455e','2018-11-09 15:46:05','2018-11-09 15:46:20',10),('59c6a46079a14c4e9f9c3dba40dbd30d','角色分页查询','/role','0a75baf5f18d41ccb1ad613301e3ff8e','2018-10-02 00:05:31','2018-10-02 00:14:20',10),('5c539cc025de41179e49701152ceb6b5','查询数据类型列表','/dictionary/type/list','9c526a8fc8c94920a3858a78c2494ac3','2018-10-05 08:19:50','2018-10-05 08:20:09',10),('5ed2ee70110e4a5188d6934c993253ba','检测角色名称是否存在','/role/check/exist','dd2c44dce56e401c807372811d2c7a8b','2018-10-02 22:03:39','2018-10-02 22:04:01',10),('692dc54634c4489e93a5aa1f0c9f0b60','系统启停','/plat/stop','3c06beba7e1c4329b7baebae1102b5df','2018-10-01 20:21:56','2018-10-01 20:22:10',10),('69477313d93d4af19c9c473caa5b8c9e','数据项目编码校验','/dictionary/item/check/exist','83f5f14c8e9744299182aaf82196212c','2018-10-05 06:14:23','2018-10-05 06:15:06',10),('6c4273214b6c4e1ea25a6e33d77b1d55','操作修改','/operation/update','45f0a6a8e1634eb785f635e3ffcc4e40','2018-10-01 20:35:44','2018-10-01 20:35:54',10),('6f288b88131947f4a5ef7f886a8f7456','检测系统是否已经存在','/plat/check/exist','86c8ef88f6f14f48997655304576d07e','2018-10-01 19:59:34','2018-10-01 19:59:49',10),('707fccf07a6e4637aeda0797890f5bb3','组织机构查询','/org/list','bf9bcff3a5a94c28a654daa1cc690099','2018-11-09 14:53:21','2018-11-09 14:54:27',10),('71a67f76303b41ce960662f829115848','数据类型分页查询','/dictionary/type','f3c808cd7c494117aad134a64302b8b3','2018-09-30 09:51:22','2018-10-04 07:23:25',10),('7554a00330cd4e52a570c79ab9dc7a91','默认子操作名称','-','b6b6ebba5bd947b1b39cc05901e5e1c9','2018-10-02 01:04:34','2018-10-02 01:04:34',10),('77edce56e3074ba3872b9a7ed06e5e47','根据系统id获取所有菜单','/menu/list','069664a094d74be0bcf17da1b4babc24','2018-10-01 20:40:09','2018-10-03 12:49:39',10),('78772186200e4e2bb30d5632e8d389dd','数据项目修改','/dictionary/item/update','4e5ad45c27f24c038d8753c42734068f','2018-10-05 06:11:37','2018-10-05 06:13:50',10),('7a85cdc8cb624da3a4420a5f35471b05','组织机构修改','/org/update','442dc45016dd40e395e4374d6260c596','2018-11-09 15:45:45','2018-11-09 15:45:59',10),('7cff01cc5cb2472aae5b2287a4005459','数据类型修改','/dictionary/type/update','865b9d9fab994f99a9455d3b68f78a6c','2018-10-04 06:53:26','2018-10-04 07:23:49',10),('7ddf4813ab0b4c4091ee172abe776e23','权限操作设置','/authority/set','09928098cf4d4fbe89389dd5ea5a7658','2018-10-04 03:26:55','2018-10-04 03:31:28',10),('806dc0c4e7f24eaeba763fe5b69ef777','数据类型删除校验','/dictionary/type/check/status','173e2bf700844bc3a147f40b1313e4fc','2018-10-04 10:14:49','2018-10-04 10:15:11',10),('82bd445a263e467eaf6b8494a9223b7d','用户账号启停','/user/stop','0fb2d855c06c4b4abdbf0fb77c454910','2018-10-01 21:01:27','2018-10-01 21:01:46',10),('838b15df9f2f423b8c050cb16750f8d3','数据类型编码校验','/dictionary/type/check/exist','a05d026e28584fd89f60531153f5ef4e','2018-10-04 11:12:15','2018-10-04 11:12:29',10),('843c9169a6484511ade8f90c6d439d25','系统修改','/plat/update','f14c8b8b2bad401586522d3b5015f1e9','2018-10-01 20:01:30','2018-10-01 20:01:41',10),('84917a4d66e147f8b5489acf789c279e','菜单修改','/menu/update','04b04c92d1c949719348677d8c820382','2018-10-01 20:31:27','2018-10-01 20:31:39',10),('869275df777c401eb2e7f62ce3eb06d6','数据项目删除','/dictionary/item/delete','a0f45b70e0e449a29d84c27830dd31c7','2018-10-05 06:11:42','2018-10-05 06:14:01',10),('8b4e22418e3e4149bc341dd77f15c16f','查询当前账号已设置角色','/user/select/roles','8092054c4c5c482c80a913acd3107cff','2018-11-10 14:35:44','2018-11-10 15:17:30',11),('90d2f03be24a40468421c2d15f41d6b6','根据角色id查询权限列表','/role/authority/list','d6f25958f41a4663b97d96c2b11300c2','2018-10-04 10:37:43','2018-10-04 10:39:47',10),('94521c2b52bf46908d189c9bac6d1b5e','用户角色设置','/user/add/roles','8092054c4c5c482c80a913acd3107cff','2018-11-10 14:35:33','2018-11-10 15:17:22',10),('9d215feaa489470a8a5d7eaadf9b4808','查询所有平台所有角色','/plat/role/list','8ec0f63133f448a1b1943a8d3f00f854','2018-11-09 15:11:25','2018-11-10 15:17:08',11),('9f1b19a498234c7c87fff759cf30bab4','数据类型添加','/dictionary/type/add','a05d026e28584fd89f60531153f5ef4e','2018-10-04 06:53:44','2018-10-04 07:24:19',10),('af0d8c770722429b90ed79cc482cec6e','系统添加','/plat/add','86c8ef88f6f14f48997655304576d07e','2018-10-01 19:58:46','2018-10-01 19:59:01',10),('afb2893812cb40f6b436488c6c7c2c9e','角色删除','/role/delete','7d890484af724a8386dca20d3877df11','2018-10-02 11:42:56','2018-10-02 11:43:13',10),('bd5fb50a4e25482487a61f400b1f01b7','根据系统id获取操作和许可列表','/permission/list','cca409f785284ff2829a7be3ed9c843e','2018-10-01 20:41:37','2018-10-03 12:26:35',10),('c896e0dc65ad4233807f69864b6e6d7d','操作添加','/operation/add','8522d88bb2eb482cb53bfd6c5b7a320c','2018-10-01 20:35:16','2018-10-01 20:35:26',10),('c95f3c139d204e839dfe10d7bb6c603f','查询数据类型列表','/dictionary/type/list','83f5f14c8e9744299182aaf82196212c','2018-10-05 07:58:00','2018-10-05 07:58:27',10),('cd46151430924e608460d1d39887f0ca','系统列表查询','/plat/list','069664a094d74be0bcf17da1b4babc24','2018-10-01 20:39:15','2018-10-01 20:39:36',10),('cf37f62d57f44b92ab8ae14d26995446','根据权限id获取所有选中菜单操作id','/authority/granted/ids','09928098cf4d4fbe89389dd5ea5a7658','2018-10-04 00:57:14','2018-10-04 03:32:41',10),('d94c44e1f2354331bbfefd8019235f48','根据系统id查询所有操作集合','/operation/list','09928098cf4d4fbe89389dd5ea5a7658','2018-10-04 00:56:42','2018-10-04 00:56:58',10),('dc115e3bec164dffb80529b3b8fc3c65','数据项目状态设置','/dictionary/item/set','cfee656c7fcb4e4383bb1c21e20d144c','2018-10-05 06:11:45','2018-10-05 06:13:14',10),('dc7a287e9e8f44edb1b839fe13a1f6f2','用户分页查询','/user','8ec0f63133f448a1b1943a8d3f00f854','2018-10-01 20:59:53','2018-10-01 21:00:08',10),('e3ca4cb9272b478596164d7b3cf41446','数据项目查询','/dictionary/item/list','9c526a8fc8c94920a3858a78c2494ac3','2018-09-30 10:46:18','2018-09-30 15:08:47',9),('e94c26df0c9343afb703bd29c733937a','组织机构添加','/org/add','f814b0f309d84fb3832b20c7e1b61d30','2018-11-09 15:45:22','2018-11-09 15:45:38',10),('ee177cef9c39484a973ff81aee2bcf4b','角色添加','/role/add','dd2c44dce56e401c807372811d2c7a8b','2018-10-02 11:42:01','2018-10-02 11:42:21',10),('f1745c902f3a49e995cb4d4296e4b163','根据菜单id获取操作列表','/operation/granted/list','aaada611c2294b078798ccb209295462','2018-10-03 18:09:18','2018-10-03 18:10:11',10),('f4c2f54f7667452eb3f00f9eb4206179','菜单删除','/menu/delete','350ce7ba50434f3db3be3b50634b5aa1','2018-10-01 20:32:04','2018-10-01 20:32:14',10);
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plat`
--

DROP TABLE IF EXISTS `plat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plat` (
  `id` varchar(50) NOT NULL COMMENT '平台id',
  `name` varchar(200) NOT NULL COMMENT '平台名称',
  `description` varchar(500) DEFAULT NULL COMMENT '平台描述',
  `url` varchar(300) DEFAULT NULL COMMENT '平台url地址',
  `image` varchar(500) DEFAULT NULL COMMENT '平台图片',
  `version` varchar(50) DEFAULT NULL COMMENT '平台版本',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `sort_number` smallint(6) DEFAULT NULL COMMENT '排序字段',
  `is_deleted` char(1) DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  `is_enabled` char(1) DEFAULT '1' COMMENT '是否启用（1：是，0：否）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plat`
--

LOCK TABLES `plat` WRITE;
/*!40000 ALTER TABLE `plat` DISABLE KEYS */;
INSERT INTO `plat` VALUES ('2f93486ffd6f422ba0256e957b9a79fd','3434','3','434',NULL,'3434','2018-10-05 08:38:19','2018-11-10 14:43:45',10,'1','0'),('5bcae4a6036f43709877191f3bcb4283','权限管理系统','权限管理系统','http://www.baidu.com','','v1.0.0','2018-09-21 11:07:42','2018-10-05 08:53:27',1,'0','1'),('c6124b229ba04562b79e96eec43f3a59','测试系统名称','22','2',NULL,'2','2018-09-21 11:08:40','2018-10-03 15:10:38',1,'0','1');
/*!40000 ALTER TABLE `plat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` varchar(50) NOT NULL COMMENT '角色id',
  `plat_id` varchar(50) DEFAULT NULL COMMENT '所属平台',
  `name` varchar(200) NOT NULL COMMENT '角色名称',
  `description` varchar(500) DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `sort_number` smallint(6) DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`),
  KEY `IXFK_role_plat` (`plat_id`),
  CONSTRAINT `FK_role_plat` FOREIGN KEY (`plat_id`) REFERENCES `plat` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('1','5bcae4a6036f43709877191f3bcb4283','超级管理员','超级管理员','2018-09-02 14:47:47','2018-10-05 05:17:22',12),('e7fe456772d241099b34ada93b4f66f4','5bcae4a6036f43709877191f3bcb4283','test','test11','2018-10-02 22:04:17','2018-10-03 13:10:06',10),('eb75dd12435b48379fe5a2ea95f40cb9','c6124b229ba04562b79e96eec43f3a59','test','test','2018-10-03 18:19:19','2018-10-04 00:06:38',10),('fe1c1c70aa2b4f6cbdde486cd78af8d9','5bcae4a6036f43709877191f3bcb4283','权限系统角色','权限系统角色','2018-10-03 19:13:04','2018-11-09 15:21:30',10);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_authority`
--

DROP TABLE IF EXISTS `role_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_authority` (
  `role_id` varchar(50) DEFAULT NULL,
  `authority_id` varchar(50) DEFAULT NULL,
  UNIQUE KEY `UNI_ROLE_AUTHORITY` (`role_id`,`authority_id`),
  KEY `IXFK_role_authority_authority` (`authority_id`),
  KEY `IXFK_role_authority_role` (`role_id`),
  CONSTRAINT `FK_role_authority_authority` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_role_authority_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_authority`
--

LOCK TABLES `role_authority` WRITE;
/*!40000 ALTER TABLE `role_authority` DISABLE KEYS */;
INSERT INTO `role_authority` VALUES ('1','1'),('eb75dd12435b48379fe5a2ea95f40cb9','685aae4af6f34606a5c826b19f18d25e'),('fe1c1c70aa2b4f6cbdde486cd78af8d9','1eccecf88d304aa3a93b329efca4ba4b');
/*!40000 ALTER TABLE `role_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL COMMENT '用户账号（登录',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `is_enabled` char(1) DEFAULT '1' COMMENT '是否启用（1：是，0：否）',
  `is_deleted` char(1) DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNI_USER_NAME` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1','GrandKai','lueSGJZetyySpUndWjMBEg==','张亚男','1','0','2018-08-30 10:38:23','2018-11-10 14:30:55'),('dc3b83f489b5443bbc35729ccd880057','test','4QrcOUm6Wau+VuBX8g+IPg==','test','1','0','2018-10-07 22:33:21','2018-10-07 22:33:21');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  `role_id` varchar(50) DEFAULT NULL COMMENT '角色id',
  UNIQUE KEY `UNI_USER_ROLE` (`user_id`,`role_id`),
  KEY `IXFK_user_role_role` (`role_id`),
  KEY `IXFK_user_role_user` (`role_id`),
  CONSTRAINT `FK_user_role_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_user_role_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('1','1'),('1','e7fe456772d241099b34ada93b4f66f4'),('1','eb75dd12435b48379fe5a2ea95f40cb9'),('1','fe1c1c70aa2b4f6cbdde486cd78af8d9'),('dc3b83f489b5443bbc35729ccd880057','1'),('dc3b83f489b5443bbc35729ccd880057','e7fe456772d241099b34ada93b4f66f4'),('dc3b83f489b5443bbc35729ccd880057','fe1c1c70aa2b4f6cbdde486cd78af8d9');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-10 15:52:03
