package fr.tartur.deminer.display.scenes

import fr.tartur.deminer.display.components.Title

import java.awt.{BorderLayout, GridLayout, LayoutManager}
import javax.swing.JPanel

abstract class AbstractMenu private (layout: LayoutManager) extends JPanel(layout):
  protected def this(title: Title, body: JPanel, footer: JPanel) =
    this(BorderLayout(0, 50))

    val gridContainer = JPanel(GridLayout(2, 1))
    gridContainer.add(title)
    gridContainer.add(body)

    super.add(gridContainer, BorderLayout.CENTER)
    super.add(footer, BorderLayout.SOUTH)

  protected def this(title: Title, body: JPanel) =
    this(GridLayout(2, 1))

    super.add(title)
    super.add(body)