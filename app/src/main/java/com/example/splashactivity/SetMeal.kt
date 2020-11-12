package com.example.splashactivity

class SetMeal {

    fun restaurantOne(): List<MainCourse> {
        val mealList: MutableList<MainCourse> = mutableListOf()

        val meal1 = MainCourse("https://cdn.pixabay.com/photo/2017/09/02/13/39/snack-2707322_960_720.jpg",
            "Lanche Natural", "Sanduíche feito com peito de Peru, alface e tomate")
        val meal2 = MainCourse("https://cdn.pixabay.com/photo/2017/07/04/19/28/tapioca-2472281__340.jpg",
            "Tapioca", "Tapioca feita de Carne Seca")
        val meal3 = MainCourse("https://cdn.pixabay.com/photo/2017/05/11/19/44/fruit-2305192__340.jpg",
            "Salada de Frutas", "Salada de frutas com frutas tropicais variadas")
        val meal4 = MainCourse("https://cdn.pixabay.com/photo/2015/03/24/00/28/cuisine-686905__340.jpg",
            "Salada com Camarão", "salada de folhas mistas com camarão")
        val meal5 = MainCourse("https://cdn.pixabay.com/photo/2018/06/19/17/16/antipasto-3484840__340.jpg",
            "Tábua de Frios", "Mix de embutidos resfriados")
        val meal6 = MainCourse("https://cdn.pixabay.com/photo/2014/09/12/12/39/pies-442633__340.jpg",
            "Empada", "Empadas de vários sabores")
        val meal7 = MainCourse("https://cdn.pixabay.com/photo/2018/08/30/10/13/plum-cake-3641810__340.jpg",
            "Torta de Maçã", "Torta doce de maçã")

        mealList.addAll(listOf(meal1, meal2, meal3, meal4, meal5, meal6, meal7))

        return mealList
    }

    fun restaurantTwo(): List<MainCourse> {
        val mealList: MutableList<MainCourse> = mutableListOf()

        val meal1 = MainCourse("https://cdn.pixabay.com/photo/2020/01/08/13/13/spaghetti-4750055__340.jpg",
            "Espaguetti", "Espaguetti a bolonhesa")
        val meal2 = MainCourse("https://cdn.pixabay.com/photo/2017/02/15/15/17/meal-2069021__340.jpg",
            "Lasanha","Lasanha de carne")
        val meal3 = MainCourse("https://cdn.pixabay.com/photo/2017/09/22/18/28/pasta-2776645__340.jpg",
            "Macarrão Penne", "Macarrão ao molho branco")
        val meal4 = MainCourse("https://cdn.pixabay.com/photo/2019/09/06/19/29/rice-4457143__340.jpg",
            "Risoto de Cogumelos", "Risoto de cogumelos")
        val meal5 = MainCourse("https://cdn.pixabay.com/photo/2018/09/29/17/52/risotto-frutti-di-mare-3711871__340.jpg",
            "Risoto de Camarão", "Risoto de Camarão")
        val meal6 = MainCourse("https://cdn.pixabay.com/photo/2019/05/24/23/10/food-4227504__340.jpg",
            "Nhoque", "Nhoque com salada")

        mealList.addAll(listOf(meal1, meal2, meal3, meal4, meal5, meal6))

        return mealList
    }
}