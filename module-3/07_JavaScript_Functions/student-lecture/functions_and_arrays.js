// function sum(a,b){
//     return a + b;
// }
// console.log(sum(a,b));

// const aa = sum(3,3);
// console.log(aa);

// const aa = function sum1(a, b) {
//     return a+b;
// }
// console.log(aa(4, 1));

//anonymous
// const sum = function(a, b){
//     return a + b;
// }
// console.log(sum(2, 1));

//shorthand notation of anonymous functions
const sum = (a, b) => {
    return a + b;
}
console.log(sum(2, 1));

const product = (a, b) => {
    return a * b;
}
console.log(product(2, 1));

/** 
*@param {function} fn is a function
*@param {number} a is number
*@param {number} b is number
*/
function onClick(fn, a, b) {
    console.log(fn(a,b));
}

onClick(sum, 2, 3);
onClick(product, 2, 3);

// function hello(name) {
//     return 'Hello ' + name;
// }

const greeting = (name) => {
    return 'Hello ' + name;
}

console.log(greeting('Kevin'));

// for loop
let names = ['Faisal', 'Solomon', 'Laura', 'Halis', 'Amy', 'Christina'];

function printNames(namesArray){
    for (let i = 0; i < namesArray.length; i++){
        console.log(namesArray[i] + " is in JG");
    }
}

const nameList = (namesArray) => {
    for (let i = 0; i < namesArray.length; i++){
        console.log(namesArray[i] + " is in JG");
    }
}

nameList(names);

//for each
names.forEach((item,index) => {
    console.log(item + "was found at index: " + index);
});

//another way for each
let anotherList = (element , index) => {
    console.log(element + " is here index " + index)
}

names.forEach(anotherList);

const newArray = names.map((element) => {
    return element.toUpperCase();
});

console.log(newArray);
console.log("-----------------");
console.log(names);

const filteredArray = names.filter((element) => {
    // if(element.startsWith('A')){
    //     return true;
    // }
    // else{
    //     return false;
    // }
    return element.startsWith('S','H');
});

console.log(filteredArray);

//reduce
let scores = [0, 0, 4, 5, 0];

const result = scores.reduce((sum, value) => {
    return sum += value;
}, 10)
console.log(result);

onClick