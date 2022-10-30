public class P43163 {

  static boolean[] visited;
  static int answer = 0;

  public static void main(String[] args) {
    String begin = "hit";
    String target = "cog";
    String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
    int result = solution(begin, target, words);
    System.out.println(result);
  }
  
  public static int solution(String begin, String target, String[] words) {
    visited = new boolean[words.length];

    dfs(begin, target, words, 0);
    return answer;
  }
  
  public static void dfs(String begin, String target, String[] words, int cnt) {
    if (begin.equals(target)) {
      answer = cnt;
      return;
    }

    for (int i = 0; i < words.length; i++) {
      if (visited[i]) {
        continue;
      }

      int k = 0;    // 같은 스펠링 몇개인지 세기
      for (int j = 0; j < begin.length(); j++) {
        if (begin.charAt(j) == words[i].charAt(j)) {
          k++;
        }
      }

      if (k == begin.length() - 1) {  // 한글자 빼고 모두 같은 경우
        visited[i] = true;
        dfs(words[i], target, words, cnt + 1);
        visited[i] = false;
      }
    }
  }
}
/*
https://school.programmers.co.kr/learn/courses/30/lessons/43163
https://velog.io/@hammii/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%8B%A8%EC%96%B4-%EB%B3%80%ED%99%98-java

1.한 글자 빼고 나머지가 같은 단어를 words에서 찾는다.
2.찾은 단어를 visited = true 로 설정해 준다.
3.cnt를 증가시키며 dfs 함수를 재귀 호출한다.
4.모든 경우의 수를 보기 위해 visited = false로 재설정한다.
5.begin과 target이 같은 경우, cnt를 answer에 대입하고 종료한다.

*/