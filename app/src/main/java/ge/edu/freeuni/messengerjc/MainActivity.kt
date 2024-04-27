package ge.edu.freeuni.messengerjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ge.edu.freeuni.messengerjc.ui.AboutThisAppCard
import ge.edu.freeuni.messengerjc.ui.AppInfo
import ge.edu.freeuni.messengerjc.ui.AppInfoCard
import ge.edu.freeuni.messengerjc.ui.AppSupportCard
import ge.edu.freeuni.messengerjc.ui.BetaTesterCard
import ge.edu.freeuni.messengerjc.ui.DataSafetyCard
import ge.edu.freeuni.messengerjc.ui.MoreAppsByDeveloper
import ge.edu.freeuni.messengerjc.ui.PlayStoreTopBar
import ge.edu.freeuni.messengerjc.ui.RatingsAndReviewsCard
import ge.edu.freeuni.messengerjc.ui.RefundPolicy
import ge.edu.freeuni.messengerjc.ui.Review

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayStoreAppView()
        }
    }
}

@Composable
fun PlayStoreAppView() {
    val appDescription = "Free group video chat, video calls, voice calls and text messaging."
    val categoryChips = listOf("#5 top free in communication", "Messaging")
    val reviewCount = "4.2M"
    val reviewStars = 4.2f
    val downloadSize = "51 MB"
    val ageRating = "Rated for 12+"
    val downloadCount = "5B+"
    val screenshots = listOf(
        ImageBitmap.imageResource(R.drawable.screenshot1),
        ImageBitmap.imageResource(R.drawable.screenshot2),
        ImageBitmap.imageResource(R.drawable.screenshot3),
        ImageBitmap.imageResource(R.drawable.screenshot4),
        ImageBitmap.imageResource(R.drawable.screenshot5),
    )
    val sampleApps = listOf(
        AppInfo(painterResource(id = R.drawable.facebook), "Facebook", 4.5f),
        AppInfo(painterResource(id = R.drawable.facebook_lite), "Facebook Lite", 4.0f),
        AppInfo(painterResource(id = R.drawable.meta_spark_player), "Meta Spark Player", 4.3f),
        AppInfo(painterResource(id = R.drawable.meta_business_suite), "Meta Business Suite", 4.8f),
        AppInfo(painterResource(id = R.drawable.meta_ads_manager), "Meta Ads Manager", 4.8f),
        AppInfo(painterResource(id = R.drawable.workplace_from_meta), "Workplace from Meta", 4.9f),
        AppInfo(
            painterResource(id = R.drawable.workplace_chat_from_meta),
            "Workplace Chat from Meta",
            4.8f
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        PlayStoreTopBar()
        AppInfoCard(
            appName = "Messenger",
            developerName = "Meta Platforms, Inc.",
            appIcon = painterResource(id = R.drawable.messenger_icon)
        )
        AppSupportCard()
        BetaTesterCard(
            email = "skhut20@freeuni.edu.ge",
            onLearnMoreClicked = {}
        )
        AboutThisAppCard(
            appDescription = appDescription,
            categoryChips = categoryChips,
            reviewCount = reviewCount,
            reviewStars = reviewStars,
            downloadSize = downloadSize,
            ageRating = ageRating,
            downloadCount = downloadCount,
            screenshots = screenshots
        )
        DataSafetyCard(onSeeDetailsClicked = {})
        RatingsAndReviewsCard(
            reviews = listOf(
                Review(
                    "Sudhanshu Singh",
                    "Great app with useful features.",
                    "2024-04-05",
                    576,
                    4.3f
                ),
                Review("Alex Doe", "Needs some improvement in UI.", "2024-04-03", 124, 3.2f)
            ),
            onSeeAllClicked = {}
        )
        MoreAppsByDeveloper(apps = sampleApps)
        RefundPolicy(policy = "All prices include VAT.")
    }
}

@Preview
@Composable
fun PreviewPlayStoreAppView() {
    PlayStoreAppView()
}