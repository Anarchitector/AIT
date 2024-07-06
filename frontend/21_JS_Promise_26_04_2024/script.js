console.log("----Start-----");
setTimeout(() => console.log(5), 0);
console.log("----Finish-----");

function giveFiveAfterSevenSeconds() {
  setTimeout(() => console.log(5), 7000);
}

let res = giveFiveAfterSevenSeconds();

const promise = new Promise((resolve, reject) => {
//  setTimeout(() => resolve(5), 7000);
setTimeout(() => reject('Error'),7000);
});

console.log("----Promise----");
promise
    .then((value) => console.log(value))
    .catch((err) => console.log(err))
    .finally(console.log("Благодарим за использование"))

const usersList = document.getElementById("usersList");

fetch('https://jsonplaceholder.typicode.com/users')
    .then((response) => response.json())
 //   .then((data) => console.log(data))
     .then(users => 
        {
          users.forEach(user => {
            const li = document.createElement('li')
            li.textContent = user.name + " - " + user.address.city;
            usersList.appendChild(li);
          })  
        })