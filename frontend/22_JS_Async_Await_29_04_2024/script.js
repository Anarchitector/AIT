const BASE_URL = "https://jsonplaceholder.typicode.com";
const userDetails = document.getElementById('userDetails');

async function fetchUsers() {
  try {
    // ???
    const response = await fetch(`${BASE_URL}/users`);
    const users = await response.json();
    return users;
  } catch (error) {
    console.log(error.message);
  }
}

function displayUsers(users) {
  users.forEach((user) => {
    const li = document.createElement("li");

    // displayUserDetails     displayUserDetails(user)    () => displayUserDetails(user)
    li.onclick = () => displayUserDetails(user);

    li.textContent = user.name;
    usersList.appendChild(li);
  });
}

function displayUserDetails({
  name,
  email,
  phone,
  website,
  company: {name: brand},
  address: {city, street, suite}
}) {
  userDetails.innerHTML = `
    <h2>${name}</h2>
    <p><strong>Email: </strong>${email}</p>
    <p><strong>Phone: </strong>${phone.split(' ')[0]}</p>
    <p><strong>Website: </strong>${website}</p>
    <p><strong>Name of Company: </strong>${brand}</p>
    <p><strong>Address: </strong>${city}, ${street}, ${suite}</p>
  `;
}

const result = async () => {
  const users = await fetchUsers();

  search.addEventListenter('input', (e) => {
    const filter = e.target.value;
    console.log(filter);
    const filteredUsers = users.filter(user => user.name.includes(filter));
  })

  if(users) {
    displayUsers(filteredUsers);
  }
};

result();
// console.log(fetchUsers());

/*
    Homework:

    1. name;
    2. email;
    3. phone (без кода города);
    4. website;
    5. companyName;
    6. address (street, suite, city)
*/ 