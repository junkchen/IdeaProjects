import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Basic Types
 *
 * Numbers
 * Double  Float  Long  Int  Short  Byte
 * 64      32     64    32   16     8
 *
 * Characters
 * Char
 *
 * Booleans
 * Boolean  true false
 *
 * Arrays
 * Array
 *
 * Strings
 * String
 */
fun main(args: Array<String>) {
    // unit(s)
    val time = 4800
    val hours = time / 3600
    val minutes = time % 3600 / 60
    println("hours: $hours, minutes: $minutes")

    println(String.format("%.1f", 0112.3456))

    println(dateConvertMinutes("02:30", "HH:mm"))
}

/**
 * 将当日的时间转换成分钟数
 *
 * @param date    当日时间
 * @param pattern 时间格式
 * @return 分钟数
 */
private fun dateConvertMinutes(date: String, pattern: String): Int {
    val srcSdf = SimpleDateFormat(pattern)
    try {
        val d = srcSdf.parse(date)
        val c = Calendar.getInstance()
        c.time = d
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)
        return hour * 60 + minute
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return 0
}