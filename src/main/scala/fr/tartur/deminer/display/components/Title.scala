package fr.tartur.deminer.display.components

import java.awt.{Color, Font}
import javax.swing.{JLabel, SwingConstants}

class Title(label: String, size: Int = 30, foreground: Color = Color.BLACK) extends JLabel(label):
  super.setFont(Font(Font.SANS_SERIF, Font.PLAIN, size))
  super.setForeground(foreground)
  super.setHorizontalAlignment(SwingConstants.CENTER)