import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Lv3 {
    public static ArrayList alphabet(char a, ArrayList b, ArrayList c) {
        for (int i = 0; i < b.size(); i++) {
            if(b.get(i).equals(a)){
                c.set(i, a);
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] list = {
                "airplane",
                "arm",
                "apple",
                "bakery",
                "banana",
                "bank",
                "bean",
                "belt",
                "bicycle",
                "biography",
                "blackboard",
                "boat",
                "bowl",
                "broccoli",
                "bus",
                "car",
                "carrot",
                "chair",
                "cherry",
                "cinema",
                "class",
                "classroom",
                "cloud",
                "coat",
                "cucumber",
                "desk",
                "dictionary",
                "dress",
                "ear",
                "eye",
                "fog",
                "foot",
                "fork",
                "fruits",
                "hail",
                "hand",
                "head",
                "helicopter",
                "hospital",
                "ice",
                "jacket",
                "kettle",
                "knife",
                "leg",
                "lettuce",
                "library",
                "magazine",
                "mango",
                "melon",
                "motorcycle",
                "mouth",
                "newspaper",
                "nose",
                "notebook",
                "novel",
                "onion",
                "orange",
                "peach",
                "pharmacy",
                "pineapple",
                "plate",
                "pot",
                "potato",
                "rain",
                "shirt",
                "shoe",
                "shop",
                "sink",
                "skateboard",
                "ski",
                "skirt",
                "sky",
                "snow",
                "sock",
                "spinach",
                "spoon",
                "stationary",
                "stomach",
                "strawberry",
                "student",
                "sun",
                "supermarket",
                "sweater",
                "teacher",
                "thunderstorm",
                "tomato",
                "trousers",
                "truck",
                "vegetables",
                "vehicles",
                "watermelon",
                "wind"
        };
        ArrayList<Character> c = new ArrayList<>();
        int on = 1; //첫 시도 체크
        int len = 9; //기회
        ArrayList<Character> answer = new ArrayList<>();
        while (0 < len) { //기회만큼 반복
            System.out.println("현재 남은 기회 : " + len);
            System.out.println("A-Z 중에 하나를 입력하시오");
            if (on == 1) { //첫 시도에만 c 배열 저장
                on--;
                int num = (int) Math.round(Math.random() * list.length - 1);//리스트의 랜덤 인덱스 추출
                for (int j = 0; j < list[num].length(); j++) { //랜덤 인덱스 값을 각각 알파벳으로 배열 저장
                    c.add(list[num].charAt(j));
                    answer.add('_');
                }
                System.out.println(answer);
            } else {//두번째 이후 시도부터
                System.out.println(answer);
                int tp = 0;
                for(int in = 0;in<c.size();in++){
                    if(!answer.get(in).equals('_')){
                        tp++;
                        if(tp == c.size()) System.out.println("축하합니다. 정답입니다.");
                    }else break;
                }
            }
            char ch = sc.nextLine().charAt(0);

            for (int k = 0; k < c.size(); k++) {
                if (Objects.equals(c.get(k), ch)) {
                    alphabet(ch, c, answer);
                    System.out.println(answer);
                    break;
                } else {
                    if (k == c.size() - 1) {
                        System.out.println("일치 문자가 없습니다. 횟수가 차감됩니다.");
                        len--;
                        if (len == 0) {
                            System.out.println("남은 횟수가 존재하지 않습니다. 게임이 종료됩니다.");
                        }else{
                            break;
                        }
                    }
                }
            }
        }
    }
}
