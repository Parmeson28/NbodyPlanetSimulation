package io.github.physicsPrototype;

import com.badlogic.gdx.utils.Array;

public class Gravity {

    //, float G, float d, float m1, float m2
    public void simulateAttraction(float G, Array<Body> bodies){

        for(int i = 0; i < bodies.size; i++){
            for(int j = i + 1; j < bodies.size; j++){

                Body actualBody = bodies.get(i);
                Body nextBody = bodies.get(j);

                float m1 = actualBody.mass;
                float m2 = nextBody.mass;

                float dx = (nextBody.position.x - actualBody.position.x);
                float dy = (nextBody.position.y - actualBody.position.y);

                float d = (float) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)); 

                float F = (float) ((G * m1 * m2) / (Math.pow(d, 2.0)));
                
                F = Math.min(F, 1000f);

                System.out.println(F);

                float fx = F * (dx/d);
                float fy = F * (dy/d);
                
                actualBody.acceleration.x += fx / actualBody.mass;
                actualBody.acceleration.y += fy / actualBody.mass;

                nextBody.acceleration.x -= fx / nextBody.mass;
                nextBody.acceleration.y -= fy / nextBody.mass;

            }
        }

    }
}