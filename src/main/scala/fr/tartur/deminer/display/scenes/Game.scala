package fr.tartur.deminer.display.scenes

import fr.tartur.deminer.display.components.ColorPalette
import fr.tartur.deminer.display.game.GameLevel

import java.awt.GridLayout
import javax.swing.{JButton, JPanel}

class Game(level: GameLevel) extends JPanel:
  private val size: Int = (level.value / 4.0 * 30).toInt

  super.setLayout(GridLayout(this.size, this.size))

  for
    y <- 0 until size
    x <- 0 until size
  do
    val box = JButton()
    box.setBackground(if (x + y) % 2 == 0 then ColorPalette.EvenBox.color else ColorPalette.OddBox.color)
    super.add(box)