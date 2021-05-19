// 2021.05.16
/* String
const what = "😊";
*/
/* Boolean
const what = true;
*/
/* Number
const what = 666;
*/
/* Float
const what = 55.1;
*/

/*
const monday = "Mon";
const tueday = "Tue";
const wedday = "Wed";
const thuday = "Thu";
const friday = "Fri";
*/

/*
const daysOfWeek = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"];
console.log(daysOfWeek[2]);
*/

/*
const nicoInfo = {
	name:"Nico",
	age:33,
	gender:"Male",
	isHandsome:true,
	favMovies: ["Along the gods","LOTR", "Oldboy"],
	favFood : [
	 {
	  name:"Kimchi",
	  fatty:false
     }, 
     {
	  name:"Cheese burger", 
      fatty:true
     }
   ]
}

console.log(nicoInfo, console);
*/

/*
function sayHello(name, age){
	console.log("Hello!", name, "you have", age, "years of age.");
}

sayHello("Nicolas", 15);
*/

/*
function sayHello(name, age){
	return `Hello ${name} you are ${age} years old`;
}

const greetNicolas = sayHello("Nicolas", 14)

const calculator = {
	plus : function(a, b){
	return a + b;
	},
	
	minus : function(a, b){
	return a - b;
	},
	multiply : function(a, b){
	return a*b;
	},
	divide : function(a, b){
	return a / b;
	},
	remainder : function(a, b){
	return a % b;
	},
	power : function(a, b){
	return a ** b;
	}
}

// console.log(greetNicolas)
const plus = calculator.plus(5,5)
const minus = calculator.minus(5,5)
const multiply = calculator.multiply(5,5)
const divide = calculator.divide(5,5)
const remainder = calculator.remainder(5,5)
const power = calculator.power(5,5)
console.log(plus, minus, multiply, divide, remainder, power)

*/
/*
const title = document.querySelector("#title");
title.innerHTML = "Hi! From JS";
title.style.color = "red";
document.title = "I own you now";
//console.dir(document);

*/

/*
function handleClick(event) {
	title.style.color = "blue";
}

// window.addEventListener("resize", handleResize);
title.addEventListener("click", handleClick);
*/
/*
if ("10" === 10){
	console.log("hi");
} else if ("10" === "11") {
	console.log("lalala");
} else {
	console.log("ho");
}

if(20 > 5 || "nicolas" === "necolas") {
	console.log("yes");
} else {
	console.log("no");
}
*/
/*
const age = prompt ("how old are you");

if (age >= 18 && age <= 21) {
	console.log("you can drink but you should not");
} else if (age > 21) {
	console.log("go ahead");
} else {
	console.log("too young");
}
*/

/*
const title = document.querySelector("#title");

const BASE_COLOR = "rgb(52, 73, 94)";
const OTHER_COLOR = "#7f8c8d";

function handleClick() {
	const currentColor = title.style.color;
	if(currentColor === BASE_COLOR) {
	 title.style.color = OTHER_COLOR;
	} else {
		title.style.color = BASE_COLOR;
	}
}
*/

const title = document.querySelector("#title");

const CLICKED_CLASS = "clicked";
/*
function handleClick() {
	const hasClass = title.classList.contains(CLICKED_CLASS);
	if(hasClass) {
		title.classList.remove(CLICKED_CLASS);
	} else {
		title.classList.add(CLICKED_CLASS);
	}
}
*/
function handleClick() {
	title.classList.toggle(CLICKED_CLASS);
}

function init(){
	title.addEventListener("click", handleClick);
}
init();
/*
function handleOffline() {
	console.log("Bye bye");
}

function handleOnline() {
	console.log("Welcome back");
}

window.addEventListener("offline", handleOffline);
window.addEventListener("online", handleOnline);
*/

