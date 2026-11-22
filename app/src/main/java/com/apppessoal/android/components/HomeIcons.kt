package com.apppessoal.android.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathBuilder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

/** Ícones vetoriais locais, escaláveis e sem dependências adicionais. */
object HomeIcons {
    private fun icon(name: String, block: PathBuilder.() -> Unit) = ImageVector.Builder(
        name = name, defaultWidth = 24.dp, defaultHeight = 24.dp,
        viewportWidth = 24f, viewportHeight = 24f,
    ).apply {
        path(fill = null, stroke = SolidColor(Color.Black), strokeLineWidth = 1.6f,
            strokeLineCap = StrokeCap.Round, strokeLineJoin = StrokeJoin.Round,
            pathBuilder = block)
    }.build()

    val Arrow = icon("Arrow") {
        moveTo(5f, 12f); lineTo(19f, 12f)
        moveTo(13f, 6f); lineTo(19f, 12f); lineTo(13f, 18f)
    }
    val Plus = icon("Plus") {
        moveTo(12f, 5f); lineTo(12f, 19f)
        moveTo(5f, 12f); lineTo(19f, 12f)
    }
    val Finance = icon("Finance") {
        moveTo(4f, 5f); lineTo(20f, 5f); lineTo(20f, 20f); lineTo(4f, 20f); close()
        moveTo(4f, 9f); lineTo(20f, 9f)
        moveTo(15f, 14f); lineTo(17f, 14f)
    }
    val Career = icon("Career") {
        moveTo(3f, 7f); lineTo(21f, 7f); lineTo(21f, 20f); lineTo(3f, 20f); close()
        moveTo(8f, 7f); lineTo(8f, 4f); lineTo(16f, 4f); lineTo(16f, 7f)
        moveTo(3f, 11f); quadTo(12f, 16f, 21f, 11f)
        moveTo(12f, 11f); lineTo(12f, 15f)
    }
    val Projects = icon("Projects") {
        moveTo(3f, 5f); lineTo(9f, 5f); lineTo(12f, 8f); lineTo(21f, 8f)
        lineTo(21f, 20f); lineTo(3f, 20f); close()
    }
    val Health = icon("Health") {
        moveTo(12f, 21f); curveTo(9f, 18f, 3f, 14f, 3f, 9f)
        curveTo(3f, 3f, 9f, 2f, 12f, 7f)
        curveTo(15f, 2f, 21f, 3f, 21f, 9f)
        curveTo(21f, 14f, 15f, 18f, 12f, 21f)
        moveTo(5f, 12f); lineTo(9f, 12f); lineTo(11f, 9f)
        lineTo(14f, 15f); lineTo(16f, 12f); lineTo(19f, 12f)
    }
    val Routine = icon("Routine") {
        moveTo(10f, 3f); lineTo(12.5f, 9.5f); lineTo(19f, 12f)
        lineTo(12.5f, 14.5f); lineTo(10f, 21f); lineTo(7.5f, 14.5f)
        lineTo(1f, 12f); lineTo(7.5f, 9.5f); close()
        moveTo(19f, 2f); lineTo(19f, 6f); moveTo(17f, 4f); lineTo(21f, 4f)
    }
    val Personal = icon("Personal") {
        moveTo(3f, 16f); lineTo(21f, 16f)
        moveTo(7f, 16f); curveTo(4f, 7f, 20f, 7f, 17f, 16f)
        moveTo(12f, 3f); lineTo(12f, 5f)
        moveTo(4f, 6f); lineTo(6f, 8f); moveTo(18f, 8f); lineTo(20f, 6f)
        moveTo(2f, 11f); lineTo(4f, 11f); moveTo(20f, 11f); lineTo(22f, 11f)
        moveTo(6f, 20f); lineTo(18f, 20f)
    }
}

