var data = [
  { 
    imageUrl: 'https://tn.fishki.net/26/upload/post/2017/05/09/2286435/roton-ams.jpg',
    title: 'Baikonur',
    country: 'Kazakhstan',
    startFrom: '$12'
  },
  { 
    imageUrl: 'https://happylove.top/uploads/posts/2023-06/1687423835_happylove-top-p-svyashchennie-mesta-kazakhstana-instagram-67.jpg',
    title: 'Ayakoz',
    country: 'Kazakhstan',
    startFrom: '$14'
  },
  { 
    imageUrl: 'https://img.tourister.ru/files/1/2/0/3/9/8/8/1/original.jpg',
    title: 'Almaty',
    country: 'Kazakhstan',
    startFrom: '$13'
  },
  { 
    imageUrl: 'https://storage.yandexcloud.net/storage.yasno.media/nat-geo/images/2019/5/16/2d08dc1a267643cab4c0ad2f03e2dbac.max-2500x1500.jpg',
    title: 'Turkistan',
    country: 'Kazakhstan',
    startFrom: '$11'
  },
];
var data2 = [
  { 
    imageUrl: 'https://i.postimg.cc/YqQPGjtQ/2024-02-23-185207.png',
    title: 'Astana',
    country: 'Kazakhstan',
    startFrom: '$12'
  },
  { 
    imageUrl: 'https://i.postimg.cc/25tLfkbK/2024-02-23-184715.png',
    title: 'Almaty',
    country: 'Kazakhstan',
    startFrom: '$10'
  },
  { 
    imageUrl: 'https://i.postimg.cc/Bv0wB3QR/2024-02-23-184850.png',
    title: 'Almaty',
    country: 'Kazakhstan',
    startFrom: '$12'
  },
  { 
    imageUrl: 'https://i.postimg.cc/g2DBs5XJ/2024-02-23-185125.png',
    title: 'Astana',
    country: 'Kazakhstan',
    startFrom: '$11'
  },
];
var data3 = [
  { 
    imageUrl: 'https://sportishka.com/uploads/posts/2022-11/1667497162_33-sportishka-com-p-almati-ozero-v-gorakh-vkontakte-39.jpg',
    title: 'Almaty',
    country: 'Kazakhstan',
    startFrom: '$19'
  },
  { 
    imageUrl: 'https://i.postimg.cc/d14sKnxt/2024-02-23-185540.png',
    title: 'Burabay',
    country: 'Kazakhstan',
    startFrom: '$19'
  },
  { 
    imageUrl: 'https://i.postimg.cc/nrhvHRVd/2024-02-23-185746.png',
    title: 'Almaty',
    country: 'Kazakhstan',
    startFrom: '$15'
  },
  { 
    imageUrl: 'https://i.postimg.cc/m2hQJ55k/2024-02-23-185808.png',
    title: 'Almaty',
    country: 'Kazakhstan',
    startFrom: '$13'
  },
];
var data4 = [
  { 
    imageUrl: 'https://s1.1zoom.me/b5362/220/Winter_Men_Snowboarding_Snow_540326_2048x2732.jpg',
    title: 'Almaty',
    country: 'Kazakhstan',
    startFrom: '$11'
  },
  { 
    imageUrl: 'https://i.postimg.cc/283XmhvT/2024-02-24-080426.png',
    title: 'Almaty',
    country: 'Kazakhstan',
    startFrom: '$5'
  },
  { 
    imageUrl: 'https://i.postimg.cc/4yywfRKn/2024-02-24-080612.png',
    title: 'Almaty',
    country: 'Kazakhstan',
    startFrom: '$8'
  },
  { 
    imageUrl: 'https://i.postimg.cc/XvW8ZCZR/2024-02-24-080722.png',
    title: 'Almaty',
    country: 'Kazakhstan',
    startFrom: '$5'
  },
];
var data5 = [
  { 
    imageUrl: 'https://i.postimg.cc/T2jWw4j3/2024-02-24-081556.png',
    title: 'Astana',
    country: 'Kazakhstan',
    startFrom: '$10'
  },
  { 
    imageUrl: 'https://i.postimg.cc/QtR8J52b/2024-02-24-115445.png',
    title: 'Almaty',
    country: 'Kazakhstan',
    startFrom: '$12'
  },
  { 
    imageUrl: 'https://i.postimg.cc/XNC77H5D/2024-02-24-115514.png',
    title: 'Almaty',
    country: 'Kazakhstan',
    startFrom: '$12'
  },
  { 
    imageUrl: 'https://i.postimg.cc/Cx2RXT0m/2024-02-24-081705.png',
    title: 'Almaty',
    country: 'Kazakhstan',
    startFrom: '$12'
  },

  {
    imageUrl: 'https://i.postimg.cc/XNC77H5D/2024-02-24-115514.png',
    title: 'Almaty',
    country: 'Kazakhstan',
    startFrom: '$12'
  },
  {
    imageUrl: 'https://i.postimg.cc/Cx2RXT0m/2024-02-24-081705.png',
    title: 'Almaty',
    country: 'Kazakhstan',
    startFrom: '$12'
  },
];

