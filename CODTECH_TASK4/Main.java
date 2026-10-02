import java.util.*;

class Main {
    public static void main(String[] args) {

        // Store preferences of all users
        Map<String, Map<String, Integer>> users = new HashMap<>();

        // Store Pravallika's movie ratings
        Map<String, Integer> pravallika = new HashMap<>();
        pravallika.put("Avengers", 5);
        pravallika.put("Inception", 4);
        pravallika.put("Titanic", 2);
        pravallika.put("Interstellar", 5);

        // Store another user's movie ratings
        Map<String, Integer> user2 = new HashMap<>();
        user2.put("Avengers", 5);
        user2.put("Inception", 4);
        user2.put("Titanic", 5);
        user2.put("Interstellar", 4);
        user2.put("Joker", 5);

        // Add users and their preferences
        users.put("Pravallika", pravallika);
        users.put("User2", user2);

        // Display recommendation system title
        System.out.println("===== MOVIE RECOMMENDATION SYSTEM =====");
        System.out.println();

        System.out.println("User: Pravallika");
        System.out.println();

        // Display Pravallika's ratings
        System.out.println("Your Ratings:");

        for (String movie : pravallika.keySet()) {
            System.out.println(movie + " : " + pravallika.get(movie));
        }

        System.out.println();
        System.out.println("Recommended Movies:");

        // Find movies highly rated by another user
        // that Pravallika has not rated
        for (String movie : user2.keySet()) {

            if (!pravallika.containsKey(movie) && user2.get(movie) >= 4) {

                System.out.println(movie);
                System.out.println();
                System.out.println("Reason:");
                System.out.println("Another user rated " + movie + " highly.");
                System.out.println("Rating: " + user2.get(movie));
            }
        }

        System.out.println();
        System.out.println("========================================");
    }
}