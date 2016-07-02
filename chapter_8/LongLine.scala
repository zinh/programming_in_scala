package zinh
import scala.io.Source

object LongLine{
    def processLine(filename: String, width: Int): Unit = {
        def processLine(line: String): Unit = {
            if (line.length > width)
                println(filename + ": " + line.trim)
        }
        val source = Source.fromFile(filename)
        for (line <- source.getLines())
            processLine(filename, width, line)
    }



    def main(args: Array[String]){
        val width = args(0).toInt
        for (arg <- args.drop(1))
            processLine(arg, width)
    }
}
