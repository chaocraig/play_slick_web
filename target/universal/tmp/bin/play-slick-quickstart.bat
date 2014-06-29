@REM play-slick-quickstart launcher script
@REM
@REM Envioronment:
@REM JAVA_HOME - location of a JDK home dir (optional if java on path)
@REM CFG_OPTS  - JVM options (optional)
@REM Configuration:
@REM PLAY_SLICK_QUICKSTART_config.txt found in the PLAY_SLICK_QUICKSTART_HOME.
@setlocal enabledelayedexpansion

@echo off
if "%PLAY_SLICK_QUICKSTART_HOME%"=="" set "PLAY_SLICK_QUICKSTART_HOME=%~dp0\\.."
set ERROR_CODE=0

set "APP_LIB_DIR=%PLAY_SLICK_QUICKSTART_HOME%\lib\"

rem Detect if we were double clicked, although theoretically A user could
rem manually run cmd /c
for %%x in (%cmdcmdline%) do if %%~x==/c set DOUBLECLICKED=1

rem FIRST we load the config file of extra options.
set "CFG_FILE=%PLAY_SLICK_QUICKSTART_HOME%\PLAY_SLICK_QUICKSTART_config.txt"
set CFG_OPTS=
if exist %CFG_FILE% (
  FOR /F "tokens=* eol=# usebackq delims=" %%i IN ("%CFG_FILE%") DO (
    set DO_NOT_REUSE_ME=%%i
    rem ZOMG (Part #2) WE use !! here to delay the expansion of
    rem CFG_OPTS, otherwise it remains "" for this loop.
    set CFG_OPTS=!CFG_OPTS! !DO_NOT_REUSE_ME!
  )
)

rem We use the value of the JAVACMD environment variable if defined
set _JAVACMD=%JAVACMD%

if "%_JAVACMD%"=="" (
  if not "%JAVA_HOME%"=="" (
    if exist "%JAVA_HOME%\bin\java.exe" set "_JAVACMD=%JAVA_HOME%\bin\java.exe"
  )
)

if "%_JAVACMD%"=="" set _JAVACMD=java

rem Detect if this java is ok to use.
for /F %%j in ('"%_JAVACMD%" -version  2^>^&1') do (
  if %%~j==Java set JAVAINSTALLED=1
)

rem Detect the same thing about javac
if "%_JAVACCMD%"=="" (
  if not "%JAVA_HOME%"=="" (
    if exist "%JAVA_HOME%\bin\javac.exe" set "_JAVACCMD=%JAVA_HOME%\bin\javac.exe"
  )
)
if "%_JAVACCMD%"=="" set _JAVACCMD=javac
for /F %%j in ('"%_JAVACCMD%" -version 2^>^&1') do (
  if %%~j==javac set JAVACINSTALLED=1
)

rem BAT has no logical or, so we do it OLD SCHOOL! Oppan Redmond Style
set JAVAOK=true
if not defined JAVAINSTALLED set JAVAOK=false
rem TODO - JAVAC is an optional requirement.
if not defined JAVACINSTALLED set JAVAOK=false

if "%JAVAOK%"=="false" (
  echo.
  echo A Java JDK is not installed or can't be found.
  if not "%JAVA_HOME%"=="" (
    echo JAVA_HOME = "%JAVA_HOME%"
  )
  echo.
  echo Please go to
  echo   http://www.oracle.com/technetwork/java/javase/downloads/index.html
  echo and download a valid Java JDK and install before running play-slick-quickstart.
  echo.
  echo If you think this message is in error, please check
  echo your environment variables to see if "java.exe" and "javac.exe" are
  echo available via JAVA_HOME or PATH.
  echo.
  if defined DOUBLECLICKED pause
  exit /B 1
)


rem We use the value of the JAVA_OPTS environment variable if defined, rather than the config.
set _JAVA_OPTS=%JAVA_OPTS%
if "%_JAVA_OPTS%"=="" set _JAVA_OPTS=%CFG_OPTS%

:run
 
set "APP_CLASSPATH=%APP_LIB_DIR%\default.play-slick-quickstart-1.0-SNAPSHOT.jar;%APP_LIB_DIR%\activation-1.1.jar;%APP_LIB_DIR%\annotations-7.0.3.jar;%APP_LIB_DIR%\annotations-api-6.0.35.jar;%APP_LIB_DIR%\antlr-2.7.6.jar;%APP_LIB_DIR%\atomikos-util-3.7.0.jar;%APP_LIB_DIR%\axis-1.4-sources.jar;%APP_LIB_DIR%\axis-1.4.jar;%APP_LIB_DIR%\axis-jaxrpc-1.4.jar;%APP_LIB_DIR%\axis-saaj-1.4.jar;%APP_LIB_DIR%\axis-wsdl4j-1.5.1.jar;%APP_LIB_DIR%\bcprov-ext-jdk16-145.jar;%APP_LIB_DIR%\bcprov-jdk16-145.jar;%APP_LIB_DIR%\c3p0-0.9.1.2.jar;%APP_LIB_DIR%\catalina-6.0.35.jar;%APP_LIB_DIR%\com.springsource.javax.mail-1.4.0.jar;%APP_LIB_DIR%\com.springsource.org.aopalliance-1.0.0.jar;%APP_LIB_DIR%\commons-codec-1.4.jar;%APP_LIB_DIR%\commons-collections-3.2.1.jar;%APP_LIB_DIR%\commons-discovery-0.2.jar;%APP_LIB_DIR%\commons-lang-2.6.jar;%APP_LIB_DIR%\commons-logging-1.1.0.jboss.jar;%APP_LIB_DIR%\commons-pool-1.5.4.jar;%APP_LIB_DIR%\couchbase-1.1.8.jar;%APP_LIB_DIR%\Decrypt.jar;%APP_LIB_DIR%\dom4j-1.6.1.jar;%APP_LIB_DIR%\gson-2.2.2.jar;%APP_LIB_DIR%\hibernate-3.6.0.jar;%APP_LIB_DIR%\hibernate-jpa-2.0-api-1.0.0.Final.jar;%APP_LIB_DIR%\hibernate-memcached-1.3.0.jar;%APP_LIB_DIR%\hibernate-validator-4.1.0.Final.jar;%APP_LIB_DIR%\httpclient-4.1.1.jar;%APP_LIB_DIR%\httpcore-4.1.1.jar;%APP_LIB_DIR%\httpcore-nio-4.1.1.jar;%APP_LIB_DIR%\infinispan-client-hotrod-5.1.6.jar;%APP_LIB_DIR%\infinispan-core-5.1.6.jar;%APP_LIB_DIR%\javassist-3.9.0.GA.jar;%APP_LIB_DIR%\jaxb-api-2.1.jar;%APP_LIB_DIR%\jaxrpc-1.1.jar;%APP_LIB_DIR%\jboss-logging-3.1.0.GA.jar;%APP_LIB_DIR%\jboss-marshalling-1.3.11.GA.jar;%APP_LIB_DIR%\jboss-marshalling-river-1.3.11.GA.jar;%APP_LIB_DIR%\jboss-transaction-api_1.1_spec-1.0.0.Final.jar;%APP_LIB_DIR%\jcip-annotations-1.0.jar;%APP_LIB_DIR%\jcl-over-slf4j-1.6.1.jar;%APP_LIB_DIR%\jettison-1.0.1.jar;%APP_LIB_DIR%\jgroups-3.0.11.Final.jar;%APP_LIB_DIR%\jline-1.0.jar;%APP_LIB_DIR%\juli-6.0.35.jar;%APP_LIB_DIR%\junit-4.7-sources.jar;%APP_LIB_DIR%\junit-4.7.jar;%APP_LIB_DIR%\log4j-1.2.16.jar;%APP_LIB_DIR%\logback-classic-0.9.28.jar;%APP_LIB_DIR%\logback-core-0.9.28.jar;%APP_LIB_DIR%\mysql-connector-java-5.1.17-bin.jar;%APP_LIB_DIR%\netty-3.5.5.jar;%APP_LIB_DIR%\org.osgi.core-4.3.0-javadoc.jar;%APP_LIB_DIR%\org.osgi.core-4.3.0-sources.jar;%APP_LIB_DIR%\org.osgi.core-4.3.0.jar;%APP_LIB_DIR%\org.springframework.aop-3.0.5.RELEASE.jar;%APP_LIB_DIR%\org.springframework.asm-3.0.5.RELEASE.jar;%APP_LIB_DIR%\org.springframework.beans-3.0.5.RELEASE.jar;%APP_LIB_DIR%\org.springframework.context-3.0.5.RELEASE.jar;%APP_LIB_DIR%\org.springframework.context.support-3.0.5.RELEASE.jar;%APP_LIB_DIR%\org.springframework.core-3.0.5.RELEASE.jar;%APP_LIB_DIR%\org.springframework.expression-3.0.5.RELEASE.jar;%APP_LIB_DIR%\org.springframework.jdbc-3.0.5.RELEASE.jar;%APP_LIB_DIR%\org.springframework.orm-3.0.5.RELEASE.jar;%APP_LIB_DIR%\org.springframework.test-3.0.5.RELEASE.jar;%APP_LIB_DIR%\org.springframework.transaction-3.0.5.RELEASE.jar;%APP_LIB_DIR%\org.springframework.web-3.0.5.RELEASE.jar;%APP_LIB_DIR%\org.springframework.web.servlet-3.0.5.RELEASE.jar;%APP_LIB_DIR%\oro-2.0.8.jar;%APP_LIB_DIR%\rhq-pluginAnnotations-3.0.4-javadoc.jar;%APP_LIB_DIR%\rhq-pluginAnnotations-3.0.4-sources.jar;%APP_LIB_DIR%\rhq-pluginAnnotations-3.0.4.jar;%APP_LIB_DIR%\servlet-api-6.0.35.jar;%APP_LIB_DIR%\slf4j-api-1.6.1.jar;%APP_LIB_DIR%\spring-batch-core-2.1.5.RELEASE.jar;%APP_LIB_DIR%\spring-batch-infrastructure-2.1.5.RELEASE.jar;%APP_LIB_DIR%\spring-security-acl-3.0.5.RELEASE.jar;%APP_LIB_DIR%\spring-security-config-3.0.5.RELEASE.jar;%APP_LIB_DIR%\spring-security-core-3.0.5.RELEASE.jar;%APP_LIB_DIR%\spring-security-taglibs-3.0.5.RELEASE.jar;%APP_LIB_DIR%\spring-security-web-3.0.5.RELEASE.jar;%APP_LIB_DIR%\spymemcached-2.9.1.jar;%APP_LIB_DIR%\stax-api-1.0-2.jar;%APP_LIB_DIR%\stax2-api-3.1.1-sources.jar;%APP_LIB_DIR%\stax2-api-3.1.1.jar;%APP_LIB_DIR%\transactions-3.7.0.jar;%APP_LIB_DIR%\transactions-api-3.7.0.jar;%APP_LIB_DIR%\transactions-hibernate3-3.7.0.jar;%APP_LIB_DIR%\transactions-jdbc-3.7.0.jar;%APP_LIB_DIR%\transactions-jta-3.7.0.jar;%APP_LIB_DIR%\uuid-3.4.jar;%APP_LIB_DIR%\validation-api-1.0.0.GA.jar;%APP_LIB_DIR%\velocity-1.6.4.jar;%APP_LIB_DIR%\woodstox-core-asl-4.1.1-sources.jar;%APP_LIB_DIR%\woodstox-core-asl-4.1.1.jar;%APP_LIB_DIR%\wurfl-1.4.4.jar;%APP_LIB_DIR%\xstream-1.3.1.jar;%APP_LIB_DIR%\org.scala-lang.scala-library-2.10.3.jar;%APP_LIB_DIR%\com.typesafe.play.play-jdbc_2.10-2.2.2.jar;%APP_LIB_DIR%\com.typesafe.play.play_2.10-2.2.2.jar;%APP_LIB_DIR%\com.typesafe.play.sbt-link-2.2.2.jar;%APP_LIB_DIR%\org.javassist.javassist-3.18.0-GA.jar;%APP_LIB_DIR%\com.typesafe.play.play-exceptions-2.2.2.jar;%APP_LIB_DIR%\com.typesafe.play.templates_2.10-2.2.2.jar;%APP_LIB_DIR%\com.github.scala-incubator.io.scala-io-file_2.10-0.4.2.jar;%APP_LIB_DIR%\com.github.scala-incubator.io.scala-io-core_2.10-0.4.2.jar;%APP_LIB_DIR%\com.jsuereth.scala-arm_2.10-1.3.jar;%APP_LIB_DIR%\com.typesafe.play.play-iteratees_2.10-2.2.2.jar;%APP_LIB_DIR%\org.scala-stm.scala-stm_2.10-0.7.jar;%APP_LIB_DIR%\com.typesafe.config-1.0.2.jar;%APP_LIB_DIR%\com.typesafe.play.play-json_2.10-2.2.2.jar;%APP_LIB_DIR%\com.typesafe.play.play-functional_2.10-2.2.2.jar;%APP_LIB_DIR%\com.typesafe.play.play-datacommons_2.10-2.2.2.jar;%APP_LIB_DIR%\joda-time.joda-time-2.2.jar;%APP_LIB_DIR%\org.joda.joda-convert-1.3.1.jar;%APP_LIB_DIR%\com.fasterxml.jackson.core.jackson-annotations-2.2.2.jar;%APP_LIB_DIR%\com.fasterxml.jackson.core.jackson-core-2.2.2.jar;%APP_LIB_DIR%\com.fasterxml.jackson.core.jackson-databind-2.2.2.jar;%APP_LIB_DIR%\org.scala-lang.scala-reflect-2.10.3.jar;%APP_LIB_DIR%\io.netty.netty-3.7.0.Final.jar;%APP_LIB_DIR%\com.typesafe.netty.netty-http-pipelining-1.1.2.jar;%APP_LIB_DIR%\org.slf4j.slf4j-api-1.7.5.jar;%APP_LIB_DIR%\org.slf4j.jul-to-slf4j-1.7.5.jar;%APP_LIB_DIR%\org.slf4j.jcl-over-slf4j-1.7.5.jar;%APP_LIB_DIR%\ch.qos.logback.logback-core-1.0.13.jar;%APP_LIB_DIR%\ch.qos.logback.logback-classic-1.0.13.jar;%APP_LIB_DIR%\com.typesafe.akka.akka-actor_2.10-2.2.0.jar;%APP_LIB_DIR%\com.typesafe.akka.akka-slf4j_2.10-2.2.0.jar;%APP_LIB_DIR%\org.apache.commons.commons-lang3-3.1.jar;%APP_LIB_DIR%\com.ning.async-http-client-1.7.18.jar;%APP_LIB_DIR%\oauth.signpost.signpost-core-1.2.1.2.jar;%APP_LIB_DIR%\commons-codec.commons-codec-1.3.jar;%APP_LIB_DIR%\oauth.signpost.signpost-commonshttp4-1.2.1.2.jar;%APP_LIB_DIR%\org.apache.httpcomponents.httpcore-4.0.1.jar;%APP_LIB_DIR%\org.apache.httpcomponents.httpclient-4.0.1.jar;%APP_LIB_DIR%\commons-logging.commons-logging-1.1.1.jar;%APP_LIB_DIR%\xerces.xercesImpl-2.11.0.jar;%APP_LIB_DIR%\xml-apis.xml-apis-1.4.01.jar;%APP_LIB_DIR%\javax.transaction.jta-1.1.jar;%APP_LIB_DIR%\com.jolbox.bonecp-0.8.0.RELEASE.jar;%APP_LIB_DIR%\com.google.guava.guava-14.0.1.jar;%APP_LIB_DIR%\com.h2database.h2-1.3.172.jar;%APP_LIB_DIR%\tyrex.tyrex-1.0.1.jar;%APP_LIB_DIR%\com.typesafe.play.anorm_2.10-2.2.2.jar;%APP_LIB_DIR%\com.typesafe.play.play-cache_2.10-2.2.2.jar;%APP_LIB_DIR%\net.sf.ehcache.ehcache-core-2.6.6.jar;%APP_LIB_DIR%\mysql.mysql-connector-java-5.1.27.jar;%APP_LIB_DIR%\org.webjars.webjars-play_2.10-2.2.2.jar;%APP_LIB_DIR%\org.webjars.requirejs-2.1.10.jar;%APP_LIB_DIR%\org.webjars.webjars-locator-0.13.jar;%APP_LIB_DIR%\com.typesafe.play.play-slick_2.10-0.6.0.1.jar;%APP_LIB_DIR%\com.typesafe.slick.slick_2.10-2.0.0.jar;%APP_LIB_DIR%\javax.servlet.javax.servlet-api-3.0.1.jar;%APP_LIB_DIR%\com.google.code.findbugs.jsr305-2.0.1.jar;%APP_LIB_DIR%\org.reflections.reflections-0.9.8.jar;%APP_LIB_DIR%\dom4j.dom4j-1.6.1.jar"
set "APP_MAIN_CLASS=play.core.server.NettyServer"

rem TODO - figure out how to pass arguments....
"%_JAVACMD%" %_JAVA_OPTS% %PLAY_SLICK_QUICKSTART_OPTS% -cp "%APP_CLASSPATH%" %APP_MAIN_CLASS% %CMDS%
if ERRORLEVEL 1 goto error
goto end

:error
set ERROR_CODE=1

:end

@endlocal

exit /B %ERROR_CODE%
