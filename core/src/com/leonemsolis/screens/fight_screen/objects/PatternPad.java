package com.leonemsolis.screens.fight_screen.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.leonemsolis.main.MainGameClass;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Leonemsolis on 06/11/2017.
 */

// TODO: 07/11/2017 SAME PATTERNS

public class PatternPad {
    private Random random;
    public String label;
    public Rectangle bounds;
    public ArrayList<Line>lines;
    private Circle c1, c2, c3, c4;

    public PatternPad(PATTERN_TYPE type) {
        random = new Random();
        switch (type) {
            case ATTACK:
                bounds = new Rectangle(40, MainGameClass.MID_POINT - 170, 100, 100);
                label = "ATTACK";
                break;
            case DEFENCE:
                bounds = new Rectangle(180, MainGameClass.MID_POINT - 170, 100, 100);
                label = "DEFENCE";
                break;
            case COUNTER:
                bounds = new Rectangle(40, MainGameClass.MID_POINT - 30, 100, 100);
                label = "COUNTER";
                break;
            case HEAL:
                bounds = new Rectangle(180, MainGameClass.MID_POINT - 30, 100, 100);
                label = "HEAL";
                break;
        }
        c1 = new Circle(bounds.x + 25, bounds.y + 25, 15);
        c2 = new Circle(bounds.x + 75, bounds.y + 25, 15);
        c3 = new Circle(bounds.x + 25, bounds.y + 75, 15);
        c4 = new Circle(bounds.x + 75, bounds.y + 75, 15);
        lines = new ArrayList<Line>();
        setupLines();
    }

    public void renderLabel(BitmapFont font, SpriteBatch batch) {
        batch.begin();
            font.draw(batch, label, bounds.x, bounds.y - 16);
        batch.end();
    }

    public void render(ShapeRenderer shape) {
        Color saved = shape.getColor().cpy();

        shape.setColor(Color.BLUE);
        shape.begin(ShapeRenderer.ShapeType.Filled);
            shape.rect(bounds.x, bounds.y, bounds.width, bounds.height);
            shape.setColor(Color.BLACK);
            for (Line l: lines) {
                if(l.checked) {
                    shape.rectLine(l.x1, l.y1, l.x2, l.y2, 4);
                }
            }
            shape.setColor(Color.GRAY);
            //Top-Left
            shape.circle(c1.x, c1.y, c1.radius);
            //Top-Right
            shape.circle(c2.x, c2.y, c2.radius);
            //Bottom-Left
            shape.circle(c3.x, c3.y, c3.radius);
            //Bottom-Right
            shape.circle(c4.x, c4.y, c4.radius);
        shape.end();

        shape.setColor(saved);
    }

    public void setupLines() {
        lines.clear();
        lines.add(new Line(c1, c2, false));
        lines.add(new Line(c2, c4, false));
        lines.add(new Line(c4, c3, false));
        lines.add(new Line(c3, c1, false));
        lines.add(new Line(c1, c4, false));
        lines.add(new Line(c3, c2, false));

        int linesNumber = random.nextInt(4)+2;

        //No parallel lines
        if(linesNumber == 2) {
            check2Lines();
        } else {
            for(int i = 0; i < linesNumber; ++i) {
                checkRandomLine();
            }
        }
    }

    private void checkRandomLine() {
        Line selected = lines.get(random.nextInt(6));
        if(selected.checked) {
            checkRandomLine();
        } else {
            selected.checked = true;
        }
        return;
    }

    private void check2Lines() {
        checkRandomLine();

        for(int i = 0; i < 6; ++i) {
            if(lines.get(i).checked) {
                if(i == 5) {
                    lines.get(0).checked = true;
                } else if(i == 0){
                    lines.get(1).checked = true;
                } else {
                    lines.get(i - 1).checked = true;
                }
            }
        }
    }
}
