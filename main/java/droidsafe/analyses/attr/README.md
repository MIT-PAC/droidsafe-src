Value Analysis
==============

Summary
-------

Value analysis is a flow and context insensitive analysis
responsible for conservatively keeping track of field values for
select object types (currently URIs & Intents).

The goal is to be able to present the analyst and other analyses with
as much info about each object at the time of its use as possible.

e.g.

* A new activity is started - analyst may want to know which activity
  exactly (need to model Intent).

* A network operation is started - analyst may want to know possible
  sources and destinations (need to model URI)

We decide which API classes are important to model, and for which
fields of each classes we want to attempt to calculate the values.

For example, Intent is a class that we have decided it is important to
model because of how it is used.  In the Intent's model class we have included
the following fields to track:

* String: mType, mAction, mPackage
* Integer: mFlags

The Intent model also includes a field that is a reference to a
different modeled class, Bundle (the field is named mExtras).  Bundle
itself is a modeled class with its own fields, and the analysis result
will use resolve values for Bundle as well.

The analysis result is, for each static allocation site of a modeled
class, a calculated set of values for each of the fields
of that class. Values that are modeled classes themselves, such as Bundle above, may be invalidated (meaning we don't know the the values of any of its fields) because there was an operation on the object
that we did not model, or cannot model currently.

How It's Results Are Used
-------------------------

* After the analysis is run, each static allocation site for a modeled class will be associated with an instance of the modeled class that is either invalidated or stores the set of values calculated for each field.

* The analysis result, the values calculated for the fields of objects
  of modeled classes, is used by the information flow to determine the
  taint kind for information flow sources that are dynamic in nature.
  For example, the information delivered by a database query is
  dependent on the database queried.  So we resolve the address of the
  database (a string), and use this to calculate the taint on any
  queries to the database.

  When Deokhwan Kim's <dkim@csail.mit.edu> info-flow analysis comes
  across a "new" expression, it asks the InjectedSourceFlows class
  what information kind, if any, is attached to each field to the
  newly-constructed object.  This class in turn queries the value modeling results
  modeling results and, using a hard-coded mapping between string
  regexs and info kinds, returns the appropriate answer.

How It Works
------------

Value analysis is made of two parts -

1. The first is a set of models written in legal java code. These
   models mirror the classes of the objects that we want to track the
   values of and classes that contain methods that modify the fields
   of the objects we want to model. The packages of these classes are
   their packages in the android api with
   "droidsafe.analyses.attr.models." prepended in front.
   (e.g. android.content.Intent becomes
   droidsafe.analyses.attr.models.android.content.Intent)

   The fields that we want to model can be divided into two groups -
       1. The type of the fields in the first group is a class that we model. At the end of the analysis, each of these fields is an instance of the model class. This model class may be invalidated, meaning we can't say what the values of any of its fields are. For a given application, every method that may modify the object must be modeled in order for the object to not be invalidated. It is possible for only one or more fields to be invalidated instead of the whole model. In that case those field must belong in this group.
       2. The type of the fields in the second group are boxed-up primitive classes and strings. In the model class, these are always represented as Sets. (e.g. String action in Android's Intent class becomes Set<String> in the corresponding model class). We currently do not support the invalidation of these fields.
   

2. The second is an analysis algorithm that walks over every statement
   in the application code + GITI modeling code and tries to simulate
   every invoke statement by using reflection to call the
   corresponding method in the appropriate model as described
   above. The signature of the method is modified to replace
   argument/receiver types with our models. (e.g. Intent's
   setData(android.net.Uri uri) becomes
   setData(droidsafe.analyses.attr.models.android.net.Uri uri)).

   The reflection call is done for every combination (cartesian
   product) of argument & receiver objects.

   If for some reason a method cannot be simulated, then we invalidate
   the receiver's model object as well as the model object of any objects that could
   have been referenced from any of the parameters, as determined by
   PTA. We assume that API calls that modify attributes are idempotent
   and don't interact.

The analysis runs multiple times until it reaches a fixed point. This
is necessary because the analysis is not flow sensitive and thus if
values of fields of objects rely on other object's field values, the values
may not propagate fully by just one run of the analysis.

If all goes well then at the end of the analysis each AllocNode has a
corresponding valid model object whose fields are all the possible values
that that AllocNode's fields could have taken on.

How to Model
--------------

It is most effective to start with an application that is short and an
object of a Class that we consider security sensitive (e.g. Intent,
URI, etc). This object should be one for which we should expect to
know the value of some field(s).

Then go to the root of the application and run "make specdump-debug". Search through the generated droidsafe/droidsafe.log file for "Starting Attribute Modeling". You will see a list of allocation sites
and their corresponding model objects if they exist. The goal is to display each AllocNode's calculated field values.

If the Class of the object you want to model doesn't exist, then create the java file
for it in the appropriate location in (models). The location (and
hence package ending after droidsafe.analyses.attr.models.) should
correspond to what it is in the android source. (see the [Intent
Model](models/android/content/Intent.java) for an example). Don't
worry about modeling any methods just yet.

After creating the class file, go back to the application and run "make specdump-debug" again. In the log file, in the "Starting Attribute Modeling" section, the corresponding model object for the allocNode will likely be invalidated. Take note of the id # of the AllocNode and view the file droidsafe/attr-modeling-errors.log. Search it for the id. This should lead you to finding out what invalidated the model object. Typically it is because a method hasn't been modeled.

To model a method, start by copying it's implementation in the [android source](http://grepcode.com/file/repository.grepcode.com/java/ext/com.google.android/android/4.0.3_r1/android). Then follow the set of rules below -

* Constructors should be methods with return type void and name _init_

* Only the parts of the method that modify a security-sensitive
  attribute of the model should be kept.

* Every primitive type should be boxed up and made a set. Aka if a
  parameter type is "int", it should be changed to Set<Integer>.

* Every String argument or return type should be changed to
  Set<String>. The implementation of the modeled method must take into
  account every possible string in this set.

* Instead of HashSet, use AttrModelingSet. AttrModelingSet helps the
  analysis run to fixed point by keeping track of whether new values
  have been added on each run.

* We do not track allocations. Clone methods and such should not be
  modeled. That is the job of GITI's modeling.

* Every model must have a dsDisplay model that prints out the values of the fields you are tracking.

Dependencies
------------

* PTA (points-to-analysis)

    * A method target or parameter that is a reference can point to
      more than one object depending on the context.  Since value analysis is conservative, it simulates everything that could possibly happen by taking into account every possible object.

* JSA

    * When it comes to string values, value analysis does not keep
      track of them but just uses JSA's results.

* GITI's modeling

    * Only objects that are allocated somewhere in the code that
      value modeling analyzes get modeled. This means that we need
      a simplified version of the android api that at the very least
      contains all the appropriate allocations.

    * In between event invocations and event handlers, newly allocated
      objects' fields' values may be based off of previously
      modeled ones (e.g. the intent between startActivityForResult and
      onActivityResult). We need a simulation of how these fields
      are set to accurately be able to model them.

Questions?
----------

Contact Dmitrij Petters <dpetters@mit.edu>
