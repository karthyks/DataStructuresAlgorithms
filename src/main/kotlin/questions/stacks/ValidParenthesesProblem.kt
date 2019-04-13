package questions.stacks

import java.util.*

class ValidParenthesesProblem {

    fun isValid(parentheses: String): Boolean {
        val localStack = Stack<Char>()
        for (char in parentheses) {
            if (char == '[' || char == '{' || char == '(') {
                localStack.push(char)
            } else if (char == ']' || char == '}' || char == ')') {
                if (char.isEnclosing(localStack.peek())) localStack.pop() else return false
            } else {
                return false
            }
        }
        return localStack.isEmpty()
    }

    private fun Char.isEnclosing(char: Char): Boolean {
        return when (char) {
            '[' -> this == ']'
            '(' -> this == ')'
            '{' -> this == '}'
            else -> false
        }
    }
}