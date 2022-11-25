package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.concurrent.Callable;

public class homeScreen implements Screen {

    private final tankStars game;
    private Texture background;
    private TextureRegion backgroundTexture;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private Texture PLAY_ACTIVE_BUTTON;
    private Texture PLAY_INACTIVE_BUTTON;
    private Texture EXIT_ACTIVE_BUTTON;
    private Texture EXIT_INACTIVE_BUTTON;
    private Texture LOAD_ACTIVE_BUTTON;
    private Texture LOAD_INACTIVE_BUTTON;

    public homeScreen(final tankStars game){
        this.game = game;
        background = new Texture("images/mainScreen2.png");
        backgroundTexture = new TextureRegion(background, 0,0,1920,1080);

        gameCam = new OrthographicCamera();
        gamePort = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),gameCam);
        gameCam.position.set(((gamePort.getWorldWidth())/2),(gamePort.getWorldHeight()/2),0);

        PLAY_ACTIVE_BUTTON = new Texture(Gdx.files.internal("images/button_new-game.png"));
        PLAY_INACTIVE_BUTTON = new Texture(Gdx.files.internal("images/button_new-game_DOWN.png"));
        EXIT_ACTIVE_BUTTON = new Texture(Gdx.files.internal("images/button_exit-game.png"));
        EXIT_INACTIVE_BUTTON = new Texture(Gdx.files.internal("images/button_exit-game_DOWN.png"));
        LOAD_ACTIVE_BUTTON = new Texture(Gdx.files.internal("images/button_load-game.png"));
        LOAD_INACTIVE_BUTTON = new Texture(Gdx.files.internal("images/button_load-game_DOWN.png"));

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
        game.batch.draw(backgroundTexture, 0,0, 1920, 1080);

        int playWidth, exitWidth,playHeight, exitHeight,loadWidth, loadHeight;
        playWidth=loadWidth= exitWidth= 400;
        playHeight= loadHeight=exitHeight = 100;

        int playX = Gdx.graphics.getWidth()/2 - loadWidth/2;
        int playY = 80;
        int exitX = Gdx.graphics.getWidth() - 200 - exitWidth;
        int exitY = 80;
        int loadX = 200;
        int loadY = 80;
        game.batch.draw(PLAY_ACTIVE_BUTTON, playX,playY,playWidth,playHeight);
        if (Gdx.input.getX() < playWidth+playX && Gdx.input.getX()>playX && Gdx.graphics.getHeight()-Gdx.input.getY() <  playY+playHeight && Gdx.graphics.getHeight()-Gdx.input.getY()>playY){
            game.batch.draw(PLAY_INACTIVE_BUTTON, playX,playY,playWidth,playHeight);
            if (Gdx.input.isTouched()){
                game.setScreen(new chooseTank(game));
            }
        }

        game.batch.draw(LOAD_ACTIVE_BUTTON, loadX,loadY,loadWidth,loadHeight);
        if (Gdx.input.getX() < loadWidth+loadX && Gdx.input.getX()>loadX && Gdx.graphics.getHeight()-Gdx.input.getY() <  loadY+loadHeight && Gdx.graphics.getHeight()-Gdx.input.getY()>loadY){
            game.batch.draw(LOAD_INACTIVE_BUTTON, loadX,loadY,loadWidth,loadHeight);
            if (Gdx.input.isTouched()){
                game.setScreen(new chooseTank(game));
            }
        }

        game.batch.draw(EXIT_ACTIVE_BUTTON, exitX,exitY,exitWidth,exitHeight);
        if (Gdx.input.getX() < exitWidth+exitX && Gdx.input.getX()>exitX && Gdx.graphics.getHeight()-Gdx.input.getY() <  playY+playHeight && Gdx.graphics.getHeight()-Gdx.input.getY()>playY){
            game.batch.draw(EXIT_INACTIVE_BUTTON, exitX,exitY,exitWidth,exitHeight);
            if (Gdx.input.isTouched()){
                Gdx.app.exit();
            }
        }

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

        background.dispose();
        backgroundTexture.getTexture().dispose();
        PLAY_ACTIVE_BUTTON.dispose();
        PLAY_INACTIVE_BUTTON.dispose();
        EXIT_ACTIVE_BUTTON.dispose();
        EXIT_INACTIVE_BUTTON.dispose();

    }
}

