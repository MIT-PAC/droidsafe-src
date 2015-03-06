/* Licensed to the Apache Software Foundation (ASF) under one or more
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
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util.prefs;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * The default implementation of <code>AbstractPreferences</code> for the Linux
 * platform, using the file system as its back end.
 *
 * TODO some sync mechanism with backend, Performance - check file edit date
 *
 * @since 1.4
 */
class FilePreferencesImpl extends AbstractPreferences {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.009 -0400", hash_original_field = "153B3D9F8114A8267E6807316455E407", hash_generated_field = "5677F674611D0097D241A9264E817442")

    private static final String PREFS_FILE_NAME = "prefs.xml";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.009 -0400", hash_original_field = "5B02597BC59BCD7684434D71680904A0", hash_generated_field = "90EB38EE1D5D4498674BA72C3F00F4C8")

    private static String USER_HOME = System.getProperty("user.home") + "/.java/.userPrefs";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.010 -0400", hash_original_field = "103AA305024B9B33504D0A86CDB8CC08", hash_generated_field = "E1535B65DE339166145FA0167621A0F2")

    private static String SYSTEM_HOME = System.getProperty("java.home") + "/.systemPrefs";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.010 -0400", hash_original_field = "4936DBCD90EF1129A7D9F03C4DB55EE0", hash_generated_field = "E58B218DC2BC9CF2BD65F7BE2F7C20BE")

    private String path;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.010 -0400", hash_original_field = "8AE54FFE197E6B2FCD764A50DF7FE467", hash_generated_field = "B417080AA05C84DDF1847F4C83E8FE68")

    private Properties prefs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.011 -0400", hash_original_field = "363931C0E21C4FB17B9023590B613477", hash_generated_field = "E7CAF92B8920E9AEF2763506FEBAA4D7")

    private File prefsFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.011 -0400", hash_original_field = "421695F357218FBE2BC46B4B44995BB1", hash_generated_field = "ED268BD9803A59B4C078610852F3BDFB")

    private File dir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.011 -0400", hash_original_field = "1C6770FEF5ED00E18F2C03F467A1DDDE", hash_generated_field = "305186409D390F5160347677C0DDB7ED")

    private Set<String> removed = new HashSet<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.012 -0400", hash_original_field = "7352D0806AF61CEBEFE58F6EEEEAFED5", hash_generated_field = "73B6D83F7C74D2DE2E72882906B3F1FF")

    private Set<String> updated = new HashSet<String>();

    /*
     * --------------------------------------------------------------
     * Constructors
     * --------------------------------------------------------------
     */

