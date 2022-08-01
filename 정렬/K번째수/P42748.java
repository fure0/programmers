import java.util.Arrays;

public class P42748 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        int[] result = solution(array, commands);
        System.out.println(Arrays.toString(result));
    }

    static public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0, size=commands.length;i<size;i++) {
            int start = commands[i][0]; // 어디서부터
            int end = commands[i][1]; // 어디까지 자를지
            int k = commands[i][2]; // k번째 수
            // Arrays.copyOfRange는 해당 배열을 start 0 부터 end 직전까지를 복사합니다.
            int[] temp = Arrays.copyOfRange(array, start-1, end);
            Arrays.sort(temp);
            answer[i] = temp[k-1];            
        }
        return answer;
    }
}

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42748
*/