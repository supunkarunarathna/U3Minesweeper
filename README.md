# Minesweeper

A implementation of the Minesweeper game in Java.

## Overview

This project is a console-based Minesweeper game where the player uncovers squares on a grid, trying to avoid mines. The goal is to reveal all squares that do not contain mines.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. Open the project in your Java IDE or text editor.

## Running the Game

1. Navigate to the `src/main` directory.

2. Compile the Java files.

    ```bash
    javac main/*.java
    ```

3. Run the `Main` class.

    ```bash
    java main.Main
    ```

## How to Play

1. The game will prompt you to enter the size of the grid. Enter a number between 2 and 10.

2. The game will then ask you to enter the number of mines to place on the grid. The maximum number of mines is 35% of the total squares on the grid.

3. The game board will be displayed, showing the rows labeled with letters (A, B, C, etc.) and columns labeled with numbers (1, 2, 3, etc.).

4. To reveal a square, enter the coordinate of the square (e.g., A1, B3). The game will reveal the square and update the board.

5. The game ends when you reveal all non-mine squares (win) or uncover a mine (lose).

## Project Structure

- `src/main`: Contains the main game code.
  - `Coordinate.java`: Represents a coordinate on the game board.
  - `GameBoard.java`: Handles the game board, mine placement, and game logic.
  - `Main.java`: The entry point of the game.
  - `Minesweeper.java`: Manages user interaction and game flow.
  - `Square.java`: Represents a square on the game board.

