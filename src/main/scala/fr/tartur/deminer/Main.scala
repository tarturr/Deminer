package fr.tartur.deminer

import fr.tartur.deminer.display.components.Scenes
import fr.tartur.deminer.display.SceneHolder
import fr.tartur.deminer.display.scenes.Menu


@main
def main(): Unit =
  val scenes = SceneHolder()
  scenes.add(Scenes.Menu, Menu(scenes))
  scenes.show()