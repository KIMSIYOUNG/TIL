let money;

const userInput = function () {
  do {
    money = prompt("구매 할 금액을 입력해주세요.", "로또는 한장에 1000원입니다.");
  } while (money < 1000 || money === null);
  return (parseInt(money) / 1000).toFixed(0);
};

const lottoGenerator = function () {
  const lotto = [];
  for (let i = 0; i < 6; i++) {
    lotto.push((Math.random() * 45).toFixed(0));
  }
  return lotto;
};

const lottosGenerator = function (count, lottoGenerator) {
  const lottos = [];
  for (let i = 0; i < count; i++) {
    lottos.push(lottoGenerator());
  }
  return lottos;
};

const userLotto = lottosGenerator(userInput(), lottoGenerator);
console.log(userLotto)