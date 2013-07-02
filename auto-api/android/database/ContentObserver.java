package android.database;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Handler;

public abstract class ContentObserver {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.673 -0400", hash_original_field = "DDB508BA6BDDCDC9D416A8817238314C", hash_generated_field = "02AF804D48FC2EFA36319D85B176604C")

    private Transport mTransport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.673 -0400", hash_original_field = "DD465B0839A70592931A97D99A9DB042", hash_generated_field = "B291AA80E80AF2EADD13F4FAD6374324")

    private Object lock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.673 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.674 -0400", hash_original_method = "DEDF781BC2901F5DB53B414F0A999CAB", hash_generated_method = "256B09D59F656DF49A982C4626C638E5")
    public  ContentObserver(Handler handler) {
        mHandler = handler;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.675 -0400", hash_original_method = "01F21475A40B0383A9D17C9A77564941", hash_generated_method = "87F7DE0776165F2B997179C515CD50BD")
    public IContentObserver getContentObserver() {
        IContentObserver varB4EAC82CA7396A68D541C85D26508E83_794797125 = null; 
        {
            {
                mTransport = new Transport(this);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_794797125 = mTransport;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_794797125.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_794797125;
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.675 -0400", hash_original_method = "0CB42947C64AC2776A7D9A6FF8C462FE", hash_generated_method = "4835350D08438DB90CF642D287A7E135")
    public IContentObserver releaseContentObserver() {
        IContentObserver varB4EAC82CA7396A68D541C85D26508E83_1579604 = null; 
        {
            Transport oldTransport = mTransport;
            {
                oldTransport.releaseContentObserver();
                mTransport = null;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1579604 = oldTransport;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1579604.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1579604;
        
        
            
            
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.676 -0400", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "9E316C1670E8115E9EB321581F74673A")
    public boolean deliverSelfNotifications() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1902271680 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1902271680;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.677 -0400", hash_original_method = "6EAEE94A5AFBBE3CB405FFF6432059B8", hash_generated_method = "43E4B8EB52312D77453544CB6778AF9B")
    public void onChange(boolean selfChange) {
        
        addTaint(selfChange);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.678 -0400", hash_original_method = "16E18AEBF4A0FC6BFB0625D1ABE0E3ED", hash_generated_method = "5CCC8EE4664D233E8BE6AEDBF2646872")
    public final void dispatchChange(boolean selfChange) {
        {
            onChange(selfChange);
        } 
        {
            mHandler.post(new NotificationRunnable(selfChange));
        } 
        addTaint(selfChange);
        
        
            
        
            
        
    }

    
    private final class NotificationRunnable implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.678 -0400", hash_original_field = "9257B96EA3E776729E1D45E7076891EA", hash_generated_field = "7939677200C76A653999F1C89FF176B1")

        private boolean mSelf;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.678 -0400", hash_original_method = "640FAC8E4E08E48125055D1606ED9C9B", hash_generated_method = "8106FFA6B3D07725DE2FEEBDB49EF1E5")
        public  NotificationRunnable(boolean self) {
            mSelf = self;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.679 -0400", hash_original_method = "ADCF046F07EA9B09E2364857C3DDF0F7", hash_generated_method = "30ECC851BB12D6B371695B1BC5CB6757")
        public void run() {
            ContentObserver.this.onChange(mSelf);
            
            
        }

        
    }


    
    private static final class Transport extends IContentObserver.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.679 -0400", hash_original_field = "C267D355D6BA0921A3D8E50CDCC2651C", hash_generated_field = "9DAED586938CBB73A279F50F5ECBF202")

        ContentObserver mContentObserver;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.679 -0400", hash_original_method = "C30CAD402A0C8AFFD18AB2CC7EC4F204", hash_generated_method = "FED9587C99F66F414D9E27DD1EDE5BC9")
        public  Transport(ContentObserver contentObserver) {
            mContentObserver = contentObserver;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.680 -0400", hash_original_method = "158F530B046C6D686908DD95065C53F9", hash_generated_method = "27D29DDBA2D6D5EFE44B0A678CA4F9BC")
        public boolean deliverSelfNotifications() {
            ContentObserver contentObserver = mContentObserver;
            {
                boolean var48E239F26E510CFEEA586BDE1698ED7B_1721034418 = (contentObserver.deliverSelfNotifications());
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_984960313 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_984960313;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.680 -0400", hash_original_method = "71BABE68DF8E341DA3CAF0778B2BD246", hash_generated_method = "708BBFB488DFE690052E3940AB168E28")
        public void onChange(boolean selfChange) {
            
            ContentObserver contentObserver = mContentObserver;
            {
                contentObserver.dispatchChange(selfChange);
            } 
            addTaint(selfChange);
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.681 -0400", hash_original_method = "A0916E3A0DA123DBB345BC81644B70F3", hash_generated_method = "ADD05F525B1B13738DD98FA14B241126")
        public void releaseContentObserver() {
            mContentObserver = null;
            
            
        }

        
    }


    
}

