package strings


fun main() {

  val v = -2.478132487394035E97
//  val vsn = if(v.toString().contains("E")) v.format(2) else v
  println(" value is ${v.toBigDecimal()}");
}

//fun Double.format(digits: Int) = "%.${digits}f".format(this)
