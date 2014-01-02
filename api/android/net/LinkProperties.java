package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;





public class LinkProperties implements Parcelable {


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.187 -0400", hash_original_field = "AD9F190960A42BD6F0B1EE16B7E966B8", hash_generated_field = "24691869BF8BBA8F28BDB834441D45F0")

    public static final Creator<LinkProperties> CREATOR =
        new Creator<LinkProperties>() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.518 -0500", hash_original_method = "0C82553AE9182D627E9FE9D3BDCCC2D2", hash_generated_method = "73ADAD9054D4C55BEF76FD0090C4909B")
        
public LinkProperties createFromParcel(Parcel in) {
                LinkProperties netProp = new LinkProperties();
                String iface = in.readString();
                if (iface != null) {
                    try {
                        netProp.setInterfaceName(iface);
                    } catch (Exception e) {
                        return null;
                    }
                }
                int addressCount = in.readInt();
                for (int i=0; i<addressCount; i++) {
                    netProp.addLinkAddress((LinkAddress)in.readParcelable(null));
                }
                addressCount = in.readInt();
                for (int i=0; i<addressCount; i++) {
                    try {
                        netProp.addDns(InetAddress.getByAddress(in.createByteArray()));
                    } catch (UnknownHostException e) { }
                }
                addressCount = in.readInt();
                for (int i=0; i<addressCount; i++) {
                    netProp.addRoute((RouteInfo)in.readParcelable(null));
                }
                if (in.readByte() == 1) {
                    netProp.setHttpProxy((ProxyProperties)in.readParcelable(null));
                }
                return netProp;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.520 -0500", hash_original_method = "CDB87C960A6DC4E6DB35A27BB9B9B68F", hash_generated_method = "2595BCDCB12E6C56DC8D5A757B992D7E")
        
public LinkProperties[] newArray(int size) {
                return new LinkProperties[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.435 -0500", hash_original_field = "6D2C834A0EA52BA031060A9E0AEE620E", hash_generated_field = "6D2C834A0EA52BA031060A9E0AEE620E")


    String mIfaceName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.437 -0500", hash_original_field = "6771322879F7906B3F7AD27229E85E95", hash_generated_field = "00DE8BD688F501E4FB5528A63461C364")

    private Collection<LinkAddress> mLinkAddresses = new ArrayList<LinkAddress>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.439 -0500", hash_original_field = "BE1E21CA00574CBD39F3591A1D87BD6A", hash_generated_field = "D0EA13350ECE9796647D8145F3FB5864")

    private Collection<InetAddress> mDnses = new ArrayList<InetAddress>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.441 -0500", hash_original_field = "946036E13BB69BB1451D6BE1DA06D891", hash_generated_field = "2D860F9C91CB145D416269098C36EC63")

    private Collection<RouteInfo> mRoutes = new ArrayList<RouteInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.443 -0500", hash_original_field = "4E719299950CF94244CCFE78203C6044", hash_generated_field = "E6A788E6ED925BAD844282A07CD34FF9")

    private ProxyProperties mHttpProxy;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.455 -0500", hash_original_method = "A2AA1798C08A5590A3DB637A5B794F80", hash_generated_method = "273E9D346883D9675472869A1CFB54C7")
    
public LinkProperties() {
        clear();
    }

    // copy constructor instead of clone
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.457 -0500", hash_original_method = "836BF23A93C2D960D78EC02574131087", hash_generated_method = "DC603CE2D361847CBDF7DAD1AF94F91B")
    
public LinkProperties(LinkProperties source) {
        if (source != null) {
            mIfaceName = source.getInterfaceName();
            for (LinkAddress l : source.getLinkAddresses()) mLinkAddresses.add(l);
            for (InetAddress i : source.getDnses()) mDnses.add(i);
            for (RouteInfo r : source.getRoutes()) mRoutes.add(r);
            mHttpProxy = (source.getHttpProxy() == null)  ?
                null : new ProxyProperties(source.getHttpProxy());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.459 -0500", hash_original_method = "658C71C3CDAAE8BF2A6E808615EC0533", hash_generated_method = "9E31EF8211A677A87A678CA5988A8774")
    
public void setInterfaceName(String iface) {
        mIfaceName = iface;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.462 -0500", hash_original_method = "DE3FEB2907F1F43DDDDBA76FC2B5A592", hash_generated_method = "1DA011E06E890CC0B08EDA9D2E04B3A4")
    
public String getInterfaceName() {
        return mIfaceName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.464 -0500", hash_original_method = "873086E492F590532E0F956B14530004", hash_generated_method = "06EE9099A519E25577FA956415465BC4")
    
public Collection<InetAddress> getAddresses() {
        Collection<InetAddress> addresses = new ArrayList<InetAddress>();
        for (LinkAddress linkAddress : mLinkAddresses) {
            addresses.add(linkAddress.getAddress());
        }
        return Collections.unmodifiableCollection(addresses);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.466 -0500", hash_original_method = "1B49E50669A271748C7EE163D2678E87", hash_generated_method = "FE7793ED86C7AE16CC0DD250E5FE2132")
    
public void addLinkAddress(LinkAddress address) {
        if (address != null) mLinkAddresses.add(address);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.468 -0500", hash_original_method = "72D86E86409333B5516C160027F12741", hash_generated_method = "504621F62ACA4AD1A1978FBA0B60350C")
    
public Collection<LinkAddress> getLinkAddresses() {
        return Collections.unmodifiableCollection(mLinkAddresses);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.471 -0500", hash_original_method = "34CA5CC4558FA9428BD44173436D0F22", hash_generated_method = "15722046DBB980E2D6E3E5049673A8D0")
    
public void addDns(InetAddress dns) {
        if (dns != null) mDnses.add(dns);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.473 -0500", hash_original_method = "71F7664B03379576DA51ED6043500785", hash_generated_method = "4378836DA565501DC7A4094F3CC7B12F")
    
public Collection<InetAddress> getDnses() {
        return Collections.unmodifiableCollection(mDnses);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.475 -0500", hash_original_method = "D2F9F5371D010F9C9B4F83D9513356DD", hash_generated_method = "B735EDE00F4F810194A825136B361BDB")
    
public void addRoute(RouteInfo route) {
        if (route != null) mRoutes.add(route);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.477 -0500", hash_original_method = "A7B26240781BB7C0E135CB45CD0D9800", hash_generated_method = "7304006BADE7268B32CBBD8D9383478F")
    
public Collection<RouteInfo> getRoutes() {
        return Collections.unmodifiableCollection(mRoutes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.479 -0500", hash_original_method = "A3A7E4451F64D99820B4BAAEF1AFE8A2", hash_generated_method = "B85412645E94B83AD754D1A278F83151")
    
public void setHttpProxy(ProxyProperties proxy) {
        mHttpProxy = proxy;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.481 -0500", hash_original_method = "6E571D9EDF02B85B7F325367F981AC91", hash_generated_method = "7F76759BBD50EF4888FEB68C88524164")
    
public ProxyProperties getHttpProxy() {
        return mHttpProxy;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.483 -0500", hash_original_method = "4D86E4F145913ECB4C1EE8109466CAB3", hash_generated_method = "DC68CAADDB204F42E26E7DF6B0DA4E6B")
    
public void clear() {
        mIfaceName = null;
        mLinkAddresses.clear();
        mDnses.clear();
        mRoutes.clear();
        mHttpProxy = null;
    }

    /**
     * Implement the Parcelable interface
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.485 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.488 -0500", hash_original_method = "FDC9878366ECD283FC0D7411AB5ED4B7", hash_generated_method = "CB8B5B3966E651CD6858565AEC15B9EB")
    
@Override
    public String toString() {
        String ifaceName = (mIfaceName == null ? "" : "InterfaceName: " + mIfaceName + " ");

        String linkAddresses = "LinkAddresses: [";
        for (LinkAddress addr : mLinkAddresses) linkAddresses += addr.toString() + ",";
        linkAddresses += "] ";

        String dns = "DnsAddresses: [";
        for (InetAddress addr : mDnses) dns += addr.getHostAddress() + ",";
        dns += "] ";

        String routes = "Routes: [";
        for (RouteInfo route : mRoutes) routes += route.toString() + ",";
        routes += "] ";
        String proxy = (mHttpProxy == null ? "" : "HttpProxy: " + mHttpProxy.toString() + " ");

        return ifaceName + linkAddresses + routes + dns + proxy;
    }

    /**
     * Compares this {@code LinkProperties} interface name against the target
     *
     * @param target LinkProperties to compare.
     * @return {@code true} if both are identical, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.490 -0500", hash_original_method = "48DB33246C86C278D2BAD545A88B9470", hash_generated_method = "D9469B281020E2E1795932C840CDF1B5")
    
public boolean isIdenticalInterfaceName(LinkProperties target) {
        return TextUtils.equals(getInterfaceName(), target.getInterfaceName());
    }

    /**
     * Compares this {@code LinkProperties} interface name against the target
     *
     * @param target LinkProperties to compare.
     * @return {@code true} if both are identical, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.493 -0500", hash_original_method = "D0F0B04B5ACB5FD8D13B5B828D9A160C", hash_generated_method = "268F6231A8F0A6129B3538D3F23EE20A")
    
public boolean isIdenticalAddresses(LinkProperties target) {
        Collection<InetAddress> targetAddresses = target.getAddresses();
        Collection<InetAddress> sourceAddresses = getAddresses();
        return (sourceAddresses.size() == targetAddresses.size()) ?
                    sourceAddresses.containsAll(targetAddresses) : false;
    }

    /**
     * Compares this {@code LinkProperties} DNS addresses against the target
     *
     * @param target LinkProperties to compare.
     * @return {@code true} if both are identical, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.495 -0500", hash_original_method = "14A4F7F9C3E90075B30F314D9FCFE073", hash_generated_method = "B3E4B4C2915A0B0A44921E3167D5ED82")
    
public boolean isIdenticalDnses(LinkProperties target) {
        Collection<InetAddress> targetDnses = target.getDnses();
        return (mDnses.size() == targetDnses.size()) ?
                    mDnses.containsAll(targetDnses) : false;
    }

    /**
     * Compares this {@code LinkProperties} Routes against the target
     *
     * @param target LinkProperties to compare.
     * @return {@code true} if both are identical, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.497 -0500", hash_original_method = "3C11F6A9D4CB5E313FF4392D544C8E01", hash_generated_method = "1EF04BAF7D27B8D813EA6AEC52049622")
    
public boolean isIdenticalRoutes(LinkProperties target) {
        Collection<RouteInfo> targetRoutes = target.getRoutes();
        return (mRoutes.size() == targetRoutes.size()) ?
                    mRoutes.containsAll(targetRoutes) : false;
    }

    /**
     * Compares this {@code LinkProperties} HttpProxy against the target
     *
     * @param target LinkProperties to compare.
     * @return {@code true} if both are identical, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.499 -0500", hash_original_method = "DD4569AF6E08EF8065FD20A93C9D719F", hash_generated_method = "189B450091A1E07E23DBA469FAD1A074")
    
public boolean isIdenticalHttpProxy(LinkProperties target) {
        return getHttpProxy() == null ? target.getHttpProxy() == null :
                    getHttpProxy().equals(target.getHttpProxy());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.501 -0500", hash_original_method = "E1692DB8F3E9AF5A893AE4BBE4FFDED0", hash_generated_method = "61BC0309E108D787D5C7851F0F1D2231")
    
@Override
    /**
     * Compares this {@code LinkProperties} instance against the target
     * LinkProperties in {@code obj}. Two LinkPropertieses are equal if
     * all their fields are equal in values.
     *
     * For collection fields, such as mDnses, containsAll() is used to check
     * if two collections contains the same elements, independent of order.
     * There are two thoughts regarding containsAll()
     * 1. Duplicated elements. eg, (A, B, B) and (A, A, B) are equal.
     * 2. Worst case performance is O(n^2).
     *
     * @param obj the object to be tested for equality.
     * @return {@code true} if both objects are equal, {@code false} otherwise.
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof LinkProperties)) return false;

        LinkProperties target = (LinkProperties) obj;

        return isIdenticalInterfaceName(target) &&
                isIdenticalAddresses(target) &&
                isIdenticalDnses(target) &&
                isIdenticalRoutes(target) &&
                isIdenticalHttpProxy(target);
    }

    /**
     * Return two lists, a list of addresses that would be removed from
     * mLinkAddresses and a list of addresses that would be added to
     * mLinkAddress which would then result in target and mLinkAddresses
     * being the same list.
     *
     * @param target is a LinkProperties with the new list of addresses
     * @return the removed and added lists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.503 -0500", hash_original_method = "F16C063B63526E6739B6C0383B3231A3", hash_generated_method = "FE08B699DB8D449FC60F52DAEAA2D00B")
    
public CompareResult<LinkAddress> compareAddresses(LinkProperties target) {
        /*
         * Duplicate the LinkAddresses into removed, we will be removing
         * address which are common between mLinkAddresses and target
         * leaving the addresses that are different. And address which
         * are in target but not in mLinkAddresses are placed in the
         * addedAddresses.
         */
        CompareResult<LinkAddress> result = new CompareResult<LinkAddress>();
        result.removed = new ArrayList<LinkAddress>(mLinkAddresses);
        result.added.clear();
        if (target != null) {
            for (LinkAddress newAddress : target.getLinkAddresses()) {
                if (! result.removed.remove(newAddress)) {
                    result.added.add(newAddress);
                }
            }
        }
        return result;
    }

    /**
     * Return two lists, a list of dns addresses that would be removed from
     * mDnses and a list of addresses that would be added to
     * mDnses which would then result in target and mDnses
     * being the same list.
     *
     * @param target is a LinkProperties with the new list of dns addresses
     * @return the removed and added lists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.506 -0500", hash_original_method = "C56C38D458207E713A2F639173CF494C", hash_generated_method = "DE8BE02083584D99A675147A77CADEB0")
    
public CompareResult<InetAddress> compareDnses(LinkProperties target) {
        /*
         * Duplicate the InetAddresses into removed, we will be removing
         * dns address which are common between mDnses and target
         * leaving the addresses that are different. And dns address which
         * are in target but not in mDnses are placed in the
         * addedAddresses.
         */
        CompareResult<InetAddress> result = new CompareResult<InetAddress>();

        result.removed = new ArrayList<InetAddress>(mDnses);
        result.added.clear();
        if (target != null) {
            for (InetAddress newAddress : target.getDnses()) {
                if (! result.removed.remove(newAddress)) {
                    result.added.add(newAddress);
                }
            }
        }
        return result;
    }

    /**
     * Return two lists, a list of routes that would be removed from
     * mRoutes and a list of routes that would be added to
     * mRoutes which would then result in target and mRoutes
     * being the same list.
     *
     * @param target is a LinkProperties with the new list of routes
     * @return the removed and added lists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.509 -0500", hash_original_method = "39063DDD1454993D1B4985089C8FABB6", hash_generated_method = "B49EE5410036343C8449E147C7B09724")
    
public CompareResult<RouteInfo> compareRoutes(LinkProperties target) {
        /*
         * Duplicate the RouteInfos into removed, we will be removing
         * routes which are common between mDnses and target
         * leaving the routes that are different. And route address which
         * are in target but not in mRoutes are placed in added.
         */
        CompareResult<RouteInfo> result = new CompareResult<RouteInfo>();

        result.removed = new ArrayList<RouteInfo>(mRoutes);
        result.added.clear();
        if (target != null) {
            for (RouteInfo r : target.getRoutes()) {
                if (! result.removed.remove(r)) {
                    result.added.add(r);
                }
            }
        }
        return result;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.511 -0500", hash_original_method = "28ECE8095E829F4615B9B35514C29B36", hash_generated_method = "1267DE3E5DC0277251D36AC5E4F91E41")
    
@Override
    /**
     * generate hashcode based on significant fields
     * Equal objects must produce the same hash code, while unequal objects
     * may have the same hash codes.
     */
    public int hashCode() {
        return ((null == mIfaceName) ? 0 : mIfaceName.hashCode()
                + mLinkAddresses.size() * 31
                + mDnses.size() * 37
                + mRoutes.size() * 41
                + ((null == mHttpProxy) ? 0 : mHttpProxy.hashCode()));
    }

    
    public static class CompareResult<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.446 -0500", hash_original_field = "89FDD408958B41DE9635DC5B20E2173D", hash_generated_field = "656FE863E184B8E40AE962362C5E65EA")

        public Collection<T> removed = new ArrayList<T>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.448 -0500", hash_original_field = "619A39801BBD6D828D1655C096FF48F1", hash_generated_field = "C6B74BD881B85CA2CE669431297F84E6")

        public Collection<T> added = new ArrayList<T>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.187 -0400", hash_original_method = "8B9C887FE92C246DB85CDDBCEEBB2CF3", hash_generated_method = "8B9C887FE92C246DB85CDDBCEEBB2CF3")
        public CompareResult ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.451 -0500", hash_original_method = "432CBAB98383F022B31745E1B8881CF6", hash_generated_method = "B5502BEE6A700ED88BC2132DC0B2A5D1")
        
@Override
        public String toString() {
            String retVal = "removed=[";
            for (T addr : removed) retVal += addr.toString() + ",";
            retVal += "] added=[";
            for (T addr : added) retVal += addr.toString() + ",";
            retVal += "]";
            return retVal;
        }

        
    }

    /**
     * Implement the Parcelable interface.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:16.514 -0500", hash_original_method = "FA484CCA03B27F5C12EABAE629DE360A", hash_generated_method = "1F987581421EDEB082D3EE8ADDC317DA")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getInterfaceName());
        dest.writeInt(mLinkAddresses.size());
        for(LinkAddress linkAddress : mLinkAddresses) {
            dest.writeParcelable(linkAddress, flags);
        }

        dest.writeInt(mDnses.size());
        for(InetAddress d : mDnses) {
            dest.writeByteArray(d.getAddress());
        }

        dest.writeInt(mRoutes.size());
        for(RouteInfo route : mRoutes) {
            dest.writeParcelable(route, flags);
        }

        if (mHttpProxy != null) {
            dest.writeByte((byte)1);
            dest.writeParcelable(mHttpProxy, flags);
        } else {
            dest.writeByte((byte)0);
        }
    }
    // orphaned legacy method
    public LinkProperties createFromParcel(Parcel in) {
                LinkProperties netProp = new LinkProperties();
                String iface = in.readString();
                if (iface != null) {
                    try {
                        netProp.setInterfaceName(iface);
                    } catch (Exception e) {
                        return null;
                    }
                }
                int addressCount = in.readInt();
                for (int i=0; i<addressCount; i++) {
                    netProp.addLinkAddress((LinkAddress)in.readParcelable(null));
                }
                addressCount = in.readInt();
                for (int i=0; i<addressCount; i++) {
                    try {
                        netProp.addDns(InetAddress.getByAddress(in.createByteArray()));
                    } catch (UnknownHostException e) { }
                }
                addressCount = in.readInt();
                for (int i=0; i<addressCount; i++) {
                    netProp.addRoute((RouteInfo)in.readParcelable(null));
                }
                if (in.readByte() == 1) {
                    netProp.setHttpProxy((ProxyProperties)in.readParcelable(null));
                }
                return netProp;
            }
    
    // orphaned legacy method
    public LinkProperties[] newArray(int size) {
                return new LinkProperties[size];
            }
    
}

