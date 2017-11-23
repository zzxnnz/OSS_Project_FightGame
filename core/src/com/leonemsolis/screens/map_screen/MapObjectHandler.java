package com.leonemsolis.screens.map_screen;


import com.badlogic.gdx.graphics.Color;
import com.leonemsolis.main.MainGameClass;
import com.leonemsolis.screens.common_objects.DataHandler;
import com.leonemsolis.screens.map_screen.objects.MapButton;

/**
 * Created by Leonemsolis on 26/10/2017.
 */

public class MapObjectHandler {

    public MapButton fight1, fight2, boss, training, shop;
    private MainGameClass mainGameClass;

    public MapObjectHandler(MainGameClass mainGameClass) {
        this.mainGameClass = mainGameClass;
        fight1 = new MapButton(160, MainGameClass.MID_POINT + 40, "Level 1", Color.BLACK);
        fight2 = new MapButton(200, MainGameClass.MID_POINT - 50, "Level 2", Color.GREEN);
        boss = new MapButton(240, 30, "Boss", Color.YELLOW);
        shop = new MapButton(0, 0, "Shop", Color.WHITE);
        training = new MapButton(90, MainGameClass.MID_POINT - 20, "Train", Color.BROWN);
    }

    public void update() {
        if(fight1.isActivated()) {
            mainGameClass.gotoFightScreen(1);
        }
        if(fight2.isActivated()) {
            mainGameClass.gotoFightScreen(2);
        }
        if(boss.isActivated()) {
            mainGameClass.gotoFightScreen(3);
        }
        if(shop.isActivated()) {
            //goto shop
        }
        if(training.isActivated()) {
            //goto training
        }
    }
}
