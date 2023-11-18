package com.axehigh.game.poc.menu;

import com.axehigh.game.poc.menu.assets.AssetDescriptors;
import com.axehigh.game.poc.menu.menu.HudScreen;
import com.axehigh.game.poc.menu.menu.MenuScreen;
import com.axehigh.game.poc.menu.menu.OptionsScreen;
import com.axehigh.game.poc.menu.util.MyLog;
import com.axehigh.game.poc.menu.util.ScreenManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import static com.axehigh.game.poc.menu.assets.AssetPaths.UI_SKIN;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Game extends com.badlogic.gdx.Game {
    private SpriteBatch batch;
    private Skin skin;
    private AssetManager assetManager;

    private Screen menuScreen;
    private Screen optionScreen;
    private Screen hudScreen;

    @Override
    public void create() {
        batch = new SpriteBatch();
        assetManager = new AssetManager();
        assetManager.load(AssetDescriptors.UI_SKIN);
        assetManager.finishLoading();
        skin = new Skin(Gdx.files.internal(UI_SKIN));

        ScreenManager.initialize(this);

        menuScreen = new MenuScreen(this);
        optionScreen = new OptionsScreen(this);
        hudScreen = new HudScreen(this);

        ScreenManager.switchScreen(menuScreen);

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        MyLog.log("Game Dispose");
        hudScreen.dispose();
        menuScreen.dispose();
        optionScreen.dispose();

        batch.dispose();
        skin.dispose();
        assetManager.dispose();
    }

    public SpriteBatch getSpriteBatch() {
        return batch;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public Screen getMenuScreen() {
        return menuScreen;
    }

    public Screen getOptionScreen() {
        return optionScreen;
    }

    public SpriteBatch getBatch() {
        return getSpriteBatch();
    }

    public Screen getHudScreen() {
        return hudScreen;
    }
}
