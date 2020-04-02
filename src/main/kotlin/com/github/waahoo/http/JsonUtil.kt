package com.github.waahoo.http

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonElement

val json = Json(JsonConfiguration.Stable.copy(prettyPrint = true))

fun String.json() = json.parseJson(this)
operator fun JsonElement.get(vararg path: String): JsonElement {
  var element = this
  for(p in path)
    element = element.jsonObject[p]!!
  return element
}

fun JsonElement.tryGet(vararg path: String): JsonElement? {
  var element: JsonElement? = this
  for(p in path) {
    if(element == null) return null
    element = element.jsonObject[p]
  }
  return element
}