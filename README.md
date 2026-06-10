# Snake Quiz Game

Classic game snake enriched with quiz mechanics. 
The movement is familiar, but each time you collect an apple there is a catch - a quiz dialog pops up.
Your task is to figure out the right answer before the timer ends. When the answer is correct, a score gets incremented. If your answer is not correct, you lose 1 HP.
The game ends when either:
- All your HP is lost
- The snake crashes into the wall
- Snake collides with itself

## How to run
1. Clone/download this repository.
2. Open the project in IntelliJ IDEA. (Currently not configured for VSCode.)
3. Make sure the `/res/` folder is marked as Resources Root
4. Run the main class: `Main.java`.

## What I learned
- Object-Oriented Programming (OOP) in Java
- Game logic and game loop design
- Development of a game from scratch without a game engine
- Application state management

## Possible future improvements
- Make the game run as a separate executable file
- Move quiz questions into a separate JSON configuration files instead of hardcoding them
- Decouple TPS from FPS so game speed becomes independent of rendering performance
- Add multiple quiz categories and difficulty levels
- Add a system of uploading custom question sets
- Support for other languages
- Bigger font or adjustable font size
- Save high scores to a file

## Known limitations:
- Quiz questions are currently available only in Czech
- Current snake movement speed is tied to the update loop (TPS = FPS), causing gameplay speed to vary with performance
- The game cannot be exited during gameplay
  - This was an intentional simplification in the original version, which was developed for a school event.

## Screenshot
![In-game question pop-up](/GitHub.png)
