const lengthOfLongestSubstring = (s) => {
  if (s.length === 1) return 1;
  let dict = {};
  let max = 0;
  for (let i = 0, j = 0; i < s.length; i++) {
    const ch = s.charAt(i);
    if (ch in dict) j = Math.max(j, dict[ch] + 1);
    dict[ch] = i;
    max = Math.max(max, i - j + 1);
  }

  return max;
};

console.log(lengthOfLongestSubstring("dvdf")); // Output: 3
console.log(lengthOfLongestSubstring("abcabcdbb")); // Output: 4
