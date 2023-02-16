import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

//Peter McLane 3/18/21
//this program is a slot machine that randomly selects different words from a list and
//based on what words are selected you could potentially win three times the amount of money you bet
public class slotMachine {

	/**
	 * @param args
	 */
	public enum values{cherries,Oranges,Plums,Bells,Melons,Bars}
	public static void main(String[] args) {
		//the score is stored here
        int score = 0;
        //the amount of money is stored in this variable
        int money = 0;
        System.out.println("Welcome to the slot machine ");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("How much money do you have to play the game?");
        money = keyboard.nextInt();
        keyboard.nextLine();
       
        String userOption = "Yes";
        //here we will loop until the user does not want to play and if the money amount is zero 
        while(userOption.equalsIgnoreCase("Yes") && money > 0){
           
            System.out.println("How much money do you want to bet?");
            score = keyboard.nextInt();
            keyboard.nextLine();
            //here we can see if the user tries to bet more money than they have or not
            if(score > money){
                System.out.println("You cannot bet more than the money you have! Please retry!");
                continue;
            }
          //here is where we will randomly generate our words for the slot machine
            Random random = new Random();
            String word1 = null;
            String word2 = null;
            String word3 = null;
            String word = null;
     
            for(int i = 0;i < 3;i++){
                int num = random.nextInt(6) + 1;

                switch(num){
                case 1:
                    word = "Cherries";
                    break;
                case 2:
                    word = "Oranges";
                    break;
                case 3:
                    word = "Plums";
                    break;
                case 4:
                    word = "Bells";
                    break;
                case 5:
                    word = "Melons";
                    break;
                case 6:
                    word = "Bars";
                    break;
                }
                if(i == 0)
                    word1 = word;
                else if(i == 1)
                    word2 = word;
                else
                    word3 = word;
            }
            //here is where the words that were spun are displayed multiplied by their winning value
            System.out.println("Words Selected:"+ word1 +" "+ word2 +" "+ word3 );
            if(word1 == word2 && word2 == word3){
                score = score * 3;
                money = money + score;
                System.out.println("You have won $"+score);

            }
            else if(word1 == word2 || word2 == word3 || word3 == word1){
                score = score*2;
                money = money + score;
                System.out.println("You have won $"+ score);
            }
            else{
                money = money-score;
                System.out.println("You lost $"+ score);
            }
            //here this statement Displays the users score at the end of each round
            System.out.println("User score at the end of this round is "+ score +" and money left to play is $"+ money);
            //here we check if there is any money left
            if(money > 0){
            System.out.print("Do you want to play again? Type Yes or No: ");
            userOption = keyboard.nextLine();
            }
            else
                userOption = "No";
        }

        System.out.println("Thanks for playing you won $"+ money);

	}

}
