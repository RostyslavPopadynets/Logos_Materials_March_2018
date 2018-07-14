// alert("Hello World");

/*
    var, let, const
*/
/*
var firstName = 'John';
console.log(firstName);

var age = 34;
console.log(age);

age = 'five';
console.log(age);

let lastName = 'Doe';
console.log(lastName);

var CONSTANTA = 0;

const city = 'Lviv';
console.log(city);
// city = 'Kyev';
*/

/*
let firstName = 'Tom';
console.log(typeof firstName);

let age = 23.2;//23
console.log(typeof age);

let isAdult = true;
console.log(typeof isAdult);

let car = null;
console.log(typeof car);

let city;
console.log(city);

let sqrt = Math.sqrt(-9);
console.log(sqrt);
*/

/*
const num1 = 30;
const num2 = 40;
let res;

res = num1 + num2;
res = num1 - num2;
res = num1 * num2;
res = num1 / num2;
console.log(res);
*/

/*
let res;
res = Math.PI;
res = Math.round(2.4);
res = Math.ceil(2.1);
res = Math.floor(2.9);
res = Math.sqrt(81);
res = Math.pow(2, 3);
console.log(res);
*/

/*
const firstName = 'Tommy';
const lastName = 'Addams';
let res;
res = firstName + lastName;
res = firstName.concat(' ', lastName);
res = firstName.length;
res = firstName[2];
res = firstName.charAt(4);
res = firstName.indexOf('m');
res = firstName.lastIndexOf('m');
res = firstName.substring(0, 2);
res = firstName.slice(0, 3);
res = firstName.slice(-3);
res = lastName.replace('m', 'C');
console.log(res);
*/

/*
const numbers = [12, 33, 123, 45, 36, 86, 334];
const numbers2 = new Array(12, 33, 123, 45, 36, 86, 334);
const test = [12, 'sdf', undefined, null, NaN, 45];
let res;

res = numbers.length;
res = Array.isArray(numbers);
res = numbers[2];
res = numbers.indexOf(86);

numbers.push(555);
numbers.unshift(111);

res = numbers.pop();
res = numbers.shift();

for(let i = 0; i < numbers.length; i++) {
    console.log(numbers[i]);
}

console.log(res);
console.log(numbers);
*/

const person = {
    firstName : 'Adam',
    lastName : 'Adams',
    age: 45,
    email: 'adam@gmail.com',
    hobbies: ['game', 'programming'],
    address: {
        city: 'Lviv',
        street: 'Lvivska'
    }
};

let res;
res = person.email;
res = person['lastName'];
res = person.hobbies;
res = person.address;
res = person.address.city;

console.log(res);
console.log(person);