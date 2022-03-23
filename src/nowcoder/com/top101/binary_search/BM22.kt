package nowcoder.com.top101.binary_search

/**
 * @author cyc
 * @Description 比较版本号
 * @createTime 2022年03月23日 23:41:00
 */


fun main(args: Array<String>) {
    val version1 = "3.424"
    val version2 = "3.425"
    val res = compare(version1, version2)
    println("res = $res")
}


fun compare(version1: String, version2: String): Int {

    var p1 = 0
    var p2 = 0

    val length1 = version1.length
    val length2 = version2.length



    while (p1 < length1 || p2 < length2) {

        var v1 = 0
        var v2 = 0

        while (p1 < length1 && version1[p1] != '.') {
            v1 = v1 * 10 + (version1[p1++] - '0')
        }

        while (p2 < length2 && version2[p2] != '.') {
            v2 = v2 * 10 + (version2[p2++] - '0')
        }

        if (v1 != v2) {
            return if (v1 > v2) {
                1
            } else {
                -1
            }
        } else {
            p1++
            p2++
        }
    }
    return 0
}