var letterCombinations = (digits) => {
  const teleMap = {
    2: ["a", "b", "c"],
    3: ["d", "e", "f"],
    4: ["g", "h", "i"],
    5: ["j", "k", "l"],
    6: ["m", "n", "o"],
    7: ["p", "q", "r", "s"],
    8: ["t", "u", "v"],
    9: ["w", "x", "y", "z"],
  };

  if (digits.length === 0) return [];
  if (digits.length === 1) return teleMap[digits];

  return backtrack(digits, teleMap, 0);
};

const backtrack = (digits, teleMap, start, res = [], sb = "") => {
  if (start === digits.length) {
    res.push(sb);
    return res;
  }
  const num = digits[start];
  for (const ch of teleMap[num]) {
    res = backtrack(digits, teleMap, start + 1, res, sb + ch);
  }

  return res;
};

console.log(letterCombinations("23"));
