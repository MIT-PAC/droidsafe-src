#! /usr/bin/env php
<?php
$HOME = getenv ("HOME");

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

  $scripts = "<script src='http://people.csail.mit.edu/jhp/jquery.js'>"
    ."</script>\n" 
    . "<script src='http://people.csail.mit.edu/jhp/java2html.js'></script>\n";

  foreach ($files as $file) {
    $contents = file_get_contents ($file);
    $contents = str_replace ("</HEAD>", "$scripts\n</HEAD>", $contents);
    file_put_contents ($file, $contents);
    echo "updated file $file\n";
  }
  
}

/** Exits with the specified error message **/
function usage_err ($msg, $usage = "") {
  echo "Error: $msg\n";
  if ($usage)
    echo "Usage: $usage\n";
  exit (1);
}

// returns true if $str starts with $substr
function starts_with ($str, $substr) {
  return (strpos ($str, $substr) === 0);
}


?>