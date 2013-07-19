package java.util;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Observable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.347 -0400", hash_original_field = "B36AF524E30B39AA028F12AED6D394A3", hash_generated_field = "41AF525BC2711909B8EC72BCD38DAB21")

    List<Observer> observers = new ArrayList<Observer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.347 -0400", hash_original_field = "9887ADA90A8808856597B3D49B60BE81", hash_generated_field = "86D4CFFA7EBA3EB225296DE0D42F7D11")

    boolean changed = false;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.348 -0400", hash_original_method = "88DD44E29F0E251AC2213FB1D624DCBA", hash_generated_method = "AF0C25D466E31090823089706BD42B3B")
    public  Observable() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.349 -0400", hash_original_method = "7F4B810E9804FBBDFC86C2FF467D8B0D", hash_generated_method = "7C12B0A3460F0824D2D9CEC9DE9399BD")
    public void addObserver(Observer observer) {
        addTaint(observer.getTaint());
        if(observer == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1715433055 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1715433055.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1715433055;
        } //End block
        synchronized
(this)        {
            if(!observers.contains(observer))            
            observers.add(observer);
        } //End block
        // ---------- Original Method ----------
        //if (observer == null) {
            //throw new NullPointerException();
        //}
        //synchronized (this) {
            //if (!observers.contains(observer))
                //observers.add(observer);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.350 -0400", hash_original_method = "410A33FBB0A048736175F5104AE7D39A", hash_generated_method = "B10215715AF0B76E324A81488D8CA311")
    protected void clearChanged() {
        changed = false;
        // ---------- Original Method ----------
        //changed = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.351 -0400", hash_original_method = "CFCBAA05968B3A0ECDA4D23DDF121D1B", hash_generated_method = "EA4ACFD3EB3B2B125C450C21B8DFEAF1")
    public int countObservers() {
        int var65C782175127BD147125F25E2BC6DF10_2002484263 = (observers.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_656896166 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_656896166;
        // ---------- Original Method ----------
        //return observers.size();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.351 -0400", hash_original_method = "37D0CFFA6009C52C8BE86CC33940023B", hash_generated_method = "4449638AC8FBD2E9568A442EE524D187")
    public synchronized void deleteObserver(Observer observer) {
        addTaint(observer.getTaint());
        observers.remove(observer);
        // ---------- Original Method ----------
        //observers.remove(observer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.352 -0400", hash_original_method = "FC084068D16B3C6E3AABFF0B17369D5A", hash_generated_method = "69167659E83300D82C016F3E273A7E68")
    public synchronized void deleteObservers() {
        observers.clear();
        // ---------- Original Method ----------
        //observers.clear();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.352 -0400", hash_original_method = "CA74254130B5D4534FA6EDAB1417F30F", hash_generated_method = "2171C1D530B7E76B01DF40BE074B4C18")
    public boolean hasChanged() {
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_699890729 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1255997177 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1255997177;
        // ---------- Original Method ----------
        //return changed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.352 -0400", hash_original_method = "5B2E81F3B40545D89DF9F8469B767022", hash_generated_method = "0A960BC1DB3E27BB8563B524BAC6D2EE")
    public void notifyObservers() {
        notifyObservers(null);
        // ---------- Original Method ----------
        //notifyObservers(null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.353 -0400", hash_original_method = "4CD1425B7C28EDF2D5ACE30F9808C0D0", hash_generated_method = "CF64505524161DAC2602A106BBB464A6")
    @SuppressWarnings("unchecked")
    public void notifyObservers(Object data) {
        addTaint(data.getTaint());
        int size = 0;
        Observer[] arrays = null;
        synchronized
(this)        {
            if(hasChanged())            
            {
                clearChanged();
                size = observers.size();
                arrays = new Observer[size];
                observers.toArray(arrays);
            } //End block
        } //End block
        if(arrays != null)        
        {
for(Observer observer : arrays)
            {
                observer.update(this, data);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int size = 0;
        //Observer[] arrays = null;
        //synchronized (this) {
            //if (hasChanged()) {
                //clearChanged();
                //size = observers.size();
                //arrays = new Observer[size];
                //observers.toArray(arrays);
            //}
        //}
        //if (arrays != null) {
            //for (Observer observer : arrays) {
                //observer.update(this, data);
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.354 -0400", hash_original_method = "87048075CC64F75CF8DABD03B4BB9693", hash_generated_method = "0A81876964F964965F16A41F060E97BD")
    protected void setChanged() {
        changed = true;
        // ---------- Original Method ----------
        //changed = true;
    }

    
}

