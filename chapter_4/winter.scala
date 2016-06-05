package zinh
import zinh.ChecksumAccumulator.calculate

object Winter extends App {
    for (season <- List("summer", "autumn", "winter", "spring"))
        println(season + ": " + ChecksumAccumulator.calculate(season))
}
