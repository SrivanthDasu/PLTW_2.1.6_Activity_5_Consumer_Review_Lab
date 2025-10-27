public class ReviewRunner {
    public static void main(String[] args) {
        double appleScore = analyzeReviews("appleReviews.txt");
        double androidScore = analyzeReviews("androidReviews.txt");
        
        if (appleScore > androidScore && (appleScore - androidScore) >= 3) {
            System.out.println("iPhone is significantly better than Android");
        } 
        else if (appleScore > androidScore) {
            System.out.println("iPhone is better than Android");
        } 
        else if (androidScore > appleScore && (androidScore - appleScore) >= 3) {
            System.out.println("Android is significantly better than iPhone");
        }
        else if (androidScore > appleScore) {
            System.out.println("Android is better than iPhone");
        } 
        else {
            if (appleScore == androidScore) {
                System.out.println("iPhone and Android are equally rated");
            }
        }
    }
    
    public static double analyzeReviews(String filename) {
        String text = Review.textToString(filename);
        String[] words = text.split(" ");
        double total = 0;
        int count = 0;
        
        for (String word : words) {
            word = Review.removePunctuation(word).toLowerCase();
            total += Review.sentimentVal(word);
            count++;
        }
        
        return count > 0 ? total / count : 0;
    }
}