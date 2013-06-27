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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.322 -0400", hash_original_field = "964B49AD414D4F0E0A989A0E998E41A3", hash_generated_field = "7F96807E8A5E86FE107A4EDE006647AC")

    ArrayList registrants = new ArrayList();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.333 -0400", hash_original_method = "60B287B1A6E3CD9A784E3DBEF9EF68BF", hash_generated_method = "60B287B1A6E3CD9A784E3DBEF9EF68BF")
    public RegistrantList ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.334 -0400", hash_original_method = "D619B6B6CF1BABB74D64C92E930385FE", hash_generated_method = "C7DCEC7C6DC6A152B184A8ED288BA472")
    public synchronized void add(Handler h, int what, Object obj) {
        add(new Registrant(h, what, obj));
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //add(new Registrant(h, what, obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.334 -0400", hash_original_method = "8738C2928375831BBA08E54EFA7A0387", hash_generated_method = "4F53DD311F189B316E6529ABA0F25B2D")
    public synchronized void addUnique(Handler h, int what, Object obj) {
        remove(h);
        add(new Registrant(h, what, obj));
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //remove(h);
        //add(new Registrant(h, what, obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.335 -0400", hash_original_method = "6ACFEC9684204FF0A155D83C1349ED2C", hash_generated_method = "1AC485DA4F823DD2AFC4A42F27BFCCB7")
    public synchronized void add(Registrant r) {
        removeCleared();
        registrants.add(r);
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        //removeCleared();
        //registrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.336 -0400", hash_original_method = "8966BBD177872515B913197EAE844100", hash_generated_method = "4E105F0DD73A985FC19132CD370AC583")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.336 -0400", hash_original_method = "F0EB9E400375C0AD2DEFF1B982C74365", hash_generated_method = "5A2E435284CAE91B9F0E51BA82297025")
    public synchronized int size() {
        int var0F8227621A931405769BDD80479B8708_1542281058 = (registrants.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619099205 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619099205;
        // ---------- Original Method ----------
        //return registrants.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.338 -0400", hash_original_method = "8E803949D880002FCD2B174D60AAE952", hash_generated_method = "C42CE2C08E08D9A9C4238E65055D246F")
    public synchronized Object get(int index) {
        Object varB4EAC82CA7396A68D541C85D26508E83_654722282 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_654722282 = registrants.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_654722282.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_654722282;
        // ---------- Original Method ----------
        //return registrants.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.338 -0400", hash_original_method = "923D2EAB51C3C809A7DC018C31FECFAC", hash_generated_method = "12792FC018496EB8CE2BB9BDC37D440B")
    private synchronized void internalNotifyRegistrants(Object result, Throwable exception) {
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
        addTaint(result.getTaint());
        addTaint(exception.getTaint());
        // ---------- Original Method ----------
        //for (int i = 0, s = registrants.size(); i < s ; i++) {
            //Registrant  r = (Registrant) registrants.get(i);
            //r.internalNotifyRegistrant(result, exception);
       //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.361 -0400", hash_original_method = "A0C1E30CB6CF686D3BFBF211B23BCEDA", hash_generated_method = "58F948B26A2328859A484DC379C9FB82")
    public void notifyRegistrants() {
        internalNotifyRegistrants(null, null);
        // ---------- Original Method ----------
        //internalNotifyRegistrants(null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.362 -0400", hash_original_method = "E10B485B8A4459DFBA6D5822C64B9581", hash_generated_method = "3A59BCA4B66329F8426CD0E7D00A871B")
    public void notifyException(Throwable exception) {
        internalNotifyRegistrants (null, exception);
        addTaint(exception.getTaint());
        // ---------- Original Method ----------
        //internalNotifyRegistrants (null, exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.363 -0400", hash_original_method = "42A5B1B813660DAC9459B35E8E550912", hash_generated_method = "9BC3C84069CBCB639CFA100BF8FC7BEB")
    public void notifyResult(Object result) {
        internalNotifyRegistrants (result, null);
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //internalNotifyRegistrants (result, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.368 -0400", hash_original_method = "3908519F6CDCE90B78E1C606E34FED53", hash_generated_method = "132066F11C17FB54880B87DEEC1BB6BF")
    public void notifyRegistrants(AsyncResult ar) {
        internalNotifyRegistrants(ar.result, ar.exception);
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        //internalNotifyRegistrants(ar.result, ar.exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.369 -0400", hash_original_method = "7E8729949AA2AB03621660BB8AC59F70", hash_generated_method = "F8F4E7802AFFC452229BCE7A1100B8AC")
    public synchronized void remove(Handler h) {
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
        addTaint(h.getTaint());
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

