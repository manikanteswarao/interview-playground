package `in`.mani.lld.insta.posts.usecases.entities

import java.util.UUID

data class UploadPostRequest(
  val userId: UUID,
  val url: String
)