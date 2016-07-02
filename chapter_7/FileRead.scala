package zinh
import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException
import java.net.{URL, MalformedURLException}
object FileRead extends App{
    val filename = 
        if (!args.isEmpty) args(0)
        else "defaults.txt"
    println(filename)

    def gcdLoop(x: Long, y: Long): Long = {
        var a = x
        var b = y
        while (a != 0){
            val temp = a
            a = b % a
            b = temp
        }
        b
    }

    def gcd(x: Long, y: Long): Long =
        if (y ==0) x else gcd(y, x % y)
    println(gcdLoop(10,20))
    println(gcd(25, 50))

    try {
        val f = new FileReader(filename)
        println(f)
    } catch {
        case ex: FileNotFoundException => println("File not found")
        case ex: IOException => println("Cannot read file")
    }

    def urlFor(path: String) = {
        try{
            new URL(path)
        }catch{
            case e: MalformedURLException =>
                new URL("http://google.com")
        }
    }

    def printMultipleTable() = {
        var i = 1
        while (i <= 10) {
            var j = 1
            while (j <= 10){
                val prod = (i * j).toString
                var k = prod.length
                while (k < 4){
                    print(" ")
                    k += 1
                }
                print(prod)
                j += 1
            }
            println()
            i += 1
        }
    }

    def makeRowSeq(n: Int) =
        for (col <- 1 to 10) yield {
            val prod = (n * col).toString
            val padding = " " * (4 - prod.length)
            padding + prod
        }
    def makeRow(row: Int) = makeRowSeq(row).mkString

    def multiTable() = {
        val tableSeq =
            for(row <- 1 to 10) yield makeRow(row)
        tableSeq.mkString("\n")
    }

    println(multiTable)
}
