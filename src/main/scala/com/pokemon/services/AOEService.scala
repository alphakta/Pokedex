package com.pokemon.services

import monix.eval.Task
import com.pokemon.Http
import spray.json._
import DefaultJsonProtocol._
import com.pokemon.AsyncHttp


trait AOEAsyncService {
  def getPokemon(name: String): Task[String]
  def getPokemonLocation(name: String): Task[String]
  def getPokemonByType(typePoke: String): Task[String]
  def getPokemonByGeneration(generation: String): Task[String]
}

class AOEAsyncServiceOnHttp(http: AsyncHttp) extends AOEAsyncService {

  def getPokemon(name: String): Task[String] =
    http.get("https://pokeapi.co/api/v2/pokemon/"+name+"/")
      .map(content => content
        .parseJson
        .toString
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

  def getPokemonByType(typePoke: String): Task[String] =
      http.get("https://pokeapi.co/api/v2/type/"+typePoke+"/")
        .map(content => content
        .parseJson
        .toString
        )

  def getPokemonByGeneration(generation: String): Task[String] = 
      http.get("https://pokeapi.co/api/v2/generation/"+generation+"/")
        .map(content => content
        .parseJson
        .toString
        )
}
