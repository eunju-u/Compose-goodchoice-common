package com.example.good_common.widget

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.example.good_common.R
import com.example.good_common.theme.Theme
import com.example.good_common.theme.dp10
import com.example.good_common.theme.dp15
import com.example.good_common.theme.dp20
import com.example.good_common.utils.ConvertUtil
import java.time.LocalDate

//국내 숙소 캘린더, 인원수 선택 Widget
@Composable
fun KoreaDateWidget(
    context: Context,
    innerPadding: PaddingValues = PaddingValues(horizontal = dp15, vertical = dp15),
    startDate: String?,
    endDate: String?,
    koreaPersonCount: Int? = 0,
    onLeftItemClick: () -> Unit = { },
    onRightItemClick: () -> Unit = { },
) {

    val startDateFormat = ConvertUtil.formatDate(startDate)
    val endDateFormat = ConvertUtil.formatDate(endDate)
    val startDayOfWeek =
        ConvertUtil.convertDayOfWeek(LocalDate.parse(startDate).dayOfWeek.name)
    val endDayOfWeek =
        ConvertUtil.convertDayOfWeek(LocalDate.parse(endDate).dayOfWeek.name)
    val date =
        "$startDateFormat ${stringResource(id = startDayOfWeek)} " +
                "- $endDateFormat ${stringResource(id = endDayOfWeek)}"

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = dp15, start = dp20, end = dp20),
        horizontalArrangement = Arrangement.spacedBy(dp10)
    ) {
        LeftImageButtonWidget(
            modifier = Modifier.weight(0.8f),
            title = date,
            containerColor = Theme.colorScheme.pureGray,
            contentColor = Theme.colorScheme.darkGray,
            shape = dp10,
            style = MaterialTheme.typography.labelLarge,
            isCenterHorizontalArrangement = false,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            innerPadding = innerPadding,
            content = {
                Image(
                    modifier = Modifier.size(dp20),
                    painter = painterResource(id = R.drawable.ic_calendar),
                    colorFilter = ColorFilter.tint(Theme.colorScheme.gray),
                    contentDescription = null
                )
            },
            onItemClick = {
                onLeftItemClick()
            }
        )
        LeftImageButtonWidget(
            title = "${koreaPersonCount}명",
            containerColor = Theme.colorScheme.pureGray,
            contentColor = Theme.colorScheme.darkGray,
            shape = dp10,
            style = MaterialTheme.typography.labelLarge,
            isCenterHorizontalArrangement = false,
            innerPadding = innerPadding,
            content = {
                Image(
                    modifier = Modifier.size(dp20),
                    painter = painterResource(id = R.drawable.ic_nav_my_page),
                    colorFilter = ColorFilter.tint(Theme.colorScheme.gray),
                    contentDescription = null
                )
            },
            onItemClick = {
                onRightItemClick()
                //TODO 연결
//                context.startActivity(
//                    Intent(
//                        context,
//                        CalendarActivity::class.java
//                    ).apply {
//                        putExtra(Const.TYPE, CalendarType.PERSON)
//                    }
//                )
            }
        )
    }
}