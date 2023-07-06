package nz.ac.vuw.ecs.swen225.gp22.app;

import nz.ac.vuw.ecs.swen225.gp22.domain.Domain;
import nz.ac.vuw.ecs.swen225.gp22.renderer.Render;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// ------------------------------------------------
// NEEDS MAJOR REFACTORING TO REMOVE DUPLICATE CODE
// You should not need an interface here. A single
// record called "Level" should be enough.
// ------------------------------------------------

/**
 * Represents level one of chip's challenge.
 *
 * @author niamh
 */
record Level(LevelTracker levelInfo, Domain domain, Render gameplayPanel) implements GameState {
    @Override
    public List<JPanel> panels() {
        JPanel timerPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                FontMetrics fm = g2d.getFontMetrics();

                g.setColor(Color.GRAY);
                g.fillRect(0, 0, getWidth(), getHeight());

                g.setColor(Color.GREEN);
                String currentlyDrawing = levelInfo().currentName();
                g.drawString(currentlyDrawing, getWidth() / 2 - fm.stringWidth(currentlyDrawing) / 2, 50);
                currentlyDrawing = "Time Remaining: " + GameClock.get().currentLevelTime() / 1000;
                g.drawString(currentlyDrawing, getWidth() / 2 - fm.stringWidth(currentlyDrawing) / 2, getHeight() / 2 - 100);

                var level = domain.getLevel().orElseThrow(() -> new Error("No level was found."));
                var chipsRemaining = level.getRemainingTreasures();

                currentlyDrawing = "Sphynxes Remaining: " + chipsRemaining;
                g.drawString(currentlyDrawing, getWidth() / 2 - fm.stringWidth(currentlyDrawing) / 2, getHeight() - 250);
            }
        };
        timerPanel.setPreferredSize(new Dimension(200, 480));
        timerPanel.setFocusable(false);

        gameplayPanel.setPreferredSize(new Dimension(480, 480));
        gameplayPanel.setFocusable(false);
        return List.of(gameplayPanel, timerPanel);
    }

    @Override
    public GameState nextLevel() {
        if (levelInfo.nextLevel().currentName().equals("Start Screen")) return new StartScreen();
        return new Level(levelInfo.nextLevel(), domain, new Render());
    }
}