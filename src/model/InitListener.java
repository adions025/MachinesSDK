package model;

import java.util.ArrayList;

public class InitListener {
	private ArrayList<LblsListener> listeners = new ArrayList<LblsListener>();

    public void addListener(LblsListener toAdd) {
        listeners.add(toAdd);
    }

    public void sayHello() {
        System.out.println("Hello!!");

        // Notify everybody that may be interested.
//        for (LblsListener hl : listeners)
//            hl.mouseClicked(e);;
    }
}
