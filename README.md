___
# Monopoly-Simulator
This is a simple Monopoly simulator written in Java. The simulator allows players to play a game of Monopoly against computer-controlled opponents. Players will roll dice, buy properties, pay rent, and bankrupt opponents to become the last player standing.

## Features
- Simulate a game of Monopoly with multiple players
- Implements the basic rules of Monopoly, including property ownership, rent payments, jail, chance cards, etc.
- Detailed logging of functionality

## Getting Started

### Prerequisites

- Build with JDK version 19

### Installation
1. Clone repository to your local machine: \
```git clone git@github.com:danwlt/Monopoly-Simulator.git```
2.  Navigate to the project directory: \
```cd Monopoly-Simulator/src```
3.  Compile the Java source files: \
```javac -d ../bin Main.java```
4. Switch to the bin directory: \
```cd ../bin```
5. Run the simulator: \
```java Main```

### Usage
- There is no way to interact with the simulator outside of running the application
- You can adjust the gamespeed in the GameHost.java file by changing the thread.sleep() value
- The UI is missing some elements to further understand the game process -> These elements might get added later on to check statistics about fields and players

### Further information
- This provides a foundation to implement other functionalities like AI-Players, enhanced UI or user input
-  ~70% of games are infinite, because players can't trade with each other. To improve simulation this needs to be added

### Acknowledgments
- Inspired by the classic Monopoly board game
