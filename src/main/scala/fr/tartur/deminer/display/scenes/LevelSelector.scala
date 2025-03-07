package fr.tartur.deminer.display.scenes

import fr.tartur.deminer.display.SceneHolder
import fr.tartur.deminer.display.components.{ColorPalette, SceneButton, Scenes, Title}

import java.awt.{BorderLayout, Color, FlowLayout, GridLayout}
import javax.swing.JPanel
import javax.swing.border.{EmptyBorder, LineBorder}

class LevelSelector(holder: SceneHolder) extends AbstractMenu(
  Title("Sélection du niveau"),
  {
    val body = JPanel(GridLayout(2, 2, 100, 40))
    body.setBorder(EmptyBorder(0, 100, 0, 100))

    body.add(SceneButton("1", holder, Scenes.Game, background = ColorPalette.Green.color))
    body.add(SceneButton("2", holder, Scenes.Game, background = ColorPalette.Blue.color))
    body.add(SceneButton("3", holder, Scenes.Game, background = ColorPalette.Red.color))
    body.add(SceneButton("4", holder, Scenes.Game, background = Color.BLACK, foreground = Color.WHITE))

    body
  },
  {
    val footer = JPanel(FlowLayout(FlowLayout.CENTER))
    footer.setBorder(EmptyBorder(10, 0, 10, 0))
    footer.add(SceneButton("Menu principal", holder, Scenes.Menu, border = LineBorder(ColorPalette.Purple.color, 10), background = ColorPalette.Purple.color), BorderLayout.CENTER)
    footer
  }
)