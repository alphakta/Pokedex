package com.pokemon.json

import spray.json._
import DefaultJsonProtocol._
import com.pokemon.models.Civilization
import com.pokemon.models.PokemonInfo
import com.pokemon.models.AOEUnit
import com.pokemon.models.AOEUnitCost
import com.pokemon.models.PokemonLocation


object JsonFormatters extends DefaultJsonProtocol {

  implicit val intOrString: JsonFormat[Int | String] = new JsonFormat[Int | String] {
    override def read(json: JsValue): Int | String =
      json match {
        case JsNumber(nb) => nb.toInt
        case JsString(str) => str
        case _ =>
          throw new RuntimeException(s"Invalid js value for intOrString: ${json.prettyPrint}")
      }

    override def write(obj: Int | String): JsValue = {
      obj match {
        case x: Int => JsNumber(x)
        case str: String => JsString(str)
      }
    }
  }

  implicit val civilizationJsonFormat: JsonFormat[Civilization] = jsonFormat8(Civilization.apply)
  implicit val aoeUnitCostJsonFormat: JsonFormat[AOEUnitCost] = jsonFormat3(AOEUnitCost.apply)
  implicit val aoeUnitJsonFormat: JsonFormat[AOEUnit] = jsonFormat17(AOEUnit.apply)
  implicit val pokemonJsonFormat: JsonFormat[PokemonInfo] = jsonFormat7(PokemonInfo.apply)
  implicit val pokemonLocationJsonFormat: JsonFormat[PokemonLocation] = jsonFormat2(PokemonLocation.apply)

}
