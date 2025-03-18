package fr.tartur.deminer.display.components

import fr.tartur.deminer.display.SceneHolder
import fr.tartur.deminer.display.game.GameLevel
import fr.tartur.deminer.display.scenes.Game

import java.awt.Color
import javax.swing.border.Border

class SceneButton(label: String, holder: SceneHolder, to: Scenes, textSize: Int = 25, border: Border = null, background: Color = Color.WHITE, foreground: Color = Color.BLACK) extends Button(label, _ => holder.switch(to), textSize, border, background, foreground)
class PlayButton(label: String, holder: SceneHolder) extends SceneButton(label, holder, Scenes.LevelSelector, background = ColorPalette.Blue.color, foreground = Color.WHITE)
class QuitButton(holder: SceneHolder) extends Button("Quit", _ => holder.close(), 25, null, ColorPalette.Red.color, Color.WHITE)
class LevelButton(level: GameLevel, holder: SceneHolder) extends Button(level.value.toString, _ => {
  holder.add(Scenes.Game, Game(level, holder))
  holder.switch(Scenes.Game)
}, 25, null, level.background, level.foreground)