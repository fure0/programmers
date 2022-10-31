import java.util.HashMap;

public class P42576 {
  public static void main(String[] args) {
    String[] participant = {"leo", "kiki", "eden"};
    String[] completion = {"eden", "kiki"};
    String result  = solution(participant, completion);
    System.out.println(result);
  }

  /**
   * 해답 반환 메서드
   *
   * @param participant: [String[]] 참여한 선수
   * @param completion: [String[]] 완주한 선수
   *
   * @return [String] 완주하지 못한 선수 이름
   */
  public static String solution(String[] participant, String[] completion) {
    String answer = "";
      
    HashMap<String, Integer> map = new HashMap<>();
      
    for (String name : participant) {
      map.put(name, map.getOrDefault(name, 0) + 1);
    }
      
    for (String name : completion) {
      map.put(name, map.get(name) - 1);
    }
      
    for (String key : map.keySet()){
      // 값이 하나 이상 있을 경우
      if (map.get(key) > 0) {
        answer = key;
        break;
      }
    }
      
    return answer;
  }
}

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42576
https://blog.itcode.dev/posts/2021/12/14/programmers-a0010

 */