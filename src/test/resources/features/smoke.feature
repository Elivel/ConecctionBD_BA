Feature: Smoke técnico para Playwright y Selenium

  @playwright
  Scenario: Abrir una URL con Playwright
    Given una sesión Playwright
    When abro la página "https://example.com"
    Then el título contiene "Example"

  @selenium
  Scenario: Abrir una URL con Selenium
    Given una sesión Selenium con WebDriverManager
    When navego a "https://example.com"
    Then el título Selenium contiene "Example"
