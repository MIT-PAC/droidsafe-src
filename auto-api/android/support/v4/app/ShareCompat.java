package android.support.v4.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.178 -0400", hash_original_method = "0A13BB4106553207210A279F3A99B9BB", hash_generated_method = "0A13BB4106553207210A279F3A99B9BB")
    public ShareCompat ()
    {
        
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.183 -0400", hash_original_method = "8064BAE7F7BB15EFDB6F22BEE7DAC14F", hash_generated_method = "8064BAE7F7BB15EFDB6F22BEE7DAC14F")
        public ShareCompatImplBase ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.183 -0400", hash_original_method = "C3E2EAA5FDB39D2940E924EA83A92CD9", hash_generated_method = "1DE1A2BE64F4826527D093E4C4576324")
        public void configureMenuItem(MenuItem item, IntentBuilder shareIntent) {
            item.setIntent(shareIntent.createChooserIntent());
            addTaint(item.getTaint());
            addTaint(shareIntent.getTaint());
            
            
        }

        
    }


    
    static class ShareCompatImplICS implements ShareCompatImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.183 -0400", hash_original_method = "2CBAE6C93111BB9854C827ED9FA39E30", hash_generated_method = "2CBAE6C93111BB9854C827ED9FA39E30")
        public ShareCompatImplICS ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.184 -0400", hash_original_method = "B1A2841A2931DAEF8203340229B6A2CE", hash_generated_method = "6A25EC6F95086DB476F168FB838751E9")
        public void configureMenuItem(MenuItem item, IntentBuilder shareIntent) {
            ShareCompatICS.configureMenuItem(item, shareIntent.getActivity(),
                    shareIntent.getIntent());
            addTaint(item.getTaint());
            addTaint(shareIntent.getTaint());
            
            
                    
        }

        
    }


    
    public static class IntentBuilder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.184 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "B0D69375984D6EE7DC93AC12DB4DFC55")

        private Activity mActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.184 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.184 -0400", hash_original_field = "E63B8F7781E4F1931DDD1A0AEA865EB7", hash_generated_field = "C9A7B3C8A894CB38E3F5AAE7F09F414B")

        private CharSequence mChooserTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.184 -0400", hash_original_field = "1807DAA89FC786F450FBCBF6EFE208C2", hash_generated_field = "21ED3C508F73EC28DFF7BE66BD15E9A5")

        private ArrayList<String> mToAddresses;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.184 -0400", hash_original_field = "663A0F10C2B6F99EAB90D4BC2B1C307A", hash_generated_field = "1FA039FD28E6545C6FC9E4ED5C735249")

        private ArrayList<String> mCcAddresses;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.184 -0400", hash_original_field = "5E4E2ED761B0E4E31C1779D389179C79", hash_generated_field = "F7527C0ABC323B033A133BADC1BA7ACD")

        private ArrayList<String> mBccAddresses;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.184 -0400", hash_original_field = "A1ADF33EC233D9220AFA3F7B9CA06090", hash_generated_field = "E38B530386D6624B9CC752A26937D70B")

        private ArrayList<Uri> mStreams;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.184 -0400", hash_original_method = "DF152584278C8F8C835FFB6AA3E923E0", hash_generated_method = "7CFDE13177AD62E7606E7FE70D0F895E")
        private  IntentBuilder(Activity launchingActivity) {
            mActivity = launchingActivity;
            mIntent = new Intent().setAction(Intent.ACTION_SEND);
            mIntent.putExtra(EXTRA_CALLING_PACKAGE, launchingActivity.getPackageName());
            mIntent.putExtra(EXTRA_CALLING_ACTIVITY, launchingActivity.getComponentName());
            mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
            
            
            
            
            
            
        }

        
                public static IntentBuilder from(Activity launchingActivity) {
            return new IntentBuilder(launchingActivity);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.186 -0400", hash_original_method = "CC05494BB54ABC476F91DA83FFC83A1D", hash_generated_method = "B773277F0E6E868CCE34B9873DF2B3A2")
        public Intent getIntent() {
            Intent varB4EAC82CA7396A68D541C85D26508E83_1494099958 = null; 
            {
                combineArrayExtra(Intent.EXTRA_EMAIL, mToAddresses);
                mToAddresses = null;
            } 
            {
                combineArrayExtra(Intent.EXTRA_CC, mCcAddresses);
                mCcAddresses = null;
            } 
            {
                combineArrayExtra(Intent.EXTRA_BCC, mBccAddresses);
                mBccAddresses = null;
            } 
            boolean needsSendMultiple = mStreams != null && mStreams.size() > 1;
            boolean isSendMultiple = mIntent.getAction().equals(Intent.ACTION_SEND_MULTIPLE);
            {
                mIntent.setAction(Intent.ACTION_SEND);
                {
                    boolean varF139EBEDE45D4A2E2BBF88D451A25947_733377259 = (mStreams != null && !mStreams.isEmpty());
                    {
                        mIntent.putExtra(Intent.EXTRA_STREAM, mStreams.get(0));
                    } 
                    {
                        mIntent.removeExtra(Intent.EXTRA_STREAM);
                    } 
                } 
                mStreams = null;
            } 
            {
                mIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
                {
                    boolean varF139EBEDE45D4A2E2BBF88D451A25947_1166455258 = (mStreams != null && !mStreams.isEmpty());
                    {
                        mIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, mStreams);
                    } 
                    {
                        mIntent.removeExtra(Intent.EXTRA_STREAM);
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1494099958 = mIntent;
            varB4EAC82CA7396A68D541C85D26508E83_1494099958.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1494099958;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.186 -0400", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "736761F747073E33E106A285F3778C7E")
         Activity getActivity() {
            Activity varB4EAC82CA7396A68D541C85D26508E83_259641511 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_259641511 = mActivity;
            varB4EAC82CA7396A68D541C85D26508E83_259641511.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_259641511;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.187 -0400", hash_original_method = "026504B88DB15C0C017BBB730BD6CA05", hash_generated_method = "C590B2DBE1791EAFCC8F4BD0A4EFFFC5")
        private void combineArrayExtra(String extra, ArrayList<String> add) {
            String[] currentAddresses = mIntent.getStringArrayExtra(extra);
            int currentLength;
            currentLength = currentAddresses.length;
            currentLength = 0;
            String[] finalAddresses = new String[currentLength + add.size()];
            add.toArray(finalAddresses);
            {
                System.arraycopy(currentAddresses, 0, finalAddresses, add.size(), currentLength);
            } 
            mIntent.putExtra(extra, finalAddresses);
            addTaint(extra.getTaint());
            addTaint(add.getTaint());
            
            
            
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.187 -0400", hash_original_method = "BD64BC57794A356441B2316C07AE8DAC", hash_generated_method = "1BAA6A3CB818A94546A705C6FA05FF03")
        private void combineArrayExtra(String extra, String[] add) {
            Intent intent = getIntent();
            String[] old = intent.getStringArrayExtra(extra);
            int oldLength;
            oldLength = old.length;
            oldLength = 0;
            String[] result = new String[oldLength + add.length];
            System.arraycopy(old, 0, result, 0, oldLength);
            System.arraycopy(add, 0, result, oldLength, add.length);
            intent.putExtra(extra, result);
            addTaint(extra.getTaint());
            addTaint(add[0].getTaint());
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.188 -0400", hash_original_method = "4A271FB631FE734F0A005F0662E72303", hash_generated_method = "43080F759E29AEF338F4446B9C39F8BD")
        public Intent createChooserIntent() {
            Intent varB4EAC82CA7396A68D541C85D26508E83_528838512 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_528838512 = Intent.createChooser(getIntent(), mChooserTitle);
            varB4EAC82CA7396A68D541C85D26508E83_528838512.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_528838512;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.188 -0400", hash_original_method = "EF93D4C25B6364A5474AC09756C110F4", hash_generated_method = "250CBDFEAEB807D2F8C8C9A9BA870E4A")
        public void startChooser() {
            mActivity.startActivity(createChooserIntent());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.189 -0400", hash_original_method = "06E956E502A80DA9473ED82266A5A9DE", hash_generated_method = "C20E2516BAC33A9FD3DF9F422F935B3E")
        public IntentBuilder setChooserTitle(CharSequence title) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1815663813 = null; 
            mChooserTitle = title;
            varB4EAC82CA7396A68D541C85D26508E83_1815663813 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1815663813.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1815663813;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.189 -0400", hash_original_method = "03DF458E6ED02C68488BE88E21862CDF", hash_generated_method = "7CC50A33C8E46646B5EF7D49822B237A")
        public IntentBuilder setChooserTitle(int resId) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1985481226 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1985481226 = setChooserTitle(mActivity.getText(resId));
            addTaint(resId);
            varB4EAC82CA7396A68D541C85D26508E83_1985481226.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1985481226;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.190 -0400", hash_original_method = "FC54C1994B818C86E4DBEFD863458812", hash_generated_method = "1C364D943F8F9585C03E8F76DCA7DFFF")
        public IntentBuilder setType(String mimeType) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1661725575 = null; 
            mIntent.setType(mimeType);
            varB4EAC82CA7396A68D541C85D26508E83_1661725575 = this;
            addTaint(mimeType.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1661725575.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1661725575;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.190 -0400", hash_original_method = "C395D7124DB9BC11CF728AC9FB5C05F1", hash_generated_method = "9A339C77A30D82BC9AB35B76FE1EE3FA")
        public IntentBuilder setText(CharSequence text) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1018784947 = null; 
            mIntent.putExtra(Intent.EXTRA_TEXT, text);
            varB4EAC82CA7396A68D541C85D26508E83_1018784947 = this;
            addTaint(text.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1018784947.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1018784947;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.191 -0400", hash_original_method = "0CC67542367F5DDA6287793533CA2797", hash_generated_method = "BC3B26672F2D5316C376545B38E0A486")
        public IntentBuilder setStream(Uri streamUri) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1136049056 = null; 
            {
                boolean var3141264D9C3F68A9609EF9BEF3806130_1187984300 = (!mIntent.getAction().equals(Intent.ACTION_SEND));
                {
                    mIntent.setAction(Intent.ACTION_SEND);
                } 
            } 
            mStreams = null;
            mIntent.putExtra(Intent.EXTRA_STREAM, streamUri);
            varB4EAC82CA7396A68D541C85D26508E83_1136049056 = this;
            addTaint(streamUri.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1136049056.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1136049056;
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.192 -0400", hash_original_method = "5DA0D5B75B65E8A970BBB6A6FE8B4CFF", hash_generated_method = "F9B9675D7F578E12346222B3383BCCA6")
        public IntentBuilder addStream(Uri streamUri) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1020223791 = null; 
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_14334554 = null; 
            Uri currentStream = mIntent.getParcelableExtra(Intent.EXTRA_STREAM);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1020223791 = setStream(streamUri);
            } 
            {
                mStreams = new ArrayList<Uri>();
            } 
            {
                mIntent.removeExtra(Intent.EXTRA_STREAM);
                mStreams.add(currentStream);
            } 
            mStreams.add(streamUri);
            varB4EAC82CA7396A68D541C85D26508E83_14334554 = this;
            addTaint(streamUri.getTaint());
            IntentBuilder varA7E53CE21691AB073D9660D615818899_542215577; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_542215577 = varB4EAC82CA7396A68D541C85D26508E83_1020223791;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_542215577 = varB4EAC82CA7396A68D541C85D26508E83_14334554;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_542215577.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_542215577;
            
            
            
                
            
            
                
            
            
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.193 -0400", hash_original_method = "FD4DB555E0D921CCC6ACF7E2C37BCAC4", hash_generated_method = "7A277A9E316EDC1FCA3C86560A58A730")
        public IntentBuilder setEmailTo(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1694264280 = null; 
            {
                mToAddresses = null;
            } 
            mIntent.putExtra(Intent.EXTRA_EMAIL, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_1694264280 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1694264280.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1694264280;
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.195 -0400", hash_original_method = "E206D9565B5E9D24AEF2AF92EC056646", hash_generated_method = "952785727EA210D231CE7717FEE100C8")
        public IntentBuilder addEmailTo(String address) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_544002269 = null; 
            {
                mToAddresses = new ArrayList<String>();
            } 
            mToAddresses.add(address);
            varB4EAC82CA7396A68D541C85D26508E83_544002269 = this;
            addTaint(address.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_544002269.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_544002269;
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.195 -0400", hash_original_method = "7721A9C42CBA5A2892BFCB8DDD6F7399", hash_generated_method = "5A15C25AC5DA0731B09EE23CD0D4A755")
        public IntentBuilder addEmailTo(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1867397897 = null; 
            combineArrayExtra(Intent.EXTRA_EMAIL, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_1867397897 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1867397897.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1867397897;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.196 -0400", hash_original_method = "BE74A7950B78C22222797B86EEED6F25", hash_generated_method = "47547FC3FBB7416CDC3071B46918083F")
        public IntentBuilder setEmailCc(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1700173820 = null; 
            mIntent.putExtra(Intent.EXTRA_CC, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_1700173820 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1700173820.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1700173820;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.196 -0400", hash_original_method = "2EF08D607B211A7E5DCF80D337C959CD", hash_generated_method = "9BAAB1284809143C919DCE71D3E596B7")
        public IntentBuilder addEmailCc(String address) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1166803633 = null; 
            {
                mCcAddresses = new ArrayList<String>();
            } 
            mCcAddresses.add(address);
            varB4EAC82CA7396A68D541C85D26508E83_1166803633 = this;
            addTaint(address.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1166803633.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1166803633;
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.197 -0400", hash_original_method = "18B1AA262CDF43BA34C5BCC06BA146A5", hash_generated_method = "B046C40173AA6CBA6394C1B160554C52")
        public IntentBuilder addEmailCc(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_388575813 = null; 
            combineArrayExtra(Intent.EXTRA_CC, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_388575813 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_388575813.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_388575813;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.198 -0400", hash_original_method = "965E5218675D98D1034B8CE91C4C024C", hash_generated_method = "1210CD86BE32A0C412F3DBF4054ADAC3")
        public IntentBuilder setEmailBcc(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_378066511 = null; 
            mIntent.putExtra(Intent.EXTRA_BCC, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_378066511 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_378066511.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_378066511;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.198 -0400", hash_original_method = "68C0EF4D86815A482951AF12B5153611", hash_generated_method = "44E35868F39E8976572A7CC8FF9A0AC9")
        public IntentBuilder addEmailBcc(String address) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_254913127 = null; 
            {
                mBccAddresses = new ArrayList<String>();
            } 
            mBccAddresses.add(address);
            varB4EAC82CA7396A68D541C85D26508E83_254913127 = this;
            addTaint(address.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_254913127.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_254913127;
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.199 -0400", hash_original_method = "A108079E5E05347E55233C38CDE39CC2", hash_generated_method = "FB7DF1DB5E006DD20FE98E51553C5DDA")
        public IntentBuilder addEmailBcc(String[] addresses) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1114253019 = null; 
            combineArrayExtra(Intent.EXTRA_BCC, addresses);
            varB4EAC82CA7396A68D541C85D26508E83_1114253019 = this;
            addTaint(addresses[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1114253019.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1114253019;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.199 -0400", hash_original_method = "3E6F6D2B7406A417F246425C88E21422", hash_generated_method = "A6286B7A8649AE330D7A48AE2798F74A")
        public IntentBuilder setSubject(String subject) {
            IntentBuilder varB4EAC82CA7396A68D541C85D26508E83_1144793956 = null; 
            mIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
            varB4EAC82CA7396A68D541C85D26508E83_1144793956 = this;
            addTaint(subject.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1144793956.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1144793956;
            
            
            
        }

        
    }


    
    public static class IntentReader {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.200 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "B0D69375984D6EE7DC93AC12DB4DFC55")

        private Activity mActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.200 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.200 -0400", hash_original_field = "69D772FE63E594767F3D526E4183666C", hash_generated_field = "E9DB1E160A758DD2D7A97AC8EAD7032B")

        private String mCallingPackage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.200 -0400", hash_original_field = "579F6F4641F6E6419FFF278DEBF8E9BA", hash_generated_field = "9F2300B66972EC6EFB2EFE241B7A0E66")

        private ComponentName mCallingActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.200 -0400", hash_original_field = "A1ADF33EC233D9220AFA3F7B9CA06090", hash_generated_field = "E38B530386D6624B9CC752A26937D70B")

        private ArrayList<Uri> mStreams;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.200 -0400", hash_original_method = "33DC5300860410C275910F5653E8BC84", hash_generated_method = "FB5749427BB382C46398D39E46300D1A")
        private  IntentReader(Activity activity) {
            mActivity = activity;
            mIntent = activity.getIntent();
            mCallingPackage = ShareCompat.getCallingPackage(activity);
            mCallingActivity = ShareCompat.getCallingActivity(activity);
            
            
            
            
            
        }

        
                public static IntentReader from(Activity activity) {
            return new IntentReader(activity);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.201 -0400", hash_original_method = "A707037246F5733C08453D3B682DF768", hash_generated_method = "5FB04032815FA7A54DFEEB1DC191FAE3")
        public boolean isShareIntent() {
            final String action = mIntent.getAction();
            boolean var6199C70CF17ED50D954A70C090A4DC62_765240115 = (action.equals(Intent.ACTION_SEND) || action.equals(Intent.ACTION_SEND_MULTIPLE));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1810106078 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1810106078;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.202 -0400", hash_original_method = "BFA6AA7528AA5BB107B3B7EA24E49B64", hash_generated_method = "52CBF8BB9700B93C68A53398ABAC8F47")
        public boolean isSingleShare() {
            boolean var163FBD7B7485DF6491201565A1589C76_85269410 = (mIntent.getAction().equals(Intent.ACTION_SEND));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_677008214 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_677008214;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.202 -0400", hash_original_method = "61DADC6D6F65F3016BDEF2AAD1D3A3F0", hash_generated_method = "85B7BD34F0E1DEC3A12E7226C3FB511A")
        public boolean isMultipleShare() {
            boolean var8AA762653092B3F38E8AE23B1AB05044_1753438440 = (mIntent.getAction().equals(Intent.ACTION_SEND_MULTIPLE));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1322588732 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1322588732;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.204 -0400", hash_original_method = "D2D116B363ACAF23E5ABAEA8317A2D07", hash_generated_method = "3CD60D14EA9AB5CD5E8DF6C5D9489A6F")
        public String getType() {
            String varB4EAC82CA7396A68D541C85D26508E83_318475690 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_318475690 = mIntent.getType();
            varB4EAC82CA7396A68D541C85D26508E83_318475690.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_318475690;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.205 -0400", hash_original_method = "001799CDC7AD568A5D9791D68F82B19E", hash_generated_method = "DC52F67D86B325F344DE382BADFE7557")
        public CharSequence getText() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_838656272 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_838656272 = mIntent.getCharSequenceExtra(Intent.EXTRA_TEXT);
            varB4EAC82CA7396A68D541C85D26508E83_838656272.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_838656272;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.206 -0400", hash_original_method = "6766C6C36607D95201A80937E1C93C5B", hash_generated_method = "554F7CE40726B255CCE6E4B67B08F3E7")
        public Uri getStream() {
            Uri varB4EAC82CA7396A68D541C85D26508E83_1857103562 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1857103562 = mIntent.getParcelableExtra(Intent.EXTRA_STREAM);
            varB4EAC82CA7396A68D541C85D26508E83_1857103562.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1857103562;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.207 -0400", hash_original_method = "CA16C800A8BACDD493D26B5DCB8F6704", hash_generated_method = "ED64F459B6C200E3F17A92EC5C864EA4")
        public Uri getStream(int index) {
            Uri varB4EAC82CA7396A68D541C85D26508E83_1162469898 = null; 
            Uri varB4EAC82CA7396A68D541C85D26508E83_205464798 = null; 
            {
                boolean varAA8C0850796E27ECE01A9205830925C9_1288841299 = (mStreams == null && isMultipleShare());
                {
                    mStreams = mIntent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
                } 
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1162469898 = mStreams.get(index);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_205464798 = mIntent.getParcelableExtra(Intent.EXTRA_STREAM);
            } 
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() +
                    " index requested: " + index);
            addTaint(index);
            Uri varA7E53CE21691AB073D9660D615818899_1200325558; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1200325558 = varB4EAC82CA7396A68D541C85D26508E83_1162469898;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1200325558 = varB4EAC82CA7396A68D541C85D26508E83_205464798;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1200325558.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1200325558;
            
            
                
            
            
                
            
            
                
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.208 -0400", hash_original_method = "BC61684682118C8B50538A4E9628C32B", hash_generated_method = "3C61405494B764492D79FFA8B8FC95E6")
        public int getStreamCount() {
            {
                boolean varAA8C0850796E27ECE01A9205830925C9_48841898 = (mStreams == null && isMultipleShare());
                {
                    mStreams = mIntent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
                } 
            } 
            {
                int varD4374328095A9182E73BED2B4E112D5C_1434044495 = (mStreams.size());
            } 
            {
                boolean var19EBAAC96567DABF4F39A6F661817952_552865182 = (mIntent.hasExtra(Intent.EXTRA_STREAM));
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878786727 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878786727;
            
            
                
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.209 -0400", hash_original_method = "D1879246F5FB4411F3E91A8AEB3C384C", hash_generated_method = "A2650E3D5DDF06330E858C7584E72CA8")
        public String[] getEmailTo() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_833932009 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_833932009 = mIntent.getStringArrayExtra(Intent.EXTRA_EMAIL);
            varB4EAC82CA7396A68D541C85D26508E83_833932009.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_833932009;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.210 -0400", hash_original_method = "F2F2C05F2171316000FF1516A5D8CD3A", hash_generated_method = "976CEBE1EC58A957E248FEC0D168BE3A")
        public String[] getEmailCc() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_1656059322 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1656059322 = mIntent.getStringArrayExtra(Intent.EXTRA_CC);
            varB4EAC82CA7396A68D541C85D26508E83_1656059322.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1656059322;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.210 -0400", hash_original_method = "8B48BB50B06FCBCC280D77A42BA7B009", hash_generated_method = "73C788A13E00B08B87F9E7C063A833FF")
        public String[] getEmailBcc() {
            String[] varB4EAC82CA7396A68D541C85D26508E83_1387853362 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1387853362 = mIntent.getStringArrayExtra(Intent.EXTRA_BCC);
            varB4EAC82CA7396A68D541C85D26508E83_1387853362.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1387853362;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.211 -0400", hash_original_method = "1E0DCEAE4F7F7EF81C98D4CC969955D0", hash_generated_method = "529CDBE8C0D3448B1785022439CB6D80")
        public String getSubject() {
            String varB4EAC82CA7396A68D541C85D26508E83_1063436602 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1063436602 = mIntent.getStringExtra(Intent.EXTRA_SUBJECT);
            varB4EAC82CA7396A68D541C85D26508E83_1063436602.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1063436602;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.212 -0400", hash_original_method = "599A2909147C5ABF7649B275042032E0", hash_generated_method = "1A774269C44B83AE59A4AC1B35A2FCE2")
        public String getCallingPackage() {
            String varB4EAC82CA7396A68D541C85D26508E83_1689039019 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1689039019 = mCallingPackage;
            varB4EAC82CA7396A68D541C85D26508E83_1689039019.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1689039019;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.213 -0400", hash_original_method = "7754B7141829C06037743B2AEFCB8100", hash_generated_method = "5A80457DE0A37285C92F83B2C3D69BC5")
        public ComponentName getCallingActivity() {
            ComponentName varB4EAC82CA7396A68D541C85D26508E83_978483958 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_978483958 = mCallingActivity;
            varB4EAC82CA7396A68D541C85D26508E83_978483958.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_978483958;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.214 -0400", hash_original_method = "DF0726DEBD67610C86B101B05D0C636E", hash_generated_method = "66F0D4EC472A3F8B9093570A15499089")
        public Drawable getCallingActivityIcon() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1858726983 = null; 
            Drawable varB4EAC82CA7396A68D541C85D26508E83_531054472 = null; 
            Drawable varB4EAC82CA7396A68D541C85D26508E83_789699527 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1858726983 = null;
            PackageManager pm = mActivity.getPackageManager();
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_531054472 = pm.getActivityIcon(mCallingActivity);
            } 
            catch (NameNotFoundException e)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_789699527 = null;
            Drawable varA7E53CE21691AB073D9660D615818899_1282462784; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1282462784 = varB4EAC82CA7396A68D541C85D26508E83_1858726983;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_1282462784 = varB4EAC82CA7396A68D541C85D26508E83_531054472;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1282462784 = varB4EAC82CA7396A68D541C85D26508E83_789699527;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1282462784.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1282462784;
            
            
            
            
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.215 -0400", hash_original_method = "CF72ECE57DC07F413BA6AAECB91EABC0", hash_generated_method = "C68F8E3C1B50F06A4F92F592DE7056AC")
        public Drawable getCallingApplicationIcon() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_107052907 = null; 
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1687670331 = null; 
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1785340625 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_107052907 = null;
            PackageManager pm = mActivity.getPackageManager();
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1687670331 = pm.getApplicationIcon(mCallingPackage);
            } 
            catch (NameNotFoundException e)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_1785340625 = null;
            Drawable varA7E53CE21691AB073D9660D615818899_1026879961; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1026879961 = varB4EAC82CA7396A68D541C85D26508E83_107052907;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_1026879961 = varB4EAC82CA7396A68D541C85D26508E83_1687670331;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1026879961 = varB4EAC82CA7396A68D541C85D26508E83_1785340625;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1026879961.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1026879961;
            
            
            
            
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.216 -0400", hash_original_method = "F45DE27FE2614ABFE05276FFE92A1DFC", hash_generated_method = "EAB46FF7F8E156326F06BB5EB7C3AC59")
        public CharSequence getCallingApplicationLabel() {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1428774399 = null; 
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_986456394 = null; 
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1361535060 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1428774399 = null;
            PackageManager pm = mActivity.getPackageManager();
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_986456394 = pm.getApplicationLabel(pm.getApplicationInfo(mCallingPackage, 0));
            } 
            catch (NameNotFoundException e)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_1361535060 = null;
            CharSequence varA7E53CE21691AB073D9660D615818899_77135880; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_77135880 = varB4EAC82CA7396A68D541C85D26508E83_1428774399;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_77135880 = varB4EAC82CA7396A68D541C85D26508E83_986456394;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_77135880 = varB4EAC82CA7396A68D541C85D26508E83_1361535060;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_77135880.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_77135880;
            
            
            
            
                
            
                
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.216 -0400", hash_original_field = "C35FE37D3D68B7F50E5B47EFC8197FEA", hash_generated_field = "5A3BF8AAA19780B6501556BBCFA31BAF")

        private static final String TAG = "IntentReader";
    }


    
    interface ShareCompatImpl {
        void configureMenuItem(MenuItem item, IntentBuilder shareIntent);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.216 -0400", hash_original_field = "3F3D0310513A50B423661811647770EA", hash_generated_field = "F0F1884F3EDE30C05A70864F9C6AA85D")

    public static final String EXTRA_CALLING_PACKAGE =
            "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.216 -0400", hash_original_field = "B933FBCC6BBDB35CD9FC72DD4DA084BA", hash_generated_field = "162A2C12919BD466B3B854E7E2E5BA78")

    public static final String EXTRA_CALLING_ACTIVITY =
            "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.216 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "1BF51C8837B8F6C5C574D00A856658A9")

    private static ShareCompatImpl IMPL;
    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new ShareCompatImplICS();
        } else {
            IMPL = new ShareCompatImplBase();
        }
    }
    
}

