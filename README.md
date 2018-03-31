#StatIIS mock endpoints

Serves mock REST endpoints for StatIIS demo.

##Prerequisities
Requires:
* Java 10 JDK
* Oracle 11 XE installed with restored database data, see [Restoring Database](#restoring-database)


##Configuration
 

##Building

Runnable jar file is built by running gradle task `bootJar` which produces jarfile in the `build\libs` subdirectory.

##Running

Resulting jar is run simply by `java -jar statiismock-XXX.jar`.

##Restoring database

1. Download Oracle XE from the [Official website](http://www.oracle.com/technetwork/database/database-technologies/express-edition/downloads/index.html)
2. Copy database dump from <file:\\\frey\all\Projekty\PRE\StatIIS\s3_dump_20180328.zip> and unzip to a local directory `<dump>`
3. Connect to the Oracle database as System user and issue these commands:
    ```oracle
    create or replace directory pre_import as '<dump>';
    create user s3 identified by s3;
    create TABLESPACE PRESTAT datafile 'prestat.dbf' size 1000M;
    ```
(Replace `<dump>` by directory with unzipped dump files.)
4. In registry editor under `Computer\HKEY_LOCAL_MACHINE\SOFTWARE\Oracle\KEY_XE` add a string value with key `NLS_DATE_FORMAT` and value `DD.MM.YYYY`.
5. Import the files by executing this command in the console:
    ```
    impdp system/oracle directory=pre_import file=exp_file_S01.dmp,exp_file_S02.dmp,exp_file_S03.dmp,exp_file_S04.dmp log=logfile.txt full=y
    ```