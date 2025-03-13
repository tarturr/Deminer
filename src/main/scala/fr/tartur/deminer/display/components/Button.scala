package fr.tartur.deminer.display.components

import java.awt.{Color, Font}
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.border.Border

open class Button(label: String, textSize: Int = 25, border: Border = null, background: Color = Color.WHITE, foreground: Color = Color.BLACK) extends JButton(label):
  super.setBorder(border)
  super.setBackground(background)
  super.setForeground(foreground)
  super.setFocusable(false)
  super.setFont(Font(Font.SANS_SERIF, Font.PLAIN, textSize))

  def this(label: String, action: ActionListener, textSize: Int, border: Border, background: Color, foreground: Color) =
    this(label, textSize, border, background, foreground)
    super.addActionListener(action)
