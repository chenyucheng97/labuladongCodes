package nowcoder.com.top101.binary_search

/**
 * @author cyc
 * @Description 无重复数字的升序数组的二分查找
 * @createTime 2022年03月20日 12:52:00
 */

fun main(args: Array<String>) {

    val numbs = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 11, 15, 17, 23)
    val target = 15
    val index = binarySearch(numbs, 15)

    println("index of target $target = $index")

}


fun binarySearch(nums: IntArray?, target: Int): Int {
    if (nums == null || nums.isEmpty())
        return -1
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        var middle = (left + right) / 2
        when {
            target < nums[middle] -> right = middle - 1
            target > nums[middle] -> left = middle + 1
            else -> return middle
        }
    }
    return -1
}