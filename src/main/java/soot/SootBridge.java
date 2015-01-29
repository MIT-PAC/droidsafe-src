package soot;

public class SootBridge {

    public static void releaseContextNumberer(){
        Scene.v().contextNumberer = null;
    }
}
