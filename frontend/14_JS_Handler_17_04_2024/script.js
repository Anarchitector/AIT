const stock = {
  items: [
    { name: Bread, price: 1, quantity: 1 },
    { name: Butter, price: 2, quantity: 1 },
    { name: Cheese, price: 3, quantity: 1 },
  ],
  totalCost: 0,

  addItem(item) {
    // example of item ( product, price, quantity)
    const existingItem = this.items.find((e) => e.name === item.name);
    if (existingItem) {
      existingItem.quantity += item.quantity;
    } else this.items.push(item);

    this.updateTotalCost();
  },

  removeItem(itemName, itemCount) {
    const index = this.items.findIndex((e) => e.name === itemName);
    if (index != -1 && itemCount <= this.items[index].quantity) {
      itemCount === this.items.quantity
        ? this.items.splice(index, 1)
        : (this.items[index].quantity -= itemCount);
    } else {
      alert("Данного товара нет в корзине");
    }

    this.updateTotalCost();
  },

  updateTotalCost() {
    this.totalCost = 0;
    for (i = 0; i < this.items.length; i++) {
      this.totalCost += this.items[i].name * this.items[i].quantity;
    }
  },
};

// const add = document.getElementById('add');
add.onclick = addHandler;

// + добавляют для перевода в строку
function addHandler() {
  const name = productName.value.trim();
  const price = +productPrice.value.trim();
  const quantity = +productQuantity.value.trim();

  if (name && price && price > 0 && quantity && quantity > 0) {
    stock.addItem({ name, price, quantity });
  }
  console.log(stock.totalCost);

  productName.value = productPrice.value = productQuantity.value = "";

  stock.items.forEach((e) => {
    const li = document.createElement("li");
    li.textContent = `
      Product name: ${e.name},
      Product price: ${e.price},
      Product quantity: ${e.quantity}
    `;
    productList.appendChild(li);
  });
}

function statsHandler() {
  const statsQuantity = stock.items.length;
  const totalCost = stock.totalCost;
  const totalQuantity = stock.items.reduce((acc, item) => acc + item.quantity, 0);
  
  const maxPrice = 0;
  for (i = 0; i < stock.items.length; i++)
  {
    if (stock.items[i].price > maxPrice) {
      maxPrice = stock.items[i].price;
    }
  }
  
//  const averagePrice = (stock.items.reduce((acc, item) => acc + item.price, 0)) / stock.items.length;
  const minPrice = maxPrice;
  for (i = 0; i < stock.items.length; i++)
  {
    if (stock.items[i].price < minPrice) {
      minPrice = stock.items[i].price;
    }
  }
}
