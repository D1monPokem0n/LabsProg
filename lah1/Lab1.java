public class Lab1 {
    public static void main(String[] args) {
        short[] a = new short[20];
        for (int i = 0; i < a.length; i++) {
            a[i] = (short) (20 - i);
        }
        for (int n : a) {
            System.out.println(n);
        }
        float[] x = new float[19];
        for (int i = 0; i < x.length; i++) {
            x[i] = MyRandom();
        }
        for (float n : x) {
            System.out.println(n);
        }
        double[][] anew = new double[20][19];
        double resup;
        double log1;
        double log2;
        double tan;
        double resdown;
        double res;
        for (int i = 0; i < 20; i++) {
            for(int j = 0; j < 19; j++) {
                switch (a[i]) {
                    case 5:
                        anew[i][j] = Math.atan(Math.pow(Math.E, Math.cbrt((-1) * Math.pow(Math.sin(x[j]), 2))));
                        break;
                    case 1, 2, 3, 4, 8, 10, 11, 12, 15, 20:
                        anew[i][j] = Math.pow((4 + Math.tan(Math.asin((x[j] - 5) / 16))) / 3, 2);
                        break;
                    default:
                        log1 = Math.pow(2 * Math.log(Math.abs(x[j])), Math.pow(Math.PI + x[j], 3));
                        log2 = Math.log(Math.pow(( Math.abs(x[j]) * (Math.abs(x[j])+1)), x[j]));
                        tan = (2 + Math.tan(Math.pow((Math.E), x[j] ))) / 2;
                        resdown = Math.pow(log2, tan);
                        resup = Math.cos(log1) - 4;
                        res = Math.pow(resup/resdown, 3);
                        anew[i][j] = res;
                      // anew[i][j] = Math.pow((-4 + Math.cos(Math.pow(2 * Math.log(Math.abs(x[j])), Math.pow((Math.PI + x[j]), 3)))) / Math.pow(Math.log(Math.pow(Math.abs(x[j]) * (Math.abs(x[j] + 1)), x[j])), (2 + Math.tan(Math.pow(Math.E, x[j]))) / 2), 3);
                        break;
                }
            }
        }
        double max = 0;
        double min = 0;
        for (int i = 0; i < 20; i++) {
            for (int k = 0; k < 19; k++) {
                if (anew[i][k] > max) {
                    max = anew[i][k];
                }
                if (anew[i][k] < min) {
                    min = anew[i][k];
                }
            }
        }
        String maxS = Double.toString(max);
        String minS = Double.toString(min);
        String Max;
        if (maxS.length() > minS.length()) {
            Max = maxS;
        } else {
            Max = minS;
        }
        String check = "%"+Max.length()+".5f";
        /* for (int i = 0; i < 20; i++) {
            for (int k = 0; k < 19; k++) {
                System.out.printf(String.format(check, anew[i][k]) + " ");
            }
            System.out.println("\n");
        } */
        Say(check, anew);
    }
    public static void Say(String a, double[][] array) {
        for (int i = 0; i < 20; i++) {
            for (int k = 0; k < 19; k++) {
                System.out.printf(String.format(a, array[i][k]) + " ");
            }
            System.out.println();
        }
    }
    public static float MyRandom() {
        float a = ((float) Math.random()) * 8 - 5.0f;
        return a;
    }
}
