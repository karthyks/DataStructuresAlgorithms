package questions.stacks

import org.junit.Before
import org.junit.Test
import java.io.File
import java.util.*

class ValidParenthesesProblemTest {

    private val parenthesesArray = mutableListOf<String>()

    @Before
    fun setUp() {
        val file = File(javaClass.classLoader.getResource("parentheses/parentheses.txt")!!.file)
        val scanner = Scanner(file)
        parenthesesArray.add(scanner.nextLine())
        parenthesesArray.add(scanner.nextLine())
        scanner.close()
    }

    @Test
    fun shouldBeValid() {
        assert(ValidParenthesesProblem().isValid(parentheses = parenthesesArray[0]))
    }

    @Test
    fun shouldNotBeValid() {
        assert(ValidParenthesesProblem().isValid(parentheses = parenthesesArray[1]).not())
    }
}