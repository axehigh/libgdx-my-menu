package com.axehigh.game.poc.menu.util;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AtlasHelper {

    TextureAtlas atlas;

    public AtlasHelper(TextureAtlas atlas) {
        this.atlas = atlas;
    }

    public TextureAtlas.AtlasRegion findRegion(String name) {
        return atlas.findRegion(name);
    }
}
