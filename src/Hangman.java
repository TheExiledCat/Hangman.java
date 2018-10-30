import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {


    static private void run() {
        String word="eindopdracht"; //te raden woord
        int life=5;
        Scanner start = new Scanner(System.in);
        String inp=start.next();
        if(inp.equals("run") ) {
            guess(word,life);

        }
    }
    static private void guess(String word, int life){
        char[] filler = new char[word.length()];

        int i=0;

        //maak een space voor elk character in het te raden woord
        while(i<word.length()){
            filler[i]='_';
            if (word.charAt(i)==' ') {
                filler[i]=' ';
            }

            i++;

        }

        System.out.println(filler);
        System.out.println("Life Remaining=" +life);
        Scanner s=new Scanner(System.in);//read players guess
        ArrayList<Character> l=new ArrayList<Character>();

        //Loop that checks if guessed letter is right and replaces dashes with the right letter
        while (life>0){
            char x=s.next().charAt(0);

            if(l.contains(x)){
                System.out.println("Already used that letter");
                System.out.println(filler);
                System.out.println("Life Remaining=" +life);
                continue;

            }l.add(x);

            if(word.contains(x+"")){
                for(int y=0;y<word.length();y++){
                    if(word.charAt(y)==x){
                        filler[y]=x;
                        System.out.println("YOU GUESSED RIGHT");
                    }
                }
            }else{
                life--;
                System.out.println("WRONG LETTER");
            }
            if(word.equals((String.valueOf(filler)))){
                System.out.println(filler);
                System.out.println("YOU WIN!");
                break;
            }
            System.out.println(filler);
            System.out.println("Life Remaining=" +life);
            if (life==0){
                System.out.println("YOU LOSE!");
            }
        }
    }
    public static void main (String[] args){

            System.out.println("Welcome to hangman, How to play: to start the game type in:");
        System.out.println("'run', then the game starts. you can then one letter at a time guess the word by typing.");


            run();

            }

    }



