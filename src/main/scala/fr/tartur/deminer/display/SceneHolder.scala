package fr.tartur.deminer.display

import fr.tartur.deminer.display.components.Scenes

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

  def add(scene: Scenes, comp: Component): Component = this.root.add(scene.toString, comp)
  def switch(scene: Scenes) = this.cardLayout.show(this.root, scene.toString)
  def show() = this.window.setVisible(true)
  def hide() = this.window.setVisible(false)
  def close() = this.window.dispatchEvent(WindowEvent(this.window, WindowEvent.WINDOW_CLOSING))
