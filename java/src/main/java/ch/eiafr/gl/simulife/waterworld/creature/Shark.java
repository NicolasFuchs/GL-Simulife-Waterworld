package ch.eiafr.gl.simulife.waterworld.creature;

import ch.eiafr.gl.simulife.model.ICreature;

abstract class Shark implements ICreature {
    private int id;
   
    int hunger=10;
    public  boolean isHunger() {
        return hunger==0;
    }

   
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    
    

}
