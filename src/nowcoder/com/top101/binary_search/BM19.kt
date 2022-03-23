package nowcoder.com.top101.binary_search

/**
 * @author cyc
 * @Description 寻找峰值
 *
 * 描述
给定一个长度为n的数组nums，请你找到峰值并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个所在位置即可。
1.峰值元素是指其值严格大于左右相邻值的元素。严格大于即不能有等于
2.假设 nums[-1] = nums[n] = -\infty−∞
3.对于所有有效的 i 都有 nums[i] != nums[i + 1]
4.你可以使用O(logN)的时间复杂度实现此问题吗？
 *
 * @createTime 2022年03月20日 15:39:00
 */

fun findPeekElement(nums: IntArray): Int {
    //关键思想：下坡的时候可能找到波峰，但是可能找不到，一直向下走的
    //上坡的时候一定能找到波峰，因为题目给出的是nums[-1] = nums[n] = -∞
    var left = 0
    var right = nums.size - 1
    while (left < right) {
        val mid = left + (right - left) / 2
        //证明右边的路是下坡路，不一定有坡峰
        if (nums[mid] > nums[mid + 1]) {
            right = mid
        } else {
            //这里是右边的路是上坡路
            left = mid + 1
        }
    }
    return left

}

fun main(args: Array<String>) {
    val res = findPeekElement(intArrayOf(2,4,1,2,7,8,4))
    println("res = $res")
}