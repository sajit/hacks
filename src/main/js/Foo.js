/**
 * Created by skunnumkal on 6/29/14.
 */
/**
 * Examples of this
 */
function doIt(){
    this.name  =  "skoo";
}
/**
 * here this.name will refer to name in anObj object. However if it wasnt defined it would refer to name variable
 * in parent obj
 * @type {{name: string, getName: getName}}
 */
var anObj = {
    name : "anoo",
    getName : function(){
        return this.name || name;
    }
};

function foo() {
    try{
        throw new Error("dd");
    }catch(error){

        console.log(" In catch " + error.message);
    }
    finally{
        console.log("Finally block,will always execute");
    }
}
window.setInterval(function(){this.x = (this.x + 1) || 0},2000);

function Employee(){
    this.name = "";
    this.dept = "general";
}
function Manager(){
    this.reports = [];
}
Manager.prototype = new Employee;

function WorkerBee(){
    this.projects = [];
}
WorkerBee.prototype = new Employee;

function SalesPerson(){
    this.dept = "sales";
    this.quota = 100;
}
SalesPerson.prototype = new WorkerBee;

function Engineer(){
    this.dept = "tech";
    this.machine = "";
}
Engineer.prototype = new WorkerBee;
