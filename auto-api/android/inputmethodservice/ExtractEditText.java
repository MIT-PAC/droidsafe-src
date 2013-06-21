package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class ExtractEditText extends EditText {
    private InputMethodService mIME;
    private int mSettingExtractedText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.220 -0400", hash_original_method = "7A0DE6148CA5B17A67B82391A3703FFF", hash_generated_method = "1B86B9A8BBF43D6B7016BD79FDC28519")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExtractEditText(Context context) {
        super(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.222 -0400", hash_original_method = "4124FA04E6528A50C013D8FF7E28B610", hash_generated_method = "A42CAAFA98153CB8323F2D1CAB233D07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExtractEditText(Context context, AttributeSet attrs) {
        super(context, attrs, com.android.internal.R.attr.editTextStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.224 -0400", hash_original_method = "E7AB7BAEBF60AF77BB15799C720B6EC6", hash_generated_method = "E9DD5A7AA81DE0EC026A63EE34754B58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExtractEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.224 -0400", hash_original_method = "E6DBB41915E723C9F2EECFAC48030375", hash_generated_method = "8AF11C0737261F3A47E3C0F73EDE8337")
    @DSModeled(DSC.SAFE)
     void setIME(InputMethodService ime) {
        dsTaint.addTaint(ime.dsTaint);
        // ---------- Original Method ----------
        //mIME = ime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.224 -0400", hash_original_method = "29AED765F6785A82C9D8840D589CD172", hash_generated_method = "27A568DC538086C464A343B5494E6E51")
    @DSModeled(DSC.SAFE)
    public void startInternalChanges() {
        mSettingExtractedText += 1;
        // ---------- Original Method ----------
        //mSettingExtractedText += 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.225 -0400", hash_original_method = "B6A18168A6952BD0C0F99B7AFD2A1CFC", hash_generated_method = "6D0BECC3D9DA8C9768F35AB3B6B16D1B")
    @DSModeled(DSC.SAFE)
    public void finishInternalChanges() {
        mSettingExtractedText -= 1;
        // ---------- Original Method ----------
        //mSettingExtractedText -= 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.225 -0400", hash_original_method = "6BAFF88F25F6637786E87F71A6E886F7", hash_generated_method = "61E16B4D5A1C93F158B86396874FAAB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setExtractedText(ExtractedText text) {
        dsTaint.addTaint(text.dsTaint);
        try 
        {
            super.setExtractedText(text);
        } //End block
        finally 
        { }
        // ---------- Original Method ----------
        //try {
            //mSettingExtractedText++;
            //super.setExtractedText(text);
        //} finally {
            //mSettingExtractedText--;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.225 -0400", hash_original_method = "FB80BE45A1B322D49A7CF30AB5AC4B14", hash_generated_method = "D15A324F8C99F7DEB54FAE51BE680854")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.226 -0400", hash_original_method = "7168E8EA0FE72B98E042580455F1047F", hash_generated_method = "A97D88CE92BEDFA1E4825BEA93E3E5FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean performClick() {
        {
            boolean varB7837EDF8D7DE3FA8DC8119B7C8011E0_1897775338 = (!super.performClick() && mIME != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.226 -0400", hash_original_method = "7C9BA2F8326E15326AC5ACB19DAA03AF", hash_generated_method = "08ED4B17C21642A360984C1A8A7DD8B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTextContextMenuItem(int id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(id);
        {
            boolean var396F8D5887804111B6BB4135FF998354_1647755992 = (mIME != null && mIME.onExtractTextContextMenuItem(id));
        } //End collapsed parenthetic
        boolean varAC8CDD01574679C252B071E5F8BE2559_1536332118 = (super.onTextContextMenuItem(id));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mIME != null && mIME.onExtractTextContextMenuItem(id)) {
            //return true;
        //}
        //return super.onTextContextMenuItem(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.226 -0400", hash_original_method = "CC164D54DA859C5908F37C0D6AF369B4", hash_generated_method = "F36CC97174DE7C619160E8E668384A43")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isInputMethodTarget() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.226 -0400", hash_original_method = "04872214ED3EAFCD92368D9E52854C64", hash_generated_method = "292356B5B85F8D5AD98E9BADB0E1C4D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasVerticalScrollBar() {
        boolean var3752A1DCE47418B0BD929DC4A11C843D_806422201 = (computeVerticalScrollRange() > computeVerticalScrollExtent());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return computeVerticalScrollRange() > computeVerticalScrollExtent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.227 -0400", hash_original_method = "1D3D3676B67FC953B437D952E76D3E93", hash_generated_method = "99E21F924B63803CDF8CC485677A09BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean hasWindowFocus() {
        boolean varC1F40335F648F143357C360526871A16_2106430243 = (this.isEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.isEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.227 -0400", hash_original_method = "CC084819861CE9346C088F826DD71D3D", hash_generated_method = "2460FAFCE4FE4FB8CDF7700747C31A42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isFocused() {
        boolean varC1F40335F648F143357C360526871A16_907351966 = (this.isEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.isEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.227 -0400", hash_original_method = "C5038B1CABC8B8B00C688F0FD76B923F", hash_generated_method = "1D9FBDB6E1F589BE4BBDCB4AA74FB4AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean hasFocus() {
        boolean varC1F40335F648F143357C360526871A16_1908138768 = (this.isEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.isEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.227 -0400", hash_original_method = "8821EFE99206E3F001E81A89F23C541D", hash_generated_method = "D962AB5D0668A00B6569C3DDC8F1B038")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.228 -0400", hash_original_method = "5EFADD14D723A5DDC172F34D6074AA1D", hash_generated_method = "FFB62D8809BA8EB0F83796FCAB20FD5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void deleteText_internal(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        mIME.onExtractedDeleteText(start, end);
        // ---------- Original Method ----------
        //mIME.onExtractedDeleteText(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.228 -0400", hash_original_method = "439F32381BAC49247AD70546B9BEE6A0", hash_generated_method = "31981B267A92F459A78441EA3E3721DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void replaceText_internal(int start, int end, CharSequence text) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        mIME.onExtractedReplaceText(start, end, text);
        // ---------- Original Method ----------
        //mIME.onExtractedReplaceText(start, end, text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.228 -0400", hash_original_method = "68A0F27720FB577E88EB01CE64B3B91C", hash_generated_method = "97FEF586D31C5F0CDA5C368F41C72962")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.229 -0400", hash_original_method = "4F35DEE60ED94EEB6924945BBEBAAE46", hash_generated_method = "F5321E8D8A139A005EFA5D2F4B70F920")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void setCursorPosition_internal(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        mIME.onExtractedSelectionChanged(start, end);
        // ---------- Original Method ----------
        //mIME.onExtractedSelectionChanged(start, end);
    }

    
}

