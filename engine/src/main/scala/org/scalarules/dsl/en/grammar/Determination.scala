package org.scalarules.dsl.en.grammar

import org.scalarules.engine.Derivation

class Determination(berekeningAccumulators: DeterminationAccumulator*) {
  val derivations: List[Derivation] = berekeningAccumulators.flatMap(_.derivations).toList
//  val berekeningenWithExtraInputInformation: List[(Derivation, List[Fact[Any]], List[Fact[Any]])] = berekeningAccumulators.flatMap(b => b.toDerivationAndInputSets).toList
}
