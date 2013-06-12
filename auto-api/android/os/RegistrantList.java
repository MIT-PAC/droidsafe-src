package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

public class RegistrantList {
    ArrayList   registrants = new ArrayList();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.863 -0400", hash_original_method = "D619B6B6CF1BABB74D64C92E930385FE", hash_generated_method = "5FF4DC70348EE524C1FAFD1962E56C2F")
    @DSModeled(DSC.SAFE)
    public synchronized void add(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        add(new Registrant(h, what, obj));
        // ---------- Original Method ----------
        //add(new Registrant(h, what, obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.863 -0400", hash_original_method = "8738C2928375831BBA08E54EFA7A0387", hash_generated_method = "2F3789A5E50F6455E239C982D57F2166")
    @DSModeled(DSC.SAFE)
    public synchronized void addUnique(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        remove(h);
        add(new Registrant(h, what, obj));
        // ---------- Original Method ----------
        //remove(h);
        //add(new Registrant(h, what, obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.863 -0400", hash_original_method = "6ACFEC9684204FF0A155D83C1349ED2C", hash_generated_method = "E428302590206436BE2486816D6046C3")
    @DSModeled(DSC.SAFE)
    public synchronized void add(Registrant r) {
        dsTaint.addTaint(r.dsTaint);
        removeCleared();
        registrants.add(r);
        // ---------- Original Method ----------
        //removeCleared();
        //registrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.863 -0400", hash_original_method = "8966BBD177872515B913197EAE844100", hash_generated_method = "F05241FCE4D933AAAB334556F1FC0F83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void removeCleared() {
        {
            int i;
            i = registrants.size() - 1;
            {
                Registrant r;
                r = (Registrant) registrants.get(i);
                {
                    registrants.remove(i);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = registrants.size() - 1; i >= 0 ; i--) {
            //Registrant  r = (Registrant) registrants.get(i);
            //if (r.refH == null) {
                //registrants.remove(i);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.863 -0400", hash_original_method = "F0EB9E400375C0AD2DEFF1B982C74365", hash_generated_method = "67D9C406D9DB1BE17E5140F4113B28BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int size() {
        int var0F8227621A931405769BDD80479B8708_1322810158 = (registrants.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return registrants.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.863 -0400", hash_original_method = "8E803949D880002FCD2B174D60AAE952", hash_generated_method = "933500D88124BCDB4E1BFB602885D081")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized Object get(int index) {
        dsTaint.addTaint(index);
        Object var50B93FE3E10842A4CE107E207BC2D55D_433858515 = (registrants.get(index));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return registrants.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.863 -0400", hash_original_method = "923D2EAB51C3C809A7DC018C31FECFAC", hash_generated_method = "45B9F293AC93B8AA2B0C638002E580F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void internalNotifyRegistrants(Object result, Throwable exception) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(exception.dsTaint);
        {
            int i, s;
            i = 0;
            s = registrants.size();
            {
                Registrant r;
                r = (Registrant) registrants.get(i);
                r.internalNotifyRegistrant(result, exception);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0, s = registrants.size(); i < s ; i++) {
            //Registrant  r = (Registrant) registrants.get(i);
            //r.internalNotifyRegistrant(result, exception);
       //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.863 -0400", hash_original_method = "A0C1E30CB6CF686D3BFBF211B23BCEDA", hash_generated_method = "A25C128914FDFE95CBCD82C7E1C4B72D")
    @DSModeled(DSC.SAFE)
    public void notifyRegistrants() {
        internalNotifyRegistrants(null, null);
        // ---------- Original Method ----------
        //internalNotifyRegistrants(null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.864 -0400", hash_original_method = "E10B485B8A4459DFBA6D5822C64B9581", hash_generated_method = "A7E7B765488C2D806998AE8E8E9D6ADB")
    @DSModeled(DSC.SAFE)
    public void notifyException(Throwable exception) {
        dsTaint.addTaint(exception.dsTaint);
        internalNotifyRegistrants (null, exception);
        // ---------- Original Method ----------
        //internalNotifyRegistrants (null, exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.864 -0400", hash_original_method = "42A5B1B813660DAC9459B35E8E550912", hash_generated_method = "BC8DE5AA48D19C1EBF3B099BDF66610E")
    @DSModeled(DSC.SAFE)
    public void notifyResult(Object result) {
        dsTaint.addTaint(result.dsTaint);
        internalNotifyRegistrants (result, null);
        // ---------- Original Method ----------
        //internalNotifyRegistrants (result, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.864 -0400", hash_original_method = "3908519F6CDCE90B78E1C606E34FED53", hash_generated_method = "47F5C3C6BD341B75F52A2FE2644D7527")
    @DSModeled(DSC.SAFE)
    public void notifyRegistrants(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
        internalNotifyRegistrants(ar.result, ar.exception);
        // ---------- Original Method ----------
        //internalNotifyRegistrants(ar.result, ar.exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.864 -0400", hash_original_method = "7E8729949AA2AB03621660BB8AC59F70", hash_generated_method = "9B18B7DB91D0916DBF4C816092028D31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void remove(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        {
            int i, s;
            i = 0;
            s = registrants.size();
            {
                Registrant r;
                r = (Registrant) registrants.get(i);
                Handler rh;
                rh = r.getHandler();
                {
                    r.clear();
                } //End block
            } //End block
        } //End collapsed parenthetic
        removeCleared();
        // ---------- Original Method ----------
        //for (int i = 0, s = registrants.size() ; i < s ; i++) {
            //Registrant  r = (Registrant) registrants.get(i);
            //Handler     rh;
            //rh = r.getHandler();
            //if (rh == null || rh == h) {
                //r.clear();
            //}
        //}
        //removeCleared();
    }

    
}


