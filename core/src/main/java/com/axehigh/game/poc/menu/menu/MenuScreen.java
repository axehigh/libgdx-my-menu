package com.axehigh.game.poc.menu.menu;

import com.axehigh.game.poc.menu.Game;
import com.axehigh.game.poc.menu.assets.AssetDescriptors;
import com.axehigh.game.poc.menu.assets.RegionNames;
import com.axehigh.game.poc.menu.util.MyLog;
import com.axehigh.game.poc.menu.util.ScreenManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MenuScreen extends MenuScreenBase {

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    protected Actor createUi() {
        Table table = new Table();

        Skin uiskin = assetManager.get(AssetDescriptors.UI_SKIN);

        // play button
        TextButton playButton = new TextButton("SELECT LEVEL", uiskin);
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                play();
            }
        });

        // options button
        TextButton optionsButton = new TextButton("OPTIONS", uiskin);
        optionsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                showOptions();
            }
        });

        // quit button
        TextButton quitButton = new TextButton("QUIT", uiskin);
        quitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                quit();
            }
        });


        // setup table
        Table buttonTable = new Table(uiskin);
        buttonTable.defaults().pad(20);
        buttonTable.setBackground(RegionNames.PANEL);

        buttonTable.add(playButton).row();
        buttonTable.add(optionsButton).row();
        buttonTable.add(quitButton);

        buttonTable.center();

        table.add(buttonTable);
        table.center();
        table.setFillParent(true);
        table.pack();

        return table;
    }

    private void play() {
        MyLog.log("play - select level()");
//        game.setScreen(new LevelScreen(game));
    }

    private void showOptions() {
        MyLog.log("showOptions()");
        ScreenManager.transitionFadeScreen(game, game.getOptionScreen());
    }

    private void quit() {
        MyLog.log("quit()");
        Gdx.app.exit();
    }

}
