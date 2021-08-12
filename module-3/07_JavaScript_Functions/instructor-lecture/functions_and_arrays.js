
//named function
//function sum1(a, b) {
//    return a + b;
//}

//how to call a named function
//console.log(sum1(2,1));
//console.log(sum1(5,5));

//we can assign result of functions to variables
//const aa = sum(3,3);
//console.log(aa);

// we can even assign the function itself to a variable
// this is known as a functional expression 
// const aa = function sum(a, b) {
//     return a + b;
// }

//we can call the function via its variable name
// console.log(aa(4,1));

//anonymous functions are functions with no name.
// const sum = function (a,b) {
//     return a + b;
// }  

//shorthand notation for anonymous functions (this is the same as above but written as a shortcut to save code)
const sum = (a,b) => {
    return a + b;
}  

console.log(sum(2,1));



const product = (a,b) => {
    return a * b;
}

// this example shows how we can make the onClick function more flexible by passing the onClick the function
//we want the onClick function to execute. This makes the onClick function more reusable. We will see more
//examples with arrays, javascript events, dom handling, Vue.js, etc.

//fn - as shown here is often called a callback handler 


/**
 * This is an onClick event handler 
 * @param {function} fn callback method to execute when onclick is called
 * @param {number} a is first number
 * @param {number} b is second number
 */
function onClick(fn, a, b) {
     console.log(fn(a,b));
}



//samples of calling above
onClick(sum, 2,2);
onClick(product, 2,3);


// function hello(name) {
//     return 'Hello ' + name;
// }


const greeting = (name) => {
    return 'Hello ' + name;
}

console.log(greeting('Kevin'));

let names = ['Faisal', 'Solomon', 'Laura', 'Sydney', 'Amy', 'Abdifatah'];

// function printNames(namesArray) {
//    for (let i = 0; i< namesArray.length; i++ ) {
//        console.log(namesArray[i] + ' is in JG');
//    }
// }



// const nameList = (namesArray) => {
//     for (let i = 0; i< namesArray.length; i++ ) {
//         console.log(namesArray[i] + ' is in JG');
//     }
//  }

// nameList(names);

// let names = ['Faisal', 'Solomon', 'Laura', 'Sydney', 'Amy', 'Abdifatah'];



//FOR EACH *****

// names.forEach((element, index, names) => {
//     console.log(element + " is here " + " at index: " + index ); 
//     console.log(names.length);
//  });


// MAP *****

 //map gives you the ability to look at each value, manipulate it in some way, 
 // and return a new array without changing the original array.
 const newArray = names.map((element) => {
       return "Hello " + element;
 });
 

 console.log(newArray);

 console.log('-------------------------------------');

 console.log(names);



const filteredArray = names.filter((element) => {


    //   if (element.startsWith('A')) {
    //       return true;
    //   }
    //   else {
    //       return false;
    //   }

      return element.startsWith('A');
});

console.log(filteredArray);


let scores = [0, 0,0,1,1,0,0];

const result2 = scores.reduce((sum, value) =>{
    return sum += value;
}, 10 );

console.log(result2);





