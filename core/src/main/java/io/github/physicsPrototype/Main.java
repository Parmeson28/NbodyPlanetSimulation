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

        body = new Body(new Vector3(0, -0.0075f, 0),
                        new Vector3(960f, 540f, 0),
                        new Vector3(0, 0, 0),
                        3300.0f,
                        24.0f,
                    "Sun");
        universe.bodies.add(body);

        // Mercury
        body = new Body(new Vector3(0, 12.34f, 0),
                        new Vector3(960f + 65f, 540f, 0),
                        new Vector3(0, 0, 0),
                        0.0005f,
                        3.0f,
                    "Mercury");
        universe.bodies.add(body);

        // Venus
        body = new Body(new Vector3(0, 9.71f, 0),
                        new Vector3(960f + 105f, 540f, 0),
                        new Vector3(0, 0, 0),
                        0.008f,
                        6.0f,
                    "Venus");
        universe.bodies.add(body);

        // Earth
        body = new Body(new Vector3(0, 8.12f, 0),
                        new Vector3(960f + 150f, 540f, 0),
                        new Vector3(0, 0, 0),
                        0.010f,
                        6.0f,
                    "Earth");
        universe.bodies.add(body);

        // Mars
        body = new Body(new Vector3(0, 7.13f, 0),
                        new Vector3(960f + 195f, 540f, 0),
                        new Vector3(0, 0, 0),
                        0.001f,
                        4.0f,
                    "Mars");
        universe.bodies.add(body);

        // Jupiter
        body = new Body(new Vector3(0, 5.95f, 0),
                        new Vector3(960f + 280f, 540f, 0),
                        new Vector3(0, 0, 0),
                        3.1f,
                        14.0f,
                    "Jupiter");
        universe.bodies.add(body);

        // Saturn
        body = new Body(new Vector3(0, 5.24f, 0),
                        new Vector3(960f + 360f, 540f, 0),
                        new Vector3(0, 0, 0),
                        0.93f,
                        12.0f,
                    "Saturn");
        universe.bodies.add(body);

        // Uranus
        body = new Body(new Vector3(0, 4.80f, 0),
                        new Vector3(960f + 430f, 540f, 0),
                        new Vector3(0, 0, 0),
                        0.14f,
                        8.0f,
                    "Uranus");
        universe.bodies.add(body);

        // Neptune
        body = new Body(new Vector3(0, 4.47f, 0),
                        new Vector3(960f + 495f, 540f, 0),
                        new Vector3(0, 0, 0),
                        0.17f,
                        8.0f,
                    "Neptune");
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
