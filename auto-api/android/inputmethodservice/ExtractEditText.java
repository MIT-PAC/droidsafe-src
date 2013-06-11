package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class ExtractEditText extends EditText {
    private InputMethodService mIME;
    private int mSettingExtractedText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.612 -0400", hash_original_method = "7A0DE6148CA5B17A67B82391A3703FFF", hash_generated_method = "124DF91F5536492514E6649BF1C053B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExtractEditText(Context context) {
        super(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.612 -0400", hash_original_method = "4124FA04E6528A50C013D8FF7E28B610", hash_generated_method = "A4131A37FE555540A1CECF8C117CF220")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExtractEditText(Context context, AttributeSet attrs) {
        super(context, attrs, com.android.internal.R.attr.editTextStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.612 -0400", hash_original_method = "E7AB7BAEBF60AF77BB15799C720B6EC6", hash_generated_method = "4EAC0BAEE205C2D5DCCACEC90193B3BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExtractEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.612 -0400", hash_original_method = "E6DBB41915E723C9F2EECFAC48030375", hash_generated_method = "E71969C10EDD40835BCCAFA357F1C4F6")
    @DSModeled(DSC.SAFE)
     void setIME(InputMethodService ime) {
        dsTaint.addTaint(ime.dsTaint);
        // ---------- Original Method ----------
        //mIME = ime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.612 -0400", hash_original_method = "29AED765F6785A82C9D8840D589CD172", hash_generated_method = "C764E13E4177E3FF6A03BE30AD729ABA")
    @DSModeled(DSC.SAFE)
    public void startInternalChanges() {
        mSettingExtractedText += 1;
        // ---------- Original Method ----------
        //mSettingExtractedText += 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.612 -0400", hash_original_method = "B6A18168A6952BD0C0F99B7AFD2A1CFC", hash_generated_method = "656DF66264AA380FB799AA7CCCD92A60")
    @DSModeled(DSC.SAFE)
    public void finishInternalChanges() {
        mSettingExtractedText -= 1;
        // ---------- Original Method ----------
        //mSettingExtractedText -= 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.612 -0400", hash_original_method = "6BAFF88F25F6637786E87F71A6E886F7", hash_generated_method = "E502B219E2650C030175D931784A4BB2")
    @DSModeled(DSC.SAFE)
    @Override
    public void setExtractedText(ExtractedText text) {
        dsTaint.addTaint(text.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.612 -0400", hash_original_method = "FB80BE45A1B322D49A7CF30AB5AC4B14", hash_generated_method = "513A7B3E9F9544AD93CDE9E75D8A84B3")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(selStart);
        dsTaint.addTaint(selEnd);
        {
            mIME.onExtractedSelectionChanged(selStart, selEnd);
        } //End block
        // ---------- Original Method ----------
        //if (mSettingExtractedText == 0 && mIME != null && selStart >= 0 && selEnd >= 0) {
            //mIME.onExtractedSelectionChanged(selStart, selEnd);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.613 -0400", hash_original_method = "7168E8EA0FE72B98E042580455F1047F", hash_generated_method = "BEC68796B4EB3A369CBF9B092BADD866")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean performClick() {
        {
            boolean varB7837EDF8D7DE3FA8DC8119B7C8011E0_153730696 = (!super.performClick() && mIME != null);
            {
                mIME.onExtractedTextClicked();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!super.performClick() && mIME != null) {
            //mIME.onExtractedTextClicked();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.613 -0400", hash_original_method = "7C9BA2F8326E15326AC5ACB19DAA03AF", hash_generated_method = "8F2B6F8EF070AA9BA030142E76B11D03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTextContextMenuItem(int id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(id);
        {
            boolean var396F8D5887804111B6BB4135FF998354_813888570 = (mIME != null && mIME.onExtractTextContextMenuItem(id));
        } //End collapsed parenthetic
        boolean varAC8CDD01574679C252B071E5F8BE2559_1413695523 = (super.onTextContextMenuItem(id));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mIME != null && mIME.onExtractTextContextMenuItem(id)) {
            //return true;
        //}
        //return super.onTextContextMenuItem(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.613 -0400", hash_original_method = "CC164D54DA859C5908F37C0D6AF369B4", hash_generated_method = "840BEB1A0FD4EA610549B36C742125E2")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isInputMethodTarget() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.613 -0400", hash_original_method = "04872214ED3EAFCD92368D9E52854C64", hash_generated_method = "62530061A47E70F40D07C9C7BA732184")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasVerticalScrollBar() {
        boolean var3752A1DCE47418B0BD929DC4A11C843D_1776865701 = (computeVerticalScrollRange() > computeVerticalScrollExtent());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return computeVerticalScrollRange() > computeVerticalScrollExtent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.613 -0400", hash_original_method = "1D3D3676B67FC953B437D952E76D3E93", hash_generated_method = "65BB440262AD27E7DBD8C2A5EB863D74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean hasWindowFocus() {
        boolean varC1F40335F648F143357C360526871A16_2083594209 = (this.isEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.isEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.613 -0400", hash_original_method = "CC084819861CE9346C088F826DD71D3D", hash_generated_method = "A1FD5B987B9DD98C41219B581492672C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isFocused() {
        boolean varC1F40335F648F143357C360526871A16_823905148 = (this.isEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.isEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.613 -0400", hash_original_method = "C5038B1CABC8B8B00C688F0FD76B923F", hash_generated_method = "E03F63BF0FB66A1E54D8FB5BF0D47C0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean hasFocus() {
        boolean varC1F40335F648F143357C360526871A16_1603481371 = (this.isEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.isEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.613 -0400", hash_original_method = "8821EFE99206E3F001E81A89F23C541D", hash_generated_method = "F25D9E95D63031AD1676C6FA9587AF2D")
    @DSModeled(DSC.SAFE)
    @Override
    protected void viewClicked(InputMethodManager imm) {
        dsTaint.addTaint(imm.dsTaint);
        {
            mIME.onViewClicked(false);
        } //End block
        // ---------- Original Method ----------
        //if (mIME != null) {
            //mIME.onViewClicked(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.613 -0400", hash_original_method = "5EFADD14D723A5DDC172F34D6074AA1D", hash_generated_method = "12289DD834F4629B5773447267D41D3C")
    @DSModeled(DSC.SAFE)
    @Override
    protected void deleteText_internal(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        mIME.onExtractedDeleteText(start, end);
        // ---------- Original Method ----------
        //mIME.onExtractedDeleteText(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.614 -0400", hash_original_method = "439F32381BAC49247AD70546B9BEE6A0", hash_generated_method = "594D44A14D7E56A45DD21050C9E1D60C")
    @DSModeled(DSC.SAFE)
    @Override
    protected void replaceText_internal(int start, int end, CharSequence text) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        mIME.onExtractedReplaceText(start, end, text);
        // ---------- Original Method ----------
        //mIME.onExtractedReplaceText(start, end, text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.614 -0400", hash_original_method = "68A0F27720FB577E88EB01CE64B3B91C", hash_generated_method = "B86A8871DD167EC80CDC4A6A6719FFDB")
    @DSModeled(DSC.SAFE)
    @Override
    protected void setSpan_internal(Object span, int start, int end, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        dsTaint.addTaint(span.dsTaint);
        mIME.onExtractedSetSpan(span, start, end, flags);
        // ---------- Original Method ----------
        //mIME.onExtractedSetSpan(span, start, end, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.614 -0400", hash_original_method = "4F35DEE60ED94EEB6924945BBEBAAE46", hash_generated_method = "7B8897C8FBFAF22B8A25589657EFD8C9")
    @DSModeled(DSC.SAFE)
    @Override
    protected void setCursorPosition_internal(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        mIME.onExtractedSelectionChanged(start, end);
        // ---------- Original Method ----------
        //mIME.onExtractedSelectionChanged(start, end);
    }

    
}


