CREATE TABLE `sys_users` (
  `usrid` int(11) NOT NULL auto_increment,
  `usrname` varchar(20) character set utf8 default NULL,
  `usrpwd` varchar(20) character set utf8 default NULL,
  `usrtype` int(11) default NULL,
  `usrmgr` int(11) default NULL,
  PRIMARY KEY  (`usrid`),
  KEY `usrmgr` (`usrmgr`),
  CONSTRAINT `sys_users_ibfk_1` FOREIGN KEY (`usrmgr`) REFERENCES `sys_users` (`usrid`)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 9216 kB';

CREATE TABLE `sys_roles` (
  `roleId` int(11) NOT NULL auto_increment,
  `roleName` varchar(40) default NULL,
  `roleUrl` varchar(100) default NULL,
  PRIMARY KEY  (`roleId`)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `usr_role_link` (
  `linkId` int(11) NOT NULL auto_increment,
  `usrid` int(11) default NULL,
  `roleid` int(11) default NULL,
  PRIMARY KEY  (`linkId`),
  KEY `usrid` (`usrid`),
  KEY `roleid` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_reim` (
  `rmid` int(11) NOT NULL auto_increment,
  `usrid` int(11) default NULL,
  `rmname` varchar(50) character set utf8 default NULL,
  `rmdesc` varchar(200) character set utf8 default NULL,
  `rmdate` datetime default NULL,
  PRIMARY KEY  (`rmid`),
  KEY `FK_FK_fk_usr_riem` (`usrid`),
  CONSTRAINT `FK_FK_fk_usr_riem` FOREIGN KEY (`usrid`) REFERENCES `sys_users` (`usrid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `t_reimapp` (
  `app_id` int(11) NOT NULL auto_increment,
  `usrid` int(11) default NULL,
  `rmid` int(11) default NULL,
  `apptext` varchar(30) character set utf8 default NULL,
  `appdesc` varchar(100) character set utf8 default NULL,
  `appdate` datetime default NULL,
  PRIMARY KEY  (`app_id`),
  KEY `FK_FK_fk_riem_appv` (`rmid`),
  KEY `FK_fk_user_reimsp` (`usrid`),
  CONSTRAINT `FK_FK_fk_riem_appv` FOREIGN KEY (`rmid`) REFERENCES `t_reim` (`rmid`),
  CONSTRAINT `FK_fk_user_reimsp` FOREIGN KEY (`usrid`) REFERENCES `sys_users` (`usrid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 9216 kB; (`rmid`) REFER `jbpm4/t_riem`(`rmid`)';

CREATE TABLE `t_reimitm` (
  `rmitmid` int(11) NOT NULL auto_increment,
  `rmid` int(11) default NULL,
  `rmitmname` varchar(50) character set utf8 default NULL,
  `rmitmcost` decimal(12,2) default NULL,
  `rmitmdesc` varchar(100) character set utf8 default NULL,
  PRIMARY KEY  (`rmitmid`),
  KEY `FK_FK_fk_Riem_Itms` (`rmid`),
  CONSTRAINT `FK_FK_fk_Riem_Itms` FOREIGN KEY (`rmid`) REFERENCES `t_reim` (`rmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 



