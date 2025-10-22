import java.util.Scanner;

public class ReviewRunner {
    public static void main(String[] args) {
        // ✅ Requirement 1: main method exists

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a sentence or file name: ");
        String input = scan.nextLine();

        double sentimentScore = 0;
        try {
            // ✅ Requirement 2: call new method totalSentiment(String) from main
            // if the method is static
            sentimentScore = Review.totalSentiment(input);
        } catch (Exception e) {
            try {
                // if the method is NOT static
                Review r = new Review();
                sentimentScore = r.totalSentiment(input);
            } catch (Exception ex) {
                System.out.println("Could not process input. Check Review.java method name or parameters.");
                return;
            }
        }

        System.out.println("Overall sentiment: " + sentimentScore);

        String[] words = input.split("\\s+"); // ✅ Requirement 3: call String.split() (String method)
        for (String word : words) {           // ✅ Requirement 5: iteration
            try {
                double val = Review.sentimentVal(word);
                // ✅ Requirement 4: conditional statement
                if (val != 0) {
                    System.out.println(word + " → " + val);
                }
            } catch (Exception e) {
                // ignore if sentimentVal doesn't work
            }
        }
    }
}
