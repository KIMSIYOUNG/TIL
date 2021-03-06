/*
promise 를 통해 함수를 정의함.
 */

function loadScript(src) {
  return new Promise(function (resolve, reject) {
    const script = document.createElement('script');
    script.src = src;

    script.onload = () => resolve(script);
    script.onerror = () => reject(new Error("읽기 실패."))

    document.head.append(script);
  })
}

/*
사용하는 부분에선 .then , finally, catch 등으로 받아서 사용가능.
 */
let promise = loadScript("https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.11/lodash.js");

promise.then(
  script => alert(`${script.src}을 불러왔습니다!`),
  error => alert(`Error: ${error.message}`)
);

promise.then(script => alert('또다른 핸들러...'));


let promise = new Promise(function (resolve, reject) {
  setTimeout(() => resolve(1), 1000);
});

promise.then(function (result) {
  console.log("저는 첫번째 입니다.");
  alert(result); // 1
  return result * 2;
});

promise.then(function (result) {
  console.log("저는 두번째 입니다.");
  alert(result); // 1
  return result * 2;
});

promise.then(function (result) {
  console.log("저는 세번째 입니다.");
  alert(result); // 1
  return result * 2;
});