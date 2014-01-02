package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Bundle;
import android.view.KeyEvent;

public interface InputConnection {
    
    static final int GET_TEXT_WITH_STYLES = 0x0001;
    
    
    public static final int GET_EXTRACTED_TEXT_MONITOR = 0x0001;
    
    
    public CharSequence getTextBeforeCursor(int n, int flags);

    
    public CharSequence getTextAfterCursor(int n, int flags);

    
    public CharSequence getSelectedText(int flags);

    
    public int getCursorCapsMode(int reqModes);
    
    
    public ExtractedText getExtractedText(ExtractedTextRequest request,
            int flags);

    
    public boolean deleteSurroundingText(int leftLength, int rightLength);

    
    public boolean setComposingText(CharSequence text, int newCursorPosition);

    
    public boolean setComposingRegion(int start, int end);

    
    public boolean finishComposingText();
    
    
    public boolean commitText(CharSequence text, int newCursorPosition);

    
    public boolean commitCompletion(CompletionInfo text);

    
    public boolean commitCorrection(CorrectionInfo correctionInfo);

    
    public boolean setSelection(int start, int end);
    
    
    public boolean performEditorAction(int editorAction);
    
    
    public boolean performContextMenuAction(int id);
    
    
    public boolean beginBatchEdit();
    
    
    public boolean endBatchEdit();
    
    
    public boolean sendKeyEvent(KeyEvent event);

    
    public boolean clearMetaKeyStates(int states);
    
    
    public boolean reportFullscreenMode(boolean enabled);
    
    
    public boolean performPrivateCommand(String action, Bundle data);
}
