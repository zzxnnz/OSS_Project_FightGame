package com.leonemsolis.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.leonemsolis.screens.common_objects.AssetHandler;
import com.leonemsolis.screens.common_objects.DataHandler;
import com.leonemsolis.screens.fight_screen.FightScreen;
import com.leonemsolis.screens.main_screen.MainScreen;
import com.leonemsolis.screens.map_screen.MapScreen;
import com.leonemsolis.screens.shop_screen.ShopScreen;
import com.leonemsolis.screens.training_screen.TrainingScreen;

/**
 * Created by Leonemsolis on 18/09/2017.
 * <p>
 * MainGameClass mainly responds for switching game screens
 * Also it's the first class that always executed first
 */

public class MainGameClass extends Game {
    // Actual width of the game (constant)
    public static int GAME_WIDTH = 320;
    // Actual height of the game (non-constant)
    public static int GAME_HEIGHT;
    // Device screen's resolution
    public static int DEVICE_WIDTH;
    public static int DEVICE_HEIGHT;

    // Middle point(height) of the game
    public static int MID_POINT;
    // Scale - how much Device's screen resolution differ from game
    public static float GAME_SCALE;

// Main Game
    @Override
    public void create() {
        DataHandler.loadData();
        AssetHandler.loadAssets();
        DEVICE_WIDTH = Gdx.graphics.getWidth();
        DEVICE_HEIGHT = Gdx.graphics.getHeight();
        GAME_SCALE = (DEVICE_WIDTH / (float) GAME_WIDTH);
        GAME_HEIGHT = (int) ((float) DEVICE_HEIGHT / GAME_SCALE);
        MID_POINT = GAME_HEIGHT / 2;
        // Goto certain screen first
        switchScreen(0);
//        gotoFightScreen(1);
    }

    public void gotoFightScreen(int level) {
        setScreen(new FightScreen(this, level));
    }

    public void switchScreen(int id) {
        switch (id) {
            case 0:
                setScreen(new MainScreen(this));
                break;
            case 1:
                setScreen(new MapScreen(this));
                break;
            case 2:
                setScreen(new TrainingScreen(this));
                break;
            case 3:
                setScreen(new ShopScreen(this));
                break;
            default:
                setScreen(new MainScreen(this));
                break;
        }
    }


    @Override
    public void dispose() {
        DataHandler.saveData();
        AssetHandler.dispose();
    }
}