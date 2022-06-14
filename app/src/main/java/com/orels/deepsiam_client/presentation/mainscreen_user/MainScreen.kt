package com.orels.deepsiam_client.presentation.mainscreen_user

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun MainScreenUser(
    navigator: DestinationsNavigator,
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val isRefreshing by viewModel.isRefreshing.collectAsState()


    DisposableEffect(key1 = viewModel) {
        viewModel.onStart()
        onDispose { /* onStop */ }
    }

    Column {
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing),
            onRefresh = { viewModel.refresh() },
            indicator = { indicatorState, trigger ->
                SwipeRefreshIndicator(
                    state = indicatorState,
                    refreshTriggerDistance = trigger,
                    scale = true,
                    backgroundColor = MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.small,
                )
            }
        ) {
            Column {
                state.notifications.forEach {
                    Text(text = it.title)
                }
            }
        }
    }
}