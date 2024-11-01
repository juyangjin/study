
public class randomName {
    public static void main(String[] args) {

        String[] name1 = {"기철초충", "멋있는", "재미있는"};
        String[] name2 = {"도전적인", "노란색의", "바보같은"};
        String[] name3 = {"돌고래", "개발자", "오랑우탄"};

        int num1 = (int)Math.round(Math.random() * name1.length-1);
        int num2 = (int)Math.round(Math.random() * name2.length-1);
        int num3 = (int)Math.round(Math.random() * name3.length-1);

        System.out.println(name1[num1] + name2[num2] + name3[num3]);

    }
}