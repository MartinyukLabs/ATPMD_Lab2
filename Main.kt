fun main() {
    println("=== User Registration ===")

    print("Enter login: ")
    val inputLogin = readlnOrNull()
    val login = inputLogin?.takeIf { it.isNotBlank() } ?: "guest"

    print("Enter password: ")
    val password1Input = readlnOrNull()
    val password1 = inputLogin?.takeIf { it.isNotBlank() } ?: "123456"

    print("Repeat password: ")
    val password2Input = readlnOrNull()
    val password2 = inputLogin?.takeIf { it.isNotBlank() } ?: "123456"

    println("Login: $login")
    println("Password: $password1")
    println("Repeat password: $password2")
    try {
        if (password1 != password2) throw PasswordMismatchException()
        if (!isPasswordStrong(password1)) throw WeakPasswordException()

        println("User \"$login\" has been successfully registered.")
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}

class PasswordMismatchException : Exception("Passwords do not match.")
class WeakPasswordException : Exception("Weak password. Minimum 8 characters, 1 digit, and 1 uppercase letter required.")

fun isPasswordStrong(password: String): Boolean {
    val hasLength = password.length >= 8
    val hasDigit = password.any { it.isDigit() }
    val hasUpper = password.any { it.isUpperCase() }
    return hasLength && hasDigit && hasUpper
}
