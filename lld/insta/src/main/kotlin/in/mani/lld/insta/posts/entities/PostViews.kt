package `in`.mani.lld.insta.posts.entities

import java.time.Instant
import java.util.*

data class PostViews(
  val postId: UUID,
  val likes: List<Like>
)

data class View(
  val userId: UUID,
  val ts: Instant
)