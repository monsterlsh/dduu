import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * 解决思路：
 *  此类问题，通常暴力枚举无法AC（要么内存超出，要么处理时间超出），因此需要借助输入串的某种性质来缩小枚举范围
 *  由于输入串必然是:
 *      (1) 一个数(全部或部分)与其前后若干个数(可以为0)(全部或部分)的组合
 *      (2) 全0：
 *      如:
 *      (1) 123456，为数字1与其后5个数2、3、4、5、6的组合
 *      (2) 45661234567123 为数字1234567与其前1个数1234566的后4位以及后1个数1234568的前3位的组合
 *      (3) 123454124 为数字454124的前一个数454123的后3位与454124的组合
 *      (4) 45661234 为数字1234566的后4位与1234567的前3位的组合
 *      (5) 1000 为数字1000，与前后数字没有组合
 *
 *      按以上的方式可以将输入串分为以下5种普遍形式：
 *      (1) 连续型：输入串可以拆分为[n(head), n+1, n+2, n+3, ..., n+m]的形式
 *          其中，n可以由输入串连续的多位组成
 *      (2) 三段型：输入串可以拆分为[head, n, n+1, n+2, n+3, ..., n+m, b]
 *          其中a为n-1的后若干位（可以取0位），b为n+m+1的前若干位（可以取0位）
 *          可以发现，连续型是三段型的特殊形式（a取0位，b取0位）
 *      (3) 两段型：输入串拆分为[head, next]
 *          其中a，b为连续的两个数的部分
 *      (4) 整数型：输入串代表一个完整的数，无法拆分
 *      (5) 全0型：输入串全0，此类情况比较特殊，处理也简单，因为全0只出现在10，100，1000，...
 *
 *  那么问题可以转化为:
 *      找出输入串符合以上4种类型(全0型的无需划分)的所有划分，并找出其中索引最小的那个划分串
 *  实现：记输入串line长度为len
 *      (1) 首先，对每一种可能的分段(段大小segSize从1，2，...，len - 1)进行遍历，段大小为len的特殊处理
 *          后面可以发现这个segSize实际上这个segSize是符合要求的划分中，一个完整数字的位数
 *          也就是这个输入串是由一个位数为segSize的数(全部或部分)与其前后若干个数(可以为0、全部或部分)构成的
 *      (2) 根据段大小segSize将输入串line划分为头部head(从1到segSize)和剩余部分next(从segSize-1到0)
 *          遍历输入串的所有可能划分
 *      (3) 判断输入串的划分是否属于上述4种类型，如果属于，则是一种可行的划分，记录其索引
 *          判断方法如下：
 *          [1] segSize大小在[1, len-1)：此时包含三种可能出现的情况(三段型，两段型和连续型)
 *              [1.1] head长度在[1, segSize)时，此时的输入串属于三段型或二段型的划分
 *                  A. 当next的长度>=段长度segSize时，属于三段型：
 *                      a. 此时需要先判断head与next的第一段是否是连续的两个数
 *                      b. 若不是则这一划分不成立，进入下一划分。
 *                      c. 若是，则继续比较next中的后面几段的数值
 *                      d. 如果next中后面几段的数值是连续序列，则这是一个可行的划分，记录其索引值
 *                      e. 若不是，则进入下一划分
 *                  B. 当next的长度小于段长度segSize时，属于两段型：
 *                      a. 此时的剩余部分长度过小而不足以构成一个完整的数，必然不属于三段型
 *                          因此此时必然是两段型[a, b]的序列
 *                          并且 len(head)+len(next) > segSize，len(next) < segSize
 *                      b. 此时需要将head补充到足够的位数segSize
 *                          取next的前segSize-len(head)位作为head的前缀(判断是否要进位)
 *                          然后与next比较，若是连续则符合要求
 *              [1.2] head长度等于segSize时：此时必然只能满足连续型的划分
 *                  对整个输入串进行连续序列的判断，若满足连续型的性质，则记录其索引值
 *          [2] segSize = len时：此时可能的情况是两段型和整数型
 *              [2.1] 对于两段型的情况：遍历所有可能的两段型划分，记录最小的那个
 *              [2.2] 对于整数型的情况：直接计算该数所在的位置即可
 */
public class LongLongSequence {
    // 保存位数1到201的所有起始值和起始位置，方便计算
    // ms是所需要的数组的大小，202是最小容量
    // 因为输入串最多可能有200位，可能会出现在位数为201的数中
    private static final int ms = 202;
    // 位数1到201的起始值，分别是1, 10, 100, 1000...
    private static BigInteger[] beginValue = new BigInteger[ms];
    // 位数1到201的起始位置(数组索引)，分别是1，10, 10 + 90 * 2, 10 + 90*2 + 900*3, ...
    // 此数组需要使用DP算法来计算1到201的所有起始位置
    private static BigInteger[] beginPosition = new BigInteger[ms];
    // 记录当前可行划分中最小的索引，也是最后输出的结果
    private static BigInteger minIndex = new BigInteger("0");

