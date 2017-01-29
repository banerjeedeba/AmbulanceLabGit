var require = {
  shim: {
    'app' : {
      'deps' :['jquery','bootstrap']
    },
    'bootstrap' : {
      'deps' :['jquery']
    },
    'jquery-ui' : {
      'deps' :['jquery','bootstrap']
    }
  },
  paths: {
    'jquery' : 'resources/fsh/scripts/jquery/jquery',
    'bootstrap' : 'resources/fsh/scripts/bootstrap/bootstrap',
    'app' : 'resources/fsh/scripts/app',
    'jquery-ui' : 'resources/fsh/scripts/jquery/jquery-ui'
  }
};
