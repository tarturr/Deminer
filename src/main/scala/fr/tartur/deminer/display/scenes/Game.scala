package fr.tartur.deminer.display.scenes

import fr.tartur.deminer.display.components.ColorPalette
import fr.tartur.deminer.display.game.GameLevel

import java.awt.{Color, GridLayout}
import javax.swing.{JButton, JPanel}
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class Game(level: GameLevel) extends JPanel:
  private val size: Int = 15 + ((level.value - 1) / 4.0 * 20).toInt
  private val boxCount: Int = size * size
  private val bombCount: Int = (boxCount / 10.0).toInt
  private val bombPositions: Array[Int] =
    val random = Random()
    val positions = ArrayBuffer[Int]()

    for _ <- 1 to bombCount.toInt do
      var position = random nextInt boxCount

      while positions contains position do
        position = random nextInt boxCount

      positions += position

    positions.toArray

  super.setLayout(GridLayout(this.size, this.size))

  for
    y <- 0 until this.size
    x <- 0 until this.size
  do
    val box = JButton()
    val position = x + y * this.size
    var color = ColorPalette.EvenBox.color

    if this.bombPositions contains position then
      color = Color.RED
    else if (x + y) % 2 != 0 then
      color = ColorPalette.OddBox.color

    box.setBackground(color)
    super.add(box)