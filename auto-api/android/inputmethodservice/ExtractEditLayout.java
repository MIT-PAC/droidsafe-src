package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.view.menu.MenuBuilder;
import com.android.internal.view.menu.MenuPopupHelper;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.LinearLayout;

public class ExtractEditLayout extends LinearLayout {
    ExtractActionMode mActionMode;
    Button mExtractActionButton;
    Button mEditButton;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.204 -0400", hash_original_method = "5E5A3BB351E8D9D7F73E3207F63F4561", hash_generated_method = "54DF665AA880102D7E7112A62728FA37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExtractEditLayout(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.204 -0400", hash_original_method = "5B5DDD3A07057211F0994E26CEDA1A4A", hash_generated_method = "64F11CF0E5E1C69052375E2975999F2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExtractEditLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.204 -0400", hash_original_method = "3AB740C640E719B54F03586FCEB648DB", hash_generated_method = "527F384D5B7500D58CA7FE551A1DEDD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ActionMode startActionModeForChild(View sourceView, ActionMode.Callback cb) {
        dsTaint.addTaint(cb.dsTaint);
        dsTaint.addTaint(sourceView.dsTaint);
        ExtractActionMode mode;
        mode = new ExtractActionMode(cb);
        {
            boolean var2B92093546C2716C766BC5924D507852_994633802 = (mode.dispatchOnCreate());
            {
                mode.invalidate();
                mExtractActionButton.setVisibility(INVISIBLE);
                mEditButton.setVisibility(VISIBLE);
                mActionMode = mode;
                sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
            } //End block
        } //End collapsed parenthetic
        return (ActionMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final ExtractActionMode mode = new ExtractActionMode(cb);
        //if (mode.dispatchOnCreate()) {
            //mode.invalidate();
            //mExtractActionButton.setVisibility(INVISIBLE);
            //mEditButton.setVisibility(VISIBLE);
            //mActionMode = mode;
            //sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
            //return mode;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.204 -0400", hash_original_method = "587B198236267AC63B96064EC21D7789", hash_generated_method = "D21868804E0A19D39AB59AC914E9E65B")
    @DSModeled(DSC.SAFE)
    public boolean isActionModeStarted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActionMode != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.205 -0400", hash_original_method = "CFF93884DD9A272729CBAF15B54B9CD3", hash_generated_method = "F8C35EADA670006FD9018FA022C7CB0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finishActionMode() {
        {
            mActionMode.finish();
        } //End block
        // ---------- Original Method ----------
        //if (mActionMode != null) {
            //mActionMode.finish();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.205 -0400", hash_original_method = "F4E3F3E884E506D9FE93C33AFB725466", hash_generated_method = "43DCC894DDC5CC8E7D5B5507D2E36A6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFinishInflate();
        mExtractActionButton = (Button) findViewById(com.android.internal.R.id.inputExtractAction);
        mEditButton = (Button) findViewById(com.android.internal.R.id.inputExtractEditButton);
        mEditButton.setOnClickListener(new OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.205 -0400", hash_original_method = "80ABF702BB778CBFC3E3D00BD35B5A63", hash_generated_method = "F319201564F11C1DBB74F21ACC98F106")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onClick(View clicked) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(clicked.dsTaint);
                {
                    new MenuPopupHelper(getContext(), mActionMode.mMenu, clicked).show();
                } //End block
                // ---------- Original Method ----------
                //if (mActionMode != null) {
                    //new MenuPopupHelper(getContext(), mActionMode.mMenu, clicked).show();
                //}
            }
});
        // ---------- Original Method ----------
        //super.onFinishInflate();
        //mExtractActionButton = (Button) findViewById(com.android.internal.R.id.inputExtractAction);
        //mEditButton = (Button) findViewById(com.android.internal.R.id.inputExtractEditButton);
        //mEditButton.setOnClickListener(new OnClickListener() {
            //public void onClick(View clicked) {
                //if (mActionMode != null) {
                    //new MenuPopupHelper(getContext(), mActionMode.mMenu, clicked).show();
                //}
            //}
        //});
    }

    
    private class ExtractActionMode extends ActionMode implements MenuBuilder.Callback {
        private ActionMode.Callback mCallback;
        MenuBuilder mMenu;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.205 -0400", hash_original_method = "1DFFBDF48C83C4F81EE07812707228A4", hash_generated_method = "FDC2B90A1E3344596DC71CEAF9DF651C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ExtractActionMode(Callback cb) {
            dsTaint.addTaint(cb.dsTaint);
            mMenu = new MenuBuilder(getContext());
            mMenu.setCallback(this);
            // ---------- Original Method ----------
            //mMenu = new MenuBuilder(getContext());
            //mMenu.setCallback(this);
            //mCallback = cb;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.206 -0400", hash_original_method = "F1AD782B0CD2259E0BE9FDDD0EC2ADD5", hash_generated_method = "6CAB1CBA53BBADEB8F0A65DDDB009AA1")
        @DSModeled(DSC.SAFE)
        @Override
        public void setTitle(CharSequence title) {
            dsTaint.addTaint(title);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.206 -0400", hash_original_method = "B30C6763E9E5F305FC4AC0CFECBEE869", hash_generated_method = "20C6324E8C43823442DA03505BCC347C")
        @DSModeled(DSC.SAFE)
        @Override
        public void setTitle(int resId) {
            dsTaint.addTaint(resId);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.206 -0400", hash_original_method = "EB006AC48BB7A6AA8B2958DC91304E5C", hash_generated_method = "26FEB34D0C15F395A2CD41EB2F1F20B9")
        @DSModeled(DSC.SAFE)
        @Override
        public void setSubtitle(CharSequence subtitle) {
            dsTaint.addTaint(subtitle);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.206 -0400", hash_original_method = "1F86E8EB25240C47EC24308D126D97B9", hash_generated_method = "733F4337DAE9A18DBCC707706657FCFA")
        @DSModeled(DSC.SAFE)
        @Override
        public void setSubtitle(int resId) {
            dsTaint.addTaint(resId);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.206 -0400", hash_original_method = "3E94F533B6F67EA66D83CADA4353AF33", hash_generated_method = "B6E059DAD488AFCAAA15BEFF473A0832")
        @DSModeled(DSC.SAFE)
        @Override
        public void setCustomView(View view) {
            dsTaint.addTaint(view.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.207 -0400", hash_original_method = "AE3782F4A9FD5538AF0C8FC979CD15B1", hash_generated_method = "09CD291F58A645AF3A8E9CF913126DF5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void invalidate() {
            mMenu.stopDispatchingItemsChanged();
            try 
            {
                mCallback.onPrepareActionMode(this, mMenu);
            } //End block
            finally 
            {
                mMenu.startDispatchingItemsChanged();
            } //End block
            // ---------- Original Method ----------
            //mMenu.stopDispatchingItemsChanged();
            //try {
                //mCallback.onPrepareActionMode(this, mMenu);
            //} finally {
                //mMenu.startDispatchingItemsChanged();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.207 -0400", hash_original_method = "73ABB077D09B369F1D81F6F51241E9AF", hash_generated_method = "87DC29E30ADC9B5E68F40E9DC4BC6121")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean dispatchOnCreate() {
            mMenu.stopDispatchingItemsChanged();
            try 
            {
                boolean var8B33BA39C48AC4211B5B4A48DBAC6104_1925359382 = (mCallback.onCreateActionMode(this, mMenu));
            } //End block
            finally 
            {
                mMenu.startDispatchingItemsChanged();
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //mMenu.stopDispatchingItemsChanged();
            //try {
                //return mCallback.onCreateActionMode(this, mMenu);
            //} finally {
                //mMenu.startDispatchingItemsChanged();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.207 -0400", hash_original_method = "2B69AFBC6E24AF84D26A0EF2F0EF4896", hash_generated_method = "C1BDA1B831D6C6F80B8C5C0A882DF506")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void finish() {
            {
                boolean var830761C64F0699CF4AD2D4B7B4D7E08E_271044356 = (mActionMode != this);
            } //End collapsed parenthetic
            mCallback.onDestroyActionMode(this);
            mCallback = null;
            mExtractActionButton.setVisibility(VISIBLE);
            mEditButton.setVisibility(INVISIBLE);
            sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
            mActionMode = null;
            // ---------- Original Method ----------
            //if (mActionMode != this) {
                //return;
            //}
            //mCallback.onDestroyActionMode(this);
            //mCallback = null;
            //mExtractActionButton.setVisibility(VISIBLE);
            //mEditButton.setVisibility(INVISIBLE);
            //sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
            //mActionMode = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.208 -0400", hash_original_method = "B2B8DF93D41CD214F77DE42BB625BB9F", hash_generated_method = "86A6A00CD1F7DBD5751DEFC4177523B8")
        @DSModeled(DSC.SAFE)
        @Override
        public Menu getMenu() {
            return (Menu)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mMenu;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.208 -0400", hash_original_method = "CD9B990298CF856E49A643E530553914", hash_generated_method = "4E70EA1AEC3EECDEDB3B2733461DA3BA")
        @DSModeled(DSC.SAFE)
        @Override
        public CharSequence getTitle() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.208 -0400", hash_original_method = "F475DA391A1931FE20FFD2579FFFF5AF", hash_generated_method = "F56F9701AED404E0D9458AB912E55E05")
        @DSModeled(DSC.SAFE)
        @Override
        public CharSequence getSubtitle() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.209 -0400", hash_original_method = "7A49E6A1A0BF55D8D926541A71E4907E", hash_generated_method = "CC802FBD578DD9D7045E1236B1C30C22")
        @DSModeled(DSC.SAFE)
        @Override
        public View getCustomView() {
            return (View)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.210 -0400", hash_original_method = "DECFD94D9899EA20C3E59178999FB9F7", hash_generated_method = "03D9C1842B0F1A16C28BA74158E66628")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public MenuInflater getMenuInflater() {
            MenuInflater var60A5F2306B0321296E959C24AACBA13F_1626699983 = (new MenuInflater(getContext()));
            return (MenuInflater)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new MenuInflater(getContext());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.210 -0400", hash_original_method = "51BD8FD51955B080CEEB769553E9A9F7", hash_generated_method = "22BD13B419EF3D4E952F73047824E617")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(item.dsTaint);
            dsTaint.addTaint(menu.dsTaint);
            {
                boolean varEDF93C5517A51BAAA6230A19AB6D2347_468680535 = (mCallback.onActionItemClicked(this, item));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (mCallback != null) {
                //return mCallback.onActionItemClicked(this, item);
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.210 -0400", hash_original_method = "BD3281B75359F57929C0B7D8E3BC0065", hash_generated_method = "3D4C6D97513B5F059A875A19E21A8BF5")
        @DSModeled(DSC.SAFE)
        @Override
        public void onMenuModeChange(MenuBuilder menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(menu.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
}

