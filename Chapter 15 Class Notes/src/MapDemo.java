import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        /*
         * The Map interface is a generic. The first type is the
         *  type of the key; the second, the type of the value.
         */
        Map<String, Color> favoriteColors = new HashMap<>();

        favoriteColors.put("Jason", Color.orange);
        favoriteColors.put("Luke", Color.blue);
        favoriteColors.put("Christian", Color.green);

        // two different keys can have the same value
        favoriteColors.put("Kevin", Color.blue);

        // but the same key cannot have two different values;
        //  instead, we change the value associated with an existing key
        favoriteColors.put("Jason", Color.blue);

        // retrieve the set of keys in the map
        Set<String> keys = favoriteColors.keySet();
        for(String key : keys)
        {
            System.out.println(key + " (" + key.hashCode() + "): " +
                    favoriteColors.get(key));
        }
    }
}
