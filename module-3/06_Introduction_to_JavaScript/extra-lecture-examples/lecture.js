//this is a single line comment

/*
Multiline
Comment
console.log('Hello World!');
console.log("Hello Again");

let someNumber = "2";
console.log(someNumber);

someNumber = someNumber + 1;
console.log(someNumber);
const someNumber = 8;
const sum = someNumber + 2;
const newSum = sum + 5;

let age = "15";

if (age >= 16) {
    console.log("sleeps in");
}





const aage = "steve";

console.log(isNaN(aage));




const bage = 17;
console.log(isNaN(bage));

if (aage === bage) {
    console.log('Equal');
}



function add (a, b) {
    return a + b;
}


console.log(add(5,10));

console.log(add(5,12));


*/

// nanEx = "444";
// let nanEx;

// console.log(Number.parseFloat(nanEx) + 17);



let names = ['steve', 'amy', 'laura', 'rumeysa']
console.log(names);

names.push('rupesh');
names.push('yasin');
console.log(names);

const nameToRemove = names.pop();
console.log(nameToRemove);

console.log(names);

names.unshift('John')
console.log(names);

const front = names.shift();
console.log(front);
console.log(names);
names.splice(2,0,'Shareeque');
console.log(names);

//console.log(names.reverse());

const listOfNames = names.join(',');
console.log(listOfNames);

const indexOfLaura = names.indexOf('laura');
console.log(indexOfLaura);

const value = names.slice(2,3);
console.log(value);

console.log(names);


const fName = names[3];
console.log(fName);

const student = {
     fname: 'steve',
     lname: 'C',
     occupation: 'Evil Venmo Chief Technologist',
     address : {
         addressLine1: '125 Main St',
         city: 'Columbus'
     },
     age : 20
}

console.log(student.fname);
console.log(student.address.city);






