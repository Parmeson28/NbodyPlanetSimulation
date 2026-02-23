package io.github.physicsPrototype;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    Universe universe = new Universe();
    Gravity gravity = new Gravity();
    Body body;

    @Override
    public void create() {

        body = new Body(new Vector3(0, 0, 0),
                        new Vector3(100f, 100f, 0),
                        new Vector3(0, 0, 0),
                        700.0f,
                        10.0f,
                    "Terra");

        universe.bodies.add(body);

        body = new Body(new Vector3(0, 0, 0),
                        new Vector3(10f, 50f, 0),
                        new Vector3(0, 0, 0),
                        670.0f,
                        5.0f,
                    "Venus");

        universe.bodies.add(body);

        body = new Body(new Vector3(0, 0, 0),
                        new Vector3(150f, 50f, 0),
                        new Vector3(0, 0, 0),
                        400.0f,
                        3.0f,
                    "Marte");

        universe.bodies.add(body);

        body = new Body(new Vector3(0, 0, 0),
                        new Vector3(75f, 250f, 0),
                        new Vector3(0, 0, 0),
                        1000.0f,
                        15.0f,
                    "Jupiter");

        universe.bodies.add(body);

        body = new Body(new Vector3(0, 0, 0),
                        new Vector3(120f, 150f, 0),
                        new Vector3(0, 0, 0),
                        200.0f,
                        2.0f,
                    "Urano");

        universe.bodies.add(body);

    }

    @Override
    public void render() {
        

        gravity.simulateAttraction(universe.G, universe.bodies);
        
        for(Body body : universe.bodies){

            body.updatePos(Gdx.graphics.getDeltaTime());
        
        }
        

        universe.drawUniverse();
        universe.drawBodies();

    }

    @Override
    public void dispose() {

    }
}
