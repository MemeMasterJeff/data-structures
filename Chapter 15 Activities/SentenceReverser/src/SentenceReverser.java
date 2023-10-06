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
    	Scanner scanner = new Scanner(sentence).useDelimiter(".");
    	String finalString = "";
        // Complete this method. Use a Stack.
        while(scanner.hasNext()){
            String segment = "";//reversed sentence
            Scanner working = new Scanner(scanner.next());//sentence extracted
            Stack<String> reverseStack = new Stack<>();//reversed sentence
            while(working.hasNext()){
                String word = working.next();
                if(word.contains(".")){
                    word  = word.substring(0,word.length()-1);
                    reverseStack.add(word);
                }else{
                    reverseStack.add(word);
                }
            }
            while(!reverseStack.empty()){
                segment += reverseStack.pop() + " ";
            }

        }




    return segment;
    }
}
