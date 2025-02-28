fun main(){
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val result = M - findGCD(N, M);
    print(if (result<0) 0 else result);
}

fun findGCD(a: Int, b: Int) : Int {
    return if (b != 0) findGCD(b, a%b) else a
}