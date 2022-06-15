var merge = function (nums1, m, nums2, n) {
  const arrNums1 = Array(m);
  for (let i = 0; i < m; i++) arrNums1[i] = nums1[i];

  let i, j, k;
  i = j = k = 0;

  while (i < m && j < n)
    nums1[k++] = arrNums1[i] <= nums2[j] ? arrNums1[i++] : nums2[j++];

  while (i < m) nums1[k++] = arrNums1[i++];

  while (j < n) nums1[k++] = nums2[j++];

  return nums1;
};

console.log(merge([1, 2, 3, 0, 0, 0], 3, [2, 5, 6], 3));
