import java.util.*;

public class P42885 {
  
  public static void main(String[] args) {
    
    int[] people = {70, 50, 80, 50};
    int limit = 100;

    int result = solution(people, limit);
    System.out.println(result);
  }

  public static int solution(int[] people, int limit) {
    
    int answer = 0;
    Arrays.sort(people);
    int index = 0;
    
    for (int i = people.length - 1; i >= index; i--) {
      if (people[i] + people[index] <= limit) {
        index++; // index 사용 했으니 다음 사람을 가르켜야 한다.
        answer++;
      } else {
        answer++;
      }
    }
    return answer;
  }
}


/*
https://school.programmers.co.kr/learn/courses/30/lessons/42885
https://easybrother0103.tistory.com/126

최대 2명씩 밖에 탈 수 없다

사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 
모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
*/