<?php
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

/**
 * Calculates the map from signature to category from a SuSi file
 */
function get_susi_map ($filename) {

  $susi = file ($filename, FILE_IGNORE_NEW_LINES);
  $map = array();
  foreach ($susi as $item) {
    $result = parse_susi ($item);
    if (!$result)
      continue;
    list ($sig, $type) = $result;
    // echo "$sig - $type\n";
    $map[$sig] = $type;
  }
  return $map;
}

/**
 * Parses a SuSi input line which is of the form:
 *      <Signature> (Category)
 *
 * Returns false if the line is a blank or comment, otherwise returns a
 * two element array with signature as the first element and category as
 * the second.
 **/
function parse_susi ($line) {
  $line = trim ($line);
  if (!$line)
    return false;
  if (ends_with ($line, ":"))
    return false;
  list ($sig, $extra) = explode (">", $line);
  $sig = substr ($sig, 1);
  $extra_arr = explode (" ", $extra);
  $type = "";
  // printf ("extra-arr = '%s'\n", implode ($extra_arr, ":"));
  foreach ($extra_arr as $extra) {
    $extra = trim ($extra);
    // echo "processing '$extra'\n";
    if ($extra && !starts_with ($extra, "android.permission")) {
      $type = preg_replace ("/[()]/", "", $extra);
      break;
    }
  }
  if (!$type) {
    echo "Can't find category ($type) for '$line'\n";
    exit (-1);
  }
  return array ($sig, $type);
}
