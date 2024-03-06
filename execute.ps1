if (Test-Path -Path ".\target")
{
    "running ..."
    clear
} else {
    mvn clean package
    clear
}

java -jar .\target\Team1-project-1.0-SNAPSHOT.jar