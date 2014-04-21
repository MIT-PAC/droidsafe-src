#! /usr/bin/env php
<?php
$HOME = getenv ("HOME");
include "utils.php";

/**
 * merge_spec_info <info_file> <report_file>
 *
 *  Reads a file specifying spec/src/sink information for a set
 *  of calls.  The file is a spreadsheet saved as a tab-separated
 *  text.  The columns are:
 *
 *      person      - person who made the changes
 *      spec        - spec/safe/ban setting
 *      src/sink    - source/sink setting
 *      call        - signature of call
 *      comment     - comment about change
 *
 *  The info file is organized by class.  There is blank row
 *  between each class and at the top of the class there is an
 *  optional comment in the spec column.
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
merge_spec_info.php <info-file> <report-file>
  info-file     - file with new spec information in it
  report-file   - report pulled from current code
USAGE;

{
  $info_file = null;
  $report_file = null;
  $print_classes_only = false;
  $apac = getenv ("APAC");
  $merged_input = false;

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
      if ($info_file == null)
        $info_file = $arg;
      else if ($report_file == null)
        $report_file = $arg;
      else
        usage_err ("Unexpected argument $arg", $usage);
    }
  }
  if (!$info_file || !$report_file)
    usage_err ("Requires two file arguments", $usage);

  // Process the info file and put all of the information
  // into info_map and bcomment
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
    if (!$ss) {
      throw new Exception ("bad line ($report_file:$linenum): '$line'");
    }
    $curinfo = new SpecInfo ($sig, $spec, $ss);
    if (array_key_exists ($sig, $info_map))
      $info_map[$sig]->report = $curinfo;
    else
      $info_map[$sig] = new AllInfo (null, $curinfo);
  }

  // Read in the list of verified files
  $ver_class_file = dirname(__FILE__) . "/verified_classes.txt";
  $verified_classes = file ($ver_class_file, FILE_IGNORE_NEW_LINES);
  if (!$verified_classes) {
    echo "Can't open $ver_class_file\n";
    exit (-1);
  }
  // printf ("verified_classes = %s\n", implode($verified_classes,":"));

  // Get the frequency counts for each method
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

function record ($person, $specdiff, $spec1, $spec2, $ssdiff, $ss1, $ss2, 
                 $freq_cnt, $sig, $comment) {
  return "$person\t$specdiff\t$spec1\t$spec2\t$ssdiff\t$ss1\t$ss2\t$freq_cnt\t$sig";
}
