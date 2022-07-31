package com.pokemon.services

import monix.eval.Task
import com.pokemon.Http
import spray.json._
import DefaultJsonProtocol._
import com.pokemon.AsyncHttp
import scala.concurrent.duration._


trait PokeAsyncService {
  def getPokemon(name: String): Task[String]
  def getPokemonLocation(name: String): Task[String]
  def getPokemonByType(typePoke: String): Task[String]
  def getPokemonByGeneration(generation: String): Task[String]
}

class PokeAsyncServiceHttp(http: AsyncHttp) extends PokeAsyncService {

  def getPokemon(name: String): Task[String] =
    http.get(s"https://pokeapi.co/api/v2/pokemon/${name}/")
      .map(content => content
        .parseJson
        .toString
      ).delayExecution(3.seconds)

  def getPokemonLocation(name: String): Task[String] = 
      http.get(s"https://pokeapi.co/api/v2/pokemon/${name}/encounters")
        .map(content => content
        .parseJson
        .toString
      ).delayExecution(3.seconds)

  def getPokemonByType(typePoke: String): Task[String] =
      http.get(s"https://pokeapi.co/api/v2/type/${typePoke}/")
        .map(content => content
        .parseJson
        .toString
        ).delayExecution(3.seconds)

  def getPokemonByGeneration(generation: String): Task[String] = 
      http.get(s"https://pokeapi.co/api/v2/generation/${generation}/")
        .map(content => content
        .parseJson
        .toString
        ).delayExecution(3.seconds)
}
