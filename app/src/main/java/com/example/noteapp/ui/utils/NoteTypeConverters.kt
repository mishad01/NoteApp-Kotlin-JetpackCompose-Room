package com.example.noteapp.ui.utils
import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

object NoteTypeConverters {

    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    @TypeConverter
    @JvmStatic
    fun fromUUID(uuid: UUID): String = uuid.toString()

    @TypeConverter
    @JvmStatic
    fun toUUID(uuidString: String): UUID = UUID.fromString(uuidString)

    @TypeConverter
    @JvmStatic
    fun fromLocalDateTime(dateTime: LocalDateTime): String =
        dateTime.format(formatter)

    @TypeConverter
    @JvmStatic
    fun toLocalDateTime(dateTimeString: String): LocalDateTime =
        LocalDateTime.parse(dateTimeString, formatter)
}
