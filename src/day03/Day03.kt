package day03

import java.io.File

fun main() {

    fun prioritiseItem(it: Char) = if (it.isUpperCase())
        (it - 'A' + 27)
    else
        (it - 'a' + 1)

    fun part1(input: String): Int {
        val rucksacks = input.lines()
        val duplicateItems = rucksacks.flatMap {
            val (first, second) = it.chunked(it.length / 2) { it.toSet() }
            val intersect = first intersect second
            intersect
        }
        return duplicateItems.sumOf { prioritiseItem(it) }
    }

    fun part2(input: String): Int {
        val rucksacks = input.lines().map { it.toSet() }
        val compartments = rucksacks.chunked(3).flatMap {
            it.reduce(Set<Char>::intersect)
        }
        return compartments.sumOf { prioritiseItem(it) }
    }

    val testInput = File("src/day03/Day03_test.txt").readText().trim()
    val part1Solution = part1(testInput)
    val part2Solution = part2(testInput)
    println(part1Solution)
    check(part1Solution == 157)
    check(part2Solution == 70)

    val input = File("src/day03/Day03.txt").readText().trim()
    println(part1(input))
    println(part2(input))
}
