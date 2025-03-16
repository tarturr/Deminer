package fr.tartur.deminer.display.components

import fr.tartur.deminer.display.ImageResources

import java.awt.{BorderLayout, Color, Font}
import java.beans.{PropertyChangeListener, PropertyChangeSupport}
import javax.swing.border.LineBorder
import javax.swing.{ImageIcon, JButton, JComponent, JLabel}

abstract sealed class GameBox(val cellX: Int, val cellY: Int, protected val images: ImageResources, borderColor: ColorPalette = ColorPalette.BorderBox) extends JButton:
  private val support = PropertyChangeSupport(this)
  private var discovered: Boolean = false
  protected val isEven: Boolean = (this.cellX + this.cellY) % 2 == 0

  this.setBorderColor(borderColor)
  super.setFocusable(false)
  super.setLayout(BorderLayout())
  super.setBackground(if this.isEven then ColorPalette.EvenBox.color else ColorPalette.OddBox.color)
  super.addActionListener(_ => if !this.discovered then
    this.onDiscover()
    this.discovered = true
    this.support.firePropertyChange("discovered", null, this)
  )

  def addDiscoverListener(listener: PropertyChangeListener): Unit = this.support.addPropertyChangeListener(listener)
  def isDiscovered: Boolean = this.discovered

  protected def addCenter(component: JComponent): Unit = super.add(component, BorderLayout.CENTER)
  protected def setBorderColor(palette: ColorPalette): Unit =
    if palette != null then
      super.setBorder(LineBorder(palette.color))
    else
      super.setBorder(null)

  protected def onDiscover(): Unit

class BombBox(x: Int, y: Int, images: ImageResources) extends GameBox(x, y, images):
  protected override def onDiscover(): Unit =
    super.setBackground(ColorPalette.Red.color)
    super.setBorderColor(ColorPalette.DarkRed)

class BasicBox(x: Int, y: Int, images: ImageResources) extends GameBox(x, y, images, ColorPalette.BorderBox):
  private var bombs: Int = 0

  def bombsAround: Int = bombs
  def bombsAround_=(value: Int): Unit =
    this.bombs = value

  protected override def onDiscover(): Unit =
    super.setIcon(this.images(this.bombs))
    super.setBackground(if this.isEven then ColorPalette.DEvenBox.color else ColorPalette.DOddBox.color)
    super.setBorder(null)