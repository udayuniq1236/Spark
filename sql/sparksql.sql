DROP TABLE IF EXISTS `sparkdb`.`collegereg`;
CREATE TABLE  `sparkdb`.`collegereg` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `collegename` varchar(30) DEFAULT NULL,
  `collegecode` varchar(30) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `principalname` varchar(30) DEFAULT NULL,
  `admin_name` varchar(30) DEFAULT NULL,
  `admin_emailid` varchar(30) DEFAULT NULL,
  `college_contactno` varchar(12) DEFAULT NULL,
  `college_alternativeno` varchar(12) DEFAULT NULL,
  `college_emailid` varchar(30) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `sparkdb`.`collegesapproved`;
CREATE TABLE  `sparkdb`.`collegesapproved` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sparkid` char(100) NOT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `collegename` varchar(100) DEFAULT NULL,
  `collegecode` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `principalname` varchar(100) DEFAULT NULL,
  `admin_name` varchar(100) DEFAULT NULL,
  `admin_emailid` varchar(100) DEFAULT NULL,
  `college_contactno` varchar(100) DEFAULT NULL,
  `college_alternativeno` varchar(100) DEFAULT NULL,
  `college_emailid` varchar(100) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `sparkdb`.`sparkadmins`;
CREATE TABLE  `sparkdb`.`sparkadmins` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `spark_username` varchar(30) DEFAULT NULL,
  `spark_password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

