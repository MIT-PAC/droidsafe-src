  // Show documentation for a class.
  showdoc = function(cls,anchor) {
    var url = cls.replace(/\./g,'/').replace(/[$][0-9]+/,'');


    if (url.match(/^java/)) {
      url = 'http://docs.oracle.com/javase/6/docs/api/' + url;
      url += '.html';
    } else if (url.match(/^android/)) {
      url = 'http://developer.android.com/reference/' + url;
      url += '.html';
    } else {
      url = 'jsrc/' + url;
      url += '.java.html';
    }

    if (anchor) {
      url = url + '#' + anchor;
    }


    console.log("Opening doc url " + url);

    $('#doc').empty();
    // Frame stuff
    frame = document.createElement('iframe');
    frame.id = 'documentation-frame';
    frame.src = url;
    frame.width = "100%";
    frame.height = "100%";
    $('#doc').append(frame);
  }


  // Generic event handling mixin.
  Events =  {
    bind: function(evt,handler) {
      events = this.events || (this['events'] = {});
      handlers = events[evt] || (events[evt] = []);
      handlers.push(handler);
      return this;
    },

    fire: function (evt) {
      var source = this;
      var events = this.events || (this.events = {});
      var handlers = events[evt] || [];
      args = [source];
      for (var arg in arguments) {
        args.push(arguments[arg]);
      }

      var caller;
      switch (args.length) {
        case 1:
        caller = function (h) { return h.call(args[0])};
        break;
        case 2:
        caller = function (h) { return h.call(args[0],args[1])};
        break;
        case 3:
        caller = function (h) { return h.call(args[0],args[1],args[2])};
        break;
        case 4:
        caller = function (h) { return h.call(args[0],args[1],args[2],args[3])};
        break;
        default:
        caller = function (h) { return h.apply(args)};
      }

      // console.log(args);
      _.each(handlers, function (handler) {
        caller(handler);
      });
      return this;
    }
  };


  // A Method corresponds to a droidsafe api endpoint, not an method implementing an event handler.
  Method = function (attributes) {
    _.extend(this,attributes);
    this.classification = [];
  }
  _.extend(Method.prototype,Events, {
    get: function(key) {
      return this.attributes[key];
    },

    hide: function () {
      this.visible = false;
      this.fire('hide');
    },

    show: function () {
      this.visible = true;
      this.fire('show');
    },

    classify: function (cls) {
      this.classification.push(cls);
      this.fire('reclassify');
    },

    unclassify: function(cls) {
      this.classification = _.without(this.classification,cls);
      this.fire('reclassify');
    },

    // The anchor for the method
    docanchor: function () {
      return this.method + '(' + _.pluck(this.arguments, 'type').join() + ')';
    }

  });



  // We keep a cache of methods in the methodlist, to reduce overhead, and to make
  // method modifications propogate events to all callers.
  MethodList = function () {
    this.apis = {}
  }

  _.extend(MethodList.prototype, {
    register: function (m) {
      // console.log(m);
      m.argstr = JSON.stringify(m.arguments);
      // console.log(m.class);
      cls = this['apis'][m.class] || (this['apis'][m.class] = []);

      var msmall = _.clone(m);
      delete msmall['arguments'];
      var method = _.findWhere(cls,msmall);
      if (method) {
        return method;
      } else {
        method = new Method(m);
        cls.push(method);
        return method;
      }
    },

    getAPIs: function () {
      var sorted = _.sortBy(_.pairs(this.apis), function (p) { return p[0];});
      return _.map(sorted,function (p) {
              return { 'class': p[0], 'methods':p[1]};
            });
    }

  });

  methods = new MethodList();


  // A callview represents an API call within a handler.
  CallView = function (attributes) {
    this.attributes = attributes;
    var m = _.clone(this.attributes);
    delete m['lines'];
    this.attributes.method = methods.register(m);
    this.tmpl = Handlebars.compile($('#callview-template').html());
    this.initialize.apply(this,arguments);

  };

  _.extend(CallView.prototype, Events, {
    initialize: function (attributes) {
      // console.log("called callview initialize");
      var self = this;
      this.attributes.method.bind('update', function (args) {
        self.updateMethod(args);
      });

      this.attributes.method.bind('hide', function (args) {
        self.hideMethod(args);
      });

      this.attributes.method.bind('show', function (args) {
        self.showMethod(args);
      });

      this.attributes.method.bind('reclassify', function (args) {
        self.reclassifyMethod(args);
      });

    },

    render: function (container) {
      // console.log(this.attributes.method);
      var html = this.tmpl(this.attributes).trim();
      var dom = this.el = $(html);
      container.append(dom);

      // Add a click handler on the method name
      var methodname = $('a[class="method-name"]', dom);
      var self = this;
      methodname.click(function () {
        var anchor = self.attributes.method.docanchor();
        console.log(anchor);
        showdoc(self.attributes.method.class,anchor);
      })

      // Add click handlers for all of the calls
      var calls = $('a[class="method-call"]',dom);
      // console.log(calls);
      calls.click(function (evt) {
        var line = $(evt.target).data('line');
        var cls = self.get('handler').get('class').get('class');
        showdoc(cls,line);
      });
    },


    // Notify when method is updated.
    updateMethod: function (args) {
      console.log('updated method');
    },

    hideMethod: function () {
      if (! this.el) {
        return;
      }
      this.el.hide();
      this.fire('hideMethod');
    },

    showMethod: function () {
      if (! this.el) {
        return;
      }
      this.el.show();
      this.fire('showMethod');
    },

    reclassifyMethod: function () {
      this.el.removeClass();
      this.el.addClass('apicall');
      var self = this;
      _.each(this.attributes.method.classification,
        function (cls) { self.el.addClass(cls);});
    },


    visible: function () {
      return this.attributes.method.visible;
    },


    // FIXME: Set/Get should be factored out, or we should eliminate the
    // attributes hash, since it really doesn't make a lot of sense for this
    // application.
    set: function(key,value) {
      this.attributes[key] = value;
      return value;
    },

    get: function(key) {
      return this.attributes[key];
    }

  });


  // Generic mixin for tree-like display, where the body can be expanded or collapsed.
  // Both HandlerView and ClassView include TreeView.
  TreeView = {
    toggleVisible: function () {
      var body = this.treebody;
      if (! body) {
        return;
      }

      var visible = body.is(":visible");
      if (visible) {
        body.hide();
      } else {
        body.show();
      }
    },

    expand: function () {
      var body = this.treebody;
      if (! this.body) {
        return;
      }
      body.show();
    },

    contract: function () {
      var body = this.treebody;
      if (! this.body) {
        return;
      }
      body.hide();
    }

  }


  HandlerView = function (attributes) {
    this.attributes = attributes;
    this.initialize.apply(this,arguments);
  };

  _.extend(HandlerView.prototype, Events, TreeView, {
    initialize: function (attributes) {

      var self = this;
      var calls = _.map(attributes.calls, function (call) {
        var c = new CallView(call);
        c.set('handler', self);

        // c.bind('showMethod', this.expand);
        return c;
      });
      this.attributes.apicalls = calls;

      this.tmpl = Handlebars.compile($('#handlerview-template').html());
    },

    render: function (container) {
      var html = this.tmpl(this.attributes).trim();
      var dom = this.el = $(html);
      container.append(dom);
      var treebody = this.treebody = $('div[class="tree-body"]',dom);
      _.each(this.attributes.apicalls, function (call) {
        call.render(treebody);
      });

        // Set up the handler for toggling visiblity
        var button = $('a[class="expand-button"] :first',dom);
        var tree = this;
        button.click(
          // FIXME: Should be able to use bind here.
          function () { return tree.toggleVisible(); });


      return this;
    },


   // FIXME: Set/Get should be factored out, or we should eliminate the
    // attributes hash, since it really doesn't make a lot of sense for this
    // application.
    set: function(key,value) {
      this.attributes[key] = value;
      return value;
    },

    get: function(key) {
      return this.attributes[key];
    }

  });

  ClassView = function (attributes) {
    this.attributes = attributes;
    this.initialize.apply(this,arguments);
  };


  _.extend(ClassView.prototype, Events, TreeView,
    {
      initialize: function (attributes) {
        // console.log("called classview initialize");

        var self = this;
        var handlers = _.map(this.attributes.events, function (event)
        {
          var e = new HandlerView(event);
          e.set('class', self);
          return e;
        });
        this.attributes.handlers = handlers;

        this.tmpl = Handlebars.compile($('#classview-template').html());
      },

      render: function (container) {
        container = container || $('#classlist');
        var html = this.tmpl(this.attributes).trim();
        var dom = this.el = $(html);
        $(container).append(dom);
        var treebody = this.treebody = $('div[class="tree-body"]',dom);
        _.each(this.attributes.handlers,function (event) {
           event.render(treebody);
        });

        // Set up the handler for toggling visiblity
        var button = $('a[class="expand-button"] :first',dom);
        var tree = this;
        button.click(
          // FIXME: Should be able to use bind here.
          function () { return tree.toggleVisible(); });
        return this;
      },

   // FIXME: Set/Get should be factored out, or we should eliminate the
    // attributes hash, since it really doesn't make a lot of sense for this
    // application.
    set: function(key,value) {
      this.attributes[key] = value;
      return value;
    },

    get: function(key) {
      return this.attributes[key];
    }


    }
    );

  APIClassView = function (attributes) {
    this.attributes = attributes;
    this.initialize.apply(this, arguments);

  }


  _.extend(APIClassView.prototype, TreeView,
  {
    initialize: function (attributes) {
      self=this;
      this.tmpl = Handlebars.compile($('#apiclassview-template').html());
      this.apimethods = _.map(attributes.methods,
        function (m) {
          return new APIMethodView(m);
        });
    },

    render: function (container) {
      container = container || $('#methodlist');
      var html = this.tmpl(this.attributes).trim();
      var dom = this.el = $(html);
      $(container).append(dom);
      var treebody = this.treebody = $('div[class="tree-body"]',dom);
      _.each(this.apimethods,function (method) {
            method.render(treebody);
      });

      // Set up the handler for toggling visiblity
      var button = $('a[class="expand-button"] :first',dom);
      var tree = this;
      button.click(
        // FIXME: Should be able to use bind here.
        function () { return tree.toggleVisible(); });
      return this;
    }

  });

  APIMethodView = function (attributes) {
    this.attributes = attributes;
    this.initialize.apply(this, arguments);
  }


  _.extend(APIMethodView.prototype,
  {
    initialize: function (attributes) {
      self=this;
      this.tmpl = Handlebars.compile($('#apimethodview-template').html());
      this.selected = false;
    },

    render: function (container) {
      var html = this.tmpl(this.attributes).trim();
      var dom = this.el = $(html);
      $(container).append(dom);

      var self = this;
      dom.dblclick(_.bind(this.toggleSelection, self));
    },

    toggleSelection: function () {
      if (this.selected) {
        this.selected = false;
        this.el.removeClass('selected');
      } else {
        this.selected = true;
        this.el.addClass('selected');
      }
      console.log(this);
      return this;
    }


  });




  // Functions for constructing a selection set.
  //
  //
  escapeRegExp = function (str) {
    return str.replace(/[\-\[\]\/\{\}\(\)\*\+\?\.\\\^\$\|]/g, "\\$&");
  }

  SelectionSet = function () {
    this.selections = methods.apis;
  }

  _.extend(SelectionSet.prototype, {

    selclass: function (cls) {
      var refined = {};
      var re = new RegExp("^" + escapeRegExp(cls));
      for (var cname in this.selections) {
        if (cname.match(re)) {
          refined[cname] = this.selections[cname].slice(0);
        }
      }
      var s = new SelectionSet();
      s.selections = refined;
      return s;
    },

    selmethod: function (spec) {
      var refined = {};
      var matches;
      for (var k in this.selections) {
        matches = _.where(this.selections[k],spec);
        // console.log(matches);
        if (! _.isEmpty(matches)) {
          refined[k] = matches;
        }
      }
      var s = new SelectionSet();
      s.selections = refined;
      return s;
    },

    addMethod: function (method) {
      var refined = this.selections;
      var methods = refined[method.class] || [method];
      refined[method.class] = _.unique(methods.push(m));
      var s = new SelectionSet();
      s.selections = refined;
      return s;
    },

    removeMethod: function (method) {
      var refined = this.selections;
      var methods = refined[method.class] || [];
      var newmethods = _.without(methods,method);
      if (newmethods != []) {
        refined[method.class] = newmethods;
      } else {
        delete refined[method.class];
      }

      var s = new SelectionSet();
      s.selections = refined;
      return s;
    },



    // Manipulating methods
    classify: function (cls) {
      this.everyMethod(function (m) { m.classify(cls); });
      return this;
    },

    unclassify: function (cls) {
      this.everyMethod(function (m) { m.unclassify(cls); });
      return this;
    },


    select: function () { this.classify('selected'); return this;},
    unselect: function () { this.unclassify('selected'); return this;},

    hide: function (cls) {
      this.everyMethod(function (m) { m.hide(); });
      return this;
    },

    show: function (cls) {
      this.everyMethod(function (m) { m.show(); });
      return this;
    },

    everyMethod: function (f) {
      for (var k in this.selections) {
        _.each(this.selections[k], f);
      }
    },

    // boolean operations
    or: function (sel) {
      var s = new SelectionSet();
      s.selections = _.extend(this.selections, sel.selections);
      return s;
    },

    diff: function (sel) {
      var refined = {};
      for (var k in this.selections) {
        var methods = sel.selections[k];
        if (methods) {
          methods = _.difference(this.selections[k], methods);
          if (methods.length > 0) {
            refined[k] = methods;
          }
        } else {
          refined[k] = this.selections[k].slice(0); // Copy the array.
        }
      }
      var s = new SelectionSet();
      s.selections = refined;
      return s;

    },

    invert: function () {
      return (new SelectionSet().diff(this));
    }


  });
