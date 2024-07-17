package com.example.good_common.utils

import com.example.good_common.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object ConvertUtil {

    fun convertDayOfWeek(day: String): Int {
        return when (day) {
            "MONDAY" -> R.string.str_monday
            "TUESDAY" -> R.string.str_tuesday
            "WEDNESDAY" -> R.string.str_wednesday
            "THURSDAY" -> R.string.str_thursday
            "FRIDAY" -> R.string.str_friday
            "SATURDAY" -> R.string.str_saturday
            else -> R.string.str_sunday
        }
    }

    fun convertMonth(month: String): Int {
        return when (month) {
            "JANUARY" -> 1
            "FEBRUARY" -> 2
            "MARCH" -> 3
            "APRIL" -> 4
            "MAY" -> 5
            "JUNE" -> 6
            "JULY" -> 7
            "AUGUST" -> 8
            "SEPTEMBER" -> 9
            "OCTOBER" -> 10
            "NOVEMBER" -> 11
            "DECEMBER" -> 12
            else -> 1
        }
    }

    /**
     * 2023-10-05 -> 10.5 로 포멧
     */
    fun formatDate(dateString: String?): String {
        return dateString?.run {
            if (this.isNotEmpty()) {
                val date = LocalDate.parse(dateString)
                val formatter = DateTimeFormatter.ofPattern("M.d")
                date.format(formatter)
            } else {
                ""
            }
        } ?: ""
    }
}