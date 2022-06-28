var trap = (height) => {
  let ans = 0;
  let left_max = Array(height.length);
  let right_max = Array(height.length);

  left_max[0] = height[0];
  for (let i = 1; i < height.length; i++) {
    left_max[i] = Math.max(height[i], left_max[i - 1]);
  }

  right_max[height.length - 1] = height[height.length - 1];
  for (let i = height.length - 2; i >= 0; i--) {
    right_max[i] = Math.max(height[i], right_max[i + 1]);
  }

  for (let i = 1; i < height.length - 1; i++)
    ans += Math.min(left_max[i], right_max[i]) - height[i];

  return ans;
};

console.log(trap([4, 2, 0, 3, 2, 5]));
