# About
This engine allows you to implement your own 2D games using Java AWT. It should provide you the necessary basis for games like 
TRON (implementation enclosed), pong, snake etc.

The engine defines interfaces you need to implement and is some cases provides you partially implemented abstract classes
you can base your implementation on, or even fully implemented classes you can use straight on.

This README explains basic structure and principles of the engine, for more details consult javadocs or the TRON game.

# Structure
`listeners` package contains two preimplemented player control mechanisms - classic up-down-left-right arrows and their "WASD: alternative.

`models` package contains the "backend" layer of the game - you'll find things related to game logic there, like `player`, `playground`, `position` etc.

`presentation` package contains the "frontend" layer of the game - it takes care of screen management, drawing of objects and other presentation-related tasks.




# Example
See enclosed implementation of TRON game to see how to fully utilize and benefit from this engine!

# How To implement a Game

Implement your own classes based on:

  *  `PositionTrait`: implement how this should change on signal
  *  `PlayerTrait`: with the help of implemented position, implement its direction change logic
  *  `CollisionDetectorContract` : Handle collisions of players, game objects, etc
  *  `PlayGroundContract` : Implement your holder of players, game objects, and add game ticking logic and GUI object reporting
  *  `controls` : Use existing controls or implement java.awt.(Key/Mouse*)Listener
  *  `DrawerContract`: Implement a class handling drawing and screen management, use the provided ScreenManagerDefault if it fits

Put it all together:
  
  *  Create your players (and game objects if any)
  *  Create a playground and add players, object, collision detectors
  *  Wrap the players into control objects
  *  Create a drawer
  *  Add the control objects to the drawer
  *  Create an Engine
  *  Add the Playground and Drawer to the Engine