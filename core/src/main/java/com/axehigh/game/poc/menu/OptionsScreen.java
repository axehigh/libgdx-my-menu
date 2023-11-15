package com.axehigh.game.poc.menu;

import com.axehigh.game.poc.menu.assets.AssetDescriptors;
import com.axehigh.game.poc.menu.assets.RegionNames;
import com.axehigh.game.poc.menu.util.MyLog;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import static com.axehigh.game.poc.menu.assets.RegionNames.iconSkuld;
import static com.axehigh.game.poc.menu.util.ImageHelper.getImageButton;

/**
 * Created by goran on 1/09/2016.
 */
public class OptionsScreen extends MenuScreenBase {

    public OptionsScreen(Game game) {
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

        // quit button
        TextButton backButton = new TextButton("BACK", uiskin);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                back();
            }
        });


        //Image Button
        ImageButton imageButton = getImageButton(uiskin, iconSkuld);


        // setup table
        Table buttonTable = new Table(uiskin);
        buttonTable.defaults().pad(20);
        buttonTable.setBackground(RegionNames.PANEL);

        buttonTable.add(playButton).row();
        buttonTable.add(backButton);
        buttonTable.add(imageButton);

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

    private void showHighScore() {
        MyLog.log("showHighScore()");
//        game.setScreen(new HighScoreScreen(game));
    }

    private void showOptions() {
        MyLog.log("showOptions()");
//        game.setScreen(new OptionsScreen(game));
    }

    private void back() {
        game.setScreen(new MenuScreen(game));
    }

    public static Texture getTexture(String textureName) {
        return new Texture(textureName);
    }
}
