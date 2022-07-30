package com.pokemon.services

import com.pokemon.models.{PokemonInfo, PokemonLocation, Civilization, AOEUnit}
import monix.eval.Task
import com.pokemon.Http
import spray.json._
import DefaultJsonProtocol._
import com.pokemon.json.JsonFormatters._
import com.pokemon.AsyncHttp


trait AOEAsyncService {
  def getCivilizations(): Task[Seq[Civilization]]
  def getPokemon(name: String): Task[Seq[PokemonInfo]]
  def getPokemonLocation(name: String): Task[String]
}

class AOEAsyncServiceOnHttp(http: AsyncHttp) extends AOEAsyncService {

  def getCivilizations(): Task[Seq[Civilization]] =
    http.get("https://age-of-empires-2-api.herokuapp.com/api/v1/civilizations")
      .map(content => content
        .parseJson.asJsObject
        .fields("civilizations")
        .convertTo[Seq[Civilization]]
      )

  def getPokemon(name: String): Task[Seq[PokemonInfo]] =
    http.get("https://pokeapi.co/api/v2/pokemon/"+name+"/")
      .map(content => content
        .parseJson
        .asJsObject
        .convertTo[Seq[PokemonInfo]]
      )

  def getPokemonLocation(name: String): Task[String] = 
      http.get("https://pokeapi.co/api/v2/pokemon/"+name+"/encounters")
        .map(content => content
        .parseJson
        .toString
        // .convertTo[Seq[PokemonLocation]]
        // .asJsObject
        // .convertTo[Seq[PokemonLocation]]
      )
}