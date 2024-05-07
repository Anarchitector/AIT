const API_KEY = '17311eb066166023d725029d7db3207b';
const locationInput = document.getElementById('locationInput');
const getWeatherBtn = document.getElementById('getWeatherButton');
const weatherInfo = document.getElementById('weatherInfoId');

getWeatherBtn.onclick = () => {
    const cityName = locationInput.value.trim();
    fetch(`https://api.openweathermap.org/data/2.5/weather?q=${cityName}&appid=${API_KEY}&units=metric`)
    .then(response => response.json())
    .then(data => {
        showWeather(data);
        console.log(data)
    })
    
    locationInput.value = "";
}

function showWeather(data) {
    weatherInfo.innerHTML = `
    <h2>${data.name}</h2>
    <p>Temperature: ${data.main.temp}</p>
    <p>Description: ${data.weather[0].description}</p>
    <p>Speed of Wind: ${data.wind.speed}</p>
   `
}
