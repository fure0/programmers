public class P43162 {

  static boolean[] check;
  
  public static void main(String[] args) {

    int n = 3;
    int[][] computers = {
      {1, 1, 0}, 
      {1, 1, 0}, 
      {0, 0, 1}
    };

    int result = solution(n, computers);
    System.out.println(result);
  }

  static int solution(int n, int[][] computers) {
    int answer = 0;
    check = new boolean[n]; // n 갯수만큼 boolean 배열을 만들고 모든 요소를 false로 초기화

    for (int i = 0; i < n; i++) {
      if (!check[i]) {
        dfs(computers, i);
        answer++;
      }
    }

    return answer;
  }

  static void dfs(int[][] computers, int i) {
    check[i] = true;

    for (int j = 0; j < computers.length; j++) {
      if (i != j && computers[i][j] == 1 && check[j] == false) {
        dfs(computers, j);
      }
    }
  }
}

/*
https://school.programmers.co.kr/learn/courses/30/lessons/43162
https://velog.io/@ajufresh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-Java

*/