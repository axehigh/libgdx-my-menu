package com.axehigh.game.poc.menu.util;

import com.axehigh.game.poc.menu.assets.Assets;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

public class ProgressBarUI extends Table {
    public final static float WIDTH = 180;
    public final static float HEIGHT = 28;
    float BAR_WIDTH = 180;
    float BAR_HEIGHT = 24;
    public float maxProgress;
    private final AtlasRegion bar;

    public float progress;

    public ProgressBarUI(AtlasRegion bar, AtlasRegion icon, float maxProgress, float x, float y) {
        this.setBounds(x, y, WIDTH, HEIGHT);
        this.maxProgress = maxProgress;
        this.progress = maxProgress;
        setBackground(Assets.progressBarBackground);
        setIcon(icon);
        this.bar = bar;
    }

    private void setIcon(AtlasRegion icon) {
        Image imgIcon = new Image(icon);
        imgIcon.scaleBy(-.5f);
        imgIcon.setPosition(-(imgIcon.getPrefWidth() / 2) + 12, getHeight() / 2f - (imgIcon.getPrefHeight() * imgIcon.getScaleY() / 2f));
        addActor(imgIcon);

    }

    public void updateProgress(float progress) {
        this.progress = progress;
        MyLog.log("progress:" + progress);

        if (progress > maxProgress)
            maxProgress = progress;

        if (progress < 0)
            this.progress = 0;
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (progress > 0) {
            float widthSizeForProgress = BAR_WIDTH * (progress / maxProgress);
            batch.draw(bar, this.getX() + 25, this.getY() + 2, widthSizeForProgress, BAR_HEIGHT);
        }
    }
}
