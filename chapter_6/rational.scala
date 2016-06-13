package zinh

class Rational(n: Int, d: Int){
    require(d != 0)
    private val g = gcd(n.abs, d.abs)
    val numer: Int = n / g
    val denom: Int = d / g

    def this(n: Int) = this(n, 1)

    override def toString = numer + "/" + denom

    def + (that: Rational): Rational =
        new Rational(n * that.denom + d * that.numer, d * that.denom)

    def + (that: Int): Rational = new Rational(numer + denom * that, denom)

    def - (that: Rational): Rational =
        new Rational(n * that.denom - d * that.numer, d * that.denom)

    def - (that: Int): Rational =
        new Rational(n - d * that, d)

    def * (that: Rational): Rational =
        new Rational(numer * that.numer, denom * that.denom)

    def * (that: Int): Rational =
        new Rational(that * numer, denom)

    def / (that: Rational): Rational = 
        new Rational(numer * that.denom, denom * that.numer)

    def / (that: Int): Rational =
        new Rational(numer, denom * that)

    def lessThan(that: Rational): Boolean =
        numer * that.denom < that.numer * denom

    def max(that: Rational) = 
        if (lessThan(that)) that else this

    private def gcd(a: Int, b: Int): Int = {
        if (b == 0) a else gcd(b, a % b)
    }
}

object Rational{
    def apply(a: Int, b: Int) = new Rational(a, b)
}
