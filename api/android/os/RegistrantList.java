package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

public class RegistrantList {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.452 -0400", hash_original_field = "964B49AD414D4F0E0A989A0E998E41A3", hash_generated_field = "7F96807E8A5E86FE107A4EDE006647AC")

    ArrayList registrants = new ArrayList();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.452 -0400", hash_original_method = "60B287B1A6E3CD9A784E3DBEF9EF68BF", hash_generated_method = "60B287B1A6E3CD9A784E3DBEF9EF68BF")
    public RegistrantList ()
    {
        
    }


    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.453 -0400", hash_original_method = "D619B6B6CF1BABB74D64C92E930385FE", hash_generated_method = "1C3B7F591F17EAF250C184147BD312F9")
    public synchronized void add(Handler h, int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        add(new Registrant(h, what, obj));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.454 -0400", hash_original_method = "8738C2928375831BBA08E54EFA7A0387", hash_generated_method = "599815918E584BB248E86CA3FA837C29")
    public synchronized void addUnique(Handler h, int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        remove(h);
        add(new Registrant(h, what, obj));
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.455 -0400", hash_original_method = "6ACFEC9684204FF0A155D83C1349ED2C", hash_generated_method = "612ED9BBB21214697F3E3076D20DF123")
    public synchronized void add(Registrant r) {
        addTaint(r.getTaint());
        removeCleared();
        registrants.add(r);
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.455 -0400", hash_original_method = "8966BBD177872515B913197EAE844100", hash_generated_method = "0C1A0F3DF93FFF27DC6A448E2B4C9204")
    public synchronized void removeCleared() {
for(int i = registrants.size() - 1;i >= 0;i--)
        {
            Registrant r = (Registrant) registrants.get(i);
    if(r.refH == null)            
            {
                registrants.remove(i);
            } 
        } 
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.456 -0400", hash_original_method = "F0EB9E400375C0AD2DEFF1B982C74365", hash_generated_method = "CCB7C3712067880834355F46A36F4CFE")
    public synchronized int size() {
        int varABF8F47332369721D26CF0669CAFC883_2127164359 = (registrants.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657562052 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657562052;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.456 -0400", hash_original_method = "8E803949D880002FCD2B174D60AAE952", hash_generated_method = "33BD700BE2212DB200A02A907C2F6543")
    public synchronized Object get(int index) {
        addTaint(index);
Object var0B7A0D5127D9EF03BDFA2AE644A59E47_1942460352 =         registrants.get(index);
        var0B7A0D5127D9EF03BDFA2AE644A59E47_1942460352.addTaint(taint);
        return var0B7A0D5127D9EF03BDFA2AE644A59E47_1942460352;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.457 -0400", hash_original_method = "923D2EAB51C3C809A7DC018C31FECFAC", hash_generated_method = "117A0DD98F2360F200B753E5410A18A4")
    private synchronized void internalNotifyRegistrants(Object result, Throwable exception) {
        addTaint(exception.getTaint());
        addTaint(result.getTaint());
for(int i = 0, s = registrants.size();i < s;i++)
        {
            Registrant r = (Registrant) registrants.get(i);
            r.internalNotifyRegistrant(result, exception);
        } 
        
        
            
            
       
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.458 -0400", hash_original_method = "A0C1E30CB6CF686D3BFBF211B23BCEDA", hash_generated_method = "58F948B26A2328859A484DC379C9FB82")
    public void notifyRegistrants() {
        internalNotifyRegistrants(null, null);
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.458 -0400", hash_original_method = "E10B485B8A4459DFBA6D5822C64B9581", hash_generated_method = "75AE876AFDEEC5DFD57A963AEDB7DCE4")
    public void notifyException(Throwable exception) {
        addTaint(exception.getTaint());
        internalNotifyRegistrants (null, exception);
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.459 -0400", hash_original_method = "42A5B1B813660DAC9459B35E8E550912", hash_generated_method = "B66A395A5A83C78FA03464E94D617BF8")
    public void notifyResult(Object result) {
        addTaint(result.getTaint());
        internalNotifyRegistrants (result, null);
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.459 -0400", hash_original_method = "3908519F6CDCE90B78E1C606E34FED53", hash_generated_method = "2D76B9F34F6F9C8370418D26E6A6217A")
    public void notifyRegistrants(AsyncResult ar) {
        addTaint(ar.getTaint());
        internalNotifyRegistrants(ar.result, ar.exception);
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.460 -0400", hash_original_method = "7E8729949AA2AB03621660BB8AC59F70", hash_generated_method = "E911261135EAFECF4FB302A79CB0D532")
    public synchronized void remove(Handler h) {
        addTaint(h.getTaint());
for(int i = 0, s = registrants.size();i < s;i++)
        {
            Registrant r = (Registrant) registrants.get(i);
            Handler rh;
            rh = r.getHandler();
    if(rh == null || rh == h)            
            {
                r.clear();
            } 
        } 
        removeCleared();
        
        
            
            
            
            
                
            
        
        
    }

    
}

