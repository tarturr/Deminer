package fr.tartur.deminer.display.scenes

import fr.tartur.deminer.display.SceneHolder
import fr.tartur.deminer.display.components.{BasicBox, BombBox, GameBox, Scenes}
import fr.tartur.deminer.display.game.{GameBoxContainer, GameLevel}

import java.awt.GridLayout
import java.beans.{PropertyChangeEvent, PropertyChangeListener}
import java.util.Timer
import javax.swing.JPanel

class Game(level: GameLevel, private val holder: SceneHolder) extends JPanel, PropertyChangeListener:
  private val width: Int = 15 + ((level.value - 1) / 4.0 * 20).toInt
  private val area: Int = width * width
  private val bombCount = (area / 10.0).toInt
  private val boxContainer = GameBoxContainer(this.width)

  private val timer = Timer()
  private var seconds: Int = 0
  private var boxCount: Int = area - bombCount

  super.setLayout(GridLayout(this.width, this.width))
  this.boxContainer.plantRandomBombs(this.bombCount)
  this.timer.schedule(() => this.seconds += 1, 0L, 1000L)

  for
    y <- 0 until this.width
    x <- 0 until this.width
  do
    val box: GameBox = this.boxContainer(x, y)
    box.addDiscoverListener(this)
    super.add(box)

  private def recursiveDiscover(basicBox: BasicBox): Unit =
    basicBox.discover(false)
    this.boxCount -= 1

    if basicBox.bombsAround == 0 then
      this.boxContainer.neighbors(basicBox.cellX, basicBox.cellY).foreach(box => if !box.isDiscovered then this.recursiveDiscover(box))

  // TODO: Make the game "freeze", so that the player cannot hit other game boxes.
  private def lose(start: BombBox): Unit =
    this.timer.cancel()
    val bombs = this.boxContainer.bombs()
    var index = bombs.size - 1

    val delayedExplosion = Timer()

    delayedExplosion.scheduleAtFixedRate(() => {
      var current = bombs(index)

      if current == start then
        index -= 1

      if index >= 0 then
        current = bombs(index)
        current.discover(false)

      if index <= 0 then
        delayedExplosion.cancel()
      else
        index -= 1
    }, 500L, 500L)

  override def propertyChange(event: PropertyChangeEvent): Unit =
    val operation = event.getPropertyName

    if !operation.equals("discovered") then
      throw UnsupportedOperationException(s"Unsupported operation: $operation")

    val discoveredByUser = event.getOldValue.asInstanceOf[Boolean]
    val box = event.getNewValue.asInstanceOf[GameBox]

    if discoveredByUser then
      box match
        case basic: BasicBox => this.recursiveDiscover(basic)
        case bomb: BombBox => this.lose(bomb)

      if this.boxCount == 0 then
        this.holder.force(Scenes.GameOver, GameWon(this.seconds, this.holder))