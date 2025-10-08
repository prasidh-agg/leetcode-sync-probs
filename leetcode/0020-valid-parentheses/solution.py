class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for ch in s:
            if ch in "({[":
                stack.append(ch)
            else:
                if stack:
                    if stack[-1] == "(" and ch == ")":
                        stack.pop()
                    elif stack[-1] == "{" and ch == "}":
                        stack.pop()
                    elif stack[-1] == "[" and ch == "]":
                        stack.pop()
                    else:
                        return False
                else:
                    return False
        return not stack
