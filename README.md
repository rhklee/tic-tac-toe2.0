# Tic Tac Toe 2.0

- Java version: 1.8
- Build tools used: Maven
- Unit testing suite: JUnit 5

## Building the Project
The project can be built with maven with the command: `mvn clean package`

## Run Built Project

After building the executable jar, it can be run with the command:
`java -jar target/tic-tac-toe-1.0-SNAPSHOT.jar target/classes/config`

In general given an executable jar it can be run only with a valid config file in the arguement.

### Configuration File

The config file should is a text file with two lines. The first line should have valid board dimensions, which is an integer 3 - 10. The second line should consist of three *distinct non-whitespace characters* that are comma separated without spaces.

The default file that is built alongside the project is:
```
5
x,y,z
```
