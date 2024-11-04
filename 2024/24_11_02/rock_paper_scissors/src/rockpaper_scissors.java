import java.util.Scanner;

public class rockpaper_scissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] q = {"가위", "바위", "보"};
        System.out.printf("가위 바위 보 중 하나를 입력해주세요!");
        String your = sc.nextLine();
        int num = (int) Math.round(Math.random() * q.length - 1);

        for (int i = 0; i < 5; i++) {
            if (your != "가위" && your != "바위" && your != "보") {
                System.out.println("잘못된 입력입니다!");
            } else {
                if(q[num].equals(your)) System.out.println("당신의 " + your + " 그리고 상대의 " + q[num] + " 으로 서로 비겼습니다.");

            }
        }


        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
}