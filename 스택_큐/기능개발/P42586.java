import java.util.*;

public class P42586 {

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] result = solution(progresses, speeds);
        for (int val : result) {
            System.out.println(val);
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>(); // 개발기간
        for(int i=0; i<progresses.length; i++){
            queue.add((int) (Math.ceil((100.0 - progresses[i]) / speeds[i]))); //ceil 올림
            // (100 - 개발진도) / (개발속도)
            // 7/1 = 7
            // 70/30 = 2
            // 45/5 = 9
        }
        
        List<Integer> answer = new ArrayList<>(); // 배포당 기능개수
        while (!queue.isEmpty()){
            int day = queue.poll();
            int cnt = 1;
            
            while(!queue.isEmpty() && day >= queue.peek()){ // 앞기능보다 뒷 기능이 먼저 or 동시에 개발되는 경우
                cnt++;
                queue.poll();
            }
            answer.add(cnt);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42586
*/