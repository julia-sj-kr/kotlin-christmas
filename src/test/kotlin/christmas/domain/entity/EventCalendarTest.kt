package christmas.domain.entity

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class EventCalendarTest {

    lateinit var eventCalendarEntity: EventCalendarEntity

    @BeforeEach
    fun `setUp`() {
        eventCalendarEntity = EventCalendarEntity()
    }


    @ValueSource(ints = [25, 3, 10])
    @ParameterizedTest
    fun `캘린더의 일요일과 크리스마스 당일이 별이 없을 경우 오류가 발생 한다`(day: Int) {
        val index = day - 1
        val hasStar = eventCalendarEntity.dates[index].hasStar
        assert(hasStar)
    }

}