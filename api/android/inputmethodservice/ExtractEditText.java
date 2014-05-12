package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class ExtractEditText extends EditText {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.828 -0500", hash_original_field = "CC8D5384A00A73871026D93AAF45F70B", hash_generated_field = "451A1E4BDED6910D4643671429CF353C")

    private InputMethodService mIME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.830 -0500", hash_original_field = "5DB5E44E48741E82AC189FAD644A1C17", hash_generated_field = "AB1C548527F3FF1A47C31A81B3CFA018")

    private int mSettingExtractedText;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.832 -0500", hash_original_method = "7A0DE6148CA5B17A67B82391A3703FFF", hash_generated_method = "C1F27FF849A53C3C93FA882BDB95F02B")
    
public ExtractEditText(Context context) {
        super(context, null);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.835 -0500", hash_original_method = "4124FA04E6528A50C013D8FF7E28B610", hash_generated_method = "41504CD3E006707537484F2A63D64F2B")
    
public ExtractEditText(Context context, AttributeSet attrs) {
        super(context, attrs, com.android.internal.R.attr.editTextStyle);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.838 -0500", hash_original_method = "E7AB7BAEBF60AF77BB15799C720B6EC6", hash_generated_method = "968DF7B6AC5496B733FF51B31E2A32D3")
    
public ExtractEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.840 -0500", hash_original_method = "E6DBB41915E723C9F2EECFAC48030375", hash_generated_method = "E6DBB41915E723C9F2EECFAC48030375")
    
void setIME(InputMethodService ime) {
        mIME = ime;
    }
    
    /**
     * Start making changes that will not be reported to the client.  That
     * is, {@link #onSelectionChanged(int, int)} will not result in sending
     * the new selection to the client
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.842 -0500", hash_original_method = "29AED765F6785A82C9D8840D589CD172", hash_generated_method = "8725C0E5EB618C55CB64F68BE430BBF2")
    
public void startInternalChanges() {
        mSettingExtractedText += 1;
    }
    
    /**
     * Finish making changes that will not be reported to the client.  That
     * is, {@link #onSelectionChanged(int, int)} will not result in sending
     * the new selection to the client
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.844 -0500", hash_original_method = "B6A18168A6952BD0C0F99B7AFD2A1CFC", hash_generated_method = "A5FDB1EB5074B41AFA780914640E9CF7")
    
public void finishInternalChanges() {
        mSettingExtractedText -= 1;
    }
    
    /**
     * Implement just to keep track of when we are setting text from the
     * client (vs. seeing changes in ourself from the user).
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.846 -0500", hash_original_method = "6BAFF88F25F6637786E87F71A6E886F7", hash_generated_method = "600D30AF1155663CD7FE89E39D22C169")
    
@Override public void setExtractedText(ExtractedText text) {
        try {
            mSettingExtractedText++;
            super.setExtractedText(text);
        } finally {
            mSettingExtractedText--;
        }
    }
    
    /**
     * Report to the underlying text editor about selection changes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.848 -0500", hash_original_method = "FB80BE45A1B322D49A7CF30AB5AC4B14", hash_generated_method = "A97519A74DDBEA07EFB9EEC2EB14A877")
    
@Override protected void onSelectionChanged(int selStart, int selEnd) {
        if (mSettingExtractedText == 0 && mIME != null && selStart >= 0 && selEnd >= 0) {
            mIME.onExtractedSelectionChanged(selStart, selEnd);
        }
    }
    
    /**
     * Redirect clicks to the IME for handling there.  First allows any
     * on click handler to run, though.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.851 -0500", hash_original_method = "7168E8EA0FE72B98E042580455F1047F", hash_generated_method = "5599A5A0AB8018CDB5583F62BE874D5E")
    
@Override public boolean performClick() {
        if (!super.performClick() && mIME != null) {
            mIME.onExtractedTextClicked();
            return true;
        }
        return false;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.854 -0500", hash_original_method = "7C9BA2F8326E15326AC5ACB19DAA03AF", hash_generated_method = "D3F6B098D622D49BD5748D8EF074174F")
    
@Override public boolean onTextContextMenuItem(int id) {
        if (mIME != null && mIME.onExtractTextContextMenuItem(id)) {
            return true;
        }
        return super.onTextContextMenuItem(id);
    }
    
    /**
     * We are always considered to be an input method target.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.856 -0500", hash_original_method = "CC164D54DA859C5908F37C0D6AF369B4", hash_generated_method = "F591D5AF39DA5D048887EDDDFDB1ABC7")
    
@Override
    public boolean isInputMethodTarget() {
        return true;
    }
    
    /**
     * Return true if the edit text is currently showing a scroll bar.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.858 -0500", hash_original_method = "04872214ED3EAFCD92368D9E52854C64", hash_generated_method = "CA1183EF66099C44D7F5D167214BE7A5")
    
public boolean hasVerticalScrollBar() {
        return computeVerticalScrollRange() > computeVerticalScrollExtent();
    }
    
    /**
     * Pretend like the window this view is in always has focus, so its
     * highlight and cursor will be displayed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.861 -0500", hash_original_method = "1D3D3676B67FC953B437D952E76D3E93", hash_generated_method = "9E50874CE195A9258AD749128620A3E9")
    
@Override public boolean hasWindowFocus() {
        return this.isEnabled();
    }

    /**
     * Pretend like this view always has focus, so its
     * highlight and cursor will be displayed.
     */
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.864 -0500", hash_original_method = "CC084819861CE9346C088F826DD71D3D", hash_generated_method = "A734C5C6906F53FB9B0347E038F958BE")
    
@Override public boolean isFocused() {
        return this.isEnabled();
    }

    /**
     * Pretend like this view always has focus, so its
     * highlight and cursor will be displayed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.866 -0500", hash_original_method = "C5038B1CABC8B8B00C688F0FD76B923F", hash_generated_method = "EA410BB510FFBBB53A8F600AEE5AEF65")
    
@Override public boolean hasFocus() {
        return this.isEnabled();
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.868 -0500", hash_original_method = "8821EFE99206E3F001E81A89F23C541D", hash_generated_method = "2BF2977F5C136CCBE40BB1C4AFEC29FC")
    
@Override protected void viewClicked(InputMethodManager imm) {
        // As an instance of this class is supposed to be owned by IMS,
        // and it has a reference to the IMS (the current IME),
        // we just need to call back its onViewClicked() here.
        // It should be good to avoid unnecessary IPCs by doing this as well.
        if (mIME != null) {
            mIME.onViewClicked(false);
        }
    }

    /**
     * {@inheritDoc}
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.871 -0500", hash_original_method = "5EFADD14D723A5DDC172F34D6074AA1D", hash_generated_method = "E6598062560B5C1A69950CFA0D1A49C9")
    
@Override
    protected void deleteText_internal(int start, int end) {
        // Do not call the super method.
        // This will change the source TextView instead, which will update the ExtractTextView.
        mIME.onExtractedDeleteText(start, end);
    }

    /**
     * {@inheritDoc}
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.873 -0500", hash_original_method = "439F32381BAC49247AD70546B9BEE6A0", hash_generated_method = "D53E26F7919C7B8128113D9AC9BE13EA")
    
@Override
    protected void replaceText_internal(int start, int end, CharSequence text) {
        // Do not call the super method.
        // This will change the source TextView instead, which will update the ExtractTextView.
        mIME.onExtractedReplaceText(start, end, text);
    }

    /**
     * {@inheritDoc}
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.875 -0500", hash_original_method = "68A0F27720FB577E88EB01CE64B3B91C", hash_generated_method = "553227923AFD0389533061117084A48E")
    
@Override
    protected void setSpan_internal(Object span, int start, int end, int flags) {
        // Do not call the super method.
        // This will change the source TextView instead, which will update the ExtractTextView.
        mIME.onExtractedSetSpan(span, start, end, flags);
    }

    /**
     * {@inheritDoc}
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:40.878 -0500", hash_original_method = "4F35DEE60ED94EEB6924945BBEBAAE46", hash_generated_method = "371C58E66CEAB0D30661D74FCDC91886")
    
@Override
    protected void setCursorPosition_internal(int start, int end) {
        // Do not call the super method.
        // This will change the source TextView instead, which will update the ExtractTextView.
        mIME.onExtractedSelectionChanged(start, end);
    }
    
}

