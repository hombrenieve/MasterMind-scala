import org.scalatest.FunSuite

class ProposedCombinationTest extends FunSuite {

  test("Proposal is not correct") {
    val proposal = new ProposedCombination(List(Color.RED, Color.RED, Color.GREEN, Color.BLUE))
    val secret = new SecretCombination(List(Color.RED, Color.RED, Color.PINK, Color.PINK))
    assert(
      proposal.getResult(secret) match {
        case (blacks, whites) => blacks == 0 && whites == 2
      }
    )
  }

  test("Proposal is correct") {
    val proposal = new ProposedCombination(List(Color.RED, Color.RED, Color.RED, Color.RED))
    val secret = new SecretCombination(List(Color.RED, Color.RED, Color.RED, Color.RED))
    assert(
      proposal.getResult(secret) match {
        case (blacks, whites) => blacks == 0 && whites == 4
      }
    )
  }

  test("Proposal is correct but not in order") {
    val proposal = new ProposedCombination(List(Color.RED, Color.BLUE, Color.GREEN, Color.PINK))
    val secret = new SecretCombination(List(Color.BLUE, Color.RED, Color.PINK, Color.GREEN))
    assert(
      proposal.getResult(secret) match {
        case (blacks, whites) => blacks == 4 && whites == 0
      }
    )
  }


  test("Proposal none is correct") {
    val proposal = new ProposedCombination(List(Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE))
    val secret = new SecretCombination(List(Color.RED, Color.RED, Color.RED, Color.RED))
    assert(
      proposal.getResult(secret) match {
        case (blacks, whites) => blacks == 0 && whites == 0
      }
    )
  }

  test("Calculate whites no white") {
    val proposal = new ProposedCombination(List(Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE))
    val secret = new SecretCombination(List(Color.RED, Color.RED, Color.RED, Color.RED))
    assert(
      proposal.calculateWhites(secret) == 0
    )
  }

  test("Calculate whites all white") {
    val proposal = new ProposedCombination(List(Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE))
    val secret = new SecretCombination(List(Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE))
    assert(
      proposal.calculateWhites(secret) == 4
    )
  }

  test("Calculate whites several white") {
    val proposal = new ProposedCombination(List(Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE))
    val secret = new SecretCombination(List(Color.BLUE, Color.RED, Color.BLUE, Color.RED))
    assert(
      proposal.calculateWhites(secret) == 2
    )
  }
}
