package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.awt.*;

import static com.badlogic.gdx.Gdx.input;

public class Tanks extends InputAdapter implements Screen {

    public World world;
    private PlayScreens game;
    public Body b2body;

//    private Stage stage;
//    private Texture tank1;
//    private Texture tank2;
//    private float tank1X;
//    private float tank2X;
//    private float tank1Y;
//    private float tank2Y;
//
//    public float getTank1X() {return tank1X;}
//    public void setTank1X(float tank1X) {this.tank1X = tank1X;}
//    public float getTank1Y() {return tank1Y;}
//    public void setTank1Y(float tank1Y) {this.tank1Y = tank1Y;}
//
//    public float getTank2X() {return tank2X;}
//    public void setTank2X(float tank2X) {this.tank2X = tank2X;}
//    public float getTank2Y() {return tank2Y;}
//    public void setTank2Y(float tank2Y) {this.tank2Y = tank2Y;}
//

    Tanks(PlayScreens game){
        this.world = world;
        defineTank();
//        tank1= new Texture("chooseTank1.png");
//        tank2= new Texture("chooseTank2.png");
//        stage = new Stage();
//        game.batch = new SpriteBatch();
    }

    public void defineTank(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(800,800);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(100);

//        System.out.println(shape.getPosition());;
        fdef.shape = shape;
        b2body.createFixture(fdef);

    }

    @Override
    public void show() {

    }

    public void handleInput(float dt){
//        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) ){
//            tank1X += 100*dt;
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) ){
//            tank1X -= 100*dt;
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.D) ){
//            tank2X += 100*dt;
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.A) ){
//            tank2X -= 100*dt;
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.UP) ){
//            tank1Y += 100*dt;
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.W) ){
//            tank2Y += 100*dt;
//        }

    }
    @Override
    public void render(float delta) {
//        Gdx.gl.glClearColor(0,0,0,1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        game.batch.begin();
//        stage.draw();
//        game.batch.draw(tank1, tank1X, tank1Y);
//
//        game.batch.begin();
//        game.batch.draw(tank2, tank2X, tank2Y);
//        Rectangle sampleRect = new Rectangle();
//        sampleRect.setRect(800,800,200,400);
//
//        Gdx.input.setInputProcessor(stage);
//        handleInput(delta);
//
//        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

//    private int health;
//    private String attack1;
//    private String attack2;
//    private String attack3;
//    private String attack4;
//    private String attack5;




}

