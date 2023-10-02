public class Level1 {
    public static int [] MadMax(int N, int [] Tele){
        int[] first = new int[N/2];
        int[] second = new int[N-(N/2)];
        int[] result = new int[N];
        int x = 0;
        int y = 0;

        for(int i = 0; i<N-1; i++) {
            for (int j = i+1; j<Tele.length; j++) {
                if(Tele[i] > Tele[j]) {
                    int temp = Tele[i];
                    Tele[i] = Tele[j];
                    Tele[j] = temp;
                }
            }
        }

        for (int i = 0; i < N; i++)
        {
            if (i < N / 2) {
                first[x]= Tele[i];
                x++;
            }
            else {
                second[y] = Tele[i];
                y++;
            }
        }

        for(int i = 0; i < second.length-1; i++) {
            for (int j = i+1; j < second.length; j++) {
                if(second[i] < second[j]) {
                    int temp = second[i];
                    second[i] = second[j];
                    second[j] = temp;
                }
            }
        }
        x = 0;
        for(int i = 0; i < N; i++){
            if (i < N / 2) {
                result[i] = first[i];
            }
            else {
                result[i] = second[x];
                x++;
            }
        }
        return result;
    }
}
