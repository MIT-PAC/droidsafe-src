package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

public class ShareCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.893 -0400", hash_original_method = "0A13BB4106553207210A279F3A99B9BB", hash_generated_method = "0A13BB4106553207210A279F3A99B9BB")
    public ShareCompat ()
    {
        //Synthesized constructor
    }


        public static String getCallingPackage(Activity calledActivity) {
        String result = calledActivity.getCallingPackage();
        if (result == null) {
            result = calledActivity.getIntent().getStringExtra(EXTRA_CALLING_PACKAGE);
        }
        return result;
    }

    
        public static ComponentName getCallingActivity(Activity calledActivity) {
        ComponentName result = calledActivity.getCallingActivity();
        if (result == null) {
            result = calledActivity.getIntent().getParcelableExtra(EXTRA_CALLING_ACTIVITY);
        }
        return result;
    }

    
        public static void configureMenuItem(MenuItem item, IntentBuilder shareIntent) {
        IMPL.configureMenuItem(item, shareIntent);
    }

    
        public static void configureMenuItem(Menu menu, int menuItemId, IntentBuilder shareIntent) {
        MenuItem item = menu.findItem(menuItemId);
        if (item == null) {
            throw new IllegalArgumentException("Could not find menu item with id " + menuItemId +
                    " in the supplied menu");
        }
        configureMenuItem(item, shareIntent);
    }

    
    static class ShareCompatImplBase implements ShareCompatImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.912 -0400", hash_original_method = "8064BAE7F7BB15EFDB6F22BEE7DAC14F", hash_generated_method = "8064BAE7F7BB15EFDB6F22BEE7DAC14F")
        public ShareCompatImplBase ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.916 -0400", hash_original_method = "C3E2EAA5FDB39D2940E924EA83A92CD9", hash_generated_method = "1DE1A2BE64F4826527D093E4C4576324")
        public void configureMenuItem(MenuItem item, IntentBuilder shareIntent) {
            item.setIntent(shareIntent.createChooserIntent());
            addTaint(item.getTaint());
            addTaint(shareIntent.getTaint());
            // ---------- Original Method ----------
            //item.setIntent(shareIntent.createChooserIntent());
        }

        
    }


    
    static class ShareCompatImplICS implements ShareCompatImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.916 -0400", hash_original_method = "2CBAE6C93111BB9854C827ED9FA39E30", hash_generated_method = "2CBAE6C93111BB9854C827ED9FA39E30")
        public ShareCompatImplICS ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.917 -0400", hash_original_method = "B1A2841A2931DAEF8203340229B6A2CE", hash_generated_method = "6A25EC6F95086DB476F168FB838751E9")
        public void configureMenuItem(MenuItem item, IntentBuilder shareIntent) {
            ShareCompatICS.configureMenuItem(item, shareIntent.getActivity(),
                    shareIntent.getIntent());
            addTaint(item.getTaint());
            addTaint(shareIntent.getTaint());
            // ---------- Original Method ----------
            //ShareCompatICS.configureMenuItem(item, shareIntent.getActivity(),
                    //shareIntent.getIntent());
        }

        
    }


    
    public static class IntentBuilder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.929 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "B0D69375984D6EE7DC93AC12DB4DFC55")

        private Activity mActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.930 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.930 -0400", hash_original_field = "E63B8F7781E4F1931DDD1A0AEA865EB7", hash_generated_field = "C9A7B3C8A894CB38E3F5AAE7F09F414B")

        private CharSequence mChooserTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.930 -0400", hash_original_field = "1807DAA89FC786F450FBCBF6EFE208C2", hash_generated_field = "21ED3C508F73EC28DFF7BE66BD15E9A5")

        private ArrayList<String> mToAddresses;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.930 -0400", hash_original_field = "663A0F10C2B6F99EAB90D4BC2B1C307A", hash_generated_field = "1FA039FD28E6545C6FC9E4ED5C735249")

        private ArrayList<String> mCcAddresses;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.930 -0400", hash_original_field = "5E4E2ED761B0E4E31C1779D389179C79", hash_generated_field = "F7527C0ABC323B033A133BADC1BA7ACD")

        private ArrayList<String> mBccAddresses;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.930 -0400", hash_original_field = "A1ADF33EC233D9220AFA3F7B9CA06090", hash_generated_field = "E38B530386D6624B9CC752A26937D70B")

        private ArrayList<Uri> mStreams;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.956 -0400", hash_original_method = "DF152584278C8F8C835FFB6AA3E923E0", hash_generated_method = "7CFDE13177AD62E7606E7FE70D0F895E")
        private  IntentBuilder(Activity launchingActivity) {
            mActivity = launchingActivity;
            mIntent = new Intent().setAction(Intent.ACTION_SEND);
            mIntent.putExtra(EXTRA_CALLING_PACKAGE, launchingActivity.getPackageName());
            mIntent.putExtra(EXTRA_CALLING_ACTIVITY, launchingActivity.getComponentName());
            mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
            // ---------- Original Method ----------
            //mActivity = launchingActivity;
            //mIntent = new Intent().setAction(Intent.ACTION_SEND);
            //mIntent.putExtra(EXTRA_CALLING_PACKAGE, launchingActivity.getPackageName());
            //mIntent.putExtra(EXTRA_CALLING_ACTIVITY, launchingActivity.getComponentName());
            //mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        }

        
                public static IntentBuilder from(Activity launchingActivity) {
            return new IntentBuilder(launchingActivity);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.959 -0400", hash_original_method = "CC05494BB54ABC476F91DA83FFC83A1D", hash_generated_method = "02CE84273398644DC0E33A5D4BA0EAE0")
        public Intent getIntent() {
            Intent varB4EAC82CA7396A68D541C85D26508E83_867904710 = null; //Variable for return #1
            {
                combineArrayExtra(Intent.EXTRA_EMAIL, mToAddresses);
                mToAddresses = null;
            } //End block
            {
                combineArrayExtra(Intent.EXTRA_CC, mCcAddresses);
                mCcAddresses = null;
            } //End block
            {
                combineArrayExtra(Intent.EXTRA_BCC, mBccAddresses);
                mBccAddresses = null;
            } //End block
            boolean needsSendMultiple;
            needsSendMultiple = mStreams != null && mStreams.size() > 1;
            boolean isSendMultiple;
            isSendMultiple = mIntent.getAction().equals(Intent.ACTION_SEND_MULTIPLE);
            {
                mIntent.setAction(Intent.ACTION_SEND);
                {
                    boolean varF139EBEDE45D4A2E2BBF88D451A25947_1229306458 = (mStreams != null && !mStreams.isEmpty());
                    {
                        mIntent.putExtra(Intent.EXTRA_STREAM, mStreams.get(0));
                    } //End block
                    {
                        mIntent.removeExtra(Intent.EXTRA_STREAM);
                    } //End block
                } //End collapsed parenthetic
                mStreams = null;
            } //End block
            {
                mIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
                {
                    boolean varF139EBEDE45D4A2E2BBF88D451A25947_2013913144 = (mStreams != null && !mStreams.isEmpty());
                    {
                        mIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, mStreams);
                    } //End block
                    {
                        mIntent.removeExtra(Intent.EXTRA_STREAM);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_867904710 = mIntent;
            varB4EAC82CA7396A68D541C85D26508E83_867904710.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_867904710;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.961 -0400", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "55B8990D91F3DAD89AC27EAFFCD4790F")
         Activity getActivity() {
            Activity varB4EAC82CA7396A68D541C85D26508E83_1625199129 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1625199129 = mActivity;
            varB4EAC82CA7396A68D541C85D26508E83_1625199129.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1625199129;
            // ---------- Original Method ----------
            //return mActivity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.962 -0400", hash_original_method = "026504B88DB15C0C017BBB730BD6CA05", hash_generated_method = "CA509B588C81BEF10ECD709CA72A49CC")
        private void combineArrayExtra(String extra, ArrayList<String> add) {
            String[] currentAddresses;
            currentAddresses = mIntent.getStringArrayExtra(extra);
            int currentLength;
            currentLength = currentAddresses.length;
            currentLength = 0;
            String[] finalAddresses;
            finalAddresses = new String[currentLength + add.size()];
            add.toArray(finalAddresses);
            {
                System.arraycopy(currentAddresses, 0, finalAddresses, add.size(), currentLength);
            } //End block
            mIntent.putExtra(extra, finalAddresses);
            addTaint(extra.getTaint());
            addTaint(add.getTaint());
            // ---------- Original Method ----------
            //String[] currentAddresses = mIntent.getStringArrayExtra(extra);
            //int currentLength = currentAddresses != null ? currentAddresses.length : 0;
            //String[] finalAddresses = new String[currentLength + add.size()];
            //add.toArray(finalAddresses);
            //if (currentAddresses != null) {
                //System.arraycopy(currentAddresses, 0, finalAddresses, add.size(), currentLength);
            //}
            //mIntent.putExtra(extra, finalAddresses);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.963 -0400", hash_original_method = "BD64BC57794A356441B2316C07AE8DAC", hash_generated_method = "4AB09B90763DBB49CA43AFCD2511E0AD")
        private void combineArrayExtra(String extra, String[] add) {
            Intent intent;
            intent = getIntent();
            String[] old;
            old = intent.getStringArrayExtra(extra);
            int oldLength;
            oldLength = old.length;
            oldLength = 0;
            String[] result;
            result = new String[oldLength + add.length];
            System.arraycopy(old, 0, result, 0, oldLength);
            System.arraycopy(add, 0, result, oldLength, add.length);
            intent.putExtra(extra, result);
            addTaint(extra.getTaint());
            addTaint(add[0].getTaint());
            // ---------- Original Method ----------
            //Intent intent = getIntent();
            //String[] old = intent.getStringArrayExtra(extra);
            //int oldLength = old != null ? old.length : 0;
            //String[] result = new String[oldLength + add.length];
            //if (old != null) System.arraycopy(old, 0, result, 0, oldLength);
            //System.arraycopy(add, 0, result, oldLength, add.length);
            //intent.putExtra(extra, result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.963 -0400", hash_original_method = "4A271FB631FE734F0A005F0662E72303", hash_generated_method = "E2EF683BBB7BF6FBA0B2F4E9415EF312")
        public Intent createChooserIntent() {
            Intent varB4EAC82CA7396A68D541C85D26508E83_513627225 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_513627225 = Intent.createChooser(getIntent(), mChooserTitle);
            varB4EAC82CA7396A68D541C85D26508E83_513627225.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_513627225;
            // ---------- Original Method ----------
            //return Intent.createChooser(getIntent(), mChooserTitle);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.974 -0400", hash_original_method = "EF93D4C25B6364A5474AC09756C110F4", hash_generated_method = "250CBDFEAEB807D2F8C8C9A9BA870E4A")
        public void startChooser() {
            mActivity.startActivity(createChooserIntent());
            // ---------- Original Method ----------
            //mActivity.startActivity(createChooserIntent());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.976 -0400", hash_original_method = "06E956E502A80DA9473ED82266A5A9DE", hash_generated_method = "D556CDDBCDCC6368B4D5823216AAA43C")
        public IntentBuilder setChooserTitle(CharSequence title) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1300794302 = null; //Variable for return #1
            mChooserTitle = title;
            varB4EAC82CA7396A68D541C85D26508E83_1300794302 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1300794302.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1300794302;
            // ---------- Original Method ----------
            //mChooserTitle = title;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.986 -0400", hash_original_method = "03DF458E6ED02C68488BE88E21862CDF", hash_generated_method = "E38F74A7A9766A5345A4A1CC9C365A01")
        public IntentBuilder setChooserTitle(int resId) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_777464648 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_777464648 = setChooserTitle(mActivity.getText(resId));
            addTaint(resId);
            varB4EAC82CA7396A68D541C85D26508E83_777464648.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_777464648;
            // ---------- Original Method ----------
            //return setChooserTitle(mActivity.getText(resId));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.988 -0400", hash_original_method = "FC54C1994B818C86E4DBEFD863458812", hash_generated_method = "E8F0ABC125A11026E7D33A3C0AFDDF81")
        public IntentBuilder setType(String mimeType) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1389111392 = null; //Variable for return #1
            mIntent.setType(mimeType);
            varB4EAC82CA7396A68D541C85D26508E83_1389111392 = this;
            addTaint(mimeType.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1389111392.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1389111392;
            // ---------- Original Method ----------
            //mIntent.setType(mimeType);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.989 -0400", hash_original_method = "C395D7124DB9BC11CF728AC9FB5C05F1", hash_generated_method = "ADE5E3B1515EC19DDACF7E06DBBB4C04")
        public IntentBuilder setText(CharSequence text) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_874954612 = null; //Variable for return #1
            mIntent.putExtra(Intent.EXTRA_TEXT, text);
            varB4EAC82CA7396A68D541C85D26508E83_874954612 = this;
            addTaint(text.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_874954612.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_874954612;
            // ---------- Original Method ----------
            //mIntent.putExtra(Intent.EXTRA_TEXT, text);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.007 -0400", hash_original_method = "0CC67542367F5DDA6287793533CA2797", hash_generated_method = "05B6907702F81296F04D2621A268FC1A")
        public IntentBuilder setStream(Uri streamUri) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1270900774 = null; //Variable for return #1
            {
                boolean var3141264D9C3F68A9609EF9BEF3806130_1367941732 = (!mIntent.getAction().equals(Intent.ACTION_SEND));
                {
                    mIntent.setAction(Intent.ACTION_SEND);
                } //End block
            } //End collapsed parenthetic
            mStreams = null;
            mIntent.putExtra(Intent.EXTRA_STREAM, streamUri);
            varB4EAC82CA7396A68D541C85D26508E83_1270900774 = this;
            addTaint(streamUri.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1270900774.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1270900774;
            // ---------- Original Method ----------
            //if (!mIntent.getAction().equals(Intent.ACTION_SEND)) {
                //mIntent.setAction(Intent.ACTION_SEND);
            //}
            //mStreams = null;
            //mIntent.putExtra(Intent.EXTRA_STREAM, streamUri);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.010 -0400", hash_original_method = "5DA0D5B75B65E8A970BBB6A6FE8B4CFF", hash_generated_method = "813B200BACEDCF6794AE558072B0046D")
        public IntentBuilder addStream(Uri streamUri) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_796373427 = null; //Variable for return #1
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1474281650 = null; //Variable for return #2
            Uri currentStream;
            currentStream = mIntent.getParcelableExtra(Intent.EXTRA_STREAM);
            {
                varB4EAC82CA7396A68D541C85D26508E83_796373427 = setStream(streamUri);
            } //End block
            {
                mStreams = new ArrayList<Uri>();
            } //End block
            {
                mIntent.removeExtra(Intent.EXTRA_STREAM);
                mStreams.add(currentStream);
            } //End block
            mStreams.add(streamUri);
            varB4EAC82CA7396A68D541C85D26508E83_1474281650 = this;
            addTaint(streamUri.getTaint());
            IntentBuilder varA7E53CE21691AB073D9660D615818899_1405286605; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1405286605 = varB4EAC82CA7396A68D541C85D26508E83_796373427;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1405286605 = varB4EAC82CA7396A68D541C85D26508E83_1474281650;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1405286605.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1405286605;
            // ---------- Original Method ----------
            //Uri currentStream = mIntent.getParcelableExtra(Intent.EXTRA_STREAM);
            //if (currentStream == null) {
                //return setStream(streamUri);
            //}
            //if (mStreams == null) {
                //mStreams = new ArrayList<Uri>();
            //}
            //if (currentStream != null) {
                //mIntent.removeExtra(Intent.EXTRA_STREAM);
                //mStreams.add(currentStream);
            //}
            //mStreams.add(streamUri);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.011 -0400", hash_original_method = "FD4DB555E0D921CCC6ACF7E2C37BCAC4", hash_generated_method = "53DFC1BC3AB80122F761D97677EF92F1")
        public IntentBuilder setEmailTo(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_486545903 = null; //Variable for return #1
            {
                mToAddresses = null;
            } //End block
            mIntent.putExtra(Intent.EXTRA_EMAIL, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_486545903 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_486545903.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_486545903;
            // ---------- Original Method ----------
            //if (mToAddresses != null) {
                //mToAddresses = null;
            //}
            //mIntent.putExtra(Intent.EXTRA_EMAIL, addresses);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.022 -0400", hash_original_method = "E206D9565B5E9D24AEF2AF92EC056646", hash_generated_method = "3CB3E856776ACA99DC389541CFF0E03B")
        public IntentBuilder addEmailTo(String address) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1915170262 = null; //Variable for return #1
            {
                mToAddresses = new ArrayList<String>();
            } //End block
            mToAddresses.add(address);
            varB4EAC82CA7396A68D541C85D26508E83_1915170262 = this;
            addTaint(address.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1915170262.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1915170262;
            // ---------- Original Method ----------
            //if (mToAddresses == null) {
                //mToAddresses = new ArrayList<String>();
            //}
            //mToAddresses.add(address);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.035 -0400", hash_original_method = "7721A9C42CBA5A2892BFCB8DDD6F7399", hash_generated_method = "FD08489E85232A9DBFE26D9F4570A009")
        public IntentBuilder addEmailTo(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_117663483 = null; //Variable for return #1
            combineArrayExtra(Intent.EXTRA_EMAIL, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_117663483 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_117663483.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_117663483;
            // ---------- Original Method ----------
            //combineArrayExtra(Intent.EXTRA_EMAIL, addresses);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.037 -0400", hash_original_method = "BE74A7950B78C22222797B86EEED6F25", hash_generated_method = "C7BEE89F09E4B8E2D4E3AB7156310692")
        public IntentBuilder setEmailCc(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1114688877 = null; //Variable for return #1
            mIntent.putExtra(Intent.EXTRA_CC, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_1114688877 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1114688877.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1114688877;
            // ---------- Original Method ----------
            //mIntent.putExtra(Intent.EXTRA_CC, addresses);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.038 -0400", hash_original_method = "2EF08D607B211A7E5DCF80D337C959CD", hash_generated_method = "10FB78DC02A5F1D6434B0ECC4290E6D8")
        public IntentBuilder addEmailCc(String address) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1773186795 = null; //Variable for return #1
            {
                mCcAddresses = new ArrayList<String>();
            } //End block
            mCcAddresses.add(address);
            varB4EAC82CA7396A68D541C85D26508E83_1773186795 = this;
            addTaint(address.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1773186795.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1773186795;
            // ---------- Original Method ----------
            //if (mCcAddresses == null) {
                //mCcAddresses = new ArrayList<String>();
            //}
            //mCcAddresses.add(address);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.039 -0400", hash_original_method = "18B1AA262CDF43BA34C5BCC06BA146A5", hash_generated_method = "95F27889F3DA92514E0F03ED0ECDA455")
        public IntentBuilder addEmailCc(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_2089956301 = null; //Variable for return #1
            combineArrayExtra(Intent.EXTRA_CC, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_2089956301 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2089956301.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2089956301;
            // ---------- Original Method ----------
            //combineArrayExtra(Intent.EXTRA_CC, addresses);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.040 -0400", hash_original_method = "965E5218675D98D1034B8CE91C4C024C", hash_generated_method = "DD9EDA84111771E881E9AF12EAF69B7B")
        public IntentBuilder setEmailBcc(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_929950186 = null; //Variable for return #1
            mIntent.putExtra(Intent.EXTRA_BCC, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_929950186 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_929950186.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_929950186;
            // ---------- Original Method ----------
            //mIntent.putExtra(Intent.EXTRA_BCC, addresses);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.055 -0400", hash_original_method = "68C0EF4D86815A482951AF12B5153611", hash_generated_method = "0D69F76EC1C0DE5EAC557766374EB60A")
        public IntentBuilder addEmailBcc(String address) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_331941584 = null; //Variable for return #1
            {
                mBccAddresses = new ArrayList<String>();
            } //End block
            mBccAddresses.add(address);
            varB4EAC82CA7396A68D541C85D26508E83_331941584 = this;
            addTaint(address.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_331941584.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_331941584;
            // ---------- Original Method ----------
            //if (mBccAddresses == null) {
                //mBccAddresses = new ArrayList<String>();
            //}
            //mBccAddresses.add(address);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.059 -0400", hash_original_method = "A108079E5E05347E55233C38CDE39CC2", hash_generated_method = "F9332A35DD4EE4505AAA0E5900AEF554")
        public IntentBuilder addEmailBcc(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1834151372 = null; //Variable for return #1
            combineArrayExtra(Intent.EXTRA_BCC, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_1834151372 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1834151372.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1834151372;
            // ---------- Original Method ----------
            //combineArrayExtra(Intent.EXTRA_BCC, addresses);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.060 -0400", hash_original_method = "3E6F6D2B7406A417F246425C88E21422", hash_generated_method = "1D25F6E9660F873BCC84BC5A8C00FD84")
        public IntentBuilder setSubject(String subject) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1471060990 = null; //Variable for return #1
            mIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
            varB4EAC82CA7396A68D541C85D26508E83_1471060990 = this;
            addTaint(subject.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1471060990.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1471060990;
            // ---------- Original Method ----------
            //mIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
            //return this;
        }

        
    }


    
    public static class IntentReader {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.060 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "B0D69375984D6EE7DC93AC12DB4DFC55")

        private Activity mActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.060 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.060 -0400", hash_original_field = "69D772FE63E594767F3D526E4183666C", hash_generated_field = "E9DB1E160A758DD2D7A97AC8EAD7032B")

        private String mCallingPackage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.061 -0400", hash_original_field = "579F6F4641F6E6419FFF278DEBF8E9BA", hash_generated_field = "9F2300B66972EC6EFB2EFE241B7A0E66")

        private ComponentName mCallingActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.061 -0400", hash_original_field = "A1ADF33EC233D9220AFA3F7B9CA06090", hash_generated_field = "E38B530386D6624B9CC752A26937D70B")

        private ArrayList<Uri> mStreams;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.061 -0400", hash_original_method = "33DC5300860410C275910F5653E8BC84", hash_generated_method = "FB5749427BB382C46398D39E46300D1A")
        private  IntentReader(Activity activity) {
            mActivity = activity;
            mIntent = activity.getIntent();
            mCallingPackage = ShareCompat.getCallingPackage(activity);
            mCallingActivity = ShareCompat.getCallingActivity(activity);
            // ---------- Original Method ----------
            //mActivity = activity;
            //mIntent = activity.getIntent();
            //mCallingPackage = ShareCompat.getCallingPackage(activity);
            //mCallingActivity = ShareCompat.getCallingActivity(activity);
        }

        
                public static IntentReader from(Activity activity) {
            return new IntentReader(activity);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.077 -0400", hash_original_method = "A707037246F5733C08453D3B682DF768", hash_generated_method = "A8DBF3279CA479D03B6E962F7A8C867F")
        public boolean isShareIntent() {
            String action;
            action = mIntent.getAction();
            boolean var6199C70CF17ED50D954A70C090A4DC62_743634431 = (action.equals(Intent.ACTION_SEND) || action.equals(Intent.ACTION_SEND_MULTIPLE));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1953448506 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1953448506;
            // ---------- Original Method ----------
            //final String action = mIntent.getAction();
            //return action.equals(Intent.ACTION_SEND) || action.equals(Intent.ACTION_SEND_MULTIPLE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.078 -0400", hash_original_method = "BFA6AA7528AA5BB107B3B7EA24E49B64", hash_generated_method = "A0BFBE3D693AC95DCB7DBDD9DB0C210A")
        public boolean isSingleShare() {
            boolean var163FBD7B7485DF6491201565A1589C76_976607082 = (mIntent.getAction().equals(Intent.ACTION_SEND));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1448435062 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1448435062;
            // ---------- Original Method ----------
            //return mIntent.getAction().equals(Intent.ACTION_SEND);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.078 -0400", hash_original_method = "61DADC6D6F65F3016BDEF2AAD1D3A3F0", hash_generated_method = "AF9C2B9234916FBC7BEA9E059973B38F")
        public boolean isMultipleShare() {
            boolean var8AA762653092B3F38E8AE23B1AB05044_198538922 = (mIntent.getAction().equals(Intent.ACTION_SEND_MULTIPLE));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1936464565 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1936464565;
            // ---------- Original Method ----------
            //return mIntent.getAction().equals(Intent.ACTION_SEND_MULTIPLE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.079 -0400", hash_original_method = "D2D116B363ACAF23E5ABAEA8317A2D07", hash_generated_method = "8C97930D7380D29ABBC60B023D6B7E10")
        public String getType() {
            String varB4EAC82CA7396A68D541C85D26508E83_1517513354 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1517513354 = mIntent.getType();
            varB4EAC82CA7396A68D541C85D26508E83_1517513354.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1517513354;
            // ---------- Original Method ----------
            //return mIntent.getType();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.095 -0400", hash_original_method = "001799CDC7AD568A5D9791D68F82B19E", hash_generated_method = "7ECCC5675C38E006DFAA27D521CDC2D3")
        public CharSequence getText() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1844178380 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1844178380 = mIntent.getCharSequenceExtra(Intent.EXTRA_TEXT);
            varB4EAC82CA7396A68D541C85D26508E83_1844178380.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1844178380;
            // ---------- Original Method ----------
            //return mIntent.getCharSequenceExtra(Intent.EXTRA_TEXT);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.096 -0400", hash_original_method = "6766C6C36607D95201A80937E1C93C5B", hash_generated_method = "5E3B978719298623013022969E13AF48")
        public Uri getStream() {
            Uri varB4EAC82CA7396A68D541C85D26508E83_705474327 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_705474327 = mIntent.getParcelableExtra(Intent.EXTRA_STREAM);
            varB4EAC82CA7396A68D541C85D26508E83_705474327.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_705474327;
            // ---------- Original Method ----------
            //return mIntent.getParcelableExtra(Intent.EXTRA_STREAM);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.108 -0400", hash_original_method = "CA16C800A8BACDD493D26B5DCB8F6704", hash_generated_method = "EED194C5235DF77B2C5E4FC5D8BA3011")
        public Uri getStream(int index) {
            Uri varB4EAC82CA7396A68D541C85D26508E83_1215677443 = null; //Variable for return #1
            Uri varB4EAC82CA7396A68D541C85D26508E83_1085636785 = null; //Variable for return #2
            {
                boolean varAA8C0850796E27ECE01A9205830925C9_745887412 = (mStreams == null && isMultipleShare());
                {
                    mStreams = mIntent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
                } //End block
            } //End collapsed parenthetic
            {
                varB4EAC82CA7396A68D541C85D26508E83_1215677443 = mStreams.get(index);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1085636785 = mIntent.getParcelableExtra(Intent.EXTRA_STREAM);
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() +
                    " index requested: " + index);
            addTaint(index);
            Uri varA7E53CE21691AB073D9660D615818899_1148145480; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1148145480 = varB4EAC82CA7396A68D541C85D26508E83_1215677443;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1148145480 = varB4EAC82CA7396A68D541C85D26508E83_1085636785;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1148145480.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1148145480;
            // ---------- Original Method ----------
            //if (mStreams == null && isMultipleShare()) {
                //mStreams = mIntent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
            //}
            //if (mStreams != null) {
                //return mStreams.get(index);
            //}
            //if (index == 0) {
                //return mIntent.getParcelableExtra(Intent.EXTRA_STREAM);
            //}
            //throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() +
                    //" index requested: " + index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.109 -0400", hash_original_method = "BC61684682118C8B50538A4E9628C32B", hash_generated_method = "D183B0D4B645F2C473DAA5E328D830D4")
        public int getStreamCount() {
            {
                boolean varAA8C0850796E27ECE01A9205830925C9_612032425 = (mStreams == null && isMultipleShare());
                {
                    mStreams = mIntent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
                } //End block
            } //End collapsed parenthetic
            {
                int varD4374328095A9182E73BED2B4E112D5C_1397149149 = (mStreams.size());
            } //End block
            {
                boolean var19EBAAC96567DABF4F39A6F661817952_1505353354 = (mIntent.hasExtra(Intent.EXTRA_STREAM));
            } //End flattened ternary
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2013009500 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2013009500;
            // ---------- Original Method ----------
            //if (mStreams == null && isMultipleShare()) {
                //mStreams = mIntent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
            //}
            //if (mStreams != null) {
                //return mStreams.size();
            //}
            //return mIntent.hasExtra(Intent.EXTRA_STREAM) ? 1 : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.114 -0400", hash_original_method = "D1879246F5FB4411F3E91A8AEB3C384C", hash_generated_method = "E734EE8B466F22495A138704463C616A")
        public String[] getEmailTo() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_2028073268 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2028073268 = mIntent.getStringArrayExtra(Intent.EXTRA_EMAIL);
            varB4EAC82CA7396A68D541C85D26508E83_2028073268.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2028073268;
            // ---------- Original Method ----------
            //return mIntent.getStringArrayExtra(Intent.EXTRA_EMAIL);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.119 -0400", hash_original_method = "F2F2C05F2171316000FF1516A5D8CD3A", hash_generated_method = "DBC0821FFC0B1826A64C668B9AE46D10")
        public String[] getEmailCc() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_1563027070 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1563027070 = mIntent.getStringArrayExtra(Intent.EXTRA_CC);
            varB4EAC82CA7396A68D541C85D26508E83_1563027070.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1563027070;
            // ---------- Original Method ----------
            //return mIntent.getStringArrayExtra(Intent.EXTRA_CC);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.140 -0400", hash_original_method = "8B48BB50B06FCBCC280D77A42BA7B009", hash_generated_method = "F11C3E4CAE3D1F55AD3358A5B600BA4E")
        public String[] getEmailBcc() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_505176968 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_505176968 = mIntent.getStringArrayExtra(Intent.EXTRA_BCC);
            varB4EAC82CA7396A68D541C85D26508E83_505176968.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_505176968;
            // ---------- Original Method ----------
            //return mIntent.getStringArrayExtra(Intent.EXTRA_BCC);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.140 -0400", hash_original_method = "1E0DCEAE4F7F7EF81C98D4CC969955D0", hash_generated_method = "24642DEB92C0C9FE10FBA602C1308019")
        public String getSubject() {
            String varB4EAC82CA7396A68D541C85D26508E83_564837405 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_564837405 = mIntent.getStringExtra(Intent.EXTRA_SUBJECT);
            varB4EAC82CA7396A68D541C85D26508E83_564837405.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_564837405;
            // ---------- Original Method ----------
            //return mIntent.getStringExtra(Intent.EXTRA_SUBJECT);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.141 -0400", hash_original_method = "599A2909147C5ABF7649B275042032E0", hash_generated_method = "F86780A464D9D382CC1349BCAB7D0691")
        public String getCallingPackage() {
            String varB4EAC82CA7396A68D541C85D26508E83_564609468 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_564609468 = mCallingPackage;
            varB4EAC82CA7396A68D541C85D26508E83_564609468.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_564609468;
            // ---------- Original Method ----------
            //return mCallingPackage;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.142 -0400", hash_original_method = "7754B7141829C06037743B2AEFCB8100", hash_generated_method = "0F3901DD0CEDF0001302E34E86AAC155")
        public ComponentName getCallingActivity() {
            ComponentName varB4EAC82CA7396A68D541C85D26508E83_843577622 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_843577622 = mCallingActivity;
            varB4EAC82CA7396A68D541C85D26508E83_843577622.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_843577622;
            // ---------- Original Method ----------
            //return mCallingActivity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.143 -0400", hash_original_method = "DF0726DEBD67610C86B101B05D0C636E", hash_generated_method = "44EB356D9439AC00BF3215C8C2F782AB")
        public Drawable getCallingActivityIcon() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1023011046 = null; //Variable for return #1
            Drawable varB4EAC82CA7396A68D541C85D26508E83_159076774 = null; //Variable for return #2
            Drawable varB4EAC82CA7396A68D541C85D26508E83_558248795 = null; //Variable for return #3
            varB4EAC82CA7396A68D541C85D26508E83_1023011046 = null;
            PackageManager pm;
            pm = mActivity.getPackageManager();
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_159076774 = pm.getActivityIcon(mCallingActivity);
            } //End block
            catch (NameNotFoundException e)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_558248795 = null;
            Drawable varA7E53CE21691AB073D9660D615818899_528815647; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_528815647 = varB4EAC82CA7396A68D541C85D26508E83_1023011046;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_528815647 = varB4EAC82CA7396A68D541C85D26508E83_159076774;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_528815647 = varB4EAC82CA7396A68D541C85D26508E83_558248795;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_528815647.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_528815647;
            // ---------- Original Method ----------
            //if (mCallingActivity == null) return null;
            //PackageManager pm = mActivity.getPackageManager();
            //try {
                //return pm.getActivityIcon(mCallingActivity);
            //} catch (NameNotFoundException e) {
                //Log.e(TAG, "Could not retrieve icon for calling activity", e);
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.161 -0400", hash_original_method = "CF72ECE57DC07F413BA6AAECB91EABC0", hash_generated_method = "4A8D92E7ACD3811838F66DD478B9BA46")
        public Drawable getCallingApplicationIcon() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_835128964 = null; //Variable for return #1
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1176913907 = null; //Variable for return #2
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1009571522 = null; //Variable for return #3
            varB4EAC82CA7396A68D541C85D26508E83_835128964 = null;
            PackageManager pm;
            pm = mActivity.getPackageManager();
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1176913907 = pm.getApplicationIcon(mCallingPackage);
            } //End block
            catch (NameNotFoundException e)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_1009571522 = null;
            Drawable varA7E53CE21691AB073D9660D615818899_777785231; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_777785231 = varB4EAC82CA7396A68D541C85D26508E83_835128964;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_777785231 = varB4EAC82CA7396A68D541C85D26508E83_1176913907;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_777785231 = varB4EAC82CA7396A68D541C85D26508E83_1009571522;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_777785231.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_777785231;
            // ---------- Original Method ----------
            //if (mCallingPackage == null) return null;
            //PackageManager pm = mActivity.getPackageManager();
            //try {
                //return pm.getApplicationIcon(mCallingPackage);
            //} catch (NameNotFoundException e) {
                //Log.e(TAG, "Could not retrieve icon for calling application", e);
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.163 -0400", hash_original_method = "F45DE27FE2614ABFE05276FFE92A1DFC", hash_generated_method = "BCB96A3427504A1EB60FB936DE0AAAA0")
        public CharSequence getCallingApplicationLabel() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1511486002 = null; //Variable for return #1
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_265465866 = null; //Variable for return #2
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_2084879303 = null; //Variable for return #3
            varB4EAC82CA7396A68D541C85D26508E83_1511486002 = null;
            PackageManager pm;
            pm = mActivity.getPackageManager();
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_265465866 = pm.getApplicationLabel(pm.getApplicationInfo(mCallingPackage, 0));
            } //End block
            catch (NameNotFoundException e)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_2084879303 = null;
            CharSequence varA7E53CE21691AB073D9660D615818899_119898916; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_119898916 = varB4EAC82CA7396A68D541C85D26508E83_1511486002;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_119898916 = varB4EAC82CA7396A68D541C85D26508E83_265465866;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_119898916 = varB4EAC82CA7396A68D541C85D26508E83_2084879303;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_119898916.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_119898916;
            // ---------- Original Method ----------
            //if (mCallingPackage == null) return null;
            //PackageManager pm = mActivity.getPackageManager();
            //try {
                //return pm.getApplicationLabel(pm.getApplicationInfo(mCallingPackage, 0));
            //} catch (NameNotFoundException e) {
                //Log.e(TAG, "Could not retrieve label for calling application", e);
            //}
            //return null;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.164 -0400", hash_original_field = "C35FE37D3D68B7F50E5B47EFC8197FEA", hash_generated_field = "725A4DD08E25F75F8322943F067C0FD8")

        private static String TAG = "IntentReader";
    }


    
    interface ShareCompatImpl {
        void configureMenuItem(MenuItem item, IntentBuilder shareIntent);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.164 -0400", hash_original_field = "3F3D0310513A50B423661811647770EA", hash_generated_field = "F0F1884F3EDE30C05A70864F9C6AA85D")

    public static final String EXTRA_CALLING_PACKAGE =
            "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.164 -0400", hash_original_field = "B933FBCC6BBDB35CD9FC72DD4DA084BA", hash_generated_field = "162A2C12919BD466B3B854E7E2E5BA78")

    public static final String EXTRA_CALLING_ACTIVITY =
            "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.164 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "1BF51C8837B8F6C5C574D00A856658A9")

    private static ShareCompatImpl IMPL;
    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new ShareCompatImplICS();
        } else {
            IMPL = new ShareCompatImplBase();
        }
    }
    
}

