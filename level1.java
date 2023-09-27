import java.util.*;
public class level1 {
    public static int squirrel(int N)
    {
        int factorial = 1;
        while (N > 1){
            factorial *= N;
            N -= 1;
        }
        while(factorial > 9){
            factorial /= 10;
        }
        return factorial;
    }
}
