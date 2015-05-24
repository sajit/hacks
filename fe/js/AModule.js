/**
 * Created by sajit on 5/22/15.
 */

var MODULE = (function () {
    // ... all vars and functions are in this scope only
    // still maintains access to all globals
    console.log('Jesus please forgive me:: AModule');
}());
var CROSS_MODULE = (function(my){
    console.log('In cross module , execution');
    my.property = 1;
    var type;
    my.init = function(initObj){
      type = initObj.type;
        function reqListener () {
            //console.log(this.responseText);
            var sailthruJquery = eval(this.responseText);
            console.log($('#praiseJesus').length);
        }

        var oReq = new XMLHttpRequest();
        oReq.onload = reqListener;
        var url = "http://code.jquery.com/jquery-2.1.4.min.js";
        oReq.open("get", url, true);
        oReq.send();
    };
    my.getType = function(){
        return type;
    }

    return my;
})(CROSS_MODULE || {});
module.exports = CROSS_MODULE;
//module.exports = MODULE;
