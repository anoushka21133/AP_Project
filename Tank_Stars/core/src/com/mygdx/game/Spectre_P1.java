package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Spectre_P1 implements Screen {

    SpriteBatch batch;
    Texture img;
    Sprite img_sprite;

    Texture left_arrow;
    Sprite left_arrow_sprite;

    Texture right_arrow;
    Sprite right_arrow_sprite;

    static MyGdxGame game;
    Vector3 coord;
    OrthographicCamera cam;

    public Spectre_P1(MyGdxGame game){
        this.game = game;
        batch = new SpriteBatch();
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        img = new Texture(Gdx.files.internal("Spectre_P1.png"));
        img_sprite = new Sprite(img);
        img_sprite.setSize(w,h);
        right_arrow = new Texture(Gdx.files.internal("right_arrow.png"));
        right_arrow_sprite = new Sprite(right_arrow);

        right_arrow_sprite.setSize(2*right_arrow_sprite.getWidth()/9, 2*right_arrow_sprite.getHeight()/9);
        left_arrow = new Texture(Gdx.files.internal("left_arrow.png"));
        left_arrow_sprite = new Sprite(left_arrow);
        left_arrow_sprite.setSize(2*left_arrow_sprite.getWidth()/9, 2*left_arrow_sprite.getHeight()/9);
        left_arrow_sprite.setPosition(w*1626/2546, h*560/1170);
        right_arrow_sprite.setPosition(w*2472/2546, h*560/1170);

        this.coord = new Vector3();
        this.cam = new OrthographicCamera();
        this.cam.setToOrtho(false);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        img_sprite.draw(batch);
        right_arrow_sprite.draw(batch);
        left_arrow_sprite.draw(batch);
        batch.end();
        this.handleTouch();
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

    void handleTouch(){
        if(Gdx.input.justTouched()){
            coord.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            cam.unproject(coord);

            float touch_x = coord.x;
            float touch_y = coord.y;

            if(touch_x >= left_arrow_sprite.getX() && touch_x <= (left_arrow_sprite.getX() + left_arrow_sprite.getWidth()) && touch_y >= left_arrow_sprite.getY() && touch_y <= (left_arrow_sprite.getY() + left_arrow_sprite.getHeight())){
                game.setScreen(new Frost_P1(game));
            }
        }
    }
}