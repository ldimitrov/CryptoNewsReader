package ldimitrov.com.cryptonewsreader.api.model

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.text.SimpleDateFormat
import java.util.*

class DateToLongDeserializer : JsonDeserializer<Long>() {
    override fun deserialize(parser: JsonParser, context: DeserializationContext?): Long {
        var format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        var date = parser.text ?: return Date().time
        return format.parse(date).time
    }

}