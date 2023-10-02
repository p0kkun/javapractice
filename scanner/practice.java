import java.util.*;
public class practice {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        Map<Character, Integer> charCount=new HashMap<>();
        for (char c='a';c<='z';c++){
            charCount.put(c,0);
        } 
        for(char c:input.toCharArray()){
            charCount.put(c,charCount.get(c)+1);
        }
        boolean first =true;
        for (char c='a';c<='z';c++){
            int count = charCount.get(c);
            if(!first){
                System.out.print(" ");
            }
            System.out.print(count);
            first=false;
        }
    }
}
