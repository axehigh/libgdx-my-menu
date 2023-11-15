package com.axehigh.game.poc.menu;

import com.axehigh.game.poc.menu.assets.AssetDescriptors;
import com.axehigh.game.poc.menu.assets.RegionNames;
import com.axehigh.game.poc.menu.util.MyLog;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;

import static com.axehigh.game.poc.menu.assets.RegionNames.iconSkuld;

/**
 * Created by goran on 1/09/2016.
 */
public class MenuScreen extends MenuScreenBase {

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    protected Actor createUi() {
        Table table = new Table();

        Skin uiskin = assetManager.get(AssetDescriptors.UI_SKIN);

//        TextureAtlas gamePlayAtlas = assetManager.get(AssetDescriptors.GAME_PLAY);
//        Texture texture = MyAtlas.getTexture(GameGfxName.background);
//        table.setBackground(new TextureRegionDrawable(texture));

        // play button
        TextButton playButton = new TextButton("SELECT LEVEL", uiskin);
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                play();
            }
        });

        // high score button
        TextButton highScoreButton = new TextButton("HIGHSCORE", uiskin);
        highScoreButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                showHighScore();
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


        //Image Button
        ImageButton imageButton = getImageButton(uiskin);


        // setup table
        Table buttonTable = new Table(uiskin);
        buttonTable.defaults().pad(20);
        buttonTable.setBackground(RegionNames.PANEL);

        buttonTable.add(playButton).row();
        buttonTable.add(highScoreButton).row();
        buttonTable.add(optionsButton).row();
        buttonTable.add(quitButton);
        buttonTable.add(imageButton);

        buttonTable.center();

        table.add(buttonTable);
        table.center();
        table.setFillParent(true);
        table.pack();

        return table;
    }

    private static ImageButton getImageButton(Skin uiskin) {
//        ImageButton imageButton = new ImageButton(uiskin);
//        TextureRegion skullIcon = uiskin.getRegion(iconSkuld);
//        TextureRegionDrawable imageUp = new TextureRegionDrawable(skullIcon);
//
//        imageButton.getStyle().imageUp = imageUp;

        //This works
        ImageButton imageButton = new ImageButton(uiskin);
        TextureRegion skullIcon = uiskin.getRegion(iconSkuld);
        TextureRegionDrawable imageUp = new TextureRegionDrawable(skullIcon);

        // Create a Drawable wrapper with scaling
        Drawable scaledDrawable = new ScalingDrawable(imageUp, Scaling.fit, Align.center, .5f, .5f);

        // Set the scaled Drawable to the imageUp property of the ImageButtonStyle
        imageButton.getStyle().imageUp = scaledDrawable;


        return imageButton;
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

    private void quit() {
        MyLog.log("quit()");
        Gdx.app.exit();
    }

    public static Texture getTexture(String textureName) {
        return new Texture(textureName);
    }
}
