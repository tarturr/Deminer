package fr.tartur.deminer.display.components

import fr.tartur.deminer.display.SceneHolder

import java.awt.Color
import javax.swing.border.Border

class SceneButton(label: String, holder: SceneHolder, to: Scenes, textSize: Int = 25, border: Border = null, background: Color = Color.WHITE, foreground: Color = Color.BLACK) extends Button(label, textSize, border, background, foreground):
  super.addActionListener((event) => {
    holder.hide()
    holder.switch(to)
    holder.show()
  })

class PlayButton(label: String, holder: SceneHolder) extends SceneButton(label, holder, Scenes.LevelSelector, background = ColorPalette.Blue.color, foreground = Color.WHITE)
class QuitButton(holder: SceneHolder) extends Button("Quit", (_) => holder.close(), 25, null, ColorPalette.Red.color, Color.WHITE)