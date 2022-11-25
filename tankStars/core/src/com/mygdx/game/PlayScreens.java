package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import javax.swing.text.View;

public class PlayScreens extends InputAdapter implements Screen {

    private tankStars game;                 //To pass on the whole game to other classes
    private Texture texture, tank1, tank2;                //To create Images
    SpriteBatch batch;

    private Stage stage;
    private TextureAtlas atlas;
    private Skin skin;

    private OrthographicCamera gameCam;

    private Viewport gamePort;
    private TiledMap map;
    private TmxMapLoader mapLoader;
    private OrthogonalTiledMapRenderer renderer;

    private World world;
    private Box2DDebugRenderer b2dr;

    private Texture pauseIcon;
    private Texture Tank1;
    private Texture Tank2;
    private Texture chooseIcon;
    private Texture topHUD;

    public PlayScreens(tankStars game){

        this.game = game;
        gameCam = new OrthographicCamera();
        tank1 = new Texture("images/Abramas.png");
        tank2 = new Texture("images/rightHelios.png");
        chooseIcon = new Texture("images/chooseIcon.png");
        topHUD = new Texture("images/TopHUD.png");
        gamePort = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),gameCam);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("sprites/ground1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        gameCam.position.set(((gamePort.getWorldWidth()/2)),(gamePort.getWorldHeight()/2),0);

        world = new World(new Vector2(0,1f),true);
        b2dr = new Box2DDebugRenderer();
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for (MapObject object: map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class))
        {
            Rectangle rect = ((RectangleMapObject)object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set(rect.getX() + rect.getWidth()/2,rect.getY()+rect.getHeight()/2);
            body = world.createBody(bdef);
            shape.setAsBox(rect.getWidth() / 2, rect.getHeight() / 2);
            fdef.shape = shape;
            body.createFixture(fdef);
        }
    }


    public void update(float dt){
//        handleInput(dt);
        world.step(1/60f, 6,2);
        gameCam.update();
        renderer.setView(gameCam);

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0,0,0,1);   //Default Base color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();
        game.batch.setProjectionMatrix(gameCam.combined);

        game.batch.begin();
        b2dr.render(world, gameCam.combined);
        game.batch.draw(chooseIcon, 20,Gdx.graphics.getHeight()-120,100,100);

        if (Gdx.input.getX()<120 && Gdx.input.getX()>20 && Gdx.input.getY()<120 && Gdx.input.getY()>20){
            if (Gdx.input.isTouched()){
                game.setScreen(new PauseScreen(game));
            }
        }
        game.batch.draw(topHUD,300,Gdx.graphics.getHeight()-160);

        game.batch.draw(tank1,400,320,230,150);
        game.batch.draw(tank2,1090,325,230,150);
        game.batch.end();

//        gameCam.update();

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
        batch.dispose();
        texture.dispose();
    }
}

