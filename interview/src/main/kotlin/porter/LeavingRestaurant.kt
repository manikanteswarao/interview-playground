package porter


// Scale

class LeavingRestaurant {

  fun solve(history: String, tables: Int): Int {
    if (history.isEmpty()) return 0
    if (tables == 0) return history.length

    val seatingMap = HashSet<Char>()
    val waitingQueue = ArrayDeque<Char>()

    var answer = 0

    for (element in history) {

      if (seatingMap.contains(element)) {
        seatingMap.remove(element)
        if (waitingQueue.isNotEmpty()) seatingMap.add(waitingQueue.removeFirst())
      } else {
        if (waitingQueue.contains(element)) {
          answer++
          waitingQueue.remove(element)
        }

        if (seatingMap.size == tables) waitingQueue.addLast(element)
        else seatingMap.add(element)
      }
    }
    return answer
  }
}




