package day01

import java.io.File

fun main() {
    fun parseElfCalorieGroups(input: String) =
        input.split("\n\n").map { it.lines().map { it.toInt() }.sum() }

    fun part1(input: String): Int {
        val elfCalorieGroups = parseElfCalorieGroups(input)
        return elfCalorieGroups.max()
    }

    fun part2(input: String): Int {
        val elfCalorieGroups = parseElfCalorieGroups(input)
        return elfCalorieGroups.sortedDescending().take(3).sum()
    }

    val testInput = File("src/day01/Day01_test.txt").readText().trim()
    val part1Solution = part1(testInput)
    val part2Solution = part2(testInput)
    println(part1Solution)
    check(part1Solution == 24000)
    check(part2Solution == 45000)

    val input = File("src/day01/Day01.txt").readText().trim()
    println(part1(input))
    println(part2(input))
}
