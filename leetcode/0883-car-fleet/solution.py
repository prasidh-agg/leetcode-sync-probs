class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        combined = zip(position, speed)
        combined_sorted = sorted(combined, reverse=True)

        count = 0
        max_time = 0
        for pos, sp in combined_sorted:
            time = (target - pos) / sp
            if time > max_time:
                count += 1
                max_time = time
        
        return count
