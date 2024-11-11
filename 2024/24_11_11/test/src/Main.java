import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = new int[array.length];
        int len = 0;

        for(int i=0;i<commands.length;i++){
            len = 0;
            int f = commands[i][0]-1;
            int e = commands[i][1];
            int[] tmp = {};
            for(int j=f;j<=e;j++){
                tmp.add)
                System.out.println(len);
            }
            Arrays.sort(tmp);
            int t_len = commands[i][2]-1;
            answer[i] = tmp[t_len];
        }

    }
}