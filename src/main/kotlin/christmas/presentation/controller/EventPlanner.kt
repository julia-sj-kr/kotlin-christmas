package christmas.presentation.controller

import christmas.domain.entity.EventCalendarEntity
import christmas.domain.entity.OrderEntity
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

    fun introduce() {
        outputView.introduce()
    }

    fun order() {
        val date = eventCalendar.dates[inputView.readDate() - 1]
        val readMenus = inputView.readMenus().map { (name, count) ->
            val menu = requireNotNull(MenuRole.values().find { menu -> menu.menu == name })
            MenuModel(menu.menu, menu.type, menu.price, count)
        }
        this.date = date
        this.order = OrderEntity(readMenus)
    }



}