package com.demo.airbnb.ui.features.explore

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.airbnb.R
import com.demo.airbnb.domain.entities.PlaceCategory
import com.demo.airbnb.ui.components.PlaceCard
import com.demo.airbnb.ui.components.UIHeader
import com.demo.airbnb.ui.components.UITabItem
import com.demo.airbnb.ui.theme.AirbnbTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExploreScreen(
    placeCategories: List<PlaceCategory> = emptyList()
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxSize()
    ) {
        val pagerState = rememberPagerState(pageCount = { placeCategories.size })
        val scope = rememberCoroutineScope()

        LazyColumn {
            stickyHeader {
                Surface {
                    OutlinedTextField(
                        shape = MaterialTheme.shapes.large,
                        value = "Search",
                        onValueChange = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp, top = 16.dp, start = 8.dp, end = 8.dp)
                    )
                }
            }

            item {
                TabRow(
                    selectedTabIndex = pagerState.currentPage,
                    modifier = Modifier.padding(top = 16.dp),
                    contentColor = MaterialTheme.colorScheme.secondary,
                ) {
                    placeCategories.forEach {
                        val index = it.priority
                        val icon = when (it.id) {
                            1 -> Icons.Filled.Home
                            2 -> Icons.Filled.Call
                            3 -> Icons.Filled.Face
                            else -> Icons.Filled.Info
                        }

                        UITabItem(
                            label = it.name,
                            imageVector = icon,
                            contentDescription = "",
                            selected = pagerState.currentPage == index,
                            onClick = {
                                scope.launch {
                                    pagerState.scrollToPage(index, 0f)
                                }
                            }
                        )
                    }
                }

                HorizontalPager(state = pagerState) { index ->
                    val titleId = when (index) {
                        0 -> R.string.explorescreen_title
                        1 -> R.string.nav_messages
                        else -> R.string.explorescreen_title
                    }

                    Column {
                        UIHeader(stringResource(titleId))
                        placeCategories[index].places.forEach { place  ->
                            PlaceCard(place = place)
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    device = "id:pixel_6a",
)
fun ExploreScreenLightPreview() {
    AirbnbTheme {
        ExploreScreen()
    }
}

@Composable
@Preview(
    device = "id:pixel_6a",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun ExploreScreenNightPreview() {
    AirbnbTheme {
        ExploreScreen()
    }
}