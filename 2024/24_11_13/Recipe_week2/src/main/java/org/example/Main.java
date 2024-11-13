package org.example;

import java.util.*;
import static java.lang.Integer.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> List = new ArrayList<String>();
        Set<String> set = new HashSet<>();
        HashMap<Object, Object> map = new HashMap<>();
        String foodname = "";
        String txt = "";
        int len = 0;

        System.out.println("어떤 자료구조로 저장하겠습니까? list,set,map 중에 선택하여 입력하세요");
        String data = sc.nextLine();

        if(data.equals("list")){
            System.out.println("좋아하는 음식을 입력하세요.");
            foodname = sc.nextLine();
            System.out.println("음식의 레시피를 입력하세요. 입력이 종료되면 끝 이라고 작성하세요.");

            while(true){
                txt = sc.nextLine();
                if(txt.charAt(0) == '끝') break;
                List.add(txt);
            }

            System.out.println("[ " + foodname + " ]");
            for(int l=0;l<List.size();l++){
                len++;
                System.out.println(len + ". " + List.get(l));
            }

        }else if(data.equals("set")){
            System.out.println("좋아하는 음식을 입력하세요.");
            foodname = sc.nextLine();

            System.out.println("음식의 레시피를 입력하세요. 입력이 종료되면 끝 이라고 작성하세요.");

            while(true){
                txt = sc.nextLine();
                if(txt.charAt(0) == '끝') break;
                set.add(txt);
            }

            Iterator iterator = set.iterator();
            System.out.println("[ " + foodname + " ]");
            for(int s=0;s<set.size();s++){
                len++;
                System.out.println(len + ". " + iterator.next());
            }

        }else if(data.equals("map")){
            System.out.println("좋아하는 음식을 입력하세요.");
            foodname = sc.nextLine();

            System.out.println("음식의 레시피를 입력하세요. 입력이 종료되면 끝 이라고 작성하세요.");

            while(true){
                txt = sc.nextLine();
                if(txt.charAt(0) == '끝') break;
                len++;
                map.put(len,txt);
            }

            System.out.println("[ " + foodname + " ]");
            for(int m=0;m<map.size();m++){
                System.out.println(map.get(m+1));
            }

        }else{
            System.out.println("잘못 입력하셨습니다.");
        }
    }
}