package `in`.mani.lld.insta.users.entities

import java.util.UUID

data class User(
  val id: UUID,
  val handleName: String,
  val name: String,
  val mobile: String
)
