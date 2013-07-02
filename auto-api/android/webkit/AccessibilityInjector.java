package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.TextUtils.SimpleStringSplitter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebViewCore.EventHub;
import java.util.ArrayList;
import java.util.Stack;

class AccessibilityInjector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.543 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.543 -0400", hash_original_field = "D1A330370DBEBA42FF52A0368B62EDD0", hash_generated_field = "3E57A1C4DB07EE64FCEAD72CC440E45E")

    private final Stack<AccessibilityEvent> mScheduledEventStack = new Stack<AccessibilityEvent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.543 -0400", hash_original_field = "7F548E9293768117746509FFDB5A3057", hash_generated_field = "4330EB8AA5A2FE255DBD22415D04ED16")

    private int mCurrentAxis = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.543 -0400", hash_original_field = "C1651C38A7F93096FAEEABE5AEB2FDDD", hash_generated_field = "224025CAF4716F1644AA382FABDDDD40")

    private boolean mLastDownEventHandled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.543 -0400", hash_original_field = "C35004E7DA14679F0A0D20E077785059", hash_generated_field = "8A7EF6B120836C189817F81132C96CE4")

    private boolean mIsLastSelectionStringNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.543 -0400", hash_original_field = "56D9C42186B57F5F56DBBA60DCED4505", hash_generated_field = "20DA94CEADB2B1E6F5C2261C53B2ECE7")

    private int mLastDirection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.544 -0400", hash_original_method = "EF4641FD66F12CE398EFC703194D8E58", hash_generated_method = "2F86D7F6824D2022926CFD290AF26273")
    public  AccessibilityInjector(WebView webView) {
        mWebView = webView;
        ensureWebContentKeyBindings();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.559 -0400", hash_original_method = "EB800BB0EE5BEF185F11F0CA48ECBE70", hash_generated_method = "49922615E174B31FB554D2F27DA0F02B")
    public boolean onKeyEvent(KeyEvent event) {
        
        {
            boolean var2964D75E6F1F5379056302BD290CFBBC_1808753112 = (isEnterActionKey(event.getKeyCode()));
        } 
        {
            boolean varCEE3787BA6CC35DE8C5C148EB02E679E_990617401 = (event.getAction() == KeyEvent.ACTION_UP);
        } 
        mLastDownEventHandled = false;
        AccessibilityWebContentKeyBinding binding = null;
        {
            Iterator<AccessibilityWebContentKeyBinding> var75D817242CC163C72A2B345E5E7E8568_275737964 = (sBindings).iterator();
            var75D817242CC163C72A2B345E5E7E8568_275737964.hasNext();
            AccessibilityWebContentKeyBinding candidate = var75D817242CC163C72A2B345E5E7E8568_275737964.next();
            {
                {
                    boolean varF74C93D19B4CBA4D7890314550B6A4A6_543923372 = (event.getKeyCode() == candidate.getKeyCode()
                    && event.hasModifiers(candidate.getModifiers()));
                    {
                        binding = candidate;
                    } 
                } 
            } 
        } 
        {
            int i = 0;
            int count = binding.getActionCount();
            {
                int actionCode = binding.getActionCode(i);
                String contentDescription = Integer.toHexString(binding.getAction(i));
                
                int axis = binding.getFirstArgument(i);
                
                
                boolean sendEvent = (binding.getSecondArgument(i) == 1);
                
                
                setCurrentAxis(axis, sendEvent, contentDescription);
                
                
                mLastDownEventHandled = true;
                
                
                int direction = binding.getFirstArgument(i);
                
                
                {
                    mIsLastSelectionStringNull = false;
                } 
                
                
                mLastDirection = direction;
                
                
                sendEvent = (binding.getSecondArgument(i) == 1);
                
                
                mLastDownEventHandled = traverseCurrentAxis(direction, sendEvent,
                            contentDescription);
                
                
                direction = binding.getFirstArgument(i);
                
                
                {
                    mIsLastSelectionStringNull = false;
                } 
                
                
                mLastDirection = direction;
                
                
                axis =  binding.getSecondArgument(i);
                
                
                sendEvent = (binding.getThirdArgument(i) == 1);
                
                
                traverseGivenAxis(direction, axis, sendEvent, contentDescription);
                
                
                mLastDownEventHandled = true;
                
                
                int fromAxis = binding.getFirstArgument(i);
                
                
                int toAxis = binding.getSecondArgument(i);
                
                
                sendEvent = (binding.getThirdArgument(i) == 1);
                
                
                prefromAxisTransition(fromAxis, toAxis, sendEvent, contentDescription);
                
                
                mLastDownEventHandled = true;
                
                
                {
                    mLastDirection = binding.getFirstArgument(i);
                    sendEvent = (binding.getSecondArgument(i) == 1);
                    traverseGivenAxis(mLastDirection, NAVIGATION_AXIS_DEFAULT_WEB_VIEW_BEHAVIOR,
                            sendEvent, contentDescription);
                    mLastDownEventHandled = false;
                } 
                {
                    mLastDownEventHandled = true;
                } 
                
            } 
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1841454870 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1841454870;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.560 -0400", hash_original_method = "3B116BB7452CBE6872A5E570E7D08041", hash_generated_method = "A246A272F3453DF219332A1E99175C7E")
    private void setCurrentAxis(int axis, boolean sendEvent, String contentDescription) {
        mCurrentAxis = axis;
        {
            AccessibilityEvent event = getPartialyPopulatedAccessibilityEvent();
            event.getText().add(String.valueOf(axis));
            event.setContentDescription(contentDescription);
            sendAccessibilityEvent(event);
        } 
        addTaint(sendEvent);
        addTaint(contentDescription.getTaint());
        
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.560 -0400", hash_original_method = "60CFCAC68A8E46E83373A5BD6B186EBB", hash_generated_method = "2C9C52B5586EAA2862069B4B9A12D228")
    private void prefromAxisTransition(int fromAxis, int toAxis, boolean sendEvent,
            String contentDescription) {
        {
            setCurrentAxis(toAxis, sendEvent, contentDescription);
        } 
        addTaint(fromAxis);
        addTaint(toAxis);
        addTaint(sendEvent);
        addTaint(contentDescription.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.560 -0400", hash_original_method = "FD1B61A72867CD7ABA9E4FFEC34475BF", hash_generated_method = "44F9CED6F0FD0DF7237828CAD86C340F")
    private boolean traverseCurrentAxis(int direction, boolean sendEvent,
            String contentDescription) {
        boolean var956738CB2E778C2CA33EB6671A7DEDFD_1944727068 = (traverseGivenAxis(direction, mCurrentAxis, sendEvent, contentDescription));
        addTaint(direction);
        addTaint(sendEvent);
        addTaint(contentDescription.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2126381808 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2126381808;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.561 -0400", hash_original_method = "D76A1821B2762F1F39CCFC0B2614F6FE", hash_generated_method = "5F3B5D156CEB7985D373E9CD681C88B6")
    private boolean traverseGivenAxis(int direction, int axis, boolean sendEvent,
            String contentDescription) {
        WebViewCore webViewCore = mWebView.getWebViewCore();
        AccessibilityEvent event = null;
        {
            event = getPartialyPopulatedAccessibilityEvent();
            event.setContentDescription(contentDescription);
        } 
        mScheduledEventStack.push(event);
        webViewCore.sendMessage(EventHub.MODIFY_SELECTION, direction, axis);
        addTaint(direction);
        addTaint(axis);
        addTaint(sendEvent);
        addTaint(contentDescription.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_694875335 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_694875335;
        
        
        
            
        
        
        
            
            
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.561 -0400", hash_original_method = "C444A575AEA295F9C8E995BA1405A425", hash_generated_method = "A60D418917B3001C215CB897C3EE8C3B")
    public void onSelectionStringChange(String selectionString) {
        
        {
            Log.d(LOG_TAG, "Selection string: " + selectionString);
        } 
        mIsLastSelectionStringNull = (selectionString == null);
        {
            boolean var420EBB15FD269B45EC982C512D58732B_1879797251 = (mScheduledEventStack.isEmpty());
        } 
        AccessibilityEvent event = mScheduledEventStack.pop();
        {
            event.getText().add(selectionString);
            sendAccessibilityEvent(event);
        } 
        
        
            
        
        
        
            
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.562 -0400", hash_original_method = "A93E1B734733D18B27A729FA6BA2D3D4", hash_generated_method = "63469AA36BCC46C3811F2B224B15257A")
    private void sendAccessibilityEvent(AccessibilityEvent event) {
        {
            Log.d(LOG_TAG, "Dispatching: " + event);
        } 
        AccessibilityManager accessibilityManager = AccessibilityManager.getInstance(mWebView.getContext());
        {
            boolean var47733DA0ED268A7603912057BB45854B_1726876270 = (accessibilityManager.isEnabled());
            {
                accessibilityManager.sendAccessibilityEvent(event);
            } 
        } 
        addTaint(event.getTaint());
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.562 -0400", hash_original_method = "97CE5C613C0F00A9204AE55F86D0A1E4", hash_generated_method = "6BA9EFA5DDE8D92778F350E6EC6727C7")
    private AccessibilityEvent getPartialyPopulatedAccessibilityEvent() {
        AccessibilityEvent varB4EAC82CA7396A68D541C85D26508E83_1397111362 = null; 
        AccessibilityEvent event = AccessibilityEvent.obtain(AccessibilityEvent.TYPE_VIEW_SELECTED);
        event.setClassName(mWebView.getClass().getName());
        event.setPackageName(mWebView.getContext().getPackageName());
        event.setEnabled(mWebView.isEnabled());
        varB4EAC82CA7396A68D541C85D26508E83_1397111362 = event;
        varB4EAC82CA7396A68D541C85D26508E83_1397111362.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1397111362;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.563 -0400", hash_original_method = "391E7039B2527FA351ED94B9C1004246", hash_generated_method = "EC584225638C1986D71A4A956A80E98B")
    private void ensureWebContentKeyBindings() {
        {
            boolean var6B7CD2D285653ADDA05685B01C7CB438_1069614855 = (sBindings.size() > 0);
        } 
        String webContentKeyBindingsString = Settings.Secure.getString(
                mWebView.getContext().getContentResolver(),
                Settings.Secure.ACCESSIBILITY_WEB_CONTENT_KEY_BINDINGS);
        SimpleStringSplitter semiColonSplitter = new SimpleStringSplitter(';');
        semiColonSplitter.setString(webContentKeyBindingsString);
        {
            boolean var31424E76797A103C5B3C4482299A3938_754143607 = (semiColonSplitter.hasNext());
            {
                String bindingString = semiColonSplitter.next();
                {
                    boolean var796F041A7ECC98C6880099122F8E0173_485344973 = (TextUtils.isEmpty(bindingString));
                } 
                String[] keyValueArray = bindingString.split("=");
                try 
                {
                    long keyCodeAndModifiers = Long.decode(keyValueArray[0].trim());
                    String[] actionStrings = keyValueArray[1].split(":");
                    int[] actions = new int[actionStrings.length];
                    {
                        int i = 0;
                        int count = actions.length;
                        {
                            actions[i] = Integer.decode(actionStrings[i].trim());
                        } 
                    } 
                    sBindings.add(new AccessibilityWebContentKeyBinding(keyCodeAndModifiers, actions));
                } 
                catch (NumberFormatException nfe)
                { }
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.564 -0400", hash_original_method = "6AB19E93948D2A1BBE98A475D0E38626", hash_generated_method = "5CF18E97F684D6062CFC6F0E540926C3")
    private boolean isEnterActionKey(int keyCode) {
        addTaint(keyCode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_930292450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_930292450;
        
        
                
                
    }

    
    private static final class AccessibilityWebContentKeyBinding {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.565 -0400", hash_original_field = "CFAA3AA1A2D9FBFD8E3F4A62BE28F7AF", hash_generated_field = "ED9AFF5D0BE3F3908705CAFA2BF1844E")

        private long mKeyCodeAndModifiers;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.565 -0400", hash_original_field = "FC1559E434165DEC394AC0678DE16FCB", hash_generated_field = "3C3518CA99FABFDBA4EEED5204CA0958")

        private int [] mActionSequence;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.565 -0400", hash_original_method = "A50D0B5AC0368A8E12CF6CC75EC809BD", hash_generated_method = "798F030C871F13812FE22F360B3AB5E6")
        public  AccessibilityWebContentKeyBinding(long keyCodeAndModifiers, int[] actionSequence) {
            mKeyCodeAndModifiers = keyCodeAndModifiers;
            mActionSequence = actionSequence;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.566 -0400", hash_original_method = "8E50A2B3D320E1E0EE376617185D134A", hash_generated_method = "4A6A906C306BB3927EA729D133B0A70B")
        public int getKeyCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502555969 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502555969;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.566 -0400", hash_original_method = "C813CFA88B40923E17E3BC75AACF9837", hash_generated_method = "61E173FBA91E38CEC309F87BC8C30BBB")
        public int getModifiers() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1642200476 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1642200476;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.566 -0400", hash_original_method = "7BDD12B6399A0F96D6927AAB9227781B", hash_generated_method = "177D2C0A42D1BABB3122E9575F2A2FBF")
        public int getActionCount() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_759904255 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_759904255;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.567 -0400", hash_original_method = "7D2F0A4FD4E90A95C2DF2F50740199D4", hash_generated_method = "874652BB8C798C2C762A2E82A15EB968")
        public int getAction(int index) {
            addTaint(index);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1026212143 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1026212143;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.567 -0400", hash_original_method = "CA4B639111BCEE7DB87E06F000E025C0", hash_generated_method = "9F4C9CC6DD76A62D91382E1B47A3736B")
        public int getActionCode(int index) {
            addTaint(index);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1412446 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1412446;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.567 -0400", hash_original_method = "D4FD6DE193B436AB1DC7E71BD25D2E14", hash_generated_method = "DFA12510B98EDE9AEDD1B9446A7488A0")
        public int getFirstArgument(int index) {
            addTaint(index);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_140090538 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_140090538;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.568 -0400", hash_original_method = "632B802F886C3F34DA2DAC0FE9DCCFBA", hash_generated_method = "088B8D69359D8C8A969D84FCC72E71AB")
        public int getSecondArgument(int index) {
            addTaint(index);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14019774 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14019774;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.568 -0400", hash_original_method = "F37454AACD85ADFC551E32B3CAA53EB4", hash_generated_method = "DFA6B635555ABDF7028BAF2F90014279")
        public int getThirdArgument(int index) {
            addTaint(index);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_646907216 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_646907216;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_method = "DADE2DD09F8576C0E4A43D6B7E83F05B", hash_generated_method = "47D4FE4F6E729228539C7BB29535551D")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_618242534 = null; 
            StringBuilder builder = new StringBuilder();
            builder.append("modifiers: ");
            builder.append(getModifiers());
            builder.append(", keyCode: ");
            builder.append(getKeyCode());
            builder.append(", actions[");
            {
                int i = 0;
                int count = getActionCount();
                {
                    builder.append("{actionCode");
                    builder.append(i);
                    builder.append(": ");
                    builder.append(getActionCode(i));
                    builder.append(", firstArgument: ");
                    builder.append(getFirstArgument(i));
                    builder.append(", secondArgument: ");
                    builder.append(getSecondArgument(i));
                    builder.append(", thirdArgument: ");
                    builder.append(getThirdArgument(i));
                    builder.append("}");
                } 
            } 
            builder.append("]");
            varB4EAC82CA7396A68D541C85D26508E83_618242534 = builder.toString();
            varB4EAC82CA7396A68D541C85D26508E83_618242534.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_618242534;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "0C0B71EEE0395BA6D7CBE31AC5F9AEC2", hash_generated_field = "F8D2FA352C0BA0C64C99BC74D59C6DE5")

        private static final int MODIFIERS_OFFSET = 32;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "4505992BBEFFAF0A453237676832770F", hash_generated_field = "F15D255C8A53F382E8E42786FABAD969")

        private static final long MODIFIERS_MASK = 0xFFFFFFF00000000L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "268BF15DBF6497E56A11F1B50F6CC54B", hash_generated_field = "20B9B8442924C25F1223DFD4562CD64E")

        private static final int KEY_CODE_OFFSET = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "A03F82C7BF66F13BCD5F7E1BEA4E3A63", hash_generated_field = "B2CEF4BD57CC748D47EB33527D82B47A")

        private static final long KEY_CODE_MASK = 0x00000000FFFFFFFFL;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "45C52D9E1A24CD6445095FA543065832", hash_generated_field = "8F5435B4DF6B7CFAD8E1946F8438D2B5")

        private static final int ACTION_OFFSET = 24;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "8D3C4D3FB51A62D4CB68E91C75A5376D", hash_generated_field = "32DF52DD728ADC6D34953391F47C41D6")

        private static final int ACTION_MASK = 0xFF000000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "4B391CE42B2BE595405534F2DF2EFDA9", hash_generated_field = "B9AF7AE6175C7800E8579A20EC2D26D0")

        private static final int FIRST_ARGUMENT_OFFSET = 16;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "E9317B50C32C42701F4886DE2617571A", hash_generated_field = "E574C2A0E6EC1F21410525FD57E75FF1")

        private static final int FIRST_ARGUMENT_MASK = 0x00FF0000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "6EC87210E442CD14032D5F0F01B65FC7", hash_generated_field = "B17B97D0AC9CE57566EDCD781528A4A2")

        private static final int SECOND_ARGUMENT_OFFSET = 8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "AB08A64255E0C7B85E28CCDD77FCEA6F", hash_generated_field = "817F021C237E947C0BC3253F16A7EA47")

        private static final int SECOND_ARGUMENT_MASK = 0x0000FF00;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "9E77A176E5CCF91A8D053D3475189A4E", hash_generated_field = "63F3F631667C122A4E9AB568B7FA393E")

        private static final int THIRD_ARGUMENT_OFFSET = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "A645DA048CC672D05E187D3253EC1A0B", hash_generated_field = "532061882B38166B9A4AFA798321EC67")

        private static final int THIRD_ARGUMENT_MASK = 0x000000FF;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "7A4A6FF299BC184104AF90C5A869703C", hash_generated_field = "355BE79B3786523315A38F99C8EFD0EF")

    private static final String LOG_TAG = "AccessibilityInjector";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "BC4FF4C62A62F66D6D2E0A35B84DD24A", hash_generated_field = "0DA17BC1AEF6DBF011A4A750F5A71D57")

    private static final boolean DEBUG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "D174E8BCC0AED576327B0F1324BA60E7", hash_generated_field = "12B31C0D92351F48989DB7D421B336D5")

    private static final int ACTION_SET_CURRENT_AXIS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "D8B4D1E3B010BB703AB75B54023AF722", hash_generated_field = "58291536D1F80FD93588C2E4178BDAD6")

    private static final int ACTION_TRAVERSE_CURRENT_AXIS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "84277BDA8832766167541A97D9B03555", hash_generated_field = "BBB0B8A34D0FE9233A286CF9AF35FBDF")

    private static final int ACTION_TRAVERSE_GIVEN_AXIS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "914DC005E92F1387BA3876F25D96B7D9", hash_generated_field = "9DC1A870966F6613A76EDD9AF5A52F83")

    private static final int ACTION_PERFORM_AXIS_TRANSITION = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "892EF700461E7EA84893534B3C007ED8", hash_generated_field = "795FF9003847153FEDDC6135D24C99D1")

    private static final int ACTION_TRAVERSE_DEFAULT_WEB_VIEW_BEHAVIOR_AXIS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "CEA850454B129A29D1E5F8174751004E", hash_generated_field = "2A75193CE584F6498192A47349148458")

    private static final int NAVIGATION_AXIS_DEFAULT_WEB_VIEW_BEHAVIOR = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.569 -0400", hash_original_field = "9952A1D46E5D034CB3461690E0BC8CAF", hash_generated_field = "4C5C7E9C43BB16E424C598EA8932A1C4")

    private static ArrayList<AccessibilityWebContentKeyBinding> sBindings = new ArrayList<AccessibilityWebContentKeyBinding>();
}

