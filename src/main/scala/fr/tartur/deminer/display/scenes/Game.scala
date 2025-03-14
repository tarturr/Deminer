package fr.tartur.deminer.display.scenes

import fr.tartur.deminer.display.game.{GameBoxContainer, GameLevel}

import java.awt.GridLayout
import javax.swing.JPanel

class Game(level: GameLevel) extends JPanel:
  private val width: Int = 15 + ((level.value - 1) / 4.0 * 20).toInt
  private val area: Int = width * width

  private val bombCount = (area / 10.0).toInt
  private val boxContainer = GameBoxContainer(this.width)

  super.setLayout(GridLayout(this.width, this.width))
  this.boxContainer.plantRandomBombs(this.bombCount)

  for
    y <- 0 until this.width
    x <- 0 until this.width
  do
    super.add(this.boxContainer(x, y))