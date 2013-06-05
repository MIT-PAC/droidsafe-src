Attribute Modeling
==================

Summary
-------

Attribute modeling is a flow and context insensitive analysis responsible for conservatively keeping track of attribute 
values for select object types (currently URIs & Intents).

The goal is to be able to present the analyst and other analyses with as much info about each object at the time of its use as possible.

e.g.

* A new activity is started - analyst may want to know which activity exactly (need to model Intent).
* A network operation is started - analyst may want to know possible sources and destinations (need to model URI)


How It's Results Are Used
-------------------------

* When Deokhwan Kim's <dkim@csail.mit.edu> info-flow analysis comes across a "new" expression, it asks the 
  InjectedSourceFlows class what information kind, if any, is attached to each field to the newly-constructed object. 
  This class in turn queries the attribute modeling results and, using a hard-coded mapping between string regexs and 
  info kinds, returns the appropriate answer.

How It Works
------------

Attribute modeling is made of two parts -

1. The first is a set of models written in legal java code. These models mirror the classes of the objects that we want 
   to track the values of and classes that contain methods that modify the values of the objects we want to model. The 
   packages of these classes are their packages in the android api with "droidsafe.analyses.attr.models." prepended in front. 
   (e.g. android.content.Intent becomes droidsafe.analyses.attr.models.android.content.Intent)

   At the end of the analysis, each models' attributes are either a set of possible values that they could be, or the 
   whole model is invalidated, meaning we can't say what any of the values of any of the attributes are. If the original 
   type of an attribute is a primitive, then the model's attribute value is a set of boxed-up primitive objects. If the original type is an android object that we model, then the list is of our corresponding model's instances.

   For a given application, every method that may modify an object must be modeled in order for the object to not be 
   invalidated. It is possible for only one or more attributes to be invalidated instead of the whole model. In that 
   case the attributes are of types that we model and were invalidated.

2. The second is an analysis algorithm that walks over every statement in the application code + GITI modeling code 
   and tries to simulate every invoke statement by using reflection to call the corresponding method in the 
   appropriate model as described above. The signature of the method is modified to replace argument/receiver types 
   with our models. (e.g. Intent's setData(android.net.Uri uri) becomes setData(droidsafe.analyses.attr.models.android.net.Uri uri)).

   The reflection call is done for every combination (cartesian product) of argument & receiver objects.

   If for some reason a method cannot be simulated, then we invalidate the receiver's model as well as the model of any 
   objects that could have been referenced from any of the parameters, as determined by PTA. We assume that API calls 
   that modify attributes are idempotent and don't interact.

The analysis runs multiple times until it reaches a fixed point. This is necessary because the analysis is not flow 
sensitive and thus if attributes of objects rely on other object's attributes, the values may not propagate fully by just one run of the analysis.

If all goes well then at the end of the analysis each allocNode has a corresponding valid model whose attributes are 
all the possible values that that allocnode's attribute could have taken on.

How to Model
--------------

It is most effective to start with an application that is short and an object of a Class that we consider security sensitive (e.g. Intent, URI, etc). This object should be one for which we should expect to know the value of some attribute(s).

Then go to the root of the application and run "make specdump". Then search through the generated droidsafe/droidsafe.log file for "Starting Attribute Modeling". You will see a list allocation sites and their corresponding models if they exist. The goal to to have the model be printed for the object that you are trying to model and have the possible values of it's attribute be what we expect them to be.

If the Class of this object doesn't exist, then create the java file for it in the appropriate location in (models). The location (and hence package ending after droidsafe.analyses.attr.models.) should correspond to what it is in the android source. (see the [Intent Model](models/android/content/Intent.java) for an example). Don't worry about modeling any methods just yet.


If you're modeling a method, start by copying it's implementation in the [android source](http://grepcode.com/file/repository.grepcode.com/java/ext/com.google.android/android/4.0.3_r1/android). Then follow the set of rules below -

* Constructors should be methods with return type void and name _init_
* Only the parts of the method that modify a security-sensitive attribute of the model should be kept.
* Every primitive type should be boxed up and made a set. Aka if a parameter type is "int", it should be changed to Set<Integer>.
* Every String argument or return type should be changed to Set<String>. The implementation of the modeled method must take into account every possible string in this set. For a good example, see the 
* Instead of HashSet, use AttrModelingSet. AttrModelingSet helps the analysis run to fixed point by keeping track of whether new values have been added on each run.
* We do not track allocations. Clone methods and such should not be modeled. That is the job of GITI's modeling.
* Every model must have a dsDisplay model that prints out any attributes you are tracking the values of.

Dependencies
------------

* PTA (points-to-analysis)
    * A method target or parameter that is a reference can point to more than one object depending on the context.
      Since attribute modeling is conservative, it simulates everything that could possibly happen by taking into 
      account every possible object.

* JSA
    * When it comes to string values, attribute modeling does not keep track of them but just uses JSA's results.

* GITI's modeling
    * Only objects that are allocated somewhere in the code that attribute modeling analyses get modeled. This means 
      that we need a simplified version of the android api that at the very least contains all the appropriate 
      allocations.
    * In between event invocations and event handlers, newly allocated objects may be given attribute values based off 
      of previously modeled ones (e.g. the intent between startActivityForResult and onActivityResult). We need a 
      simulation of how these attributes are set to accurately be able to model them.

Questions?
----------

Contact Dmitrij Petters <dpetters@mit.edu>
