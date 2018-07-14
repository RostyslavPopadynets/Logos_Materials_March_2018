function changeStyle() {
  document.getElementById('h2Elem').style.color = '#01ff0f';
  document.getElementById('pElem').style.backgroundColor = 'orange';
  document.getElementById('spanElem')
          .setAttribute('style', 'font-size: 25px; color: blue;');
  document.getElementById('btnElem').style.transform = 'rotate(15deg)';

}

function createClock() {
  let today = new Date();
  let h = today.getHours();
  let m = today.getMinutes();
  let s = today.getSeconds();

  h = checkTime(h);
  m = checkTime(m);
  s = checkTime(s);
  document.getElementById('clock').innerHTML = h + ':' + m + ':' + s;

  setTimeout(createClock, 500);
}

function checkTime(i) {
  if(i < 10) {
    i = '0' + i;
  }
  return i;
}

setTimeout(function() {
    createClock();
}, 50);

document.getElementById('btnSearch').addEventListener('click', function() {
  let searchWord = document.getElementById('searchValue');
  // https://www.google.com.ua/search?q=qwery
  // https://stackoverflow.com/search?q=jpa
  window.open('https://stackoverflow.com/search?q=' + searchWord.value);
});

//alert("Hello");

// const id = "100";

// if(id == 100) {
//   console.log("true");
// } else {
//   console.log("false");
// }
//
// if(id === 100) {
//   console.log("true");
// } else {
//   console.log("false");
// }

// function sayHello() {
//   console.log('Hello World');
// }

// function sayHello(name = 'Tom') {
//   // if(typeof name === 'undefined') name = 'Tom';
//   console.log('Hello, ' + name);
// }
// sayHello('John');
//
// const square = function(x = 0) {
//   return x * x;
// }
// console.log(square());

// (function() {
//   console.log('Hello World');
// })();

// (function(name = 'Logos') {
//   console.log('Hello, ' + name);
// })('Jerremy');
