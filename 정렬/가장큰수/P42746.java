import java.util.*;

public class P42746 {
    public static void main(String[] args) {
        int[] numbers = {6,10,2};
        // int[] numbers = {3, 30, 34, 5, 9};
        String result = solution(numbers);
        System.out.println(result);
    }

    public static String solution(int[] numbers) {
        String[] stringNumbers = new String[numbers.length];

        //int형 배열을 String형 배열로 바꿈
        for (int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = Integer.toString(numbers[i]);
        }

        // 두 수를 번갈아가며 합친 수 중 큰 값을 앞으로 정렬(내림차순 정렬)
        // 정렬 시 비교할 문자가 o1와 o2라면 o1+o2와 o2+o1를 비교한 뒤에 더 큰 수를 반환해줘야 한다.
        // ex) o1 = 3,  o2 = 30  -> 330  vs 303을 비교하는 것처럼 말이다.
        // (o2+o1).compareTo(o1+o2) 이 식은 내림차순으로 정렬하겠다는 의미다.
        Arrays.sort(stringNumbers, new Comparator<String>() {
            @Override 
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
                //오름차순 정렬 (o1+o2).compareTo(o1+o2);
            }
        });

        //0값이 중복일경우 ex){0,0,0}
        //답이 000이 나오면 안되므로 첫번째값이 0이면 0을 리턴
        if (stringNumbers[0].equals("0")) 
            return "0";
        
        //문자열을 delimiter("") 기준으로 합침
        return String.join("", stringNumbers);

    }
}

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42746
*/
