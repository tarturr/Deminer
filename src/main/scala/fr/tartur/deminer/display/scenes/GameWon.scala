package fr.tartur.deminer.display.scenes

import fr.tartur.deminer.display.SceneHolder
import fr.tartur.deminer.display.components.PlayButton

import java.awt.GridLayout
import javax.swing.{Box, JLabel, JPanel}

class GameWon(seconds: Int, holder: SceneHolder) extends JPanel(GridLayout(4, 1, 0, 20)):
  super.add(Box.createVerticalStrut(50))
  super.add(JLabel(s"Bravo, vous avez gagné en $seconds !"))
  super.add(PlayButton("Rejouer", holder))
  super.add(Box.createVerticalStrut(50))