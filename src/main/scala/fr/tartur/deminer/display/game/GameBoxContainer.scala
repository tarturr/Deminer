package fr.tartur.deminer.display.game

import fr.tartur.deminer.display.components.{BasicBox, BombBox, GameBox}

import scala.util.Random

class GameBoxContainer(private val width: Int):
  private val area = width * width
  private val container = (for position <- 0 until area yield BasicBox(position % 2 == 0)).toArray[GameBox]

  def plantRandomBombs(count: Int) =
    val random = Random()

    for _ <- 1 to count do
      var position = random nextInt this.area

      while this.container(position).isInstanceOf[BombBox] do
        position = random nextInt this.area

      this.plant(position)

  private def plant(position: Int) =
    this.container(position) = BombBox(position % 2 == 0)
    val (x, y): (Int, Int) = (position % this.width, position / this.width)

    this.neighbors(x, y).foreach(box => {
      box.bombsAround += 1
      println(s"Found neighbor at ($x, $y). Bombs around: ${box.bombsAround}")
    })

  private def neighbors(x: Int, y: Int): Array[BasicBox] = (
    for
      y <- y - 1 until y + 1
      x <- x - 1 until x + 1
      if this.exists(x, y) && this(x, y).isInstanceOf[BasicBox]
    yield
      this(x, y).asInstanceOf[BasicBox]
    ).toArray

  private def exists(x: Int, y: Int): Boolean =
    val range = 0 until this.width
    range.contains(x) && range.contains(y)

  def apply(x: Int, y: Int) =
    if !this.exists(x, y) then
      throw IndexOutOfBoundsException("Trying to reach a game box at an out of bounds position")

    this.container(y * this.width + x)