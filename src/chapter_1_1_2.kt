fun main(args: Array<String>) {

    println("getFib(1) = " + getFib(1))
    println("getFib(2) = " + getFib(2))
    println("getFib(3) = " + getFib(3))
    println("getFib(10) = " + getFib(10))
}

fun getFib(n: Int): Int = when (n) {
    1 -> 1
    2 -> 2
    else -> {
        var pre = 1
        var cur = 2
        for (i in 3..n) {
            val sum = pre + cur
            pre = cur
            cur = sum
        }
        cur
    }
}