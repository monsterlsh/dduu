class Solution:
    # API
    def reverseWords(self, s: str) -> str:
        return " ".join(reversed(s.split()))



class Solution2:
    '''
    手写api
    '''
    def trim_spaces(self, s: str) -> list:
        left, right = 0, len(s) - 1
        # 去掉字符串开头的空白字符
        while left <= right and s[left] == ' ':
            left += 1

        # 去掉字符串末尾的空白字符
        while left <= right and s[right] == ' ':
            right -= 1

        # 将字符串间多余的空白字符去除
        output = []
        while left <= right:
            if s[left] != ' ':
                output.append(s[left])
            elif output[-1] != ' ':
                output.append(s[left])
            left += 1

        return output

    def reverse(self, l: list, left: int, right: int) -> None:
        while left < right:
            l[left], l[right] = l[right], l[left]
            left, right = left + 1, right - 1

    def reverse_each_word(self, l: list) -> None:
        n = len(l)
        start = end = 0

        while start < n:
            # 循环至单词的末尾
            while end < n and l[end] != ' ':
                end += 1
            # 翻转单词
            self.reverse(l, start, end - 1)
            # 更新start，去找下一个单词
            start = end + 1
            end += 1

    def reverseWords(self, s: str) -> str:
        l = self.trim_spaces(s)

        # 翻转字符串
        self.reverse(l, 0, len(l) - 1)

        # 翻转每个单词
        self.reverse_each_word(l)

        return ''.join(l)

 class Solution3:
     '''
     双端队列
     '''
     def reverseWords(self, s: str) -> str:
         left, right = 0, len(s) - 1
         # 去掉字符串开头的空白字符
         while left <= right and s[left] == ' ':
             left += 1

         # 去掉字符串末尾的空白字符
         while left <= right and s[right] == ' ':
             right -= 1

         d, word = collections.deque(), []
         # 将单词 push 到队列的头部
         while left <= right:
             if s[left] == ' ' and word:
                 d.appendleft(''.join(word))
                 word = []
             elif s[left] != ' ':
                 word.append(s[left])
             left += 1
         d.appendleft(''.join(word))

         return ' '.join(d)





