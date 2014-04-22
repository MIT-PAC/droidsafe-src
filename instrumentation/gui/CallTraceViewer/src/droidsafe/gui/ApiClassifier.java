/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package droidsafe.gui;

import java.util.Random;

/**
 *
 * @author Nguyen Nguyen
 */
public class ApiClassifier {
    private static ApiClassifier instance = new ApiClassifier();
    private Random rand;
    
    private ApiClassifier() {
        rand = new Random();
    }
    
    
    //////////////////////Public interface //////////////////////////
    public static ApiClassifier v() { return instance; }
    
    public void load(String file) {
        
    }
    
    public boolean isSpec(String api) {
        return rand.nextBoolean();
    }
    
    public boolean isSafe(String api) {
        return true;
    }
    
    public boolean isSink(String api) {
        return true;
    }
    
    public boolean isSource(String api) {
        return true;
    }
    
}
