class MyQueue:

    def __init__(self):
        self.input_st = []
        self.output_st = []

    def push(self, x: int) -> None:
        self.input_st.append(x)

    def pop(self) -> int:
        self.transfer()
        return self.output_st.pop()

    def peek(self) -> int:
        self.transfer()
        return self.output_st[-1]

    def empty(self) -> bool:
        return not self.input_st and not self.output_st

    def transfer(self) -> None:
        # if input stack is not empty, it means there is scope to transfer over latest pushed elements
        # while elements exist in the input stack, keep popping them and pushing to the output stack
        if not self.output_st:
            while self.input_st:
                ele = self.input_st.pop()
                self.output_st.append(ele)


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
