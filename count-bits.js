const calculateBinary = (dec) => {
  return (dec >>> 0).toString(2);
};

const countBits = function (n) {
  const ans = Array(n + 1).fill(0);

  ans[1] = 1;
  for (let i = 2; i <= n; i++) {
    const bin = calculateBinary(i);
    for (let j of bin) {
      if (j === "1") ans[i]++;
    }
  }
  return ans;
};

console.log(countBits(1));
