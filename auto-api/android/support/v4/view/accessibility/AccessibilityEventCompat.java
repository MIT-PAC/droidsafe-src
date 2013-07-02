package android.support.v4.view.accessibility;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

public class AccessibilityEventCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.431 -0400", hash_original_method = "7235302697174B91ED05919A9677679C", hash_generated_method = "537EB0F8C8251B969DD646E3655E17D3")
    private  AccessibilityEventCompat() {
        
    }

    
    public static int getRecordCount(AccessibilityEvent event) {
        return IMPL.getRecordCount(event);
    }

    
    public static void appendRecord(AccessibilityEvent event, AccessibilityRecordCompat record) {
        IMPL.appendRecord(event, record.getImpl());
    }

    
    public static AccessibilityRecordCompat getRecord(AccessibilityEvent event, int index) {
        return new AccessibilityRecordCompat(IMPL.getRecord(event, index));
    }

    
    static class AccessibilityEventStubImpl implements AccessibilityEventVersionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.432 -0400", hash_original_method = "49184BA4C73C970BF616A8E1EB656B67", hash_generated_method = "49184BA4C73C970BF616A8E1EB656B67")
        public AccessibilityEventStubImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.433 -0400", hash_original_method = "6DC417BFFFF374A16DB9A049CC5CFE7B", hash_generated_method = "554AEF757AD4BB8AE9D6AE9956FA9708")
        @Override
        public void appendRecord(AccessibilityEvent event, Object record) {
            addTaint(event.getTaint());
            addTaint(record.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.434 -0400", hash_original_method = "0011894BC70FDA6596188C683FDF537A", hash_generated_method = "A9019009F3D49340893D803B70FA613C")
        @Override
        public Object getRecord(AccessibilityEvent event, int index) {
            Object varB4EAC82CA7396A68D541C85D26508E83_2020411161 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2020411161 = null;
            addTaint(event.getTaint());
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_2020411161.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2020411161;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.435 -0400", hash_original_method = "57C8A18205681899A54255474D3D91AF", hash_generated_method = "EE149645A2F162768C8456E9181A960A")
        @Override
        public int getRecordCount(AccessibilityEvent event) {
            addTaint(event.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_251472255 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_251472255;
            
            
        }

        
    }


    
    static class AccessibilityEventIcsImpl extends AccessibilityEventStubImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.440 -0400", hash_original_method = "B5BE2109A6DAB61B9BC4DD5D6C5CF976", hash_generated_method = "B5BE2109A6DAB61B9BC4DD5D6C5CF976")
        public AccessibilityEventIcsImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.441 -0400", hash_original_method = "528A3D0D7039D653C3E30DD2B22DE649", hash_generated_method = "1EDE0AF47D78A2881D4F88EAE9275D2B")
        @Override
        public void appendRecord(AccessibilityEvent event, Object record) {
            AccessibilityEventCompatIcs.appendRecord(event, record);
            addTaint(event.getTaint());
            addTaint(record.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.442 -0400", hash_original_method = "A698E5305C0DF071EDEE66EFAE00872C", hash_generated_method = "190BE7EF3B1CB159003A426A3BCF89EE")
        @Override
        public Object getRecord(AccessibilityEvent event, int index) {
            Object varB4EAC82CA7396A68D541C85D26508E83_2112826027 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2112826027 = AccessibilityEventCompatIcs.getRecord(event, index);
            addTaint(event.getTaint());
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_2112826027.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2112826027;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.443 -0400", hash_original_method = "B6B9307BAAEBF97CF1A6D54D89E71B99", hash_generated_method = "EF6757D9CAC4D85AA086BFCCD72A5C01")
        @Override
        public int getRecordCount(AccessibilityEvent event) {
            int var3AE8632AE082997CD0EA265BABDD9615_929078337 = (AccessibilityEventCompatIcs.getRecordCount(event));
            addTaint(event.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836140559 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836140559;
            
            
        }

        
    }


    
    static interface AccessibilityEventVersionImpl {
        public int getRecordCount(AccessibilityEvent event);
        public void appendRecord(AccessibilityEvent event, Object record);
        public Object getRecord(AccessibilityEvent event, int index);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.443 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "4324F97AEF46831155DDBB54D409FF66")

    private static AccessibilityEventVersionImpl IMPL;
    static {
        if (Build.VERSION.SDK_INT >= 14) { 
            IMPL = new AccessibilityEventIcsImpl();
        } else {
            IMPL = new AccessibilityEventStubImpl();
        }
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.444 -0400", hash_original_field = "682B4667B2E14C813F6FB7E8685004E2", hash_generated_field = "FE950ACD1EB76F522B84E4AF57C8EB4E")

    public static final int TYPE_VIEW_HOVER_ENTER = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.444 -0400", hash_original_field = "8B3827358B19D07352F5E4B61B5E45FF", hash_generated_field = "18FE8FEEC4DFCC299D1871533484029C")

    public static final int TYPE_VIEW_HOVER_EXIT = 0x00000100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.444 -0400", hash_original_field = "27E59EDCB3387FEEF330602C38D225F7", hash_generated_field = "241CE14D36798EBC2A23586E200A67F4")

    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 0x00000200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.445 -0400", hash_original_field = "F10DE93AB695DD6D105E8B37EDEEDFF2", hash_generated_field = "BA83447C09FF159FA67B3574E6C27B8C")

    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 0x00000400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.445 -0400", hash_original_field = "F1901586F3217FA9270185C68DFCADFC", hash_generated_field = "78AE73D6DF96970386315118ADB13502")

    public static final int TYPE_WINDOW_CONTENT_CHANGED = 0x00000800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.445 -0400", hash_original_field = "7184B53D897BEEE90B38FBD41E529218", hash_generated_field = "4CA347468789B2191C2D5030F3F1C887")

    public static final int TYPE_VIEW_SCROLLED = 0x00001000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.446 -0400", hash_original_field = "CB33A23DB3E2726687F30510DC8ED665", hash_generated_field = "FD261FCAF58AFDA7AA95FBDB48245FF4")

    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 0x00002000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.446 -0400", hash_original_field = "104097D8D93B2DE6AFDA4623257F7B16", hash_generated_field = "C0EA68A2D37FD542C5D861087BFB7CE8")

    public static final int TYPE_ANNOUNCEMENT = 0x00004000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.446 -0400", hash_original_field = "2DF17B72C23EB6CBDB2A0D1409B1F2BD", hash_generated_field = "70410615CF305FFFBE69D3A87E794625")

    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 0x00008000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.446 -0400", hash_original_field = "DF90FB5C858D4EAFF42F9B670082D04E", hash_generated_field = "BF57397E4E5C2EE32C2358B506B54B1C")

    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 0x00010000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.447 -0400", hash_original_field = "D6555267CF070FFC7CCAAAC6F9F8FFA5", hash_generated_field = "E64CE1CFA8A5E8A0F5354490DD9502EC")

    public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 0x00020000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.447 -0400", hash_original_field = "ED843A87404B0C65272CFC6D400A6CAE", hash_generated_field = "217E21322551E7FCE0FCA6B64A315101")

    public static final int TYPE_GESTURE_DETECTION_START = 0x00040000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.447 -0400", hash_original_field = "2F2C26BFDCB52483B75BA3243BDAF80E", hash_generated_field = "6B4E2DAB210EC6B88F7CA1E4F0990088")

    public static final int TYPE_GESTURE_DETECTION_END = 0x00080000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.447 -0400", hash_original_field = "65B81B90F9BC75E3EA2DEE939F3625F2", hash_generated_field = "B8995E3C3AD32E2FCD524B07F928B050")

    public static final int TYPE_TOUCH_INTERACTION_START = 0x00100000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.448 -0400", hash_original_field = "F319647C6D9E061EBA20C54B34C3164A", hash_generated_field = "6EEC19352074E437B59D57C411EE9CFF")

    public static final int TYPE_TOUCH_INTERACTION_END = 0x00200000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:06:52.448 -0400", hash_original_field = "6DCB32AA8EBE9BEB5FFDEC7994730CE7", hash_generated_field = "5BAD57F63E5D649A21D00BA11B6FBBFC")

    public static final int TYPES_ALL_MASK = 0xFFFFFFFF;
}