    private static final BigInteger negOne = BigInteger.valueOf(-1);
    private static final BigInteger nine = new BigInteger("9");

    // 取得后面一个数字，输入为n，则输出n + 1
    private static String getNextInt(String n) {
        StringBuilder t = new StringBuilder();
        int len = n.length(), sum, carry = 1;
        for (int i = len - 1; i >= 0; --i) {
            char num = n.charAt(i);
            sum = num - 48 + carry;
            carry = sum / 10;
            sum %= 10;
            t.insert(0, (char) (sum + 48));
        }
        while (carry > 0) {
            sum = carry % 10;
            t.insert(0, (char) (sum + 48));
            carry /= 10;
        }
        return t.toString();
    }

    // 取得前一个数字，输入为n，则输出n - 1
    private static String getFrontInt(String n) {
        StringBuilder t = new StringBuilder();
        int len = n.length(), diff, borrow = 1;
        for (int i = len - 1; i >= 0; --i) {
            char num = n.charAt(i);
            diff = num - 48 - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            if (!(0 == i && diff == 0)) {
                t.insert(0, (char) (diff + 48));
            }
        }
        if (t.length() == 0) {
            t = new StringBuilder("0");
        }
        return t.toString();
    }

    // 获得a与line[pos: ]相等的子串长度，没有时返回-1
    private static int getEqualSubStrLen(String a, String line, int pos) {
        int i;
        for (i = 0; i < a.length() && (pos + i) < line.length(); ++i) {
            if (a.charAt(i) != line.charAt(pos + i)) {
                return -1;
            }
        }
        return i;
    }

    // 判断line是否为连续数构成的序列
    // 方法为：
    //      取第1个段作为头部head，获得head对应的后继successor(即head+1)
    //      与line[beginPos: ]比较，要么successor是line[beginPos: ]的子串
    //      要么line[beginPos: ]是successor的子串，否则不是连续数序列
    private static boolean stringCompareBySegSize(String line, int segSize) {
        int beginPos = segSize, ret, len = line.length();
        String head = line.substring(0, segSize);
        while (beginPos < len) {
            String successor = getNextInt(head);
            ret = getEqualSubStrLen(successor, line, beginPos);
            if (-1 == ret) {
                return false;
            } else {
                beginPos += ret;
                head = successor;
            }
        }
        return true;
    }

    // 在计算一个数的后继时，可能存在进位的情况(后几位全为9)
    // 在二段型情况的处理时需要额外判断
    private static boolean isCarryOut(String a) {
        int len = a.length();
        for (int i = 0; i < len; ++i) {
            if (a.charAt(i) != '9') return false;
        }
        return true;
    }

    //    --------------------------------------------------------------------------//
    // beginValue[] 记录了位数1到201的起始值，分别是1, 10, 100, 1000..
    // beginPosition[] 位数1到201的起始位置(数组索引)，分别是1，10, 10 + 90 * 2, 10 + 90*2 + 900*3, ...
    // 此数组需要使用DP算法来计算1到201的所有起始位置
    // len[] 为位数1到201的区间中数的个数，位数为1的有9个，2的有90(99 - 10 + 1)个，3的有900(999 - 100 + 1)个...
    private static void genBeginPos() {
        BigInteger[] len = new BigInteger[ms];
        BigInteger ten = BigInteger.ONE;
        len[0] = BigInteger.ZERO;
        beginPosition[0] = BigInteger.ZERO;
        beginPosition[1] = BigInteger.ONE;
        for (int i = 1; i < ms; ++i) {
            len[i] = nine.multiply(ten);
            beginValue[i] = ten;
            ten = ten.multiply(BigInteger.valueOf(10));
        }
        // DP算法求位数为i的第一个数的位置
        for (int i = 2; i < ms; ++i) {
            beginPosition[i] = beginPosition[i - 1].add(len[i - 1].multiply(BigInteger.valueOf(i - 1)));
        }
    }

    // 计算数value所在的位置
    // 根据其位数确定起始位置from
    // 根据value的值计算其相对于起始值的偏移量
    // value的位置就等于 from + offset
    private static BigInteger getPos(String value) {
        int len = value.length();
        BigInteger bValue = beginValue[len];
        BigInteger from = beginPosition[len];
        BigInteger offset = (new BigInteger(value)).subtract(bValue);
        offset = offset.multiply(BigInteger.valueOf(len));
        return from.add(offset);
    }

    // 设置当前最小的满足要求的划分的索引
    private static void setMinIndex(BigInteger a) {
        if (minIndex.compareTo(negOne) == 0 || minIndex.compareTo(a) > 0) {
            minIndex = a;
        }
    }

    // 判断是否全0
    private static boolean isAllZero(String a) {
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != '0') return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        // 首先计算位数1到201每区间的起始值和起始位置
        genBeginPos();
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        String line;
        line = cin.readLine();

