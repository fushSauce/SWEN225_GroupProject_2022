package nz.ac.vuw.ecs.swen225.gp22.app;

public enum LevelTracker {
    NONE("Start Screen", "") {
        @Override
        public LevelTracker nextLevel() {
            return LevelTracker.LEVEL_ONE;
        }
    },
    LEVEL_ONE("Level One", "level1") {
        @Override
        public LevelTracker nextLevel() {
            return LevelTracker.LEVEL_TWO;
        }
    },
    LEVEL_TWO("Level Two", "level2") {
        @Override
        public LevelTracker nextLevel() {
            return LevelTracker.NONE;
        }
    },
    SAVED_LEVEL("Saved Level", "") {
        @Override
        public LevelTracker nextLevel() {
            return LevelTracker.NONE;
        }
    };

    private final Pair<String, String> currentLevel;

    protected void setCustomPath(String path) {
        currentLevel.setValue(path);
    }

    public String currentName(){
        return currentLevel.key();
    }
    public String currentPath(){
        return currentLevel.value();
    }

    public LevelTracker nextLevel() {
        return LevelTracker.NONE;
    }

    LevelTracker(String levelName, String levelPath) {
        currentLevel = new Pair<>(levelName, levelPath);
    }
}
