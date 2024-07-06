const stock = {
  items: [
    { name: "Откосить", isChecked: false },
    { name: "Забить", isChecked: false },
    { name: "Расслабиться", isChecked: false },
  ], // массив задач
  totalTasks: 0,
  addItem(item) {
    const existingItem = this.items.find((e) => e.name === item.name);
    if (existingItem) {
      alert("Эта задача уже есть в списке");
    } else {
      this.items.push(item);
      console.log(this.items);
    }
    this.updateAllTasks();
  },
  // itemName - наименование задачи
  removeItem(itemName) {
    const index = this.items.findIndex((e) => e.name === itemName);

    if (index !== -1) {
      this.items.splice(index, 1);
    } else {
      alert("Данной задачи нет в списке");
    }

    this.updateAllTasks();
  },
  updateAllTasks() {
    this.totalTasks = this.items.reduce((acc, item) => acc, 0);
  },
};

stock.updateAllTasks();
console.log(stock.totalTasks);

add.onclick = addHandler;

function addHandler() {
  const name = taskName.value.trim();
  
  if (name) {
    stock.addItem({ name });
    console.log(name);
  }

  taskName.value = "";
  updateAllTasks();
}

function updateAllTasks() {
  tasksList.innerHTML = "";

  // 1. Перебор элементов массива
  stock.items
    .sort((a, b) => {
      return b.isChecked - a.isChecked;
    })
    .forEach((e) => {
      // 2. При каждой итерации создаем HTML Element
      const li = document.createElement("li");
      li.classList.add("list-group-item", "list-group-item-action");
      const removeButton = document.createElement("button");
      removeButton.textContent = "X";
      removeButton.classList.add("btn", "btn-danger", "ms-2");
      removeButton.onclick = () => {
        stock.removeItem(e.name);
        li.remove();
      };

      const checkBox = document.createElement("input");
      checkBox.type = "checkbox";
      checkBox.classList.add("form-check-input", "mx-2");
      checkBox.checked = e.isChecked;
      if (checkBox.checked) {
        li.classList.add("list-group-item-secondary");
        li.style.textDecoration = "line-through";
      }

      checkBox.onclick = () => {
        e.isChecked = !e.isChecked;
        updateAllTasks();
      };

      // 3. Наделяем его текстовым контентом
      li.textContent = `
              Task name: ${e.name}
          `;

      // HW - добавляем кнопку в каждый элемент списка
      li.appendChild(checkBox);
      li.appendChild(removeButton);

      // 4. Добавляем его в productsList
      tasksList.appendChild(li);
    });
}

/*stats.onclick = statsHandler;

function statsHandler() {
  const itemsCount = stock.items.length;
  const totalCost = stock.totalCost;
  const totalQuantity = stock.items.reduce(
    (acc, item) => acc + item.quantity,
    0
  );
  // Итерирует элементы массива и меняет их на новое значение
  const arrPrices = stock.items.map((e) => e.price);
  const maxPrice = Math.max(...arrPrices);
  const minPrice = Math.min(...arrPrices);
  const avgPrice =
    arrPrices.reduce((acc, item) => acc + item, 0) / arrPrices.length;

  // Сортировка по цене (в сторону увеличения)
  console.log(stock.items.sort((a, b) => a.price - b.price));
  // Сортировка по кол-ву (в сторону увеличения)
  console.log(stock.items.sort((a, b) => a.quantity - b.quantity));
  // Сортировка по длине кол-ву букв в наименовании товара (в сторону увеличения)
  console.log(stock.items.sort((a, b) => a.name.length - b.name.length));

  console.log(
    stock.items.sort((a, b) => {
      if (a.price === b.price) {
        return a.quantity - b.quantity;
      }
      return a.price - b.price;
    })
  );

  statsList.innerHTML = `
          <li class="list-group-item list-group-item-action">
              <p>Count of items: ${itemsCount}</p>
              <p>Total cost: ${totalCost}</p>
              <p>Total Quantity: ${totalQuantity}</p>
              <p>Min price: ${minPrice}</p>
              <p>Average price: ${avgPrice}</p>
              <p>Max price: ${maxPrice}</p>
          </li>
      `;
}

// Math.random() возвращает от 0 до 1
*/
