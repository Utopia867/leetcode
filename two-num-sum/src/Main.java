import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    /**
     * 哈希表
     * 使用hashMap，将遍历过得元素放入map,后面的元素与map中元素相加计算，达到只遍历一遍的目的
     * 时间复杂度：O(N)，其中 N 是数组中的元素数量。对于每一个元素 x，我们可以 O(1) 地寻找 target - x。
     * 空间复杂度：O(N)，其中 N 是数组中的元素数量。主要为哈希表的开销。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            //int num2 = target-nums[index];
            if (map.containsKey(target - nums[index])) {
                return new int[]{map.get(target - nums[index]), index};
            }
            map.put(nums[index], index);
        }
        return new int[]{};
    }

    /**
     * 暴力枚举法
     * 当我们使用遍历整个数组的方式寻找 target - x 时，需要注意到每一个位于 x 之前的元素都已经和 x 匹配过，因此不需要再进行匹配。而每一个元素不能被使用两次，所以我们只需要在 x 后面的元素中寻找 target - x。
     * 时间复杂度：O(N*N)，其中 N 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
     * 空间复杂度：O(1)。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumFor(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}