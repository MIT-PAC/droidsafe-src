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
