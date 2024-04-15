/*let arr = [1,2,3, 'four', 'five'];
console.log(typeof arr);

console.log('----SLICE----');
res = arr.slice(1,4);

console.log(res);
console.log(arr);

console.log('----SPLICE----');
res = arr.splice(3,1);

console.log(res);
console.log(arr);



alert('Переход возможен только зарегистрированным пользователям');

let answer = confirm('Подтвердите, что вам исполнилось 18');
console.log(answer);

answer = prompt('Введите ваше имя');
console.log(answer);

const str = '     Beer or not to beer      ';
const str1 = str.trim();
console.log(str1);

res = str1.split(' ');
console.log(res);

let newRes = res.join(' ');
console.log(newRes);
*/
//HOMEWORK
let library = [
  {
    ISBN: "123456789",
    TITLE: "451 degree",
    AUTHOR: "R.Breadberry",
    YEAR: "1951",
  },
];

let inputDate = prompt('Enter book data separate by ";"');

while (!inputDate) {

    inputDate = prompt('Enter book data separate by ";"');
}

function findIndexOfBook(index) {
  for (i = 0; i < library.length; i++) {
    if (index === library[i].ISBN) {
      return library[i];
    }
  }
}

function splitStrIntoParts(inputDate) {
  let resStr = inputDate.trim();
  let obj = {
    ISBN: "",
    TITLE: "",
    AUTHOR: "",
    YEAR: "",
  };

  resStr = resStr.split(";");
  obj.ISBN = resStr[0];
  obj.TITLE = resStr[1];
  obj.AUTHOR = resStr[2];
  obj.YEAR = resStr[3];
  return obj;
}

library.push(splitStrIntoParts(inputDate));
console.log(library);
let index = prompt("Введите ISDN");
console.log(findIndexOfBook(index));

//987654321;451 градус;Рэй Бредберри;1951
