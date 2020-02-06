import org.scalatest.FunSuite

class SecretCombinationTest extends FunSuite {
  private val forcedSecret = List(Color.BLUE, Color.RED, Color.PINK, Color.ORANGE)

  test("Forced secret is the same") {
    val secret = new SecretCombination(forcedSecret)
    assert(secret.secret == forcedSecret)
  }

  test("Not forced secret is different") {
    val secret = new SecretCombination(dimension = forcedSecret.size)
    assert(secret.secret != forcedSecret)
  }

}
