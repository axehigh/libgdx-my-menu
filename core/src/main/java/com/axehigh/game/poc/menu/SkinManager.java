package com.axehigh.game.poc.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class SkinManager {

    private Skin skin;

    public void setSkin(Skin skin) {
        this.skin = new Skin(Gdx.files.internal("skins/uiskin.json"));
    }
}
