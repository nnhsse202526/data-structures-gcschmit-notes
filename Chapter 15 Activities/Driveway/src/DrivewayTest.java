public class DrivewayTest {
    public static void main(String[] args) {
        Driveway testDriveway = new Driveway();
        int[] testInputs = {2, 5, 6, -5, 3, -2, 0};
        String[] expectedOutputs = {
            "Driveway: 2\nStreet: ",
            "Driveway: 2 5\nStreet: ",
            "Driveway: 2 5 6\nStreet: ",
            "Driveway: 2 6\nStreet: ",
            "Driveway: 2 6 3\nStreet: ",
            "Driveway: 6 3\nStreet: ",
            "Driveway: 6 3\nStreet: "
        };
        for (int i = 0; i < testInputs.length; i++) {
            int licensePlate = testInputs[i];
            if (licensePlate > 0) {
                testDriveway.add(licensePlate);
            } else if (licensePlate < 0) {
                testDriveway.remove(0 - licensePlate);
            } else {
                testDriveway.print();
            }
            System.out.println("Expected after input " + licensePlate + ":");
            System.out.println(expectedOutputs[i]);
            System.out.println();
        }
    }
}
