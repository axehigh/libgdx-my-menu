package com.axehigh.game.poc.menu.util;

import com.axehigh.game.poc.menu.Game;
import com.badlogic.gdx.Screen;

public class ScreenManager {
    private static Game game;

    public static void initialize(Game game) {
        ScreenManager.game = game;
    }

    public static void switchScreen(Screen newScreen) {
        game.setScreen(newScreen);
    }

    public static void transitionFadePixelScreen(Game game, Screen newScreen) {
        TransitionFadePixelScreen screenEffect = new TransitionFadePixelScreen(game, game.getScreen(), newScreen);
        screenEffect.startTransition();
        game.setScreen(screenEffect);
    }
    public static void transitionFadeScreen(Game game, Screen newScreen) {
        TransitionFadeScreen transitionFadeScreen = new TransitionFadeScreen(game, game.getScreen(), newScreen);
        transitionFadeScreen.startTransition();
        game.setScreen(transitionFadeScreen);
    }
}
