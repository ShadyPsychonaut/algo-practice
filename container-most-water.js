var maxArea = function (height) {
  let maxWater = 0,
    area = 0;
  let x = 0,
    y = height.length - 1;

  while (x !== y) {
    if (height[x] <= height[y]) {
      area = height[x] * (y - x);
      x++;
    } else {
      area = height[y] * (y - x);
      y--;
    }
    maxWater = Math.max(maxWater, area);
  }

  return maxWater;
};

console.log(maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7])); // Output : 49
