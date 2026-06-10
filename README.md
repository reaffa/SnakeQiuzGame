# Snake Quiz Game

Classic game snake enriched by the addition of quizes. 
The movement is familiar, but each time you collect an apple there is a catch - a quiz dialoge pops up.
Your task is to figure out the right answer before the timer ends. When the answer is correct, a score gets incremented. If your answer is not correct, you lose 1 HP.
The game ends after you lose all your HP or you crash into the wall or your body.

## What I learned
- OOP in Java
- game logic, game loop
- developing a game from scratch without game engine
- application state management

## Possible future improvements
- Move quiz questions into a separate JSON config files instead of questions being hardcoded
- Resolve the TPS = FPS design, so that FPS is seperate from TPS
- Add multiple quiz categories and difficulty levels
- Add a system of uploading custom question sets
- Save high scores to a file

## Known limitation:
Current snake movement speed is tied to FPS, therefore FPS = TPS. A future version will solve this issue.
