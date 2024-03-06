if (Test-Path -Path ".\target") {
    "running ..."
    clear
} else {
    mvn clean package
    clear
}

try
{
    java -jar .\target\Team1-project-1.0-SNAPSHOT.jar
}
catch {
    winget install -e --id Oracle.JDK.17
    java -jar .\target\Team1-project-1.0-SNAPSHOT.jar
}