package com.axehigh.game.poc.menu.util;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;

public class ImageHelper {

    public static ImageButton getImageButton(Skin uiskin, String icon,float scale) {
        //This works
        ImageButton imageButton = new ImageButton(uiskin);

        TextureRegionDrawable imageUp = new TextureRegionDrawable(uiskin.getRegion(icon));

        // Create a Drawable wrapper with scaling
        Drawable scaledDrawable = new ScalingDrawable(imageUp, Scaling.fit, Align.center, scale, scale);

        // Set the scaled Drawable to the imageUp property of the ImageButtonStyle
        imageButton.getStyle().imageUp = scaledDrawable;

        return imageButton;
    }
}
