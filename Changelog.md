# Changelog
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

- implemented feature for file name creation based on ticker input.
- created scripts: build, clean, run (sh) to speed up development
- Setup inital Maven environment

### Changed

- moved build, clean, run (sh) to scripts directory

### Removed

- simple json dependency from pom file.
