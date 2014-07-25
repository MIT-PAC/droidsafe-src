<?php

function jwhich ($class, $classpath = "") {

  if ($classpath == "")
    $classpath = getenv ("CLASSPATH");

  if (!ends_with ($class, ".class"))
    $class .= ".class";

  $class_dirs = explode (":", $classpath);
  foreach ($class_dirs as $dir) {
    // echo "looking for $class in $dir\n";
    if (file_exists ("$dir/$class"))
      return ("$dir/$class");
  }

 return (false);
}

// Builds the javap line number table for the specified class and
// returns the file that contains it.  This caches up results since
// javap is not terrible quick
function build_javap_lt ($package, $class) {

  // Find the file containing the specified class
  $package_fname = str_replace (".", "/", $package);
  $class_fname = str_replace (".", "$", $class);
  $class_path = jwhich ("$package_fname/$class_fname");

  // Some inner classes have a 1 prepended to their names
  if (!$class_path) {
    $class_1fname = str_replace ("$", "$1", $class_fname);
    $class_path = jwhich ("$package_fname/$class_1fname");
    if (!$class_path) {
      echo "build_javap_lt: Can't find package/class file '$package.$class'\n";
      exit;
    }
    $class_fname = $class_1fname;
  }

  $user = getenv ("USER");
  sys ("install -d -m 777 /tmp/$user/javap");
  $outfile = "/tmp/$user/javap/${class}.txt";
  $cmd = "javap -private -l $package.$class";
  if (file_exists ($outfile)) {
    $out_mtime = filemtime ($outfile);
    $src_mtime = filemtime ($class_path);
    if ($src_mtime > $out_mtime) {
      sys ("$cmd > $outfile");
    }
  } else {
    sys ("$cmd > $outfile");
  }

  return ($outfile);
}

function sys ($command) {

  global $sys_echo;

  if ($sys_echo)
    echo "$command\n";

  system ($command, $ret);
  return ($ret);
}

/**
 * Execute each of the commands in the array $commands.  Stop if an error
 * occurs.  If an error occurs, returns it, otherwise returns 0
 */
function sys_until_error ($commands) {

  foreach ($commands as $command) {
    $err = sys ($command);
    if ($err)
      return ($err);
  }
  return 0;
}

// returns true if $str starts with $substr
function starts_with ($str, $substr) {
  return (strpos ($str, $substr) === 0);
}

// returns true if $str ends with $substr
function ends_with ($str, $substr) {
  $substr = preg_quote ($substr, "/");
  return preg_match ("/$substr" . '$/', $str);
}

/** returns true if $str contains $substr **/
function contains ($str, $substr) {
  return (strpos ($str, $substr) !== false);
}

/**
 * If the next line is blank, reads it and returns true.  Otherwise,
 * nothing from the file is read and returns false.
 */
function found_blank_line ($fp) {
  $tell = ftell ($fp);
  $line = fgets ($fp, 4096);
  if (trim ($line) == "")
    return true;
  fseek ($fp, $tell);
  return false;
}

function get_tok ($str, &$offset, &$white_space) {

  $rstr = substr ($str, $offset);
  $result = ereg ("(^[ \n\t]*)([^ \n\t]+)", $rstr, $regs);
  $white_space = $regs[1];
  if ($result === false) {
    $tok = null;
    $offset += strlen ($white_space);
  } else {
    $tok = $regs[2];
    $offset += strlen ($white_space) + strlen ($tok);
  }

  return ($tok);
}

/** Exits with the specified error message **/
function usage_err ($msg, $usage = "") {
  echo "Error: $msg\n";
  if ($usage)
    echo "Usage: $usage\n";
  exit (1);
}

/** place a debugging log message in a queue of messages **/
function dlog ($msg) {
  global $dlog_messages;

  $dlog_messages[] = $msg;
}

function dump_dlog() {
  global $dlog_messages;

  if (!$dlog_messages) {
    echo "<h4> No Debug Messages </h4>\n";
    return;
  }

  echo "<h4>Debug Messages</h4>\n";
  foreach ($dlog_messages as $msg) {
    echo "$msg<br>\n";
  }

  $dlog_messages = array();
}

function ftime() {
  $ta = explode (" ", microtime());
  return (float)$ta[1] + (float)$ta[0];
}

/**
 * Looks for the specified file starting in the directory indicated
 * by $top.  Uses find
 */
function find_file ($fname, $top = ".") {

  $files = `find $top -name '$fname'`;
  return $files;
}

function human_number ($num) {

  $exps = array ("T" , "G", "M", "K");
  for ($exponent = 1000000000000.0; $exponent > 0.1; $exponent /= 1000) {
    if ($num > $exponent) {
      $num = round($num/$exponent);
      return $num . $exps[0];
    }
    array_shift ($exps);
  }
  return $num;
}

/**
 * Cleans a line of comments and returns the non-comment contents.  Supports
 * // and #  comments
 **/
function clean_line($line) {

  $line = trim ($line);
  $line = preg_replace ("!//.*|#.*!", "", $line);
  return ($line);
}

function fopen_exc ($file, $mode) {

  $fp = @fopen ($file, $mode);
  if (!$fp)
    throw new Exception ("Can't open file '$file'");
  return $fp;
}

/**
 * Returns an HTML formatted exception
 */
function html_exception ($e) {

  $out = "Exception: " . $e->getMessage(). "<br>\n";
  $out .= sprintf ("file %s, line %d<br>\n", $e->getFile(), $e->getLine());
  foreach ($e->getTrace() as $trace) {
    $out .= sprintf ("file %s, line %d<br>\n", $trace['file'], $trace['line']);
  }
  return ($out);
}

/**
 * Returns a text formatted exception.  Be very careful not to cause 
 * other errors as that may lead to exceptions within exceptions
 */
function text_exception ($e) {

  $out = "Exception: " . $e->getMessage(). "\n";
  $out .= sprintf ("file %s, line %d\n", $e->getFile(), $e->getLine());
  foreach ($e->getTrace() as $trace) {
    $fname = "unknown";
    if (isset($trace['file']))
      $fname = $trace['file'];
    $lnum = "??";
    if (isset($trace['line']))
      $lnum = $trace['line'];
    $out .= sprintf ("file %s, line %d\n", $fname, $lnum);
  }
  return ($out);
}
    
/** Returns true if the specified directory is SVN controlled **/
function is_svn ($dir = ".") {
  $output = array();
  exec ("svn info 2>&1", $output, $result);
  return ($result === 0);
}

/** Returns true if the specified directory is GIT controlled **/
function is_git ($dir = ".") {
  $output = array();
  exec ("git rev-parse 2>&1", $output, $result);
  return ($result == 0);
}

/**
 * Returns the string that matches the specified regular expression.
 *
 * Returns the characters that matched the pattern or the empty string
 * if there was no match.
 */
function find_first_preg ($preg, $subject) {
  $result = preg_match ($preg, $subject, $matches);
  if ($result == 1)
    return $matches[0];
  else
    return "";
}
    

?>
