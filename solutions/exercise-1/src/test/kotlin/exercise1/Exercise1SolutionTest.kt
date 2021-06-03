import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class Exercise1SolutionTest {
    @TestFactory
    fun `given gold bars objective, should count all the possible K values to reach it exactly`() =
        listOf(
            10 to "2" to 2
        ).map { (k, s, expected) ->
            dynamicTest(
                "given gold bars objective, should count all the possible K values to reach it exactly"
            ) {
                expectThat(countPalindromesBelowS()).isEqualTo(expected)
            }
        }
}