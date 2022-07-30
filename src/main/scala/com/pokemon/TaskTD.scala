package com.pokemon
import com.pokemon.services.AOEAsyncServiceOnHttp
import monix.execution.Scheduler.Implicits.global

object TaskTD {
  /**
   * API url  https://age-of-empires-2-api.herokuapp.com/api/v1/
   */
  def main(args: Array[String]): Unit =
    val aoeSvc = new AOEAsyncServiceOnHttp(http = new AsyncHttp)

    // val http = "https://pokeapi.co/api/v2/pokemon/1/"

    // val result = scala.io.Source.fromURL(http).mkString

    // println(result)


    // aoeSvc.getPokemon("1")
    //   .runAsync {
    //     case Left(err) =>
    //       println(s"Got err: ${err.toString}")
    //     case Right(units) =>
    //       println(units)
    //   }

      aoeSvc.getPokemonLocation("1")
      .runAsync {
        case Left(err) =>
          println(s"Got err: ${err.toString}")
        case Right(units) =>
          println(units)
      }

    // aoeSvc.getCivilizations()
    //   .runAsync {
    //     case Left(err) =>
    //       println(s"Got err: ${err.toString}")
    //     case Right(units) =>
    //       println(units)
    //   }
}
