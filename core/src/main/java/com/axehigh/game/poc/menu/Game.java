package com.axehigh.game.poc.menu;

import com.axehigh.game.poc.menu.assets.AssetDescriptors;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
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


    @Override
    public void create() {
        batch = new SpriteBatch();
        assetManager = new AssetManager();
        assetManager.load(AssetDescriptors.UI_SKIN);
        assetManager.finishLoading();
        skin = new Skin(Gdx.files.internal(UI_SKIN));

        setScreen(new MenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
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
}
