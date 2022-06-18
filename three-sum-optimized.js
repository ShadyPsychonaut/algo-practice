const threeSum = (nums) => {
  let res = [];

  if (nums.length < 3) return res;

  nums.sort((a, b) => a - b);

  if (nums[nums.length - 1] < 0) return res;

  for (let i = 0; i < nums.length - 2; i++) {
    if (nums[i] > 0) break;
    if (i === 0 || nums[i] !== nums[i - 1]) {
      let lo = i + 1,
        hi = nums.length - 1;
      let sum = 0 - nums[i];

      while (lo < hi) {
        if (nums[lo] + nums[hi] === sum) {
          res.push([nums[i], nums[lo], nums[hi]]);
          while (lo < hi && nums[lo] === nums[lo + 1]) lo++;
          while (lo < hi && nums[hi] === nums[hi - 1]) hi--;
          lo++;
          hi--;
        } else if (nums[lo] + nums[hi] < sum) {
          while (lo < hi && nums[lo] === nums[lo + 1]) lo++;
          lo++;
        } else {
          while (lo < hi && nums[hi] === nums[hi - 1]) hi--;
          hi--;
        }
      }
    }
  }

  return res;
};

console.log(threeSum([-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4]));
