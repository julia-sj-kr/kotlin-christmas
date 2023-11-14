package christmas.presentation.controller

import christmas.domain.entity.BadgeEntity
import christmas.domain.entity.BenefitsEntity
import christmas.domain.entity.EventCalendarEntity
import christmas.domain.entity.OrderEntity
import christmas.enum.Error
import christmas.enum.MenuRole
import christmas.presentation.model.DateModel
import christmas.presentation.model.MenuModel
import christmas.presentation.view.InputView
import christmas.presentation.view.OutputView

class EventPlanner {
    private val eventCalendar = EventCalendarEntity()
    private val inputView = InputView()
    private val outputView = OutputView()
    private lateinit var order: OrderEntity
    private lateinit var date: DateModel
    private lateinit var benefits: BenefitsEntity
    private lateinit var badge: BadgeEntity

    fun play() {
        introduce()
        setDate()
        guide()
        takeOrder()
        showOrder()
        showBenefitsEvent()
        showStatistics()
    }

    private fun introduce() {
        outputView.introduce()
    }

    private fun setDate() {
        val date = eventCalendar.dates[inputView.readDate() - DATE_TO_INDEX_NUMBER]
        this.date = date
    }

    private fun guide() {
        outputView.showCaution()
        outputView.showMenus()
    }

    private fun takeOrder() {
        val readMenus = inputView.readMenus().map { (name, count) ->
            val menu =
                requireNotNull(MenuRole.values().find { menu -> menu.menu == name }) { println(Error.NO_MENU.message) }
            MenuModel(menu.menu, menu.type, menu.price, count)
        }
        this.order = OrderEntity(readMenus)
        this.benefits = BenefitsEntity(date, order)
        this.badge = BadgeEntity(benefits.totalDiscountPrice())
    }

    private fun showOrder() {
        outputView.showOrderMenus(order.getMenus())
        outputView.showTotalPrice(order)
    }

    private fun showBenefitsEvent() {
        outputView.showFreeMenus(benefits)
        outputView.showDiscounts(benefits)
    }

    private fun showStatistics() {
        outputView.showTotalDiscount(benefits)
        outputView.showPayment(order, benefits)
        outputView.showEventBadge(badge)
    }

    private companion object {
        const val DATE_TO_INDEX_NUMBER = 1
    }

}