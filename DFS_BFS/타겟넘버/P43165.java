
public class P42885 {

  static int answer = 0;

  public static void main(String[] args) {
    int[] numbers = {1, 1, 1, 1, 1};
    int target = 3;
    solution(numbers, target);
    System.out.println(answer);
  }

  static int solution(int[] numbers, int target) {
    dfs(numbers, 0, target, 0);

    return answer;
  }

  // 깊이 우선 탐색
  static void dfs(int[] numbers, int depth, int target, int sum){
      if(depth == numbers.length){ // 마지막 노드 까지 탐색한 경우
          if(target == sum) answer++;
      } else {
          dfs(numbers, depth + 1, target, sum + numbers[depth]); // 해당 노드의 값을 더하고 다음 깊이 탐색
          dfs(numbers, depth + 1, target, sum - numbers[depth]); // 해당 노드의 값을 빼고 다음 깊이 탐색
      }
  }
}

/*
https://school.programmers.co.kr/learn/courses/30/lessons/43165 
https://hyojun.tistory.com/entry/Programmers-%ED%83%80%EA%B2%9F-%EB%84%98%EB%B2%84-Java

*/