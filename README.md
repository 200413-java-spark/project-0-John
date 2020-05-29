# Trade Processor 1.0.4

***An Algorithm Based Trade Processor With Moving Average Advisory.***

***This Project Is For Educational And Information Purposes Only.***

(Use At Your Own Discretion.)

## Build
### Java

>mvn clean package

### Postgres

```Bash
docker build -t mydb -f src/main/resources/Dockerfile
docker run --name mydb -d --rm -p 5432:5432 mydb
```

||

```Bash
./builddocker.sh
./rundocker.sh
./login.sh
```

## Usage

> [java -jar] [filepath/trade-advisor.jar] [arg]

Or

> [java -jar] [filepath/trade-advisor.jar] 


## Design
### Architecture
- Trade Processor Is A Command Line Application
- The Strategy Package Defines A Strategy Abstract Class, Strategy Interface. It Comes With A Placeholder Strategy To Demonstration Purposes Utilizing The Moving Average For General Market Guidance Based Off User Input.
- The Routes Package Utilizes A Function Factory To Build The Modes For The User.
- The Modes Package Gathers Input From The User And Dispatches Them To The Desired Functionality. 
It Also Has A Mode Interface To Define Each Modes' Behavior As Well As A Recursive Restart Function To Help Manage User Flow.
- The Logs Package Generates A Log For Io And Sql Faults.
- The Database Package Creates Files Based Off The Information In The Database, Provides A Connection, And Writes Input To The Database. 
- The Agents Package Defines The Agents That Can Traverse The Program That Carry The Information For File Paths, User Inputs.
It Has An Abstract User Class To Functions As A Basic Source For Which The Files, Data Generation, And Ticker Classes Can Extend. 
This Reduces Duplicate Code And Provides A Single Source Of Truth Of Which To Parse Input. The Threadworker Class Allow For Concurrent Placeholder Data Creation. 
In Future Releases' Concurrency Will Extend To The Batch Method For Rapid Data Entry.

### Main Algorithm
- The Init Class Parses Args, And If They Exist and routes the user through a mode based on their selection.

## Modes

### Manual 
- Allows The User To Manually Input Data Into A Csv File.

### Batch 

Allows The User To Insert Or Select Data From The Database. 
- Insert - The Insert Function Allows You To Upload .csv Data To The Database. 
- Select - The Select Function Generates A .csv File Based Of User Specified Ticker Stored In Database.

(You Can Also Use I Or S To Utilize Either Mode, Respectively.)

### Generate 
- Generates Placeholder Data To A Csv.

### Tgenerate 
- Generates Placeholder Data To A Csv With Multithreading.

### Advise 
- Processes The Data Based Of User Specified Strategy On User Specified Ticker Symbol From A .csv File.

### Exit 
- Exits The Terminal Prompt.

(You Can Also Use M,B,G,T,A, Or E To Utilize Each Mode, Respectively.)

### Architecture:
**Business Logic Layer:**
- Java

**Data Access Layer:**
- PostgreSQL

**Build Tools:**
- Maven
- Docker
- JUnit
