package fr.tartur.deminer.display

import java.awt.event.WindowEvent
import java.awt.{CardLayout, Component}
import javax.swing.{JFrame, JPanel, WindowConstants}

final class SceneHolder:
  private val window = JFrame("Tartine's Deminer")
  private val cardLayout = CardLayout()
  private val root = JPanel(this.cardLayout)

  window.setSize(500, 500)
  window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
  window.setLocationRelativeTo(null)
  window.add(this.root)

  def add(name: String, comp: Component): Component = this.root.add(name, comp)
  def switch(name: String) = this.cardLayout.show(this.root, name)
  def show() = this.window.setVisible(true)
  def hide() = this.window.setVisible(false)
  def close() = this.window.dispatchEvent(WindowEvent(this.window, WindowEvent.WINDOW_CLOSING))
