name := "zen-search"

description := "simple search app"

version := "1.0"

scalaVersion := "2.12.4"

sbtVersion := "1.0.3"

val specs2Version = "4.0.1"
val catsVersion = "0.9.0"

libraryDependencies ++= Seq(
  "org.typelevel"     %%    "cats"                   % catsVersion,
  "org.typelevel"     %%    "cats-free"              % catsVersion,
  "org.specs2"        %%    "specs2-core"            % specs2Version    % "test",
  "org.specs2"        %%    "specs2-scalacheck"      % specs2Version    % "test"
)

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-Ywarn-unused-import",
  "-deprecation",
  "-unchecked",
  "-feature",
  "-Xlint",
  "-language:higherKinds")

scalacOptions in Test ++= Seq("-Yrangepos")

