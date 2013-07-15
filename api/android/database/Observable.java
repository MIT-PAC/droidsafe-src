package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;

public abstract class Observable<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.445 -0400", hash_original_field = "4568676A708AC893FC758A70E573C153", hash_generated_field = "68FF9C8CE88B8AC7C5CD64388A1A318D")

    protected final ArrayList<T> mObservers = new ArrayList<T>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.446 -0400", hash_original_method = "70464F2D6E4F3B59517C778B3B1A93D5", hash_generated_method = "70464F2D6E4F3B59517C778B3B1A93D5")
    public Observable ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.447 -0400", hash_original_method = "E1D85670162EF30644779B34B74FE79F", hash_generated_method = "89E3CA374B0AF9EC62CFA359F9983E56")
    public void registerObserver(T observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
    if(observer == null)        
        {
            IllegalArgumentException varD8549322C6300CBB2674A7924C5E257A_390775344 = new IllegalArgumentException("The observer is null.");
            varD8549322C6300CBB2674A7924C5E257A_390775344.addTaint(taint);
            throw varD8549322C6300CBB2674A7924C5E257A_390775344;
        } //End block
        synchronized
(mObservers)        {
    if(mObservers.contains(observer))            
            {
                IllegalStateException var4ED84C89C8DE99719769468B984ED60A_1841275576 = new IllegalStateException("Observer " + observer + " is already registered.");
                var4ED84C89C8DE99719769468B984ED60A_1841275576.addTaint(taint);
                throw var4ED84C89C8DE99719769468B984ED60A_1841275576;
            } //End block
            mObservers.add(observer);
        } //End block
        // ---------- Original Method ----------
        //if (observer == null) {
            //throw new IllegalArgumentException("The observer is null.");
        //}
        //synchronized(mObservers) {
            //if (mObservers.contains(observer)) {
                //throw new IllegalStateException("Observer " + observer + " is already registered.");
            //}
            //mObservers.add(observer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.449 -0400", hash_original_method = "5FAF0F37EA51171D6350539680C2708B", hash_generated_method = "94822B8B39B4A33B87567E7CE955DACE")
    public void unregisterObserver(T observer) {
        addTaint(observer.getTaint());
    if(observer == null)        
        {
            IllegalArgumentException varD8549322C6300CBB2674A7924C5E257A_700851573 = new IllegalArgumentException("The observer is null.");
            varD8549322C6300CBB2674A7924C5E257A_700851573.addTaint(taint);
            throw varD8549322C6300CBB2674A7924C5E257A_700851573;
        } //End block
        synchronized
(mObservers)        {
            int index = mObservers.indexOf(observer);
    if(index == -1)            
            {
                IllegalStateException varFA0CC1A3FD1B549CF302ACCE9A2F3D78_27777274 = new IllegalStateException("Observer " + observer + " was not registered.");
                varFA0CC1A3FD1B549CF302ACCE9A2F3D78_27777274.addTaint(taint);
                throw varFA0CC1A3FD1B549CF302ACCE9A2F3D78_27777274;
            } //End block
            mObservers.remove(index);
        } //End block
        // ---------- Original Method ----------
        //if (observer == null) {
            //throw new IllegalArgumentException("The observer is null.");
        //}
        //synchronized(mObservers) {
            //int index = mObservers.indexOf(observer);
            //if (index == -1) {
                //throw new IllegalStateException("Observer " + observer + " was not registered.");
            //}
            //mObservers.remove(index);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.450 -0400", hash_original_method = "68DB825828DE5D87C3617DBC5932D86C", hash_generated_method = "EECAF37010A355E20626A6752F3C7F31")
    public void unregisterAll() {
        synchronized
(mObservers)        {
            mObservers.clear();
        } //End block
        // ---------- Original Method ----------
        //synchronized(mObservers) {
            //mObservers.clear();
        //}
    }

    
}

