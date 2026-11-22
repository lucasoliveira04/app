package com.apppessoal.android.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apppessoal.android.components.HomeButton
import com.apppessoal.android.components.HomeButtonData
import com.apppessoal.android.components.HomeButtonSpec
import com.apppessoal.android.components.HomeIcons
import com.apppessoal.android.configurations.AppColors
import kotlinx.coroutines.launch

/** Dados de demonstração; podem ser substituídos por dados de um serviço. */
object HomeDefaults {
    val buttons: List<HomeButtonSpec> = listOf(
        HomeButtonData("finance", "Finanças", "Saldo em dia", HomeIcons.Finance, AppColors.Finance, AppColors.FinanceBackground),
        HomeButtonData("career", "Estudos & Carreira", "2 pendências", HomeIcons.Career, AppColors.Career, AppColors.CareerBackground),
        HomeButtonData("projects", "Projetos", "3 ativos", HomeIcons.Projects, AppColors.Projects, AppColors.ProjectsBackground),
        HomeButtonData("health", "Saúde", "4/4 treinos", HomeIcons.Health, AppColors.Health, AppColors.HealthBackground),
        HomeButtonData("routine", "Rotina", "12 dias seguidos", HomeIcons.Routine, AppColors.Routine, AppColors.RoutineBackground),
        HomeButtonData("personal", "Pessoal", "Descanso em dia", HomeIcons.Personal, AppColors.Personal, AppColors.PersonalBackground),
    )
}

@Composable
fun Home(
    modifier: Modifier = Modifier,
    userName: String = "Lucas",
    summary: String = "7 itens abertos · Tudo em dia",
    buttons: List<HomeButtonSpec> = HomeDefaults.buttons,
    onAction: ((HomeButtonSpec) -> Unit)? = null,
    onCreate: ((HomeButtonSpec) -> Unit)? = null,
) {
    val snackbar = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var newMenuExpanded by remember { mutableStateOf(false) }
    fun select(item: HomeButtonSpec, create: Boolean = false) {
        val handler = if (create) onCreate else onAction
        if (handler != null) handler(item)
        else scope.launch { snackbar.showSnackbar("${item.title}: módulo em breve.") }
    }

    Scaffold(
        modifier = modifier,
        containerColor = AppColors.Background,
        snackbarHost = { SnackbarHost(snackbar) },
    ) { insets ->
        BoxWithConstraints(Modifier.fillMaxSize().padding(insets)) {
            val columns = if (maxWidth >= 600.dp) 2 else 1
            LazyVerticalGrid(
                columns = GridCells.Fixed(columns),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Row(Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            Box(Modifier.size(9.dp).background(AppColors.TextPrimary, CircleShape))
                            Text("$userName Gestão", color = AppColors.TextPrimary, style = MaterialTheme.typography.titleSmall)
                        }
                        Spacer(Modifier.width(12.dp))
                        Box {
                            OutlinedButton(
                                onClick = { newMenuExpanded = true },
                                shape = RoundedCornerShape(50),
                                border = BorderStroke(1.dp, AppColors.Border),
                                colors = ButtonDefaults.outlinedButtonColors(containerColor = AppColors.Surface, contentColor = AppColors.TextPrimary),
                                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp),
                            ) {
                                Icon(HomeIcons.Plus, contentDescription = null, modifier = Modifier.size(16.dp), tint = AppColors.TextSecondary)
                                Spacer(Modifier.width(6.dp))
                                Text("Novo")
                            }
                            DropdownMenu(expanded = newMenuExpanded, onDismissRequest = { newMenuExpanded = false }) {
                                buttons.forEach { item ->
                                    DropdownMenuItem(
                                        text = { Text(item.title) },
                                        leadingIcon = { Icon(item.icon, contentDescription = null, tint = item.accent) },
                                        onClick = { newMenuExpanded = false; select(item, create = true) },
                                    )
                                }
                            }
                        }
                    }
                }
                item(span = { GridItemSpan(maxLineSpan) }) {
                    Column(Modifier.padding(top = 36.dp, bottom = 24.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("Olá, $userName", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Medium, color = AppColors.TextPrimary)
                        Text(summary, style = MaterialTheme.typography.bodyMedium, color = AppColors.TextSecondary)
                    }
                }
                items(buttons, key = { it.id }) { item ->
                    HomeButton(item, onClick = { select(item) }, modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}

@Preview(name = "Celular", showBackground = true, widthDp = 393, heightDp = 852)
@Preview(name = "Tablet", showBackground = true, widthDp = 840, heightDp = 720)
@Composable
private fun HomePreview() {
    MaterialTheme { Home() }
}
