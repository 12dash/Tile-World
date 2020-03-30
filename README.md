# Tile-World

The project was done for the course Intelligent agents

# Maze Environment
![image](https://user-images.githubusercontent.com/42071654/77924119-e42d5c80-72d5-11ea-9a21-3eb5340e6d23.png)

The maze environment consists of four types of tiles:

    1. Wall         Unreacheble State
    2. Green Tile   Reward +1  
    3. Brown Tile   Reward -1  
    4. White Tile   Reward -.4  
    
# Transition Model
![image](https://user-images.githubusercontent.com/42071654/77924443-3ec6b880-72d6-11ea-82fb-2c6c064d7cea.png)

The transition model of the agent is described by: 

    1.	The intended outcome for an action occurs with a probability of 0.8.
    2.  The agent moves right angle to the intended direction with a probability of 0.1.

There is no terminal state in the maze of the Tile world.
