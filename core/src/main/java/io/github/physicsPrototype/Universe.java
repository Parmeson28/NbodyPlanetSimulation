package io.github.physicsPrototype;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class Universe {

    Array<Body> bodies = new Array<>();
    float G = 10f;
    float dt;
    float speedMultiplier;
    long stepCount;

    public void drawUniverse(){
        
        ScreenUtils.clear(0, 0, 0, 1f);

    }

    public void drawBodies(){

        for(Body body : bodies){

            ShapeRenderer shape = new ShapeRenderer();

            shape.begin(ShapeType.Filled);
            shape.circle(body.position.x, body.position.y, body.radius);
            shape.setColor(Color.GREEN);
            
            shape.end();

        }
        
    }

}
