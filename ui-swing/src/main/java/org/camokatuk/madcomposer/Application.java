package org.camokatuk.madcomposer;

import org.camokatuk.madcomposer.controlroom.EngineControlRoom;
import org.camokatuk.madcomposer.midi.Engine;
import org.camokatuk.madcomposer.ui.View;

public class Application
{
    public static void main(String[] sd)
    {
        Engine engine = new Engine();
        EngineControlRoom controlRoom = new EngineControlRoom(engine);

        controlRoom.startEngine();

        View view = new View(controlRoom);
        view.initialize();
    }
}