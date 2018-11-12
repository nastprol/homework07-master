package fintech.homework07

import scala.collection.mutable

/**
  * Реализовать алгоритмы quick-sort и merge-sort
  * использую *подходящие* *мутабельные* коллекции
  */

object Sorting {

  def mergeSort[T](arr: mutable.MutableList[T])(implicit ordering: Ordering[T]): Unit = {

    def sort(arr: mutable.MutableList[T]): mutable.MutableList[T] = {
      val length = arr.length
      if (length == 1) return arr

      def merge(l: mutable.MutableList[T], r: mutable.MutableList[T]): mutable.MutableList[T] = {
        (l, r) match {
          case (mutable.MutableList(), _) => r
          case (_, mutable.MutableList()) | (mutable.MutableList(), mutable.MutableList()) => l
          case (_, _) =>
            if (ordering.compare(l.head, r.head) < 0) l.head +: merge(l.tail, r)
            else r.head +: merge(l, r.tail)
        }
      }

      val m = length / 2
      val (l, r) = arr.splitAt(m)
      merge(sort(l), sort(r))
    }

    val sorted: mutable.MutableList[T] = sort(arr)
    var i = 0
    for (e <- sorted) {
      arr.update(i, e)
      i += 1
    }
  }

  def quickSort[T](arr: mutable.IndexedSeq[T])(implicit ordering: Ordering[T]): Unit = {

    qsort(0, arr.length - 1)

    def qsort(left: Int, right: Int): Unit = {

      def swap(a: mutable.IndexedSeq[T], i: Int, j: Int): Unit = {
        val t = a(i)
        a.update(i, a(j))
        a.update(j, t)
      }

      var l = left
      var r = right
      val m: Int = (l + r) / 2
      val pivot = arr(m)
      while (l <= r) {
        while (ordering.compare(arr(l), pivot) < 0) l += 1
        while (ordering.compare(arr(r), pivot) > 0) r -= 1
        if (l <= r) {
          swap(arr, l, r)
          l += 1
          r -= 1
        }
      }
      if (left < r) qsort(left, r)
      if (l < right) qsort(l, right)
    }
  }
}