var searchRange = (nums, target) => {
  let left = 0;
  let right = nums.length - 1;

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    if (nums[mid] === target) {
      let i, j;
      i = j = mid;
      while (nums[i] === target) i--;
      while (nums[j] === target) j++;

      return [i + 1, j - 1];
    }
    if (target > nums[mid]) left = mid + 1;
    else right = mid - 1;
  }

  return [-1, -1];
};

console.log(searchRange([5, 7, 7, 8, 8, 10], 8)); // returns [3,4]
