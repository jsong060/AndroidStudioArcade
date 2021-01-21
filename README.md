# Assignment 5

## Description

This is the final assignment for SEG2105 class of summer 2020.

This project includes 2 mini-games combined together with a simple user interface:

  * Tic Tac Toe : simple game where the player that connects 3 token of same kind in a straight line wins(Defaulted to a Best-of-3 match)
  * Sudoku : a famous (typically)9x9 math puzzle that requires numbers 1 to 9 to be present in a column, a row and a 3x3 box

## Requirements/User stories

  * User opens the application and decides to exit out of it and proceed to do other things.
  * User opens the application and gets a friend to play the tic tac toe game, then quits the application.
  * User starts off to play the tic tac toe game and then proceeds to play a round of Sudoku. Vice versa.
  * User can keep playing the game of their choice, either the tic tac toe or Sudoku game, repeatedly.
  * User can choose the level of difficulty that they wish to challenge in the game of Sudoku.
  * if user finds the Sudoku level to be too hard, they can choose to back out of it and play one that best suit their ability.
  * User may choose to exit out of the application at any time by pressing the home button on their phone.

## Build

you can download the full release APK from the following path: asg5/assignment5/app/release/app-release.apk
I did all of my test on a Pixel 3A AVD from Android Studio, there might be issues if the device you are using has a different screen size or resolution.

## Architecture

### Layered Architecture

I coded this project with a layered approach. I first drafted a simple hierarchical diagram that presented all the classes and different menus/activities that I needed to have, and then I started filling in the skeleton structure with actual code that made this project what it is at the end.

An example would be in the Sudoku game, I've separated the class that solely generates a 2D array of numbers(Sudoku) and the actual class that creates the interactive page that allows users to enter values. The actual logic of the game and what the users are dealing with are separated, creating 2 different layers of program, which decreases coupling and increases reusability. This design also allows increased testability, as one can perform separate testing on both classes to determine the cause of bugs should there be any.

This multilayered architecture is great for future improvement, one can easily add a new button to fill up a new method or to add a brand new functionality, such as adding another minigame.

## Test

I've decided to do manual testing instead of using testing frameworks. I combined the testing with the short description video. Youtube link: *https://youtu.be/FGgL3vMm8bs* 