    /**
     * Construct root <code>FilePreferencesImpl</code> instance, construct
     * user root if userNode is true, system root otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.012 -0400", hash_original_method = "7F6C6ED0BA74F98C262CDB8E4F5CCB65", hash_generated_method = "7F6C6ED0BA74F98C262CDB8E4F5CCB65")
    
FilePreferencesImpl(boolean userNode) {
        super(null, "");
        this.userNode = userNode;
        path = userNode ? USER_HOME : SYSTEM_HOME;
        initPrefs();
    }

    /**
     * Construct a prefs using given parent and given name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.013 -0400", hash_original_method = "F5A89712FE44235FF309DF1D852A3C79", hash_generated_method = "F881B3B6D3C6920B6F8E4CF715190243")
    
private FilePreferencesImpl(AbstractPreferences parent, String name) {
        super(parent, name);
        path = ((FilePreferencesImpl) parent).path + File.separator + name;
        initPrefs();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.013 -0400", hash_original_method = "AB30ED0F4494C64027D63A735646CAAE", hash_generated_method = "8F0A61AE4951B60DDF02A8EF21562B15")
    
private void initPrefs() {
        dir = new File(path);
        newNode = !dir.exists();
        prefsFile = new File(path + File.separator + PREFS_FILE_NAME);
        prefs = XMLParser.readXmlPreferences(prefsFile);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.015 -0400", hash_original_method = "9CB1AEDE19F74E0C38CED556BED53029", hash_generated_method = "43EA77866CF68646B958DF9962526970")
    
@Override
    protected String[] childrenNamesSpi() throws BackingStoreException {
        String[] names = dir.list(new FilenameFilter() {
            @DSSafe(DSCat.SAFE_LIST)
        public boolean accept(File parent, String name) {
                return new File(path + File.separator + name).isDirectory();
            }
        });
        if (names == null) {// file is not a directory, exception case
            throw new BackingStoreException("Cannot get child names for " + toString()
                    + " (path is " + path + ")");
        }
        return names;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.015 -0400", hash_original_method = "F1B982AB128922BC1655DB53B5AE75B9", hash_generated_method = "9B89C4358AF359DDF7E9B136D4D59D18")
    
@Override
    protected AbstractPreferences childSpi(String name) {
        FilePreferencesImpl child = new FilePreferencesImpl(this, name);
        return child;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.016 -0400", hash_original_method = "51D70912EACD6F0AE65F09BA87599F4F", hash_generated_method = "8E0D87FC3A567FF1279E0ABF6B1DB26E")
    
@Override
    protected void flushSpi() throws BackingStoreException {
        try {
            //if removed, return
            if(isRemoved()){
                return;
            }
            // reload
            Properties currentPrefs = XMLParser.readXmlPreferences(prefsFile);
            // merge
            Iterator<String> it = removed.iterator();
            while (it.hasNext()) {
                currentPrefs.remove(it.next());
            }
            removed.clear();
            it = updated.iterator();
            while (it.hasNext()) {
                Object key = it.next();
                currentPrefs.put(key, prefs.get(key));
            }
            updated.clear();
            // flush
            prefs = currentPrefs;
            XMLParser.writeXmlPreferences(prefsFile, prefs);
        } catch (Exception e) {
            throw new BackingStoreException(e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.017 -0400", hash_original_method = "DF986369C467394CEC7D07E3301E047F", hash_generated_method = "6B0DB1B7A1FC98FCA4C85E43BF4FA389")
    
@Override
    protected String getSpi(String key) {
        try {
            if (prefs == null) {
                prefs = XMLParser.readXmlPreferences(prefsFile);
            }
            return prefs.getProperty(key);
        } catch (Exception e) {
            // if Exception happened, return null
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.017 -0400", hash_original_method = "2BADA2732950068F6C66E78A2680C4C3", hash_generated_method = "076CE2CE0CEBAFC8DFD6DA99A1AB071F")
    
@Override
    protected String[] keysSpi() throws BackingStoreException {
        final Set<Object> ks = prefs.keySet();
        return ks.toArray(new String[ks.size()]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.017 -0400", hash_original_method = "5E6352C577EA8D8166F88B34BB27EEA6", hash_generated_method = "7036074362168F2F4354F8B07BAE66C6")
    
@Override
    protected void putSpi(String name, String value) {
        prefs.setProperty(name, value);
        updated.add(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.018 -0400", hash_original_method = "2975E9823790A9357BBEB4A684D36F8E", hash_generated_method = "66DD9187F0D536A794C3B0CB7F7C6D4A")
    
@Override
    protected void removeNodeSpi() throws BackingStoreException {
        prefsFile.delete();
        boolean removeSucceed = dir.delete();
        if (!removeSucceed) {
            throw new BackingStoreException("Cannot remove " + toString());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.018 -0400", hash_original_method = "2A117B7C405C819FDE0C10B7F2EBBE56", hash_generated_method = "ABD4A7D6B9D7499B5D6E0F1A588431C8")
    
@Override
    protected void removeSpi(String key) {
        prefs.remove(key);
        updated.remove(key);
        removed.add(key);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.019 -0400", hash_original_method = "09F19E358D80524A9988B14995965FEE", hash_generated_method = "B6CCF131660594F6B8A2F31573231D55")
    
@Override
    protected void syncSpi() throws BackingStoreException {
        flushSpi();
    }
}
