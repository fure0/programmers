
public class P42862 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,2,3,5};
        int result = solution(n, lost, reserve);
        System.out.println(result);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        
        int[] people = new int[n];
        int answer = n; // answer값을 모든학생으로 초기화
    
        for (int l : lost) 
            people[l-1]--; // lost인 사람만 -1
        for (int r : reserve) 
            people[r-1]++; // reserve인 사람만 +1
    
        for (int i = 0; i < people.length; i++) { // people배열을 순회하며 -1(잃어버리기만한사람) 을 찾는다.
            if(people[i] == -1) {
                if (i-1>=0 && people[i-1] == 1) { // i-1>0은 i가 0번째면 index오류가 나기때문이다.
                    people[i]++;
                    people[i-1]--;
                } else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                } else {
                    answer--;
                }
            }
        }
        return answer;
        
    }
}

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42862
https://taehoung0102.tistory.com/11
*/