        // 全0情况的特殊处理
        if (isAllZero(line)) {
            line = "1" + line;
            BigInteger pos = getPos(line);
            pos = pos.add(BigInteger.ONE);
            System.out.println(pos.toString());
            return;
        }

        final int line_len = line.length();
        minIndex = negOne;
        // 对输入串做不同的分段，从1 到 line_len - 1
        for (int segSize = 1; segSize < line_len; ++segSize) {
            String head, next;
            int head_len, next_len;

            // 情况[1.1] headSize在[1, segSize)
            for (int headSize = 1; headSize < segSize; ++headSize) {
                head = line.substring(0, headSize);
                head_len = head.length();
                next = line.substring(headSize, line_len);
                next_len = next.length();
                if (next_len > 0 && next.charAt(0) == '0') continue;

                // 情况[1.1.A] 三段型情形
                if (next_len >= segSize) {
                    // next 的第1段
                    String value = next.substring(0, segSize);
                    String prev = getFrontInt(value);

                    boolean ret = true;
                    // 判断不足segSize长度的head是否与next的第1段连续即 (value - 1) 的后len(head)位 == head
                    for (int i = head.length() - 1, j = prev.length() - 1;
                         i >= 0 ; --i, --j) {
                        if (head.charAt(i) != prev.charAt(j)) {
                            ret = false;
                            break;
                        }
                    }
                    // 相等时，继续判断next序列是否为连续序列
                    if (ret) {
                        boolean bNextEqualToSegmentSize = stringCompareBySegSize(next, segSize);
                        if (bNextEqualToSegmentSize) {
                            String beginValue = getFrontInt(value);
                            BigInteger pos = getPos(beginValue);
                            pos = pos.add(BigInteger.valueOf(beginValue.length() - head.length()));
                            setMinIndex(pos);
                        }
                    }
                } else { // 情况[1.1.B] 两段型[head, next]情形 len(a) + len(b) > segSize
                    // 获得head的前缀，next[0, segSize - len(head)]
                    String front_head = next.substring(0, segSize - head_len);

                    // 特殊情况，前面的数全为9，涉及进位
                    boolean bCarryOut = isCarryOut(head);
                    String front_part_value;
                    if (bCarryOut) {
                        // 有进位时，head的前缀比原先少1
                        front_part_value = getFrontInt(front_head);
                    } else {
                        front_part_value = front_head;
                    }

                    String frontValue = front_part_value + head;
                    String NextValue = getNextInt(frontValue);
                    boolean bIsEqual = true;
                    // 比较加上前缀后的frontValue是否与next连续
                    for (int i = 0, j = 0; i < NextValue.length() && j < next_len; ++i, ++j) {
                        if (NextValue.charAt(i) != next.charAt(j)) {
                            bIsEqual = false;
                            break;
                        }
                    }
                    // 连续的话，则为可行划分，记录较小的索引值
                    if (bIsEqual) {
                        BigInteger pos = getPos(frontValue);
                        pos = pos.add(BigInteger.valueOf(frontValue.length() - head.length()));
                        setMinIndex(pos);
                    }
                }
            }
            // 情况[1.2] 连续型情形
            // 头部head的长度与segSize相同时，只能存在连续型的情况
            // 对整个序列判断是否为连续序列
            if (line.charAt(segSize) != '0' && line.charAt(0) != '0') {
                boolean bHeadEqualToSegmentSize = stringCompareBySegSize(line, segSize);
                if (bHeadEqualToSegmentSize) {
                    String beginValue = line.substring(0, segSize);
                    BigInteger pos = getPos(beginValue);
                    setMinIndex(pos);
                }
            }
        }

        // 情况[2] 分段长度等于输入串长度
        // 情况[2.1] 两段型
        //  输入串划分为head和next，组合为next + head，找出最小的那个
        //  依然需要判断进位的情况
        for (int headSize = 1; headSize < line_len; ++headSize) {
            String head = line.substring(0, headSize);
            String next = line.substring(headSize, line_len);
            final int next_len = next.length();
            if (next_len > 0 && next.charAt(0) == '0') continue;

            // 进位处理
            boolean bCarryOut = isCarryOut(head);
            String frontValue;
            if (bCarryOut) {
                frontValue = getFrontInt(next) + head;
            } else {
                frontValue = next + head;
            }

            BigInteger pos = getPos(frontValue);
            pos = pos.add(BigInteger.valueOf(frontValue.length() - head.length()));
            setMinIndex(pos);
        }

        // 情况[2.2] 整数型
        // 此时整个输入串代表一个数，直接计算得到其位置即可
        if (line_len > 0 && line.charAt(0) != '0') {
            BigInteger pos = getPos(line);
            setMinIndex(pos);
        }

        if (minIndex.compareTo(negOne) != 0) {
            System.out.println(minIndex.toString());
        }
    }
}