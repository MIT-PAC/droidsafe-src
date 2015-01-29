#! /usr/bin/env php
<?php
$HOME = getenv ("HOME");
include "utils.php";

/**
 * merge_susi_info <report_file>
 *
 * Reads the SuSi source/sink files (Ouput_CatSinks_v0_9.txt,
 * Ouput_CatSources_v0_9.txt) and compares them against the report file.

 */
class SpecInfo {
  var $sig;
  var $spec;
  var $ss;
  var $comment;
  var $person;
  var $cur_specdiff = null;
  var $cur_ssdiff = null;

  public function __construct ($sig, $spec, $ss, $comment=null, $person=null) {
    $this->sig = trim($sig);
    $spec = trim ($spec);
    if (true && starts_with ($spec, "DS"))
      $spec = "@$spec";
    $this->spec = $spec;
    $ss = trim ($ss);
    if (true && starts_with ($ss, "DS"))
      $ss = "@$ss";
    $this->ss = $ss;
    $this->comment = trim($comment);
    $this->person = trim($person);
  }

  public function __toString() {
    return "$this->sig, $this->spec, $this->ss, $this->person, $this->comment";
  }

  function get_class() {
    return sig_to_class ($this->sig);
  }
}

/** both spec info and info from the current code **/
class AllInfo {
  var $spec;
  var $report;
  public function __construct ($spec=null, $report=null) {
    $this->spec = $spec;
    $this->report = $report;
  }
}

$usage = <<<USAGE
merge_spec_info.php <report-file>
  report-file   - report pulled from current code
USAGE;

