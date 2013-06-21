package com.android.internal.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.DragEvent;
import android.view.IWindow;
import android.view.IWindowSession;

public class BaseIWindow extends IWindow.Stub {
    private IWindowSession mSession;
    public int mSeq;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.955 -0400", hash_original_method = "6538A8C9EF5A5F3250E102EE3E24A445", hash_generated_method = "6538A8C9EF5A5F3250E102EE3E24A445")
        public BaseIWindow ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.955 -0400", hash_original_method = "DDDF8BE863F51F4784FBED4F44364C1D", hash_generated_method = "40A4FE9CC62C01BA8DEFC1367DB6E7F6")
    @DSModeled(DSC.SAFE)
    public void setSession(IWindowSession session) {
        dsTaint.addTaint(session.dsTaint);
        // ---------- Original Method ----------
        //mSession = session;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.955 -0400", hash_original_method = "B78D43805956C22534D670D6CA75C80F", hash_generated_method = "7F54D2EF70640A613D6B749DA9443F9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void resized(int w, int h, Rect coveredInsets,
            Rect visibleInsets, boolean reportDraw, Configuration newConfig) {
        dsTaint.addTaint(w);
        dsTaint.addTaint(visibleInsets.dsTaint);
        dsTaint.addTaint(reportDraw);
        dsTaint.addTaint(newConfig.dsTaint);
        dsTaint.addTaint(coveredInsets.dsTaint);
        dsTaint.addTaint(h);
        {
            try 
            {
                mSession.finishDrawing(this);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        // ---------- Original Method ----------
        //if (reportDraw) {
            //try {
                //mSession.finishDrawing(this);
            //} catch (RemoteException e) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.956 -0400", hash_original_method = "BE0716F4AD0CF82E07CDF7A02946EA01", hash_generated_method = "7EDA35E6DCECAF8A5FFF06D6B921805C")
    @DSModeled(DSC.SAFE)
    public void dispatchAppVisibility(boolean visible) {
        dsTaint.addTaint(visible);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.956 -0400", hash_original_method = "772CEEEC7D5AEF0AF70740664444DBC4", hash_generated_method = "DFC4B13DC642E23ADDFEF747CDDDFBCC")
    @DSModeled(DSC.SAFE)
    public void dispatchGetNewSurface() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.956 -0400", hash_original_method = "D905966528548D16DAB92D4F551B9EC2", hash_generated_method = "F6217EB40E8DBAA98E87D8C43D84032E")
    @DSModeled(DSC.SAFE)
    public void windowFocusChanged(boolean hasFocus, boolean touchEnabled) {
        dsTaint.addTaint(touchEnabled);
        dsTaint.addTaint(hasFocus);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.956 -0400", hash_original_method = "FFE9D2CBC83B323644FA8C6DFE6F40CA", hash_generated_method = "EB41CF4B5154F9AF2BF07F3A57CF266A")
    @DSModeled(DSC.SAFE)
    public void executeCommand(String command, String parameters, ParcelFileDescriptor out) {
        dsTaint.addTaint(command);
        dsTaint.addTaint(parameters);
        dsTaint.addTaint(out.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.956 -0400", hash_original_method = "829D6830743782B159BBDA8D0B21AA05", hash_generated_method = "9E5C020ECD7F2F1ACAFCB08D721C3EC0")
    @DSModeled(DSC.SAFE)
    public void closeSystemDialogs(String reason) {
        dsTaint.addTaint(reason);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.956 -0400", hash_original_method = "5012B02F4729E57505C4DA5AF3CD3EF7", hash_generated_method = "25001EE2C83BEFEA087D36FE9DFF45B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchWallpaperOffsets(float x, float y, float xStep, float yStep, boolean sync) {
        dsTaint.addTaint(sync);
        dsTaint.addTaint(xStep);
        dsTaint.addTaint(yStep);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            try 
            {
                mSession.wallpaperOffsetsComplete(asBinder());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        // ---------- Original Method ----------
        //if (sync) {
            //try {
                //mSession.wallpaperOffsetsComplete(asBinder());
            //} catch (RemoteException e) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.957 -0400", hash_original_method = "3961AB29F0B7DEEA47B4CBEA679C2606", hash_generated_method = "AB6C3E4CEE86429E2A9CEFA0E7238785")
    @DSModeled(DSC.SAFE)
    public void dispatchDragEvent(DragEvent event) {
        dsTaint.addTaint(event.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.957 -0400", hash_original_method = "0828E805F96F67CD22A73377A61D4574", hash_generated_method = "DE817A269B67BCB02C8DDB5B1AC78B48")
    @DSModeled(DSC.SAFE)
    public void dispatchSystemUiVisibilityChanged(int seq, int globalUi,
            int localValue, int localChanges) {
        dsTaint.addTaint(localChanges);
        dsTaint.addTaint(localValue);
        dsTaint.addTaint(seq);
        dsTaint.addTaint(globalUi);
        // ---------- Original Method ----------
        //mSeq = seq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.957 -0400", hash_original_method = "CCCF2ED340559A471760B73050C6F938", hash_generated_method = "360879A6604BC38BF5D4CB393B3E21EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchWallpaperCommand(String action, int x, int y,
            int z, Bundle extras, boolean sync) {
        dsTaint.addTaint(sync);
        dsTaint.addTaint(action);
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(extras.dsTaint);
        dsTaint.addTaint(x);
        {
            try 
            {
                mSession.wallpaperCommandComplete(asBinder(), null);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        // ---------- Original Method ----------
        //if (sync) {
            //try {
                //mSession.wallpaperCommandComplete(asBinder(), null);
            //} catch (RemoteException e) {
            //}
        //}
    }

    
}

