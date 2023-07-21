package `in`.mani.lld.insta.users.entities

import java.util.UUID

data class Followers(
  val userId: UUID,
  val followers: List<UUID>,
  val following: List<UUID>
)