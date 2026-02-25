# NbodySimulation

## GOALS
The main goal of this project is to further my studies in computer physics simulations.

My choice for Java and the LibGDX library is determined by my familiarity with the language and the library in previous projects. Also, LibGDX provides a good performance with a less complex syntax if compared to a lower level alternative such as pure OpenGL.

## First implementations
At first, my goal was to make it functional so I implemented the Newton's Law of Gravitation (defined below).
The force is calculated each frame by a O(N²) nested for loop, which takes the information of the bodies from an array that stores them.
There's a Body class which is used to create new bodies which contain speed, acceleration, mass, radius, and position. 
If two bodies collide, they will merge into each other. The one with more mass will "absorb" the other.

Newton's Law of Gravitation -> F = G * (m1 * m2)/r²

F -> Resulting force

G -> Gravitational Constant

m -> Mass of the bodies

r -> Distance between the bodies

## Leapfrog integration
Leapfrog integration algorithm is used for a more realistic approach for updating the position of the bodies. In the previous method, we passed an old velocity value to update the body position, which doesn't happen now because velocity is always half step ahead of position, and the program recalculates the velocity in between the execution of two methods.

Half time update (add half of the acceleration to velocity then updates position) -> Calculate force based on Newton's Law of Gravitation -> Half time update (add half of the acceleration to velocity based on the updated position)

Reference: https://jduarte.physics.ucsd.edu/phys141/_downloads/98b2b44e12426a0a101effebb1ad7144/leapfrog.pdf

Next step:
Barnes-Hut
Reference: https://www1.univap.br/irapuan/Tese/treecode/treecode.htm


A [libGDX](https://libgdx.com/) project generated with [gdx-liftoff](https://github.com/libgdx/gdx-liftoff).

This project was generated with a template including simple application launchers and an `ApplicationAdapter` extension that draws libGDX logo.

## Platforms

- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3; was called 'desktop' in older docs.

## Gradle

This project uses [Gradle](https://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `build`: builds sources and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/libs`.
- `lwjgl3:run`: starts the application.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.
