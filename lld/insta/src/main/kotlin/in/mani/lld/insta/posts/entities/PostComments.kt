package `in`.mani.lld.insta.posts.entities

import java.time.Instant
import java.util.UUID

data class PostComments(
  val postId: UUID,
  val comments: List<Comment>
)

data class Comment(
  val userId: UUID,
  val userHandle: String,
  val comment: String,
  val ts: Instant,
  val subComments: List<Comment>
)
