/**
 * Created by sajit on 5/23/15.
 */
var assert = require("assert"); // node.js core module
var CROSS_MODULE = require('../js/AModule.js');

describe('Array', function(){
    describe('#indexOf()', function(){
        it('should return -1 when the value is not present', function(){
            assert.equal(-1, [1,2,3].indexOf(4)); // 4 is not present in this array so indexOf returns -1
        });

        it('should test sanity', function() {
           assert.equal(1,1);
        });
    });

    describe('Another bout', function(){
        it('should map an array', function(){
            assert.deepEqual([2,3,4],[1,2,3].map(function(el){return (el + 1);}));
        });

    });
});

describe('AModule test', function(){
    describe('Module A', function(){
        it('should have a property function ', function(){
            assert.equal(typeof CROSS_MODULE, 'object');
            assert.equal(typeof CROSS_MODULE.property, 'number');
        });

        it('should have a type', function(){
           assert.equal(undefined,CROSS_MODULE.getType());
        });
    });
});
