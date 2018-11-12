package fintech.homework07

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable

class SortingSpec extends FlatSpec with Matchers {

  "Merge sorting" should "work correct with ints" in {
    val a = mutable.MutableList(1, 2, 4, 3)
    Sorting.mergeSort(a)
    a should be(mutable.MutableList(1, 2, 3, 4))

    val b = mutable.MutableList(4, 3, 2, 1, 0, -1, -2)
    Sorting.mergeSort(b)
    b should be(mutable.MutableList(-2, -1, 0, 1, 2, 3, 4))

    val c = mutable.MutableList(1, 2, 3, 4)
    Sorting.mergeSort(c)
    c should be(mutable.MutableList(1, 2, 3, 4))

    val d = mutable.MutableList(1, 1, 1)
    Sorting.mergeSort(d)
    d should be(mutable.MutableList(1, 1, 1))

    val e = mutable.MutableList(1)
    Sorting.mergeSort(e)
    e should be(mutable.MutableList(1))
  }

  "Merge sorting" should "work correct with other types" in {
    val a = mutable.MutableList(1.1, 2.0, 4.6, 4.61, -3)
    Sorting.mergeSort(a)
    a should be(mutable.MutableList(-3, 1.1, 2.0, 4.6, 4.61))

    val b = mutable.MutableList('a', 'd', 'b', '1')
    Sorting.mergeSort(b)
    b should be(mutable.MutableList('1', 'a', 'b', 'd'))

    val c = mutable.MutableList("aba", "a", "aa")
    Sorting.mergeSort(c)
    c should be(mutable.MutableList("a", "aa", "aba"))
  }

  "Quick sorting" should "work correct with ints" in {
    val a = mutable.IndexedSeq(1, 2, 4, 3)
    Sorting.quickSort(a)
    a should be(mutable.IndexedSeq(1, 2, 3, 4))

    val b = mutable.IndexedSeq(4, 3, 2, 1, 0, -1, -2)
    Sorting.quickSort(b)
    b should be(mutable.IndexedSeq(-2, -1, 0, 1, 2, 3, 4))

    val c = mutable.IndexedSeq(1, 2, 3, 4)
    Sorting.quickSort(c)
    c should be(mutable.IndexedSeq(1, 2, 3, 4))

    val d = mutable.IndexedSeq(1, 1, 1)
    Sorting.quickSort(d)
    d should be(mutable.IndexedSeq(1, 1, 1))

    val e = mutable.IndexedSeq(1)
    Sorting.quickSort(e)
    e should be(mutable.IndexedSeq(1))
  }

  "Quick sorting" should "work correct with other types" in {
    val a = mutable.IndexedSeq(1.1, 2.0, 4.6, 4.61, -3)
    Sorting.quickSort(a)
    a should be(mutable.IndexedSeq(-3, 1.1, 2.0, 4.6, 4.61))

    val b = mutable.IndexedSeq('a', 'd', 'b', '1')
    Sorting.quickSort(b)
    b should be(mutable.IndexedSeq('1', 'a', 'b', 'd'))

    val c = mutable.IndexedSeq("aba", "a", "aa")
    Sorting.quickSort(c)
    c should be(mutable.IndexedSeq("a", "aa", "aba"))
  }
}
