import java.util.*;

public class game1 {
    public static void main(String[] args) {
        String[] rps = {"Rock", "Paper", "Scissors"};
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        while (true) {
            System.out.println("Enter move (Rock, Paper, Scissors). To exit the game, type \"exit\": ");
            String user = sc.nextLine();
            
            if (user.equalsIgnoreCase("exit")) {
                break;
            }
            
            if (!user.equalsIgnoreCase("Rock") && !user.equalsIgnoreCase("Paper") && !user.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid move, please try again.");
                continue;
            }
            
            int compMoveIndex = random.nextInt(3);
            String compMove = rps[compMoveIndex];
            
            System.out.println("Computer move: " + compMove);
            
            if (user.equalsIgnoreCase(compMove)) {
                System.out.println("It's a tie!");
            } else if (user.equalsIgnoreCase("Rock") && compMove.equals("Scissors") ||
                       user.equalsIgnoreCase("Paper") && compMove.equals("Rock") ||
                       user.equalsIgnoreCase("Scissors") && compMove.equals("Paper")) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            }
        }
        
    }
}

