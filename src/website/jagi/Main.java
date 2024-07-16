package website.jagi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        initializeLocations();

        Map<String, String> vocabulary = getVocabulary();

        int loc = 1;

        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available ways are: ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();
            System.out.println("Which way do you want to go?");
            String order = scanner.nextLine().toUpperCase();
            String[] orderWords = order.replace(".", "").replace(",", "").split(" ");

            String direction = "";
            for (String word : orderWords) {
                if (vocabulary.containsKey(word)) {
                    direction = vocabulary.get(word);
                    break;
                }
            }
            if (!direction.isEmpty()) {
                if (exits.containsKey(direction)) {
                    loc = exits.get(direction);
                } else {
                    System.out.println("You cannot go in that direction");
                }
            } else {
                System.out.println("Direction was not identified in your statement");
            }
        }
        scanner.close();

    }

    private static void initializeLocations() {
        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of a computer", null));
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small bridge.", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill.", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExit));
    }

    private static Map<String, String> getVocabulary() {
        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("QUIT", "Q");
        vocabulary.put("E", "E");
        vocabulary.put("W", "W");
        vocabulary.put("N", "N");
        vocabulary.put("S", "S");
        vocabulary.put("Q", "Q");

        return vocabulary;
    }
}
