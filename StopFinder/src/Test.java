import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Map map = new Map("stops.txt");
        System.out.println("\tACTV stops finder");
        Scanner in = new Scanner(System.in);
        System.out.print("Input latitude: ");
        double latitude = in.nextDouble();
        System.out.print("Input longitude: ");
        double longitude = in.nextDouble();
        System.out.println("\nYou are near:\n" + map.search(latitude, longitude).toString());
    }
}
