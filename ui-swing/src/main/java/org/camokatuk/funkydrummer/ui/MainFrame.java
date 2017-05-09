package org.camokatuk.funkydrummer.ui;

import org.camokatuk.funkydrummer.control.EngineControlRoom;
import org.camokatuk.funkydrummer.ui.playback.BpmChangeListener;
import org.camokatuk.funkydrummer.ui.playback.TestListener;

import javax.swing.*;

public class MainFrame extends JFrame
{
    private final EngineControlRoom controlRoom;

    public MainFrame(EngineControlRoom controlRoom)
    {
        this.controlRoom = controlRoom;
        this.initialize();
    }

    private void initialize()
    {
        this.addPlaybackControls(controlRoom);
        this.pack();
    }

    private void addPlaybackControls(EngineControlRoom controlRoom)
    {
        final JToolBar toolBar = new JToolBar();

        JTextField textField = new JTextField(Integer.toString(controlRoom.getStateMonitor().getBpm()), 3);
        textField.getDocument().addDocumentListener(new BpmChangeListener(controlRoom));
        toolBar.add(textField);

        JButton button = new JButton("Test");
        button.addActionListener(new TestListener(controlRoom));
        toolBar.add(button);

        this.getContentPane().add(toolBar);
    }
}