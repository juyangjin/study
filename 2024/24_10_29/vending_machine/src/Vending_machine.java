import java.util.Scanner;
import static java.lang.System.*;

public class Vending_machine {
    public static void main(String[] args) {
        int answer = 0;
        int sider = 1700;
        int coke = 1900;
        int sic = 2500;
        int sol = 3000;

        Scanner input = new Scanner(in);
        System.out.println("음료수를 선택하시오");
        String name = input.nextLine();
        System.out.println("지불할 값을 입력하시오");;
        int cash = input.nextInt();

        if(name.equals("사이다")){
            answer = cash - sider;
        }else if(name.equals("콜라")){
            answer = cash - coke;
        }else if(name.equals("식혜")){
            answer = cash - sic;
        } else if (name.equals("솔의눈")){
            answer = cash - sol;
        }else {
            return;
        }
        if(answer < 0) out.println("잔액이 부족합니다.");
        else out.println("거스름돈은 " + answer + "원입니다.");
    }
}