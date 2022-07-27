import java.util.*;

public class P42584 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] result = solution(prices);
        System.out.println(Arrays.toString(result));
    }
    
    public static int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<len; i++){ // prices 배열의 크기동안
            
            //비교대상stack 인덱스의 price값이 현재 비교중인 인덱스의 price값보다 작다면
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){ 
                //stack에서 해당값은 빼주고
                int idx = stack.pop();
                //answer 인덱스에 얼마만에 찾았는지 넣어준다. 
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        // System.out.println(stack);
        
        while(!stack.isEmpty()){
            int leftIdx = stack.pop();
            answer[leftIdx] = len-leftIdx-1;
        }
        
        return answer;
    }

}

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42584

https://annyeongworld.tistory.com/84
*/