# SnakeGame


![image](https://github.com/kd1120/SnakeGame/assets/121998675/59aca24b-4e6e-44de-a846-274d96c81326)

1. Game Components:
   - Snake: The snake is represented by a series of connected segments or nodes. Each segment is a rectangular block on the game board.
   - Food: The food appears at random positions on the game board and is consumed by the snake. When the snake eats the food, it grows longer.
   - Game Board: The game board is a rectangular grid where the snake moves and interacts with the food. It displays the snake, food, and other game elements.
   - Score: The score keeps track of the player's progress, usually incremented each time the snake eats food.

2. Object-Oriented Design:
   - SnakeGame class: This class acts as the main driver of the game. It creates an instance of the game board and initializes the snake and food.
   - GameBoard class: This class extends JFrame and represents the graphical window for the game. It contains the game loop and handles user input.
   - Snake class: This class represents the snake and is responsible for its movement, growth, and collision detection.
   - Food class: This class represents the food and is responsible for generating random positions on the game board.

3. Game Loop:
   The game operates on a continuous loop that updates the state of the game and redraws the game board.
   - The loop starts by checking for user input, such as arrow key presses, to control the snake's movement direction.
   - The snake's position is updated according to its current direction, and collision detection is performed to check for collisions with walls, the snake's own body, or food.
   - If the snake collides with food, the snake grows by adding a new segment, and the score is incremented.
   - The game board is then repainted to reflect the updated positions of the snake, food, and other game elements.
   - The loop continues until the game ends, which happens when the snake collides with a wall or its own body.

4. Graphical User Interface (GUI):
   - The game board is represented by a JFrame window that contains a JPanel.
   - The JPanel is responsible for drawing the game elements (snake, food, etc.) on the screen using graphics methods provided by Java Swing.
   - The graphics are updated within the game loop, and the JPanel's paintComponent method is called to repaint the screen with the updated positions.

5. User Input Handling:
   - The GameBoard class listens for keyboard input using Java Swing event listeners.
   - When an arrow key is pressed, the snake's direction is updated accordingly, allowing the player to control the snake's movement.

6. Collision Detection:
   - Collision detection is performed to check if the snake collides with walls, its own body, or the food.
   - For wall collision, the snake's position is compared with the boundaries of the game board.
   - For self-collision, the snake's head position is compared with the positions of its body segments.
   - For food collision, the snake's head position is compared with the position of the food.

7. Game Over:
   - The game ends when the snake collides with a wall or its own body.
   - When the game ends, a game-over message is displayed, along with the final score.
   - The player can then choose to restart the game.


