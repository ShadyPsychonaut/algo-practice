const longestPalindrome = (s) => {
  let start = 0,
    end = 0;

  for (let i = 0; i < s.length; i++) {
    const ch = s[i];
    let left = i;
    let right = i;

    while (left >= 0 && s[left] === ch) left--;
    while (right < s.length && s[right] === ch) right++;

    while (left >= 0 && right < s.length) {
      if (s[left] !== s[right]) break;
      left--;
      right++;
    }

    left = left + 1;
    right = right - 1;
    if (end - start < right - left) {
      start = left;
      end = right;
    }
  }

  return [s.substr(start, end - start + 1), end - start + 1];
};

console.log(longestPalindrome("dabba")); // outputs ['abba', 4]
