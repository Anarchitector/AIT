const stock = {
  items: [],
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
    if(index != -1 && itemCount <= this.items[index].quantity) {
      itemCount === this.items.quantity ?
      this.items.splice(index, 1) : 
      this.items[index].quantity -= itemCount;
    }
    else {
      alert("Данного товара нет в корзине");
    }


    this.updateTotalCost();
  },

  updateTotalCost() {
    this.totalCost = 0;
    for (i = 0; i < this.items.length; i++) {
      this.totalCost += this.items[i].name * this.items[i].quantity;
    }
  }
}

