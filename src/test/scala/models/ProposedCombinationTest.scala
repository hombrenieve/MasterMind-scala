package models

import org.scalatest.FunSuite

class ProposedCombinationTest extends FunSuite {

  test("Proposal is not correct") {
    val secret = new SecretCombination(List(Color.RED, Color.RED, Color.PINK, Color.PINK))
    val proposal = new ProposedCombination(List(Color.RED, Color.RED, Color.GREEN, Color.BLUE), secret.secret)
    assert(
      proposal.result == (2, 0)
    )
  }

  test("Proposal is correct") {
    val secret = new SecretCombination(List(Color.RED, Color.RED, Color.RED, Color.RED))
    val proposal = new ProposedCombination(List(Color.RED, Color.RED, Color.RED, Color.RED), secret.secret)
    assert(
      proposal.result == (4, 0)
    )
  }

  test("Proposal is correct but not in order") {
    val secret = new SecretCombination(List(Color.BLUE, Color.RED, Color.PINK, Color.GREEN))
    println()
    val proposal = new ProposedCombination(List(Color.RED, Color.BLUE, Color.GREEN, Color.PINK), secret.secret)
    assert(
      proposal.result == (0, 4)
    )
  }

  test("Proposal none is correct") {
    val secret = new SecretCombination(List(Color.RED, Color.RED, Color.RED, Color.RED))
    val proposal = new ProposedCombination(List(Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE), secret.secret)
    assert(
      proposal.result == (0, 0)
    )
  }

  test("Proposal is not correct and mixed") {
    val secret = new SecretCombination(List(Color.BLUE, Color.RED, Color.PINK, Color.PINK))
    val proposal = new ProposedCombination(List(Color.RED, Color.BLUE, Color.PINK, Color.RED), secret.secret)
    assert(
      proposal.result == (1, 2)
    )
  }
}
