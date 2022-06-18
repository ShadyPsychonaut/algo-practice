const threeSum = (nums) => {
  if (nums.length < 3) return [];
  let result = [];
  for (let i = 0; i < nums.length; i++) {
    const sumOfTwo = twoSum(0 - nums[i], nums, i);
    if (sumOfTwo.length === 0) continue;
    const sumOfThree = sumOfTwo.map((way) => [nums[i], ...way]);
    for (let j = 0; j < sumOfThree.length; j++) {
      const ans = sumOfThree[j];
      if (
        result
          .map((solution) =>
            ans.every(
              (val) =>
                solution.includes(val) &&
                ans.filter((el) => el === val).length <=
                  solution.filter((el) => el === val).length
            )
          )
          .includes(true)
      )
        continue;
      result.push(ans);
    }
  }
  return result;
};

const twoSum = (target, nums, pos) => {
  let dict = {};
  let result = [];
  for (let i in nums) {
    if (i == pos) continue;
    const newTarget = target - nums[i];
    if (newTarget in dict) {
      const sumOfTwo = [newTarget, nums[i]];
      if (
        !result
          .map((sol) =>
            sumOfTwo.every(
              (val) =>
                sol.includes(val) &&
                sumOfTwo.filter((el) => el === val).length <=
                  sol.filter((el) => el === val).length
            )
          )
          .includes(true)
      )
        result.push(sumOfTwo);
    }
    dict[nums[i]] = i;
  }
  return result;
};

console.log(threeSum([-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4]));
