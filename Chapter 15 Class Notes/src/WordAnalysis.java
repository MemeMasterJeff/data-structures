import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
*/
public class WordAnalysis
{
    public static void main(String[] args)
            throws IOException
    {
        Set<String> dictionaryWords = readWords("words");
        Set<String> novelWords = readWords("throughTheLookingGlass.txt");

        for(String word:novelWords){
            if(!dictionaryWords.contains(word)){
                System.out.println(word);
            }
        }

        //print no. of words in the novel
        System.out.println("words in novel: " + novelWords.size());

        //print thee number of unique words with >3 letters
        Iterator<String> iterator = novelWords.iterator();
        while(iterator.hasNext()){
            if(iterator.next().length() <=3){
                iterator.remove();
            }
        }
        System.out.println("There are "+novelWords.size()+"unique words with more than 3 letters");
    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
    */
    public static Set<String> readWords(String filename)
            throws IOException,FileNotFoundException{
        Set<String> words  = new HashSet<>();

        Scanner in = new Scanner(new File("Chapter 15 Class Notes/src/"+filename), StandardCharsets.UTF_8);
        //use any character that is not a letter as delimiter
        in.useDelimiter("[^a-zA-Z]+");

        while(in.hasNext()){
            words.add(in.next().toLowerCase());
        }
        return words;
    }
}
