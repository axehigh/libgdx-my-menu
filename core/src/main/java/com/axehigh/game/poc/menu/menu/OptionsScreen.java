package com.axehigh.game.poc.menu.menu;

import com.axehigh.game.poc.menu.Game;
import com.axehigh.game.poc.menu.assets.AssetDescriptors;
import com.axehigh.game.poc.menu.assets.RegionNames;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import static com.axehigh.game.poc.menu.assets.RegionNames.iconBlueBottle;
import static com.axehigh.game.poc.menu.util.ImageHelper.getImageButton;

public class OptionsScreen extends MenuScreenBase {

    public OptionsScreen(Game game) {
        super(game);
    }

    @Override
    protected Actor createUi() {
        Table table = new Table();

        Skin uiskin = assetManager.get(AssetDescriptors.UI_SKIN);

        // Main Menu
        TextButton backButton = new TextButton("BACK", uiskin);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                mainMenu();
            }
        });

        //Image Button
        ImageButton imageButton = getImageButton(uiskin, iconBlueBottle, 0.8f);


        // setup table
        Table buttonTable = new Table(uiskin);
        buttonTable.defaults().pad(20);
        buttonTable.setBackground(RegionNames.PANEL);

        buttonTable.add(backButton);
        buttonTable.add(imageButton);

        buttonTable.center();

        table.add(buttonTable);
        table.center();
        table.setFillParent(true);
        table.pack();

        return table;
    }

}
