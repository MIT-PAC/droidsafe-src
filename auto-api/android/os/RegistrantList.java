package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

public class RegistrantList {
    ArrayList   registrants = new ArrayList();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.135 -0400", hash_original_method = "E255E23F16782FE2AA1416B51525EC81", hash_generated_method = "E255E23F16782FE2AA1416B51525EC81")
        public RegistrantList ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.135 -0400", hash_original_method = "D619B6B6CF1BABB74D64C92E930385FE", hash_generated_method = "14A40D8074D3EC4BDE9B6D3819CA077C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void add(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        add(new Registrant(h, what, obj));
        // ---------- Original Method ----------
        //add(new Registrant(h, what, obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.135 -0400", hash_original_method = "8738C2928375831BBA08E54EFA7A0387", hash_generated_method = "D0E6A2B425CD630A848A6ADFCCA27AAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.136 -0400", hash_original_method = "6ACFEC9684204FF0A155D83C1349ED2C", hash_generated_method = "4E988BC8931BB48D4C1EE401EC543803")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void add(Registrant r) {
        dsTaint.addTaint(r.dsTaint);
        removeCleared();
        registrants.add(r);
        // ---------- Original Method ----------
        //removeCleared();
        //registrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.136 -0400", hash_original_method = "8966BBD177872515B913197EAE844100", hash_generated_method = "4E105F0DD73A985FC19132CD370AC583")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.136 -0400", hash_original_method = "F0EB9E400375C0AD2DEFF1B982C74365", hash_generated_method = "1003226822957957F7DFF873607D221F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int size() {
        int var0F8227621A931405769BDD80479B8708_1191831897 = (registrants.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return registrants.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.136 -0400", hash_original_method = "8E803949D880002FCD2B174D60AAE952", hash_generated_method = "19A269A0708BE1F997BE3F50D9C6660F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized Object get(int index) {
        dsTaint.addTaint(index);
        Object var50B93FE3E10842A4CE107E207BC2D55D_426268475 = (registrants.get(index));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return registrants.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.137 -0400", hash_original_method = "923D2EAB51C3C809A7DC018C31FECFAC", hash_generated_method = "1160789E9BF05D23595315439C747ABC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.137 -0400", hash_original_method = "A0C1E30CB6CF686D3BFBF211B23BCEDA", hash_generated_method = "58F948B26A2328859A484DC379C9FB82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyRegistrants() {
        internalNotifyRegistrants(null, null);
        // ---------- Original Method ----------
        //internalNotifyRegistrants(null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.137 -0400", hash_original_method = "E10B485B8A4459DFBA6D5822C64B9581", hash_generated_method = "188EC63A8B25688E68687CD0BBEB2F1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyException(Throwable exception) {
        dsTaint.addTaint(exception.dsTaint);
        internalNotifyRegistrants (null, exception);
        // ---------- Original Method ----------
        //internalNotifyRegistrants (null, exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.138 -0400", hash_original_method = "42A5B1B813660DAC9459B35E8E550912", hash_generated_method = "CB33BAA63EFD0394FFAC716018B8B069")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyResult(Object result) {
        dsTaint.addTaint(result.dsTaint);
        internalNotifyRegistrants (result, null);
        // ---------- Original Method ----------
        //internalNotifyRegistrants (result, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.138 -0400", hash_original_method = "3908519F6CDCE90B78E1C606E34FED53", hash_generated_method = "D57EFDDCC7A777313AEE727DCB91F397")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyRegistrants(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
        internalNotifyRegistrants(ar.result, ar.exception);
        // ---------- Original Method ----------
        //internalNotifyRegistrants(ar.result, ar.exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.138 -0400", hash_original_method = "7E8729949AA2AB03621660BB8AC59F70", hash_generated_method = "A021CC1A9F0F388AB1404C8C287B04D6")
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

