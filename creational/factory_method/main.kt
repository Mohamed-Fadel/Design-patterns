package creational.factory_method

interface Button {
  fun render(): String
}

interface TextField {
  fun render(): String
}

class LightButton : Button {
  override fun render(): String {
      return "Rendering Light Button"
  }
}

class LightTextField : TextField {
  override fun render(): String {
      return "Rendering Light TextField"
  }
}

class DarkButton : Button {
  override fun render(): String {
      return "Rendering Dark Button"
  }
}

class DarkTextField : TextField {
  override fun render(): String {
      return "Rendering Dark TextField"
  }
}

interface ThemeFactory {
    fun createButton(): Button
    fun createTextField(): TextField
}

class LightThemeFactory : ThemeFactory {
  override fun createButton(): Button {
      return LightButton()
  }

  override fun createTextField(): TextField {
      return LightTextField()
  }
}

class DarkThemeFactory : ThemeFactory {
  override fun createButton(): Button {
      return DarkButton()
  }

  override fun createTextField(): TextField {
      return DarkTextField()
  }
}

fun main() {
  val themeFactory: ThemeFactory = if (isDarkModeEnabled()) {
      DarkThemeFactory()
  } else {
      LightThemeFactory()
  }

  val button = themeFactory.createButton()
  val textField = themeFactory.createTextField()

  println(button.render())
  println(textField.render())
}

fun isDarkModeEnabled(): Boolean {
  // Logic to determine if dark mode is enabled
  return false // Change to true to test dark mode
}
