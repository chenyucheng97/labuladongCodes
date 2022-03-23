package nowcoder.com.top101.binary_search

/**
 * @author cyc
 * @Description  数组中的逆序对
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P mod 1000000007
 *
 * @createTime 2022年03月20日 16:20:00
 */


fun main(args: Array<String>) {
    val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 0)
    sort(array)
    print("res= $res")
}


fun sort(array: IntArray) {
    if (array.isEmpty() || array.size == 1) {
        res = 0
    }
    val temp = IntArray(array.size)
    sort_merge(array, temp, 0, array.size - 1)

}

fun sort_merge(array: IntArray, temp: IntArray, left: Int, right: Int) {

    val middle = left + (right - left).shr(1)
    if (left < right) {
        sort_merge(array, temp, left, middle)
        sort_merge(array, temp, middle + 1, right)
        merge(array, temp, left, middle, right)
    }

}

var res = 0

fun merge(array: IntArray, temp: IntArray, left: Int, middle: Int, right: Int) {


    var i = left
    var j = middle + 1
    var t = 0


    while (i <= middle && j <= right) {
        if (array[i] > array[j]) {
            temp[t++] = array[j++]
            res += (middle + 1 - i)
            res = res.rem(1000000007)
        } else {
            temp[t++] = array[i++]
        }
    }
    while (i <= middle) {
        temp[t++] = array[i++]
    }
    while (j <= right) {
        temp[t++] = array[j++]
    }
    t = 0
    i = left
    while (i <= right) {
        array[i++] = temp[t++]
    }

}





