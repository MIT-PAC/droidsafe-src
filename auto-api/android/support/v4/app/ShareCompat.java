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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.645 -0400", hash_original_method = "0A13BB4106553207210A279F3A99B9BB", hash_generated_method = "0A13BB4106553207210A279F3A99B9BB")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.648 -0400", hash_original_method = "8064BAE7F7BB15EFDB6F22BEE7DAC14F", hash_generated_method = "8064BAE7F7BB15EFDB6F22BEE7DAC14F")
        public ShareCompatImplBase ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.662 -0400", hash_original_method = "C3E2EAA5FDB39D2940E924EA83A92CD9", hash_generated_method = "1DE1A2BE64F4826527D093E4C4576324")
        public void configureMenuItem(MenuItem item, IntentBuilder shareIntent) {
            item.setIntent(shareIntent.createChooserIntent());
            addTaint(item.getTaint());
            addTaint(shareIntent.getTaint());
            // ---------- Original Method ----------
            //item.setIntent(shareIntent.createChooserIntent());
        }

        
    }


    
    static class ShareCompatImplICS implements ShareCompatImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.662 -0400", hash_original_method = "2CBAE6C93111BB9854C827ED9FA39E30", hash_generated_method = "2CBAE6C93111BB9854C827ED9FA39E30")
        public ShareCompatImplICS ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.663 -0400", hash_original_method = "B1A2841A2931DAEF8203340229B6A2CE", hash_generated_method = "6A25EC6F95086DB476F168FB838751E9")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.663 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "B0D69375984D6EE7DC93AC12DB4DFC55")

        private Activity mActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.663 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.663 -0400", hash_original_field = "E63B8F7781E4F1931DDD1A0AEA865EB7", hash_generated_field = "C9A7B3C8A894CB38E3F5AAE7F09F414B")

        private CharSequence mChooserTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.663 -0400", hash_original_field = "1807DAA89FC786F450FBCBF6EFE208C2", hash_generated_field = "21ED3C508F73EC28DFF7BE66BD15E9A5")

        private ArrayList<String> mToAddresses;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.663 -0400", hash_original_field = "663A0F10C2B6F99EAB90D4BC2B1C307A", hash_generated_field = "1FA039FD28E6545C6FC9E4ED5C735249")

        private ArrayList<String> mCcAddresses;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.663 -0400", hash_original_field = "5E4E2ED761B0E4E31C1779D389179C79", hash_generated_field = "F7527C0ABC323B033A133BADC1BA7ACD")

        private ArrayList<String> mBccAddresses;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.663 -0400", hash_original_field = "A1ADF33EC233D9220AFA3F7B9CA06090", hash_generated_field = "E38B530386D6624B9CC752A26937D70B")

        private ArrayList<Uri> mStreams;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.664 -0400", hash_original_method = "DF152584278C8F8C835FFB6AA3E923E0", hash_generated_method = "7CFDE13177AD62E7606E7FE70D0F895E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.682 -0400", hash_original_method = "CC05494BB54ABC476F91DA83FFC83A1D", hash_generated_method = "4D862ECAF1121BAE1EFB2D94DCD26EBB")
        public Intent getIntent() {
            Intent varB4EAC82CA7396A68D541C85D26508E83_302649322 = null; //Variable for return #1
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
                    boolean varF139EBEDE45D4A2E2BBF88D451A25947_2819623 = (mStreams != null && !mStreams.isEmpty());
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
                    boolean varF139EBEDE45D4A2E2BBF88D451A25947_217741245 = (mStreams != null && !mStreams.isEmpty());
                    {
                        mIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, mStreams);
                    } //End block
                    {
                        mIntent.removeExtra(Intent.EXTRA_STREAM);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_302649322 = mIntent;
            varB4EAC82CA7396A68D541C85D26508E83_302649322.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_302649322;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.690 -0400", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "B9494C5582E607BDC06B532AAE84AF62")
         Activity getActivity() {
            Activity varB4EAC82CA7396A68D541C85D26508E83_2049427676 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2049427676 = mActivity;
            varB4EAC82CA7396A68D541C85D26508E83_2049427676.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2049427676;
            // ---------- Original Method ----------
            //return mActivity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.699 -0400", hash_original_method = "026504B88DB15C0C017BBB730BD6CA05", hash_generated_method = "CA509B588C81BEF10ECD709CA72A49CC")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.700 -0400", hash_original_method = "BD64BC57794A356441B2316C07AE8DAC", hash_generated_method = "4AB09B90763DBB49CA43AFCD2511E0AD")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.700 -0400", hash_original_method = "4A271FB631FE734F0A005F0662E72303", hash_generated_method = "20CC75A76D2D63B9E6AE078AD0ED09FB")
        public Intent createChooserIntent() {
            Intent varB4EAC82CA7396A68D541C85D26508E83_305629259 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_305629259 = Intent.createChooser(getIntent(), mChooserTitle);
            varB4EAC82CA7396A68D541C85D26508E83_305629259.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_305629259;
            // ---------- Original Method ----------
            //return Intent.createChooser(getIntent(), mChooserTitle);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.701 -0400", hash_original_method = "EF93D4C25B6364A5474AC09756C110F4", hash_generated_method = "250CBDFEAEB807D2F8C8C9A9BA870E4A")
        public void startChooser() {
            mActivity.startActivity(createChooserIntent());
            // ---------- Original Method ----------
            //mActivity.startActivity(createChooserIntent());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.724 -0400", hash_original_method = "06E956E502A80DA9473ED82266A5A9DE", hash_generated_method = "EE2632F92AB977BA4FB6E2D63C119D1D")
        public IntentBuilder setChooserTitle(CharSequence title) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1163123650 = null; //Variable for return #1
            mChooserTitle = title;
            varB4EAC82CA7396A68D541C85D26508E83_1163123650 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1163123650.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1163123650;
            // ---------- Original Method ----------
            //mChooserTitle = title;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.724 -0400", hash_original_method = "03DF458E6ED02C68488BE88E21862CDF", hash_generated_method = "44DF6084EBF7A6D3C58C3F794ADA4AF1")
        public IntentBuilder setChooserTitle(int resId) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1185170168 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1185170168 = setChooserTitle(mActivity.getText(resId));
            addTaint(resId);
            varB4EAC82CA7396A68D541C85D26508E83_1185170168.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1185170168;
            // ---------- Original Method ----------
            //return setChooserTitle(mActivity.getText(resId));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.725 -0400", hash_original_method = "FC54C1994B818C86E4DBEFD863458812", hash_generated_method = "55776F8CB37AFD1472D097A9F0BF38D7")
        public IntentBuilder setType(String mimeType) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_935632214 = null; //Variable for return #1
            mIntent.setType(mimeType);
            varB4EAC82CA7396A68D541C85D26508E83_935632214 = this;
            addTaint(mimeType.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_935632214.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_935632214;
            // ---------- Original Method ----------
            //mIntent.setType(mimeType);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.726 -0400", hash_original_method = "C395D7124DB9BC11CF728AC9FB5C05F1", hash_generated_method = "BA0C8784924656A1D95C2DADA0A12B16")
        public IntentBuilder setText(CharSequence text) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1095807565 = null; //Variable for return #1
            mIntent.putExtra(Intent.EXTRA_TEXT, text);
            varB4EAC82CA7396A68D541C85D26508E83_1095807565 = this;
            addTaint(text.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1095807565.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1095807565;
            // ---------- Original Method ----------
            //mIntent.putExtra(Intent.EXTRA_TEXT, text);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.729 -0400", hash_original_method = "0CC67542367F5DDA6287793533CA2797", hash_generated_method = "70164BA4834FF83A195C0876445FBBD1")
        public IntentBuilder setStream(Uri streamUri) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1347619347 = null; //Variable for return #1
            {
                boolean var3141264D9C3F68A9609EF9BEF3806130_1225734883 = (!mIntent.getAction().equals(Intent.ACTION_SEND));
                {
                    mIntent.setAction(Intent.ACTION_SEND);
                } //End block
            } //End collapsed parenthetic
            mStreams = null;
            mIntent.putExtra(Intent.EXTRA_STREAM, streamUri);
            varB4EAC82CA7396A68D541C85D26508E83_1347619347 = this;
            addTaint(streamUri.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1347619347.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1347619347;
            // ---------- Original Method ----------
            //if (!mIntent.getAction().equals(Intent.ACTION_SEND)) {
                //mIntent.setAction(Intent.ACTION_SEND);
            //}
            //mStreams = null;
            //mIntent.putExtra(Intent.EXTRA_STREAM, streamUri);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.746 -0400", hash_original_method = "5DA0D5B75B65E8A970BBB6A6FE8B4CFF", hash_generated_method = "F6DB1B46BD88E404A39D9DC77419E93E")
        public IntentBuilder addStream(Uri streamUri) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_283172473 = null; //Variable for return #1
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1718804793 = null; //Variable for return #2
            Uri currentStream;
            currentStream = mIntent.getParcelableExtra(Intent.EXTRA_STREAM);
            {
                varB4EAC82CA7396A68D541C85D26508E83_283172473 = setStream(streamUri);
            } //End block
            {
                mStreams = new ArrayList<Uri>();
            } //End block
            {
                mIntent.removeExtra(Intent.EXTRA_STREAM);
                mStreams.add(currentStream);
            } //End block
            mStreams.add(streamUri);
            varB4EAC82CA7396A68D541C85D26508E83_1718804793 = this;
            addTaint(streamUri.getTaint());
            IntentBuilder varA7E53CE21691AB073D9660D615818899_1275559426; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1275559426 = varB4EAC82CA7396A68D541C85D26508E83_283172473;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1275559426 = varB4EAC82CA7396A68D541C85D26508E83_1718804793;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1275559426.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1275559426;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.746 -0400", hash_original_method = "FD4DB555E0D921CCC6ACF7E2C37BCAC4", hash_generated_method = "DF05639293287DE6E41AF79B0B9B6B6D")
        public IntentBuilder setEmailTo(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_837337886 = null; //Variable for return #1
            {
                mToAddresses = null;
            } //End block
            mIntent.putExtra(Intent.EXTRA_EMAIL, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_837337886 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_837337886.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_837337886;
            // ---------- Original Method ----------
            //if (mToAddresses != null) {
                //mToAddresses = null;
            //}
            //mIntent.putExtra(Intent.EXTRA_EMAIL, addresses);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.748 -0400", hash_original_method = "E206D9565B5E9D24AEF2AF92EC056646", hash_generated_method = "CD9EFEF3290CEC860A3D48DB2C147101")
        public IntentBuilder addEmailTo(String address) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1224743354 = null; //Variable for return #1
            {
                mToAddresses = new ArrayList<String>();
            } //End block
            mToAddresses.add(address);
            varB4EAC82CA7396A68D541C85D26508E83_1224743354 = this;
            addTaint(address.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1224743354.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1224743354;
            // ---------- Original Method ----------
            //if (mToAddresses == null) {
                //mToAddresses = new ArrayList<String>();
            //}
            //mToAddresses.add(address);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.748 -0400", hash_original_method = "7721A9C42CBA5A2892BFCB8DDD6F7399", hash_generated_method = "605102821029839FCE2B45A287F21FA1")
        public IntentBuilder addEmailTo(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1142885262 = null; //Variable for return #1
            combineArrayExtra(Intent.EXTRA_EMAIL, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_1142885262 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1142885262.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1142885262;
            // ---------- Original Method ----------
            //combineArrayExtra(Intent.EXTRA_EMAIL, addresses);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.770 -0400", hash_original_method = "BE74A7950B78C22222797B86EEED6F25", hash_generated_method = "46E32FAFBF85C65827B8585EEC2680A4")
        public IntentBuilder setEmailCc(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_633801608 = null; //Variable for return #1
            mIntent.putExtra(Intent.EXTRA_CC, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_633801608 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_633801608.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_633801608;
            // ---------- Original Method ----------
            //mIntent.putExtra(Intent.EXTRA_CC, addresses);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.770 -0400", hash_original_method = "2EF08D607B211A7E5DCF80D337C959CD", hash_generated_method = "3701AE998D811EC2314714E3FF643426")
        public IntentBuilder addEmailCc(String address) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1599974319 = null; //Variable for return #1
            {
                mCcAddresses = new ArrayList<String>();
            } //End block
            mCcAddresses.add(address);
            varB4EAC82CA7396A68D541C85D26508E83_1599974319 = this;
            addTaint(address.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1599974319.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1599974319;
            // ---------- Original Method ----------
            //if (mCcAddresses == null) {
                //mCcAddresses = new ArrayList<String>();
            //}
            //mCcAddresses.add(address);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.771 -0400", hash_original_method = "18B1AA262CDF43BA34C5BCC06BA146A5", hash_generated_method = "BA559F610F4810AD4935AF4569CDF5BE")
        public IntentBuilder addEmailCc(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_109068669 = null; //Variable for return #1
            combineArrayExtra(Intent.EXTRA_CC, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_109068669 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_109068669.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_109068669;
            // ---------- Original Method ----------
            //combineArrayExtra(Intent.EXTRA_CC, addresses);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.772 -0400", hash_original_method = "965E5218675D98D1034B8CE91C4C024C", hash_generated_method = "E7932F403FC047B77189348470A4EFAF")
        public IntentBuilder setEmailBcc(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_394947770 = null; //Variable for return #1
            mIntent.putExtra(Intent.EXTRA_BCC, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_394947770 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_394947770.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_394947770;
            // ---------- Original Method ----------
            //mIntent.putExtra(Intent.EXTRA_BCC, addresses);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.778 -0400", hash_original_method = "68C0EF4D86815A482951AF12B5153611", hash_generated_method = "59D1B97005FBBF094DDDAF44AFABBD37")
        public IntentBuilder addEmailBcc(String address) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1118761919 = null; //Variable for return #1
            {
                mBccAddresses = new ArrayList<String>();
            } //End block
            mBccAddresses.add(address);
            varB4EAC82CA7396A68D541C85D26508E83_1118761919 = this;
            addTaint(address.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1118761919.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1118761919;
            // ---------- Original Method ----------
            //if (mBccAddresses == null) {
                //mBccAddresses = new ArrayList<String>();
            //}
            //mBccAddresses.add(address);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.797 -0400", hash_original_method = "A108079E5E05347E55233C38CDE39CC2", hash_generated_method = "33808856FE9DF06E01CC56D3BFA38855")
        public IntentBuilder addEmailBcc(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1713466252 = null; //Variable for return #1
            combineArrayExtra(Intent.EXTRA_BCC, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_1713466252 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1713466252.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1713466252;
            // ---------- Original Method ----------
            //combineArrayExtra(Intent.EXTRA_BCC, addresses);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.798 -0400", hash_original_method = "3E6F6D2B7406A417F246425C88E21422", hash_generated_method = "4D295AD3DD9887235161F2E878C0D802")
        public IntentBuilder setSubject(String subject) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_90370154 = null; //Variable for return #1
            mIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
            varB4EAC82CA7396A68D541C85D26508E83_90370154 = this;
            addTaint(subject.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_90370154.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_90370154;
            // ---------- Original Method ----------
            //mIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
            //return this;
        }

        
    }


    
    public static class IntentReader {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.798 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "B0D69375984D6EE7DC93AC12DB4DFC55")

        private Activity mActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.798 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.798 -0400", hash_original_field = "69D772FE63E594767F3D526E4183666C", hash_generated_field = "E9DB1E160A758DD2D7A97AC8EAD7032B")

        private String mCallingPackage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.798 -0400", hash_original_field = "579F6F4641F6E6419FFF278DEBF8E9BA", hash_generated_field = "9F2300B66972EC6EFB2EFE241B7A0E66")

        private ComponentName mCallingActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.800 -0400", hash_original_field = "A1ADF33EC233D9220AFA3F7B9CA06090", hash_generated_field = "E38B530386D6624B9CC752A26937D70B")

        private ArrayList<Uri> mStreams;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.813 -0400", hash_original_method = "33DC5300860410C275910F5653E8BC84", hash_generated_method = "FB5749427BB382C46398D39E46300D1A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.814 -0400", hash_original_method = "A707037246F5733C08453D3B682DF768", hash_generated_method = "D48A7494D5F208FE324F4FF3ED8C259A")
        public boolean isShareIntent() {
            String action;
            action = mIntent.getAction();
            boolean var6199C70CF17ED50D954A70C090A4DC62_129571139 = (action.equals(Intent.ACTION_SEND) || action.equals(Intent.ACTION_SEND_MULTIPLE));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2138481346 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2138481346;
            // ---------- Original Method ----------
            //final String action = mIntent.getAction();
            //return action.equals(Intent.ACTION_SEND) || action.equals(Intent.ACTION_SEND_MULTIPLE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.814 -0400", hash_original_method = "BFA6AA7528AA5BB107B3B7EA24E49B64", hash_generated_method = "A7C35EB40BB1CD6AC13D501081AAA720")
        public boolean isSingleShare() {
            boolean var163FBD7B7485DF6491201565A1589C76_1649790676 = (mIntent.getAction().equals(Intent.ACTION_SEND));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1974104890 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1974104890;
            // ---------- Original Method ----------
            //return mIntent.getAction().equals(Intent.ACTION_SEND);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.815 -0400", hash_original_method = "61DADC6D6F65F3016BDEF2AAD1D3A3F0", hash_generated_method = "7CAD912C7F71469DA0265FDC5332D2CC")
        public boolean isMultipleShare() {
            boolean var8AA762653092B3F38E8AE23B1AB05044_1579340742 = (mIntent.getAction().equals(Intent.ACTION_SEND_MULTIPLE));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482077155 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482077155;
            // ---------- Original Method ----------
            //return mIntent.getAction().equals(Intent.ACTION_SEND_MULTIPLE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.819 -0400", hash_original_method = "D2D116B363ACAF23E5ABAEA8317A2D07", hash_generated_method = "30C4BA551E089061F594BCC7CA28B9B8")
        public String getType() {
            String varB4EAC82CA7396A68D541C85D26508E83_873886436 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_873886436 = mIntent.getType();
            varB4EAC82CA7396A68D541C85D26508E83_873886436.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_873886436;
            // ---------- Original Method ----------
            //return mIntent.getType();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.839 -0400", hash_original_method = "001799CDC7AD568A5D9791D68F82B19E", hash_generated_method = "2A4B96713CF06D9DCBDDEA5FD2B52467")
        public CharSequence getText() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1069783222 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1069783222 = mIntent.getCharSequenceExtra(Intent.EXTRA_TEXT);
            varB4EAC82CA7396A68D541C85D26508E83_1069783222.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1069783222;
            // ---------- Original Method ----------
            //return mIntent.getCharSequenceExtra(Intent.EXTRA_TEXT);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.840 -0400", hash_original_method = "6766C6C36607D95201A80937E1C93C5B", hash_generated_method = "F0EB89F7CCA058F0833BBD3723BF186B")
        public Uri getStream() {
            Uri varB4EAC82CA7396A68D541C85D26508E83_1940274008 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1940274008 = mIntent.getParcelableExtra(Intent.EXTRA_STREAM);
            varB4EAC82CA7396A68D541C85D26508E83_1940274008.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1940274008;
            // ---------- Original Method ----------
            //return mIntent.getParcelableExtra(Intent.EXTRA_STREAM);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.841 -0400", hash_original_method = "CA16C800A8BACDD493D26B5DCB8F6704", hash_generated_method = "35AEC82572CC4E337B0B5C63CCF562F5")
        public Uri getStream(int index) {
            Uri varB4EAC82CA7396A68D541C85D26508E83_1366615589 = null; //Variable for return #1
            Uri varB4EAC82CA7396A68D541C85D26508E83_433279750 = null; //Variable for return #2
            {
                boolean varAA8C0850796E27ECE01A9205830925C9_423252446 = (mStreams == null && isMultipleShare());
                {
                    mStreams = mIntent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
                } //End block
            } //End collapsed parenthetic
            {
                varB4EAC82CA7396A68D541C85D26508E83_1366615589 = mStreams.get(index);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_433279750 = mIntent.getParcelableExtra(Intent.EXTRA_STREAM);
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() +
                    " index requested: " + index);
            addTaint(index);
            Uri varA7E53CE21691AB073D9660D615818899_1823408103; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1823408103 = varB4EAC82CA7396A68D541C85D26508E83_1366615589;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1823408103 = varB4EAC82CA7396A68D541C85D26508E83_433279750;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1823408103.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1823408103;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.842 -0400", hash_original_method = "BC61684682118C8B50538A4E9628C32B", hash_generated_method = "F0623ADE9F72CF8E65A35AC7FDD00000")
        public int getStreamCount() {
            {
                boolean varAA8C0850796E27ECE01A9205830925C9_1176651299 = (mStreams == null && isMultipleShare());
                {
                    mStreams = mIntent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
                } //End block
            } //End collapsed parenthetic
            {
                int varD4374328095A9182E73BED2B4E112D5C_745201437 = (mStreams.size());
            } //End block
            {
                boolean var19EBAAC96567DABF4F39A6F661817952_1660087184 = (mIntent.hasExtra(Intent.EXTRA_STREAM));
            } //End flattened ternary
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_312194722 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_312194722;
            // ---------- Original Method ----------
            //if (mStreams == null && isMultipleShare()) {
                //mStreams = mIntent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
            //}
            //if (mStreams != null) {
                //return mStreams.size();
            //}
            //return mIntent.hasExtra(Intent.EXTRA_STREAM) ? 1 : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.856 -0400", hash_original_method = "D1879246F5FB4411F3E91A8AEB3C384C", hash_generated_method = "D93DD7830C71D38A475BBCE07362CF58")
        public String[] getEmailTo() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_1752306550 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1752306550 = mIntent.getStringArrayExtra(Intent.EXTRA_EMAIL);
            varB4EAC82CA7396A68D541C85D26508E83_1752306550.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1752306550;
            // ---------- Original Method ----------
            //return mIntent.getStringArrayExtra(Intent.EXTRA_EMAIL);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.858 -0400", hash_original_method = "F2F2C05F2171316000FF1516A5D8CD3A", hash_generated_method = "D710779880A471C0E2273A57FED9FA7B")
        public String[] getEmailCc() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_291527643 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_291527643 = mIntent.getStringArrayExtra(Intent.EXTRA_CC);
            varB4EAC82CA7396A68D541C85D26508E83_291527643.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_291527643;
            // ---------- Original Method ----------
            //return mIntent.getStringArrayExtra(Intent.EXTRA_CC);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.858 -0400", hash_original_method = "8B48BB50B06FCBCC280D77A42BA7B009", hash_generated_method = "761806A7A660BF095BD165FA9F13AA05")
        public String[] getEmailBcc() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_1650421027 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1650421027 = mIntent.getStringArrayExtra(Intent.EXTRA_BCC);
            varB4EAC82CA7396A68D541C85D26508E83_1650421027.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1650421027;
            // ---------- Original Method ----------
            //return mIntent.getStringArrayExtra(Intent.EXTRA_BCC);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.865 -0400", hash_original_method = "1E0DCEAE4F7F7EF81C98D4CC969955D0", hash_generated_method = "5091D94D7C1280B576FD4DA03A44B284")
        public String getSubject() {
            String varB4EAC82CA7396A68D541C85D26508E83_833347340 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_833347340 = mIntent.getStringExtra(Intent.EXTRA_SUBJECT);
            varB4EAC82CA7396A68D541C85D26508E83_833347340.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_833347340;
            // ---------- Original Method ----------
            //return mIntent.getStringExtra(Intent.EXTRA_SUBJECT);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.866 -0400", hash_original_method = "599A2909147C5ABF7649B275042032E0", hash_generated_method = "A454085B9D403A691DD62673DDE459D6")
        public String getCallingPackage() {
            String varB4EAC82CA7396A68D541C85D26508E83_407453689 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_407453689 = mCallingPackage;
            varB4EAC82CA7396A68D541C85D26508E83_407453689.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_407453689;
            // ---------- Original Method ----------
            //return mCallingPackage;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.869 -0400", hash_original_method = "7754B7141829C06037743B2AEFCB8100", hash_generated_method = "3696F0296A5A0809B888E446DC253E29")
        public ComponentName getCallingActivity() {
            ComponentName varB4EAC82CA7396A68D541C85D26508E83_1190285423 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1190285423 = mCallingActivity;
            varB4EAC82CA7396A68D541C85D26508E83_1190285423.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1190285423;
            // ---------- Original Method ----------
            //return mCallingActivity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.887 -0400", hash_original_method = "DF0726DEBD67610C86B101B05D0C636E", hash_generated_method = "876075BE0A7646342271BD1808E8DC31")
        public Drawable getCallingActivityIcon() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1312469875 = null; //Variable for return #1
            Drawable varB4EAC82CA7396A68D541C85D26508E83_742006124 = null; //Variable for return #2
            Drawable varB4EAC82CA7396A68D541C85D26508E83_835924708 = null; //Variable for return #3
            varB4EAC82CA7396A68D541C85D26508E83_1312469875 = null;
            PackageManager pm;
            pm = mActivity.getPackageManager();
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_742006124 = pm.getActivityIcon(mCallingActivity);
            } //End block
            catch (NameNotFoundException e)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_835924708 = null;
            Drawable varA7E53CE21691AB073D9660D615818899_2122099043; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_2122099043 = varB4EAC82CA7396A68D541C85D26508E83_1312469875;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_2122099043 = varB4EAC82CA7396A68D541C85D26508E83_742006124;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2122099043 = varB4EAC82CA7396A68D541C85D26508E83_835924708;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2122099043.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_2122099043;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.889 -0400", hash_original_method = "CF72ECE57DC07F413BA6AAECB91EABC0", hash_generated_method = "3386C34CCF20271DC068BBB50BAE2CD6")
        public Drawable getCallingApplicationIcon() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_775513962 = null; //Variable for return #1
            Drawable varB4EAC82CA7396A68D541C85D26508E83_514920477 = null; //Variable for return #2
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1924541511 = null; //Variable for return #3
            varB4EAC82CA7396A68D541C85D26508E83_775513962 = null;
            PackageManager pm;
            pm = mActivity.getPackageManager();
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_514920477 = pm.getApplicationIcon(mCallingPackage);
            } //End block
            catch (NameNotFoundException e)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_1924541511 = null;
            Drawable varA7E53CE21691AB073D9660D615818899_835271377; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_835271377 = varB4EAC82CA7396A68D541C85D26508E83_775513962;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_835271377 = varB4EAC82CA7396A68D541C85D26508E83_514920477;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_835271377 = varB4EAC82CA7396A68D541C85D26508E83_1924541511;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_835271377.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_835271377;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.898 -0400", hash_original_method = "F45DE27FE2614ABFE05276FFE92A1DFC", hash_generated_method = "B3C34E0DFA679E7D333BE835C6AFF790")
        public CharSequence getCallingApplicationLabel() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_561571241 = null; //Variable for return #1
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_586299317 = null; //Variable for return #2
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_184652393 = null; //Variable for return #3
            varB4EAC82CA7396A68D541C85D26508E83_561571241 = null;
            PackageManager pm;
            pm = mActivity.getPackageManager();
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_586299317 = pm.getApplicationLabel(pm.getApplicationInfo(mCallingPackage, 0));
            } //End block
            catch (NameNotFoundException e)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_184652393 = null;
            CharSequence varA7E53CE21691AB073D9660D615818899_2113877963; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_2113877963 = varB4EAC82CA7396A68D541C85D26508E83_561571241;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_2113877963 = varB4EAC82CA7396A68D541C85D26508E83_586299317;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2113877963 = varB4EAC82CA7396A68D541C85D26508E83_184652393;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2113877963.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_2113877963;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.899 -0400", hash_original_field = "C35FE37D3D68B7F50E5B47EFC8197FEA", hash_generated_field = "725A4DD08E25F75F8322943F067C0FD8")

        private static String TAG = "IntentReader";
    }


    
    interface ShareCompatImpl {
        void configureMenuItem(MenuItem item, IntentBuilder shareIntent);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.899 -0400", hash_original_field = "3F3D0310513A50B423661811647770EA", hash_generated_field = "F0F1884F3EDE30C05A70864F9C6AA85D")

    public static final String EXTRA_CALLING_PACKAGE =
            "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.899 -0400", hash_original_field = "B933FBCC6BBDB35CD9FC72DD4DA084BA", hash_generated_field = "162A2C12919BD466B3B854E7E2E5BA78")

    public static final String EXTRA_CALLING_ACTIVITY =
            "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.899 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "1BF51C8837B8F6C5C574D00A856658A9")

    private static ShareCompatImpl IMPL;
    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new ShareCompatImplICS();
        } else {
            IMPL = new ShareCompatImplBase();
        }
    }
    
}

