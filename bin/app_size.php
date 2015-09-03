#! /usr/bin/env php
#
# Copyright (C) 2015,  Massachusetts Institute of Technology
# 
# This program is free software; you can redistribute it and/or modify it
# under the terms of the GNU General Public License as published by the
# Free Software Foundation; either version 2 of the License, or (at your
# option) any later version.
# 
# This program is distributed in the hope that it will be useful, but 
# WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
# or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
# for more details.
# 
# You should have received a copy of the GNU General Public License along
# with this program; if not, write to the Free Software Foundation, Inc., 
# 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
# 
# Please email droidsafe@lists.csail.mit.edu if you need additional
# information or have any questions.
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