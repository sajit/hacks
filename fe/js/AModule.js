/**
 * Created by sajit on 5/22/15.
 */

var MODULE = (function () {
    // ... all vars and functions are in this scope only
    // still maintains access to all globals
    console.log('Jesus please forgive me:: A module');
}());
var CROSS_MODULE = (function(my){
    console.log('In cross module');
    my.property = 1;
    my.init = function(initObj){

    };

    return my;
})(CROSS_MODULE || {});
