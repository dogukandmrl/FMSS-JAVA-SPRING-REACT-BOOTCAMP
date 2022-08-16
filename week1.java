package week1;

import static java.lang.Math.sqrt;
import java.util.Scanner;

public class week1{
    public static void main(String[] args) {
        Scanner deger = new Scanner(System.in);
        int a,b,c;
        int x1,x2;
        int diskriminant;
        System.out.println("A denk gelen katsayı giriniz");
        a = deger.nextInt();
        System.out.println("B denk gelen katsayı giriniz");
        b = deger.nextInt();
        System.out.println("C denk gelen katsayı giriniz");
        c = deger.nextInt();
        
        diskriminant = b*b-4*a*c;
        
        if(diskriminant >=0){
            x1 = (int) (-b+sqrt(diskriminant)/2*a);
            x2 = (int) (-b-sqrt(diskriminant)/2*a);
            System.out.println(x1);
             System.out.println(x2);
        }
        else if (diskriminant == 0){
            x1 = (int) -b/2*a;
            x2 = (int) -b/2*a;
            System.out.println(x1);
            System.out.println(x2); 
        }
        else{
             System.out.println("Denklemin gerçel kökü yoktur");
        }
        
        
        
    
        //getDigitSum(321);
    }
    public static void getDigitSum( int number){
      int b,c,d;
      b = number %10;
      c = (number %100-b)/10;
      d = (number %1000-c-b)/100;
      System.out.println(b+c+d);
    }   
}
