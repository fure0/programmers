import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class P42578 {

  public static void main(String[] args) {
    String[][] clothes = {
      {"yellow_hat", "headgear"}, 
      {"blue_sunglasses", "eyewear"}, 
      {"green_turban", "headgear"}
    };

    int result = solution(clothes);
    System.out.println(result);
  }
  
  public static int solution(String[][] clothes) {

    // 1. 옷을 종류별로 구분하기
    HashMap<String, Integer> map = new HashMap<>();
    for (String[] clothe : clothes) {
      String type = clothe[1];
      map.put(type, map.getOrDefault(type, 0) + 1);
    }

    map.forEach((key, value) -> {
      System.out.println(key + " : " + value);
    });

    // 2. 입지 않는 경우를 추가하여 모든 조합 계산하기
    Iterator<Integer> it = map.values().iterator();

    int answer = 1;

    while (it.hasNext()) {
      answer *= it.next().intValue() + 1;
    }

    // 3. 아예 아무것도 입지 않는 경우 제외하기 (뭔가는 입어야 됨)
    return answer - 1;

  }
}


/*
https://school.programmers.co.kr/learn/courses/30/lessons/42578
https://coding-grandpa.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%9C%84%EC%9E%A5-%ED%95%B4%EC%8B%9C-Lv-2-%EC%9E%90%EB%B0%94-Java
*/