const human = {
  height: 180,
  weight: 70,
  age: 31,
  sing() {
    console.log("I am");
  },
};

const player = {
  result: 1.2,
  __proto__: human,
};

console.log(player);

//getters & setters

const playerJohn = {
  name: "John",
  surname: "Doe",
  get fullName() {
    return `${this.name} ${this.surname}`
  },
  set fullName(value) {
    // Деструктуризация
    const [firstName, lastName] = value.split(' ');
    this.name = firstName;
    this.surname = lastName;
  }
};

playerJohn.fullName = 'Johnny Depp';
console.log(playerJohn);

// Конструкторы

function Player(name, height, weight,result) {
    this.name = name;
    this.height = height;
    this.weight = weight;
    this.result = result;
}

const player1 = new Player('Mike,172,85,1.5');
const player2 = new Player('Mary,172,85,1.5');
