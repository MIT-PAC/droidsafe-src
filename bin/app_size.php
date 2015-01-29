#! /usr/bin/env php
<?php
$HOME = getenv ("HOME");
include "$HOME/phplib/utils.php";

{
  $files = array();

  // Process arguments
  for ($i = 1; $i < count ($argv); $i++) {
    $arg = $argv[$i];
    if (($arg == "-debug") || ($arg == "-d"))
      $debug = true;
    else if (starts_with ($arg, "-"))
      usage_err ("Unexpected argument $arg");
    else
      $files[] = $arg;
  }

  if (count ($files) == 0)
    $files[] = ".";

  foreach ($files as $dir) {
    $total_lines = 0;
    $files = 0;
    $fp = popen ("find $dir -name '*.java'", "r");
    while (!feof ($fp)) {
      $jfile = trim (fgets ($fp));
      if (!$jfile)
        continue;
      if (!contains ($jfile, "/src/")) {
        if ($debug) printf ("skipping file %s\n", '$jfile');
        continue;
      }
      $line_cnt = trim (shell_exec ("wc -l < $jfile"));
      if ($debug)
        printf ("%5d %s\n", $line_cnt, $jfile);
      $total_lines += $line_cnt;
      $files++;
    }

    if ($dir == ".") {
      $dirname = getcwd();
      $dir_arr = split ("/", $dirname);
      $leaf = $dir_arr[count($dir_arr)-1];
    } else {
      $leaf = $dir;
    }

    printf ("%-22s %5d lines in %d files\n", $leaf.":", $total_lines, $files);
  }
}

?>