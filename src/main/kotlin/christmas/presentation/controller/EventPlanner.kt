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
    lateinit var order: OrderEntity
    lateinit var date: DateModel
    lateinit var benefits: BenefitsEntity
    lateinit var badge: BadgeEntity

    fun play() {
        introduce()
        order()
        showBenefitsEvent()

    }

    private fun introduce() {
        outputView.introduce()
    }

    private fun order() {
        val date = eventCalendar.dates[inputView.readDate() - 1]
        val readMenus = inputView.readMenus().map { (name, count) ->
            val menu =
                requireNotNull(MenuRole.values().find { menu -> menu.menu == name }) { println(Error.NO_MENU.message) }
            MenuModel(menu.menu, menu.type, menu.price, count)
        }
        this.date = date
        this.order = OrderEntity(readMenus)
        this.benefits = BenefitsEntity(date, order)
        this.badge = BadgeEntity(benefits.totalDiscountPrice())
    }

    private fun showBenefitsEvent() {
        outputView.showOrderMenus(order.getMenus())
        outputView.showTotalPrice(order)
        outputView.showFreeMenus(benefits)
        outputView.showDiscounts(benefits)
        outputView.showTotalDiscount(benefits)
        outputView.showPayment(order, benefits)
        outputView.showEventBadge(badge)
    }
}