package com.pokemon
import com.pokemon.services.PokeAsyncServiceHttp
import monix.execution.Scheduler.Implicits.global

object Pokedex {

  def main(args: Array[String]): Unit =
    val aoeSvc = new PokeAsyncServiceHttp(http = new AsyncHttp)
   /* 
    // ----- GET -> Le pokemon avec le nom bulbasaur
       aoeSvc.getPokemon("bulbasaur")
      .runAsync {
        case Left(err) =>
          println(s"Got err: ${err.toString}")
        case Right(result) =>
          println(s"-------------------- \n API CALL Return: \n ${result}")
      } 
      */

    /* 
    ----- WHEREIS -> Tous les pokemons de cerulean-city-area
      aoeSvc.getPokemonLocation("cerulean-city-area")
      .runAsync {
        case Left(err) =>
          println(s"Got err: ${err.toString}")
        case Right(result) =>
          println(s"-------------------- \n API CALL Return: \n ${result}")
      } */

     
    // // ----- GETALLTYPE -> Tous les pokemons de type ground
    //   aoeSvc.getPokemonByType("ground")
    //   .runAsync {
    //     case Left(err) =>
    //       println(s"Got err: ${err.toString}")
    //     case Right(result) =>
    //       println(s"-------------------- \n API CALL Return: \n ${result}")
    //   }

    // // ----- GETALLGENERATION -> Tous les pokemons de generation-i
    //   aoeSvc.getPokemonByGeneration("generation-i")
    //   .runAsync {
    //     case Left(err) =>
    //       println(s"Got err: ${err.toString}")
    //     case Right(result) =>
    //       println(s"-------------------- \n API CALL Return: \n ${result}")
    //   } 

    println("<>--------------------------- POKEDEX API ---------------------------<>")
    println("Entrez les commandes : \n GET <pokemon-name> \n GETALLTYPE <pokemon-type> \n GETALLGENERATION <pokemon-generation> \n WHEREIS <pokemon-location> \n QUIT")
    println("PokedexAPI>")

    //Je n'ai pas pu tester les commandes par ligne de commande car j'ai une erreur avec mon Debug Console...
    val a = scala.io.StdIn.readLine()
    var args = a.split(" ").toList

    args match {
      case List("GET", pokemonName) => aoeSvc.getPokemon(args(1)).runAsync { case Left(err) => println(s"Got err: ${err.toString}") case Right(result) => println(s"-------------------- \n API CALL Return: \n ${result}") }
      case List("GETALLTYPE", pokemonType) => aoeSvc.getPokemonByType(args(1)).runAsync { case Left(err) => println(s"Got err: ${err.toString}") case Right(result) => println(s"-------------------- \n API CALL Return: \n ${result}") }
      case List("GETALLGENERATION", pokemonType) => aoeSvc.getPokemonByGeneration(args(1)).runAsync { case Left(err) => println(s"Got err: ${err.toString}") case Right(result) => println(s"-------------------- \n API CALL Return: \n ${result}") }
      case List("WHEREIS", pokemonLocation) => aoeSvc.getPokemonLocation(args(1)).runAsync { case Left(err) => println(s"Got err: ${err.toString}") case Right(result) => println(s"-------------------- \n API CALL Return: \n ${result}") }
      case List("MATCH", pokemonType) => println("")
      case List("QUIT") => System.exit(0)
      case _ => println("Commande inconnue")
    }

}
