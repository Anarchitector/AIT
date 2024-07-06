console.log("Hello world!");
console.log(5 + 4);

//const (константа)
//let (переменная)
//var (переменная, depcrecated - устаревший вариант)

let a = 10;
console.log(a + 5);

a = "15";
console.log(a);

const b = 5;
console.log(b);

let x;
console.log(x);
console.log(typeof a);

function sumDigits(x) {
  let sum = 0;

  while (x) {
    sum += x % 10;
    x = (x - (x % 10)) / 10;
  }
  return sum;
}

function luckyNumber(x) {
    
    let second_half = x % 1000;
    let first_half = (x - (x % 1000)) / 1000;

    return sumDigits(first_half) === sumDigits(second_half);
}

console.log(sumDigits(12345));
console.log(luckyNumber(123123));
