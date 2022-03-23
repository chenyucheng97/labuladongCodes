package nowcoder.com.top101.binary_search

/**
 * @author cyc
 * @Description 旋转数组的最小数字
 *
 * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。请问，给定这样一个旋转数组，求数组中的最小值。

数据范围：1≤n≤10000，数组中任意元素的值: 0≤val≤10000
要求：空间复杂度：O(1) ，时间复杂度：O(logn)

输入：
[3,4,5,1,2]

返回值：
1

 *
 * @createTime 2022年03月20日 21:32:00
 */


fun main(args: Array<String>) {
    val array = intArrayOf(3, 4, 5, 1, 2)
    val res = minNumberInRotateArray(array)
    println("res = $res")
}


fun minNumberInRotateArray(rotateArray: IntArray): Int {

    if (rotateArray.isEmpty()) {
        return 0
    }

    var left = 0
    var right = rotateArray.size - 1
    while (left < right) {
        if (rotateArray[left] < rotateArray[right]) {
            return rotateArray[left]
        }
        var middle = left + (right - left).shr(1)
        if (rotateArray[middle] > rotateArray[right]) {
            left = middle + 1
        } else if (rotateArray[middle] < rotateArray[right]) {
            right = middle
        } else {
            right--
        }
    }
    return rotateArray[left]

}