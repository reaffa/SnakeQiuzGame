# Snake Quiz Game

Classic game snake enriched with quiz mechanics. 
The movement is familiar, but each time you collect an apple there is a catch - a quiz dialog pops up.
Your task is to figure out the right answer before the timer ends. When the answer is correct, a score gets incremented. If your answer is not correct, you lose 1 HP.
The game ends when either:
- All your HP is lost
- The snake crashes into the wall
- Snake collides with itself

## Goal of the project
I initially built this game as a project for a school event.

I didn't approach it with any particular architecture in mind. The entire project was built in just a few days, which is why some parts of the implementation and the UI may feel rushed. I initially took inspiration from tutorials I found online and then gradually diverged from them as I added my own mechanics and ideas.

I chose Java because I wanted to improve my skills in the language and experiment with object-oriented programming paradigm, as opposed to the more procedural style I have been practicing in C.

Other reasons for choosing Java over C were the time pressure (I came up with the idea only a few days before the school event) and the ability to work at a higher level of abstraction without having to deal with some of the lower-level concerns I was used to in C. This tradeoff might result in a program with greater memory usage or runtime overhead, but this game isn't supposed to run anywhere else than on a modern desktop personal computer, so I don't see this as a concerning issue.

This was my first ever take on a GUI software, excluding some websites I coded with HTML and CSS before tackling this project. It was interesting to move away from the traditional sequential design and learn to write an event-driven program, structured around one constant event loop, user input, timers and application state.

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
- Game properly works only on 1920x1080 screens
- Quiz questions are currently available only in Czech
- Current snake movement speed is tied to the update loop (TPS = FPS), causing gameplay speed to vary with performance
- The game cannot be exited during gameplay
  - This was an intentional simplification in the original version, which was developed for a school event.

## Screenshot
![In-game question pop-up](/GitHub.png)
