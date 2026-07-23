# Connect Four
 
Two-player Connect Four, played in the console.
 
Standard 6-row by 7-column board. Players alternate dropping pieces into a
column; first to connect four in a row (horizontal, vertical, or diagonal)
wins. Detects a tie if the board fills with no winner.
 
## Run it
 
```
javac src/ConnectFour.java -d bin
java -cp bin ConnectFour
```
 
## Notes
 
Board state and win detection are done with a plain `char[][]` grid — no
external dependencies.
 
