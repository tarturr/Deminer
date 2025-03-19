package fr.tartur.deminer.display.game

import fr.tartur.deminer.display.ImageResources
import fr.tartur.deminer.display.components.{BasicBox, BombBox, GameBox}

import scala.util.Random

class GameBoxContainer(private val width: Int):
  private val images = ImageResources(32)
  private val area = width * width
  private val container = (
    for
      y <- 0 until this.width
      x <- 0 until this.width
    yield
      val box = BasicBox(x, y, images)
      box
  ).toArray[GameBox]

  def plantRandomBombs(count: Int): Unit =
    val random = Random()

    for _ <- 1 to count do
      var coords = this.randomCoords(random)

      while this.container(this.toIndex(coords._1, coords._2)).isInstanceOf[BombBox] do
        coords = this.randomCoords(random)

      this.plant(coords._1, coords._2)

  def neighbors(x: Int, y: Int): Array[BasicBox] = (
    for
      y <- y - 1 to y + 1
      x <- x - 1 to x + 1
      if this.exists(x, y) && this(x, y).isInstanceOf[BasicBox]
    yield
      this(x, y).asInstanceOf[BasicBox]
    ).toArray

  def bombs(): Array[BombBox] =
    this.container.filter(_.isInstanceOf[BombBox])
      .map(box => box.asInstanceOf[BombBox])
      .toArray

  def apply(x: Int, y: Int): GameBox =
    if !this.exists(x, y) then
      throw IndexOutOfBoundsException("Trying to reach a game box at an out of bounds position")

    this.container(this.toIndex(x, y))

  private def plant(x: Int, y: Int): Unit =
    val bomb = BombBox(x, y, images)
    this.container(this.toIndex(x, y)) = bomb

    this.neighbors(x, y).foreach(box => box.bombsAround += 1)

  private def exists(x: Int, y: Int): Boolean =
    val range = 0 until this.width
    range.contains(x) && range.contains(y)

  private def toIndex(x: Int, y: Int): Int = y * this.width + x
  private def randomCoords(seed: Random): (Int, Int) = (seed nextInt this.width, seed nextInt this.width)