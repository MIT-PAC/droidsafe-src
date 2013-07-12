package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class Observable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.310 -0400", hash_original_field = "B36AF524E30B39AA028F12AED6D394A3", hash_generated_field = "41AF525BC2711909B8EC72BCD38DAB21")

    List<Observer> observers = new ArrayList<Observer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.310 -0400", hash_original_field = "9887ADA90A8808856597B3D49B60BE81", hash_generated_field = "86D4CFFA7EBA3EB225296DE0D42F7D11")

    boolean changed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.310 -0400", hash_original_method = "88DD44E29F0E251AC2213FB1D624DCBA", hash_generated_method = "AF0C25D466E31090823089706BD42B3B")
    public  Observable() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.311 -0400", hash_original_method = "7F4B810E9804FBBDFC86C2FF467D8B0D", hash_generated_method = "D3F5D58A519855565D89D68112E6281D")
    public void addObserver(Observer observer) {
        addTaint(observer.getTaint());
    if(observer == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_502064339 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_502064339.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_502064339;
        } 
        synchronized
(this)        {
    if(!observers.contains(observer))            
            observers.add(observer);
        } 
        
        
            
        
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.311 -0400", hash_original_method = "410A33FBB0A048736175F5104AE7D39A", hash_generated_method = "B10215715AF0B76E324A81488D8CA311")
    protected void clearChanged() {
        changed = false;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.312 -0400", hash_original_method = "CFCBAA05968B3A0ECDA4D23DDF121D1B", hash_generated_method = "E38D12CA313153904355D3C67FB17A8D")
    public int countObservers() {
        int var65C782175127BD147125F25E2BC6DF10_1845558773 = (observers.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358017142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358017142;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.312 -0400", hash_original_method = "37D0CFFA6009C52C8BE86CC33940023B", hash_generated_method = "4449638AC8FBD2E9568A442EE524D187")
    public synchronized void deleteObserver(Observer observer) {
        addTaint(observer.getTaint());
        observers.remove(observer);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.312 -0400", hash_original_method = "FC084068D16B3C6E3AABFF0B17369D5A", hash_generated_method = "69167659E83300D82C016F3E273A7E68")
    public synchronized void deleteObservers() {
        observers.clear();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.312 -0400", hash_original_method = "CA74254130B5D4534FA6EDAB1417F30F", hash_generated_method = "8139628CAC5B5648D7383D7EE5956C71")
    public boolean hasChanged() {
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_342635429 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1512276676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1512276676;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.313 -0400", hash_original_method = "5B2E81F3B40545D89DF9F8469B767022", hash_generated_method = "0A960BC1DB3E27BB8563B524BAC6D2EE")
    public void notifyObservers() {
        notifyObservers(null);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.313 -0400", hash_original_method = "4CD1425B7C28EDF2D5ACE30F9808C0D0", hash_generated_method = "CF64505524161DAC2602A106BBB464A6")
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
            } 
        } 
    if(arrays != null)        
        {
for(Observer observer : arrays)
            {
                observer.update(this, data);
            } 
        } 
        
        
        
        
            
                
                
                
                
            
        
        
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.314 -0400", hash_original_method = "87048075CC64F75CF8DABD03B4BB9693", hash_generated_method = "0A81876964F964965F16A41F060E97BD")
    protected void setChanged() {
        changed = true;
        
        
    }

    
}

