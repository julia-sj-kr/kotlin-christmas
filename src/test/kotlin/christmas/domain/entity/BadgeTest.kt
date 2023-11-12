package christmas.domain.entity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BadgeTest {
    lateinit var badge: BadgeEntity

    @BeforeEach
    fun `setUp`() {
        badge = BadgeEntity(6000)
    }

    @Test
    fun `뱃지가 별이 아니라면 오류가 발생 한다`() {
        assertEquals(badge.getType(), "별")
    }
}