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

    1.The intended outcome for an action occurs with a probability of 0.8.
    2.The agent moves right angle to the intended direction with a probability of 0.1.

There is no terminal state in the maze of the Tile world.

# Program Structure

![image](https://user-images.githubusercontent.com/42071654/77925056-fe1b6f00-72d6-11ea-9ab9-c4f142a5a89f.png)

<h1> Value Iteration</h1>

<div>
    
![image](https://user-images.githubusercontent.com/42071654/77925158-1b503d80-72d7-11ea-9042-49292dbe0939.png)

The utility of each state is updated according to the above equation

    U(s)= Utility of the states in the itch iteration
    R(s)= Reward of the state s 
    P (s’|s, a)= Probability of reaching state s’, given s and action a.
    
 <b>Algorithm</b>
 
   ![image](https://user-images.githubusercontent.com/42071654/77925465-771ac680-72d7-11ea-9790-03968edd9a4d.png)

  <b>Results</b>
  
   ![image](https://user-images.githubusercontent.com/42071654/78099760-84d66600-7415-11ea-9c44-0cce6de607ca.png)
    
   ![image](https://user-images.githubusercontent.com/42071654/78099778-90c22800-7415-11ea-90af-af8f8adb19d5.png)


  
</div>
