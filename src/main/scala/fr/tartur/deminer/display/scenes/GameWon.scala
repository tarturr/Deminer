package fr.tartur.deminer.display.scenes

import fr.tartur.deminer.display.SceneHolder
import fr.tartur.deminer.display.components.{PlayButton, Title}

import java.awt.GridLayout
import javax.swing.{Box, JPanel}

class GameWon(seconds: Int, holder: SceneHolder) extends AbstractMenu(
  Title(s"Bravo, vous avez gagné en $seconds secondes !"),
  {
    val body = JPanel(GridLayout(2, 1))

    val button = JPanel(GridLayout(1, 3))
    button.add(Box.createHorizontalGlue())
    button.add(PlayButton("Rejouer", holder))
    button.add(Box.createHorizontalGlue())

    body.add(button)
    body.add(Box.createHorizontalGlue())
    body
  }
)