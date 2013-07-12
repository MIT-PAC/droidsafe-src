package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.805 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.805 -0400", hash_original_field = "D1A330370DBEBA42FF52A0368B62EDD0", hash_generated_field = "3E57A1C4DB07EE64FCEAD72CC440E45E")

    private final Stack<AccessibilityEvent> mScheduledEventStack = new Stack<AccessibilityEvent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.805 -0400", hash_original_field = "7F548E9293768117746509FFDB5A3057", hash_generated_field = "4330EB8AA5A2FE255DBD22415D04ED16")

    private int mCurrentAxis = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.805 -0400", hash_original_field = "C1651C38A7F93096FAEEABE5AEB2FDDD", hash_generated_field = "224025CAF4716F1644AA382FABDDDD40")

    private boolean mLastDownEventHandled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.805 -0400", hash_original_field = "C35004E7DA14679F0A0D20E077785059", hash_generated_field = "8A7EF6B120836C189817F81132C96CE4")

    private boolean mIsLastSelectionStringNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.805 -0400", hash_original_field = "56D9C42186B57F5F56DBBA60DCED4505", hash_generated_field = "20DA94CEADB2B1E6F5C2261C53B2ECE7")

    private int mLastDirection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.806 -0400", hash_original_method = "EF4641FD66F12CE398EFC703194D8E58", hash_generated_method = "2F86D7F6824D2022926CFD290AF26273")
    public  AccessibilityInjector(WebView webView) {
        mWebView = webView;
        ensureWebContentKeyBindings();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.809 -0400", hash_original_method = "EB800BB0EE5BEF185F11F0CA48ECBE70", hash_generated_method = "909F2449EA84227B4506023A900FA399")
    public boolean onKeyEvent(KeyEvent event) {
        
        addTaint(event.getTaint());
    if(isEnterActionKey(event.getKeyCode()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2002332425 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1241593302 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1241593302;
        } 
    if(event.getAction() == KeyEvent.ACTION_UP)        
        {
            boolean varC1651C38A7F93096FAEEABE5AEB2FDDD_633348624 = (mLastDownEventHandled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_310816399 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_310816399;
        } 
        mLastDownEventHandled = false;
        AccessibilityWebContentKeyBinding binding = null;
for(AccessibilityWebContentKeyBinding candidate : sBindings)
        {
    if(event.getKeyCode() == candidate.getKeyCode()
                    && event.hasModifiers(candidate.getModifiers()))            
            {
                binding = candidate;
                break;
            } 
        } 
    if(binding == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1774168662 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2036293927 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2036293927;
        } 
for(int i = 0, count = binding.getActionCount();i < count;i++)
        {
            int actionCode = binding.getActionCode(i);
            String contentDescription = Integer.toHexString(binding.getAction(i));
switch(actionCode){
            case ACTION_SET_CURRENT_AXIS:
            int axis = binding.getFirstArgument(i);
            boolean sendEvent = (binding.getSecondArgument(i) == 1);
            setCurrentAxis(axis, sendEvent, contentDescription);
            mLastDownEventHandled = true;
            break;
            case ACTION_TRAVERSE_CURRENT_AXIS:
            int direction = binding.getFirstArgument(i);
    if(direction == mLastDirection && mIsLastSelectionStringNull)            
            {
                mIsLastSelectionStringNull = false;
                boolean var68934A3E9455FA72420237EB05902327_642173775 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1716916734 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1716916734;
            } 
            mLastDirection = direction;
            sendEvent = (binding.getSecondArgument(i) == 1);
            mLastDownEventHandled = traverseCurrentAxis(direction, sendEvent,
                            contentDescription);
            break;
            case ACTION_TRAVERSE_GIVEN_AXIS:
            direction = binding.getFirstArgument(i);
    if(direction == mLastDirection && mIsLastSelectionStringNull)            
            {
                mIsLastSelectionStringNull = false;
                boolean var68934A3E9455FA72420237EB05902327_1947360443 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_527657765 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_527657765;
            } 
            mLastDirection = direction;
            axis =  binding.getSecondArgument(i);
            sendEvent = (binding.getThirdArgument(i) == 1);
            traverseGivenAxis(direction, axis, sendEvent, contentDescription);
            mLastDownEventHandled = true;
            break;
            case ACTION_PERFORM_AXIS_TRANSITION:
            int fromAxis = binding.getFirstArgument(i);
            int toAxis = binding.getSecondArgument(i);
            sendEvent = (binding.getThirdArgument(i) == 1);
            prefromAxisTransition(fromAxis, toAxis, sendEvent, contentDescription);
            mLastDownEventHandled = true;
            break;
            case ACTION_TRAVERSE_DEFAULT_WEB_VIEW_BEHAVIOR_AXIS:
    if(mCurrentAxis == NAVIGATION_AXIS_DEFAULT_WEB_VIEW_BEHAVIOR)            
            {
                mLastDirection = binding.getFirstArgument(i);
                sendEvent = (binding.getSecondArgument(i) == 1);
                traverseGivenAxis(mLastDirection, NAVIGATION_AXIS_DEFAULT_WEB_VIEW_BEHAVIOR,
                            sendEvent, contentDescription);
                mLastDownEventHandled = false;
            } 
            else
            {
                mLastDownEventHandled = true;
            } 
            break;
            default:
}
        } 
        boolean varC1651C38A7F93096FAEEABE5AEB2FDDD_560156808 = (mLastDownEventHandled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1241110265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1241110265;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.810 -0400", hash_original_method = "3B116BB7452CBE6872A5E570E7D08041", hash_generated_method = "9C005923B78F09727FF20186EF2353DE")
    private void setCurrentAxis(int axis, boolean sendEvent, String contentDescription) {
        addTaint(contentDescription.getTaint());
        addTaint(sendEvent);
        mCurrentAxis = axis;
    if(sendEvent)        
        {
            AccessibilityEvent event = getPartialyPopulatedAccessibilityEvent();
            event.getText().add(String.valueOf(axis));
            event.setContentDescription(contentDescription);
            sendAccessibilityEvent(event);
        } 
        
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.810 -0400", hash_original_method = "60CFCAC68A8E46E83373A5BD6B186EBB", hash_generated_method = "6F06C03EC59681E59269B33F0E12B5A7")
    private void prefromAxisTransition(int fromAxis, int toAxis, boolean sendEvent,
            String contentDescription) {
        addTaint(contentDescription.getTaint());
        addTaint(sendEvent);
        addTaint(toAxis);
        addTaint(fromAxis);
    if(mCurrentAxis == fromAxis)        
        {
            setCurrentAxis(toAxis, sendEvent, contentDescription);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.810 -0400", hash_original_method = "FD1B61A72867CD7ABA9E4FFEC34475BF", hash_generated_method = "055454F7DFF5F7D95C57B9B98B993965")
    private boolean traverseCurrentAxis(int direction, boolean sendEvent,
            String contentDescription) {
        addTaint(contentDescription.getTaint());
        addTaint(sendEvent);
        addTaint(direction);
        boolean var68361291D1B55A22856F2004E68E620B_1505318032 = (traverseGivenAxis(direction, mCurrentAxis, sendEvent, contentDescription));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_154667563 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_154667563;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.811 -0400", hash_original_method = "D76A1821B2762F1F39CCFC0B2614F6FE", hash_generated_method = "253A7261E71D6FEAE16F58CB9D7FC913")
    private boolean traverseGivenAxis(int direction, int axis, boolean sendEvent,
            String contentDescription) {
        addTaint(contentDescription.getTaint());
        addTaint(sendEvent);
        addTaint(axis);
        addTaint(direction);
        WebViewCore webViewCore = mWebView.getWebViewCore();
    if(webViewCore == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_381554276 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_73143011 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_73143011;
        } 
        AccessibilityEvent event = null;
    if(sendEvent)        
        {
            event = getPartialyPopulatedAccessibilityEvent();
            event.setContentDescription(contentDescription);
        } 
        mScheduledEventStack.push(event);
    if(axis == NAVIGATION_AXIS_DEFAULT_WEB_VIEW_BEHAVIOR)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1053702465 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1933698362 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1933698362;
        } 
        webViewCore.sendMessage(EventHub.MODIFY_SELECTION, direction, axis);
        boolean varB326B5062B2F0E69046810717534CB09_1852703163 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1485718660 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1485718660;
        
        
        
            
        
        
        
            
            
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.812 -0400", hash_original_method = "C444A575AEA295F9C8E995BA1405A425", hash_generated_method = "DEF6ED9ECF768097014613BE17F54785")
    public void onSelectionStringChange(String selectionString) {
        
    if(DEBUG)        
        {
            Log.d(LOG_TAG, "Selection string: " + selectionString);
        } 
        mIsLastSelectionStringNull = (selectionString == null);
    if(mScheduledEventStack.isEmpty())        
        {
            return;
        } 
        AccessibilityEvent event = mScheduledEventStack.pop();
    if(event != null)        
        {
            event.getText().add(selectionString);
            sendAccessibilityEvent(event);
        } 
        
        
            
        
        
        
            
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.812 -0400", hash_original_method = "A93E1B734733D18B27A729FA6BA2D3D4", hash_generated_method = "3EC130305D7F73985F55B3A610D4C3C7")
    private void sendAccessibilityEvent(AccessibilityEvent event) {
        addTaint(event.getTaint());
    if(DEBUG)        
        {
            Log.d(LOG_TAG, "Dispatching: " + event);
        } 
        AccessibilityManager accessibilityManager = AccessibilityManager.getInstance(mWebView.getContext());
    if(accessibilityManager.isEnabled())        
        {
            accessibilityManager.sendAccessibilityEvent(event);
        } 
        
        
            
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.812 -0400", hash_original_method = "97CE5C613C0F00A9204AE55F86D0A1E4", hash_generated_method = "66FBA4955D36F0E282DF3132740768C6")
    private AccessibilityEvent getPartialyPopulatedAccessibilityEvent() {
        AccessibilityEvent event = AccessibilityEvent.obtain(AccessibilityEvent.TYPE_VIEW_SELECTED);
        event.setClassName(mWebView.getClass().getName());
        event.setPackageName(mWebView.getContext().getPackageName());
        event.setEnabled(mWebView.isEnabled());
AccessibilityEvent var3162E7A4A1E5D72F1058A9B39A6A8738_866280981 =         event;
        var3162E7A4A1E5D72F1058A9B39A6A8738_866280981.addTaint(taint);
        return var3162E7A4A1E5D72F1058A9B39A6A8738_866280981;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.813 -0400", hash_original_method = "391E7039B2527FA351ED94B9C1004246", hash_generated_method = "AFAA3A8DCCCF3CD9C3FC40E66BD0B862")
    private void ensureWebContentKeyBindings() {
    if(sBindings.size() > 0)        
        {
            return;
        } 
        String webContentKeyBindingsString = Settings.Secure.getString(
                mWebView.getContext().getContentResolver(),
                Settings.Secure.ACCESSIBILITY_WEB_CONTENT_KEY_BINDINGS);
        SimpleStringSplitter semiColonSplitter = new SimpleStringSplitter(';');
        semiColonSplitter.setString(webContentKeyBindingsString);
        while
(semiColonSplitter.hasNext())        
        {
            String bindingString = semiColonSplitter.next();
    if(TextUtils.isEmpty(bindingString))            
            {
                continue;
            } 
            String[] keyValueArray = bindingString.split("=");
    if(keyValueArray.length != 2)            
            {
                continue;
            } 
            try 
            {
                long keyCodeAndModifiers = Long.decode(keyValueArray[0].trim());
                String[] actionStrings = keyValueArray[1].split(":");
                int[] actions = new int[actionStrings.length];
for(int i = 0, count = actions.length;i < count;i++)
                {
                    actions[i] = Integer.decode(actionStrings[i].trim());
                } 
                sBindings.add(new AccessibilityWebContentKeyBinding(keyCodeAndModifiers, actions));
            } 
            catch (NumberFormatException nfe)
            {
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.813 -0400", hash_original_method = "6AB19E93948D2A1BBE98A475D0E38626", hash_generated_method = "199F113469D37A2C9E47987BBC5834EB")
    private boolean isEnterActionKey(int keyCode) {
        addTaint(keyCode);
        boolean var70CD4F4EC1EE6CA63BEE6D7DF6CF566D_577580114 = (keyCode == KeyEvent.KEYCODE_DPAD_CENTER
                || keyCode == KeyEvent.KEYCODE_ENTER
                || keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1839669986 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1839669986;
        
        
                
                
    }

    
    private static final class AccessibilityWebContentKeyBinding {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.814 -0400", hash_original_field = "CFAA3AA1A2D9FBFD8E3F4A62BE28F7AF", hash_generated_field = "ED9AFF5D0BE3F3908705CAFA2BF1844E")

        private long mKeyCodeAndModifiers;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.814 -0400", hash_original_field = "FC1559E434165DEC394AC0678DE16FCB", hash_generated_field = "3C3518CA99FABFDBA4EEED5204CA0958")

        private int [] mActionSequence;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.814 -0400", hash_original_method = "A50D0B5AC0368A8E12CF6CC75EC809BD", hash_generated_method = "798F030C871F13812FE22F360B3AB5E6")
        public  AccessibilityWebContentKeyBinding(long keyCodeAndModifiers, int[] actionSequence) {
            mKeyCodeAndModifiers = keyCodeAndModifiers;
            mActionSequence = actionSequence;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.815 -0400", hash_original_method = "8E50A2B3D320E1E0EE376617185D134A", hash_generated_method = "B1FC79E7E2991C554A9309C6561165F1")
        public int getKeyCode() {
            int varA75A3D80301F215059C189AB3A651AD9_706463768 = ((int) ((mKeyCodeAndModifiers & KEY_CODE_MASK) >> KEY_CODE_OFFSET));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994396333 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994396333;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.815 -0400", hash_original_method = "C813CFA88B40923E17E3BC75AACF9837", hash_generated_method = "66F108A5BD985D0F0AD3A7F5F092DDAD")
        public int getModifiers() {
            int var604E7C877BF7C2FFEE4E8B7678BA2487_290606108 = ((int) ((mKeyCodeAndModifiers & MODIFIERS_MASK) >> MODIFIERS_OFFSET));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1354394643 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1354394643;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.815 -0400", hash_original_method = "7BDD12B6399A0F96D6927AAB9227781B", hash_generated_method = "0028A9CFB16C4420E59C544401866CF6")
        public int getActionCount() {
            int var55EBD6CE5F216B713C69296A75FC4C26_299127183 = (mActionSequence.length);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_827450087 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_827450087;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.815 -0400", hash_original_method = "7D2F0A4FD4E90A95C2DF2F50740199D4", hash_generated_method = "3CA766D5A3A18A09C2147C73B1C18885")
        public int getAction(int index) {
            addTaint(index);
            int varE31817265A0A094F5753AAC0B308FE6C_901183126 = (mActionSequence[index]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_588137305 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_588137305;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.816 -0400", hash_original_method = "CA4B639111BCEE7DB87E06F000E025C0", hash_generated_method = "C75A6F2D44A453D95E8D5381C6FB8A90")
        public int getActionCode(int index) {
            addTaint(index);
            int varECE6401468DA90AB7AC358CBE3757694_1561723605 = ((mActionSequence[index] & ACTION_MASK) >> ACTION_OFFSET);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432940500 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432940500;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.816 -0400", hash_original_method = "D4FD6DE193B436AB1DC7E71BD25D2E14", hash_generated_method = "61DBA3A41B4060B0B74B58CA81220084")
        public int getFirstArgument(int index) {
            addTaint(index);
            int var18D2A268AC6D28E541C200508A0640F7_1377201391 = ((mActionSequence[index] & FIRST_ARGUMENT_MASK) >> FIRST_ARGUMENT_OFFSET);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521355347 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521355347;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.816 -0400", hash_original_method = "632B802F886C3F34DA2DAC0FE9DCCFBA", hash_generated_method = "9276C6FD00791B73F15B41CE3CFBD329")
        public int getSecondArgument(int index) {
            addTaint(index);
            int var35FEAFB18A135150C6FD76566BEE267C_1594472396 = ((mActionSequence[index] & SECOND_ARGUMENT_MASK) >> SECOND_ARGUMENT_OFFSET);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028017536 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028017536;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.816 -0400", hash_original_method = "F37454AACD85ADFC551E32B3CAA53EB4", hash_generated_method = "2ED7A15CD4FA2F9C5A5F6A81496912D8")
        public int getThirdArgument(int index) {
            addTaint(index);
            int var5A96A24059FFDFF4B544F9DA67323D00_1458029286 = ((mActionSequence[index] & THIRD_ARGUMENT_MASK) >> THIRD_ARGUMENT_OFFSET);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128030044 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128030044;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.817 -0400", hash_original_method = "DADE2DD09F8576C0E4A43D6B7E83F05B", hash_generated_method = "4A881EF8B4E75C6C33ECAF6E846FD0CB")
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("modifiers: ");
            builder.append(getModifiers());
            builder.append(", keyCode: ");
            builder.append(getKeyCode());
            builder.append(", actions[");
for(int i = 0, count = getActionCount();i < count;i++)
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
            builder.append("]");
String varF4CF030572656354ACFDF83FEE21D7A6_1764136460 =             builder.toString();
            varF4CF030572656354ACFDF83FEE21D7A6_1764136460.addTaint(taint);
            return varF4CF030572656354ACFDF83FEE21D7A6_1764136460;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.817 -0400", hash_original_field = "0C0B71EEE0395BA6D7CBE31AC5F9AEC2", hash_generated_field = "F8D2FA352C0BA0C64C99BC74D59C6DE5")

        private static final int MODIFIERS_OFFSET = 32;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.817 -0400", hash_original_field = "4505992BBEFFAF0A453237676832770F", hash_generated_field = "F15D255C8A53F382E8E42786FABAD969")

        private static final long MODIFIERS_MASK = 0xFFFFFFF00000000L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.817 -0400", hash_original_field = "268BF15DBF6497E56A11F1B50F6CC54B", hash_generated_field = "20B9B8442924C25F1223DFD4562CD64E")

        private static final int KEY_CODE_OFFSET = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.817 -0400", hash_original_field = "A03F82C7BF66F13BCD5F7E1BEA4E3A63", hash_generated_field = "B2CEF4BD57CC748D47EB33527D82B47A")

        private static final long KEY_CODE_MASK = 0x00000000FFFFFFFFL;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.817 -0400", hash_original_field = "45C52D9E1A24CD6445095FA543065832", hash_generated_field = "8F5435B4DF6B7CFAD8E1946F8438D2B5")

        private static final int ACTION_OFFSET = 24;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.817 -0400", hash_original_field = "8D3C4D3FB51A62D4CB68E91C75A5376D", hash_generated_field = "32DF52DD728ADC6D34953391F47C41D6")

        private static final int ACTION_MASK = 0xFF000000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.817 -0400", hash_original_field = "4B391CE42B2BE595405534F2DF2EFDA9", hash_generated_field = "B9AF7AE6175C7800E8579A20EC2D26D0")

        private static final int FIRST_ARGUMENT_OFFSET = 16;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.817 -0400", hash_original_field = "E9317B50C32C42701F4886DE2617571A", hash_generated_field = "E574C2A0E6EC1F21410525FD57E75FF1")

        private static final int FIRST_ARGUMENT_MASK = 0x00FF0000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.817 -0400", hash_original_field = "6EC87210E442CD14032D5F0F01B65FC7", hash_generated_field = "B17B97D0AC9CE57566EDCD781528A4A2")

        private static final int SECOND_ARGUMENT_OFFSET = 8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.818 -0400", hash_original_field = "AB08A64255E0C7B85E28CCDD77FCEA6F", hash_generated_field = "817F021C237E947C0BC3253F16A7EA47")

        private static final int SECOND_ARGUMENT_MASK = 0x0000FF00;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.818 -0400", hash_original_field = "9E77A176E5CCF91A8D053D3475189A4E", hash_generated_field = "63F3F631667C122A4E9AB568B7FA393E")

        private static final int THIRD_ARGUMENT_OFFSET = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.818 -0400", hash_original_field = "A645DA048CC672D05E187D3253EC1A0B", hash_generated_field = "532061882B38166B9A4AFA798321EC67")

        private static final int THIRD_ARGUMENT_MASK = 0x000000FF;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.818 -0400", hash_original_field = "7A4A6FF299BC184104AF90C5A869703C", hash_generated_field = "355BE79B3786523315A38F99C8EFD0EF")

    private static final String LOG_TAG = "AccessibilityInjector";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.818 -0400", hash_original_field = "BC4FF4C62A62F66D6D2E0A35B84DD24A", hash_generated_field = "0DA17BC1AEF6DBF011A4A750F5A71D57")

    private static final boolean DEBUG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.818 -0400", hash_original_field = "D174E8BCC0AED576327B0F1324BA60E7", hash_generated_field = "12B31C0D92351F48989DB7D421B336D5")

    private static final int ACTION_SET_CURRENT_AXIS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.818 -0400", hash_original_field = "D8B4D1E3B010BB703AB75B54023AF722", hash_generated_field = "58291536D1F80FD93588C2E4178BDAD6")

    private static final int ACTION_TRAVERSE_CURRENT_AXIS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.818 -0400", hash_original_field = "84277BDA8832766167541A97D9B03555", hash_generated_field = "BBB0B8A34D0FE9233A286CF9AF35FBDF")

    private static final int ACTION_TRAVERSE_GIVEN_AXIS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.818 -0400", hash_original_field = "914DC005E92F1387BA3876F25D96B7D9", hash_generated_field = "9DC1A870966F6613A76EDD9AF5A52F83")

    private static final int ACTION_PERFORM_AXIS_TRANSITION = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.818 -0400", hash_original_field = "892EF700461E7EA84893534B3C007ED8", hash_generated_field = "795FF9003847153FEDDC6135D24C99D1")

    private static final int ACTION_TRAVERSE_DEFAULT_WEB_VIEW_BEHAVIOR_AXIS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.818 -0400", hash_original_field = "CEA850454B129A29D1E5F8174751004E", hash_generated_field = "2A75193CE584F6498192A47349148458")

    private static final int NAVIGATION_AXIS_DEFAULT_WEB_VIEW_BEHAVIOR = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.818 -0400", hash_original_field = "9952A1D46E5D034CB3461690E0BC8CAF", hash_generated_field = "4C5C7E9C43BB16E424C598EA8932A1C4")

    private static ArrayList<AccessibilityWebContentKeyBinding> sBindings = new ArrayList<AccessibilityWebContentKeyBinding>();
}

