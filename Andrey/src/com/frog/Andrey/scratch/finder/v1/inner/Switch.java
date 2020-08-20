package com.frog.Andrey.scratch.finder.v1.inner;

import java.util.List;

public class Switch {

    private Boolean state;
    private List<Switch> correspondence;


    public Switch(Boolean state, List<Switch> correspondence) {
        this.state = state;
        this.correspondence = correspondence;
    }
    
    
    public boolean getState() {
        return state;
    }
    
    
    public void turn() {
        this.state = !this.state;
        this.correspondence.forEach(Switch::turnInner);
    }
    
    
    void turnInner() {
       this.state = !this.state;
    }
    
    
    List<Switch> correspondence() {
        return correspondence;
    }
    
}
