import java.util.Scanner;
public class ConnectFour {        
    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)) {
            //create the board
            

            char[][] board = new char[6][7];

            //Initialize board
            for(int row = 0; row < board.length; row++){
                for(int col = 0; col < board[row].length; col++){
                    board[row][col] = ' ';
                }
            }
            //Set the turn
            int turn = 1;
            char player = 'X';
            boolean winner = false;

            //play turn
            while(winner == false && turn <= 42){
                boolean validPlay = false;
                int play = 0;

                while (validPlay == false){
                    
                    //Display the grid
                    System.out.println("**************************************");
                    System.out.println("Turn: " + turn);
                    display(board);

                    System.out.print("Player " + player + ", choose a column: ");

                    play = in.nextInt();

                    //function to validate play
                    validPlay = validatePlay(play, board);
                }

                //Drop checker
                for(int row = board.length-1; row >= 0; row--){
                    if(board[row][play-1] == ' '){
                        board[row][play-1] = player;
                        break;
                    }
                }

                //Check for Winner
                winner = isWinner(player, board);

                // Change player and add turn
                if(player == 'X'){
                    player = 'O';
                }else{
                    player = 'X';
                }
                turn++;
            }

            display(board);

            if(winner){
                if(player == 'X'){
                    System.out.println("Blue won!");
                }
                else{
                    System.out.println("Red won!");
                }
            }else{
                System.out.println("Tie Game!!");
            }
        }
    }

    public static void display(char[][] brd){
        System.out.println();
        for(int i = 0; i < brd.length; i++){
            System.out.print("| ");
            for (int j = 0; j < brd[i].length; j++){
                System.out.print(brd[i][j] + " | ");
            }
            System.out.println();
            System.out.println("----------------------------");
        }
        System.out.println("----------------------------");
        System.out.println("| 1 | 2 | 3 | 4 | 5 | 6 | 7 |");
        System.out.println();
    }

    public static boolean validatePlay(int col, char[][] brd){
        if(col < 1 || col > brd.length+1){
            System.out.println("Invalid Move, Try Again!");
            return false;
        }
        if (brd[0][col] != ' '){
            System.out.println("Invalid Move, Try Again!");
            return false;
        }
        return true;
    }

    public static boolean isWinner(char player, char[][] brd){
        //Check 4 across
        for(int row = 0; row < brd.length; row++){
            for(int col = 0; col < brd[0].length -3; col++){
                if(brd[row][col] == player &&
                   brd[row][col+1] == player &&
                   brd[row][col+2] == player &&
                   brd[row][col+3] == player){
                    return true;
                }
            }
        }
        
        //Check vertical
        for(int row = 0; row < brd.length-3; row++){
            for(int col = 0; col < brd[0].length; col++){
                if(brd[row][col] == player &&
                   brd[row+1][col] == player &&
                   brd[row+2][col] == player &&
                   brd[row+3][col] == player){
                    return true;
                }
            }
        }
        //Check up diagonal
        for(int row = 3; row < brd.length; row++){
            for(int col = 0; col < brd[0].length-3; col++){
                if(brd[row][col] == player &&
                   brd[row-1][col+1] == player &&
                   brd[row-2][col+2] == player &&
                   brd[row-3][col+3] == player){
                    return true;
                }
            }
        }

        //Check down diagonal
        for(int row = 0; row < brd.length-3; row++){
            for(int col = 0; col < brd[0].length-3; col++){
                if(brd[row][col] == player &&
                   brd[row+1][col+1] == player &&
                   brd[row+2][col+2] == player &&
                   brd[row+3][col+3] == player){
                    return true;
                }
            }
        }
        return false;
    }
}
// PROJECT COMPLETED