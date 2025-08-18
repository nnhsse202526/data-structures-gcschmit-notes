import java.util.TreeMap;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MorseCode
{
    private static final char DOT = '.';
    private static final char DASH = '-';

    private static TreeMap<Character, String> codeMap;
    private static TreeNode decodeTree;

    public static void main(String[] args)
    {
        MorseCode.start();  
        //System.out.println(MorseCode.encode("Watson come here"));
        BTreePrinter.printNode(decodeTree);
    }

    public static void start()
    {
        codeMap = new TreeMap<Character, String>();

        // put a space in the root of the decoding tree
        decodeTree = new TreeNode(' ', null, null);

        addSymbol('A', ".-");
        addSymbol('B', "-...");
        addSymbol('C', "-.-.");
        addSymbol('D', "-..");
        addSymbol('E', ".");
        addSymbol('F', "..-.");
        addSymbol('G', "--.");
        addSymbol('H', "....");
        addSymbol('I', "..");
        addSymbol('J', ".---");
        addSymbol('K', "-.-");
        addSymbol('L', ".-..");
        addSymbol('M', "--");
        addSymbol('N', "-.");
        addSymbol('O', "---");
        addSymbol('P', ".--.");
        addSymbol('Q', "--.-");
        addSymbol('R', ".-.");
        addSymbol('S', "...");
        addSymbol('T', "-");
        addSymbol('U', "..-");
        addSymbol('V', "...-");
        addSymbol('W', ".--");
        addSymbol('X', "-..-");
        addSymbol('Y', "-.--");
        addSymbol('Z', "--..");
        addSymbol('0', "-----");
        addSymbol('1', ".----");
        addSymbol('2', "..---");
        addSymbol('3', "...--");
        addSymbol('4', "....-");
        addSymbol('5', ".....");
        addSymbol('6', "-....");
        addSymbol('7', "--...");
        addSymbol('8', "---..");
        addSymbol('9', "----.");
        addSymbol('.', ".-.-.-");
        addSymbol(',', "--..--");
        addSymbol('?', "..--..");
    }

    /**
     * Inserts a letter and its Morse code string into the encoding map
     * and calls treeInsert to insert them into the decoding tree.
     */
    private static void addSymbol(char letter, String code)
    {
        /*
            !!! INSERT CODE HERE
        */
    }

    /**
     * Inserts a letter and its Morse code string into the
     * decoding tree.  Each dot-dash string corresponds to a path
     * in the tree from the root to a node: at a "dot" go left, at a "dash" go
     * right.  The node at the end of the path holds the symbol
     * for that code string.
     */
    private static void treeInsert(char letter, String code)
    {
        /*
            !!! INSERT CODE HERE
        */
    }

    /**
     * Converts text into a Morse code message.  Adds a space after a dot-dash
     * sequence for each letter.  Other spaces in the text are transferred directly
     * into the encoded message.
     * 
     * @return returns the encoded message
     */
    public static String encode(String text)
    {
        StringBuffer morse = new StringBuffer(400);

        /*
            !!! INSERT CODE HERE
        */

        return morse.toString();
    }

    /**
     * Converts a Morse code message into a text string.  Assumes that dot-dash
     * sequences for each letter are separated by one space.  Additional spaces are
     * transferred directly into text.
     * 
     * @return returns the plain text message
     */
    public static String decode(String morse)
    {
        StringBuffer text = new StringBuffer(100);

        /*
            !!! INSERT CODE HERE
        */

        return text.toString();
    }
}

/**
 * BTreePrinter rewrite courtesy of August Junttila
 * original courtesy of Karen Ge (@karenge1)
 */
class BTreePrinter {
    public static void printNode(TreeNode root) {
        int height = getHeight(root);
        String[] lines = new String[height * 2 + 1];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = "";
        }
        printBranch(root, height, lines);
        for (int i = 0; i < lines.length; i++) {
            String temp = lines[i], temp2 = "";
            for (int i2 = 0; i2 < temp.length(); i2++) {
                char c = temp.charAt(i2);
                if (c != ' ') {
                    if (c == '─' || c == '┌' || c == '┐' || c == '┴' || c == '┘' || c == '└') {
                        temp2 += colorText(c, 120, 120, 120);
                    } else {
                        temp2 += colorText(c, 255, 255, 255);
                    }
                } else {
                    temp2 += colorText(" ", 30, 30, 30);
                }
            }
            lines[i] = temp2 += colorText("", 255, 255, 255);
        }
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);

        }
    }

    private static void printBranch(TreeNode node, int height, String[] lines) {
        String printString = "";
        for (int i = 0; i < Math.pow(2, height - 1) - 1; i++) {
            printString += " ";
        }
        if (node != null) {
            printString = printString + node.getValue();
            if (node.getValue() != null) {
                for (int i = 0; i < Math.pow(2, height - 1) + 1 - node.getValue().toString().length(); i++) {
                    printString += " ";
                }
            } else {
                for (int i = 0; i < Math.pow(2, height - 1) + 1 - 4; i++) {
                    printString += " ";
                }
            }
        } else {
            for (int i = 0; i < Math.pow(2, height - 1) + 1; i++) {
                printString += " ";
            }
        }
        if (height > 1) {
            addLines(node, height, lines);
        }
        lines[lines.length - (height * 2)] += printString;

        if (height > 1) {
            if (node != null && node.getLeft() != null) {
                printBranch(node.getLeft(), height - 1, lines);
            } else {
                printBranch(null, height - 1, lines);
            }
            if (node != null && node.getRight() != null) {
                printBranch(node.getRight(), height - 1, lines);
            } else {
                printBranch(null, height - 1, lines);
            }
        }
    }

    private static void addLines(TreeNode node, int height, String[] lines) {
        int l1 = lines[lines.length - (height * 2)].length(), l2 = lines[lines.length - (height * 2) + 1].length();
        int L = (int) Math.pow(2, height - 1) - 1, sL = (int) Math.pow(2, height - 2) - 1;
        boolean b1 = false, b2 = false;
        if (node != null) {
            b1 = node.getLeft() != null;
            b2 = node.getRight() != null;
        }
        for (int i = l2; i < l1; i++) {
            lines[lines.length - (height * 2) + 1] += " ";
        }
        for (int i = 0; i < Math.pow(2, height - 1) * 2 - 1; i++) {
            String c = i < sL ? " "
                    : i == sL ? b1 ? "┌" : " "
                            : i == L ? b2 && b1 ? "┴" : b1 ? "┘" : b2 ? "└" : " "
                                    : i < L ? b1 ? "─" : " "
                                            : i == sL + L + 1 ? b2 ? "┐" : " "
                                                    : i > sL + L + 1 ? " " : i > L ? b2 ? "─" : " " : "=";
            lines[lines.length - (height * 2) + 1] += c;
        }
    }

    private static String colorText(Object input, int r, int g, int b) {
        return "\033[38;2;" + r + ";" + g + ";" + b + "m" + input;
    }

    private static int getHeight(TreeNode node) {
        int h1, h2;
        if (node.getLeft() != null) {
            h1 = getHeight(node.getLeft());
        } else {
            h1 = 0;
        }
        if (node.getRight() != null) {
            h2 = getHeight(node.getRight());
        } else {
            h2 = 0;
        }
        return Math.max(h1, h2) + 1;
    }
}