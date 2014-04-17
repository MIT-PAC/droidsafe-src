#! /usr/bin/env php
<?php
$HOME = getenv ("HOME");
include "utils.php";
include "spec_utils.php";

$usage = "update_spec_info <spec-file>";

{
  $spec_file = null;
  $apac = getenv ("APAC");

  // Process arguments
  for ($i = 1; $i < count ($argv); $i++) {
    $arg = $argv[$i];
    if (($arg == "-debug") || ($arg == "-d"))
      $debug = true;
    else if (starts_with ($arg, "-"))
      usage_err ("Unexpected argument $arg", $usage);
    else {
      if ($spec_file == null)
        $spec_file = $arg;
      else
        usage_err ("Unexpected argument $arg", $usage);
    }
  }
  if (!$spec_file)
    usage_err ("Requires one file arguments", $usage);

  // Read in the list of verified files
  $ver_class_file = dirname(__FILE__) . "/verified_classes.txt";
  $verified_classes = file ($ver_class_file, FILE_IGNORE_NEW_LINES);
  if (!$verified_classes) {
    echo "Can't open $ver_class_file\n";
    exit (-1);
  }

  $all_info = file ($spec_file, FILE_IGNORE_NEW_LINES);
  $bcomment = null;
  foreach ($all_info as $info) {
    @list ($person, $cur_specdiff, $newspec, $curspec, $cur_ssdiff, 
           $newss, $curss, $freq_cnt, $sig, $comment) = explode ("\t", $info);
    if ($person == "who") {
      printf ("%s\n", record($person, $cur_specdiff, $newspec, $curspec,
                             $cur_ssdiff, $newss, $curss, $freq_cnt, 
                             $sig, $comment)); 
    } else if (!$sig && !$newspec) {
      echo "\n";
      if ($bcomment)
        printf ("\t\t%s\n", $bcomment);
      $bcomment = null;
    } else if (!$sig) {
      if ($newspec)
        $bcomment = $newspec;
    } else { // standard line
      // if there are only minor diffs between new and cur, just use cur
      if (($newspec == "@DSSafe") && starts_with ($curspec, "@DSSafe"))
        $newspec = $curspec;

      $class = sig_to_class ($sig);
      $verified = in_array ($class, $verified_classes);
      $specdiff = "XX";
      $ssdiff = "XX";
      if ($verified) {
        $specdiff = "XXXX";
        $ssdiff = "XXXX";
      }
      if (contains ($curspec, "IPC"))
        $specdiff = "XXXXXX";
      if (contains ($curss, "IPC"))
        $ssdiff = "XXXXXX";
      if ($newspec == $curspec)
        $specdiff = " ";
      if ($newss == $curss)
        $ssdiff = " ";
      if ($cur_specdiff == "OK")
        $specdiff = "OK";
      if ($cur_ssdiff == "OK")
        $ssdiff = "OK";
      printf ("%s\n", record($person, $specdiff, $newspec, $curspec,
                             $ssdiff, $newss, $curss, $freq_cnt, 
                             $sig, $comment));
    }
  }
}
        

