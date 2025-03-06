package fr.tartur.deminer.display

import fr.tartur.deminer.display.components.{Button, ColorPalette, PlayButton, QuitButton, SceneButton, Scenes, Title}

import java.awt.GridLayout
import javax.swing.JPanel
import javax.swing.border.EmptyBorder

class Menu(holder: SceneHolder) extends JPanel(GridLayout(3, 1)):
  super.setBorder(EmptyBorder(40, 40, 40, 40))
  super.add(Title("Tartine's Deminer"))
  super.add(PlayButton("Play", holder))
  super.add(QuitButton(holder))