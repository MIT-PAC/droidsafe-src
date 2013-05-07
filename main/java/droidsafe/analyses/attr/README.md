Attribute Modeling
==================

Summary
-------

Attribute modeling is a flow and context insensitive analysis responsible for conservatively keeping track of attribute values for select object types (currently URIs, Intents, and Strings).

The goal is to be able to present the analyst and other analyses with as much info about each object at the time of its use as possible.

e.g.

* A new activity is started - analyst may want to know which activity exactly (need to model Intent).
* A network operation is started - analyst may want to know possible sources and destinations (need to model URI)


How It's Results Are Used
-------------------------

* When Deokhwan Kim's <dkim@csail.mit.edu> info-flow analysis comes across a "new" expression, it asks the InjectedSourceFlows class what information kind, if any, is attached to each field to the newly-constructed object. This class in turn queries the attribute modeling results and, using a hard-coded mapping between string regexs and info kinds, returns the appropriate answer.

How It Works
------------

Attribute modeling is made of two parts -

    1. The first is a set of models written in legal java code. These models mirror the classes of the objects that we want to track the values of and classes that contain methods that modify the values of the objects we want to model. The packages of these classes are their packages in the android api with "droidsafe.attr-models" prepended in front. (e.g. android.content.Intent becomes droidsafe.attr-models.android.content.Intent)

    At the end of the analysis, each models' attributes are either a list of possible values that they could be, or the whole model is invalidated, meaning we can't say what any of the values of any of the attributes are. If the original type of an attribute is a primitive, then the model's attribute value is a list of that primitive. If the original type is an android object that we model, then the list is of our corresponding model's instances.

    For a given application, every method that modifies an object must be modeled in order for the object to not be invalidated. It is possible for only one or more attributes to be invalidated instead of the whole model. In that case the attributes are of types that we model and were invalidated.

    2. The second is an analysis algorithm that walks over every statement in the application code + GITI modeling code and tries to simulate every invoke statement by using reflection to call the corresponding method in the appropriate model as described above. The signature of the method is modified to replace argument/receiver types with our models. (e.g. Intent's setData(android.net.Uri uri) becomes setData(droidsafe.model.android.net.Uri uri)).

    The reflection call is done for every combination (cartesian product) of argument & receiver objects.

    If for some reason a method cannot be simulated, then we invalidate the receiver's model as well as the model of any objects that could have been referenced from any of the parameters, as determined by PTA.
    We assume that API calls that modify attributes are idempotent and don't interact.

The analysis runs multiple times until it reaches a fixed point. This is necessary because the analysis is not flow sensitive and thus if attributes of objects rely on other object's attributes, the values may not propagate fully if loops are present.

If all goes well then at the end of the analysis each allocNode has a corresponding valid model whose attributes are all the possible values that that allocnode's attribute could have taken on.

Dependencies
------------

* PTA (points-to-analysis)
    * A method target or parameter that is a reference can point to more than one object depending on the context. Since attribute modeling is conservative, it simulates everything that could possibly happen by taking into account every possible object.

* JSA
    * When it comes to string values, attribute modeling does not keep track of them but just uses JSA's results.

* GITI's modeling
    * Only objects that are allocated somewhere in the code that attribute modeling analyses get modeled. This means that we need a simplified version of the android api that at the very least contains all the appropriate allocations.
    * In between event invocations and event handlers, newly allocated objects may be given attribute values based off of previously modeled ones (e.g. the intent between startActivityForResult and onActivityResult). We need a simulation of how these attributes are set to accurately be able to model them.

Questions?
----------

Contact Dmitrij Petters <dpetters@mit.edu>
