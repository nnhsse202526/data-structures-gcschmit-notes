public class ReverseTester {
    public static void main(String[] args) {
        test("Mary had a little lamb. Its fleece was white as snow.",
                "Lamb little a had mary. Snow as white was fleece its.");
        test("Hello world.", "World hello.");
        test("One.", "One.");
        test("", "");
        test("A b c d.", "D c b a.");
        test("This is a test.", "Test a is this.");
        test("Multiple   spaces here.", "Here spaces multiple.");
        test("ALL CAPS SENTENCE.", "Sentence caps all.");
        test("MiXeD CaSe WoRdS.", "Words case mixed.");
    }

    private static void test(String input, String expected) {
        String actual = SentenceReverser.reverse(input);
        System.out.println("Given:    [" + input + "]");
        System.out.println("Actual:   [" + actual + "]");
        System.out.println("Expected: [" + expected + "]");
        System.out.println(actual.equals(expected) ? "PASS" : "FAIL");
        System.out.println();
    }
}
