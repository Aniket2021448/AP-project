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

    final tankStars game;
    private Texture background;
    private TextureRegion backgroundTexture;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private Stage stage;
    private Skin mySkin;
    private Button startButton, resumeButton, exitButton;
    private TextureAtlas atlas;

    public homeScreen(final tankStars game){
        this.game = game;
        background = new Texture("images/mainScreen2.png");
        backgroundTexture = new TextureRegion(background, 0,0,1920,1080);

        gameCam = new OrthographicCamera();
        gamePort = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),gameCam);
        gameCam.position.set(((gamePort.getWorldWidth())/2),(gamePort.getWorldHeight()/2),0);

        mySkin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        stage = new Stage(gamePort);
        Gdx.input.setInputProcessor(stage);

        startButton = new TextButton("START GAME",mySkin, "small");
        startButton.setSize(480, 240);
        startButton.setPosition(Gdx.graphics.getWidth()/2 - startButton.getWidth(),500);


        stage.addActor(startButton);
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
        stage.act();
        stage.draw();

//        game.font.draw(game.batch, "SMASHHH SPACE TO BEGIN!!!!", 850, 200);

        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            game.setScreen(new PlayScreens(game));
            dispose();
        }
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
        stage.dispose();
        mySkin.dispose();
        background.dispose();
        backgroundTexture.getTexture().dispose();
        atlas.dispose();

    }
}
