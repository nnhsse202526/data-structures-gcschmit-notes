import java.util.Map;

public class DistanceFinderTest {
    public static void main(String[] args) {
        String[] files = {"src/cities1.txt", "src/cities2.txt", "src/cities3.txt", "src/cities4.txt"};
        String[] expectedOutputs = {
            "Testing file: cities1.txt\n" +
            "Shortest distances from Pierre:\n" +
            "Pendleton: 2\n" +
            "Pensacola: 11\n" +
            "Peoria: 6\n" +
            "Phoenix: 6\n" +
            "Pierre: 0\n" +
            "Pittsburgh: 11\n" +
            "Princeton: 13\n" +
            "Pueblo: 3\n",
            "Testing file: cities2.txt\n" +
            "Shortest distances from Phoenix:\n" +
            "Pendleton: 4\n" +
            "Pensacola: 5\n" +
            "Peoria: 4\n" +
            "Phoenix: 0\n" +
            "Pierre: 6\n" +
            "Pittsburgh: 9\n" +
            "Princeton: 10\n" +
            "Pueblo: 3\n",
            "Testing file: cities3.txt\n" +
            "Shortest distances from Princeton:\n" +
            "Pendleton: 14\n" +
            "Pensacola: 5\n" +
            "Peoria: 7\n" +
            "Phoenix: 10\n" +
            "Pierre: 13\n" +
            "Pittsburgh: 2\n" +
            "Princeton: 0\n" +
            "Pueblo: 10\n",
            "Testing file: cities4.txt\n" +
            "Shortest distances from Pendleton:\n" +
            "Pendleton: 0\n" +
            "Pensacola: 9\n" +
            "Peoria: 8\n" +
            "Phoenix: 4\n" +
            "Pierre: 2\n" +
            "Pittsburgh: 13\n" +
            "Princeton: 14\n" +
            "Pueblo: 5\n"
        };
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            System.out.println("\nTesting file: " + file);
            DistanceFinder finder = new DistanceFinder(file);
            String start = finder.getStartingCity();
            Map<String, Integer> distances = finder.shortestDistances();
            System.out.println("Shortest distances from " + start + ":");
            for (Map.Entry<String, Integer> entry : distances.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("\nExpected output:");
            System.out.println(expectedOutputs[i]);
        }
    }
}
