package zinh

object Lst{
    def append[T](xs: List[T], ys: List[T]): List[T] = xs match {
        case List() => ys
        case hd :: tl => hd::append(tl, ys)
    }

    def length[T](xs: List[T]): Int = length_tail(xs, 0)

    def last[T](lst: List[T]): T = lst match {
        case List(last) => last
        case hd :: tl => last(tl)
    }

    def init[T](lst: List[T]): List[T] = lst match {
        case List(last) => List()
        case hd :: tl => hd::init(tl)
    }

    def reverse[T](lst: List[T]): List[T] = reverse_tail(lst, List())

    def reverse_left[T](lst: List[T]): List[T] = lst.foldLeft(Nil: List[T])((memo: List[T], x: T) => x::memo)

    // merge sort
    def msort[T](less: (T, T) => Boolean)(lst: List[T]): List[T] = {
        def merge(xs: List[T], ys: List[T]): List[T] =
            (xs, ys) match {
                case (Nil, _) =>  ys
                case (_, Nil) => xs
                case (x :: xs1, y :: ys1) => 
                    if (less(x, y)) x::merge(xs1, ys)
                    else y :: merge(xs, ys1)
            }
        val n = lst.length / 2
        if (n == 0)
            lst
        else {
            val (l1, l2) = lst splitAt n
            merge(msort(less)(l1), msort(less)(l2))
        }
    }

    private def reverse_tail[T](lst: List[T], result: List[T]): List[T] = lst match {
        case List() => result
        case hd :: tl => reverse_tail(tl, hd::result)
    }

    private def length_tail[T](xs: List[T], len: Int): Int = xs match {
        case List() => len
        case hd :: tl => length_tail(tl, len + 1)
    }
}
