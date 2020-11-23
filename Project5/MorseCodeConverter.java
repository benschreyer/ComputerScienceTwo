/**
 *
 * Convert Morse Code Strings and Files to English
 *
 * @author  Ben Schreyer
 * @version 1.0
 * @since   2020-11-13
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeConverter
{

    static MorseCodeTree morseCodeTree = new MorseCodeTree();
    /**
     * Translate Morse code string file to english string
     * @param s String Code string / delimits words space delimits letters
     * @return English decoding of string
     */
    public static String convertToEnglish(String s) throws InvalidMorseCodeException {

        morseCodeTree.buildTree();

        String ret = "";
        String currCode = "";
        for(char c:s.toCharArray())
        {
            if(c == '/')
            {
                ret += " ";
                continue;
            }
            if(c == ' ')
            {
                try {
                    ret += morseCodeTree.fetch(currCode);
                }
                catch(Exception e)
                {
                    throw new InvalidMorseCodeException();
                }
                currCode = "";
                continue;
            }
            if(c == '.' || c == '-')
                currCode += c;
        }
        if(currCode.length() > 0)
        {
            ret += morseCodeTree.fetch(currCode);
        }
        return ret;
    }

    /**
     * Translate Morse code ascii file to english string
     * @param f File to read Morse Code from
     * @return English string of decoded file
     * @throws FileNotFoundException
     */
    public static String convertToEnglish(File f) throws FileNotFoundException, InvalidMorseCodeException {
        Scanner fileRead;

        fileRead = new Scanner(f);
        String st="";

        while(fileRead.hasNextLine())
        {
            st+=fileRead.nextLine();
        }
        st.replace("\n","/");
        return convertToEnglish(st);
    }

    /**
     * Get an Inorder representation of the tree
     * @return String of each object in tree Inorder
     */
    public static String printTree()
    {
        MorseCodeTree mt = new MorseCodeTree();
        mt.buildTree();
        return mt.toArrayList().toString().replace(",","").replace("[","").replace("]","");
    }
}
