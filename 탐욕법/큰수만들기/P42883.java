
public class P42883 {
  public static void main(String[] args) {
    String number = "1231234";
    int k = 3;
    String result = solution(number, k);
    System.out.println(result); // 3234
  }

  public static String solution(String number, int k) {
    StringBuilder sb = new StringBuilder();
    int index = 0;
    int next = 0;
    
    // 7 - 3 = 4 자리수를 가져가야 한다. 즉 4번 루프가 필요하다.
    for (int i = 0; i < number.length() - k; i++) {
        int max = 0;
        
        /*
          1231234 -> 남은자릿수 4, 1231234 중 가장 큰 수는 3
          xxx1234 -> 남은자릿수 3, xxx1234 중 가장 큰 수는 2
          xxxxx34 -> 남은자릿수 2, xxxxx34 중 가장 큰 수는 3
          xxxxxx4 -> 남은자릿수 1, xxxxxx4 중 가장 큰 수는 4
        */
        for (int j = index; j <= i + k; j++) {
          int current = number.charAt(j) - '0';

          if (max < current) {
              max = current;
              next = j;
          }
        }
        sb.append(max);
        index = next + 1;
    }
    return sb.toString();
  }
}

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42883

https://easybrother0103.tistory.com/125

1. 0 ~ k 인덱스 사이에서 가장 큰 값을 구한다.
2. 가장 큰 값을 버퍼에 삽입한다.
3. 버퍼 + 1 인덱스를 i라고 할 때, i ~ i + k 사이의 인덱스중 가장 큰 값을 버퍼에 삽입한다.
4. 1 ~ 3을 반복한다.
*/