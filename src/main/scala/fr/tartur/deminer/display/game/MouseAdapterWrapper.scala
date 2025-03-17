package fr.tartur.deminer.display.game

import java.awt.event.{MouseAdapter, MouseEvent}

class MouseAdapterWrapper(private val leftClick: () => Unit, private val rightClick: () => Unit) extends MouseAdapter:
  override def mousePressed(event: MouseEvent): Unit =
    event.getButton match
      case MouseEvent.BUTTON1 => this.leftClick()
      case MouseEvent.BUTTON3 => this.rightClick()