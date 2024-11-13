import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //입력부
        System.out.println("좋아하는 음식을 입력해주세요");
        String name = sc.nextLine();

        System.out.println("이 음식의 별점을 입력하세요");
        float score = Float.parseFloat(sc.nextLine()); //nextFloat로 했을 경우 다음 float형을 인식하고, 그 뒤 nextline의 경우 다음 줄을 인식해야하는데
        // float로 인식된 값도 nextline에 해당되어 line 1이 비어버리는 오류가 발생, 그리하여 float도 nextline으로 받고 형변환을 하여 저장하는 것으로 오류를 해결
        System.out.println("이 음식의 레시피를 입력하세요");

        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        String line3 = sc.nextLine();
        String line4 = sc.nextLine();
        String line5 = sc.nextLine();
        String line6 = sc.nextLine();
        String line7 = sc.nextLine();
        String line8 = sc.nextLine();
        String line9 = sc.nextLine();
        String line10 = sc.nextLine();

        //출력부

        System.out.println("[ " + name + " ]");
        System.out.println("별점 : " + (int)score + "(" + (int)score/5.0 * 100 + "%)");
        System.out.println("1." + line1);
        System.out.println("2." + line2);
        System.out.println("3." + line3);
        System.out.println("4." + line4);
        System.out.println("5." + line5);
        System.out.println("6." + line6);
        System.out.println("7." + line7);
        System.out.println("8." + line8);
        System.out.println("9." + line9);
        System.out.println("10." + line10);

    }
}