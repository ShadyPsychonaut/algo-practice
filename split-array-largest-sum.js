var splitArray = (nums, m) => {
  return dfs(0, m);

  function dfs(i, m, memo = {}) {
    if (m === 1) {
      let sum = 0;
      for (let pos = i; pos < nums.length; pos++) sum += nums[pos];
      return sum;
    }
    if ([i, m] in memo) return memo[[i, m]];

    let res = Number.POSITIVE_INFINITY,
      curSum = 0;
    for (let j = i; j < nums.length - m + 1; j++) {
      curSum += nums[j];
      const maxSum = Math.max(curSum, dfs(j + 1, m - 1, memo));
      res = Math.min(res, maxSum);
      if (curSum > res) break;
    }

    memo[[i, m]] = res;
    return res;
  }
};

console.log(splitArray([7, 2, 5, 10, 8], 2)); // logs 18

// Time: O(N^2 * M)
