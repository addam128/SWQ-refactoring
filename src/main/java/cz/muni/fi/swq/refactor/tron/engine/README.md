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
