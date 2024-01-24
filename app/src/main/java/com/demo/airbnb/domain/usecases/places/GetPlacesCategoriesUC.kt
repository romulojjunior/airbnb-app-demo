package com.demo.airbnb.domain.usecases.places

import com.demo.airbnb.data.samples.PlacesSamples
import com.demo.airbnb.domain.entities.PlaceCategory
import javax.inject.Inject

class GetPlacesCategoriesUC @Inject constructor() {
    suspend fun execute(): List<PlaceCategory> {
        Thread.sleep(1000L)
        return listOf(
            PlaceCategory(
                id = 1,
                priority = 0,
                name = "Home",
                places = PlacesSamples.subList(0, 4)
            ),
            PlaceCategory(id = 2, priority = 1, name = "Apartment",
                places = PlacesSamples.subList(4, 5)
            ),
            PlaceCategory(id = 3, priority = 2, name = "Bed",
                places = PlacesSamples.subList(5, 6)
            ),
            PlaceCategory(id = 4, priority = 3, name = "Other",
                places = PlacesSamples.subList(6, 7)
            ),
        )
    }
}
