class Solution {
    maxUniqueSplit(s) {
      let ans = 0;
      this.dfs(s, 0, new Set(), ans);
      return ans;
    }
  
    dfs(s, start, seen, ans) {
      if (start === s.length) {
        ans = Math.max(ans, seen.size);
        return;
      }
  
      for (let i = 1; start + i <= s.length; i++) {
        const cand = s.substring(start, start + i);
        if (seen.has(cand)) continue;
        seen.add(cand);
        this.dfs(s, start + i, new Set(seen), ans);
        seen.delete(cand);
      }
    }
  }
  