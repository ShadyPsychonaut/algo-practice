var twoSum = function (nums, target) {
  let map = {};
  for (let i in nums) {
    const newTarget = target - nums[i];
    if (newTarget in map) return [map[newTarget], i];
    map[nums[i]] = i;
  }
};

console.log(twoSum([3, 2, 4], 6));
