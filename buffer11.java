public class Level1 {
   public static String MassVote(int N, int[] Votes) {
        int totalVotes = 0;
        int maxVotes = 0;
        int winnerIndex = -1;
        boolean isMajority = false;

        for (int i = 0; i < N; i++) {
            totalVotes += Votes[i];
            if (Votes[i] > maxVotes) {
                maxVotes = Votes[i];
                winnerIndex = i;
                isMajority = true;
            } else if (Votes[i] == maxVotes) {
                isMajority = false;
            }
        }

        double percentage = ((double) maxVotes / totalVotes) * 100;

        if (isMajority && percentage > 50) {
            return "majority winner " + (winnerIndex + 1);
        } else if (isMajority && percentage <= 50) {
            return "minority winner " + (winnerIndex + 1);
        } else {
            return "no winner";
        }
    }
}
