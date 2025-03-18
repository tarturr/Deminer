package fr.tartur.deminer.display.scenes

import fr.tartur.deminer.display.components.{BasicBox, GameBox}
import fr.tartur.deminer.display.game.{GameBoxContainer, GameLevel}

import java.awt.GridLayout
import java.beans.{PropertyChangeEvent, PropertyChangeListener}
import javax.swing.JPanel

class Game(level: GameLevel) extends JPanel, PropertyChangeListener:
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
    val box: GameBox = this.boxContainer(x, y)
    box.addDiscoverListener(this)
    super.add(box)

  private def recursiveDiscover(basicBox: BasicBox): Unit =
    basicBox.discover()

    if basicBox.bombsAround == 0 then
      this.boxContainer.neighbors(basicBox.cellX, basicBox.cellY).foreach(box => if !box.isDiscovered then this.recursiveDiscover(box))

  override def propertyChange(event: PropertyChangeEvent): Unit =
    val operation = event.getPropertyName

    if !operation.equals("discovered") then
      throw UnsupportedOperationException(s"Unsupported operation: $operation")

    val box = event.getNewValue.asInstanceOf[GameBox]

    box match
      case basic: BasicBox => this.recursiveDiscover(basic)
      case _ => ???