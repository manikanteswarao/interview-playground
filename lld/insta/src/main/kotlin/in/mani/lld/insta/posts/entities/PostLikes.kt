package `in`.mani.lld.insta.posts.entities

import java.time.Instant
import java.util.UUID

data class PostLikes(
  val postId: UUID,
  val likes: List<Like>
)

data class Like(
  val userId: UUID,
  val ts: Instant
)