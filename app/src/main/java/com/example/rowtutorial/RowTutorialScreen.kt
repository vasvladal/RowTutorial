package com.example.rowtutorial

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rowtutorial.ui.components.StyleableTutorialText
import com.example.rowtutorial.ui.components.TutorialHeader
import com.example.rowtutorial.ui.components.TutorialText2

@Preview(showBackground = true)
@Composable
fun RowTutorialScreen() {
    RowTutorialContent()
}

@Composable
private fun RowTutorialContent() {
    LazyColumn(Modifier.fillMaxSize()) {
        item {
            TutorialHeader(text = "Row")
            StyleableTutorialText(
                text = "1-) **Row** is a layout composable that places its children in a horizontal sequence."
            )
            RowExample()

            StyleableTutorialText(
                text = "2-) **verticalAlignment** aligns children vertically inside the Row."
            )
            RowVerticalAlignmentExample()

            StyleableTutorialText(
                text = "3-) **weight** determines how much of the parent's width each child occupies."
            )
            RowWeightExample()

            StyleableTutorialText(
                text = "4-) **Modifier order matters!** padding before/after background changes behavior."
            )
            RowPaddingOrderExample()

            StyleableTutorialText(
                text = "5-) You can apply **shadow** to a Row for elevation effect."
            )
            RowShadowExample()

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun RowExample() {
    TutorialText2(text = "Arrangement.Start")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
        RowTexts()
    }

    TutorialText2(text = "Arrangement.End")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        RowTexts()
    }

    TutorialText2(text = "Arrangement.Center")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        RowTexts()
    }

    TutorialText2(text = "Arrangement.SpaceEvenly")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        RowTexts()
    }

    TutorialText2(text = "Arrangement.SpaceAround")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        RowTexts()
    }

    TutorialText2(text = "Arrangement.SpaceBetween")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        RowTexts()
    }
}

@Composable
fun RowVerticalAlignmentExample() {
    val containerModifier = Modifier
        .fillMaxWidth()
        .height(90.dp)
        .padding(vertical = 4.dp)
        .background(Color.LightGray)

    TutorialText2(text = "Alignment.Top")
    Row(modifier = containerModifier, verticalAlignment = Alignment.Top) {
        DifferentHeightElements()
    }

    TutorialText2(text = "Alignment.CenterVertically")
    Row(modifier = containerModifier, verticalAlignment = Alignment.CenterVertically) {
        DifferentHeightElements()
    }

    TutorialText2(text = "Alignment.Bottom")
    Row(modifier = containerModifier, verticalAlignment = Alignment.Bottom) {
        DifferentHeightElements()
    }
}

@Composable
fun RowWeightExample() {
    val parentModifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .background(Color.LightGray)

    val blockModifier = Modifier
        .fillMaxHeight()
        .background(Color(0xFFA1887F))
        .padding(4.dp)

    Row(modifier = parentModifier) {
        Text(
            fontSize = 12.sp,
            text = "Weight 2",
            color = Color.White,
            modifier = blockModifier.weight(2f)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            fontSize = 12.sp,
            text = "Weight 3",
            color = Color.White,
            modifier = blockModifier.weight(3f)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            fontSize = 12.sp,
            text = "Weight 4",
            color = Color.White,
            modifier = blockModifier.weight(4f)
        )
    }
}

@Composable
fun RowPaddingOrderExample() {
    val rowModifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFFF06292))
        .padding(8.dp)

    val modifierA = Modifier
        .background(Color(0xFFFFEB3B))
        .padding(15.dp)

    val modifierB = Modifier
        .padding(10.dp)
        .background(Color(0xFF80DEEA))
        .padding(end = 15.dp)

    Row(modifier = rowModifier, horizontalArrangement = Arrangement.SpaceEvenly) {
        Column(
            modifier = modifierA
                .background(Color(0xFFFFFFFF))
                .padding(8.dp)
        ) {
            Text(text = "A1")
            Text(text = "A2")
        }
        Column(
            modifier = modifierB
                .background(Color(0xFF9575CD))
                .padding(top = 12.dp, bottom = 12.dp)
        ) {
            Text(text = "B1", color = Color.White)
            Text(text = "B2", color = Color.White)
        }
    }
}

@Composable
fun RowShadowExample() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .background(Color.White)
            .padding(8.dp)
    ) {
        RowTexts()
    }
}

@Composable
fun RowTexts() {
    Text(
        text = "Row1",
        modifier = Modifier.background(Color(0xFFFF9800)).padding(4.dp)
    )
    Text(
        text = "Row2",
        modifier = Modifier.background(Color(0xFFFFA726)).padding(4.dp)
    )
    Text(
        text = "Row3",
        modifier = Modifier.background(Color(0xFFFFB74D)).padding(4.dp)
    )
}

@Composable
fun DifferentHeightElements() {
    Text(
        text = "30dp",
        color = Color.White,
        modifier = Modifier
            .background(Color(0xFF4CAF50))
            .height(30.dp)
            .width(70.dp)
    )
    Text(
        text = "50dp",
        color = Color.White,
        modifier = Modifier
            .background(Color(0xFF66BB6A))
            .height(50.dp)
            .width(70.dp)
    )
    Text(
        text = "70dp",
        color = Color.White,
        modifier = Modifier
            .background(Color(0xFF81C784))
            .height(70.dp)
            .width(70.dp)
    )
}

@Preview(showBackground = true)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(device = Devices.PIXEL_C, showBackground = true)
@Composable
private fun RowTutorialPreview() {
    RowTutorialContent()
}