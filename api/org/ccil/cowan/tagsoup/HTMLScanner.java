package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.Writer;

import org.xml.sax.Locator;
import org.xml.sax.SAXException;






public class HTMLScanner implements Scanner, Locator {

	/**
	Test procedure.  Reads HTML from the standard input and writes
	PYX to the standard output.
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.623 -0500", hash_original_method = "9CEB13EDEDC086BFEC8BA1088EE97A14", hash_generated_method = "656413B9044418C61B8D0EFF05138943")
	public static void main(String[] argv) throws IOException, SAXException {
		Scanner s = new HTMLScanner();
		Reader r = new InputStreamReader(System.in, "UTF-8");
		Writer w = new OutputStreamWriter(System.out, "UTF-8");
		PYXWriter pw = new PYXWriter(w);
		s.scan(r, pw);
		w.close();
		}


	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.624 -0500", hash_original_method = "6185991F32A594F12E5499FEE0E2DB19", hash_generated_method = "F9E9DA837D2ACF24723CDE3E9BD9E281")
	private static String nicechar(int in) {
		if (in == '\n') return "\\n";
		if (in < 32) return "0x"+Integer.toHexString(in);
		return "'"+((char)in)+"'";
		}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.543 -0500", hash_original_field = "465E12C7E1C1D3ABB5D6AA96E7E052C1", hash_generated_field = "FBF4CCB0E0C015F7A0D40EF16DBFEE4F")

		private static final int S_ANAME = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.544 -0500", hash_original_field = "E12DA00B27E48C468F7AE549218DAAE0", hash_generated_field = "7427FF5CF2F4140DD15D538DCE4941F9")

	private static final int S_APOS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.544 -0500", hash_original_field = "6187DCA05761C00FA61AD69E7C6FD60C", hash_generated_field = "E3A0255D1F2889AA367FBDB4FBBFA19B")

	private static final int S_AVAL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.545 -0500", hash_original_field = "A30A765534DCF5C4302351C0BB83F278", hash_generated_field = "D81BA253EF5CB7720634733F1FA9C426")

	private static final int S_BB = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.546 -0500", hash_original_field = "12A979D34A642D67B39E63F885ED6B80", hash_generated_field = "658E6171037AF7B58264EEA0EA4E3C07")

	private static final int S_BBC = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.547 -0500", hash_original_field = "E18AACD06FE19C4EA6CD07C1B4BC9025", hash_generated_field = "1CBC31A5B8CD34B7ED0EA9AA51CBAA50")

	private static final int S_BBCD = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.548 -0500", hash_original_field = "EEDFED3B725801477A7775F7867C0641", hash_generated_field = "FC57827FD7CB64929EC205F2C8218CAD")

	private static final int S_BBCDA = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.549 -0500", hash_original_field = "6BBDAA7EB7D987DD6EA0404AEFE61AD5", hash_generated_field = "56A686C56D1EC3FA6E5EC6963F8AEEEC")

	private static final int S_BBCDAT = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.550 -0500", hash_original_field = "504DF1CB08E00FD7AA19AE533E4B9299", hash_generated_field = "856C0AC527EB9310BDC893358DEFDAE9")

	private static final int S_BBCDATA = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.551 -0500", hash_original_field = "E2447E4F9124DA529E5F74C04474D8B6", hash_generated_field = "5381C86960EECA2A1F31C2F74C8F8E42")

	private static final int S_CDATA = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.551 -0500", hash_original_field = "A65C439BFE69FD829180B2198EDEACF7", hash_generated_field = "6241444BE23EE130D76378E0BD67A4EF")

	private static final int S_CDATA2 = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.552 -0500", hash_original_field = "16077AA7E0C473E7D7ABF78D9633611C", hash_generated_field = "AB987E6AD90B0188EFB8E7A3B6C2499F")

	private static final int S_CDSECT = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.553 -0500", hash_original_field = "BE1DDFC4DE035C6E2B1261BED7C01B3A", hash_generated_field = "6AA4751A3D5CB29B690FE78C72B7CFDC")

	private static final int S_CDSECT1 = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.554 -0500", hash_original_field = "223F46BAA22C6B5C566BD9EB8C65B795", hash_generated_field = "71D398473DF5A41C8CF4750C1668453B")

	private static final int S_CDSECT2 = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.555 -0500", hash_original_field = "44CB88387D61C01F52140FDEA1E0E21C", hash_generated_field = "ABB31CB0D5E2B0912E20492D6D912ECC")

	private static final int S_COM = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.556 -0500", hash_original_field = "151D92FCA27ABC9274C64E39479217DF", hash_generated_field = "C3CB91E60A32613603D31C9CFFA5800D")

	private static final int S_COM2 = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.557 -0500", hash_original_field = "7ECD6A7D1B6B6453CB0F687A6F06691C", hash_generated_field = "F4EA6CF25AFA7BDCD82F2F466A79FFB2")

	private static final int S_COM3 = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.557 -0500", hash_original_field = "D04F9E02F3EF50D9BCC7E9BF42A005B3", hash_generated_field = "85EB2897B78D7E4982DE1EE56EF7DC1C")

	private static final int S_COM4 = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.558 -0500", hash_original_field = "17019A5F6B08036F28940886842CCF08", hash_generated_field = "20D5D3AD590B0C95D5E8EDF5F377B75B")

	private static final int S_DECL = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.559 -0500", hash_original_field = "796A4691D37815C3D4C4AEE625686952", hash_generated_field = "0106DCCA5118758BCB2D6D1074C9BA96")

	private static final int S_DECL2 = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.560 -0500", hash_original_field = "0D2E4DEDA39CA10F0915FEE9E66528AA", hash_generated_field = "730EE6C4156A9FB471549766C70732EE")

	private static final int S_DONE = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.561 -0500", hash_original_field = "6FB179B4789A6E01931BF82618902042", hash_generated_field = "062AE6CCC0D6C9EEA85B7FCA9F6C285F")

	private static final int S_EMPTYTAG = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.562 -0500", hash_original_field = "F88304E5ACCC7BADB2761ED7AA24AE96", hash_generated_field = "25ADD432C0243739691F2A8BA2BBDE65")

	private static final int S_ENT = 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.563 -0500", hash_original_field = "BC43F3E8932C16BE7CFB72A45385074E", hash_generated_field = "44B6AFF7497D41E66DD272AA78186370")

	private static final int S_EQ = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.563 -0500", hash_original_field = "BA64FEFB9ACFF57CC97C6B2942CDDC2C", hash_generated_field = "DE92DE56C324D7DB69544B1CBF59EF93")

	private static final int S_ETAG = 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.564 -0500", hash_original_field = "B3B34EDFC92E7DE138B3D512B6522776", hash_generated_field = "7A6CD32C477C7B4ACFD7F0D089BCFF32")

	private static final int S_GI = 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.565 -0500", hash_original_field = "6E920B008E186FF4B55277767C1D7C3E", hash_generated_field = "9A939DC8562C7DFBCA9FCC4CE55AD0FC")

	private static final int S_NCR = 27;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.566 -0500", hash_original_field = "5A1F6C7D8F3B328E63EE31933677AA67", hash_generated_field = "63EA530657B6CB08E6729244F2A7A029")

	private static final int S_PCDATA = 28;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.567 -0500", hash_original_field = "AAE67FD1CC8E18A02187FE1093E02787", hash_generated_field = "25FEF3C4A0E8E055E58FCFB0CF22B90D")

	private static final int S_PI = 29;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.568 -0500", hash_original_field = "99C195A2009FB22150EDA645D5F85F29", hash_generated_field = "080F9295264C75AE1CFA3F2B6EBA6BC5")

	private static final int S_PITARGET = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.569 -0500", hash_original_field = "D3DC673F90987C33B60A1207CF285EB4", hash_generated_field = "18CD1CB472777438443FD159F8A10A15")

	private static final int S_QUOT = 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.569 -0500", hash_original_field = "8886F1C1FC61509B4B09644D912F5045", hash_generated_field = "F1754F8A1FEBC2122F5A09D3B549FAD7")

	private static final int S_STAGC = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.571 -0500", hash_original_field = "8765573234A74CA63929D3B1EE4B2375", hash_generated_field = "BB5FF0FC10B5FC449A0D56D044C30EB4")

	private static final int S_TAG = 33;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.571 -0500", hash_original_field = "A35F5FB5257BDB24BEAA9A714E8A6F58", hash_generated_field = "3D7B4113B9A82A541DF21E497BD00E3A")

	private static final int S_TAGWS = 34;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.572 -0500", hash_original_field = "539090C0177E5DF11AD6AC91BC679A1B", hash_generated_field = "2FC1662A6EB227CAE0ACC13CE07C0035")

	private static final int S_XNCR = 35;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.573 -0500", hash_original_field = "F2CE7BED6369C61E6DE32115073040E5", hash_generated_field = "8C5023571008931FD6C3E012329D8D5F")

	private static final int A_ADUP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.574 -0500", hash_original_field = "4BF5808557599A27A839C4DAB0F5300D", hash_generated_field = "03E70ACC95A0D6624061A6F56180C17B")

	private static final int A_ADUP_SAVE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.575 -0500", hash_original_field = "3870F1D215A591D2E544FE2E03C7DC00", hash_generated_field = "B84619190E8FBDCE64F9CB6C57E94654")

	private static final int A_ADUP_STAGC = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.575 -0500", hash_original_field = "895282781F5BCB7F390EBCE36B82AAEC", hash_generated_field = "A6DA3A552D53EFA5B307D90D50252444")

	private static final int A_ANAME = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.576 -0500", hash_original_field = "697CC6D0881A6A95C5EFB0868B1DB0BF", hash_generated_field = "1D1E27CBE8CC6448A8D21899A2361585")

	private static final int A_ANAME_ADUP = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.577 -0500", hash_original_field = "5E54F286530C340A38EEC6FB17539C45", hash_generated_field = "9F345F9AE2E0005999C252F423E3F525")

	private static final int A_ANAME_ADUP_STAGC = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.578 -0500", hash_original_field = "C5439176A57649CADF2BEEE8464C9A3E", hash_generated_field = "82CD7AAD2EE078CAA921AB2EB6326E09")

	private static final int A_AVAL = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.579 -0500", hash_original_field = "7996CE1AB7EC6535A9E3EB5494046A92", hash_generated_field = "EEFDDC8ACED2CD34778BCC6EC802E850")

	private static final int A_AVAL_STAGC = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.580 -0500", hash_original_field = "F46AC6540AA7629BE1AA45E7D5DB6D94", hash_generated_field = "9CECF6163CE38788BF45727AFB596AF9")

	private static final int A_CDATA = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.581 -0500", hash_original_field = "76567251DAB513269633B1AAD4C1DA50", hash_generated_field = "54D0165ABD723C054926D3136BB733E1")

	private static final int A_CMNT = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.581 -0500", hash_original_field = "ABB1705CA835738152B4FE5207D10D13", hash_generated_field = "22C009E05903A8534711EF342CCB4038")

	private static final int A_DECL = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.582 -0500", hash_original_field = "82EA7DF2397E71C2A5910EAB08C66608", hash_generated_field = "BB51D1D35458744DBC815D0458DE69B6")

	private static final int A_EMPTYTAG = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.583 -0500", hash_original_field = "769283A455B7B26EBBB3D21CE839AC4D", hash_generated_field = "37737BF736E122BF7FDCED5DDBFB7161")

	private static final int A_ENTITY = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.584 -0500", hash_original_field = "FDD35D052C5EA2BE11CAD991769F1A88", hash_generated_field = "6B9C51D6EBB62046F08D2B38607C1BE2")

	private static final int A_ENTITY_START = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.586 -0500", hash_original_field = "D7BBDD76ABA4F3F8641052C2F313C394", hash_generated_field = "9C34690B75DFCF16209554E97CA2BEB1")

	private static final int A_ETAG = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.587 -0500", hash_original_field = "AF12DBB6A7EE863E4F7FF72BB5B989FF", hash_generated_field = "5EA41916D95BB4944453B271F6FC1030")

	private static final int A_GI = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.587 -0500", hash_original_field = "5F70B6D0D9E405D2550DCB52DC656451", hash_generated_field = "12495701D92212BF028152A5DA08BFBF")

	private static final int A_GI_STAGC = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.588 -0500", hash_original_field = "146342A8CB6705A060B9525DD5BA8582", hash_generated_field = "F1CCAE09B6E014C30D84F88807E429AB")

	private static final int A_LT = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.589 -0500", hash_original_field = "FEF1808B7DB0C90FAE18583DBB38628A", hash_generated_field = "6537BA942DB865D3C7C6DB0C487FF794")

	private static final int A_LT_PCDATA = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.590 -0500", hash_original_field = "0FCA9E50477EEE702C1AC6825213C51E", hash_generated_field = "38554D6769B35C70CF5C7375FEACBF7A")

	private static final int A_MINUS = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.591 -0500", hash_original_field = "D1B595BF1D644775B0D9B7F608FAC8EF", hash_generated_field = "15ACE7B1927A8182F3B74716A7C03DC4")

	private static final int A_MINUS2 = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.592 -0500", hash_original_field = "0DD78FAA87DF9CDF913A71A0ADA5A603", hash_generated_field = "731E47753233B88C1E3B4AFE9BDB82DE")

	private static final int A_MINUS3 = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.593 -0500", hash_original_field = "009E3AAD904C17AF04B57B7988F6F776", hash_generated_field = "461EC7F282E796E6FE44A983EC72F12C")

	private static final int A_PCDATA = 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.593 -0500", hash_original_field = "63D93E3B79AB8FF39BBD459D8858BDFA", hash_generated_field = "C58113A1D5C5274ECA947F1BE8E15CB2")

	private static final int A_PI = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.594 -0500", hash_original_field = "5EB9C5FA526A50AF3BE31D2468CAB3B8", hash_generated_field = "3071C8CCE67164F186CBDF4B9091F1B1")

	private static final int A_PITARGET = 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.595 -0500", hash_original_field = "4F4A53AC438C475B1F3EAD47AC2ECEC7", hash_generated_field = "7AB8724EC540C89B444DC191810E83D5")

	private static final int A_PITARGET_PI = 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.596 -0500", hash_original_field = "BB0856705196D584B87248CB2FE00F95", hash_generated_field = "527517156BADF85E45A33E49629ED526")

	private static final int A_SAVE = 27;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.597 -0500", hash_original_field = "7525A3ADC279C650DA06A20ED18D82E5", hash_generated_field = "CB0A06A7AE6857936556DD70E2884DB6")

	private static final int A_SKIP = 28;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.598 -0500", hash_original_field = "5A4E51DD42F5EA42306F81406919653A", hash_generated_field = "0B2D976710E3273CCCE75D9466DBA3A8")

	private static final int A_SP = 29;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.599 -0500", hash_original_field = "5BFC416D650191A4A2EAB4A21AC7A392", hash_generated_field = "F786E60D4FF5503E86C58EDB3C40EF90")

	private static final int A_STAGC = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.599 -0500", hash_original_field = "C475260D7C532361E7A8C2B28D7F8B20", hash_generated_field = "D315D76E37601DEDC5FE51F70EC23581")

	private static final int A_UNGET = 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.600 -0500", hash_original_field = "D69377334C8422308EB18795CC003EC1", hash_generated_field = "97B05E575B3CDCB636E59F91B624B432")

	private static final int A_UNSAVE_PCDATA = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.602 -0500", hash_original_field = "1BAAE84C38E7ED841DE7CAAFAE55B42E", hash_generated_field = "42AE8F347F354E39EDE4E32AAC75B88F")

	private static int[] statetable = {
		S_ANAME, '/', A_ANAME_ADUP, S_EMPTYTAG,
		S_ANAME, '=', A_ANAME, S_AVAL,
		S_ANAME, '>', A_ANAME_ADUP_STAGC, S_PCDATA,
		S_ANAME, 0, A_SAVE, S_ANAME,
		S_ANAME, -1, A_ANAME_ADUP_STAGC, S_DONE,
		S_ANAME, ' ', A_ANAME, S_EQ,
		S_ANAME, '\n', A_ANAME, S_EQ,
		S_ANAME, '\t', A_ANAME, S_EQ,
		S_APOS, '\'', A_AVAL, S_TAGWS,
		S_APOS, 0, A_SAVE, S_APOS,
		S_APOS, -1, A_AVAL_STAGC, S_DONE,
		S_APOS, ' ', A_SP, S_APOS,
		S_APOS, '\n', A_SP, S_APOS,
		S_APOS, '\t', A_SP, S_APOS,
		S_AVAL, '\'', A_SKIP, S_APOS,
		S_AVAL, '"', A_SKIP, S_QUOT,
		S_AVAL, '>', A_AVAL_STAGC, S_PCDATA,
		S_AVAL, 0, A_SAVE, S_STAGC,
		S_AVAL, -1, A_AVAL_STAGC, S_DONE,
		S_AVAL, ' ', A_SKIP, S_AVAL,
		S_AVAL, '\n', A_SKIP, S_AVAL,
		S_AVAL, '\t', A_SKIP, S_AVAL,
		S_BB, 'C', A_SKIP, S_BBC,
		S_BB, 0, A_SKIP, S_DECL,
		S_BB, -1, A_SKIP, S_DONE,
		S_BBC, 'D', A_SKIP, S_BBCD,
		S_BBC, 0, A_SKIP, S_DECL,
		S_BBC, -1, A_SKIP, S_DONE,
		S_BBCD, 'A', A_SKIP, S_BBCDA,
		S_BBCD, 0, A_SKIP, S_DECL,
		S_BBCD, -1, A_SKIP, S_DONE,
		S_BBCDA, 'T', A_SKIP, S_BBCDAT,
		S_BBCDA, 0, A_SKIP, S_DECL,
		S_BBCDA, -1, A_SKIP, S_DONE,
		S_BBCDAT, 'A', A_SKIP, S_BBCDATA,
		S_BBCDAT, 0, A_SKIP, S_DECL,
		S_BBCDAT, -1, A_SKIP, S_DONE,
		S_BBCDATA, '[', A_SKIP, S_CDSECT,
		S_BBCDATA, 0, A_SKIP, S_DECL,
		S_BBCDATA, -1, A_SKIP, S_DONE,
		S_CDATA, '<', A_SAVE, S_CDATA2,
		S_CDATA, 0, A_SAVE, S_CDATA,
		S_CDATA, -1, A_PCDATA, S_DONE,
		S_CDATA2, '/', A_UNSAVE_PCDATA, S_ETAG,
		S_CDATA2, 0, A_SAVE, S_CDATA,
		S_CDATA2, -1, A_UNSAVE_PCDATA, S_DONE,
		S_CDSECT, ']', A_SAVE, S_CDSECT1,
		S_CDSECT, 0, A_SAVE, S_CDSECT,
		S_CDSECT, -1, A_SKIP, S_DONE,
		S_CDSECT1, ']', A_SAVE, S_CDSECT2,
		S_CDSECT1, 0, A_SAVE, S_CDSECT,
		S_CDSECT1, -1, A_SKIP, S_DONE,
		S_CDSECT2, '>', A_CDATA, S_PCDATA,
		S_CDSECT2, 0, A_SAVE, S_CDSECT,
		S_CDSECT2, -1, A_SKIP, S_DONE,
		S_COM, '-', A_SKIP, S_COM2,
		S_COM, 0, A_SAVE, S_COM2,
		S_COM, -1, A_CMNT, S_DONE,
		S_COM2, '-', A_SKIP, S_COM3,
		S_COM2, 0, A_SAVE, S_COM2,
		S_COM2, -1, A_CMNT, S_DONE,
		S_COM3, '-', A_SKIP, S_COM4,
		S_COM3, 0, A_MINUS, S_COM2,
		S_COM3, -1, A_CMNT, S_DONE,
		S_COM4, '-', A_MINUS3, S_COM4,
		S_COM4, '>', A_CMNT, S_PCDATA,
		S_COM4, 0, A_MINUS2, S_COM2,
		S_COM4, -1, A_CMNT, S_DONE,
		S_DECL, '-', A_SKIP, S_COM,
		S_DECL, '[', A_SKIP, S_BB,
		S_DECL, '>', A_SKIP, S_PCDATA,
		S_DECL, 0, A_SAVE, S_DECL2,
		S_DECL, -1, A_SKIP, S_DONE,
		S_DECL2, '>', A_DECL, S_PCDATA,
		S_DECL2, 0, A_SAVE, S_DECL2,
		S_DECL2, -1, A_SKIP, S_DONE,
		S_EMPTYTAG, '>', A_EMPTYTAG, S_PCDATA,
		S_EMPTYTAG, 0, A_SAVE, S_ANAME,
		S_EMPTYTAG, ' ', A_SKIP, S_TAGWS,
		S_EMPTYTAG, '\n', A_SKIP, S_TAGWS,
		S_EMPTYTAG, '\t', A_SKIP, S_TAGWS,
		S_ENT, 0, A_ENTITY, S_ENT,
		S_ENT, -1, A_ENTITY, S_DONE,
		S_EQ, '=', A_SKIP, S_AVAL,
		S_EQ, '>', A_ADUP_STAGC, S_PCDATA,
		S_EQ, 0, A_ADUP_SAVE, S_ANAME,
		S_EQ, -1, A_ADUP_STAGC, S_DONE,
		S_EQ, ' ', A_SKIP, S_EQ,
		S_EQ, '\n', A_SKIP, S_EQ,
		S_EQ, '\t', A_SKIP, S_EQ,
		S_ETAG, '>', A_ETAG, S_PCDATA,
		S_ETAG, 0, A_SAVE, S_ETAG,
		S_ETAG, -1, A_ETAG, S_DONE,
		S_ETAG, ' ', A_SKIP, S_ETAG,
		S_ETAG, '\n', A_SKIP, S_ETAG,
		S_ETAG, '\t', A_SKIP, S_ETAG,
		S_GI, '/', A_SKIP, S_EMPTYTAG,
		S_GI, '>', A_GI_STAGC, S_PCDATA,
		S_GI, 0, A_SAVE, S_GI,
		S_GI, -1, A_SKIP, S_DONE,
		S_GI, ' ', A_GI, S_TAGWS,
		S_GI, '\n', A_GI, S_TAGWS,
		S_GI, '\t', A_GI, S_TAGWS,
		S_NCR, 0, A_ENTITY, S_NCR,
		S_NCR, -1, A_ENTITY, S_DONE,
		S_PCDATA, '&', A_ENTITY_START, S_ENT,
		S_PCDATA, '<', A_PCDATA, S_TAG,
		S_PCDATA, 0, A_SAVE, S_PCDATA,
		S_PCDATA, -1, A_PCDATA, S_DONE,
		S_PI, '>', A_PI, S_PCDATA,
		S_PI, 0, A_SAVE, S_PI,
		S_PI, -1, A_PI, S_DONE,
		S_PITARGET, '>', A_PITARGET_PI, S_PCDATA,
		S_PITARGET, 0, A_SAVE, S_PITARGET,
		S_PITARGET, -1, A_PITARGET_PI, S_DONE,
		S_PITARGET, ' ', A_PITARGET, S_PI,
		S_PITARGET, '\n', A_PITARGET, S_PI,
		S_PITARGET, '\t', A_PITARGET, S_PI,
		S_QUOT, '"', A_AVAL, S_TAGWS,
		S_QUOT, 0, A_SAVE, S_QUOT,
		S_QUOT, -1, A_AVAL_STAGC, S_DONE,
		S_QUOT, ' ', A_SP, S_QUOT,
		S_QUOT, '\n', A_SP, S_QUOT,
		S_QUOT, '\t', A_SP, S_QUOT,
		S_STAGC, '>', A_AVAL_STAGC, S_PCDATA,
		S_STAGC, 0, A_SAVE, S_STAGC,
		S_STAGC, -1, A_AVAL_STAGC, S_DONE,
		S_STAGC, ' ', A_AVAL, S_TAGWS,
		S_STAGC, '\n', A_AVAL, S_TAGWS,
		S_STAGC, '\t', A_AVAL, S_TAGWS,
		S_TAG, '!', A_SKIP, S_DECL,
		S_TAG, '?', A_SKIP, S_PITARGET,
		S_TAG, '/', A_SKIP, S_ETAG,
		S_TAG, '<', A_SAVE, S_TAG,
		S_TAG, 0, A_SAVE, S_GI,
		S_TAG, -1, A_LT_PCDATA, S_DONE,
		S_TAG, ' ', A_LT, S_PCDATA,
		S_TAG, '\n', A_LT, S_PCDATA,
		S_TAG, '\t', A_LT, S_PCDATA,
		S_TAGWS, '/', A_SKIP, S_EMPTYTAG,
		S_TAGWS, '>', A_STAGC, S_PCDATA,
		S_TAGWS, 0, A_SAVE, S_ANAME,
		S_TAGWS, -1, A_STAGC, S_DONE,
		S_TAGWS, ' ', A_SKIP, S_TAGWS,
		S_TAGWS, '\n', A_SKIP, S_TAGWS,
		S_TAGWS, '\t', A_SKIP, S_TAGWS,
		S_XNCR, 0, A_ENTITY, S_XNCR,
		S_XNCR, -1, A_ENTITY, S_DONE,

	};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.603 -0500", hash_original_field = "6BB1E2BCDE8B0C1C1DF5A4B0BC92A1B3", hash_generated_field = "A974EA1E26A24169F00F81DBB3C02AD2")

	private static final String[] debug_actionnames = { "", "A_ADUP", "A_ADUP_SAVE", "A_ADUP_STAGC", "A_ANAME", "A_ANAME_ADUP", "A_ANAME_ADUP_STAGC", "A_AVAL", "A_AVAL_STAGC", "A_CDATA", "A_CMNT", "A_DECL", "A_EMPTYTAG", "A_ENTITY", "A_ENTITY_START", "A_ETAG", "A_GI", "A_GI_STAGC", "A_LT", "A_LT_PCDATA", "A_MINUS", "A_MINUS2", "A_MINUS3", "A_PCDATA", "A_PI", "A_PITARGET", "A_PITARGET_PI", "A_SAVE", "A_SKIP", "A_SP", "A_STAGC", "A_UNGET", "A_UNSAVE_PCDATA"};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.604 -0500", hash_original_field = "8AEA32A781E31D256161DA638DAA713F", hash_generated_field = "94C8DD3C0B0DF20945959CD74C941DDC")

	private static final String[] debug_statenames = { "", "S_ANAME", "S_APOS", "S_AVAL", "S_BB", "S_BBC", "S_BBCD", "S_BBCDA", "S_BBCDAT", "S_BBCDATA", "S_CDATA", "S_CDATA2", "S_CDSECT", "S_CDSECT1", "S_CDSECT2", "S_COM", "S_COM2", "S_COM3", "S_COM4", "S_DECL", "S_DECL2", "S_DONE", "S_EMPTYTAG", "S_ENT", "S_EQ", "S_ETAG", "S_GI", "S_NCR", "S_PCDATA", "S_PI", "S_PITARGET", "S_QUOT", "S_STAGC", "S_TAG", "S_TAGWS", "S_XNCR"};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.605 -0500", hash_original_field = "5C707ECB339F23EAEEC892B0212CE645", hash_generated_field = "5DE7612FB52B4C7CD7CF6BE3E02E09B6")


	private String thePublicid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.606 -0500", hash_original_field = "8E986C2E3C2DBAB0669078F2DDD53CDD", hash_generated_field = "9A678ABFCD87282CEC96ECE7EA2137F4")

	private String theSystemid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.607 -0500", hash_original_field = "54BBD5B6230DF32773FB5408E01D438B", hash_generated_field = "002B529451A6709EF216BD8F8F7D4F81")

	private int theLastLine;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.607 -0500", hash_original_field = "84871466E1662C12899594D1F2A5B520", hash_generated_field = "F4A44194D173076DCB26B2C8E351310B")

	private int theLastColumn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.608 -0500", hash_original_field = "61833AD459125EDD9F4A460D150355BF", hash_generated_field = "1E986C0C45EC0CBFCB2541DDE893227E")

	private int theCurrentLine;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.609 -0500", hash_original_field = "DE983E8E09636E2DDF5F7B87E6702D1C", hash_generated_field = "A6C1CC9770372CF135647494BE6B1EA7")

	private int theCurrentColumn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.610 -0500", hash_original_field = "2A9B3707FE4B47A183CA387F06CD96C3", hash_generated_field = "2A9B3707FE4B47A183CA387F06CD96C3")


	int theState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.611 -0500", hash_original_field = "B539E59DE16ED9BC0EA86219F312D4FD", hash_generated_field = "B539E59DE16ED9BC0EA86219F312D4FD")

	int theNextState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.611 -0500", hash_original_field = "BFE6CE6F03989DB396BE3B22A5F736FE", hash_generated_field = "BFE6CE6F03989DB396BE3B22A5F736FE")

	char[] theOutputBuffer = new char[200];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.612 -0500", hash_original_field = "22B5A69CFAB142C36A53904D0940E17C", hash_generated_field = "22B5A69CFAB142C36A53904D0940E17C")

	int theSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.613 -0500", hash_original_field = "542BE9D4F64152B2AED96D4C22F1251F", hash_generated_field = "F0FD22D31F68AD6CA22F36A1711CAAAB")

	int[] theWinMap = {				// Windows chars map
		0x20AC, 0xFFFD, 0x201A, 0x0192, 0x201E, 0x2026, 0x2020, 0x2021,
		0x02C6, 0x2030, 0x0160, 0x2039, 0x0152, 0xFFFD, 0x017D, 0xFFFD,
		0xFFFD, 0x2018, 0x2019, 0x201C, 0x201D, 0x2022, 0x2013, 0x2014,
		0x02DC, 0x2122, 0x0161, 0x203A, 0x0153, 0xFFFD, 0x017E, 0x0178};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.835 -0400", hash_original_method = "A8030374AECACF3BB4D2A2FA58C4A7D8", hash_generated_method = "A8030374AECACF3BB4D2A2FA58C4A7D8")
    public HTMLScanner ()
    {
        //Synthesized constructor
    }

	// Compensate for bug in PushbackReader that allows
	// pushing back EOF.
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.614 -0500", hash_original_method = "7BF7C7D5830ADAF76FEF60D8F3F10567", hash_generated_method = "872D3FD9168E1181E028E49E9A4216EB")
	private void unread(PushbackReader r, int c) throws IOException {
		if (c != -1) r.unread(c);
		}

	// Locator implementation

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.614 -0500", hash_original_method = "17D8C6B884298309CDBB8C115CEF45AD", hash_generated_method = "279B434579FFA4459D3046F7F45DAFB9")
	public int getLineNumber() {
		return theLastLine;
		}
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.616 -0500", hash_original_method = "CC76CCC6A19838EC65870F98307D39F4", hash_generated_method = "1A30DEA5198B61D0D33235193B0CF6FB")
	public int getColumnNumber() {
		return theLastColumn;
		}
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.616 -0500", hash_original_method = "EE9557AC8121925813378C18555B01E0", hash_generated_method = "06235A262FCF60358C59DC0A29A6CC50")
	public String getPublicId() {
		return thePublicid;
		}
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.617 -0500", hash_original_method = "B52DC32D5FB92F39EE1C6D62A566FA39", hash_generated_method = "DABDB33649964195ACD2BAF147D39707")
	public String getSystemId() {
		return theSystemid;
		}


	// Scanner implementation

	/**
	Reset document locator, supplying systemid and publicid.
	@param systemid System id
	@param publicid Public id
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.618 -0500", hash_original_method = "0F092EE343E640C5A578BAEFAE8AEFB5", hash_generated_method = "6F28AC5149E20C1DA152AF872D663D1C")
	public void resetDocumentLocator(String publicid, String systemid) {
		thePublicid = publicid;
		theSystemid = systemid;
		theLastLine = theLastColumn = theCurrentLine = theCurrentColumn = 0;
		}

	/**
	Scan HTML source, reporting lexical events.
	@param r0 Reader that provides characters
	@param h ScanHandler that accepts lexical events.
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.620 -0500", hash_original_method = "D85CBFA2F1A37C13B743BA6B1C12F2CC", hash_generated_method = "1CD5DECB5B3EECBD930281411C62A36B")
	public void scan(Reader r0, ScanHandler h) throws IOException, SAXException {
		theState = S_PCDATA;
		PushbackReader r;
		if (r0 instanceof PushbackReader) {
			r = (PushbackReader)r0;
			}
		else if (r0 instanceof BufferedReader) {
			r = new PushbackReader(r0);
			}
		else {
			r = new PushbackReader(new BufferedReader(r0, 200));
			}

		int firstChar = r.read();	// Remove any leading BOM
		if (firstChar != '\uFEFF') unread(r, firstChar);

		while (theState != S_DONE) {
			int ch = r.read();

			// Process control characters
			if (ch >= 0x80 && ch <= 0x9F) ch = theWinMap[ch-0x80];

			if (ch == '\r') {
				ch = r.read();		// expect LF next
				if (ch != '\n') {
					unread(r, ch);	// nope
					ch = '\n';
					}
				}

			if (ch == '\n') {
				theCurrentLine++;
				theCurrentColumn = 0;
				}
			else {
				theCurrentColumn++;
				}

			if (!(ch >= 0x20 || ch == '\n' || ch == '\t' || ch == -1)) continue;

			// Search state table
			int action = 0;
			for (int i = 0; i < statetable.length; i += 4) {
				if (theState != statetable[i]) {
					if (action != 0) break;
					continue;
					}
				if (statetable[i+1] == 0) {
					action = statetable[i+2];
					theNextState = statetable[i+3];
					}
				else if (statetable[i+1] == ch) {
					action = statetable[i+2];
					theNextState = statetable[i+3];
					break;
					}
				}
//			System.err.println("In " + debug_statenames[theState] + " got " + nicechar(ch) + " doing " + debug_actionnames[action] + " then " + debug_statenames[theNextState]);
			switch (action) {
			case 0:
				throw new Error(
"HTMLScanner can't cope with " + Integer.toString(ch) + " in state " +
Integer.toString(theState));
        		case A_ADUP:
				h.adup(theOutputBuffer, 0, theSize);
				theSize = 0;
				break;
        		case A_ADUP_SAVE:
				h.adup(theOutputBuffer, 0, theSize);
				theSize = 0;
				save(ch, h);
				break;
        		case A_ADUP_STAGC:
				h.adup(theOutputBuffer, 0, theSize);
				theSize = 0;
				h.stagc(theOutputBuffer, 0, theSize);
				break;
        		case A_ANAME:
				h.aname(theOutputBuffer, 0, theSize);
				theSize = 0;
				break;
        		case A_ANAME_ADUP:
				h.aname(theOutputBuffer, 0, theSize);
				theSize = 0;
				h.adup(theOutputBuffer, 0, theSize);
				break;
        		case A_ANAME_ADUP_STAGC:
				h.aname(theOutputBuffer, 0, theSize);
				theSize = 0;
				h.adup(theOutputBuffer, 0, theSize);
				h.stagc(theOutputBuffer, 0, theSize);
				break;
        		case A_AVAL:
				h.aval(theOutputBuffer, 0, theSize);
				theSize = 0;
				break;
        		case A_AVAL_STAGC:
				h.aval(theOutputBuffer, 0, theSize);
				theSize = 0;
				h.stagc(theOutputBuffer, 0, theSize);
				break;
			case A_CDATA:
				mark();
				// suppress the final "]]" in the buffer
				if (theSize > 1) theSize -= 2;
				h.pcdata(theOutputBuffer, 0, theSize);
				theSize = 0;
				break;
			case A_ENTITY_START:
				h.pcdata(theOutputBuffer, 0, theSize);
				theSize = 0;
				save(ch, h);
				break;
			case A_ENTITY:
				mark();
				char ch1 = (char)ch;
//				System.out.println("Got " + ch1 + " in state " + ((theState == S_ENT) ? "S_ENT" : ((theState == S_NCR) ? "S_NCR" : "UNK")));
				if (theState == S_ENT && ch1 == '#') {
					theNextState = S_NCR;
					save(ch, h);
					break;
					}
				else if (theState == S_NCR && (ch1 == 'x' || ch1 == 'X')) {
					theNextState = S_XNCR;
					save(ch, h);
					break;
					}
				else if (theState == S_ENT && Character.isLetterOrDigit(ch1)) {
					save(ch, h);
					break;
					}
				else if (theState == S_NCR && Character.isDigit(ch1)) {
					save(ch, h);
					break;
					}
				else if (theState == S_XNCR && (Character.isDigit(ch1) || "abcdefABCDEF".indexOf(ch1) != -1)) {
					save(ch, h);
					break;
					}

				// The whole entity reference has been collected
//				System.err.println("%%" + new String(theOutputBuffer, 0, theSize));
				h.entity(theOutputBuffer, 1, theSize - 1);
				int ent = h.getEntity();
//				System.err.println("%% value = " + ent);
				if (ent != 0) {
					theSize = 0;
					if (ent >= 0x80 && ent <= 0x9F) {
						ent = theWinMap[ent-0x80];
						}
					if (ent < 0x20) {
						// Control becomes space
						ent = 0x20;
						}
					else if (ent >= 0xD800 && ent <= 0xDFFF) {
						// Surrogates get dropped
						ent = 0;
						}
					else if (ent <= 0xFFFF) {
						// BMP character
						save(ent, h);
						}
					else {
						// Astral converted to two surrogates
						ent -= 0x10000;
						save((ent>>10) + 0xD800, h);
						save((ent&0x3FF) + 0xDC00, h);
						}
					if (ch != ';') {
						unread(r, ch);
						theCurrentColumn--;
						}
					}
				else {
					unread(r, ch);
					theCurrentColumn--;
					}
				theNextState = S_PCDATA;
				break;
        		case A_ETAG:
				h.etag(theOutputBuffer, 0, theSize);
				theSize = 0;
				break;
        		case A_DECL:
				h.decl(theOutputBuffer, 0, theSize);
				theSize = 0;
				break;
        		case A_GI:
				h.gi(theOutputBuffer, 0, theSize);
				theSize = 0;
				break;
			case A_GI_STAGC:
				h.gi(theOutputBuffer, 0, theSize);
				theSize = 0;
				h.stagc(theOutputBuffer, 0, theSize);
				break;
        		case A_LT:
				mark();
				save('<', h);
				save(ch, h);
				break;
			case A_LT_PCDATA:
				mark();
				save('<', h);
				h.pcdata(theOutputBuffer, 0, theSize);
				theSize = 0;
				break;
        		case A_PCDATA:
				mark();
				h.pcdata(theOutputBuffer, 0, theSize);
				theSize = 0;
				break;
			case A_CMNT:
				mark();
				h.cmnt(theOutputBuffer, 0, theSize);
				theSize = 0;
				break;
			case A_MINUS3:
				save('-', h);
				save(' ', h);
				break;
			case A_MINUS2:
				save('-', h);
				save(' ', h);
				// fall through into A_MINUS
			case A_MINUS:
				save('-', h);
				save(ch, h);
				break;
        		case A_PI:
				mark();
				h.pi(theOutputBuffer, 0, theSize);
				theSize = 0;
				break;
        		case A_PITARGET:
				h.pitarget(theOutputBuffer, 0, theSize);
				theSize = 0;
				break;
        		case A_PITARGET_PI:
				h.pitarget(theOutputBuffer, 0, theSize);
				theSize = 0;
				h.pi(theOutputBuffer, 0, theSize);
				break;
        		case A_SAVE:
				save(ch, h);
				break;
        		case A_SKIP:
				break;
        		case A_SP:
				save(' ', h);
				break;
        		case A_STAGC:
				h.stagc(theOutputBuffer, 0, theSize);
				theSize = 0;
				break;
			case A_EMPTYTAG:
				mark();
//				System.err.println("%%% Empty tag seen");
				if (theSize > 0) h.gi(theOutputBuffer, 0, theSize);
				theSize = 0;
				h.stage(theOutputBuffer, 0, theSize);
				break;
			case A_UNGET:
				unread(r, ch);
				theCurrentColumn--;
				break;
        		case A_UNSAVE_PCDATA:
				if (theSize > 0) theSize--;
				h.pcdata(theOutputBuffer, 0, theSize);
				theSize = 0;
				break;
			default:
				throw new Error("Can't process state " + action);
				}
			theState = theNextState;
			}
		h.eof(theOutputBuffer, 0, 0);
		}

	/**
	* Mark the current scan position as a "point of interest" - start of a tag,
	* cdata, processing instruction etc.
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.621 -0500", hash_original_method = "5C668F99FD089E189A03C18C500CC1BE", hash_generated_method = "7A5B6ECB950F08DE7D9790B7A3DE1542")
	private void mark() {
		theLastColumn = theCurrentColumn;
		theLastLine = theCurrentLine;
		}

	/**
	A callback for the ScanHandler that allows it to force
	the lexer state to CDATA content (no markup is recognized except
	the end of element.
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.622 -0500", hash_original_method = "ADD8A6D3E398AE84BB2395E77CB3DD25", hash_generated_method = "6DA260BB897D74B8F53EF5A21360381C")
	public void startCDATA() { theNextState = S_CDATA; }

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:01.622 -0500", hash_original_method = "84101FD8AB96FAF4340E309879AEA5A7", hash_generated_method = "68B699CFEA4728D8A26CE0926E51E66F")
	private void save(int ch, ScanHandler h) throws IOException, SAXException {
		if (theSize >= theOutputBuffer.length - 20) {
			if (theState == S_PCDATA || theState == S_CDATA) {
				// Return a buffer-sized chunk of PCDATA
				h.pcdata(theOutputBuffer, 0, theSize);
				theSize = 0;
				}
			else {
				// Grow the buffer size
				char[] newOutputBuffer = new char[theOutputBuffer.length * 2];
                                System.arraycopy(theOutputBuffer, 0, newOutputBuffer, 0, theSize+1);
				theOutputBuffer = newOutputBuffer;
				}
			}
		theOutputBuffer[theSize++] = (char)ch;
		}
}

