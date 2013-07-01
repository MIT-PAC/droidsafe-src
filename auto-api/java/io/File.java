package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import libcore.io.ErrnoException;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import libcore.io.StructStat;
import libcore.io.StructStatFs;
import org.apache.harmony.luni.util.DeleteOnExit;
import static libcore.io.OsConstants.*;

public class File implements Serializable, Comparable<File> {
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.825 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "E58B218DC2BC9CF2BD65F7BE2F7C20BE")
	private String path;

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.826 -0400", hash_original_method = "A8210D76C41C6A4AAFC6BE2371A42886", hash_generated_method = "E550E6CD140886FB69160E8A05F219F7")
	public File(File dir, String name) {
		this(dir == null ? null : dir.getPath(), name);
		addTaint(dir.getTaint());
		addTaint(name.getTaint());
		// ---------- Original Method ----------
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.826 -0400", hash_original_method = "2175D562A2B588CC53D616403013683C", hash_generated_method = "F0CF2469DAAFA8B053A90565BD5CE965")
	public File(String path) {
		this.path = fixSlashes(path);
		// ---------- Original Method ----------
		// this.path = fixSlashes(path);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.826 -0400", hash_original_method = "133C96EC98AEE8D59630F091A182C267", hash_generated_method = "5041BF576B322DA3A79796DBDACDE73F")
	public File(String dirPath, String name) {
		{
			if (DroidSafeAndroidRuntime.control)
				throw new NullPointerException();
		} // End block
		{
			boolean var522AFCE5CC8B40A2A75402BE5D6A8AB4_2056981148 = (dirPath == null || dirPath.isEmpty());
			{
				this.path = fixSlashes(name);
			} // End block
			{
				boolean varC45442D5CAC21BA5127C6B3BB3F7C12C_1051957273 = (name.isEmpty());
				{
					this.path = fixSlashes(dirPath);
				} // End block
				{
					this.path = fixSlashes(join(dirPath, name));
				} // End block
			} // End collapsed parenthetic
		} // End collapsed parenthetic
			// ---------- Original Method ----------
			// if (name == null) {
			// throw new NullPointerException();
		// }
		// if (dirPath == null || dirPath.isEmpty()) {
		// this.path = fixSlashes(name);
		// } else if (name.isEmpty()) {
		// this.path = fixSlashes(dirPath);
		// } else {
		// this.path = fixSlashes(join(dirPath, name));
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.826 -0400", hash_original_method = "8BC21AA0285296D0787FE6CED7AAF58D", hash_generated_method = "79D164A841B35BD55411DA5A8905C5CC")
	public File(URI uri) {
		checkURI(uri);
		this.path = fixSlashes(uri.getPath());
		// ---------- Original Method ----------
		// checkURI(uri);
		// this.path = fixSlashes(uri.getPath());
	}

	private static String fixSlashes(String origPath) {
		boolean lastWasSlash = false;
		char[] newPath = origPath.toCharArray();
		int length = newPath.length;
		int newLength = 0;
		for (int i = 0; i < length; ++i) {
			char ch = newPath[i];
			if (ch == '/') {
				if (!lastWasSlash) {
					newPath[newLength++] = separatorChar;
					lastWasSlash = true;
				}
			} else {
				newPath[newLength++] = ch;
				lastWasSlash = false;
			}
		}
		if (lastWasSlash && newLength > 1) {
			newLength--;
		}
		return (newLength != length) ? new String(newPath, 0, newLength) : origPath;
	}

	private static String join(String prefix, String suffix) {
		int prefixLength = prefix.length();
		boolean haveSlash = (prefixLength > 0 && prefix.charAt(prefixLength - 1) == separatorChar);
		if (!haveSlash) {
			haveSlash = (suffix.length() > 0 && suffix.charAt(0) == separatorChar);
		}
		return haveSlash ? (prefix + suffix) : (prefix + separatorChar + suffix);
	}

	private static void checkURI(URI uri) {
		if (!uri.isAbsolute()) {
			throw new IllegalArgumentException("URI is not absolute: " + uri);
		} else if (!uri.getRawSchemeSpecificPart().startsWith("/")) {
			throw new IllegalArgumentException("URI is not hierarchical: " + uri);
		}
		if (!"file".equals(uri.getScheme())) {
			throw new IllegalArgumentException("Expected file scheme in URI: " + uri);
		}
		String rawPath = uri.getRawPath();
		if (rawPath == null || rawPath.isEmpty()) {
			throw new IllegalArgumentException("Expected non-empty path in URI: " + uri);
		}
		if (uri.getRawAuthority() != null) {
			throw new IllegalArgumentException("Found authority in URI: " + uri);
		}
		if (uri.getRawQuery() != null) {
			throw new IllegalArgumentException("Found query in URI: " + uri);
		}
		if (uri.getRawFragment() != null) {
			throw new IllegalArgumentException("Found fragment in URI: " + uri);
		}
	}

	public static File[] listRoots() {
		return new File[] { new File("/") };
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.828 -0400", hash_original_method = "69AF6799D7AA8E2E8441037938ACC088", hash_generated_method = "6AC3EF8501EAB1604E0F26A8CF2C04E7")
	public boolean canExecute() {
		boolean var11EACB11BCA61ED56E96A87B0CEEC84B_928601466 = (doAccess(X_OK));
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_244822216 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_244822216;
		// ---------- Original Method ----------
		// return doAccess(X_OK);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.828 -0400", hash_original_method = "7B792954ECFC131D8AE4D0E193C4885E", hash_generated_method = "0FD64682FCDAF02F502AB367ABE3D8FF")
	public boolean canRead() {
		boolean varE70EB23F73ADA6B237B4D65AC4B82C5A_1737164597 = (doAccess(R_OK));
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_76800950 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_76800950;
		// ---------- Original Method ----------
		// return doAccess(R_OK);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.828 -0400", hash_original_method = "80B9F14946D459E582021E9E2F6280AD", hash_generated_method = "D94CE4F53B82F54C9AC76890B6B01BA4")
	public boolean canWrite() {
		boolean varDA123BCACBFFAE09BFEC6AFFB499FD36_1746119130 = (doAccess(W_OK));
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_866918704 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_866918704;
		// ---------- Original Method ----------
		// return doAccess(W_OK);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.829 -0400", hash_original_method = "66AEEE703F2A5FBBF7F14BCD3C8F63B9", hash_generated_method = "854A48E4A5F89B648ABB79543CC8E155")
	private boolean doAccess(int mode) {
		try {
			boolean varE1C8CEC7263488E3BB150496CD78C18E_663648735 = (Libcore.os.access(path, mode));
		} // End block
		catch (ErrnoException errnoException) {
		}
		addTaint(mode);
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1498005536 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1498005536;
		// ---------- Original Method ----------
		// try {
		// return Libcore.os.access(path, mode);
		// } catch (ErrnoException errnoException) {
		// return false;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.829 -0400", hash_original_method = "B9E553F90A7CDA44D1E185A0919015AC", hash_generated_method = "2F7BE8C1677F029B6B2D8878AC8B64B0")
	public int compareTo(File another) {
		int var6643EA56E785E991D6AF3A2A2A7F5979_1081625482 = (this.getPath().compareTo(another.getPath()));
		addTaint(another.getTaint());
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310852702 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310852702;
		// ---------- Original Method ----------
		// return this.getPath().compareTo(another.getPath());
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.829 -0400", hash_original_method = "5CDCBB522AFEF90E14CEC34C413E4DF5", hash_generated_method = "9416ADAC77E8CF9915E117D7CE34C920")
	public boolean delete() {
		try {
			Libcore.os.remove(path);
		} // End block
		catch (ErrnoException errnoException) {
		}
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1578768375 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1578768375;
		// ---------- Original Method ----------
		// try {
		// Libcore.os.remove(path);
		// return true;
		// } catch (ErrnoException errnoException) {
		// return false;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.830 -0400", hash_original_method = "CB1935EF5F2FD9C7C5DF0BCD9272AB92", hash_generated_method = "1DCAE6528A5E92D9050119D34A45FB7D")
	public void deleteOnExit() {
		DeleteOnExit.getInstance().addFile(getAbsolutePath());
		// ---------- Original Method ----------
		// DeleteOnExit.getInstance().addFile(getAbsolutePath());
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.830 -0400", hash_original_method = "CB9025D33A83838782FA748F5EB00F53", hash_generated_method = "6797E6EB93D1E6E3937D798AFA579DA7")
	@Override
	public boolean equals(Object obj) {
		boolean varCCDEE86E8E195B720CEBCF68075E8EAF_438045391 = (path.equals(((File) obj).getPath()));
		addTaint(obj.getTaint());
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1575899216 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1575899216;
		// ---------- Original Method ----------
		// if (!(obj instanceof File)) {
		// return false;
		// }
		// return path.equals(((File) obj).getPath());
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.830 -0400", hash_original_method = "D48176638CA08E926D8083B62CC7EB27", hash_generated_method = "32CCE8A429A461CB5AD60F0F920E142E")
	public boolean exists() {
		boolean var3DC7BE7F0FA842D88DF3FAB30F500134_1492928348 = (doAccess(F_OK));
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_25618198 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_25618198;
		// ---------- Original Method ----------
		// return doAccess(F_OK);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.831 -0400", hash_original_method = "8F2B41FC4DF09EBF8497AC74B170E125", hash_generated_method = "A6518841A4BC76A167B3DEA14485EA8A")
	public String getAbsolutePath() {
		String varB4EAC82CA7396A68D541C85D26508E83_1143635416 = null; // Variable
																		// for
																		// return
																		// #1
		String varB4EAC82CA7396A68D541C85D26508E83_453881605 = null; // Variable
																		// for
																		// return
																		// #2
		{
			boolean var40530E982042ED763A2119FF5384DF93_519384685 = (isAbsolute());
			{
				varB4EAC82CA7396A68D541C85D26508E83_1143635416 = path;
			} // End block
		} // End collapsed parenthetic
		String userDir = System.getProperty("user.dir");
		varB4EAC82CA7396A68D541C85D26508E83_453881605 = path.isEmpty() ? userDir : join(userDir, path);
		String varA7E53CE21691AB073D9660D615818899_1181023146; // Final return
																// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_1181023146 = varB4EAC82CA7396A68D541C85D26508E83_1143635416;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_1181023146 = varB4EAC82CA7396A68D541C85D26508E83_453881605;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_1181023146.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varA7E53CE21691AB073D9660D615818899_1181023146;
		// ---------- Original Method ----------
		// if (isAbsolute()) {
		// return path;
		// }
		// String userDir = System.getProperty("user.dir");
		// return path.isEmpty() ? userDir : join(userDir, path);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.831 -0400", hash_original_method = "C817D7800025B01E09F67B96128B6FD2", hash_generated_method = "33228C3B20BD56F35AC9FBAA8AD1AB82")
	public File getAbsoluteFile() {
		File varB4EAC82CA7396A68D541C85D26508E83_1765825895 = null; // Variable
																	// for
																	// return #1
		varB4EAC82CA7396A68D541C85D26508E83_1765825895 = new File(getAbsolutePath());
		varB4EAC82CA7396A68D541C85D26508E83_1765825895.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varB4EAC82CA7396A68D541C85D26508E83_1765825895;
		// ---------- Original Method ----------
		// return new File(getAbsolutePath());
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.832 -0400", hash_original_method = "2353D6268FF62C4AA3E4D2A85DA0DDFF", hash_generated_method = "124B21528ED93BBEDAFE2AA050D7DDA9")
	public String getCanonicalPath() throws IOException {
		String varB4EAC82CA7396A68D541C85D26508E83_1356843616 = null; // Variable
																		// for
																		// return
																		// #1
		varB4EAC82CA7396A68D541C85D26508E83_1356843616 = realpath(getAbsolutePath());
		varB4EAC82CA7396A68D541C85D26508E83_1356843616.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varB4EAC82CA7396A68D541C85D26508E83_1356843616;
		// ---------- Original Method ----------
		// return realpath(getAbsolutePath());
	}

	private static String realpath(String path) {
		return new String();
	}

	private static String readlink(String path) {
		return new String();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.834 -0400", hash_original_method = "703FA6965000EF35DC5F6EF68FCCB383", hash_generated_method = "EA87694E67F19D1B14E110DF1B5A1140")
	public File getCanonicalFile() throws IOException {
		File varB4EAC82CA7396A68D541C85D26508E83_1782496204 = null; // Variable
																	// for
																	// return #1
		varB4EAC82CA7396A68D541C85D26508E83_1782496204 = new File(getCanonicalPath());
		varB4EAC82CA7396A68D541C85D26508E83_1782496204.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varB4EAC82CA7396A68D541C85D26508E83_1782496204;
		// ---------- Original Method ----------
		// return new File(getCanonicalPath());
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.835 -0400", hash_original_method = "6E20F332F3C7773E9502AE9F2437B5A6", hash_generated_method = "D19F5894B8DFC9ACC108120D30093529")
	public String getName() {
		String varB4EAC82CA7396A68D541C85D26508E83_2111632190 = null; // Variable
																		// for
																		// return
																		// #1
		int separatorIndex = path.lastIndexOf(separator);
		varB4EAC82CA7396A68D541C85D26508E83_2111632190 = (separatorIndex < 0) ? path : path.substring(separatorIndex + 1, path.length());
		varB4EAC82CA7396A68D541C85D26508E83_2111632190.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varB4EAC82CA7396A68D541C85D26508E83_2111632190;
		// ---------- Original Method ----------
		// int separatorIndex = path.lastIndexOf(separator);
		// return (separatorIndex < 0) ? path : path.substring(separatorIndex +
		// 1, path.length());
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.836 -0400", hash_original_method = "160BE3FD42E1931950E2200B6303D787", hash_generated_method = "D1D67F83A9F83744618D035FA1C164AD")
	public String getParent() {
		String varB4EAC82CA7396A68D541C85D26508E83_899408920 = null; // Variable
																		// for
																		// return
																		// #1
		String varB4EAC82CA7396A68D541C85D26508E83_89785682 = null; // Variable
																	// for
																	// return #2
		String varB4EAC82CA7396A68D541C85D26508E83_1543315943 = null; // Variable
																		// for
																		// return
																		// #3
		int length = path.length();
		int firstInPath = 0;
		{
			boolean var863DBDB94E3E0C1E688E23D6337C055A_1551561000 = (separatorChar == '\\' && length > 2 && path.charAt(1) == ':');
			{
				firstInPath = 2;
			} // End block
		} // End collapsed parenthetic
		int index = path.lastIndexOf(separatorChar);
		{
			index = 2;
		} // End block
		{
			boolean var5FAB5682D222D850607AC8A1318BB400_628864087 = (index == -1 || path.charAt(length - 1) == separatorChar);
			{
				varB4EAC82CA7396A68D541C85D26508E83_899408920 = null;
			} // End block
		} // End collapsed parenthetic
		{
			boolean var343245EEE7F8E8A5D373797FE3BDF63A_297361294 = (path.indexOf(separatorChar) == index && path.charAt(firstInPath) == separatorChar);
			{
				varB4EAC82CA7396A68D541C85D26508E83_89785682 = path.substring(0, index + 1);
			} // End block
		} // End collapsed parenthetic
		varB4EAC82CA7396A68D541C85D26508E83_1543315943 = path.substring(0, index);
		String varA7E53CE21691AB073D9660D615818899_987159626; // Final return
																// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_987159626 = varB4EAC82CA7396A68D541C85D26508E83_899408920;
			break;
		case 2: // Assign result for return ordinal #2
			varA7E53CE21691AB073D9660D615818899_987159626 = varB4EAC82CA7396A68D541C85D26508E83_89785682;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_987159626 = varB4EAC82CA7396A68D541C85D26508E83_1543315943;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_987159626.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varA7E53CE21691AB073D9660D615818899_987159626;
		// ---------- Original Method ----------
		// int length = path.length(), firstInPath = 0;
		// if (separatorChar == '\\' && length > 2 && path.charAt(1) == ':') {
		// firstInPath = 2;
		// }
		// int index = path.lastIndexOf(separatorChar);
		// if (index == -1 && firstInPath > 0) {
		// index = 2;
		// }
		// if (index == -1 || path.charAt(length - 1) == separatorChar) {
		// return null;
		// }
		// if (path.indexOf(separatorChar) == index
		// && path.charAt(firstInPath) == separatorChar) {
		// return path.substring(0, index + 1);
		// }
		// return path.substring(0, index);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.837 -0400", hash_original_method = "05B6D7D4A7E04D12316D2DAB95CF61C6", hash_generated_method = "C929AB0D1ABA012A0D4CC39BBDA7AF58")
	public File getParentFile() {
		File varB4EAC82CA7396A68D541C85D26508E83_629168564 = null; // Variable
																	// for
																	// return #1
		File varB4EAC82CA7396A68D541C85D26508E83_1795406723 = null; // Variable
																	// for
																	// return #2
		String tempParent = getParent();
		{
			varB4EAC82CA7396A68D541C85D26508E83_629168564 = null;
		} // End block
		varB4EAC82CA7396A68D541C85D26508E83_1795406723 = new File(tempParent);
		File varA7E53CE21691AB073D9660D615818899_1793419931; // Final return
																// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_1793419931 = varB4EAC82CA7396A68D541C85D26508E83_629168564;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_1793419931 = varB4EAC82CA7396A68D541C85D26508E83_1795406723;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_1793419931.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varA7E53CE21691AB073D9660D615818899_1793419931;
		// ---------- Original Method ----------
		// String tempParent = getParent();
		// if (tempParent == null) {
		// return null;
		// }
		// return new File(tempParent);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.839 -0400", hash_original_method = "F862A3BA81BCB206C83E79C3BEB01336", hash_generated_method = "6D78852A968D972C0D68D3EB6169D447")
	public String getPath() {
		String varB4EAC82CA7396A68D541C85D26508E83_1141077551 = null; // Variable
																		// for
																		// return
																		// #1
		varB4EAC82CA7396A68D541C85D26508E83_1141077551 = path;
		varB4EAC82CA7396A68D541C85D26508E83_1141077551.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varB4EAC82CA7396A68D541C85D26508E83_1141077551;
		// ---------- Original Method ----------
		// return path;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.839 -0400", hash_original_method = "9D3CBE29781C2664F4636CCC28F83B76", hash_generated_method = "926294C09AA862932571ACE9F2948222")
	@Override
	public int hashCode() {
		int var4C9E48E0C9F3F2F1C840C74BEE9A825F_372268255 = (getPath().hashCode() ^ 1234321);
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1435560665 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1435560665;
		// ---------- Original Method ----------
		// return getPath().hashCode() ^ 1234321;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.841 -0400", hash_original_method = "9F2931F68825A4578F9E89212BCAE059", hash_generated_method = "B87BE9650374656F8B6E14A1D66CCDA8")
	public boolean isAbsolute() {
		boolean varDB79D8CAC4C2DC7A32AE3E7DAD7DA818_31422191 = (path.length() > 0 && path.charAt(0) == separatorChar);
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1364519452 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1364519452;
		// ---------- Original Method ----------
		// return path.length() > 0 && path.charAt(0) == separatorChar;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.843 -0400", hash_original_method = "5A1A5CA8E31989238D097F162F5C184C", hash_generated_method = "515F3B812A640346AA5D271E58627EFB")
	public boolean isDirectory() {
		try {
			boolean var6AC74137E657BFBDC734D05A25089622_1472878698 = (S_ISDIR(Libcore.os.stat(path).st_mode));
		} // End block
		catch (ErrnoException errnoException) {
		}
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1499096357 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1499096357;
		// ---------- Original Method ----------
		// try {
		// return S_ISDIR(Libcore.os.stat(path).st_mode);
		// } catch (ErrnoException errnoException) {
		// return false;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.844 -0400", hash_original_method = "B5DE2229663641D636EF433E62C83E7A", hash_generated_method = "FFCBD8116DCCE641D7B003AA8849BDA6")
	public boolean isFile() {
		try {
			boolean var14FAC7C6C345F2015B4501A8E995DD2F_278105405 = (S_ISREG(Libcore.os.stat(path).st_mode));
		} // End block
		catch (ErrnoException errnoException) {
		}
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_301947574 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_301947574;
		// ---------- Original Method ----------
		// try {
		// return S_ISREG(Libcore.os.stat(path).st_mode);
		// } catch (ErrnoException errnoException) {
		// return false;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.846 -0400", hash_original_method = "8D5680EC06296245D4F0DE9A90486B91", hash_generated_method = "28063CFA6E5EB3D1866D6F412642DAB2")
	public boolean isHidden() {
		{
			boolean varA747A2DF3E8CB4EAF5D9CDB3DF3D81CE_679372624 = (path.isEmpty());
		} // End collapsed parenthetic
		boolean varECBEA0E755D64DBD137B22ECA70830D2_273057010 = (getName().startsWith("."));
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1626862674 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1626862674;
		// ---------- Original Method ----------
		// if (path.isEmpty()) {
		// return false;
		// }
		// return getName().startsWith(".");
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.862 -0400", hash_original_method = "0921E33485CFCA34C1412D0CC74585F6", hash_generated_method = "A37E35BE97D2D3A3B29B6515D6F6F519")
	public long lastModified() {
		try {
			long var98E9A747C7267ABB1ADEE4EE0674948C_1369717987 = (Libcore.os.stat(path).st_mtime * 1000L);
		} // End block
		catch (ErrnoException errnoException) {
		}
		long var0F5264038205EDFB1AC05FBB0E8C5E94_1669447326 = getTaintLong();
		return var0F5264038205EDFB1AC05FBB0E8C5E94_1669447326;
		// ---------- Original Method ----------
		// try {
		// return Libcore.os.stat(path).st_mtime * 1000L;
		// } catch (ErrnoException errnoException) {
		// return 0;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.862 -0400", hash_original_method = "9B75702C13A04EF9D2AD1E246C28DD45", hash_generated_method = "A6BE6FB034FD84B3FA0BF17E63EFEB39")
	public boolean setLastModified(long time) {
		{
			if (DroidSafeAndroidRuntime.control)
				throw new IllegalArgumentException("time < 0");
		} // End block
		boolean varC4720CBC7FAA490EA21CC63802D3E053_2146777869 = (setLastModifiedImpl(path, time));
		addTaint(time);
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_564746085 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_564746085;
		// ---------- Original Method ----------
		// if (time < 0) {
		// throw new IllegalArgumentException("time < 0");
		// }
		// return setLastModifiedImpl(path, time);
	}

	private static boolean setLastModifiedImpl(String path, long time) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_916883677 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_916883677;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.863 -0400", hash_original_method = "A10D7182120D225C8A5565403EC4EFFE", hash_generated_method = "E393EB7266E1EA2BD63AE76EC0D0C754")
	public boolean setReadOnly() {
		boolean var2207B650E4763A2B2533AEE20A1ED73D_700606049 = (setWritable(false, false));
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_80210833 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_80210833;
		// ---------- Original Method ----------
		// return setWritable(false, false);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.863 -0400", hash_original_method = "6BD52A034BD79C942DD6922B1E4C88BF", hash_generated_method = "C96EE207B0282275F85D8F1D17F2FC2F")
	public boolean setExecutable(boolean executable, boolean ownerOnly) {
		boolean varE7D48606C7C85663E76F2F7A25E0A393_460219667 = (doChmod(ownerOnly ? S_IXUSR : (S_IXUSR | S_IXGRP | S_IXOTH), executable)); // DSFIXME:
																																			// CODE0008:
																																			// Nested
																																			// ternary
																																			// operator
																																			// in
																																			// expression
		addTaint(executable);
		addTaint(ownerOnly);
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_185182863 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_185182863;
		// ---------- Original Method ----------
		// return doChmod(ownerOnly ? S_IXUSR : (S_IXUSR | S_IXGRP | S_IXOTH),
		// executable);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.863 -0400", hash_original_method = "C14362B21605A10B0FC1769762B4B7C4", hash_generated_method = "46D59AC7330544741ED7332DD9DE38D1")
	public boolean setExecutable(boolean executable) {
		boolean varA4BAA13E37DA9069F7C7E719CB0FE8CC_246304127 = (setExecutable(executable, true));
		addTaint(executable);
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_833668632 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_833668632;
		// ---------- Original Method ----------
		// return setExecutable(executable, true);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.863 -0400", hash_original_method = "4618439ECB899A21431C9885F3874F0C", hash_generated_method = "5B4C2865655569B550CF925F42F4A256")
	public boolean setReadable(boolean readable, boolean ownerOnly) {
		boolean var5C11E9C261FABB343952CE11090CFB2B_1821085681 = (doChmod(ownerOnly ? S_IRUSR : (S_IRUSR | S_IRGRP | S_IROTH), readable)); // DSFIXME:
																																			// CODE0008:
																																			// Nested
																																			// ternary
																																			// operator
																																			// in
																																			// expression
		addTaint(readable);
		addTaint(ownerOnly);
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2084626316 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_2084626316;
		// ---------- Original Method ----------
		// return doChmod(ownerOnly ? S_IRUSR : (S_IRUSR | S_IRGRP | S_IROTH),
		// readable);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.864 -0400", hash_original_method = "25CECE784879D9A6F63C12E2E495084D", hash_generated_method = "FCB8618B0A878D04593F4F843814B5EC")
	public boolean setReadable(boolean readable) {
		boolean var1EB034476AE7B9DE3A44A8EDA359DB4A_660351364 = (setReadable(readable, true));
		addTaint(readable);
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_950159924 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_950159924;
		// ---------- Original Method ----------
		// return setReadable(readable, true);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.864 -0400", hash_original_method = "C7C84CA2ADD923BB8D9E9EBE2B4AA50C", hash_generated_method = "405D55D498BA81446DE5A90B4ED9A45C")
	public boolean setWritable(boolean writable, boolean ownerOnly) {
		boolean var2B456D826A2D8464A1C5648BA8B179E5_1225596398 = (doChmod(ownerOnly ? S_IWUSR : (S_IWUSR | S_IWGRP | S_IWOTH), writable)); // DSFIXME:
																																			// CODE0008:
																																			// Nested
																																			// ternary
																																			// operator
																																			// in
																																			// expression
		addTaint(writable);
		addTaint(ownerOnly);
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1398081984 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1398081984;
		// ---------- Original Method ----------
		// return doChmod(ownerOnly ? S_IWUSR : (S_IWUSR | S_IWGRP | S_IWOTH),
		// writable);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.864 -0400", hash_original_method = "0112F87387A0225E67147890BEDE5131", hash_generated_method = "F15E4D1BB546869A1BD59652BF907F9E")
	public boolean setWritable(boolean writable) {
		boolean var16EE60A060ACAE8B25D2293C6A6A7935_2079965094 = (setWritable(writable, true));
		addTaint(writable);
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1800475213 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1800475213;
		// ---------- Original Method ----------
		// return setWritable(writable, true);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.864 -0400", hash_original_method = "1AE2CD7860321C46BB79C9D3B3E6342E", hash_generated_method = "F2CE7724E8EB9CACEDFB88970EB6A002")
	private boolean doChmod(int mask, boolean set) {
		try {
			StructStat sb = Libcore.os.stat(path);
			int newMode;
			newMode = (sb.st_mode | mask);
			newMode = (sb.st_mode & ~mask);
			Libcore.os.chmod(path, newMode);
		} // End block
		catch (ErrnoException errnoException) {
		}
		addTaint(mask);
		addTaint(set);
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2046026851 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_2046026851;
		// ---------- Original Method ----------
		// try {
		// StructStat sb = Libcore.os.stat(path);
		// int newMode = set ? (sb.st_mode | mask) : (sb.st_mode & ~mask);
		// Libcore.os.chmod(path, newMode);
		// return true;
		// } catch (ErrnoException errnoException) {
		// return false;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.866 -0400", hash_original_method = "6E1602EC51AE975F6EDA687DC2872422", hash_generated_method = "21614DBB0A67BCF4130EB597AB91AC99")
	public long length() {
		try {
			long var9DB83E12CA4626330CD62F63533A5F87_1842384015 = (Libcore.os.stat(path).st_size);
		} // End block
		catch (ErrnoException errnoException) {
		}
		long var0F5264038205EDFB1AC05FBB0E8C5E94_1732628337 = getTaintLong();
		return var0F5264038205EDFB1AC05FBB0E8C5E94_1732628337;
		// ---------- Original Method ----------
		// try {
		// return Libcore.os.stat(path).st_size;
		// } catch (ErrnoException errnoException) {
		// return 0;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.867 -0400", hash_original_method = "DC3A6B837A6CEBDAA6FC05976EEFEE9C", hash_generated_method = "9CD788FAF1FED10747B6E7CA4AB2D615")
	public String[] list() {
		String[] varB4EAC82CA7396A68D541C85D26508E83_1579413058 = null; // Variable
																		// for
																		// return
																		// #1
		varB4EAC82CA7396A68D541C85D26508E83_1579413058 = listImpl(path);
		varB4EAC82CA7396A68D541C85D26508E83_1579413058.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varB4EAC82CA7396A68D541C85D26508E83_1579413058;
		// ---------- Original Method ----------
		// return listImpl(path);
	}

	private static String[] listImpl(String path) {
		return new String[0];
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.876 -0400", hash_original_method = "9DF6733463E25DE92688E347FBBAD22E", hash_generated_method = "26591FECE0C276CDA4885CFCC0B45B2D")
	public String[] list(FilenameFilter filter) {
		String[] varB4EAC82CA7396A68D541C85D26508E83_206840207 = null; // Variable
																		// for
																		// return
																		// #1
		String[] varB4EAC82CA7396A68D541C85D26508E83_1413445050 = null; // Variable
																		// for
																		// return
																		// #2
		String[] filenames = list();
		{
			varB4EAC82CA7396A68D541C85D26508E83_206840207 = filenames;
		} // End block
		List<String> result = new ArrayList<String>(filenames.length);
		{
			String filename = filenames[0];
			{
				{
					boolean var81601EE8E283E32D6B2251267018272D_1267568361 = (filter.accept(this, filename));
					{
						result.add(filename);
					} // End block
				} // End collapsed parenthetic
			} // End block
		} // End collapsed parenthetic
		varB4EAC82CA7396A68D541C85D26508E83_1413445050 = result.toArray(new String[result.size()]);
		addTaint(filter.getTaint());
		String[] varA7E53CE21691AB073D9660D615818899_923291513; // Final return
																// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_923291513 = varB4EAC82CA7396A68D541C85D26508E83_206840207;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_923291513 = varB4EAC82CA7396A68D541C85D26508E83_1413445050;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_923291513.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varA7E53CE21691AB073D9660D615818899_923291513;
		// ---------- Original Method ----------
		// String[] filenames = list();
		// if (filter == null || filenames == null) {
		// return filenames;
		// }
		// List<String> result = new ArrayList<String>(filenames.length);
		// for (String filename : filenames) {
		// if (filter.accept(this, filename)) {
		// result.add(filename);
		// }
		// }
		// return result.toArray(new String[result.size()]);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.878 -0400", hash_original_method = "9B953D65872590D8ABB7497D4B159A57", hash_generated_method = "39B22A19335CFC12FBEB1652C1556CC4")
	public File[] listFiles() {
		File[] varB4EAC82CA7396A68D541C85D26508E83_1819933153 = null; // Variable
																		// for
																		// return
																		// #1
		varB4EAC82CA7396A68D541C85D26508E83_1819933153 = filenamesToFiles(list());
		varB4EAC82CA7396A68D541C85D26508E83_1819933153.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varB4EAC82CA7396A68D541C85D26508E83_1819933153;
		// ---------- Original Method ----------
		// return filenamesToFiles(list());
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.879 -0400", hash_original_method = "94A37D22B56FB881F333055CF5969013", hash_generated_method = "5AAE2F57F828522E5E100CD51E103B01")
	public File[] listFiles(FilenameFilter filter) {
		File[] varB4EAC82CA7396A68D541C85D26508E83_218325788 = null; // Variable
																		// for
																		// return
																		// #1
		varB4EAC82CA7396A68D541C85D26508E83_218325788 = filenamesToFiles(list(filter));
		addTaint(filter.getTaint());
		varB4EAC82CA7396A68D541C85D26508E83_218325788.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varB4EAC82CA7396A68D541C85D26508E83_218325788;
		// ---------- Original Method ----------
		// return filenamesToFiles(list(filter));
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.901 -0400", hash_original_method = "1FB8ED2C60AA91150D4C3211C8CB2AD8", hash_generated_method = "3F2A991657FAB4976366900E71D786E5")
	public File[] listFiles(FileFilter filter) {
		File[] varB4EAC82CA7396A68D541C85D26508E83_173020781 = null; // Variable
																		// for
																		// return
																		// #1
		File[] varB4EAC82CA7396A68D541C85D26508E83_985945800 = null; // Variable
																		// for
																		// return
																		// #2
		File[] files = listFiles();
		{
			varB4EAC82CA7396A68D541C85D26508E83_173020781 = files;
		} // End block
		List<File> result = new ArrayList<File>(files.length);
		{
			File file = files[0];
			{
				{
					boolean var03D1D21AA056B6A17B9A8B3C581BEF3E_422000176 = (filter.accept(file));
					{
						result.add(file);
					} // End block
				} // End collapsed parenthetic
			} // End block
		} // End collapsed parenthetic
		varB4EAC82CA7396A68D541C85D26508E83_985945800 = result.toArray(new File[result.size()]);
		addTaint(filter.getTaint());
		File[] varA7E53CE21691AB073D9660D615818899_571167171; // Final return
																// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_571167171 = varB4EAC82CA7396A68D541C85D26508E83_173020781;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_571167171 = varB4EAC82CA7396A68D541C85D26508E83_985945800;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_571167171.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varA7E53CE21691AB073D9660D615818899_571167171;
		// ---------- Original Method ----------
		// File[] files = listFiles();
		// if (filter == null || files == null) {
		// return files;
		// }
		// List<File> result = new ArrayList<File>(files.length);
		// for (File file : files) {
		// if (filter.accept(file)) {
		// result.add(file);
		// }
		// }
		// return result.toArray(new File[result.size()]);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.902 -0400", hash_original_method = "7CC449D7C06EBE9C929936D878A8919D", hash_generated_method = "B957586D572D37674C09111F0CFFCE85")
	private File[] filenamesToFiles(String[] filenames) {
		File[] varB4EAC82CA7396A68D541C85D26508E83_460420354 = null; // Variable
																		// for
																		// return
																		// #1
		File[] varB4EAC82CA7396A68D541C85D26508E83_265116190 = null; // Variable
																		// for
																		// return
																		// #2
		{
			varB4EAC82CA7396A68D541C85D26508E83_460420354 = null;
		} // End block
		int count = filenames.length;
		File[] result = new File[count];
		{
			int i = 0;
			{
				result[i] = new File(this, filenames[i]);
			} // End block
		} // End collapsed parenthetic
		varB4EAC82CA7396A68D541C85D26508E83_265116190 = result;
		addTaint(filenames[0].getTaint());
		File[] varA7E53CE21691AB073D9660D615818899_1859312587; // Final return
																// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_1859312587 = varB4EAC82CA7396A68D541C85D26508E83_460420354;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_1859312587 = varB4EAC82CA7396A68D541C85D26508E83_265116190;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_1859312587.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varA7E53CE21691AB073D9660D615818899_1859312587;
		// ---------- Original Method ----------
		// if (filenames == null) {
		// return null;
		// }
		// int count = filenames.length;
		// File[] result = new File[count];
		// for (int i = 0; i < count; ++i) {
		// result[i] = new File(this, filenames[i]);
		// }
		// return result;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.902 -0400", hash_original_method = "9AA9A2328E77BE45E90F159A380326D5", hash_generated_method = "3829BE28FF6B51F230707CB33D09B443")
	public boolean mkdir() {
		try {
			Libcore.os.mkdir(path, S_IRWXU);
		} // End block
		catch (ErrnoException errnoException) {
		}
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1685570863 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1685570863;
		// ---------- Original Method ----------
		// try {
		// Libcore.os.mkdir(path, S_IRWXU);
		// return true;
		// } catch (ErrnoException errnoException) {
		// return false;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.902 -0400", hash_original_method = "0ED75208E22CDF6376FEADF6E55B44EF", hash_generated_method = "C126CEB9293CE729530DEED070FEC4DD")
	public boolean mkdirs() {
		{
			boolean varE013DE3A7A1EF9C151970630934B77B9_1813604622 = (exists());
		} // End collapsed parenthetic
		{
			boolean varAB3FB019EC81204DE93169D3E3914AF2_1330662750 = (mkdir());
		} // End collapsed parenthetic
		String parentDir = getParent();
		boolean var8762E100442E02162B81EA5619FDCADC_1790447031 = ((new File(parentDir).mkdirs() && mkdir()));
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_256983661 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_256983661;
		// ---------- Original Method ----------
		// if (exists()) {
		// return false;
		// }
		// if (mkdir()) {
		// return true;
		// }
		// String parentDir = getParent();
		// if (parentDir == null) {
		// return false;
		// }
		// return (new File(parentDir).mkdirs() && mkdir());
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.902 -0400", hash_original_method = "B6F8DC1B8131115DA0E4E46657B89E08", hash_generated_method = "3E5A81E57EBAD097D53F7EA959ABD408")
	public boolean createNewFile() throws IOException {
		FileDescriptor fd = null;
		try {
			fd = Libcore.os.open(path, O_RDWR | O_CREAT | O_EXCL, 0600);
		} // End block
		catch (ErrnoException errnoException) {
			if (DroidSafeAndroidRuntime.control)
				throw errnoException.rethrowAsIOException();
		} // End block
		finally {
			IoUtils.close(fd);
		} // End block
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1829750720 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1829750720;
		// ---------- Original Method ----------
		// FileDescriptor fd = null;
		// try {
		// fd = Libcore.os.open(path, O_RDWR | O_CREAT | O_EXCL, 0600);
		// return true;
		// } catch (ErrnoException errnoException) {
		// if (errnoException.errno == EEXIST) {
		// return false;
		// }
		// throw errnoException.rethrowAsIOException();
		// } finally {
		// IoUtils.close(fd);
		// }
	}

	public static File createTempFile(String prefix, String suffix) throws IOException {
		return createTempFile(prefix, suffix, null);
	}

	public static File createTempFile(String prefix, String suffix, File directory) throws IOException {
		if (prefix.length() < 3) {
			throw new IllegalArgumentException("prefix must be at least 3 characters");
		}
		if (suffix == null) {
			suffix = ".tmp";
		}
		File tmpDirFile = directory;
		if (tmpDirFile == null) {
			String tmpDir = System.getProperty("java.io.tmpdir", ".");
			tmpDirFile = new File(tmpDir);
		}
		File result;
		do {
			result = new File(tmpDirFile, prefix + tempFileRandom.nextInt() + suffix);
		} while (!result.createNewFile());
		return result;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.903 -0400", hash_original_method = "FDC5D6D625B3CE9B182F17F4E03581A9", hash_generated_method = "7D627EEDB652198B0BBB57332A2036D2")
	public boolean renameTo(File newPath) {
		try {
			Libcore.os.rename(path, newPath.path);
		} // End block
		catch (ErrnoException errnoException) {
		}
		addTaint(newPath.getTaint());
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_881867395 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_881867395;
		// ---------- Original Method ----------
		// try {
		// Libcore.os.rename(path, newPath.path);
		// return true;
		// } catch (ErrnoException errnoException) {
		// return false;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.903 -0400", hash_original_method = "2B0DBB93241DF37011E39BE4D10F6879", hash_generated_method = "F3C7AAD0E7C859A9F07F7B6C878A999F")
	@Override
	public String toString() {
		String varB4EAC82CA7396A68D541C85D26508E83_490867933 = null; // Variable
																		// for
																		// return
																		// #1
		varB4EAC82CA7396A68D541C85D26508E83_490867933 = path;
		varB4EAC82CA7396A68D541C85D26508E83_490867933.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varB4EAC82CA7396A68D541C85D26508E83_490867933;
		// ---------- Original Method ----------
		// return path;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.904 -0400", hash_original_method = "700C756497BE64476D6C692FA75956E5", hash_generated_method = "EC945AC40E9B48CB4370DC683EF1438D")
	public URI toURI() {
		URI varB4EAC82CA7396A68D541C85D26508E83_392482504 = null; // Variable
																	// for
																	// return #1
		URI varB4EAC82CA7396A68D541C85D26508E83_733799503 = null; // Variable
																	// for
																	// return #2
		URI varB4EAC82CA7396A68D541C85D26508E83_1817481357 = null; // Variable
																	// for
																	// return #3
		URI varB4EAC82CA7396A68D541C85D26508E83_1303876558 = null; // Variable
																	// for
																	// return #4
		String name = getAbsoluteName();
		try {
			{
				boolean var7CF5F60EBC5E2C901F827EF7830FC621_320908435 = (!name.startsWith("/"));
				{
					varB4EAC82CA7396A68D541C85D26508E83_392482504 = new URI("file", null, "/" + name, null, null);
				} // End block
				{
					boolean varE9B43904F9CC6A4F5AC7EEBE42EBAED2_2066825261 = (name.startsWith("//"));
					{
						varB4EAC82CA7396A68D541C85D26508E83_733799503 = new URI("file", "", name, null);
					} // End block
				} // End collapsed parenthetic
			} // End collapsed parenthetic
			varB4EAC82CA7396A68D541C85D26508E83_1817481357 = new URI("file", null, name, null, null);
		} // End block
		catch (URISyntaxException e) {
			varB4EAC82CA7396A68D541C85D26508E83_1303876558 = null;
		} // End block
		URI varA7E53CE21691AB073D9660D615818899_253097266; // Final return value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_253097266 = varB4EAC82CA7396A68D541C85D26508E83_392482504;
			break;
		case 2: // Assign result for return ordinal #2
			varA7E53CE21691AB073D9660D615818899_253097266 = varB4EAC82CA7396A68D541C85D26508E83_733799503;
			break;
		case 3: // Assign result for return ordinal #3
			varA7E53CE21691AB073D9660D615818899_253097266 = varB4EAC82CA7396A68D541C85D26508E83_1817481357;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_253097266 = varB4EAC82CA7396A68D541C85D26508E83_1303876558;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_253097266.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varA7E53CE21691AB073D9660D615818899_253097266;
		// ---------- Original Method ----------
		// String name = getAbsoluteName();
		// try {
		// if (!name.startsWith("/")) {
		// return new URI("file", null, "/" + name, null, null);
		// } else if (name.startsWith("//")) {
		// return new URI("file", "", name, null);
		// }
		// return new URI("file", null, name, null, null);
		// } catch (URISyntaxException e) {
		// return null;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.904 -0400", hash_original_method = "A697C8A8DDF3EFD4E15B0A56A47ADC60", hash_generated_method = "0A35A2341F7DE53096049C2B60060E87")
	@Deprecated
	public URL toURL() throws java.net.MalformedURLException {
		URL varB4EAC82CA7396A68D541C85D26508E83_1612919315 = null; // Variable
																	// for
																	// return #1
		URL varB4EAC82CA7396A68D541C85D26508E83_75023791 = null; // Variable for
																	// return #2
		URL varB4EAC82CA7396A68D541C85D26508E83_652798097 = null; // Variable
																	// for
																	// return #3
		String name = getAbsoluteName();
		{
			boolean var3B7AB1EAFD7996D7CA57EDAFF1D8E8B9_581499578 = (!name.startsWith("/"));
			{
				varB4EAC82CA7396A68D541C85D26508E83_1612919315 = new URL("file", "", -1, "/" + name, null);
			} // End block
			{
				boolean varB9723AF77574C7325A352568702E319A_42819936 = (name.startsWith("//"));
				{
					varB4EAC82CA7396A68D541C85D26508E83_75023791 = new URL("file:" + name);
				} // End block
			} // End collapsed parenthetic
		} // End collapsed parenthetic
		varB4EAC82CA7396A68D541C85D26508E83_652798097 = new URL("file", "", -1, name, null);
		URL varA7E53CE21691AB073D9660D615818899_1464209568; // Final return
															// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_1464209568 = varB4EAC82CA7396A68D541C85D26508E83_1612919315;
			break;
		case 2: // Assign result for return ordinal #2
			varA7E53CE21691AB073D9660D615818899_1464209568 = varB4EAC82CA7396A68D541C85D26508E83_75023791;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_1464209568 = varB4EAC82CA7396A68D541C85D26508E83_652798097;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_1464209568.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varA7E53CE21691AB073D9660D615818899_1464209568;
		// ---------- Original Method ----------
		// String name = getAbsoluteName();
		// if (!name.startsWith("/")) {
		// return new URL("file", "", -1, "/" + name, null);
		// } else if (name.startsWith("//")) {
		// return new URL("file:" + name);
		// }
		// return new URL("file", "", -1, name, null);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.904 -0400", hash_original_method = "6DC10F50F559258D97A948A93E776D0B", hash_generated_method = "A5B9F35A99CBEC1E61C9860DA6DFDCF6")
	private String getAbsoluteName() {
		String varB4EAC82CA7396A68D541C85D26508E83_771395097 = null; // Variable
																		// for
																		// return
																		// #1
		File f = getAbsoluteFile();
		String name = f.getPath();
		{
			boolean var43D90A838F59D75751D39C0CE0A07AE8_2004955110 = (f.isDirectory() && name.charAt(name.length() - 1) != separatorChar);
			{
				name = name + "/";
			} // End block
		} // End collapsed parenthetic
		{
			name = name.replace(separatorChar, '/');
		} // End block
		varB4EAC82CA7396A68D541C85D26508E83_771395097 = name;
		varB4EAC82CA7396A68D541C85D26508E83_771395097.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varB4EAC82CA7396A68D541C85D26508E83_771395097;
		// ---------- Original Method ----------
		// File f = getAbsoluteFile();
		// String name = f.getPath();
		// if (f.isDirectory() && name.charAt(name.length() - 1) !=
		// separatorChar) {
		// name = name + "/";
		// }
		// if (separatorChar != '/') {
		// name = name.replace(separatorChar, '/');
		// }
		// return name;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.905 -0400", hash_original_method = "84E8B11DBED8384FBE25A5788F12F18C", hash_generated_method = "E89EE35230152441AD158B6AA526B263")
	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		stream.writeChar(separatorChar);
		addTaint(stream.getTaint());
		// ---------- Original Method ----------
		// stream.defaultWriteObject();
		// stream.writeChar(separatorChar);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.905 -0400", hash_original_method = "FED9F4FA8E5031FA72F265B39D2840EA", hash_generated_method = "C445FF7B4D6C93490A45B31F8B405D60")
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		char inSeparator = stream.readChar();
		this.path = fixSlashes(path.replace(inSeparator, separatorChar));
		addTaint(stream.getTaint());
		// ---------- Original Method ----------
		// stream.defaultReadObject();
		// char inSeparator = stream.readChar();
		// this.path = fixSlashes(path.replace(inSeparator, separatorChar));
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.905 -0400", hash_original_method = "585308EC98C018F35D8810C372CB8328", hash_generated_method = "803D381BC347CD77CA20DA6BA20E3303")
	public long getTotalSpace() {
		try {
			StructStatFs sb = Libcore.os.statfs(path);
		} // End block
		catch (ErrnoException errnoException) {
		}
		long var0F5264038205EDFB1AC05FBB0E8C5E94_1460412908 = getTaintLong();
		return var0F5264038205EDFB1AC05FBB0E8C5E94_1460412908;
		// ---------- Original Method ----------
		// try {
		// StructStatFs sb = Libcore.os.statfs(path);
		// return sb.f_blocks * sb.f_bsize;
		// } catch (ErrnoException errnoException) {
		// return 0;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.905 -0400", hash_original_method = "14D64E7B25BCE5C0F5FB20D43EB644E7", hash_generated_method = "A1B7B88106150951C938513B6692688C")
	public long getUsableSpace() {
		try {
			StructStatFs sb = Libcore.os.statfs(path);
		} // End block
		catch (ErrnoException errnoException) {
		}
		long var0F5264038205EDFB1AC05FBB0E8C5E94_1720650969 = getTaintLong();
		return var0F5264038205EDFB1AC05FBB0E8C5E94_1720650969;
		// ---------- Original Method ----------
		// try {
		// StructStatFs sb = Libcore.os.statfs(path);
		// return sb.f_bavail * sb.f_bsize;
		// } catch (ErrnoException errnoException) {
		// return 0;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.905 -0400", hash_original_method = "23B4E27185BC412B65C1DC7422116A5E", hash_generated_method = "26A9C1827FDA7BE3719CBCC593A1B313")
	public long getFreeSpace() {
		try {
			StructStatFs sb = Libcore.os.statfs(path);
		} // End block
		catch (ErrnoException errnoException) {
		}
		long var0F5264038205EDFB1AC05FBB0E8C5E94_2068583022 = getTaintLong();
		return var0F5264038205EDFB1AC05FBB0E8C5E94_2068583022;
		// ---------- Original Method ----------
		// try {
		// StructStatFs sb = Libcore.os.statfs(path);
		// return sb.f_bfree * sb.f_bsize;
		// } catch (ErrnoException errnoException) {
		// return 0;
		// }
	}

	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.905 -0400", hash_original_field = "1E2D55A8188F4AAB89A2617091CD8DD3", hash_generated_field = "573261A4844452FF520B7BA941A9349A")
	private static final long serialVersionUID = 301077366599181567L;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.905 -0400", hash_original_field = "87AF8356E9494D3959A18CDFF00E37ED", hash_generated_field = "E9BF35C3AF9EB264C60B98A12F779A5F")
	private static final Random tempFileRandom = new Random();
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.906 -0400", hash_original_field = "70AC49BC330EA299ED55B5111D605814", hash_generated_field = "0CB7CCD71BDA0E3767C3A1B66A5E66EA")
	public static final char separatorChar;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.906 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "27036D15C987D02F54CC6DCFF754396D")
	public static final String separator;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.906 -0400", hash_original_field = "D043CF7D7D8EF3A009AAF357162D0088", hash_generated_field = "915D1D5E91DE4C4CF3D6A430E7A8D5AC")
	public static final char pathSeparatorChar;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.906 -0400", hash_original_field = "CB7E5EBB429F7E76E32EC729035E5287", hash_generated_field = "E086687B15C5540EFB395F08D9FB6B55")
	public static final String pathSeparator;
	static {
		separatorChar = System.getProperty("file.separator", "/").charAt(0);
		pathSeparatorChar = System.getProperty("path.separator", ":").charAt(0);
		separator = String.valueOf(separatorChar);
		pathSeparator = String.valueOf(pathSeparatorChar);
	}

}
