package fr.tartur.deminer

import fr.tartur.deminer.display.components.Scenes
import fr.tartur.deminer.display.SceneHolder
import fr.tartur.deminer.display.scenes.{LevelSelector, Menu}

@main
def main(): Unit =
  val holder = SceneHolder()
  holder.add(Scenes.Menu, Menu(holder))
  holder.add(Scenes.LevelSelector, LevelSelector(holder))
  holder.show()