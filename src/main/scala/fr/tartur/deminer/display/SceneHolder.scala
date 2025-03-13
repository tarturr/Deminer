package fr.tartur.deminer.display

import fr.tartur.deminer.display.components.Scenes

import java.awt.event.WindowEvent
import java.awt.{CardLayout, Component}
import javax.swing.{JFrame, JPanel, WindowConstants}

final class SceneHolder:
  private val window = JFrame("Tartine's Deminer")
  private val cardLayout = CardLayout()
  private val root = JPanel(this.cardLayout)

  window.setSize(800, 800)
  window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
  window.setLocationRelativeTo(null)
  window.add(this.root)

  def add(scene: Scenes, component: Component): Component = this.root.add(scene.toString, component)
  def switch(scene: Scenes) = this.cardLayout.show(this.root, scene.toString)
  def force(scene: Scenes, component: Component) =
    this.add(scene, component)
    this.switch(scene)

  def show() = this.window.setVisible(true)
  def hide() = this.window.setVisible(false)
  def close() = this.window.dispatchEvent(WindowEvent(this.window, WindowEvent.WINDOW_CLOSING))
