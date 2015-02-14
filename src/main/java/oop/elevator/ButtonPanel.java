package oop.elevator;

import java.util.List;

/**
 * Created by skunnumkal on 12/22/14.
 */
public abstract class ButtonPanel {

    private List<Button> buttonList;

    public abstract void pressButton(Button button);

    public abstract List<Button> getPressedButtons();
}
