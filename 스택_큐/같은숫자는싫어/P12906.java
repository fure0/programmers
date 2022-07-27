import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class P12906 {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        //int[] arr = {4,4,4,3,3};
        int[] result = solution(arr);

        System.out.print(Arrays.toString(result));
    }

    public static int[] solution(int []arr) {

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length-1; i++) {
            if (!stack.isEmpty() && stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }
        int[] answer = new int[stack.size()];
        int i = stack.size() -1;
        while (!stack.isEmpty()) {
            answer[i] = stack.pop();
            i--;
        }
        
        return answer;
    }
}

/*
https://school.programmers.co.kr/learn/courses/30/lessons/12906
*/