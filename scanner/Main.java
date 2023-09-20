package scanner;

// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int human = 170;
//         int N = sc.nextInt();
//         if(N>=0 && N<=100){
//             human+=N;
//             System.out.println(human);
//         }else{
//             System.out.println("不正なコードです");
//         }
//         System.out.println();
//     }
// }
// import java.util.*;


// public class Main {
//     public static void main(String[] args) {
//         // 自分の得意な言語で
//         // Let's チャレンジ！！
//         Scanner sc = new Scanner(System.in);
//         int line = sc.nextInt();
//         if((line % 4 == 0 && line % 100 != 0) || (line % 400 ==0)){
//         System.out.println(line +" is a leap year");
//         }else{
//             System.out.println(line +" is not a leap year");
//         }
//     }
// }
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] fares = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                fares[i][j] = sc.nextInt();
            }
        }
        int X = sc.nextInt();
        int[] route = new int[X];
        for (int i = 0; i < X; i++) {
            int R = sc.nextInt();
            int S = sc.nextInt();
            route[i] = S - 1; 
        }
        int totalFare = 0;
        int currentStation = 0; 
        int currentLine = 0; 
        for (int i = 0; i < X; i++) {
            int nextStation = route[i];
            int fare = fares[currentLine][nextStation];
            for (int j = currentStation; j < nextStation; j++) {
                fare -= fares[currentLine][j];
            }
            totalFare += Math.max(fare, 0); 
            currentStation = nextStation;
            currentLine = currentStation; 
        }
        System.out.println(totalFare);
    }
}