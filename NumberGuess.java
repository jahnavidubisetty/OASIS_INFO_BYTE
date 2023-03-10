import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGuess{
    public void isNumEqual(){
        Scanner sc = new Scanner(System.in);

        String  play = "yes";
        int rounds = 0, finalScore = 0, totalAttempts = 0;
        while(play.equals("yes")){
           ++rounds;
           int guess, i, a = 5, attempts = 0, score = 50;
           int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
           for(i = 0; i < a; i++){
             System.out.print("\nGuess the number:");
             guess = sc.nextInt();
             if (guess <= 0 || guess > 100){
                System.out.println("You lost an attempt.Choose a valid number(1-100)");
                attempts++;
                score -= 10;
             }
             else if(randomNum == guess){
                attempts++;
                System.out.println("-------------------------");
                System.out.println("HURRAY!!  YOU WON!");
                System.out.println("-------------------------");
                System.out.println("\nAttempts : " + attempts);
                System.out.println("Your score : " + score);
                totalAttempts += attempts;
                finalScore += score;
                System.out.println("\nWould you like to play the game again? (yes/no) : ");
                play = sc.next().toLowerCase();
                break;
             }
             else if (randomNum > guess){
                System.out.println("Generated number is greater than " + guess);
                attempts++;
                score -= 10;
             }
             else{
                System.out.println("Generated number is less than " + guess);
                attempts++;
                score -= 10;
             }
           }
        if (i == a){
            System.out.println("-------------------------");
            System.out.println("YOU LOST!");
            System.out.println("-------------------------");
            System.out.println("Generated number is "+ randomNum);
            totalAttempts += attempts;
            finalScore += score; 
            System.out.println("\nAttempts : " + attempts);
            System.out.println("Your score : " + score);
            System.out.print("\nWould you like to play the game again? (yes/no) : ");
            play = sc.next().toLowerCase();
        }
      }
      System.out.println("\nRounds : " + rounds);
      System.out.println("\nTotal Attempts : " + totalAttempts);
      System.out.println("Final score : " + finalScore);
      System.out.println("Hope you like the game.Thanks for playing!!\n");
    }
    public static void main(String[] args){
        NumberGuess ng = new NumberGuess();
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Choose a number in the range of 1 to 100.Tou to have guess the generated number within 5 attempts");
        System.out.println("-------------------------------------------------------------------------------------------------");
        ng.isNumEqual();
    }
}