{
  $info_file = null;
  $report_file = null;
  $print_classes_only = false;
  $apac = getenv ("APAC");
  if (!$apac)
    $apac = getenv ("apac");
  if (!$apac) {
    printf ('Cant find apac home in either $apac or $APAC\n');
    exit (-1);
  }
  $merged_input = false;
  $susi_sink_file = "$apac/categorize/Ouput_CatSinks_v0_9.txt";
  $susi_src_file = "$apac/categorize/Ouput_CatSources_v0_9.txt";

  // Process arguments
  for ($i = 1; $i < count ($argv); $i++) {
    $arg = $argv[$i];
    if (($arg == "-debug") || ($arg == "-d"))
      $debug = true;
    else if ($arg == '-classes')
      $print_classes_only = true;
    else if ($arg == '-merged_input')
      $merged_input = true;
    else if (starts_with ($arg, "-"))
      usage_err ("Unexpected argument $arg", $usage);
    else {
      if ($report_file == null)
        $report_file = $arg;
      else
        usage_err ("Unexpected argument $arg", $usage);
    }
  }
  if (!$report_file)
    usage_err ("Requires one file arguments", $usage);

  // Process the Susi source/sink files
  $susi_sink_map = get_susi_map ($susi_sink_file);
  $susi_src_map = get_susi_map ($susi_src_file);

  // Get the frequency counts for each method
  // This also gives us a list of what methods we considered.
  $freq_cnt_file = "$apac/todo/engagement-3-api-calls/calls_by_freq.no_support";
  $freq_array = file ($freq_cnt_file, FILE_IGNORE_NEW_LINES);
  if (!$freq_array) {
    fwrite(STDERR, "can't open $freq_cnt_file\n");
    exit (-1);
  }
  foreach ($freq_array as $finfo) {
    list ($cnt, $class, $method) = preg_split ("/[\s]+/", trim($finfo));
    $index = "$class: $method";
    $freq_map[$index] = $cnt;
    // printf ("'$index' -> '$cnt'\n");
  }

  // Get the list of susi source calls that we didn't consider
  $not_included_src_cnt = 0;
  foreach ($susi_src_map as $sig => $type) {
    $class_method = sig_to_name ($sig);
    if (!array_key_exists ($class_method, $freq_map)) {
      printf ("ds-excluded: $sig '$class_method' $type\n");
      $not_included_src_cnt++;
    } else {
      printf ("ds-included: $sig $type\n");
    }
  }
  printf ("%d SuSi sources, %d considered by DroidSafe\n", count($susi_src_map),
          count($susi_src_map) - $not_included_src_cnt);

  // Get the list of susi sink calls that we didn't consider
  $not_included_sink_cnt = 0;
  foreach ($susi_sink_map as $sig => $type) {
    $class_method = sig_to_name ($sig);
    if (!array_key_exists ($class_method, $freq_map)) {
      printf ("ds-excluded: $sig '$class_method' $type\n");
      $not_included_sink_cnt++;
    } else {
      printf ("ds-included: $sig $type\n");
    }
  }
  printf ("%d SuSi sinks, %d considered by DroidSafe\n", count($susi_sink_map),
          count($susi_sink_map) - $not_included_sink_cnt);



  // Process the info file and put all of the information
  // into info_map and bcomment
  if (false) {
    $all_info = file ($info_file, FILE_IGNORE_NEW_LINES);
    if (!$all_info)
      throw new Exception ("Can't open $info_file");
    $info_map = array();
    $cur_specdiff = null;
    $cur_ssdiff = null; 
    $new_block_comment = false;
    foreach ($all_info as $info) {
      if ($merged_input)
        @list ($person, $cur_specdiff, $spec, $curspec, $cur_ssdiff, 
               $ss, $curss, $freq_cnt, $sig, $comment) = explode ("\t", $info);
      else {
        @list ($person, $spec, $ss, $sig, $comment) = explode ("\t", $info);
      }

      // sometimes the spreadsheet puts quotes around some items (why??)
      $sig = trim ($sig, '"');

      if ($person == "who")
        continue;
      if ($person)
        $last_person = $person;
      if (!$sig && !$spec) {
        assert (!$person && !$ss && !$comment);
        $block_comment = null;
        $new_block_comment = false;
        $last_person = null;
        continue;
      }
      if (!$sig) {
        if ($person || $ss || $comment || !$spec)
          // echo "Warning: odd input line: $info\n";
          throw new exception ("odd input line: $info");
        $block_comment = trim($spec, '"');
        $new_block_comment = true;
        continue;
      }
      if (!$person)
        $person = $last_person;
      $specinfo = new SpecInfo ($sig, $spec, $ss, $comment, $person);
      if (trim($cur_specdiff) && !starts_with ($cur_specdiff, "X"))
        $specinfo->cur_specdiff = $cur_specdiff;
      if (trim($cur_ssdiff) && !starts_with ($cur_ssdiff, "X"))
        $specinfo->cur_ssdiff = $cur_ssdiff;

      // If there was a block comment for this class, remember it
      if ($new_block_comment) {
        $class = $specinfo->get_class();
        $bcomment[$class] = $block_comment;
        $new_block_comment = false;
      }

      // Remember the information for this signature
      if (array_key_exists($sig, $info_map)) 
        throw new Exception ("$sig appears twice: $info");
      $info_map[$sig] = new AllInfo($specinfo);
    }
  }

  // Read the current spec/source/sink info
  $lines = file ($report_file, FILE_IGNORE_NEW_LINES);
  $linenum = 0;
  foreach ($lines as $line) {
    $linenum++;
    if (!trim($line) || starts_with ($line, "===========") 
        || contains ($line, "No Source Found") || !contains ($line, "-"))
        continue;
    $line = str_replace ("DSSinkKind", "DSout", $line);
    $line = str_replace ("DSSourceKind", "DSin", $line);
    @list ($sig, $spec, $ss) = preg_split ("/ +- +/", $line);
    $ss = trim ($ss);
    if (!$ss) {
      throw new Exception ("bad line ($report_file:$linenum): '$line'");
    }
    $curinfo = new SpecInfo ($sig, $spec, $ss);
    $sig = preg_replace ("/[<>]/", "", $sig);
    $susi_src_cat = @$susi_src_map[$sig];
    $susi_sink_cat = @$susi_sink_map[$sig];
    $susi_src = array_key_exists ($sig, $susi_src_map);
    $susi_sink = array_key_exists ($sig, $susi_sink_map);
    if (($ss == "NO_INFO") && !$susi_src && !$susi_sink)
      continue;
    $ds_src = contains ($ss, "DSSource");
    $ds_sink = contains ($ss, "DSSink");
    
    if ($ds_src != $susi_src) 
      echo "src:  $ss - $susi_src_cat  <$sig>\n"; 
    if ($ds_sink != $susi_sink)
      echo "sink: $ss - $susi_sink_cat  <$sig>\n"; 
    if (($ds_src == $susi_src) && ($ds_sink == $ds_src))
      echo "match: $ss - $susi_src_cat - $susi_sink_cat <$sig>\n";
  }

  // Read in the list of verified files
  $ver_class_file = dirname(__FILE__) . "/verified_classes.txt";
  $verified_classes = file ($ver_class_file, FILE_IGNORE_NEW_LINES);
  if (!$verified_classes) {
    echo "Can't open $ver_class_file\n";
    exit (-1);
  }
  // printf ("verified_classes = %s\n", implode($verified_classes,":"));

  // Sort the results and output everything together
  ksort ($info_map);
  $last_class = null;
  $class_cnt = 0;
  printf ("%s\n", record ("who", "SDiff", "New Spec", "Cur Spec", "SSDiff",
                          "New SS", "Cur SS", "Cnt", "Signature", "Comment"));
  foreach ($info_map as $sig => $allinfo) {
    $si = $allinfo->spec;
    $ri = $allinfo->report;
    $class = sig_to_class ($sig);
    $method_name = sig_to_method ($sig);
    $cm = "$class: $method_name";
    // printf ("looking up '$cm' in freq_map\n");
    $freq_cnt = -1;
    if (array_key_exists ($cm, $freq_map)) 
      $freq_cnt = $freq_map[$cm];
    if ($class != $last_class) {
      if ($class_cnt > 0) 
        printf ("\n");
      $class_cnt = 0;
      if (array_key_exists ($class, $bcomment))
        printf ("\t\t$bcomment[$class]\n");
      $verified = in_array ($class, $verified_classes);
      if ($verified)
        fwrite(STDERR, "$class is verified\n");
      $last_class = $class;
    }
    if ($si && $ri) { 
      $specdiff = "XX";
      $ssdiff = "XX";
      if ($verified) {
        $specdiff = "XXXX";
        $ssdiff = "XXXX";
      }
      if (contains ($ri->spec, "IPC"))
        $specdiff = "XXXXXX";
      if (contains ($ri->ss, "IPC"))
        $ssdiff = "XXXXXX";
      // echo "cur = '$si->cur_specdiff', '$si->cur_ssdiff'\n";
      if ($si->cur_specdiff)
        $specdiff = $si->cur_specdiff;
      if ($si->cur_ssdiff)
        $ssdiff = $si->cur_ssdiff;
      if (($si->spec == $ri->spec) || 
          (str_replace("DSSpec2", "DSSpec", $si->spec) == $ri->spec))
        $specdiff = " ";
      if ($si->ss == $ri->ss)
        $ssdiff = " ";
      printf ("%s\n", record($si->person, $specdiff, $si->spec, $ri->spec,
                             $ssdiff, $si->ss, $ri->ss, $freq_cnt, 
                             $sig, $si->comment));
      $class_cnt++;
    } else if ($si) {
      printf ("%s\n", record ($si->person, " ", $si->spec, " ", " ", $si->ss,
                              " ", $freq_cnt, $sig, $si->comment));
      $class_cnt++;
    } else if ($ri) {
      if (false) {
        printf ("%s\n", record ($ri->person, " ", " ", $ri->spec, " ", 
                                " ", $ri->ss, $freq_cnt, $sig, $ri->comment));
        $class_cnt++;
      }
    } else {
      throw new Exception ("$sig without info");
    }
  }

}

/** Returns the class from the specified signature **/
function sig_to_class ($sig) {
  return str_replace("<", "", preg_replace ("/:.*/", "", $sig));
}

/** Returns the method name from the specified signature **/
function sig_to_method ($sig) {
  $method_and_args = preg_replace ("/^.*: *[^\s]* /", "", $sig);
  return (preg_replace ("/ *[(].*$/", "", $method_and_args));
}

/** Returns the class: name portion of the signature (no arguments) **/
function sig_to_name ($sig) {
  $class = sig_to_class ($sig);
  $method_name = sig_to_method ($sig);
  $cm = "$class: $method_name";
  return $cm;
}

function record ($person, $specdiff, $spec1, $spec2, $ssdiff, $ss1, $ss2, 
                 $freq_cnt, $sig, $comment) {
  return "$person\t$specdiff\t$spec1\t$spec2\t$ssdiff\t$ss1\t$ss2\t$freq_cnt\t$sig";
}

