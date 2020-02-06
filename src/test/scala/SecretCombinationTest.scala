import org.scalatest.FunSuite

class SecretCombinationTest extends FunSuite {
  private val forcedSecret = List(Color.BLUE, Color.RED, Color.PINK, Color.ORANGE)

  test("Forced secret is the same") {
    val secret = new SecretCombination(forcedSecret)
    assert(secret.secret == forcedSecret)
  }

  test("Forced secret is the same regardless of the size") {
    val secret = new SecretCombination(forcedSecret, dimension = forcedSecret.size+5)
    assert(secret.secret == forcedSecret)
  }

  test("Not forced secret is different in size") {
    val secret = new SecretCombination(dimension = forcedSecret.size+5)
    assert(secret.secret != forcedSecret)
  }

}
