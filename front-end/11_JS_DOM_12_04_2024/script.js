const t = setInterval(move, 20);

let pos=0;
let flag = true;
let step = 1;

function move() {
  pos += step;
  if (pos === 150) {
    step = -1;
//    clearInterval(t);
  }
  if (pos === 0) {
    step = 1;
  }
  box.style.top = `${pos}px`;
  box.style.left = `${pos}px`;

}

//clearInterval(t)
