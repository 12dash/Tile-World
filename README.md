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
    
 <h3>Algorithm</h3>
 
   ![image](https://user-images.githubusercontent.com/42071654/77925465-771ac680-72d7-11ea-9790-03968edd9a4d.png)

  <h3>Results</h3>
  
   ![image](https://user-images.githubusercontent.com/42071654/78099760-84d66600-7415-11ea-9c44-0cce6de607ca.png)
    
   ![image](https://user-images.githubusercontent.com/42071654/78099778-90c22800-7415-11ea-90af-af8f8adb19d5.png)

   <h3>Note</h3>
   <p style="text-align:center">
       The utility value of each states is normalized to a maximum of 2. The normalization factor needs to be decided based on the reward. The algorithm gives a decent, acceptabe result when it is run without normalization. In fact in some cases, normalization gives worse results  like the maze set up below :
    
   ![image](https://user-images.githubusercontent.com/42071654/78100049-50af7500-7416-11ea-9a22-c2c79c124d12.png)
   
    
   ![image](https://user-images.githubusercontent.com/42071654/78100118-7a689c00-7416-11ea-96e3-f1c08fa5e45b.png)
    With normalization 
   
   
   ![image](https://user-images.githubusercontent.com/42071654/78100162-93714d00-7416-11ea-9b9b-a54c33a31b1d.png)
     Without normalization 
   </p>
  
</div>
