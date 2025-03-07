package fr.tartur.deminer.display.scenes

import fr.tartur.deminer.display.SceneHolder
import fr.tartur.deminer.display.components.*

import java.awt.GridLayout
import javax.swing.JPanel
import javax.swing.border.EmptyBorder

class Menu(holder: SceneHolder) extends AbstractMenu(
  Title("Tartine's Deminer"),
  {
    val container = JPanel(GridLayout(2, 1, 0, 40))
    container.setBorder(EmptyBorder(0, 40, 40, 40))

    container.add(PlayButton("Play", holder))
    container.add(QuitButton(holder))

    container
  }
)