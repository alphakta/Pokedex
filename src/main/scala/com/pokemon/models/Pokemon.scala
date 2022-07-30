package com.pokemon.models
  // "id": 35,
  // "name": "clefairy",
  // "base_experience": 113,
  // "height": 6,
  // "is_default": true,
  // "order": 56,
  // "weight": 75,
  // "abilities": [
  //   {
  //     "is_hidden": true,
  //     "slot": 3,
  //     "ability": {
  //       "name": "friend-guard",
  //       "url": "https://pokeapi.co/api/v2/ability/132/"
  //     }
  //   }
  // ],
case class PokemonInfo(
  id: Int,
  name: String,
  base_experience: Int,
  height: Int,
  is_default: Boolean,
  order: Int,
  weight: Int
)

case class PokemonLocation(
  name: String,
  url: String
)
