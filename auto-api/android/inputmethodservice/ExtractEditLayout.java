package android.inputmethodservice;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.528 -0400", hash_original_field = "3B382D379664B509F22D0EB5D96F2BA8", hash_generated_field = "84372CBE17BCE552A035CEA7A14F295A")

    ExtractActionMode mActionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.528 -0400", hash_original_field = "3E6D26FB674BD5BECF55AF87AA05424D", hash_generated_field = "3B9794871E7B10840F19B29A2246BB31")

    Button mExtractActionButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.528 -0400", hash_original_field = "79CC0F5D3D0182DF888F5D7BF86044D2", hash_generated_field = "B2154EF2825FBCE7DE09C4738860180E")

    Button mEditButton;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.529 -0400", hash_original_method = "5E5A3BB351E8D9D7F73E3207F63F4561", hash_generated_method = "FF076AB15802724C5AF1EBE865EE317C")
    public  ExtractEditLayout(Context context) {
        super(context);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.529 -0400", hash_original_method = "5B5DDD3A07057211F0994E26CEDA1A4A", hash_generated_method = "0FEED4B6F896D44B95C7E222AAC74E70")
    public  ExtractEditLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.532 -0400", hash_original_method = "3AB740C640E719B54F03586FCEB648DB", hash_generated_method = "538E9EFF0DA14108C7C1F02BE5590113")
    @Override
    public ActionMode startActionModeForChild(View sourceView, ActionMode.Callback cb) {
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_1462888984 = null; 
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_164579003 = null; 
        final ExtractActionMode mode = new ExtractActionMode(cb);
        {
            boolean var2B92093546C2716C766BC5924D507852_1994352120 = (mode.dispatchOnCreate());
            {
                mode.invalidate();
                mExtractActionButton.setVisibility(INVISIBLE);
                mEditButton.setVisibility(VISIBLE);
                mActionMode = mode;
                sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
                varB4EAC82CA7396A68D541C85D26508E83_1462888984 = mode;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_164579003 = null;
        addTaint(sourceView.getTaint());
        addTaint(cb.getTaint());
        ActionMode varA7E53CE21691AB073D9660D615818899_205985613; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_205985613 = varB4EAC82CA7396A68D541C85D26508E83_1462888984;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_205985613 = varB4EAC82CA7396A68D541C85D26508E83_164579003;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_205985613.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_205985613;
        
        
        
            
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.532 -0400", hash_original_method = "587B198236267AC63B96064EC21D7789", hash_generated_method = "8BB4873FDBB3329A7C62FB48029190D7")
    public boolean isActionModeStarted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_32126435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_32126435;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.533 -0400", hash_original_method = "CFF93884DD9A272729CBAF15B54B9CD3", hash_generated_method = "F8C35EADA670006FD9018FA022C7CB0E")
    public void finishActionMode() {
        {
            mActionMode.finish();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.534 -0400", hash_original_method = "F4E3F3E884E506D9FE93C33AFB725466", hash_generated_method = "11F6F11E27A1F481F4FC971C070967F5")
    @Override
    public void onFinishInflate() {
        
        super.onFinishInflate();
        mExtractActionButton = (Button) findViewById(com.android.internal.R.id.inputExtractAction);
        mEditButton = (Button) findViewById(com.android.internal.R.id.inputExtractEditButton);
        mEditButton.setOnClickListener(new OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.534 -0400", hash_original_method = "80ABF702BB778CBFC3E3D00BD35B5A63", hash_generated_method = "C3CD4FE1E9CCA0149AA1B88F5F70E187")
            public void onClick(View clicked) {
                
                {
                    new MenuPopupHelper(getContext(), mActionMode.mMenu, clicked).show();
                } 
                addTaint(clicked.getTaint());
                
                
                    
                
            }
});
        
        
        
        
        
            
                
                    
                
            
        
    }

    
    private class ExtractActionMode extends ActionMode implements MenuBuilder.Callback {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.534 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "8F251D8FB2618CB877D06AB4E966D630")

        private ActionMode.Callback mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.534 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "E0FA7D9C40725579D8730D3DABE74643")

        MenuBuilder mMenu;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.534 -0400", hash_original_method = "1DFFBDF48C83C4F81EE07812707228A4", hash_generated_method = "7016906F6AE6283CE484B5EEE99D31EE")
        public  ExtractActionMode(Callback cb) {
            mMenu = new MenuBuilder(getContext());
            mMenu.setCallback(this);
            mCallback = cb;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.535 -0400", hash_original_method = "F1AD782B0CD2259E0BE9FDDD0EC2ADD5", hash_generated_method = "EA5142F85218179C74E31C4344F7840C")
        @Override
        public void setTitle(CharSequence title) {
            addTaint(title.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.535 -0400", hash_original_method = "B30C6763E9E5F305FC4AC0CFECBEE869", hash_generated_method = "C6BC91ECFE1C379B9775192FE76B7EE1")
        @Override
        public void setTitle(int resId) {
            addTaint(resId);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.535 -0400", hash_original_method = "EB006AC48BB7A6AA8B2958DC91304E5C", hash_generated_method = "9DFEDFD3C97DB086294C2841AEBA9335")
        @Override
        public void setSubtitle(CharSequence subtitle) {
            addTaint(subtitle.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.535 -0400", hash_original_method = "1F86E8EB25240C47EC24308D126D97B9", hash_generated_method = "D51D417B20F4E43280CDC3BCD8EA2931")
        @Override
        public void setSubtitle(int resId) {
            addTaint(resId);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.536 -0400", hash_original_method = "3E94F533B6F67EA66D83CADA4353AF33", hash_generated_method = "A18B374E9FE9E6972BDC43896DF58822")
        @Override
        public void setCustomView(View view) {
            addTaint(view.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.536 -0400", hash_original_method = "AE3782F4A9FD5538AF0C8FC979CD15B1", hash_generated_method = "09CD291F58A645AF3A8E9CF913126DF5")
        @Override
        public void invalidate() {
            mMenu.stopDispatchingItemsChanged();
            try 
            {
                mCallback.onPrepareActionMode(this, mMenu);
            } 
            finally 
            {
                mMenu.startDispatchingItemsChanged();
            } 
            
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.536 -0400", hash_original_method = "73ABB077D09B369F1D81F6F51241E9AF", hash_generated_method = "91F967A203E58301428585BB27E714CE")
        public boolean dispatchOnCreate() {
            mMenu.stopDispatchingItemsChanged();
            try 
            {
                boolean var8B33BA39C48AC4211B5B4A48DBAC6104_396573085 = (mCallback.onCreateActionMode(this, mMenu));
            } 
            finally 
            {
                mMenu.startDispatchingItemsChanged();
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1378386017 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1378386017;
            
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.536 -0400", hash_original_method = "2B69AFBC6E24AF84D26A0EF2F0EF4896", hash_generated_method = "39CED13507842E49B63AA29C1D6ADB6D")
        @Override
        public void finish() {
            {
                boolean var830761C64F0699CF4AD2D4B7B4D7E08E_1172379129 = (mActionMode != this);
            } 
            mCallback.onDestroyActionMode(this);
            mCallback = null;
            mExtractActionButton.setVisibility(VISIBLE);
            mEditButton.setVisibility(INVISIBLE);
            sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
            mActionMode = null;
            
            
                
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.537 -0400", hash_original_method = "B2B8DF93D41CD214F77DE42BB625BB9F", hash_generated_method = "8997A2482AAA3D625DCAF41D74EF4032")
        @Override
        public Menu getMenu() {
            Menu varB4EAC82CA7396A68D541C85D26508E83_999877270 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_999877270 = mMenu;
            varB4EAC82CA7396A68D541C85D26508E83_999877270.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_999877270;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.537 -0400", hash_original_method = "CD9B990298CF856E49A643E530553914", hash_generated_method = "623409EFF9AE392762EDF662452BDF31")
        @Override
        public CharSequence getTitle() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_645086943 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_645086943 = null;
            varB4EAC82CA7396A68D541C85D26508E83_645086943.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_645086943;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.538 -0400", hash_original_method = "F475DA391A1931FE20FFD2579FFFF5AF", hash_generated_method = "393431B4098D65DE7EA03D3532FB8D39")
        @Override
        public CharSequence getSubtitle() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1739456791 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1739456791 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1739456791.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1739456791;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.538 -0400", hash_original_method = "7A49E6A1A0BF55D8D926541A71E4907E", hash_generated_method = "536CEB6A584E6815D22D111FB9FEDADE")
        @Override
        public View getCustomView() {
            View varB4EAC82CA7396A68D541C85D26508E83_1816142367 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1816142367 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1816142367.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1816142367;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.538 -0400", hash_original_method = "DECFD94D9899EA20C3E59178999FB9F7", hash_generated_method = "203DCCB6D3B6E06FFCE487CE66385C02")
        @Override
        public MenuInflater getMenuInflater() {
            MenuInflater varB4EAC82CA7396A68D541C85D26508E83_232450541 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_232450541 = new MenuInflater(getContext());
            varB4EAC82CA7396A68D541C85D26508E83_232450541.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_232450541;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.539 -0400", hash_original_method = "51BD8FD51955B080CEEB769553E9A9F7", hash_generated_method = "9B033E218C442898AC7006B48E513603")
        @Override
        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
            
            {
                boolean varEDF93C5517A51BAAA6230A19AB6D2347_653763771 = (mCallback.onActionItemClicked(this, item));
            } 
            addTaint(menu.getTaint());
            addTaint(item.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_162819021 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_162819021;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.539 -0400", hash_original_method = "BD3281B75359F57929C0B7D8E3BC0065", hash_generated_method = "4DC0BAA3678E3B1F051D28FC48B7B7DA")
        @Override
        public void onMenuModeChange(MenuBuilder menu) {
            
            addTaint(menu.getTaint());
            
        }

        
    }


    
}

