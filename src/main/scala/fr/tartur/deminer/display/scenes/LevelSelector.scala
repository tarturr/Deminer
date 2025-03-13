package fr.tartur.deminer.display.scenes

import fr.tartur.deminer.display.SceneHolder
import fr.tartur.deminer.display.components.{ColorPalette, LevelButton, SceneButton, Scenes, Title}
import fr.tartur.deminer.display.game.GameLevel

import java.awt.{BorderLayout, Color, FlowLayout, GridLayout}
import javax.swing.JPanel
import javax.swing.border.{EmptyBorder, LineBorder}

class LevelSelector(holder: SceneHolder) extends AbstractMenu(
  Title("Sélection du niveau"),
  {
    val body = JPanel(GridLayout(2, 2, 100, 40))
    body.setBorder(EmptyBorder(0, 100, 0, 100))

    GameLevel.values.foreach(level => body.add(LevelButton(level, holder)))

    body
  },
  {
    val footer = JPanel(FlowLayout(FlowLayout.CENTER))
    footer.setBorder(EmptyBorder(10, 0, 10, 0))
    footer.add(SceneButton("Menu principal", holder, Scenes.Menu, border = LineBorder(ColorPalette.Purple.color, 10), background = ColorPalette.Purple.color), BorderLayout.CENTER)
    footer
  }
)