package day04

import java.io.File

fun main() {

    fun String.asIntRange() =
        substringBefore('-').toInt()..substringAfter('-').toInt()

    infix fun IntRange.contains(other: IntRange) = first <= other.first && last >= other.last

    infix fun IntRange.overlaps(other: IntRange) = first <= other.last && last >= other.first

    fun part1(input: String): Int {
        val pairs = input.lines().map {
            it.substringBefore(",").asIntRange() to it.substringAfter(",").asIntRange()
        }
        return pairs.count {
            it.first contains it.second || it.second contains it.first
        }
    }

    fun part2(input: String): Int {
        val pairs = input.lines().map {
            it.substringBefore(",").asIntRange() to it.substringAfter(",").asIntRange()
        }
        return pairs.count {
            it.first overlaps it.second || it.second overlaps it.first
        }
    }

    val testInput = File("src/day04/Day04_test.txt").readText().trim()
    val part1Solution = part1(testInput)
    val part2Solution = part2(testInput)
    println(part1Solution)
    check(part1Solution == 2)
    check(part2Solution == 4)

    val input = File("src/day04/Day04.txt").readText().trim()
    println(part1(input))
    println(part2(input))
}