var container = document.getElementById('cards-container-1');
var container2 = document.getElementById('cards-container-2');
var container3 = document.getElementById('cards-container-3');
var container4 = document.getElementById('cards-container-4');
var container5 = document.getElementById('cards-container-5');

for (var i = 0; i < data.length; i++) {
  var card = document.createElement('div');
  card.className = 'card';

  var img = document.createElement('img');
  img.className = 'card-img';
  var priceDiv = document.createElement('div');
  var cardDiv = document.createElement('div');
  var startFromH5 = document.createElement('h5');
  var countryH4 = document.createElement('h4');
  var titleDiv = document.createElement('div');
  var titleH3 = document.createElement('h3');
  var priceH3 = document.createElement('h3');
  
  cardDiv.className = 'card-div';
  img.src = data[i].imageUrl;
  titleH3.textContent = data[i].title;
  countryH4.textContent = data[i].country;
  priceH3.textContent = data[i].startFrom;
  titleDiv.appendChild(titleH3);
  titleDiv.appendChild(countryH4);
  startFromH5.textContent = 'Start from';
  priceDiv.appendChild(startFromH5);
  priceDiv.appendChild(priceH3);

  cardDiv.appendChild(titleDiv);
  cardDiv.appendChild(priceDiv);
  card.appendChild(img);
  card.appendChild(cardDiv);
  container.appendChild(card);
} 
for (var i = 0; i < data2.length; i++) {
  var card = document.createElement('div');
  card.className = 'card';

  var img = document.createElement('img');
  img.className = 'card-img';
  var priceDiv = document.createElement('div');
  var cardDiv = document.createElement('div');
  var startFromH5 = document.createElement('h5');
  var countryH4 = document.createElement('h4');
  var titleDiv = document.createElement('div');
  var titleH3 = document.createElement('h3');
  var priceH3 = document.createElement('h3');
  
  cardDiv.className = 'card-div';
  img.src = data2[i].imageUrl;
  titleH3.textContent = data2[i].title;
  countryH4.textContent = data2[i].country;
  priceH3.textContent = data2[i].startFrom;
  titleDiv.appendChild(titleH3);
  titleDiv.appendChild(countryH4);
  startFromH5.textContent = 'Start from';
  priceDiv.appendChild(startFromH5);
  priceDiv.appendChild(priceH3);

  cardDiv.appendChild(titleDiv);
  cardDiv.appendChild(priceDiv);
  card.appendChild(img);
  card.appendChild(cardDiv);
  container2.appendChild(card);
} 
for (var i = 0; i < data3.length; i++) {
  var card = document.createElement('div');
  card.className = 'card';

  var img = document.createElement('img');
  img.className = 'card-img';
  var priceDiv = document.createElement('div');
  var cardDiv = document.createElement('div');
  var startFromH5 = document.createElement('h5');
  var countryH4 = document.createElement('h4');
  var titleDiv = document.createElement('div');
  var titleH3 = document.createElement('h3');
  var priceH3 = document.createElement('h3');
  
  cardDiv.className = 'card-div';
  img.src = data3[i].imageUrl;
  titleH3.textContent = data3[i].title;
  countryH4.textContent = data3[i].country;
  priceH3.textContent = data3[i].startFrom;
  titleDiv.appendChild(titleH3);
  titleDiv.appendChild(countryH4);
  startFromH5.textContent = 'Start from';
  priceDiv.appendChild(startFromH5);
  priceDiv.appendChild(priceH3);

  cardDiv.appendChild(titleDiv);
  cardDiv.appendChild(priceDiv);
  card.appendChild(img);
  card.appendChild(cardDiv);
  container3.appendChild(card);
} 
for (var i = 0; i < data4.length; i++) {
  var card = document.createElement('div');
  card.className = 'card';

  var img = document.createElement('img');
  img.className = 'card-img';
  var priceDiv = document.createElement('div');
  var cardDiv = document.createElement('div');
  var startFromH5 = document.createElement('h5');
  var countryH4 = document.createElement('h4');
  var titleDiv = document.createElement('div');
  var titleH3 = document.createElement('h3');
  var priceH3 = document.createElement('h3');
  
  cardDiv.className = 'card-div';
  img.src = data4[i].imageUrl;
  titleH3.textContent = data4[i].title;
  countryH4.textContent = data4[i].country;
  priceH3.textContent = data4[i].startFrom;
  titleDiv.appendChild(titleH3);
  titleDiv.appendChild(countryH4);
  startFromH5.textContent = 'Start from';
  priceDiv.appendChild(startFromH5);
  priceDiv.appendChild(priceH3);

  cardDiv.appendChild(titleDiv);
  cardDiv.appendChild(priceDiv);
  card.appendChild(img);
  card.appendChild(cardDiv);
  container4.appendChild(card);
} 
for (var i = 0; i < data5.length; i++) {
  var card = document.createElement('div');
  card.className = 'card';

  var img = document.createElement('img');
  img.className = 'card-img';
  var priceDiv = document.createElement('div');
  var cardDiv = document.createElement('div');
  var startFromH5 = document.createElement('h5');
  var countryH4 = document.createElement('h4');
  var titleDiv = document.createElement('div');
  var titleH3 = document.createElement('h3');
  var priceH3 = document.createElement('h3');
  
  cardDiv.className = 'card-div';
  img.src = data5[i].imageUrl;
  titleH3.textContent = data5[i].title;
  countryH4.textContent = data5[i].country;
  priceH3.textContent = data5[i].startFrom;
  titleDiv.appendChild(titleH3);
  titleDiv.appendChild(countryH4);
  startFromH5.textContent = 'Start from';
  priceDiv.appendChild(startFromH5);
  priceDiv.appendChild(priceH3);

  cardDiv.appendChild(titleDiv);
  cardDiv.appendChild(priceDiv);
  card.appendChild(img);
  card.appendChild(cardDiv);
  container5.appendChild(card);
} 









