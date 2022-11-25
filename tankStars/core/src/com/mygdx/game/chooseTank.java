package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.w3c.dom.Text;

public class chooseTank implements Screen {
    private tankStars game;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private Texture PICK_TANK_ACTIVE;
    private Texture PICK_TANK_INACTIVE;
    private Texture chooseTank;
    private Texture chooseTankBackground1;
    private Texture chooseTankBackground2;
    private Texture logo;
    private Texture abrams;
    private Texture abramsName;
    private Texture helios;
    private Texture frost;
    private Texture goLeft;
    private Texture goRight;
    private Texture goBack;
//    private TextureRegion ;


    public chooseTank(tankStars game){
        this.game = game;
        gameCam = new OrthographicCamera();
        gamePort = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),gameCam);
        gameCam.position.set(((gamePort.getWorldWidth())/2),(gamePort.getWorldHeight()/2),0);


        chooseTankBackground1 = new Texture("images/chooseTankBase.jpg");
        chooseTankBackground2 = new Texture("images/rightSideChooseTank.png");
        PICK_TANK_ACTIVE = new Texture("images/button_lets-rock.png");
        PICK_TANK_INACTIVE = new Texture("images/button_lets-rock_DOWN.png");
        chooseTank = new Texture("images/button_choose-tank.png");
        logo = new Texture("images/Tank_Star_logo.png");
        abrams= new Texture("images/Abramas.png");
        abramsName= new Texture("images/AbramsOnChoose.png");

        helios = new Texture("images/Helios.png");
        frost = new Texture("images/Frost.png");
        goLeft = new Texture("images/goLeft.png");
        goRight = new Texture("images/goRight.png");
        goBack = new Texture("images/goBack.png");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);   //Default Base color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        gameCam.update();
        game.batch.setProjectionMatrix(gameCam.combined);
        game.batch.begin();
        game.batch.draw(chooseTankBackground1, 0,0,1200,1080);
        game.batch.draw(chooseTankBackground2,1100,0,820,1080);
        game.batch.draw(logo, 200,Gdx.graphics.getHeight()-400 );

        game.batch.draw(abrams, 270,100, 700,600);
        game.batch.draw(abramsName, 1270,Gdx.graphics.getHeight()/2-100);
        int NavSize = 60;
        game.batch.draw(goLeft,1110,Gdx.graphics.getHeight()/2-30,NavSize,NavSize);
        game.batch.draw(goRight,Gdx.graphics.getWidth()-100, Gdx.graphics.getHeight()/2-30,NavSize,NavSize);

        game.batch.draw(goBack, 20,Gdx.graphics.getHeight()-120,100,100);
        if (Gdx.input.getX()<120 && Gdx.input.getX()>20 && Gdx.input.getY()<120 && Gdx.input.getY()>20){
            if (Gdx.input.isTouched()){
                game.setScreen(new homeScreen(game));
            }
        }

        int pickWidth, chooseWidth,pickHeight, chooseHeight;
        pickWidth=chooseWidth=400;
        pickHeight= chooseHeight= 100;

        int pickX = Gdx.graphics.getWidth()- 820/2 - pickWidth/2;
        int pickY = 180;
        int chooseX = Gdx.graphics.getWidth()- 820/2 - pickWidth/2;;
        int chooseY = Gdx.graphics.getHeight() - 200 - chooseHeight;

        game.batch.draw(PICK_TANK_ACTIVE, pickX,pickY,pickWidth,pickHeight);
        if (Gdx.input.getX() < pickWidth+pickX && Gdx.input.getX()>pickX && Gdx.graphics.getHeight()-Gdx.input.getY() <  pickY+pickHeight && Gdx.graphics.getHeight()-Gdx.input.getY()>pickY){
            game.batch.draw(PICK_TANK_INACTIVE, pickX,pickY,pickWidth,pickHeight);
            if (Gdx.input.isTouched()){
                game.setScreen(new PlayScreens(game));
            }
        }

        game.batch.draw(chooseTank, chooseX,chooseY,chooseWidth,chooseHeight);

        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
        gameCam.update();
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
}
