import java.util.Arrays;

public class P42747 {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int result = solution(citations);
        System.out.println(result);
    }

    /*
    문제에서 보면 'h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h가 이 과학자의 H-Index입니다.' 
    라고 되어있다. 이를 다시 해석해보면 h번 이상 인용된 논문이 h편 이상인 h의 최댓값을 구하면 된다. 
    이를 위해서 논문 인용 수가 있는 배열을 정렬하였다. 
    정렬 한 후에 앞에서부터 가면서 맨 처음 h-index가 성립한 순간을 고르면 된다. 
    끝까지 해보지 않고 첫 번째만 바로 찾으면 되는 이유는, 갈수록 인용된 눈믄의 수가 줄어들기 때문에 
    맨 처음에 성립하는 부분만 확인하면 된다!
    */
    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
 
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
 
            System.out.println("h = " + h + " citations[i] = " + citations[i]);
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
 
        return answer;
    }
}

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42747

https://bada744.tistory.com/94
https://ju-nam2.tistory.com/74
*/