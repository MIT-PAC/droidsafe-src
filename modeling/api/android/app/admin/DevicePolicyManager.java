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
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.app.admin;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.ServiceManager;

public class DevicePolicyManager {

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.663 -0500", hash_original_method = "55AE6CA87895AD6E1A6D7E33BF40E1AD", hash_generated_method = "E46DC9ABD03A3356F5D1E8EF744443B9")
    
public static DevicePolicyManager create(Context context, Handler handler) {
        DevicePolicyManager me = new DevicePolicyManager(context, handler);
        return me.mService != null ? me : null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.653 -0500", hash_original_field = "9190DF3EFF34FCEFD01405440D426757", hash_generated_field = "FF900525E51DBB3F6D9B2A6E08054C76")

    private static String TAG = "DevicePolicyManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.666 -0500", hash_original_field = "21A07E75D2DAE150F905F6B9D4FCE5D3", hash_generated_field = "CDF0D3A915C96327043A2D40EDE2C92A")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ADD_DEVICE_ADMIN
            = "android.app.action.ADD_DEVICE_ADMIN";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.668 -0500", hash_original_field = "937A07734998A09915E3E4D89CD33CF8", hash_generated_field = "5BDD43B8A0E93C7D4FDE8B1FA69FAF93")

    public static final String ACTION_DEVICE_POLICY_MANAGER_STATE_CHANGED
            = "android.app.action.DEVICE_POLICY_MANAGER_STATE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.671 -0500", hash_original_field = "2E843652564362F549937C95209A0BA8", hash_generated_field = "8C18FCF3FC885F2E0E13E7C006ED1A43")

    public static final String EXTRA_DEVICE_ADMIN = "android.app.extra.DEVICE_ADMIN";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.673 -0500", hash_original_field = "F4F5EFD88A7C7FF2182E93D909B97406", hash_generated_field = "89CEC099D619C862DB69E018F3BFDC73")

    public static final String EXTRA_ADD_EXPLANATION = "android.app.extra.ADD_EXPLANATION";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.675 -0500", hash_original_field = "03F3617FA90788FC385BFAAA7A041CCE", hash_generated_field = "E3AD59906BAAA7B9E356941998879FE7")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SET_NEW_PASSWORD
            = "android.app.action.SET_NEW_PASSWORD";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.689 -0500", hash_original_field = "6CCCDF5C22D3D3AD40D242B2086D02C3", hash_generated_field = "420ABA592DCBCC7FDBBD6984C905D379")

    public static final int PASSWORD_QUALITY_UNSPECIFIED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.691 -0500", hash_original_field = "8E51C9045007C12E228AE1F0FB968491", hash_generated_field = "33A112A34C5C25DFBD5A157010E89532")

    public static final int PASSWORD_QUALITY_BIOMETRIC_WEAK = 0x8000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.694 -0500", hash_original_field = "11DB6EF3D35BB23FEFDD4461959F1FB8", hash_generated_field = "7D590DB4720EE2DDFEFB4FFA71549D9C")

    public static final int PASSWORD_QUALITY_SOMETHING = 0x10000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.696 -0500", hash_original_field = "E32E5A174C17DA00C7D7104BEFD56CC6", hash_generated_field = "6079C1AD224868A1FD2E6C91F592E8E5")

    public static final int PASSWORD_QUALITY_NUMERIC = 0x20000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.698 -0500", hash_original_field = "9F11D95DC42EE5FA270A8B49D81D3649", hash_generated_field = "4CF28041A91E5136B4028DFC45BF43A2")

    public static final int PASSWORD_QUALITY_ALPHABETIC = 0x40000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.701 -0500", hash_original_field = "301E79E8B3BECA6431AAD1787688A804", hash_generated_field = "19D36D84D76399F2965778802906C5F4")

    public static final int PASSWORD_QUALITY_ALPHANUMERIC = 0x50000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.704 -0500", hash_original_field = "52CC266791BE5DFC77FB5E19767C8E7D", hash_generated_field = "B6900B6DFFCE3EC3137AFAC8CDF141C8")

    public static final int PASSWORD_QUALITY_COMPLEX = 0x60000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.769 -0500", hash_original_field = "14498304BE487A48CFA7FCBD2961B4BF", hash_generated_field = "A25E572D19EAB5FC775D99C2E5CBD7F9")

    public static final int RESET_PASSWORD_REQUIRE_ENTRY = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.780 -0500", hash_original_field = "BB0190315F212ABEC87FEE2FEF0285D5", hash_generated_field = "6DBBDEA2F83957970766E3EB7A360D87")

    public static final int WIPE_EXTERNAL_STORAGE = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.791 -0500", hash_original_field = "F6A79ACB642F68E0231ADEF36F08F5D9", hash_generated_field = "C963AC3E0F57998F2C6F71339C6345A2")

    public static final int ENCRYPTION_STATUS_UNSUPPORTED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.793 -0500", hash_original_field = "DCB533AE10ED5FEECFAD8E5F982D8F74", hash_generated_field = "9BC8B9B07F2BB6E9920B39CA1C7F82FB")

    public static final int ENCRYPTION_STATUS_INACTIVE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.795 -0500", hash_original_field = "273A71838109512D42735C89C0F45BC8", hash_generated_field = "5F4944DA22B7A103647F3EE380E7C7E1")

    public static final int ENCRYPTION_STATUS_ACTIVATING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.798 -0500", hash_original_field = "50A233A8D95B2111069CC282A8501EB3", hash_generated_field = "4AECE9433F73E3025A1218697C4A55F7")

    public static final int ENCRYPTION_STATUS_ACTIVE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.800 -0500", hash_original_field = "A052CD99A5D5FB1455AE5EC8C6134EF5", hash_generated_field = "D3A52877D04884CC38F2F15EF3C82C3E")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_START_ENCRYPTION
            = "android.app.action.START_ENCRYPTION";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.656 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.658 -0500", hash_original_field = "7C2672154573FCF3BE1B466023E739FB", hash_generated_field = "E263D54C98D833F4BF6DB51617AA3116")

    private  IDevicePolicyManager mService;
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.708 -0400", hash_original_method = "50DCCFAFB01D68C84073DED89668D8AE", hash_generated_method = "C38A3CAA5978B5E74759E44B9191AA99")
    private  DevicePolicyManager(Context context, Handler handler) {
        //addTaint(handler.getTaint());
        //addTaint(context.getTaint());
        mContext = context;
        mService = IDevicePolicyManager.Stub.asInterface(
                ServiceManager.getService(Context.DEVICE_POLICY_SERVICE));
        // ---------- Original Method ----------
        //mContext = context;
        //mService = IDevicePolicyManager.Stub.asInterface(
                //ServiceManager.getService(Context.DEVICE_POLICY_SERVICE));
    }
    
    //Injected by hand modeling
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.708 -0400", hash_original_method = "50DCCFAFB01D68C84073DED89668D8AE", hash_generated_method = "C38A3CAA5978B5E74759E44B9191AA99")
    public DevicePolicyManager(Context context) {
        //addTaint(context.getTaint());
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
        //mService = IDevicePolicyManager.Stub.asInterface(
                //ServiceManager.getService(Context.DEVICE_POLICY_SERVICE));
    }

    /**
     * Return true if the given administrator component is currently
     * active (enabled) in the system.
     */
    @DSComment("device administration")
    @DSSpec(DSCat.DEVICE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.678 -0500", hash_original_method = "DEBAA688BC0765F8640468141F520924", hash_generated_method = "27BF5B51AAA4CF65F3AECBF647F40D39")
    
public boolean isAdminActive(ComponentName who) {
        if (mService != null) {
            try {
                return mService.isAdminActive(who);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return false;
    }

    /**
     * Return a list of all currently active device administrator's component
     * names.  Note that if there are no administrators than null may be
     * returned.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.680 -0500", hash_original_method = "304202BD61CAAFAF35BBB8D3C8BC6AB8", hash_generated_method = "D03CA4F02C9F9CBC5C13F43C507A75A3")
    
public List<ComponentName> getActiveAdmins() {
        if (mService != null) {
            try {
                return mService.getActiveAdmins();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return null;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.682 -0500", hash_original_method = "EE57BBE804AE4C87F4CB89ED9793C019", hash_generated_method = "E6F88F156CDC64E1A938C26BA56167FA")
    
public boolean packageHasActiveAdmins(String packageName) {
        if (mService != null) {
            try {
                return mService.packageHasActiveAdmins(packageName);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return false;
    }

    /**
     * Remove a current administration component.  This can only be called
     * by the application that owns the administration component; if you
     * try to remove someone else's component, a security exception will be
     * thrown.
     */
    @DSComment("device administration")
    @DSSpec(DSCat.DEVICE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.684 -0500", hash_original_method = "260DBD46AB1A27EF2CC0A61E058D7901", hash_generated_method = "A34F6369DE54268FFED0D29DF5F4D187")
    
public void removeActiveAdmin(ComponentName who) {
        if (mService != null) {
            try {
                mService.removeActiveAdmin(who);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * Returns true if an administrator has been granted a particular device policy.  This can
     * be used to check if the administrator was activated under an earlier set of policies,
     * but requires additional policies after an upgrade.
     *
     * @param admin Which {@link DeviceAdminReceiver} this request is associated with.  Must be
     * an active administrator, or an exception will be thrown.
     * @param usesPolicy Which uses-policy to check, as defined in {@link DeviceAdminInfo}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.687 -0500", hash_original_method = "23A835CF05C7A5BCBD423FD3E5C1A622", hash_generated_method = "D469B2833BA2D077E5FD498CA9DE392F")
    
public boolean hasGrantedPolicy(ComponentName admin, int usesPolicy) {
        if (mService != null) {
            try {
                return mService.hasGrantedPolicy(admin, usesPolicy);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return false;
    }

    /**
     * Called by an application that is administering the device to set the
     * password restrictions it is imposing.  After setting this, the user
     * will not be able to enter a new password that is not at least as
     * restrictive as what has been set.  Note that the current password
     * will remain until the user has set a new one, so the change does not
     * take place immediately.  To prompt the user for a new password, use
     * {@link #ACTION_SET_NEW_PASSWORD} after setting this value.
     *
     * <p>Quality constants are ordered so that higher values are more restrictive;
     * thus the highest requested quality constant (between the policy set here,
     * the user's preference, and any other considerations) is the one that
     * is in effect.
     *
     * <p>The calling device admin must have requested
     * {@link DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call
     * this method; if it has not, a security exception will be thrown.
     *
     * @param admin Which {@link DeviceAdminReceiver} this request is associated with.
     * @param quality The new desired quality.  One of
     * {@link #PASSWORD_QUALITY_UNSPECIFIED}, {@link #PASSWORD_QUALITY_SOMETHING},
     * {@link #PASSWORD_QUALITY_NUMERIC}, {@link #PASSWORD_QUALITY_ALPHABETIC},
     * {@link #PASSWORD_QUALITY_ALPHANUMERIC} or {@link #PASSWORD_QUALITY_COMPLEX}.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.706 -0500", hash_original_method = "59F8BF318650672CABE968E5789C79B4", hash_generated_method = "E4FDC421A930C78ABB10B0F505610904")
    
public void setPasswordQuality(ComponentName admin, int quality) {
        if (mService != null) {
            try {
                mService.setPasswordQuality(admin, quality);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * Retrieve the current minimum password quality for all admins
     * or a particular one.
     * @param admin The name of the admin component to check, or null to aggregate
     * all admins.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.708 -0500", hash_original_method = "953DAEE8D36D414E1ED2EDA688583D7B", hash_generated_method = "2C6B293E9B7AB9983F9B16E1AD95E00A")
    
public int getPasswordQuality(ComponentName admin) {
        if (mService != null) {
            try {
                return mService.getPasswordQuality(admin);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return PASSWORD_QUALITY_UNSPECIFIED;
    }

    /**
     * Called by an application that is administering the device to set the
     * minimum allowed password length.  After setting this, the user
     * will not be able to enter a new password that is not at least as
     * restrictive as what has been set.  Note that the current password
     * will remain until the user has set a new one, so the change does not
     * take place immediately.  To prompt the user for a new password, use
     * {@link #ACTION_SET_NEW_PASSWORD} after setting this value.  This
     * constraint is only imposed if the administrator has also requested either
     * {@link #PASSWORD_QUALITY_NUMERIC}, {@link #PASSWORD_QUALITY_ALPHABETIC}
     * {@link #PASSWORD_QUALITY_ALPHANUMERIC}, or {@link #PASSWORD_QUALITY_COMPLEX}
     * with {@link #setPasswordQuality}.
     *
     * <p>The calling device admin must have requested
     * {@link DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call
     * this method; if it has not, a security exception will be thrown.
     *
     * @param admin Which {@link DeviceAdminReceiver} this request is associated with.
     * @param length The new desired minimum password length.  A value of 0
     * means there is no restriction.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.711 -0500", hash_original_method = "F270559FB103FDDF70DB07978E6CE793", hash_generated_method = "8BAE076C0FA25459742B0C469F0B4148")
    
public void setPasswordMinimumLength(ComponentName admin, int length) {
        if (mService != null) {
            try {
                mService.setPasswordMinimumLength(admin, length);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * Retrieve the current minimum password length for all admins
     * or a particular one.
     * @param admin The name of the admin component to check, or null to aggregate
     * all admins.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.713 -0500", hash_original_method = "0BF67C005C50195D588980E6F78FE344", hash_generated_method = "DBCE40106A43C0201EFDB697938390EF")
    
public int getPasswordMinimumLength(ComponentName admin) {
        if (mService != null) {
            try {
                return mService.getPasswordMinimumLength(admin);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return 0;
    }

    /**
     * Called by an application that is administering the device to set the
     * minimum number of upper case letters required in the password. After
     * setting this, the user will not be able to enter a new password that is
     * not at least as restrictive as what has been set. Note that the current
     * password will remain until the user has set a new one, so the change does
     * not take place immediately. To prompt the user for a new password, use
     * {@link #ACTION_SET_NEW_PASSWORD} after setting this value. This
     * constraint is only imposed if the administrator has also requested
     * {@link #PASSWORD_QUALITY_COMPLEX} with {@link #setPasswordQuality}. The
     * default value is 0.
     * <p>
     * The calling device admin must have requested
     * {@link DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call
     * this method; if it has not, a security exception will be thrown.
     *
     * @param admin Which {@link DeviceAdminReceiver} this request is associated
     *            with.
     * @param length The new desired minimum number of upper case letters
     *            required in the password. A value of 0 means there is no
     *            restriction.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.715 -0500", hash_original_method = "B0A7D811F24F382978794CAD91B66775", hash_generated_method = "475B1508F81885AACD1750F17D3741B5")
    
public void setPasswordMinimumUpperCase(ComponentName admin, int length) {
        if (mService != null) {
            try {
                mService.setPasswordMinimumUpperCase(admin, length);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * Retrieve the current number of upper case letters required in the
     * password for all admins or a particular one. This is the same value as
     * set by {#link {@link #setPasswordMinimumUpperCase(ComponentName, int)}
     * and only applies when the password quality is
     * {@link #PASSWORD_QUALITY_COMPLEX}.
     *
     * @param admin The name of the admin component to check, or null to
     *            aggregate all admins.
     * @return The minimum number of upper case letters required in the
     *         password.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.717 -0500", hash_original_method = "42E8A5AFC85991E9FFA780A53F7AB6A7", hash_generated_method = "EB6FB860F38272C8D5E477319E563294")
    
public int getPasswordMinimumUpperCase(ComponentName admin) {
        if (mService != null) {
            try {
                return mService.getPasswordMinimumUpperCase(admin);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return 0;
    }

    /**
     * Called by an application that is administering the device to set the
     * minimum number of lower case letters required in the password. After
     * setting this, the user will not be able to enter a new password that is
     * not at least as restrictive as what has been set. Note that the current
     * password will remain until the user has set a new one, so the change does
     * not take place immediately. To prompt the user for a new password, use
     * {@link #ACTION_SET_NEW_PASSWORD} after setting this value. This
     * constraint is only imposed if the administrator has also requested
     * {@link #PASSWORD_QUALITY_COMPLEX} with {@link #setPasswordQuality}. The
     * default value is 0.
     * <p>
     * The calling device admin must have requested
     * {@link DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call
     * this method; if it has not, a security exception will be thrown.
     *
     * @param admin Which {@link DeviceAdminReceiver} this request is associated
     *            with.
     * @param length The new desired minimum number of lower case letters
     *            required in the password. A value of 0 means there is no
     *            restriction.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.719 -0500", hash_original_method = "411E57E6ADFDEF4CCE60FF315FF9330B", hash_generated_method = "D0A36400D0E336E48CE052EE786103DC")
    
public void setPasswordMinimumLowerCase(ComponentName admin, int length) {
        if (mService != null) {
            try {
                mService.setPasswordMinimumLowerCase(admin, length);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * Retrieve the current number of lower case letters required in the
     * password for all admins or a particular one. This is the same value as
     * set by {#link {@link #setPasswordMinimumLowerCase(ComponentName, int)}
     * and only applies when the password quality is
     * {@link #PASSWORD_QUALITY_COMPLEX}.
     *
     * @param admin The name of the admin component to check, or null to
     *            aggregate all admins.
     * @return The minimum number of lower case letters required in the
     *         password.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.722 -0500", hash_original_method = "115CC4F3CDF24178A32FCDB4FA3C0CE3", hash_generated_method = "79DFB16A6010C875B95F508E4F4ECA00")
    
public int getPasswordMinimumLowerCase(ComponentName admin) {
        if (mService != null) {
            try {
                return mService.getPasswordMinimumLowerCase(admin);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return 0;
    }

    /**
     * Called by an application that is administering the device to set the
     * minimum number of letters required in the password. After setting this,
     * the user will not be able to enter a new password that is not at least as
     * restrictive as what has been set. Note that the current password will
     * remain until the user has set a new one, so the change does not take
     * place immediately. To prompt the user for a new password, use
     * {@link #ACTION_SET_NEW_PASSWORD} after setting this value. This
     * constraint is only imposed if the administrator has also requested
     * {@link #PASSWORD_QUALITY_COMPLEX} with {@link #setPasswordQuality}. The
     * default value is 1.
     * <p>
     * The calling device admin must have requested
     * {@link DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call
     * this method; if it has not, a security exception will be thrown.
     *
     * @param admin Which {@link DeviceAdminReceiver} this request is associated
     *            with.
     * @param length The new desired minimum number of letters required in the
     *            password. A value of 0 means there is no restriction.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.724 -0500", hash_original_method = "14047A2F7D126C90FC5B2063BAF2E4A1", hash_generated_method = "D8C1F0AAAC2A113877CE35A3AB13ADD9")
    
public void setPasswordMinimumLetters(ComponentName admin, int length) {
        if (mService != null) {
            try {
                mService.setPasswordMinimumLetters(admin, length);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * Retrieve the current number of letters required in the password for all
     * admins or a particular one. This is the same value as
     * set by {#link {@link #setPasswordMinimumLetters(ComponentName, int)}
     * and only applies when the password quality is
     * {@link #PASSWORD_QUALITY_COMPLEX}.
     *
     * @param admin The name of the admin component to check, or null to
     *            aggregate all admins.
     * @return The minimum number of letters required in the password.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.726 -0500", hash_original_method = "B7290C5B6AA0AFA6598FFFCBACAFA85A", hash_generated_method = "64429EBBF24BA57FD0661F530EA473CF")
    
public int getPasswordMinimumLetters(ComponentName admin) {
        if (mService != null) {
            try {
                return mService.getPasswordMinimumLetters(admin);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return 0;
    }

    /**
     * Called by an application that is administering the device to set the
     * minimum number of numerical digits required in the password. After
     * setting this, the user will not be able to enter a new password that is
     * not at least as restrictive as what has been set. Note that the current
     * password will remain until the user has set a new one, so the change does
     * not take place immediately. To prompt the user for a new password, use
     * {@link #ACTION_SET_NEW_PASSWORD} after setting this value. This
     * constraint is only imposed if the administrator has also requested
     * {@link #PASSWORD_QUALITY_COMPLEX} with {@link #setPasswordQuality}. The
     * default value is 1.
     * <p>
     * The calling device admin must have requested
     * {@link DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call
     * this method; if it has not, a security exception will be thrown.
     *
     * @param admin Which {@link DeviceAdminReceiver} this request is associated
     *            with.
     * @param length The new desired minimum number of numerical digits required
     *            in the password. A value of 0 means there is no restriction.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.728 -0500", hash_original_method = "33FACE9A88EEFFC907427A4DE2511E88", hash_generated_method = "9EA2C9368E33C29479AF22723F246866")
    
public void setPasswordMinimumNumeric(ComponentName admin, int length) {
        if (mService != null) {
            try {
                mService.setPasswordMinimumNumeric(admin, length);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * Retrieve the current number of numerical digits required in the password
     * for all admins or a particular one. This is the same value as
     * set by {#link {@link #setPasswordMinimumNumeric(ComponentName, int)}
     * and only applies when the password quality is
     * {@link #PASSWORD_QUALITY_COMPLEX}.
     *
     * @param admin The name of the admin component to check, or null to
     *            aggregate all admins.
     * @return The minimum number of numerical digits required in the password.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.731 -0500", hash_original_method = "55CECC6BB4262687B1FECD13F88E35AB", hash_generated_method = "9D9515B58E2E504EBEDA6D7C6359ABE2")
    
public int getPasswordMinimumNumeric(ComponentName admin) {
        if (mService != null) {
            try {
                return mService.getPasswordMinimumNumeric(admin);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return 0;
    }

    /**
     * Called by an application that is administering the device to set the
     * minimum number of symbols required in the password. After setting this,
     * the user will not be able to enter a new password that is not at least as
     * restrictive as what has been set. Note that the current password will
     * remain until the user has set a new one, so the change does not take
     * place immediately. To prompt the user for a new password, use
     * {@link #ACTION_SET_NEW_PASSWORD} after setting this value. This
     * constraint is only imposed if the administrator has also requested
     * {@link #PASSWORD_QUALITY_COMPLEX} with {@link #setPasswordQuality}. The
     * default value is 1.
     * <p>
     * The calling device admin must have requested
     * {@link DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call
     * this method; if it has not, a security exception will be thrown.
     *
     * @param admin Which {@link DeviceAdminReceiver} this request is associated
     *            with.
     * @param length The new desired minimum number of symbols required in the
     *            password. A value of 0 means there is no restriction.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.733 -0500", hash_original_method = "D86720687DC7C5B971FF240E5ADCEB58", hash_generated_method = "110913DA2CB88B38CEC0609BC70AB910")
    
public void setPasswordMinimumSymbols(ComponentName admin, int length) {
        if (mService != null) {
            try {
                mService.setPasswordMinimumSymbols(admin, length);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * Retrieve the current number of symbols required in the password for all
     * admins or a particular one. This is the same value as
     * set by {#link {@link #setPasswordMinimumSymbols(ComponentName, int)}
     * and only applies when the password quality is
     * {@link #PASSWORD_QUALITY_COMPLEX}.
     *
     * @param admin The name of the admin component to check, or null to
     *            aggregate all admins.
     * @return The minimum number of symbols required in the password.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.735 -0500", hash_original_method = "97C1C4934ACB04DD5927B31B09CB55B5", hash_generated_method = "E861BE5402ABF5F6E67D4341563B3C14")
    
public int getPasswordMinimumSymbols(ComponentName admin) {
        if (mService != null) {
            try {
                return mService.getPasswordMinimumSymbols(admin);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return 0;
    }

    /**
     * Called by an application that is administering the device to set the
     * minimum number of non-letter characters (numerical digits or symbols)
     * required in the password. After setting this, the user will not be able
     * to enter a new password that is not at least as restrictive as what has
     * been set. Note that the current password will remain until the user has
     * set a new one, so the change does not take place immediately. To prompt
     * the user for a new password, use {@link #ACTION_SET_NEW_PASSWORD} after
     * setting this value. This constraint is only imposed if the administrator
     * has also requested {@link #PASSWORD_QUALITY_COMPLEX} with
     * {@link #setPasswordQuality}. The default value is 0.
     * <p>
     * The calling device admin must have requested
     * {@link DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call
     * this method; if it has not, a security exception will be thrown.
     *
     * @param admin Which {@link DeviceAdminReceiver} this request is associated
     *            with.
     * @param length The new desired minimum number of letters required in the
     *            password. A value of 0 means there is no restriction.
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.737 -0500", hash_original_method = "8F226B24E69D209379BEE3195F22A7DC", hash_generated_method = "E615574F9EF7ADEA63048ED12239348A")
    
public void setPasswordMinimumNonLetter(ComponentName admin, int length) {
        if (mService != null) {
            try {
                mService.setPasswordMinimumNonLetter(admin, length);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * Retrieve the current number of non-letter characters required in the
     * password for all admins or a particular one. This is the same value as
     * set by {#link {@link #setPasswordMinimumNonLetter(ComponentName, int)}
     * and only applies when the password quality is
     * {@link #PASSWORD_QUALITY_COMPLEX}.
     *
     * @param admin The name of the admin component to check, or null to
     *            aggregate all admins.
     * @return The minimum number of letters required in the password.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.739 -0500", hash_original_method = "8ED1E73D193F12CF2F8CF85176FE9B97", hash_generated_method = "6C66EF3A44A86EC3057D1B7A99F3E408")
    
public int getPasswordMinimumNonLetter(ComponentName admin) {
        if (mService != null) {
            try {
                return mService.getPasswordMinimumNonLetter(admin);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return 0;
    }

  /**
   * Called by an application that is administering the device to set the length
   * of the password history. After setting this, the user will not be able to
   * enter a new password that is the same as any password in the history. Note
   * that the current password will remain until the user has set a new one, so
   * the change does not take place immediately. To prompt the user for a new
   * password, use {@link #ACTION_SET_NEW_PASSWORD} after setting this value.
   * This constraint is only imposed if the administrator has also requested
   * either {@link #PASSWORD_QUALITY_NUMERIC},
   * {@link #PASSWORD_QUALITY_ALPHABETIC}, or
   * {@link #PASSWORD_QUALITY_ALPHANUMERIC} with {@link #setPasswordQuality}.
   *
   * <p>
   * The calling device admin must have requested
   * {@link DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call this
   * method; if it has not, a security exception will be thrown.
   *
   * @param admin Which {@link DeviceAdminReceiver} this request is associated
   *        with.
   * @param length The new desired length of password history. A value of 0
   *        means there is no restriction.
   */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.741 -0500", hash_original_method = "56A45FF24A713BC35886C94CD936741A", hash_generated_method = "35DE2A00AA0D79BCB282660E1DEA9EB5")
    
public void setPasswordHistoryLength(ComponentName admin, int length) {
        if (mService != null) {
            try {
                mService.setPasswordHistoryLength(admin, length);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * Called by a device admin to set the password expiration timeout. Calling this method
     * will restart the countdown for password expiration for the given admin, as will changing
     * the device password (for all admins).
     *
     * <p>The provided timeout is the time delta in ms and will be added to the current time.
     * For example, to have the password expire 5 days from now, timeout would be
     * 5 * 86400 * 1000 = 432000000 ms for timeout.
     *
     * <p>To disable password expiration, a value of 0 may be used for timeout.
     *
     * <p>The calling device admin must have requested
     * {@link DeviceAdminInfo#USES_POLICY_EXPIRE_PASSWORD} to be able to call this
     * method; if it has not, a security exception will be thrown.
     *
     * @param admin Which {@link DeviceAdminReceiver} this request is associated with.
     * @param timeout The limit (in ms) that a password can remain in effect. A value of 0
     *        means there is no restriction (unlimited).
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.749 -0500", hash_original_method = "A2F840E60969344CDBBA08F42E12EB97", hash_generated_method = "F1271CF92F6B3701D8E992F7EB492240")
    
public void setPasswordExpirationTimeout(ComponentName admin, long timeout) {
        if (mService != null) {
            try {
                mService.setPasswordExpirationTimeout(admin, timeout);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * Get the password expiration timeout for the given admin. The expiration timeout is the
     * recurring expiration timeout provided in the call to
     * {@link #setPasswordExpirationTimeout(ComponentName, long)} for the given admin or the
     * aggregate of all policy administrators if admin is null.
     *
     * @param admin The name of the admin component to check, or null to aggregate all admins.
     * @return The timeout for the given admin or the minimum of all timeouts
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.751 -0500", hash_original_method = "31D7885DD1B838E718F93D593801E489", hash_generated_method = "72E49514A1125DF1E3AA246A2F2C4630")
    
public long getPasswordExpirationTimeout(ComponentName admin) {
        if (mService != null) {
            try {
                return mService.getPasswordExpirationTimeout(admin);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return 0;
    }

    /**
     * Get the current password expiration time for the given admin or an aggregate of
     * all admins if admin is null. If the password is expired, this will return the time since
     * the password expired as a negative number.  If admin is null, then a composite of all
     * expiration timeouts is returned - which will be the minimum of all timeouts.
     *
     * @param admin The name of the admin component to check, or null to aggregate all admins.
     * @return The password expiration time, in ms.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.754 -0500", hash_original_method = "F850BD1F4A684FFED232083DC78EC214", hash_generated_method = "F7B766CEAE434CB2D25557BF953CA8C2")
    
public long getPasswordExpiration(ComponentName admin) {
        if (mService != null) {
            try {
                return mService.getPasswordExpiration(admin);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return 0;
    }

    /**
     * Retrieve the current password history length for all admins
     * or a particular one.
     * @param admin The name of the admin component to check, or null to aggregate
     * all admins.
     * @return The length of the password history
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.756 -0500", hash_original_method = "6A25C50AEC7E714C844A4ACF270DA0EA", hash_generated_method = "C9B53D524D3260BE8DAC4587A13D27D3")
    
public int getPasswordHistoryLength(ComponentName admin) {
        if (mService != null) {
            try {
                return mService.getPasswordHistoryLength(admin);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return 0;
    }

    /**
     * Return the maximum password length that the device supports for a
     * particular password quality.
     * @param quality The quality being interrogated.
     * @return Returns the maximum length that the user can enter.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.758 -0500", hash_original_method = "B720364465717C512AF715245037D814", hash_generated_method = "A603C0BCB8D2995657F7D0CDB142F54F")
    
public int getPasswordMaximumLength(int quality) {
        // Kind-of arbitrary.
        return 16;
    }

    /**
     * Determine whether the current password the user has set is sufficient
     * to meet the policy requirements (quality, minimum length) that have been
     * requested.
     *
     * <p>The calling device admin must have requested
     * {@link DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call
     * this method; if it has not, a security exception will be thrown.
     *
     * @return Returns true if the password meets the current requirements,
     * else false.
     */
    @DSComment("device administration")
    @DSSpec(DSCat.DEVICE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.760 -0500", hash_original_method = "2B762200302C4E580602F331CF81E49C", hash_generated_method = "A1E8004CC69CBC7393C5A90D581E66F1")
    
public boolean isActivePasswordSufficient() {
        if (mService != null) {
            try {
                return mService.isActivePasswordSufficient();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return false;
    }

    /**
     * Retrieve the number of times the user has failed at entering a
     * password since that last successful password entry.
     *
     * <p>The calling device admin must have requested
     * {@link DeviceAdminInfo#USES_POLICY_WATCH_LOGIN} to be able to call
     * this method; if it has not, a security exception will be thrown.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.762 -0500", hash_original_method = "EACD63B4064B49538F5A848510A5F41A", hash_generated_method = "734273F3588C3554C5D91D6700B000CD")
    
public int getCurrentFailedPasswordAttempts() {
        if (mService != null) {
            try {
                return mService.getCurrentFailedPasswordAttempts();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return -1;
    }

    /**
     * Setting this to a value greater than zero enables a built-in policy
     * that will perform a device wipe after too many incorrect
     * device-unlock passwords have been entered.  This built-in policy combines
     * watching for failed passwords and wiping the device, and requires
     * that you request both {@link DeviceAdminInfo#USES_POLICY_WATCH_LOGIN} and
     * {@link DeviceAdminInfo#USES_POLICY_WIPE_DATA}}.
     *
     * <p>To implement any other policy (e.g. wiping data for a particular
     * application only, erasing or revoking credentials, or reporting the
     * failure to a server), you should implement
     * {@link DeviceAdminReceiver#onPasswordFailed(Context, android.content.Intent)}
     * instead.  Do not use this API, because if the maximum count is reached,
     * the device will be wiped immediately, and your callback will not be invoked.
     *
     * @param admin Which {@link DeviceAdminReceiver} this request is associated with.
     * @param num The number of failed password attempts at which point the
     * device will wipe its data.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.764 -0500", hash_original_method = "386BE05045BF9977A6E5636AA6860E45", hash_generated_method = "7775E01C31B93481B29EE4669F2F1C05")
    
public void setMaximumFailedPasswordsForWipe(ComponentName admin, int num) {
        if (mService != null) {
            try {
                mService.setMaximumFailedPasswordsForWipe(admin, num);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * Retrieve the current maximum number of login attempts that are allowed
     * before the device wipes itself, for all admins
     * or a particular one.
     * @param admin The name of the admin component to check, or null to aggregate
     * all admins.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.767 -0500", hash_original_method = "2F7102BE4460977EBBF2224AD7A1647D", hash_generated_method = "8D68097D66C86010F25314B086CF6646")
    
public int getMaximumFailedPasswordsForWipe(ComponentName admin) {
        if (mService != null) {
            try {
                return mService.getMaximumFailedPasswordsForWipe(admin);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return 0;
    }

    /**
     * Force a new device unlock password (the password needed to access the
     * entire device, not for individual accounts) on the user.  This takes
     * effect immediately.
     * The given password must be sufficient for the
     * current password quality and length constraints as returned by
     * {@link #getPasswordQuality(ComponentName)} and
     * {@link #getPasswordMinimumLength(ComponentName)}; if it does not meet
     * these constraints, then it will be rejected and false returned.  Note
     * that the password may be a stronger quality (containing alphanumeric
     * characters when the requested quality is only numeric), in which case
     * the currently active quality will be increased to match.
     *
     * <p>The calling device admin must have requested
     * {@link DeviceAdminInfo#USES_POLICY_RESET_PASSWORD} to be able to call
     * this method; if it has not, a security exception will be thrown.
     *
     * @param password The new password for the user.
     * @param flags May be 0 or {@link #RESET_PASSWORD_REQUIRE_ENTRY}.
     * @return Returns true if the password was applied, or false if it is
     * not acceptable for the current constraints.
     */
    @DSComment("device administration")
    @DSSpec(DSCat.DEVICE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.771 -0500", hash_original_method = "17E6FC8B97A136DE019ACBDDB18AEC37", hash_generated_method = "B1C17E0534D90353D42B964C5FA185BC")
    
public boolean resetPassword(String password, int flags) {
        if (mService != null) {
            try {
                return mService.resetPassword(password, flags);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return false;
    }

    /**
     * Called by an application that is administering the device to set the
     * maximum time for user activity until the device will lock.  This limits
     * the length that the user can set.  It takes effect immediately.
     *
     * <p>The calling device admin must have requested
     * {@link DeviceAdminInfo#USES_POLICY_FORCE_LOCK} to be able to call
     * this method; if it has not, a security exception will be thrown.
     *
     * @param admin Which {@link DeviceAdminReceiver} this request is associated with.
     * @param timeMs The new desired maximum time to lock in milliseconds.
     * A value of 0 means there is no restriction.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.774 -0500", hash_original_method = "063F6779A334FCBA41EF649C9EC5AECE", hash_generated_method = "CEAAC32104FE0682CFE5F6C6BB3F4B31")
    
public void setMaximumTimeToLock(ComponentName admin, long timeMs) {
        if (mService != null) {
            try {
                mService.setMaximumTimeToLock(admin, timeMs);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * Retrieve the current maximum time to unlock for all admins
     * or a particular one.
     * @param admin The name of the admin component to check, or null to aggregate
     * all admins.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.776 -0500", hash_original_method = "236548EEF0B27F3ADB5D68074D378910", hash_generated_method = "B0D3A36DEAA47BFDC76EA4DEA2B2D379")
    
public long getMaximumTimeToLock(ComponentName admin) {
        if (mService != null) {
            try {
                return mService.getMaximumTimeToLock(admin);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return 0;
    }

    /**
     * Make the device lock immediately, as if the lock screen timeout has
     * expired at the point of this call.
     *
     * <p>The calling device admin must have requested
     * {@link DeviceAdminInfo#USES_POLICY_FORCE_LOCK} to be able to call
     * this method; if it has not, a security exception will be thrown.
     */
    @DSComment("device administration")
    @DSSpec(DSCat.DEVICE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.778 -0500", hash_original_method = "1AD41EB1582F6A4A56913D2EEA649B59", hash_generated_method = "38C960AFB962E4F4A911599A242E23C4")
    
public void lockNow() {
        if (mService != null) {
            try {
                mService.lockNow();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * Ask the user date be wiped.  This will cause the device to reboot,
     * erasing all user data while next booting up.  External storage such
     * as SD cards will not be erased.
     *
     * <p>The calling device admin must have requested
     * {@link DeviceAdminInfo#USES_POLICY_WIPE_DATA} to be able to call
     * this method; if it has not, a security exception will be thrown.
     *
     * @param flags Bit mask of additional options: currently must be 0.
     */
    @DSComment("device administration")
    @DSSpec(DSCat.DEVICE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.783 -0500", hash_original_method = "6CEDCC268C3E709685447E15BC08FD3A", hash_generated_method = "9311530DA7B5928250FF41F628CC297A")
    
public void wipeData(int flags) {
        if (mService != null) {
            try {
                mService.wipeData(flags);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * Called by an application that is administering the device to set the
     * global proxy and exclusion list.
     * <p>
     * The calling device admin must have requested
     * {@link DeviceAdminInfo#USES_POLICY_SETS_GLOBAL_PROXY} to be able to call
     * this method; if it has not, a security exception will be thrown.
     * Only the first device admin can set the proxy. If a second admin attempts
     * to set the proxy, the {@link ComponentName} of the admin originally setting the
     * proxy will be returned. If successful in setting the proxy, null will
     * be returned.
     * The method can be called repeatedly by the device admin alrady setting the
     * proxy to update the proxy and exclusion list.
     *
     * @param admin Which {@link DeviceAdminReceiver} this request is associated
     *            with.
     * @param proxySpec the global proxy desired. Must be an HTTP Proxy.
     *            Pass Proxy.NO_PROXY to reset the proxy.
     * @param exclusionList a list of domains to be excluded from the global proxy.
     * @return returns null if the proxy was successfully set, or a {@link ComponentName}
     *            of the device admin that sets thew proxy otherwise.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.786 -0500", hash_original_method = "53AB2A6BFBDB5E04C8F47C30215E30C2", hash_generated_method = "1A54A3744E388310941FC928A9C9529B")
    
public ComponentName setGlobalProxy(ComponentName admin, Proxy proxySpec,
            List<String> exclusionList ) {
        if (proxySpec == null) {
            throw new NullPointerException();
        }
        if (mService != null) {
            try {
                String hostSpec;
                String exclSpec;
                if (proxySpec.equals(Proxy.NO_PROXY)) {
                    hostSpec = null;
                    exclSpec = null;
                } else {
                    if (!proxySpec.type().equals(Proxy.Type.HTTP)) {
                        throw new IllegalArgumentException();
                    }
                    InetSocketAddress sa = (InetSocketAddress)proxySpec.address();
                    String hostName = sa.getHostName();
                    int port = sa.getPort();
                    StringBuilder hostBuilder = new StringBuilder();
                    hostSpec = hostBuilder.append(hostName)
                        .append(":").append(Integer.toString(port)).toString();
                    if (exclusionList == null) {
                        exclSpec = "";
                    } else {
                        StringBuilder listBuilder = new StringBuilder();
                        boolean firstDomain = true;
                        for (String exclDomain : exclusionList) {
                            if (!firstDomain) {
                                listBuilder = listBuilder.append(",");
                            } else {
                                firstDomain = false;
                            }
                            listBuilder = listBuilder.append(exclDomain.trim());
                        }
                        exclSpec = listBuilder.toString();
                    }
                    android.net.Proxy.validate(hostName, Integer.toString(port), exclSpec);
                }
                return mService.setGlobalProxy(admin, hostSpec, exclSpec);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return null;
    }

    /**
     * Returns the component name setting the global proxy.
     * @return ComponentName object of the device admin that set the global proxy, or
     *            null if no admin has set the proxy.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.788 -0500", hash_original_method = "46A87FF58FD44FDC19B7F90436F7E978", hash_generated_method = "E3475CCE3B89C08A65BDEFD91857C79A")
    
public ComponentName getGlobalProxyAdmin() {
        if (mService != null) {
            try {
                return mService.getGlobalProxyAdmin();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return null;
    }

    /**
     * Called by an application that is administering the device to
     * request that the storage system be encrypted.
     *
     * <p>When multiple device administrators attempt to control device
     * encryption, the most secure, supported setting will always be
     * used.  If any device administrator requests device encryption,
     * it will be enabled;  Conversely, if a device administrator
     * attempts to disable device encryption while another
     * device administrator has enabled it, the call to disable will
     * fail (most commonly returning {@link #ENCRYPTION_STATUS_ACTIVE}).
     *
     * <p>This policy controls encryption of the secure (application data) storage area.  Data
     * written to other storage areas may or may not be encrypted, and this policy does not require
     * or control the encryption of any other storage areas.
     * There is one exception:  If {@link android.os.Environment#isExternalStorageEmulated()} is
     * {@code true}, then the directory returned by
     * {@link android.os.Environment#getExternalStorageDirectory()} must be written to disk
     * within the encrypted storage area.
     *
     * <p>Important Note:  On some devices, it is possible to encrypt storage without requiring
     * the user to create a device PIN or Password.  In this case, the storage is encrypted, but
     * the encryption key may not be fully secured.  For maximum security, the administrator should
     * also require (and check for) a pattern, PIN, or password.
     *
     * @param admin Which {@link DeviceAdminReceiver} this request is associated with.
     * @param encrypt true to request encryption, false to release any previous request
     * @return the new request status (for all active admins) - will be one of
     * {@link #ENCRYPTION_STATUS_UNSUPPORTED}, {@link #ENCRYPTION_STATUS_INACTIVE}, or
     * {@link #ENCRYPTION_STATUS_ACTIVE}.  This is the value of the requests;  Use
     * {@link #getStorageEncryptionStatus()} to query the actual device state.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.802 -0500", hash_original_method = "17B73A4F954CB746271DADF07BB03245", hash_generated_method = "CB378D4C16DB2D05CDD662574A6FD08A")
    
public int setStorageEncryption(ComponentName admin, boolean encrypt) {
        if (mService != null) {
            try {
                return mService.setStorageEncryption(admin, encrypt);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return ENCRYPTION_STATUS_UNSUPPORTED;
    }

    /**
     * Called by an application that is administering the device to
     * determine the requested setting for secure storage.
     *
     * @param admin Which {@link DeviceAdminReceiver} this request is associated with.  If null,
     * this will return the requested encryption setting as an aggregate of all active
     * administrators.
     * @return true if the admin(s) are requesting encryption, false if not.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.805 -0500", hash_original_method = "9A4BD9BB365A613657C962C51C854645", hash_generated_method = "7D1FB93BDFD53D72AA0F1FB67290A1E5")
    
public boolean getStorageEncryption(ComponentName admin) {
        if (mService != null) {
            try {
                return mService.getStorageEncryption(admin);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return false;
    }

    /**
     * Called by an application that is administering the device to
     * determine the current encryption status of the device.
     *
     * Depending on the returned status code, the caller may proceed in different
     * ways.  If the result is {@link #ENCRYPTION_STATUS_UNSUPPORTED}, the
     * storage system does not support encryption.  If the
     * result is {@link #ENCRYPTION_STATUS_INACTIVE}, use {@link
     * #ACTION_START_ENCRYPTION} to begin the process of encrypting or decrypting the
     * storage.  If the result is {@link #ENCRYPTION_STATUS_ACTIVATING} or
     * {@link #ENCRYPTION_STATUS_ACTIVE}, no further action is required.
     *
     * @return current status of encryption.  The value will be one of
     * {@link #ENCRYPTION_STATUS_UNSUPPORTED}, {@link #ENCRYPTION_STATUS_INACTIVE},
     * {@link #ENCRYPTION_STATUS_ACTIVATING}, or{@link #ENCRYPTION_STATUS_ACTIVE}.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.808 -0500", hash_original_method = "6CEE42CBFD4B02D7CAAADEA83FCF3486", hash_generated_method = "9AF9993874F734D8E3EC27D86C8753E8")
    
public int getStorageEncryptionStatus() {
        if (mService != null) {
            try {
                return mService.getStorageEncryptionStatus();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return ENCRYPTION_STATUS_UNSUPPORTED;
    }

    /**
     * Called by an application that is administering the device to disable all cameras
     * on the device.  After setting this, no applications will be able to access any cameras
     * on the device.
     *
     * <p>The calling device admin must have requested
     * {@link DeviceAdminInfo#USES_POLICY_DISABLE_CAMERA} to be able to call
     * this method; if it has not, a security exception will be thrown.
     *
     * @param admin Which {@link DeviceAdminReceiver} this request is associated with.
     * @param disabled Whether or not the camera should be disabled.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.810 -0500", hash_original_method = "A5F298BC4842F29AB6F496D6FD4E07FD", hash_generated_method = "552B6290202768CA177AFF2BF574D8EB")
    
public void setCameraDisabled(ComponentName admin, boolean disabled) {
        if (mService != null) {
            try {
                mService.setCameraDisabled(admin, disabled);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * Determine whether or not the device's cameras have been disabled either by the current
     * admin, if specified, or all admins.
     * @param admin The name of the admin component to check, or null to check if any admins
     * have disabled the camera
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.812 -0500", hash_original_method = "8D92C22AE776D4D287A7DAE7D5749852", hash_generated_method = "0B32DCBC7D85201363DCD17D0283A104")
    
public boolean getCameraDisabled(ComponentName admin) {
        if (mService != null) {
            try {
                return mService.getCameraDisabled(admin);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
        return false;
    }

    /**
     * @hide
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.814 -0500", hash_original_method = "2E5C17164A00D32AA17FC960DDB2A30B", hash_generated_method = "E5F5AAA88F8BE1EE6ADEA4E3148EB40D")
    
public void setActiveAdmin(ComponentName policyReceiver, boolean refreshing) {
        if (mService != null) {
            try {
                mService.setActiveAdmin(policyReceiver, refreshing);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * Returns the DeviceAdminInfo as defined by the administrator's package info & meta-data
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.817 -0500", hash_original_method = "6B96BC98EC991BA4501EAC59D3A81719", hash_generated_method = "38D02163D17B96BBBAB39FCE2E56FEA2")
    
public DeviceAdminInfo getAdminInfo(ComponentName cn) {
        ActivityInfo ai;
        try {
            ai = mContext.getPackageManager().getReceiverInfo(cn,
                    PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            Log.w(TAG, "Unable to retrieve device policy " + cn, e);
            return null;
        }

        ResolveInfo ri = new ResolveInfo();
        ri.activityInfo = ai;

        try {
            return new DeviceAdminInfo(mContext, ri);
        } catch (XmlPullParserException e) {
            Log.w(TAG, "Unable to parse device policy " + cn, e);
            return null;
        } catch (IOException e) {
            Log.w(TAG, "Unable to parse device policy " + cn, e);
            return null;
        }
    }

    /**
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.819 -0500", hash_original_method = "B78826B0ABC7DA178D8BC699F76B9B76", hash_generated_method = "1241EBD154ABFF3242B6A44433F7AF8C")
    
public void getRemoveWarning(ComponentName admin, RemoteCallback result) {
        if (mService != null) {
            try {
                mService.getRemoveWarning(admin, result);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.822 -0500", hash_original_method = "6E15637B027827B7A463543C03AC9E11", hash_generated_method = "C4109B4074AC740F9F4460C19352F47C")
    
public void setActivePasswordState(int quality, int length, int letters, int uppercase,
            int lowercase, int numbers, int symbols, int nonletter) {
        if (mService != null) {
            try {
                mService.setActivePasswordState(quality, length, letters, uppercase, lowercase,
                        numbers, symbols, nonletter);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.824 -0500", hash_original_method = "7A06EB783FBF60A73CE8C82F7F508BC8", hash_generated_method = "D76CBB25191C33EE19CA7E31E984F48C")
    
public void reportFailedPasswordAttempt() {
        if (mService != null) {
            try {
                mService.reportFailedPasswordAttempt();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:52.826 -0500", hash_original_method = "715E68F4DA8529CFE0A9E396D6B5FAA4", hash_generated_method = "678D5FB26021E8B547917569322B6817")
    
public void reportSuccessfulPasswordAttempt() {
        if (mService != null) {
            try {
                mService.reportSuccessfulPasswordAttempt();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed talking with device policy service", e);
            }
        }
    }
}

