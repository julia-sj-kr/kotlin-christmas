package christmas

import christmas.presentation.controller.EventPlanner

fun main() {
    try {
        EventPlanner().play()
    }catch (e:IllegalArgumentException){

    }

}
