1，暴力破解法

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
        }
        return new int[]{-1, -1};
    }
}
```
2，使用HashMap解决
```
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.get(target - nums[i]) != null) {
                return new int[]{m.get(target - nums[i]), i};
            }
            m.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
```
3，我本来以为前两种方式就够了，后来想了下使用排序可不可以，结果发现排序还能击败52.38%的用户，出乎我的意料，当然这种写法效率很差，看看就行。
 [微信截图_20200610224130.png](https://pic.leetcode-cn.com/a8c267f2b29ba4eb48b0b21fe94eeae1ce969d959cfe34f2d758379e4dbb872f-%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20200610224130.png)

```
    public int[] twoSum(int[] nums, int target) {
        Object[] objects = new Object[nums.length];
        for (int i = 0; i < nums.length; i++) {
            objects[i] = new int[]{nums[i], i};
        }
        Arrays.sort(objects, new Comparator<Object>() {

            @Override
            public int compare(Object o, Object t1) {
                int[] arr1 = (int[]) o;
                int[] arr2 = (int[]) t1;
                return arr1[0] - arr2[0];
            }
        });
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int[] leftValue = (int[]) objects[left];
            int[] rightValue = (int[]) objects[right];
            int value = leftValue[0] + rightValue[0];
            if (value == target)
                return new int[]{leftValue[1], rightValue[1]};
            else if (value < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[2];
    }
```


 [a1b7c667f08bace157ec8fd3e8cb53a.jpg](https://pic.leetcode-cn.com/4f192957457e73b49ba048c3b247285ff8d98634b74867fd4394d533c9a87fed-a1b7c667f08bace157ec8fd3e8cb53a.jpg)

如果想查看更多答案，可关注我微信公众号“**[数据结构和算法](https://img-blog.csdnimg.cn/20190515124616751.jpg)**”，也可以扫描上方二维码关注