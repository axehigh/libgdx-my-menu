package com.axehigh.game.poc.menu.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Assets {

    public static TextureRegionDrawable progressBarBackground;


    public static void load(Skin skin) {
        progressBarBackground = new TextureRegionDrawable(skin.getRegion(RegionNames.healthBar));
    }


}
