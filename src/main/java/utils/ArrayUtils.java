package utils;

public class ArrayUtils {

    public static < E > void print(E[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }

//    public static void print(int[][] t) {
//        for (int i = 0; i < t.length; i++) {
//            for (int j = 0; j < t[i].length; j++) {
//                System.out.print(t[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("-----------------------------");
//    }
}
