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
                        new Vector3(250f, 250f, 0),
                        new Vector3(0, 0, 0),
                        3300.0f,
                        10.0f,
                    "Sun");

        universe.bodies.add(body);

        body = new Body(new Vector3(0, -10f, 0),
                        new Vector3(250f + 100f, 250f, 0),
                        new Vector3(0, 0f, 0),
                        8.0f,
                        3.0f,
                    "Venus");

        universe.bodies.add(body);


        body = new Body(new Vector3(0, 10f, 0),
                        new Vector3(250f + 150f, 250f, 0),
                        new Vector3(0, 0f, 0),
                        10.0f,
                        3.0f,
                    "Earth");

        universe.bodies.add(body);

    }

    @Override
    public void render() {
        
        float dt = Gdx.graphics.getDeltaTime();

        
        for(Body body : universe.bodies){

            body.halfTimeSpeedAndPos(dt);
        
        }

        gravity.simulateAttraction(universe.G, universe.bodies);
        

        for(Body body : universe.bodies){

            body.halfTimeSpeed(dt);

        }
        

        universe.drawUniverse();
        universe.drawBodies();

    }

    @Override
    public void dispose() {

    }
}
