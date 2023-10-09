import java.util.Scanner;
import java.util.Stack;

/**
 * Class for reversing the order of a sentence.
*/
public class SentenceReverser
{
    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reverseStack.
     * @return reverseStack sentence.
    */
    public static String reverse(String sentence)
    {
    	Scanner scanner = new Scanner(sentence).useDelimiter("\\.");
    	String finalString = "";
        // Complete this method. Use a Stack.
        while(scanner.hasNext()){
            String segment = "";//reversed sentence
            Scanner working = new Scanner(scanner.next()).useDelimiter(" ");//sentence extracted
            Stack<String> reverseStack = new Stack<>();//reversed sentence

            while(working.hasNext()){
                String word = working.next();
                System.out.println(word);
                if(word.contains(".")){
                    word  = word.substring(0,word.length()-1);
                    /*
                    System.out.println(word.substring(0,1).toUpperCase()+word.substring(1));
                    reverseStack.add(word.substring(0,1).toUpperCase()+word.substring(1));
                     */
                }else{
                    reverseStack.add(word.toLowerCase());
                }
                System.out.println(reverseStack);
            }
            while(!reverseStack.empty()){
                segment += reverseStack.pop() + " ";
            }
            segment += ". ";
            finalString+=segment;
        }




    return finalString;
    }
}
