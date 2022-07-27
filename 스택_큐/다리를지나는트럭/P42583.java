import java.util.LinkedList;
import java.util.Queue;

public class P42583 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        int result = solution(bridge_length, weight, truck_weights);
        System.out.println(result);
    }

    
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<Integer>();
        int sum = 0; // 다리를 건너는 트럭들의 무게 합
        
        for(int t : truck_weights) {
            
            while(true) {
                //큐가 비어있다면 다음 트럭 삽입
                if(q.isEmpty()) {
                    q.offer(t);
                    sum += t;
                    answer++;
                    break;
                }
                //큐의 사이즈와 다리의 길이가 같다면 큐에서 큐에서 처음 값을 빼고 최대 무게 -
                else if(q.size() == bridge_length) {
                    sum -= q.poll();
                } else { //큐가 비어있지 않을 때
                    // 다음 트럭이 최대 무게 초과
                    // 넘는다면 0을 넣어 이미 큐에 있는 트럭이 다리를 건너게 만듬 
                    if(sum + t > weight) {
                        q.offer(0);
                        answer++;
                    } else { //다음 트럭이 최대 무게 이내
                        q.offer(t);
                        sum += t;
                        answer++;
                        break;
                    }
                }
            }
        }
        
        // 마지막 트럭에서 반복문이 끝나는데, 마지막 역시 다리 길이만큼 지나가야하기에 + 다리 길이 
        return answer + bridge_length;
    }

}

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42583

문제 조건 이상함
1초당 차가 두대가 가는 경우가 없음
*/