import java.util.HashMap;
import java.util.Map;

public class P42577 {
  public static void main(String[] args) {
    String[] phoneBook = {"119", "97674223", "1195524421", "445119321"};

    boolean result = solution(phoneBook);
    System.out.println(result);
  }

  public static boolean solution(String[] phoneBook) {
    // 1. HashMap을 선언한다.
    Map<String, Integer> map = new HashMap<>();

    // 2. 모든 전화번호를 HashMap에 넣는다.
    for (int i = 0; i < phoneBook.length; i++) {
      map.put(phoneBook[i], i);
    }

    map.forEach((key, value) -> {
      System.out.println(key + " : " + value);
    });

    System.out.println("=========");

    // 3. 모든 전화번호의 substring이 HashMap에 존재하는지 확인한다.
    for (int i = 0; i < phoneBook.length; i++) { // length = 4
      // {"119", "97674223", "1195524421", "445119321"}
      for (int j = 0; j < phoneBook[i].length(); j++) { 
        System.out.print(phoneBook[i].substring(0, j));
        if (map.containsKey(phoneBook[i].substring(0, j))) {
          System.out.print("< -- 해당");
          return false;
        }
        System.out.println("");
      }
    }

    return true;
  }
}

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42577
https://coding-grandpa.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A0%84%ED%99%94%EB%B2%88%ED%98%B8-%EB%AA%A9%EB%A1%9D-%ED%95%B4%EC%8B%9C-Lv-2-%EC%9E%90%EB%B0%94-Java

그냥 2중 for문에 startWith로 풀면 편할듯..

*/