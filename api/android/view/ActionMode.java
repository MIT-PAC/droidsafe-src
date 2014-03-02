package android.view;

// Droidsafe Imports
import android.widget.PopupMenu;

import com.android.internal.view.menu.ContextMenuBuilder;

import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class ActionMode {
    
    public static ActionMode droidsafeObtainObject() {
        return new SimpleActionMode();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.142 -0500", hash_original_field = "87CC02BABEBC2A0BC6D4C7D0ADFF58E9", hash_generated_field = "EE550655758D5D3DEE98B11CF176B67D")

    private Object mTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.413 -0400", hash_original_method = "D3C302D61DC5B7843982EAB33028FB58", hash_generated_method = "D3C302D61DC5B7843982EAB33028FB58")
    public ActionMode ()
    {
        //Synthesized constructor
    }

    /**
     * Set a tag object associated with this ActionMode.
     *
     * <p>Like the tag available to views, this allows applications to associate arbitrary
     * data with an ActionMode for later reference.
     *
     * @param tag Tag to associate with this ActionMode
     *
     * @see #getTag()
     */
    @DSComment("Action mode, providing alternative interaction mode")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.144 -0500", hash_original_method = "256DC994AF5E64F19A2C820A8209C31D", hash_generated_method = "4B49D6D7D0735F0E1B7D1CA587CE5238")
    
public void setTag(Object tag) {
        mTag = tag;
    }

    /**
     * Retrieve the tag object associated with this ActionMode.
     *
     * <p>Like the tag available to views, this allows applications to associate arbitrary
     * data with an ActionMode for later reference.
     *
     * @return Tag associated with this ActionMode
     *
     * @see #setTag(Object)
     */
    @DSComment("Action mode, providing alternative interaction mode")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.147 -0500", hash_original_method = "15C9157ADF1B79E512CAFF71050D7BD7", hash_generated_method = "1B4659EEE0161BE6922AFBEB646209D7")
    
public Object getTag() {
        return mTag;
    }

    /**
     * Set the title of the action mode. This method will have no visible effect if
     * a custom view has been set.
     *
     * @param title Title string to set
     *
     * @see #setTitle(int)
     * @see #setCustomView(View)
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.149 -0500", hash_original_method = "410835EEA321510B785087E900780AFB", hash_generated_method = "F61FA778C52CF90209781407DFEFC387")
    
public abstract void setTitle(CharSequence title);

    /**
     * Set the title of the action mode. This method will have no visible effect if
     * a custom view has been set.
     *
     * @param resId Resource ID of a string to set as the title
     *
     * @see #setTitle(CharSequence)
     * @see #setCustomView(View)
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.152 -0500", hash_original_method = "516EEAF41A54C2F23324189E2ED4731D", hash_generated_method = "D271218F7CA96C8DBB89D368B635F8B6")
    
public abstract void setTitle(int resId);

    /**
     * Set the subtitle of the action mode. This method will have no visible effect if
     * a custom view has been set.
     *
     * @param subtitle Subtitle string to set
     *
     * @see #setSubtitle(int)
     * @see #setCustomView(View)
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.154 -0500", hash_original_method = "D00074A941BED700B112E60CA2B4BBFA", hash_generated_method = "0BA816A36095386377AF796A7E9F4E55")
    
public abstract void setSubtitle(CharSequence subtitle);

    /**
     * Set the subtitle of the action mode. This method will have no visible effect if
     * a custom view has been set.
     *
     * @param resId Resource ID of a string to set as the subtitle
     *
     * @see #setSubtitle(CharSequence)
     * @see #setCustomView(View)
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.156 -0500", hash_original_method = "08B7103B21D83BEA0EC09BF9CF437884", hash_generated_method = "8D1000593E31D74C218814097C6E4287")
    
public abstract void setSubtitle(int resId);

    /**
     * Set a custom view for this action mode. The custom view will take the place of
     * the title and subtitle. Useful for things like search boxes.
     *
     * @param view Custom view to use in place of the title/subtitle.
     *
     * @see #setTitle(CharSequence)
     * @see #setSubtitle(CharSequence)
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.159 -0500", hash_original_method = "75E78D59B0AC673EC9AC299DFF89779E", hash_generated_method = "3F5163B75632712B25ECCBFB0D907DF2")
    
public abstract void setCustomView(View view);

    /**
     * Invalidate the action mode and refresh menu content. The mode's
     * {@link ActionMode.Callback} will have its
     * {@link Callback#onPrepareActionMode(ActionMode, Menu)} method called.
     * If it returns true the menu will be scanned for updated content and any relevant changes
     * will be reflected to the user.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.161 -0500", hash_original_method = "70F593FC630C0533FD7D3758F8C5CFA1", hash_generated_method = "1747FC730FFA208D064087D81614198D")
    
public abstract void invalidate();

    /**
     * Finish and close this action mode. The action mode's {@link ActionMode.Callback} will
     * have its {@link Callback#onDestroyActionMode(ActionMode)} method called.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.164 -0500", hash_original_method = "813B1E67A5651AE12B7ADAA81DD30965", hash_generated_method = "EA335D0833EB6960285108A346A4AFC1")
    
public abstract void finish();

    /**
     * Returns the menu of actions that this action mode presents.
     * @return The action mode's menu.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.166 -0500", hash_original_method = "DCB61573D17CF52C77788C074BA8AC8B", hash_generated_method = "F0C4744A37BE92FD577BF28B66ABAB46")
    
public abstract Menu getMenu();

    /**
     * Returns the current title of this action mode.
     * @return Title text
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.168 -0500", hash_original_method = "2A829968551EA225833AD910559E3639", hash_generated_method = "9F704A6DC6184A7C8579171531B62A23")
    
public abstract CharSequence getTitle();

    /**
     * Returns the current subtitle of this action mode.
     * @return Subtitle text
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.171 -0500", hash_original_method = "FEEA0E87B97F8601D44AFB1E29DE7E64", hash_generated_method = "19C700D07F867A34AFE71438482B9BA4")
    
public abstract CharSequence getSubtitle();

    /**
     * Returns the current custom view for this action mode.
     * @return The current custom view
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.173 -0500", hash_original_method = "9FFDC35B3B54894B02C81A484E99C0EB", hash_generated_method = "E95F0DF95C54D06CFADD71C2C35C4CFF")
    
public abstract View getCustomView();

    /**
     * Returns a {@link MenuInflater} with the ActionMode's context.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.176 -0500", hash_original_method = "232216C9B01BF51DC3B19AC833B1F44A", hash_generated_method = "E76EC25552FE301AA15012E8BEC12C50")
    
public abstract MenuInflater getMenuInflater();
    
    public interface Callback {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public boolean onCreateActionMode(ActionMode mode, Menu menu);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public boolean onPrepareActionMode(ActionMode mode, Menu menu);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public boolean onActionItemClicked(ActionMode mode, MenuItem item);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onDestroyActionMode(ActionMode mode);
    }

    /**
     * Returns whether the UI presenting this action mode can take focus or not.
     * This is used by internal components within the framework that would otherwise
     * present an action mode UI that requires focus, such as an EditText as a custom view.
     *
     * @return true if the UI used to show this action mode can take focus
     * @hide Internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:04.178 -0500", hash_original_method = "57D435E5DB9DAA5D06EB98D67411AC43", hash_generated_method = "BCCFD0C1F6AE7BD81B649ACADC755607")
    
public boolean isUiFocusable() {
        return true;
    }
    
    public static class SimpleActionMode extends ActionMode {
        
        CharSequence mTitle;
        CharSequence mSubtitle;
        View mView;
        
        @DSVerified
        @DSSafe(DSCat.SAFE_OTHERS)
        public SimpleActionMode() {
            mView = new View();
        }
        @DSSafe(DSCat.SAFE_OTHERS)
        public SimpleActionMode(int mode) {
            mView = new View();
        }
         
        @DSSafe(DSCat.SAFE_OTHERS)
        @Override
        public void setTitle(CharSequence title) {
            // TODO Auto-generated method stub
            mTitle = title;
        }
        @Override
        
        public void setTitle(int resId) {
            // TODO Auto-generated method stub
            mTitle = mView.getContext().getText(resId);
        }

        @Override
        
        public void setSubtitle(CharSequence subtitle) {
            // TODO Auto-generated method stub
            mSubtitle = subtitle;
        }

        @Override
        @DSSafe(DSCat.SAFE_OTHERS)
        public void setSubtitle(int resId) {
            // TODO Auto-generated method stub
            mSubtitle = mView.getContext().getText(resId);
        }

        @Override
        @DSSafe(DSCat.SAFE_OTHERS)
        public void setCustomView(View view) {
            // TODO Auto-generated method stub
            mView = view;
        }

        @Override
        
        public void invalidate() {
            // TODO Auto-generated method stub
            
        }

        @Override
        
        public void finish() {
            // TODO Auto-generated method stub
            
        }

        @Override
        
        public Menu getMenu() {
            // TODO Auto-generated method stub
           
            return new ContextMenuBuilder(mView.getContext());
        }

        @Override
        
        public CharSequence getTitle() {
            // TODO Auto-generated method stub
            return mTitle;
        }

        @Override
        
        public CharSequence getSubtitle() {
            // TODO Auto-generated method stub
            return mSubtitle;
        }

        @Override
        
        public View getCustomView() {
            // TODO Auto-generated method stub
            return mView;
        }

        @Override
        
        public MenuInflater getMenuInflater() {
            // TODO Auto-generated method stub
            View v = mView;
            MenuInflater inflater = new MenuInflater(v.getContext());
            inflater.addTaint(getTaint());
            return inflater;
        }
        
    }
}

