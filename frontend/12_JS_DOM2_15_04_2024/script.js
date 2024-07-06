const bank = [];

const bankAccount = {
  accountNumber: "123456789",
  accountHolderName: "Alice",
  balance: 0,
  deposit: (sum) => {
    sum >= 5 && sum < 100000
      ? (bankAccount.balance += sum)
      : alert("Вводимая сумма для поплнения баланса некорректная");
    return bankAccount.balance;
  },
  withdraw: (sum) => {
    sum <= bankAccount.balance && sum >= 5
      ? (bankAccount.balance -= sum)
      : alert("Вводимая сумма для снятия со счета некорректная");
    return bankAccount.balance;
  },
  checkBalance() {
    alert(this.balance + "$");
  },
};

const nameInput = document.getElementById("name");
const accountIdInput = document.getElementById("accountId");
const amountInput = document.getElementById("amount");

const accountsListOl = document.getElementById("accountsList");

const withdrawBtn = document.getElementById("withdraw");
const depositBtn = document.getElementById("deposit");

const date = new Date();
console.log(date.getTime() / 1000 / 60 / 60 / 24 / 365.25);

//1713351915613 /1000 / 60 / 60 / 24 / 365.25

function createAccount() {
  if (nameInput.value.trim()) {
    const date = new Date();
    bank.push({
      ...bankAccount, 
      accountNumber: date.getTime()+'', 
      accountHolderName: nameInput.value.trim()
    });
    nameInput.value = '';
    console.log(bank);
  }
}

function showAccounts() {
  accountsListOl.innerHTML = '';
  bank.forEach(account => {
    const li = document.createElement('li');
    li.innerHTML = `
      <p>Username: ${account.accountHolderName}}</p>
      <p>Account: ${account.accountNumber}}</p>
      <p>Balance: ${account.balance}}</p>
    `;
    accountsListOl.appendChild(li);
  })
}

withdrawBtn.onclick = function withdrawingFromAccount() {
  const id = accountIdInput.value.trim();
  const amount = +amountInput.value.trim();

  const index = bank.findIndex(account => account.accountNumber === id);

  if (index === -1) {
    console.log('Проверьте правильность ввода номера аккаунта');
  } 
  else {
    if(!isNaN(amount)) {
      bank[index].withdraw(amount);
    }
  }

  accountIdInput.value = amountInput.value = '';
}

depositBtn.onclick = function depositOnAccount() {
  const id = accountIdInput.value.trim();
  const amount = +amountInput.value.trim();

  const index = bank.findIndex(account => account.accountNumber === id);

  if (index === -1) {
    console.log('Проверьте правильность ввода номера аккаунта');
  } else {
    if(!isNaN(amount) ) {
      bank[index].deposit(amount);
    }
  }

  accountIdInput.value = amountInput.value = '';
}
