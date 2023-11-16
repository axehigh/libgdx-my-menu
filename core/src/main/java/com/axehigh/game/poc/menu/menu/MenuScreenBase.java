package com.axehigh.game.poc.menu.menu;

import com.axehigh.game.poc.menu.Game;
import com.axehigh.game.poc.menu.Global;
import com.axehigh.game.poc.menu.util.MyLog;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class MenuScreenBase implements Screen {
    protected final Game game;
    protected final AssetManager assetManager;
    private Stage stage;
    private Viewport viewport;

    public MenuScreenBase(Game game) {
        this.game = game;
        this.assetManager = game.getAssetManager();
        viewport = new FitViewport(Global.MENU_SCREEN_WIDTH, Global.MENU_SCREEN_HEIGHT);
        stage = new Stage(viewport, game.getSpriteBatch());

        stage.addActor(createUi());
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    protected abstract Actor createUi();

    private ClickListener exitGameListener() {
        return new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                exitGame();
            }
        };
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.0f, 0.0f, 0.0f, 1);
        update();
        stage.act();
        stage.draw();

    }

    private void update() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            exitGame();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            startGame();
        }
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
        Camera camera = stage.getViewport().getCamera();
        game.getSpriteBatch().setProjectionMatrix(camera.combined);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
//        dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    private void startGame() {
//        game.setScreen(new LevelScreen(game));
        MyLog.log("Start Game Pressed");
//        dispose();
    }

    private void exitGame() {
        MyLog.log("Exit Game Pressed");
        Gdx.app.exit();
    }

}
