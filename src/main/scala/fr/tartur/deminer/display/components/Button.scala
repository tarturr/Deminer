package fr.tartur.deminer.display.components

import fr.tartur.deminer.display.SceneHolder

import java.awt.Color
import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.{Action, JButton}
import javax.swing.border.Border

sealed class Button(label: String, border: Border = null, background: Color = Color.WHITE, foreground: Color = Color.BLACK) extends JButton(label):
  super.setBorder(border)
  super.setBackground(background)
  super.setForeground(foreground)

  def this(label: String, action: ActionListener, border: Border, background: Color, foreground: Color) =
    this(label, border, background, foreground)
    super.addActionListener(action)

class SceneButton(label: String, holder: SceneHolder, to: Scenes, border: Border = null, background: Color = Color.WHITE, foreground: Color = Color.BLACK) extends Button(label, border, background, foreground):
  super.addActionListener((event) => {
    holder.hide()
    holder.switch(to.toString)
    holder.show()
  })

class PlayButton(label: String, holder: SceneHolder) extends SceneButton(label, holder, Scenes.Game, background = ColorPalette.Blue.color, foreground = Color.WHITE)
class QuitButton(holder: SceneHolder) extends Button("Quit", (_) => holder.close(), null, ColorPalette.Red.color, Color.WHITE)
