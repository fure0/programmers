import java.util.HashSet;

public class P1845 {
  public static void main(String[] args) {
    int[] nums = {3,1,2,3};
    int result = solution(nums);
    System.out.println(result);
  } 
  
  /**
   * 해답 반환 메서드
   *
   * @param nums: [int[]] 폰켓몬 종류 배열
   *
   * @return [int] 폰켓몬 종류 갯수
   */
  public static int solution(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    
    for (int num : nums) {
        set.add(num);
    }
    /*
     * nums 에서 폰켓몬의 종류와 nums.length / 2 중 더 작은 값을 반환하면 된다.
     * [1, 2, 3, 4, 5, 1] 종류는 5개, N / 2 는 4이므로 가져갈 수 있는 최대 종류는 3개
     * [1, 1 ,1 1, 2 ,2 ,3 ,3] 종류는 3개, N / 2 는 4이므로 가져갈 수 있는 최대 종류는 3개
     */
    return Math.min(set.size(), nums.length / 2);
  }
  
}

/*
https://school.programmers.co.kr/learn/courses/30/lessons/1845
https://blog.itcode.dev/posts/2021/12/15/programmers-a0017

*/
