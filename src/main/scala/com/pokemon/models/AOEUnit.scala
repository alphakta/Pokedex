package com.pokemon.models

/**
 * {
      "id": 1,
      "name": "Archer",
      "description": "Quick and light. Weak at close range; excels at battle from distance",
      "expansion": "Age of Kings",
      "age": "Feudal",
      "created_in": "https://age-of-empires-2-api.herokuapp.com/api/v1/structure/archery_range",
      "cost": {
        "Wood": 25,
        "Gold": 45
      },
      "build_time": 35,
      "reload_time": 2.0,
      "attack_delay": 0.35,
      "movement_rate": 0.96,
      "line_of_sight": 6,
      "hit_points": 4,
      "range": 30,
      "attack": 4,
      "armor": "0/0",
      "accuracy": "80%"
    }
 */

case class AOEUnitCost(
  wood: Option[Int],
  gold: Option[Int],
  food: Option[Int]
)

case class AOEUnit(
  id: Int,
  name: String,
  description: String,
  expansion: String,
  age: String,
  created_in: String,
  cost: AOEUnitCost,
  build_time: Option[Int],
  reload_time: Option[Double],
  attack_delay: Option[Double],
  movement_rate: Option[Double],
  line_of_sight: Option[Int],
  hit_points: Option[Int],
  range: Option[Int | String],
  attack: Option[Int],
  armor: Option[String],
  accuracy: Option[String]
)
