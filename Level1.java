import java.util.*;

public class Level1 {
    public static int [] SynchronizingTables(int N, int [] ids, int [] salary){
        int[] bufferSalary = new int [salary.length];
        int[] result = new int [N];
        HashMap<Integer, Integer> associativeArray = new HashMap<>(N);
        System.arraycopy(salary, 0, bufferSalary, 0, salary.length);

        for(int i = 0; i<N-1; i++) {
            for (int j = i+1; j<bufferSalary.length; j++) {
                if(bufferSalary[i] > bufferSalary[j]) {
                    int temp = bufferSalary[i];
                    bufferSalary[i] = bufferSalary[j];
                    bufferSalary[j] = temp;
                }
            }
        }

        for(int i=0; i<N; i++){
            associativeArray.put(ids[i], bufferSalary[i]);
        }

        List<Integer> sortedKeys = new ArrayList<>(associativeArray.keySet());
        Collections.sort(sortedKeys);

        for (int i = 0; i < sortedKeys.size(); i++) {
            int key = sortedKeys.get(i);
            int value = associativeArray.get(key);
            result[i] = value;
        }

        return result;
    }
}
