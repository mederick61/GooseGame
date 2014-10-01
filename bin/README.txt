
 _____                       _____                      
 / ____|                     / ____|                     
| |  __  ___   ___  ___  ___| |  __  __ _ _ __ ___   ___ 
| | |_ |/ _ \ / _ \/ __|/ _ \ | |_ |/ _` | '_ ` _ \ / _ \
| |__| | (_) | (_) \__ \  __/ |__| | (_| | | | | | |  __/
 \_____|\___/ \___/|___/\___|\_____|\__,_|_| |_| |_|\___|
                                                         
/**** Leo Jumel & Brice NUZZO ****/
/****        27/09/2014       ****/

==========- INTRODUCTION -==========

The Goose Game is a board game which can be played from 2 to 4 players.
The gameboard is composed 63 cells, from the outside to the inside. Many cells have special hazards or benefits for players who land on them. The object of the game is to travel along the board from cell 1 to cell 63, and the first player who successfully lands exactly on cell 63 is the winner.

On each turn, a player rolls the two dice and advances along the board by as many cells as the sum of the two dice. The player must deal with any situation on the space landed on, be they hazards or benefits. The special bonus and hazard cells are the following :

- Teleport Cell : The player must go to the cell which is indicated by the Teleport Cell.
- Goose Cell : The player dice throw is doubled.
- Wait Cell : Player must wait the amount of turns indicated by the Wait Cell.
- Trap Cell : Player cannot move until another player move on this cell.

==========- ARCHITECTURE -==========

---- Inheritance ---

The Cell class has 4 daughters : 
- TeleportCell
- GooseCell
- WaitCell
- TrapCell

And implements the interface 'CellInterface', which provide different methods to run the Game.

==========-  COMPILATION  -==========





==========-     MANUAL    -==========