function showBlock(categoryNumber) {
for (let i = 1; i <= 5; i++) {
  document.getElementById('cards-container-' + i).style.display = 'none';
}
document.getElementById('cards-container-' + categoryNumber).style.display = 'grid';
}
for (let i = 2; i <= 5; i++) {
document.getElementById('cards-container-' + i).style.display = 'none';
}
function changeBackgroundImage(imageUrl) {
  document.getElementById('bloks-container').style.backgroundImage = imageUrl;
}


function toggleContent() {
  var hiddenContent = document.getElementById('hiddenContent');
  if (hiddenContent.style.display === 'none' || hiddenContent.style.display === '') {
      hiddenContent.style.display = 'block';
  } else {
      hiddenContent.style.display = 'none';
  }
}  
function toggleContent2() {
  var hiddenContent = document.getElementById('hiddenContent2');
  if (hiddenContent.style.display === 'none' || hiddenContent.style.display === '') {
      hiddenContent.style.display = 'block';
  } else {
      hiddenContent.style.display = 'none';
  }
}
function toggleContent3() {
  var hiddenContent = document.getElementById('hiddenContent3');
  if (hiddenContent.style.display === 'none' || hiddenContent.style.display === '') {
      hiddenContent.style.display = 'block';
  } else {
      hiddenContent.style.display = 'none';
  }
} 
function toggleContent4() {
  var hiddenContent = document.getElementById('hiddenContent4');
  if (hiddenContent.style.display === 'none' || hiddenContent.style.display === '') {
      hiddenContent.style.display = 'block';
  } else {
      hiddenContent.style.display = 'none';
  }
}  

document.addEventListener("DOMContentLoaded", function () {
  var link = document.querySelector(".link");
  var pagesMenu = document.querySelector(".pages");

  link.addEventListener("mouseover", function () {
      pagesMenu.style.opacity = "1";
  });

  link.addEventListener("mouseout", function () {
      pagesMenu.style.opacity = "0";
  });
});