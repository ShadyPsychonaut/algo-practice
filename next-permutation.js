var nextPermutation = function (nums) {
  let i = nums.length - 2;
  while (i >= 0 && nums[i] >= nums[i + 1]) i--;

  if (i < 0) return nums.sort((a, b) => a - b);

  let j = nums.length - 1;
  while (nums[j] <= nums[i]) j--;
  swap(i, j);

  let arr = nums.splice(i + 1, nums.length - 1 - i);
  arr.reverse();
  nums.push(...arr);

  return nums;

  function swap(i, j) {
    const temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }
};

console.log(nextPermutation([3, 5, 8, 6, 1])); // returns [ 3, 6, 1, 5, 8 ]
