import org.scalatest.FunSuite

class ProposedCombinationTest extends FunSuite {

  test("Proposal is not correct") {
    val proposal = new ProposedCombination(List(Color.RED, Color.RED, Color.GREEN, Color.BLUE))
    val secret = new SecretCombination(List(Color.RED, Color.RED, Color.PINK, Color.PINK))
    assert(
      proposal.getResult(secret) == (2, 0)
    )
  }

  test("Proposal is correct") {
    val proposal = new ProposedCombination(List(Color.RED, Color.RED, Color.RED, Color.RED))
    val secret = new SecretCombination(List(Color.RED, Color.RED, Color.RED, Color.RED))
    assert(
      proposal.getResult(secret) == (4, 0)
    )
  }

  test("Proposal is correct but not in order") {
    val proposal = new ProposedCombination(List(Color.RED, Color.BLUE, Color.GREEN, Color.PINK))
    val secret = new SecretCombination(List(Color.BLUE, Color.RED, Color.PINK, Color.GREEN))
    assert(
      proposal.getResult(secret) == (0, 4)
    )
  }

  test("Proposal none is correct") {
    val proposal = new ProposedCombination(List(Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE))
    val secret = new SecretCombination(List(Color.RED, Color.RED, Color.RED, Color.RED))
    assert(
      proposal.getResult(secret) == (0, 0)
    )
  }

  test("Proposal is not correct and mixed") {
    val proposal = new ProposedCombination(List(Color.RED, Color.BLUE, Color.PINK, Color.RED))
    val secret = new SecretCombination(List(Color.BLUE, Color.RED, Color.PINK, Color.PINK))
    assert(
      proposal.getResult(secret) == (1, 2)
    )
  }
}
