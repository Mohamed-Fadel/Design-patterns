# Factory Method Pattern in Kotlin

## Overview

The **Factory Method** is a creational design pattern that provides an interface for creating objects, allowing subclasses to alter the type of objects that will be created.

## Example: Themed UI Components

In this example, we implement the Factory Method pattern to create different types of UI components (buttons and text fields) based on the selected theme: **LightTheme** and **DarkTheme**.

## Implementation

### 1. UI Component Interface

Defines the structure for UI components.

```kotlin
interface Button {
    fun render(): String
}

interface TextField {
    fun render(): String
}
```

### 2. Concrete UI Component Classes

Implementations of the `Button` and `TextField` interfaces for Light Theme.

```kotlin
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
```

###  3. Concrete UI Component Classes for Dark Theme

Implementations for Dark Theme.

```kotlin
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
```

###  3. Theme Factory Interface

Declares the factory method for creating UI components.

```kotlin
interface ThemeFactory {
    fun createButton(): Button
    fun createTextField(): TextField
}
```

### 5. Concrete Theme Factories

Factories for creating UI components for each theme.

```kotlin
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
```

### 6. Usage Example

Demonstrate how to use the factories to create themed UI components.

```kotlin
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
```

### Output

When you run the code with dark mode disabled, you will see:

```
Rendering Light Button
Rendering Light TextField
```

If dark mode is enabled, the output would be:

```
Rendering Dark Button
Rendering Dark TextField
```

## Benefits of the Factory Method Pattern

The Factory Method Pattern enhances code organization and maintainability by:

- **Encapsulation**: Instantiation logic is encapsulated in factories, promoting loose coupling.

- **Extensibility**: New themes and UI components can be added without altering existing code, adhering to the Open/Closed Principle.

- **Decoupling**: Client code can work with different themes through the factory interface, enhancing code readability and maintainability.


