import java.util.*;
class Braver{
    int hp,frame,attack,frame2,attack2,frame3,attack3;
    Braver(){
         hp=0;
         frame=0;
         attack=0;
         frame2=0;
         attack2=0;
         frame3=0;
         attack3=0;
    }
    void setHp(int num){
        this.hp=num;
    }
    void damage(int num){
        this.hp -=num;
    }
    void setFrame(int num){
            this.frame=num;
    }
    void setAttack(int num){
        this.attack=num;
    }
    void upAttack(int num){
        if(this.attack>0){
        this.attack+=num;
        }
    }
    void setFrame2(int num){
            this.frame2=num;
    }
    void setAttack2(int num){
        this.attack2=num;
    }
    void upAttack2(int num){
        if(this.attack2>0){
        this.attack2 +=num;
        }
    }
    void setFrame3(int num){
            this.frame3 =num;
    }
    void setAttack3(int num){
        this.attack3 = num;
    }
    void upAttack3(int num){
        if(this.attack3>0){
            this.attack3 +=num;
        }
    }
    void skillUp(){
            if(this.frame<4){
                this.frame =1;
            }else{
                this.frame -=3;
            }
            if(this.frame2<4){
                this.frame2 =1;
            }else{
                this.frame2 -=3;
            }
            if(this.frame3<4){
                this.frame3 =1;
            }else{
                this.frame3 -=3;
            }
            upAttack(5);
            upAttack2(5);
            upAttack3(5);
    }
}
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        List<Braver> braver=new ArrayList<>();
        
        for (int i=0;i<m ;i++ ){
            braver.add(new Braver());
            braver.get(i).setHp(sc.nextInt());
            braver.get(i).setFrame(sc.nextInt());
            braver.get(i).setAttack(sc.nextInt());
            braver.get(i).setFrame2(sc.nextInt());
            braver.get(i).setAttack2(sc.nextInt());
            braver.get(i).setFrame3(sc.nextInt());
            braver.get(i).setAttack3(sc.nextInt());
        } 
        for (int i=0;i<n ;i++ ){
            
            int p = sc.nextInt()-1;
            int a = sc.nextInt();
            int p2 = sc.nextInt()-1;
            int a2 = sc.nextInt();
            
            int fr = 0;
            int at = 0;
            int fr2 = 0;
            int at2 = 0;
            
            if(braver.get(p).hp>0&&braver.get(p2).hp>0){
                if(a==1){
                    fr=braver.get(p).frame;
                    at=braver.get(p).attack;
                    
                }else if(a==2){
                    fr=braver.get(p).frame2;
                    at=braver.get(p).attack2;
                    
                }else if(a==2){
                    fr=braver.get(p).frame3;
                    at=braver.get(p).attack3;
                }
                
                if(a2==1){
                    fr2=braver.get(p2).frame;
                    at2=braver.get(p2).attack;
                    
                }else if(a2==2){
                    fr2=braver.get(p2).frame2;
                    at2=braver.get(p2).attack2;
                    
                }else if(a2==2){
                    fr2=braver.get(p2).frame3;
                    at2=braver.get(p2).attack3;
                }
            }else if(fr != 0 && fr2 != 0){
                    
                    if(fr<fr2){
                        braver.get(p2).damage(at);
                        
                    }else if(fr>fr2){
                        braver.get(p).damage(at2);
                    }
                    
                }else if(fr==0||fr2==0){
                    
                    if(fr==0){
                        braver.get(p).skillUp();
                        braver.get(p).damage(at2);
                        
                    }else if(fr2==0){
                        braver.get(p2).skillUp();
                        braver.get(p2).damage(at);
                    }
               
                }
            
        } 
        int alive=0;
        for (int i=0;i<m ;i++ ){
            if(braver.get(i).hp>=0){
                alive++;
            }
            
        } 
        System.out.println(alive);
    }
}