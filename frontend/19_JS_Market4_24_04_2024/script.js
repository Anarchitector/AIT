const stock = {
  items: [
    { name: "milk", price: 6, quantity: 50, isChecked: false },
    { name: "cheese", price: 30, quantity: 70, isChecked: false },
    { name: "meat", price: 30, quantity: 40, isChecked: false },
    { name: "pizza", price: 30, quantity: 110, isChecked: false },
    { name: "bread", price: 3, quantity: 100, isChecked: false },
  ], // массив товаров
  totalCost: 0, // суммарная стоимость всех товаров CRUD
  addItem(item) {
    // example of item: { name, price, quantity }
    // TODO
    const existingItem = this.items.find((e) => e.name === item.name);

    if (existingItem) {
      existingItem.quantity += item.quantity;
      //
    } else {
      this.items.push(item);
    }

    this.updateTotalCost();
  },
  // itemName - наименование товара, itemCount - кол-во удаляемого товара
  removeItem(itemName, itemCount) {
    const index = this.items.findIndex((e) => e.name === itemName);

    if (index !== -1 && itemCount <= this.items[index].quantity) {
      itemCount === this.items[index].quantity
        ? this.items.splice(index, 1)
        : (this.items[index].quantity -= itemCount);
    } else {
      alert("Данного товара недостаточно на складе");
    }

    this.updateTotalCost();
  },
  updateTotalCost() {
    this.totalCost = this.items.reduce(
      (acc, item) => acc + item.price * item.quantity,
      0
    );
  },
};

stock.updateTotalCost();
console.log(stock.totalCost);

// const add = document.getElementById('add');
add.onclick = addHandler;

function addHandler() {
  const name = productName.value.trim();
  const price = +productPrice.value.trim();
  const quantity = +productQuantity.value.trim();
  
  if (name && price && price > 0 && quantity && quantity > 0) {
    stock.addItem({ name, price, quantity, isChecked: false });
  }

  productName.value = productPrice.value = productQuantity.value = "";
  updateTotalList();
}

function updateTotalList() {
  productsList.innerHTML = "";

  // 1. Перебор элементов массива
  stock.items.forEach((e) => {
    // 2. При каждой итерации создаем HTML Element
    const li = document.createElement("li");
    li.classList.add("list-group-item", "list-group-item-action");

    const removeButton = document.createElement("button");
    removeButton.textContent = "X";
    removeButton.classList.add("btn", "btn-danger", "ms-2");
    removeButton.onclick = () => {
      stock.removeItem(e.name, e.quantity);
      li.remove();
    };

    const pCheckBox = document.createElement("input");
    pCheckBox.type = 'checkbox';
    pCheckBox.classList.add('form-check-input','mx-2');
    pCheckBox.checked = e.isChecked;
    if (pCheckBox.checked)
    
    pCheckBox.onclick = () => {
      if (pCheckBox.checked) {
        li.classList.add('')
//        li.style.backgroundColor = "yellow";
        e.isChecked = true;
      }
      else {
        li.style.backgroundColor = "white";
        e.isChecked = false;
      }
    };

    // 3. Наделяем его текстовым контентом
    li.textContent = `
            Product name: ${e.name},
            Product price: ${e.price},
            Product quantity: ${e.quantity}
        `;
    li.appendChild(pCheckBox);
    li.appendChild(removeButton);
    // 4. Добавляем его в productsList
    productsList.appendChild(li);
  });
}

stats.onclick = statsHandler;

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
