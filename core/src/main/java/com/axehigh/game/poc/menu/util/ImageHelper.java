package com.axehigh.game.poc.menu.util;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;

public class ImageHelper {


    public static TextureRegionDrawable getTextureRegionDrawable(Skin uiSkin, String region) {
        return new TextureRegionDrawable(uiSkin.getRegion(region));
    }

    public static ImageButton getImageButton(Skin uiskin, String icon, float scale) {
        MyLog.log("Region name: " + icon);

        //This works
        ImageButton imageButton = new ImageButton(uiskin);
        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle(imageButton.getStyle());
        imageButton.setStyle(style);

        TextureRegionDrawable imageUp = new TextureRegionDrawable(uiskin.getRegion(icon));

        // Set the scaled Drawable to the imageUp property of the ImageButtonStyle
        imageButton.getStyle().imageUp = new ScalingDrawable(imageUp, scale, scale);

        return imageButton;
    }
}
