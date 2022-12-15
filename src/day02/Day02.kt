package day02

import java.io.File

enum class MyHand(val hand: Char, val scoreWorth: Int) {
    X('R', 1), Y('P', 2), Z('S', 3);
}

enum class OpponentHand(val hand: Char) {
    A('R'), B('P'), C('S');
}

fun scoreGame(theirs: OpponentHand, mine: MyHand): Int = when {
    mine.hand == theirs.hand -> 3
    (mine == MyHand.X && theirs == OpponentHand.C) || (mine == MyHand.Y && theirs == OpponentHand.A) || (mine == MyHand.Z && theirs == OpponentHand.B) -> 6
    else -> 0
} + mine.scoreWorth

fun calculateHand(round: String): Int = when (round) {
    "A X", "B Z", "C Y" -> 3
    "B Y", "C X", "A Z" -> 2
    "A Y", "B X", "C Z" -> 1
    else -> 0
} + (round[2] - 'X') * 3

fun main() {

    fun part1(input: String): Int {
        val games = input.split("\n").map { it.split(" ") }
        println(games)
        val score = games.fold(0) { acc, hands ->
            acc + scoreGame(OpponentHand.valueOf(hands[0]), MyHand.valueOf(hands[1]))
        }
        return score
    }

    fun part2(input: String): Int {
        val games = input.split("\n")
        println(games)
        val score = games.fold(0) { acc, game ->
            acc + calculateHand(game)
        }
        return score
    }

    val testInput = File("src/day02/Day02_test.txt").readText().trim()
    val part1Solution = part1(testInput)
    val part2Solution = part2(testInput)
    println(part1Solution)
    check(part1Solution == 15)
    check(part2Solution == 12)

    val input = File("src/day02/Day02.txt").readText().trim()
    println(part1(input))
    println(part2(input))
}
