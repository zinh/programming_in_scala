package zinh
abstract class Element{
  def contents: Array[String]
  val height: Int = contents.length
  val width: Int = if (height = 0) 0 else contents(0).length
  def above(that: Element): Element = {
  }
}

class ArrayElement(val contents: Array[String]) extends Element

class  LineElement(s: String) extends Element{
  val contents = Array(s)
  override width = s.length
  override height = 1
}

class UniformElement(ch: Char, override width: Int, override height: Int) extends Element{
  private val line = ch.toString * width
  def contents = Array.fill(height)(line)
}
