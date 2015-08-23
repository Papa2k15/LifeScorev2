CREATE TABLE players(
	LSUID 			VARCHAR(100),
	firstName 		VARCHAR(60),		
	lastName 		VARCHAR(60),
	userName		VARCHAR(30),		
	password		VARCHAR(60),
	email			VARCHAR(100),
	PRIMARY  KEY (LSUID)
) ENGINE=MyISAM; 

CREATE TABLE demographics(
	LSUID 			VARCHAR(100),
	dob				DATE default '0000-00-00',
	gender			VARCHAR(6),
	PRIMARY  KEY (LSUID)
) ENGINE=MyISAM;

CREATE TABLE missions(
	LSMID  		VARCHAR(100),
	LSUID		VARCHAR(100),
	title	 	VARCHAR(100),		
	description	VARCHAR(200),		
	trackerVal  BIGINT(50),
	trackerGoal BIGINT(50),
	unit		VARCHAR(50),
	startDate	DATE default '0000-00-00',
	endDate		DATE default '0000-00-00',	
	complete	BOOLEAN default false,
	priority    VARCHAR(6),
	pointsEarned BOOLEAN default false,
	PRIMARY  KEY (LSMID)
) ENGINE=MyISAM; 

CREATE TABLE points(
	LSUID		VARCHAR(100),
	total  		BIGINT,
	daily  		BIGINT,
	weekly  	BIGINT,
	monthly  	BIGINT,
	yearly  	BIGINT,
	dReset		BOOLEAN default false,
	wReset		BOOLEAN default false,
	mReset		BOOLEAN default false,
	yReset		BOOLEAN default false,
	PRIMARY KEY (LSUID)
) ENGINE=MyISAM;