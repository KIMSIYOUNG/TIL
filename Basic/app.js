new Vue({
  el: '#app',
  data: {
    myChoice: null,
    comChoice: null,
    count: 3,
    winner: null,
    lifeOfMe: 3,
    lifeOfCom: 3,
    isSelectable: true,
    logs: [],
    selects: [
      { name: '가위', value: 'scissor' },
      { name: '바위', value: 'rock' },
      { name: '보', value: 'paper' },
    ]
  },

  computed: {
    myChoiceImg: function () {
      return this.myChoice !== null ? 'images/' + this.myChoice + '.jpg' : 'images/question.jpg';
    },
    comChoiceImg: function () {
      return this.comChoice !== null ? 'images/' + this.comChoice + '.jpg' : 'images/question.jpg';
    },
    leftLifeOfMe: function () {
      return 3 - this.lifeOfMe
    },
    leftLifeOfCom: function () {
      return 3 - this.lifeOfCom
    }
  },

  watch: {
    count: function (newValue) {
      if (newValue === 0) {
        this.createComputerValue()
        this.createWinner();
        this.count = 3;
        this.isSelectable = true;
        this.createLogs();
      }
    },
    lifeOfMe: function (newValue) {
      if (newValue === 0) {
        this.endGame("안타깝네요. 당신이 패배자입니다.^_____^ 너무 상심마라. 상대가 나니까")

      }
    },
    lifeOfCom: function (newValue) {
      if (newValue === 0) {
        this.endGame("축하드립니다. 당신이 승리하였습니다.")
      }
    }
  },

  methods: {
    startGame: function () {
      if (this.myChoice === null) {
        alert("가위 바위 보 중 하나를 선택해주세요.")
      } else {
        this.isSelectable = false
        let countDown = setInterval(() => {
          this.count--;
          if (this.count === 0) {
            clearInterval(countDown);
          }
        }, 1000)
      }
    },
    createComputerValue: function () {
      let randomNumber = Math.random();
      if (randomNumber < 0.33) {
        this.comChoice = 'scissor'
      } else if (randomNumber < 0.66) {
        this.comChoice = 'rock'
      } else {
        this.comChoice = 'paper'
      }
    },
    createWinner: function () {
      if (this.myChoice === this.comChoice) this.winner = 'no one'
      else if (this.myChoice === 'rock' && this.comChoice === 'scissor') this.winner = 'me'
      else if (this.myChoice === 'scissor' && this.comChoice === 'paper') this.winner = 'me'
      else if (this.myChoice === 'paper' && this.comChoice === 'rock') this.winner = 'me'
      else if (this.myChoice === 'scissor' && this.comChoice === 'rock') this.winner = 'computer'
      else if (this.myChoice === 'paper' && this.comChoice === 'scissor') this.winner = 'computer'
      else if (this.myChoice === 'rock' && this.comChoice === 'paper') this.winner = 'computer'
      else this.winner = 'error'

      if (this.winner === 'me') {
        this.lifeOfCom--;
      } else if (this.winner === 'computer') {
        this.lifeOfMe--;
      }
    },
    createLogs: function () {
      let log = {
        message: `You : ${this.myChoice}, Computer : ${this.comChoice}, Winner : ${this.winner}`,
        winner: this.winner
      }
      this.logs.unshift(log);
    },
    endGame: function (msg) {
      setTimeout(() => {
        confirm(msg)
        this.lifeOfMe = 3
        this.lifeOfCom = 3
        this.myChoice = null
        this.comChoice = null
        this.winner = null
        this.logs = []
      }, 500)
    }
  }
})