package fr.tartur.deminer.display.components

import fr.tartur.deminer.display.ImageResources

import java.awt.{BorderLayout, Color, Font}
import java.beans.{PropertyChangeListener, PropertyChangeSupport}
import javax.swing.{ImageIcon, JButton, JComponent, JLabel}

abstract sealed class GameBox(val cellX: Int, val cellY: Int, protected val images: ImageResources) extends JButton:
  private val support = PropertyChangeSupport(this)
  private var discovered: Boolean = false

  super.setBorder(null)
  super.setFocusable(false)
  super.setLayout(BorderLayout())
  super.setBackground(if (this.cellX + this.cellY) % 2 == 0 then ColorPalette.EvenBox.color else ColorPalette.OddBox.color)
  super.addActionListener(_ => if !this.discovered then
    this.onDiscover()
    this.discovered = true
    this.support.firePropertyChange("discovered", null, this)
  )

  def addDiscoverListener(listener: PropertyChangeListener): Unit = this.support.addPropertyChangeListener(listener)
  def isDiscovered: Boolean = this.discovered

  protected def addCenter(component: JComponent): Unit = super.add(component, BorderLayout.CENTER)
  protected def onDiscover(): Unit

class BombBox(x: Int, y: Int, images: ImageResources) extends GameBox(x, y, images):
  protected override def onDiscover(): Unit = super.setBackground(Color.RED)

class BasicBox(x: Int, y: Int, images: ImageResources) extends GameBox(x, y, images):
  private var bombs: Int = 0

  def bombsAround: Int = bombs
  def bombsAround_=(value: Int): Unit =
    this.bombs = value

  protected override def onDiscover(): Unit =
    super.setIcon(this.images(this.bombs))
    super.setBackground(Color.WHITE)