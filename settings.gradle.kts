rootProject.name = "ds-algo"

include("commons")
include("dp")
include("graphs")
include("strings")
include("trees")
include("arrays")

include("leetcode")

include("interview")

include(":insta")
include(":linkedlist")
project(":insta").projectDir = File("lld/insta")

