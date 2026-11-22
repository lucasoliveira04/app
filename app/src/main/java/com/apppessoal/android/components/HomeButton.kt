package com.apppessoal.android.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.apppessoal.android.configurations.AppColors

/** Contrato comum para os botões da Home, inclusive implementações com dados dinâmicos. */
interface HomeButtonSpec {
    val id: String
    val title: String
    val supportingText: String
    val icon: ImageVector
    val accent: Color
    val iconBackground: Color
}

data class HomeButtonData(
    override val id: String,
    override val title: String,
    override val supportingText: String,
    override val icon: ImageVector,
    override val accent: Color,
    override val iconBackground: Color,
) : HomeButtonSpec

/** A ação é fornecida pela tela, sem acoplar o componente à navegação. */
@Composable
fun HomeButton(item: HomeButtonSpec, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = AppColors.Surface),
        border = BorderStroke(1.dp, AppColors.Border),
    ) {
        Row(Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
            Surface(color = item.iconBackground, shape = RoundedCornerShape(13.dp)) {
                Box(Modifier.size(46.dp), contentAlignment = Alignment.Center) {
                    Icon(item.icon, contentDescription = null, tint = item.accent, modifier = Modifier.size(22.dp))
                }
            }
            Spacer(Modifier.width(16.dp))
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(item.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Medium, color = AppColors.TextPrimary)
                Text(item.supportingText, style = MaterialTheme.typography.bodySmall, color = AppColors.TextSecondary)
            }
            Spacer(Modifier.width(8.dp))
            Icon(HomeIcons.Arrow, contentDescription = null, tint = AppColors.Arrow, modifier = Modifier.size(18.dp))
        }
    }
}
