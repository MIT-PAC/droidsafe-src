package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.view.KeyEvent;

public interface DialogInterface {
    
    public static final int BUTTON_POSITIVE = -1;
    
    public static final int BUTTON_NEGATIVE = -2;
    
    public static final int BUTTON_NEUTRAL = -3;
    
    @Deprecated
    public static final int BUTTON1 = BUTTON_POSITIVE;
    
    @Deprecated
    public static final int BUTTON2 = BUTTON_NEGATIVE;
    
    @Deprecated
    public static final int BUTTON3 = BUTTON_NEUTRAL;
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public void cancel();

    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public void dismiss();
    
    interface OnCancelListener {
        @DSVerified("Called from Dialog")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onCancel(DialogInterface dialog);
    }
    
    interface OnDismissListener {
        @DSVerified("Called from AlertDialog.Builder.create()")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onDismiss(DialogInterface dialog);
    }
    
    interface OnShowListener {
        @DSVerified("Called from Dialog")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onShow(DialogInterface dialog);
    }
    
    interface OnClickListener {
        
        @DSVerified("Called from AlertDialog.Builder.create()")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onClick(DialogInterface dialog, int which);
    }
    
    interface OnMultiChoiceClickListener {
        @DSVerified("Called from AlertDialog.Builder.create()")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onClick(DialogInterface dialog, int which, boolean isChecked);
    }
    
    interface OnKeyListener {
        @DSVerified("Called from Dialog")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event);
    }
}
