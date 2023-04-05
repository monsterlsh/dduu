//54. 数据流中的中位数
//剑指 Offer 41. 数据流中的中位数
class MedianFinder {
    multiset<int> nums;
    multiset<int>::iterator left, right;

public:
    MedianFinder() : left(nums.end()), right(nums.end()) {}

    void addNum(int num) {
        const size_t n = nums.size();

        nums.insert(num);
        if (!n) {
            left = right = nums.begin();
        } else if (n & 1) {
            if (num < *left) {
                left--;
            } else {
                right++;
            }
        } else {
            if (num > *left && num < *right) {
                left++;
                right--;
            } else if (num >= *right) {
                left++;
            } else {
                right--;
                left = right;
            }
        }
    }

    double findMedian() {
        return (*left + *right) / 2.0;
    }
};


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */