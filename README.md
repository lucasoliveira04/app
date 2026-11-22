# App Pessoal — Android

Base nativa em Kotlin e Jetpack Compose, com Material 3 e temas claro/escuro.
Compatível com Android 8.0 (API 26) ou superior. Ainda não há funcionalidades de negócio ou persistência.

## Ambiente

- JDK 17 ou 21, configurado em `JAVA_HOME`.
- Android SDK: plataforma 36, Build Tools 35.0.0 e Platform Tools.
- Gradle 8.13 via wrapper; Android Gradle Plugin 8.13.2 e Kotlin 2.2.21.
- `local.properties` deve conter `sdk.dir=C\:/caminho/Android/Sdk` (arquivo local, ignorado pelo Git).

Abra esta pasta no Android Studio para sincronizar e executar pelo botão Run.
Também é possível compilar pelo PowerShell no VS Code:
O atalho `Ctrl+Shift+B` executa o build debug; outras tarefas estão em **Terminal → Run Task**.

```powershell
.\gradlew.bat assembleDebug
.\gradlew.bat lintDebug
```

O APK de desenvolvimento é gerado em `app/build/outputs/apk/debug/app-debug.apk`.
Para instalar em um celular conectado com depuração USB habilitada:

```powershell
.\gradlew.bat installDebug
```

## Build otimizado

```powershell
.\gradlew.bat assembleRelease bundleRelease
```

A versão release aplica R8 e remoção de recursos não utilizados. O APK release é
gerado sem assinatura; configure uma chave própria antes de distribuir/publicar.
Não versione chaves ou senhas. Compare tamanhos de produção; o APK debug inclui
recursos de desenvolvimento e não representa o download pela Play Store.

Room e DataStore serão adicionados quando houver uma necessidade de persistência.
O identificador provisório é `com.apppessoal.android`; defina o definitivo antes de publicar.
