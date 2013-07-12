package android.database;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Handler;

public abstract class ContentObserver {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.035 -0400", hash_original_field = "DDB508BA6BDDCDC9D416A8817238314C", hash_generated_field = "02AF804D48FC2EFA36319D85B176604C")

    private Transport mTransport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.036 -0400", hash_original_field = "DD465B0839A70592931A97D99A9DB042", hash_generated_field = "B291AA80E80AF2EADD13F4FAD6374324")

    private Object lock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.036 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.036 -0400", hash_original_method = "DEDF781BC2901F5DB53B414F0A999CAB", hash_generated_method = "256B09D59F656DF49A982C4626C638E5")
    public  ContentObserver(Handler handler) {
        mHandler = handler;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.037 -0400", hash_original_method = "01F21475A40B0383A9D17C9A77564941", hash_generated_method = "EA5C8EE2815D751B548102E2EC90F720")
    public IContentObserver getContentObserver() {
        synchronized
(lock)        {
    if(mTransport == null)            
            {
                mTransport = new Transport(this);
            } 
IContentObserver varF2CB7A1EAFE712633AC71AFDD720A221_798126315 =             mTransport;
            varF2CB7A1EAFE712633AC71AFDD720A221_798126315.addTaint(taint);
            return varF2CB7A1EAFE712633AC71AFDD720A221_798126315;
        } 
        
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.038 -0400", hash_original_method = "0CB42947C64AC2776A7D9A6FF8C462FE", hash_generated_method = "9C6DF2C340EF80271A86FF7588970A92")
    public IContentObserver releaseContentObserver() {
        synchronized
(lock)        {
            Transport oldTransport = mTransport;
    if(oldTransport != null)            
            {
                oldTransport.releaseContentObserver();
                mTransport = null;
            } 
IContentObserver var61D75B28C94E2275AC66248604AA2B96_1380456584 =             oldTransport;
            var61D75B28C94E2275AC66248604AA2B96_1380456584.addTaint(taint);
            return var61D75B28C94E2275AC66248604AA2B96_1380456584;
        } 
        
        
            
            
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.039 -0400", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "8C699D353DDA64E02894757F30DD3B90")
    public boolean deliverSelfNotifications() {
        boolean var68934A3E9455FA72420237EB05902327_1339616288 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1517231975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1517231975;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.039 -0400", hash_original_method = "6EAEE94A5AFBBE3CB405FFF6432059B8", hash_generated_method = "43E4B8EB52312D77453544CB6778AF9B")
    public void onChange(boolean selfChange) {
        
        addTaint(selfChange);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.040 -0400", hash_original_method = "16E18AEBF4A0FC6BFB0625D1ABE0E3ED", hash_generated_method = "96E71E866A8763A0E0A9F51947AAFCB3")
    public final void dispatchChange(boolean selfChange) {
        addTaint(selfChange);
    if(mHandler == null)        
        {
            onChange(selfChange);
        } 
        else
        {
            mHandler.post(new NotificationRunnable(selfChange));
        } 
        
        
            
        
            
        
    }

    
    private final class NotificationRunnable implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.041 -0400", hash_original_field = "9257B96EA3E776729E1D45E7076891EA", hash_generated_field = "7939677200C76A653999F1C89FF176B1")

        private boolean mSelf;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.042 -0400", hash_original_method = "640FAC8E4E08E48125055D1606ED9C9B", hash_generated_method = "8106FFA6B3D07725DE2FEEBDB49EF1E5")
        public  NotificationRunnable(boolean self) {
            mSelf = self;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.042 -0400", hash_original_method = "ADCF046F07EA9B09E2364857C3DDF0F7", hash_generated_method = "30ECC851BB12D6B371695B1BC5CB6757")
        public void run() {
            ContentObserver.this.onChange(mSelf);
            
            
        }

        
    }


    
    private static final class Transport extends IContentObserver.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.043 -0400", hash_original_field = "C267D355D6BA0921A3D8E50CDCC2651C", hash_generated_field = "9DAED586938CBB73A279F50F5ECBF202")

        ContentObserver mContentObserver;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.044 -0400", hash_original_method = "C30CAD402A0C8AFFD18AB2CC7EC4F204", hash_generated_method = "FED9587C99F66F414D9E27DD1EDE5BC9")
        public  Transport(ContentObserver contentObserver) {
            mContentObserver = contentObserver;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.044 -0400", hash_original_method = "158F530B046C6D686908DD95065C53F9", hash_generated_method = "F99FE4FAA9E59A55E750FA52EFFF6AE5")
        public boolean deliverSelfNotifications() {
            ContentObserver contentObserver = mContentObserver;
    if(contentObserver != null)            
            {
                boolean varFE2EE6CBCAC1B680CE6770BEA730EF78_2045920372 = (contentObserver.deliverSelfNotifications());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_671714398 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_671714398;
            } 
            boolean var68934A3E9455FA72420237EB05902327_1325465411 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_214653925 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_214653925;
            
            
            
                
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.045 -0400", hash_original_method = "71BABE68DF8E341DA3CAF0778B2BD246", hash_generated_method = "14133A945816033F06407340BD36D671")
        public void onChange(boolean selfChange) {
            
            addTaint(selfChange);
            ContentObserver contentObserver = mContentObserver;
    if(contentObserver != null)            
            {
                contentObserver.dispatchChange(selfChange);
            } 
            
            
            
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.046 -0400", hash_original_method = "A0916E3A0DA123DBB345BC81644B70F3", hash_generated_method = "ADD05F525B1B13738DD98FA14B241126")
        public void releaseContentObserver() {
            mContentObserver = null;
            
            
        }

        
    }


    
}

