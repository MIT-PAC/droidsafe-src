package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

public class RegistrantList {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.662 -0500", hash_original_field = "7F96807E8A5E86FE107A4EDE006647AC", hash_generated_field = "7F96807E8A5E86FE107A4EDE006647AC")

    ArrayList   registrants = new ArrayList();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.438 -0400", hash_original_method = "60B287B1A6E3CD9A784E3DBEF9EF68BF", hash_generated_method = "60B287B1A6E3CD9A784E3DBEF9EF68BF")
    public RegistrantList ()
    {
        //Synthesized constructor
    }      // of Registrant

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.665 -0500", hash_original_method = "D619B6B6CF1BABB74D64C92E930385FE", hash_generated_method = "C078BA369D6F529BB4F45333008F0AE2")
    
public synchronized void
    add(Handler h, int what, Object obj)
    {
        add(new Registrant(h, what, obj));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.667 -0500", hash_original_method = "8738C2928375831BBA08E54EFA7A0387", hash_generated_method = "00F180E7EF169475860257C26BE5DE8C")
    
public synchronized void
    addUnique(Handler h, int what, Object obj)
    {
        // if the handler is already in the registrant list, remove it
        remove(h);
        add(new Registrant(h, what, obj));        
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.669 -0500", hash_original_method = "6ACFEC9684204FF0A155D83C1349ED2C", hash_generated_method = "9B100D21F350582A851B881A1EBCD5E4")
    
public synchronized void
    add(Registrant r)
    {
        removeCleared();
        registrants.add(r);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.671 -0500", hash_original_method = "8966BBD177872515B913197EAE844100", hash_generated_method = "E3863668766BA886499A7C30ACA7C7D4")
    
public synchronized void
    removeCleared()
    {
        for (int i = registrants.size() - 1; i >= 0 ; i--) {
            Registrant  r = (Registrant) registrants.get(i);
            
            if (r.refH == null) {
                registrants.remove(i);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.674 -0500", hash_original_method = "F0EB9E400375C0AD2DEFF1B982C74365", hash_generated_method = "29A1A4E433FBCFC5695AA0249C970026")
    
public synchronized int
    size()
    {
        return registrants.size();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.676 -0500", hash_original_method = "8E803949D880002FCD2B174D60AAE952", hash_generated_method = "201473706323896C6EAFA6D338812DA9")
    
public synchronized Object
    get(int index)
    {
        return registrants.get(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.679 -0500", hash_original_method = "923D2EAB51C3C809A7DC018C31FECFAC", hash_generated_method = "8DAFE555768F325F8FF542C6BF8C8427")
    
private synchronized void
    internalNotifyRegistrants (Object result, Throwable exception)
    {
       for (int i = 0, s = registrants.size(); i < s ; i++) {
            Registrant  r = (Registrant) registrants.get(i);
            r.internalNotifyRegistrant(result, exception);
       }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.681 -0500", hash_original_method = "A0C1E30CB6CF686D3BFBF211B23BCEDA", hash_generated_method = "29C93A120359B8DB3BAD48956558C589")
    
public /*synchronized*/ void
    notifyRegistrants()
    {
        internalNotifyRegistrants(null, null);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.683 -0500", hash_original_method = "E10B485B8A4459DFBA6D5822C64B9581", hash_generated_method = "8331705687F4623D77424E3082BC1906")
    
public /*synchronized*/ void
    notifyException(Throwable exception)
    {
        internalNotifyRegistrants (null, exception);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.685 -0500", hash_original_method = "42A5B1B813660DAC9459B35E8E550912", hash_generated_method = "B2AD814C21E22A6C0235EE6EA59EABFD")
    
public /*synchronized*/ void
    notifyResult(Object result)
    {
        internalNotifyRegistrants (result, null);
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.687 -0500", hash_original_method = "3908519F6CDCE90B78E1C606E34FED53", hash_generated_method = "9BD6B76420A710DC1D39A85652D2D37A")
    
public /*synchronized*/ void
    notifyRegistrants(AsyncResult ar)
    {
        internalNotifyRegistrants(ar.result, ar.exception);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.690 -0500", hash_original_method = "7E8729949AA2AB03621660BB8AC59F70", hash_generated_method = "4B77784B7C188414E1D468C0AAECAAAC")
    
public synchronized void
    remove(Handler h)
    {
        for (int i = 0, s = registrants.size() ; i < s ; i++) {
            Registrant  r = (Registrant) registrants.get(i);
            Handler     rh;

            rh = r.getHandler();

            /* Clean up both the requested registrant and
             * any now-collected registrants
             */
            if (rh == null || rh == h) {
                r.clear();
            }
        }

        removeCleared();
    }
    
}

