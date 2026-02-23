package io.github.physicsPrototype;

import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector3;

public class Body {

    Vector3 speed = new Vector3();
    Vector3 position = new Vector3();
    Vector3 acceleration = new Vector3();

    float mass;
    float radius;
    String name;

    public Body(Vector3 speed, Vector3 position, Vector3 acceleration, float mass, float radius, String name){
        this.speed = speed;
        this.position = position;
        this.acceleration = acceleration;

        this.mass = mass;
        this.radius = radius;
        this.name = name;
    }

    public void updatePos(float dt){

        speed.x += acceleration.x * dt;
        speed.y += acceleration.y * dt;

        position.x += speed.x * dt;
        position.y += speed.y * dt;

        System.out.println(name + " pos: " + position.x + ", " + position.y);

        acceleration.set(0, 0, 0);
        
    }
    
}
