# Persistency2 Readme

## About
Persistency handles saving and loading games, this was done by utilising the Jackson Xml serialization and deserialization library and attaching custom serializer and deserializer to main game entities in order to save and load them into the game, then using a Facade esque pattern where other modules can simply call load and save methods.
## Comments
Made a persistency2 package because at the time, other modules where using Persistency while I wanted to change its functionality so I made persitency2 to allow people to continue using persitency while I made changes on the 2nd one.
## Packages
- `custom`
  - Holds classes related to outside users implementing a CustomMovingEntityService
- `helpers`
  - Helper classes for loading and saving `GameSave` objects
## Classes (The ones that matter)
- `GameSave`
  - represents game state
- `LevelMap`
  - acts as source of truth for tests.
- `GameSaveHelper`
  - Helper class for writing and reading game save objects
  - to load a game save use static method `GameSaveHelper.loadGameSave(Path path)` to load a GameSave object into memory. To save a gameSave object use `GameSaveHelper.saveGameSave(GameSave gameSave)` to save given GameSave to the `SAVE_DIR` directory under name `save-<gamesavehash>.xml`.
- `CustomMovingEntityService`
  - Abstract class to be implemented by service providers