package fr.tartur.deminer.display.scenes

import fr.tartur.deminer.display.SceneHolder
import fr.tartur.deminer.display.components.*

import java.awt.GridLayout
import javax.swing.JPanel
import javax.swing.border.EmptyBorder

class Menu(holder: SceneHolder) extends JPanel(GridLayout(3, 1, 0, 40)):
  super.setBorder(EmptyBorder(80, 40, 80, 40))
  super.add(Title("Tartine's Deminer"))
  super.add(PlayButton("Play", holder))
  super.add(QuitButton(holder))