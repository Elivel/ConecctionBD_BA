# ConecctionBD_BA
conexión base de datos oracle, gestión de data

## Configuración Gradle para automatización
Se agregó configuración base con **Gradle** para usar:
- **Playwright** (UI testing moderno)
- **Cucumber** (BDD)
- **Selenium** + **WebDriverManager** (Selenium con local driver setup)

### Ejecutar pruebas
```bash
JAVA_HOME=$HOME/.local/share/mise/installs/java/17.0.2 PATH=$JAVA_HOME/bin:$PATH gradle test
```

> Si el entorno bloquea Maven Central, la resolución de dependencias puede fallar (HTTP 403).
