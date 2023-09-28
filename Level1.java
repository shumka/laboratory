public class Level1 {
    public static int odometer(int [] oksana){
        int N = oksana.length;
        int oldt = 0;
        int S = 0;
        int vi= 0;
        int ti = 0;
        int dt = 0;
        int ds = 0;
        for (int i=0; i < N; i=i+2){
            vi = oksana[i];
            ti = oksana[i+1];
            dt = ti - oldt;
            oldt = ti;
            ds = vi * dt;
            S += ds;
        }
        return S;
    }
}
