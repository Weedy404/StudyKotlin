import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.TreeMap


fun calcMinute (date : String, time : String) : Long {
    val month = date.substring(5,7).toInt()
    val day = date.substring(8,10).toInt()
    val hour = time.substring(0,2).toInt()
    val minute = time.substring(3,5).toInt()

    return ((calcDay(month, day) * 24 + hour) * 60 + minute) 
}

fun calcDay (month : Int, day : Int) : Long {
    if (month == 1) return day.toLong()

    return when(month) {
        2, 4, 6, 8, 9, 11 -> calcDay(month-1, day+31)
        5, 7, 10, 12 -> calcDay(month-1, day+30)
        3 -> calcDay(month-1, day+28)
        else -> day.toLong()
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val note = mutableMapOf<String,Long>()
    val (N_string, L_string, F_string) = br.readLine().split(" ")
    val result = TreeMap<String, Long>()

    val (day_string, time_string) = L_string.split("/")
    val (hour, minute) = time_string.split(":").map{it.toInt()}

    val N = N_string.toInt()
    val L = (day_string.toInt() * 24 + hour) * 60 + minute
    val F = F_string.toInt()

    repeat(N.toInt()){
        val (date, time, P_M) = br.readLine().split(" ", limit=3)
        val calcedMin = calcMinute(date, time)
        if(note.containsKey(P_M)){
            val timeDiff = calcedMin - (note[P_M] ?: calcedMin) - L
            if(timeDiff > 0){
                val name = P_M.split(" ")[1]
                result[name] = result.getOrDefault(name, 0) + (timeDiff*F)
            }
            note.remove(P_M)
        }else{
            note[P_M] = calcedMin
        }
    }
    if(result.isEmpty()){
        print("-1")
    }else{
        result.forEach{(key, value) -> println("$key $value")}
    }
}