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
        index++;
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


*/