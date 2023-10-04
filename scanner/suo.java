import java.util.*;
class supercar {
    int fuel, dis;
    public supercar(int fuel, int dis) {
        this.fuel = fuel;
        this.dis = dis;
    }
    int run(int a, int f) {
        if (a > 0) {
            return f;
        } else {
            return 0;
        }
    }
}
class supersupercar extends supercar {
    public supersupercar(int fuel, int dis) {
        super(fuel, dis);
    }
    int fly(int a, int f) {
        if (a >= 5) {
            return 2 * f * f;
        } else {
            return super.run(a, f);
        }
    }
}
class supersupersupercar extends supersupercar {
    public supersupersupercar(int fuel, int dis) {
        super(fuel, dis);
    }
    int teleport(int a, int f) {
        if (a >= f * f) {
            return f * f * f * f;
        } else {
            return super.fly(a, f);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int f = sc.nextInt();
        int[] totals = new int[a]; // 各車両の合計移動距離を保持する配列
        supercar[] c = new supercar[a];
        for (int i = 0; i < a; i++) {
            String s = sc.next();
            int fuel = sc.nextInt();
            int dis = sc.nextInt();
            if (s.equals("supercar")) {
                c[i] = new supercar(fuel, dis);
            } else if (s.equals("supersupercar")) {
                c[i] = new supersupercar(fuel, dis);
            } else if (s.equals("supersupersupercar")) {
                c[i] = new supersupersupercar(fuel, dis);
            }
        }
        for (int i = 0; i < a; i++) {
            int d = sc.nextInt() - 1;
            String t = sc.next();
            if (t.equals("run")) {
                totals[d] += c[d].run(c[d].fuel, c[d].dis);
                c[d].fuel -= 1;
            } else if (t.equals("fly") && c[d] instanceof supersupercar) {
                totals[d] += ((supersupercar) c[d]).fly(c[d].fuel, c[d].dis);
                c[d].fuel -= 5;
            } else if (t.equals("teleport") && c[d] instanceof supersupersupercar) {
                totals[d] += ((supersupersupercar) c[d]).teleport(c[d].fuel, c[d].dis);
                c[d].fuel -= c[d].dis * c[d].dis;
            }
        }
        for (int total : totals) {
            System.out.println(total);
        }
    }
}