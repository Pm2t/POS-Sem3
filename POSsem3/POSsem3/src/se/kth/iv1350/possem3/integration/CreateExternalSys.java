package se.kth.iv1350.possem3.integration;

/**
 * This class has the purpose of creating objects of the external system classes.
 */

public class CreateExternalSys {
    private final ExtAccSys extAccSys;
    private final ExtInvSys extInvSys;

    /**
     * This constructor creates objects of the external systems.
     */

    public CreateExternalSys(){
        extAccSys = new ExtAccSys();
        extInvSys = new ExtInvSys();
    }

    /**
     * Getter method for the object of <code>ExtInvSys</code>.
     * @return Returns the object.
     */

    public ExtInvSys getExtInvSys(){
        return extInvSys;
    }

    /**
     * Getter method for the object of <code>ExtAccSys</code>.
     * @return Returns the object.
     */

    public ExtAccSys getExtAccSys(){
        return extAccSys;
    }


}
