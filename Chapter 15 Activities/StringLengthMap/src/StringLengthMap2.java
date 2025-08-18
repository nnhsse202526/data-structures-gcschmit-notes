import java.util.*;
import java.io.*;
/**
 * Read all words from a file and add them to a
 * map whose keys are word lengths and whose values
 * are comma-separated strings of words of the same length.
 * Then print out those strings, in increasing order by
 * the length of their entries.
 * Use the Java 8 merge() method from Java 8 Note 15.1.
 */
public class StringLengthMap2
{
    public static void main(String[] args)
    {
        String filename = "src/test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            // Create your map here
            

            while (in.hasNext())
            {
                String word = clean(in.next());
                Integer len = word.length();

                /*
                 * Below is my sample solution of the first part of the activity.
                 */
                
                /*
                 * String oldValue = words.get(len);
                 * String newValue = word;
                 * String str;
                 * 
                 * if (oldValue != null) {
                 * str = newValue;
                 * } else {
                 * str = oldValue + ", " + newValue;
                 * }
                 * words.put(len, str);
                 */

                /*
                 * The same functionality can be applied by using the merge method
                 * of the Map class. The first parameter to the
                 * merge method is the key; the second, the value if there is no
                 * association already in the map; the third, a reference to a method.
                 * 
                 * The "::" operator returns a reference to the specified method.
                 * 
                 * This method must take two parameters; the first, the value currently
                 * in the map; the second, the value to merge with the value already in the map.
                 * The method must return the "merged" value to be added to the map. The method
                 * is only invoked if there is already an association in the map and, therefore,
                 * the values have to be "merged".
                 * 
                 * Here is the implementation of the merge method, which illustrates where it
                 * calls the remappingFunction (our variable len corresponds to the key
                 * parameter and our variable word corresponds to the value parameter):
                 * 
                 * V oldValue = map.get(key);
                 * V newValue;
                 * if(oldValue == null)
                 *      newValue = value;
                 * else
                 *      newValue = remappingFunction.apply(oldValue, value);
                 * 
                 * if (newValue == null)
                 *      map.remove(key);
                 * else
                 *      map.put(key, newValue);
                 * 
                 */
                 
                 
                 
                 
                 /*
                 * Instead of defining the remappingFunction method, which is only
                 * referenced when invoking the merge method, we can use a Java
                 * lambda expression to define the method "inline".
                 * 
                 * The parameters to the method are specified in the parentheses without
                 * types as the types are implicit based on the merge method. The method
                 * definition follows the "->" operator. If the definition consists of a
                 * single line, curly brackets are not needed and the return keyword is
                 * implied.
                 */
                 
                 
                 
                 
                 /*
                 * If the definition spans multiple statements, curly brackets are
                 *  required and the value must be explicitly returned.
                 */

            }

            // Print the strings, in increasing order of their length
            // Use this format: 1: i, a, i
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    /**
     * This method "merges" the newValue with the oldValue such that the "merged"
     * value can be added to the map, replacing the old value
     * 
     * @param oldValue the value currently associated in the map
     * @param newValue the value to "merge" with the value currently associated in
     *                 the map
     * @return the "merged" value to replace the value currently in the map
     */
     
     
     

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}
