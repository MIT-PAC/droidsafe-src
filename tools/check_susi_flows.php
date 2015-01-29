#! /usr/bin/env php
<?php
$HOME = getenv ("HOME");
include "utils.php";
include "spec_utils.php";

/**
 * check_susi_flows <expected-flow-files>
 *
 * Given a list of expected flow files, indicate which source/sinks are 
 * in the SuSi list

 */

{
  $apac = getenv ("APAC");
  if (!$apac)
    $apac = getenv ("apac");
  if (!$apac) {
    printf ('Cant find apac home in either $apac or $APAC\n');
    exit (-1);
  }

  $usage = "check_susi_flows.php <expected-flow-files>";
  $info_file = null;
  $report_file = null;
  $print_classes_only = false;
  $merged_input = false;
  $susi_sink_file = "$apac/categorize/Ouput_CatSinks_v0_9.txt";
  $susi_src_file = "$apac/categorize/Ouput_CatSources_v0_9.txt";

  $flow_files = array();

  // Process arguments
  for ($i = 1; $i < count ($argv); $i++) {
    $arg = $argv[$i];
    if (($arg == "-debug") || ($arg == "-d"))
      $debug = true;
    else if (starts_with ($arg, "-"))
      usage_err ("Unexpected argument $arg", $usage);
    else {
      $flow_files[] = $arg;
    }
  }
  if (count($flow_files) == 0)
    usage_err ("One or more expected flow files must be specified", $usage);

  // Process the Susi source/sink files
  $susi_sink_map = get_susi_map ($susi_sink_file);
  $susi_src_map = get_susi_map ($susi_src_file);

  $sources = array();
  $sinks = array();
  $no_sinks = array();
  $no_sources = array();    
  $cnt = 0;
  foreach ($flow_files as $flow_file) {
    $lines = file ($flow_file, FILE_IGNORE_NEW_LINES);
    foreach ($lines as $line) {
      if (!starts_with ($line, "FLOW:"))
        continue;
      preg_match_all ("/{.*?}/", $line, $matches);
      // printf ("matches (%d) = %s\n", count($matches[0]), 
      //        implode (":", $matches[0]));
      $cnt++;
      $sink = $matches[0][0];
      $source = $matches[0][1];
      $sink = find_first_preg ("/<.*?>/", $sink);
      $source = find_first_preg ("/<.*?>/", $source);
      // printf ("source = $source, sink = $sink\n");
      $sink = preg_replace ("/[<>]/", "", $sink);
      $source = preg_replace ("/[<>]/", "", $source);
      if (array_key_exists ($sink, $susi_sink_map))
        printf ("sink $sink = $susi_sink_map[$sink]\n");
      else { // not in susi
        printf ("sink $sink not found\n");
        $no_sinks[] = $sink;
      }
      if (array_key_exists ($source, $susi_src_map))
        printf ("source $source = $susi_src_map[$source]\n");
      else { // not in susi
        printf ("source $source not found\n");
        $no_sources[] = $source;
      }
    }
  }

  $no_sinks_unique = array_unique ($no_sinks);
  $no_sources_unique = array_unique ($no_sources);

  printf ("Total flows      = %d\n", $cnt);
  printf ("Non-susi sinks   = %d unique, %d total\n", count ($no_sinks_unique),
          count ($no_sinks));
  foreach ($no_sinks_unique as $ns)
    printf ("    $ns\n");
  printf ("Non-susi sources = %d unique, %d total\n", count ($no_sources_unique),
          count ($no_sources));
  foreach ($no_sources_unique as $ns)
    printf ("    $ns\n");
}
