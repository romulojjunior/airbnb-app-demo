package com.demo.airbnb.domain.usecases.places

import com.demo.airbnb.AppConfig
import com.demo.airbnb.domain.entities.Place
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
                places = listOf(
                    Place(
                        id = 1,
                        description = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more",
                        address = "San Petter, Hannoia, AK",
                        price = 150.00,
                        coverUrl = "${AppConfig.hostUrl}/assets/001/001.webp",
                        imagesUrl = listOf(
                            "${AppConfig.hostUrl}/assets/001/001.webp",
                            "${AppConfig.hostUrl}/assets/001/002.webp",
                            "${AppConfig.hostUrl}/assets/001/003.webp",
                            "${AppConfig.hostUrl}/assets/001/004.webp",
                        )
                    ),
                    Place(
                        id = 2,
                        description = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more",
                        address = "Anaky Chua, Hannoia, AK",
                        price = 160.00,
                        coverUrl = "${AppConfig.hostUrl}/assets/002/001.webp",
                        imagesUrl = listOf(
                            "${AppConfig.hostUrl}/assets/002/001.webp",
                            "${AppConfig.hostUrl}/assets/002/002.webp",
                            "${AppConfig.hostUrl}/assets/002/003.webp",
                            "${AppConfig.hostUrl}/assets/002/004.webp",
                        )
                    ),
                    Place(
                        id = 3,
                        description = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more",
                        address = "Grovy Annesh, Hannoia, AK",
                        price = 170.00,
                        coverUrl = "${AppConfig.hostUrl}/assets/003/001.webp",
                        imagesUrl = listOf(
                            "${AppConfig.hostUrl}/assets/003/001.webp",
                            "${AppConfig.hostUrl}/assets/003/002.webp",
                            "${AppConfig.hostUrl}/assets/003/003.webp",
                            "${AppConfig.hostUrl}/assets/003/004.webp",
                        )
                    ),
                    Place(
                        id = 4,
                        description = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more",
                        address = "Ashe Muya, Hannoia, AK",
                        price = 180.00,
                        coverUrl = "${AppConfig.hostUrl}/assets/004/001.webp",
                        imagesUrl = listOf(
                            "${AppConfig.hostUrl}/assets/004/001.webp",
                            "${AppConfig.hostUrl}/assets/004/002.webp",
                            "${AppConfig.hostUrl}/assets/004/003.webp",
                            "${AppConfig.hostUrl}/assets/004/004.webp",
                        )
                    )
                )
            ),
            PlaceCategory(id = 2, priority = 1, name = "Call"),
            PlaceCategory(id = 3, priority = 2, name = "Face"),
            PlaceCategory(id = 4, priority = 3, name = "Info"),
        )
    }
}