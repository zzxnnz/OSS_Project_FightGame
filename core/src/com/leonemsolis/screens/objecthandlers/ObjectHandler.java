package com.leonemsolis.screens.objecthandlers;

import com.leonemsolis.screens.objecthandlers.objects.InteractiveObjects;
import com.leonemsolis.screens.objecthandlers.objects.Object;

import java.util.List;

/**
 * Created by Leonemsolis on 28/09/2017.
 *
 * ObjectHandler - manages and updates all the object of a
 * certain screen
 *
 */

public abstract class ObjectHandler {
    List<Object>objects;
    List<Object>renderingObjects;
    List<InteractiveObjects>interactiveObjects;

    public void update() {

    }

    public List<InteractiveObjects> getInteractiveObjects() {
        return interactiveObjects;
    }

    public List<Object> getRenderingObjects() {
        return renderingObjects;
    }

}