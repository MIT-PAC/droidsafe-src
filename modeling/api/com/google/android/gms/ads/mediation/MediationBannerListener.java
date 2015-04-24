/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package com.google.android.gms.ads.mediation;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public abstract interface MediationBannerListener
{

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void onAdLoaded(MediationBannerAdapter  r0);

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void onAdFailedToLoad(MediationBannerAdapter  r0, int  i1);

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void onAdOpened(MediationBannerAdapter  r0);

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void onAdClosed(MediationBannerAdapter  r0);

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void onAdLeftApplication(MediationBannerAdapter  r0);

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void onAdClicked(MediationBannerAdapter  r0);
}
