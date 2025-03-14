package fr.tartur.deminer.display.components

import java.awt.{BorderLayout, Color}
import javax.swing.{JButton, JComponent, JLabel}

abstract sealed class GameBox(even: Boolean) extends JButton:
  private var discovered: Boolean = false

  super.setLayout(BorderLayout())
  super.setBackground(if even then ColorPalette.EvenBox.color else ColorPalette.OddBox.color)
  super.addActionListener(_ => if !this.discovered then this.onDiscover())

  protected def addCenter(component: JComponent) = super.add(component, BorderLayout.CENTER)
  protected def onDiscover(): Unit

class BombBox(even: Boolean) extends GameBox(even):
  protected override def onDiscover(): Unit = super.setBackground(Color.RED)

class BasicBox(even: Boolean) extends GameBox(even):
  private var bombs: Int = 0
  private val text = JLabel()

  def bombsAround: Int = bombs
  def bombsAround_=(value: Int) =
    this.bombs = value
    this.text.setText(this.bombs.toString)

  protected override def onDiscover(): Unit =
    super.setBackground(Color.WHITE)
    super.addCenter(this.text)