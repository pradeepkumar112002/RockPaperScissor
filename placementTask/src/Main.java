
import java.util.*;
import java.io.*;
public class Main {
    // Program to implement Rock Paper Scissors !!!
    static String extractInt(String str)
    {
        str = str.replaceAll("[^0-9]", " ");
        str = str.replaceAll(" +", "");
        if (str.equals(""))
            return "-1";
        return str;
    }
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        boolean proceed = true;
        boolean cont = true;
        String choice1 ;
        String choice2 ;
        String name1;
        String name2;
        ArrayList<String> score = new ArrayList<String>();

        int score1 = 0;
        int score2 = 0;
        BufferedReader br = new BufferedReader(new FileReader("output.txt"));
        ArrayList<String> lines = new ArrayList<String>();
        String currentLine = br.readLine();
        while (currentLine != null)
        {
            lines.add(currentLine);
            currentLine = br.readLine();
        }
        Collections.sort(lines);
        Collections.reverse(lines);
        System.out.println("The last highest score so far is "+lines.get(0));
        // Starting the game now!
        while(proceed== true){
            System.out.println("Enter your name Player 1:");
            name1 = sc.next();
            System.out.println("Enter your name player 2");
            name2 = sc.next();
            while(true){
            System.out.println("Enter your choice player one (rock/paper/scissor):");
            choice1 = sc.next();
            System.out.println("Enter your choice player two (rock/paper/scissor");
            choice2 = sc.next();
            if(choice1.equals(choice2)){
                System.out.println("You tied!");
            }else if (choice1.equals("rock")&&choice2.equals("scissor") ||choice1.equals("paper")&&choice2.equals("rock") || choice1.equals("paper")&&choice2.equals("rock") || choice1.equals("scissor")&&choice2.equals("paper") )
            {
                System.out.println("Player one won");
                score1++;
            }
            else if (choice2.equals("rock")&&choice1.equals("scissor") ||choice2.equals("paper")&&choice1.equals("rock") || choice2.equals("paper")&&choice1.equals("rock")  || choice2.equals("scissor")&&choice1.equals("paper") ){
                    System.out.println("Player two won");
                    score2++;
            }
                System.out.println("Would You Like to continue this current game ? (yes/no)");
                String cont_ = sc.next();
                if(cont_.equals("yes")){
                    cont = true;
                }
                else if (cont_.equals("no")){
                    if(score1 > score2 ){
                        score.add(Integer.toString(score1)+name1);
                    }
                    else{
                        score.add(Integer.toString(score2)+name2);
                    }
                    score1 = 0;
                    score2 = 0;
                    cont=false;

                    break;
                }
            }
            System.out.println("Would you like to start a new game  ?? (yes/no)");
            String s1 = sc.next();
            if(s1.equals("yes")){
                proceed = true;
            }
            else{
                //Results will be produced after this
                proceed = false;
            }
        }
        //displaying winner (or) the person with the highest score
        System.out.println(score);
        Collections.sort(score);
        Collections.reverse(score);
        String highScore = score.get(0);
        int a = highScore.length();
        String ch = extractInt(highScore);
        int a1 = ch.length();
        String str = highScore.substring(a1,a);
        System.out.println("The Highest score in this game is "+ch+" The winner's name is "+str);
        File file = new File("output.txt");
        FileWriter fw = new FileWriter(file,true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(ch+" and the player with the high score is "+str);
        pw.close();
    }
}


// Sorry for the variable namings.....