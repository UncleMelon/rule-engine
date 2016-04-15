package org.scalarules.utils

import org.scalarules.engine.Fact

import scala.reflect.ClassTag

object GlossaryConverter {

  def toJson(g: Glossary): String = {

    def factToJson[A : ClassTag](fe: (String, Fact[A])): String = {
      val (name, fact) = fe
      val classTag = implicitly[ClassTag[A]]
      s""" "${name}": {
          |  "name": "${name}",
          |  "description": "${fact.description}",
          |}
       """.stripMargin
    }

    g.getFacts.map( factToJson ).mkString("{", ", ", "}")
  }

}