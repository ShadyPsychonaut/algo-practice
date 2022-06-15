var climbStairs = function (n, memo = {}) {
  if (n in memo) return memo[n];
  if (n === 0 || n === 1) return 1;

  let totalWays = 0;

  for (let i = 1; i != 3; i++) {
    const remainingWays = climbStairs(n - i, memo);
    totalWays += remainingWays;
  }

  memo[n] = totalWays;
  return totalWays;
};

console.log(climbStairs(100));
