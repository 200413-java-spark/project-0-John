# Changelog
## Version 1.0.0

### Added

### Changed

- batch insert now works properly
- batch select now generates a file with the output

## Version 0.2.4

### Added

- batch mode read and writes without crashing.
- seperated queries from db properties.
- added logic gate for datbase object. 

### Changed

- broke getSQL() in to multiple parts
- inputs in pom file.

## Version 0.2.3

### Added

- program now connects to postgres database
- batch input option
- loop added for process to take more actions.

### Changed

- inputs in pom file.

## Version 0.2.2

### Added

- future.txt file for a pipeline.
- Implemented test for the Data obj.

### Changed

- try catch blocks for IO functions 
- ParseInput now implements a batch function.
- cleaned up data switch in main func.

## Version 0.2.1

### Changed
- fixed file writer bugs with adding a space before operation. 
- new input now checks if the user already created a file. if the file does exist it just adds to the file.

## Version 0.2.0

### Changed
- created factory for more than one strategy.
- reduced number of inputs needed in order to generate and predict.
- added file creation functionality to generate command.

### Removed
- scripts folder and run scripts
- removed exec dependency from pom file.

## Version 0.1.2

### Added
- created class FileInfo to abstract away the file creation from main method.
- created class ParseInput to abstract away the parsing from main method.
- created an interface for strategies 
- created abstract parent class for strategies.

### Changed
- modified main method to reflect changes made in FileInfo, ParseInput, and simplified control flow.
- refactored Data class 
- refactored getprediction method. Will be refactored further.

## Version 0.1.1

### Changed

- Changed to JDK 8

## Version 0.1.0

### Added

- Placeholder data generation: input generate followed by ticker, and it generates 200 data points.
- Control flow for file generation.

### Changed

getPrediction(): refactored code to be less loopy.

## Version 0.0.2

### Added

- added getPrediction: It gives you a buy or sell signal based off the data in the csv file. According to the market conditions you fed it.

### Changed

- run.sh consolidated scripts to single file
- pom.xml changed to reflect version changes.

### Removed

- build.sh
- clean.sh

## Version 0.0.1

### Added

- Add a feature for file name creation based on ticker input.
- created scripts: build, clean, run (sh) to speed up development
- Setup initial Maven environment

### Changed

- moved build, clean, run (sh) to scripts directory

### Removed

- simple json dependency from pom file.
