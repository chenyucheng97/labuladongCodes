package nowcoder.com.top101.binary_search

/**
 * @author cyc
 * @Description  二维数组中的查找
 * @createTime 2022年03月20日 13:42:00
 */

fun main(args: Array<String>) {


    val array = Array(4) { IntArray(4) }
    array[0] = intArrayOf(1, 2, 8, 9)
    array[1] = intArrayOf(2, 4, 9, 12)
    array[0] = intArrayOf(4, 7, 10, 13)
    array[0] = intArrayOf(6, 8, 11, 15)

    val target = 11

    val res = find(target, array)

    print("res = $res")
}


fun find(target: Int, array: Array<IntArray>?): Boolean {
    if (array == null || array.isEmpty()) {
        return false
    }
    var i = 0
    var j = array[0].size - 1
    while (i <= array.size - 1 && j >= 0) {
        when {
            target == array[i][j] -> return true
            target > array[i][j] -> {
                i++
            }
            else -> {
                j--
            }
        }
    }
    return false
}