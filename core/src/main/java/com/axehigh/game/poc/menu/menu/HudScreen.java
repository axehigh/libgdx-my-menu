package com.axehigh.game.poc.menu.menu;

import com.axehigh.game.poc.menu.Game;
import com.axehigh.game.poc.menu.assets.AssetDescriptors;
import com.axehigh.game.poc.menu.assets.RegionNames;
import com.axehigh.game.poc.menu.util.AtlasHelper;
import com.axehigh.game.poc.menu.util.MyLog;
import com.axehigh.game.poc.menu.util.ProgressBarUI;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import static com.axehigh.game.poc.menu.util.ImageHelper.getImageButton;

public class HudScreen extends MenuScreenBase {

    private final int maxHealth = 5;
    private int health = maxHealth;

    ProgressBarUI progressBarUI;

    public HudScreen(Game game) {
        super(game);
        health = maxHealth;
    }

    protected void update() {
        progressBarUI.updateProgress(health);
    }

    private void reduceHealth() {
        health--;
        if (health < 0) {
            health = 0;
        }
    }

    private void increaseHealth() {
        health++;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    @Override
    protected Actor createUi() {
        Table table = new Table();

        Skin uiskin = assetManager.get(AssetDescriptors.UI_SKIN);

        AtlasHelper atlas = new AtlasHelper(uiskin.getAtlas());
        // Main Menu
        TextButton mainMenu = new TextButton("MENU", uiskin);
        mainMenu.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                mainMenu();
            }
        });

        //Image Button

        ImageButton imageButtonReduce = getImageButton(uiskin, RegionNames.iconFlash, 0.6f);
        imageButtonReduce.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                reduceHealth();
            }
        });

        ImageButton imageButtonAdd = getImageButton(uiskin, RegionNames.iconHealth, 0.6f);
        imageButtonAdd.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                increaseHealth();
            }
        });

        progressBarUI = new ProgressBarUI(
            atlas.findRegion(RegionNames.healthBar),
            atlas.findRegion(RegionNames.iconHealth),
            maxHealth, 0, 0
        );

        // setup table
        Table buttonTable = new Table(uiskin);
        buttonTable.defaults().pad(20);
        buttonTable.setBackground(RegionNames.PANEL);

        buttonTable.add(mainMenu).row();
        buttonTable.add(imageButtonReduce).row();
        buttonTable.add(imageButtonAdd).row();
        buttonTable.add(progressBarUI).row();


        buttonTable.center();

        table.add(buttonTable);
        table.center();
        table.setFillParent(true);
        table.pack();

        return table;
    }


}
