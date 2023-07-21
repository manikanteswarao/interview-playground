package `in`.mani.lld.insta.posts.entities

import java.time.Instant
import java.util.UUID


data class Post(
  val id: UUID,
  val url: String,
  val thumbnail: String,
  val userId: UUID,
  val ts: Instant
)


data class PostMetadata(
  val postId: UUID,
  val url: String,
  val likes: Long,
  val views: Long
)