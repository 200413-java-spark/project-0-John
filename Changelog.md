# Changelog

## Version 1.0.4

### Added
- Now Supports Concurrency In Tgeneration Mode.
- Tgeneration Mode.
- Threadworker Agent
- Added Logging To Manual File Creation
- Added Some Formating To The Menus

### Changed
- Optimized Tgeneration & Generation
- Now Files Properly Close
- Advise Ma Strategy Now Breaks Appropriately.
- Now The Manual, Generate, Tgenerate, And Batch Modes Closes Streams Properly

### Removed
- Createfile Function And Moved Logic Into Create Input.
## Version 1.0.3

### Changed
- Parses Inputs For Batch To Select Without Upper Or Lowercase Matches.

## Version 1.0.2

### Added
- Added Logging For Error Messages.

### Changed
- Allows For No Arg Boot Up

## Version 1.0.1

### Added

- Init Class - Init Object.
- Modeinterface - Blueprint For All Modes.
- Strategyinterface - Blueprint For All Strategies.
- Batchmode Class - Allows For User To Update And Download Data To Csv.
- Generatemode Class - Generates User Determined Number Of Inputs Of Specified Ticker.
- Manualmode Class - Manual Inputs Ticker Inputs.
- Advisemode Class - Advises Based Of Specified Strategy.
- Demo Class - Agent For Generate Mode.
- Filestructure Class - Agent For File Creation.
- Ticker Class - Agent For Ticker Info.
- User Class - Abstract For Filestructure And Ticker Agents.
- Mode Factory - Reduces Code Mode Object Creation.
- Strategy Factory - Reduces Code Factory Object Creation.
- Added User Guidance Prompts - Program Now Prompts User With Valid Inputs.
- Added Moving Average Strategy - Based Off Of User Inputs For Tickers It Prompts Market Conditions.
- Created Junit Test.

### Changed

- Refactored Cli Flags Into Modes For Batch, Generate, Manual, And Prediction.
- Refactored Strategies To Use Collections Api.
- Data File Now Just Stores Csv Files.
- Moved Properties Files To Configurations Folder.
- Created A Loop For Inputs Until User Exits The Program.

### Removed

- Data Class - Broke Up In Multiple Classes
- Parseinput Class - Used Factory Instead 
- Fileinfo Class - Replaced By Filestructure Agent
- Storage File - Removed Now Data Is A Dedicated Storage Space.
- All Test Strategies - Removed Placeholder Data.
- Removed Future.txt
- Properties Files And Configuration Folder. Moved To Raw Strings For Prepare Statements. For Jar Config.

## Version 1.0.0

### Added

### Changed

- Batch Insert Now Works Properly
- Batch Select Now Generates A File With The Output
- All User Methods Now Conform To The Database Inputs.

## Version 0.2.4

### Added

- Batch Mode Read And Writes Without Crashing.
- Separated Queries From Db Properties.
- Added Logic Gate For Database Object. 

### Changed

- Broke Getsql() In To Multiple Parts
- Inputs In Pom File.

## Version 0.2.3

### Added

- Program Now Connects To Postgres Database
- Batch Input Option
- Loop Added For Process To Take More Actions.

### Changed

- Inputs In Pom File.

## Version 0.2.2

### Added

- Future.txt File For A Pipeline.
- Implemented Test For The Data Obj.

### Changed

- Try Catch Blocks For Io Functions 
- Parseinput Now Implements A Batch Function.
- Cleaned Up Data Switch In Main Func.

## Version 0.2.1

### Changed
- Fixed File Writer Bugs With Adding A Space Before Operation. 
- New Input Now Checks If The User Already Created A File. If The File Does Exist It Just Adds To The File.

## Version 0.2.0

### Changed
- Created Factory For More Than One Strategy.
- Reduced Number Of Inputs Needed In Order To Generate And Predict.
- Added File Creation Functionality To Generate Command.

### Removed
- Scripts Folder And Run Scripts
- Removed Exec Dependency From Pom File.

## Version 0.1.2

### Added
- Created Class Fileinfo To Abstract Away The File Creation From Main Method.
- Created Class Parseinput To Abstract Away The Parsing From Main Method.
- Created An Interface For Strategies 
- Created Abstract Parent Class For Strategies.

### Changed
- Modified Main Method To Reflect Changes Made In Fileinfo, Parseinput, And Simplified Control Flow.
- Refactored Data Class 
- Refactored Getprediction Method. Will Be Refactored Further.

## Version 0.1.1

### Changed

- Changed To Jdk 8

## Version 0.1.0

### Added

- Placeholder Data Generation: Input Generate Followed By Ticker, And It Generates 200 Data Points.
- Control Flow For File Generation.

### Changed

- Getprediction(): Refactored Code To Be Less Loopy.

## Version 0.0.2

### Added

- Added Getprediction: It Gives You A Buy Or Sell Signal Based Off The Data In The Csv File. According To The Market Conditions You Fed It.

### Changed

- Run.sh Consolidated Scripts To Single File
- Pom.xml Changed To Reflect Version Changes.

### Removed

- Build.sh
- Clean.sh

## Version 0.0.1

### Added

- Add A Feature For File Name Creation Based On Ticker Input.
- Created Scripts: Build, Clean, Run (Sh) To Speed Up Development
- Setup Initial Maven Environment

### Changed

- Moved Build, Clean, Run (Sh) To Scripts Directory

### Removed

- Simple Json Dependency From Pom File.
