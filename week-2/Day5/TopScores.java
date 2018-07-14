import java.util.Arrays;

public class TopScores {
    public int[] sort(int [] scores,int maxScorePossible){
        int sortingArray[] = new int [maxScorePossible+1];
        for (int score : scores) {
            sortingArray[score]++;
        }
        int k=0;
        for (int i=maxScorePossible; i>=0&&k<scores.length; i--) {
            int s = sortingArray[i];
            for (int j = s;j>=1 ;j-- ) {
                scores[k++]=i;
            }
        }
        return scores;
    }

    public static void main(String[] args) {
        int scores[] = {37, 89, 41, 65, 91, 53};
        int maxScorePossible = 100;
        TopScores obj = new TopScores();
        
        System.out.println(Arrays.toString(obj.sort(scores,maxScorePossible)));
    }
}
