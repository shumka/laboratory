import java.util.*;

public class Level1 {
    public static int [] SynchronizingTables(int N, int [] ids, int [] salary){
        int[] bufferSalary = new int [N];
        int[] bufferID = new int [N];
        int[] result = new int [N];
        HashMap<Integer, Integer> associativeArray = new HashMap<>(N);
        System.arraycopy(salary, 0, bufferSalary, 0, N);
        System.arraycopy(ids, 0, bufferID, 0, N);

        for(int i = 0; i<N-1; i++) {
            for (int j = i+1; j<bufferSalary.length; j++) {
                if(bufferSalary[i] > bufferSalary[j]) {
                    int temp = bufferSalary[i];
                    bufferSalary[i] = bufferSalary[j];
                    bufferSalary[j] = temp;
                }
            }
        }

        for(int i = 0; i<N-1; i++) {
            for (int j = i+1; j<bufferID.length; j++) {
                if(bufferID[i] > bufferID[j]) {
                    int temp = bufferID[i];
                    bufferID[i] = bufferID[j];
                    bufferID[j] = temp;
                }
            }
        }

        for(int i=0; i<N; i++){
            associativeArray.put(bufferID[i], bufferSalary[i]);
        }

        for (int i = 0; i < N; i++) {
            result[i] = associativeArray.get(ids[i]);
        }

        return result;
    }
}
