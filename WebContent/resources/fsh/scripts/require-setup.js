var require = {
  shim: {
    'bootstrap' : {
      'deps' :['jquery']
    },
    'app' : {
      'deps' :['jquery','bootstrap']
    },
	'jquery-ui' : {
      'deps' :['jquery','bootstrap']
    }
  },
  paths: {
    'jquery' : 'resources/fsh/scripts/jquery/jquery',
	'bootstrap' : 'resources/fsh/scripts/bootstrap/bootstrap',
	'jquery-ui' : 'resources/fsh/scripts/jquery/jquery-ui',
    'app' : 'resources/fsh/scripts/app'
  }
};
