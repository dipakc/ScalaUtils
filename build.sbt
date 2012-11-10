/* basic project info */
name := "scalautils"

organization := "com.github.dipakc"

version := "0.1.0-SNAPSHOT"

description := "My personal collection of scala utils"

homepage := Some(url("https://github.com/dipakc/ScalaUtils"))

startYear := Some(2012)

licenses := Seq(
  ("GPLv3", url("http://www.gnu.org/licenses/gpl-3.0.txt"))
)

scmInfo := Some(
  ScmInfo(
    url("https://github.com/dipakc/ScalaUtils"),
    "scm:git:https://github.com/dipakc/ScalaUtils.git",
    Some("scm:git:git@github.com:dipakc/ScalaUtils.git")
  )
)

// organizationName := "My Company"

/* scala versions and options */
scalaVersion := "2.9.2"

// crossScalaVersions := Seq("2.9.1")

offline := false

scalacOptions ++= Seq("-deprecation", "-unchecked")

// scalacOptions ++= Seq("-Ydependent-method-types") // if using shapeless

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

/* entry point */
mainClass in (Compile, packageBin) := Some("com.github.dipakc.scalautils.Main")

mainClass in (Compile, run) := Some("com.github.dipakc.scalautils.Main")

///* continuations */
// autoCompilerPlugins := true

// addCompilerPlugin("org.scala-lang.plugins" % "continuations" % "2.9.2")

// scalacOptions += "-P:continuations:enable"

/* dependencies */
libraryDependencies ++= Seq (
  // -- lang --
  // "org.apache.commons" % "commons-lang3" % "3.1",
  // "org.scalaz" %% "scalaz-core" % "7.0.0-M4",
  // "org.scalaz" %% "scalaz-effect" % "7.0.0-M4",
  //
  // -- collections --
  // "org.scalaj" %% "scalaj-collection" % "1.2",
  // "com.google.guava" % "guava" % "13.0.1",
  // "com.chuusai" %% "shapeless" % "1.2.2",
  //
  // -- io --
  // "commons-io" % "commons-io" % "2.4",
  // "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.1-seq",
  // "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.1-seq",
  //
  // -- logging & configuration --
  // "org.clapper" %% "grizzled-slf4j" % "1.0.1",
  // "ch.qos.logback" % "logback-classic" % "1.0.7",
  // "com.typesafe" % "config" % "1.0.0", //(also included in akka-actor)
  //
  // -- persistence & serialization --
  // "org.json4s" %% "json4s-native" % "3.0.0",
  // "com.novus" %% "salat" % "1.9.2-SNAPSHOT",
  // "com.typesafe.akka" % "akka-actor" % "2.0.3",
  // "com.h2database" % "h2" % "1.2.127",
  // "mysql" % "mysql-connector-java" % "5.1.10",
  //
  // -- concurrency --
  // "com.typesafe.akka" % "akka-actor" % "2.0.3",
  // "org.scala-stm" %% "scala-stm" % "0.6",
  //
  // -- network --
  //  "net.databinder.dispatch" %% "dispatch-core" % "0.9.2",
  //
  // -- testing --
  // "org.scalacheck" %% "scalacheck" % "1.10.0" % "test",
  // "org.specs2" %% "specs2" % "1.12.2" % "test",
  // "org.scalatest" %% "scalatest" % "2.0.M4" % "test"
)

/* you may need these repos */
resolvers ++= Seq(
  // Resolver.sonatypeRepo("snapshots")
  // Resolver.typesafeIvyRepo("snapshots")
  // Resolver.typesafeIvyRepo("releases")
  // Resolver.typesafeRepo("releases")
  // Resolver.typesafeRepo("snapshots")
  // JavaNet2Repository,
  // JavaNet1Repository
)

/* sbt behavior */
logLevel in compile := Level.Warn

traceLevel := 5

/* publishing */
publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some(
    "snapshots" at nexus + "content/repositories/snapshots"
  )
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
                      }

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <developers>
    <developer>
      <id>dipakc</id>
      <name>Dipak Chaudhari</name>
      <!-- <email></email> -->
      <!-- <url></url> -->
    </developer>
  </developers>
)

// Josh Suereth's step-by-step guide to publishing on sonatype
// httpcom://www.scala-sbt.org/using_sonatype.html

/* assembly plugin */
mainClass in AssemblyKeys.assembly := Some("com.github.dipakc.scalautils.Main")

assemblySettings

test in AssemblyKeys.assembly := {}
