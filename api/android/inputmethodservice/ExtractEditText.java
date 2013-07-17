package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class ExtractEditText extends EditText {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.147 -0400", hash_original_field = "BB5B873D5AA4316358E44EE9F67CDC3B", hash_generated_field = "451A1E4BDED6910D4643671429CF353C")

    private InputMethodService mIME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.147 -0400", hash_original_field = "AA5A7C446988A5EAB1082BA21E32A53D", hash_generated_field = "AB1C548527F3FF1A47C31A81B3CFA018")

    private int mSettingExtractedText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.148 -0400", hash_original_method = "7A0DE6148CA5B17A67B82391A3703FFF", hash_generated_method = "A54B2D16CEA9673C0951F076CC26E7EF")
    public  ExtractEditText(Context context) {
        super(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.148 -0400", hash_original_method = "4124FA04E6528A50C013D8FF7E28B610", hash_generated_method = "585A2BC23B8722370634F10AD0882A46")
    public  ExtractEditText(Context context, AttributeSet attrs) {
        super(context, attrs, com.android.internal.R.attr.editTextStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.149 -0400", hash_original_method = "E7AB7BAEBF60AF77BB15799C720B6EC6", hash_generated_method = "7EDD7BB777CB73779114D32A3E34407E")
    public  ExtractEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.149 -0400", hash_original_method = "E6DBB41915E723C9F2EECFAC48030375", hash_generated_method = "B5DB85C3F2BB9A526DFFD35933729A52")
     void setIME(InputMethodService ime) {
        mIME = ime;
        // ---------- Original Method ----------
        //mIME = ime;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.150 -0400", hash_original_method = "29AED765F6785A82C9D8840D589CD172", hash_generated_method = "27A568DC538086C464A343B5494E6E51")
    public void startInternalChanges() {
        mSettingExtractedText += 1;
        // ---------- Original Method ----------
        //mSettingExtractedText += 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.150 -0400", hash_original_method = "B6A18168A6952BD0C0F99B7AFD2A1CFC", hash_generated_method = "6D0BECC3D9DA8C9768F35AB3B6B16D1B")
    public void finishInternalChanges() {
        mSettingExtractedText -= 1;
        // ---------- Original Method ----------
        //mSettingExtractedText -= 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.151 -0400", hash_original_method = "6BAFF88F25F6637786E87F71A6E886F7", hash_generated_method = "7432FE4D1A31A23951A3EC8BEAEC333E")
    @Override
    public void setExtractedText(ExtractedText text) {
        addTaint(text.getTaint());
        try 
        {
            mSettingExtractedText++;
            super.setExtractedText(text);
        } //End block
        finally 
        {
            mSettingExtractedText--;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mSettingExtractedText++;
            //super.setExtractedText(text);
        //} finally {
            //mSettingExtractedText--;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.151 -0400", hash_original_method = "FB80BE45A1B322D49A7CF30AB5AC4B14", hash_generated_method = "68D3D5159D39C8765482DEECD871AEF3")
    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(selEnd);
        addTaint(selStart);
        if(mSettingExtractedText == 0 && mIME != null && selStart >= 0 && selEnd >= 0)        
        {
            mIME.onExtractedSelectionChanged(selStart, selEnd);
        } //End block
        // ---------- Original Method ----------
        //if (mSettingExtractedText == 0 && mIME != null && selStart >= 0 && selEnd >= 0) {
            //mIME.onExtractedSelectionChanged(selStart, selEnd);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.152 -0400", hash_original_method = "7168E8EA0FE72B98E042580455F1047F", hash_generated_method = "6DE66E891D6974F31F437E08715C56D7")
    @Override
    public boolean performClick() {
        if(!super.performClick() && mIME != null)        
        {
            mIME.onExtractedTextClicked();
            boolean varB326B5062B2F0E69046810717534CB09_270088068 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_863645679 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_863645679;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2033347515 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1629426838 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1629426838;
        // ---------- Original Method ----------
        //if (!super.performClick() && mIME != null) {
            //mIME.onExtractedTextClicked();
            //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.152 -0400", hash_original_method = "7C9BA2F8326E15326AC5ACB19DAA03AF", hash_generated_method = "6DD1DBA51387297908462F958845E00F")
    @Override
    public boolean onTextContextMenuItem(int id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(id);
        if(mIME != null && mIME.onExtractTextContextMenuItem(id))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1063080845 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_350531116 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_350531116;
        } //End block
        boolean var8E801D6810F2178EF18C6E12B0DFEEC8_1954869495 = (super.onTextContextMenuItem(id));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_978842382 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_978842382;
        // ---------- Original Method ----------
        //if (mIME != null && mIME.onExtractTextContextMenuItem(id)) {
            //return true;
        //}
        //return super.onTextContextMenuItem(id);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.153 -0400", hash_original_method = "CC164D54DA859C5908F37C0D6AF369B4", hash_generated_method = "6BAEB7409B3D135DD1A18D2429668D6D")
    @Override
    public boolean isInputMethodTarget() {
        boolean varB326B5062B2F0E69046810717534CB09_766040449 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_842417700 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_842417700;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.153 -0400", hash_original_method = "04872214ED3EAFCD92368D9E52854C64", hash_generated_method = "93AE0A3324B8858BE7EDFB4D3F23CDFA")
    public boolean hasVerticalScrollBar() {
        boolean var22DFB4B0D8430A12D0029AD265A2CAAA_1603675927 = (computeVerticalScrollRange() > computeVerticalScrollExtent());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_447000166 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_447000166;
        // ---------- Original Method ----------
        //return computeVerticalScrollRange() > computeVerticalScrollExtent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.153 -0400", hash_original_method = "1D3D3676B67FC953B437D952E76D3E93", hash_generated_method = "2167BD755CC45BBFC2A6DFCA9982119F")
    @Override
    public boolean hasWindowFocus() {
        boolean var9E13B6C84817D382752962DB0D9F78A9_1920553796 = (this.isEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_6473005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_6473005;
        // ---------- Original Method ----------
        //return this.isEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.154 -0400", hash_original_method = "CC084819861CE9346C088F826DD71D3D", hash_generated_method = "D00B93FF5C7674FD210D34D782D2302C")
    @Override
    public boolean isFocused() {
        boolean var9E13B6C84817D382752962DB0D9F78A9_1825015495 = (this.isEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1383122328 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1383122328;
        // ---------- Original Method ----------
        //return this.isEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.154 -0400", hash_original_method = "C5038B1CABC8B8B00C688F0FD76B923F", hash_generated_method = "40B5D994EB851DEB185AA78402BF66E5")
    @Override
    public boolean hasFocus() {
        boolean var9E13B6C84817D382752962DB0D9F78A9_1523147318 = (this.isEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1415014369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1415014369;
        // ---------- Original Method ----------
        //return this.isEnabled();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.155 -0400", hash_original_method = "8821EFE99206E3F001E81A89F23C541D", hash_generated_method = "8E126FA49998E613390E2F1FCD233D1B")
    @Override
    protected void viewClicked(InputMethodManager imm) {
        addTaint(imm.getTaint());
        if(mIME != null)        
        {
            mIME.onViewClicked(false);
        } //End block
        // ---------- Original Method ----------
        //if (mIME != null) {
            //mIME.onViewClicked(false);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.163 -0400", hash_original_method = "5EFADD14D723A5DDC172F34D6074AA1D", hash_generated_method = "F9EE5538E6AA87AA47FAB5DED002BB54")
    @Override
    protected void deleteText_internal(int start, int end) {
        addTaint(end);
        addTaint(start);
        mIME.onExtractedDeleteText(start, end);
        // ---------- Original Method ----------
        //mIME.onExtractedDeleteText(start, end);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.164 -0400", hash_original_method = "439F32381BAC49247AD70546B9BEE6A0", hash_generated_method = "4958D6B1F85A7A7F7A64D9FF2B4F22BD")
    @Override
    protected void replaceText_internal(int start, int end, CharSequence text) {
        addTaint(text.getTaint());
        addTaint(end);
        addTaint(start);
        mIME.onExtractedReplaceText(start, end, text);
        // ---------- Original Method ----------
        //mIME.onExtractedReplaceText(start, end, text);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.171 -0400", hash_original_method = "68A0F27720FB577E88EB01CE64B3B91C", hash_generated_method = "0D2922EAA3A423972165667948D9887E")
    @Override
    protected void setSpan_internal(Object span, int start, int end, int flags) {
        addTaint(flags);
        addTaint(end);
        addTaint(start);
        addTaint(span.getTaint());
        mIME.onExtractedSetSpan(span, start, end, flags);
        // ---------- Original Method ----------
        //mIME.onExtractedSetSpan(span, start, end, flags);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.176 -0400", hash_original_method = "4F35DEE60ED94EEB6924945BBEBAAE46", hash_generated_method = "CAC619E3074C7B011882CC12883765DA")
    @Override
    protected void setCursorPosition_internal(int start, int end) {
        addTaint(end);
        addTaint(start);
        mIME.onExtractedSelectionChanged(start, end);
        // ---------- Original Method ----------
        //mIME.onExtractedSelectionChanged(start, end);
    }

    
}

