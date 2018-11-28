package LeetCode.book;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySequenceOfBST {


    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int start, int end) {
        if (start >= end - 1) {  // 只有两个以内的数，无论怎么排列都合理
            return true;
        }

        int rootVal = sequence[end];  // 最后一个节点为根节点
        int index = start;
        while (sequence[index] < rootVal && index < end) { // 小于root的节点为左枝
            index++;
        }

        for (int i = index; i < end; i++) { // 右枝必须都大于根节点
            if (sequence[i] < rootVal) {
                return false;
            }
        }

        return verify(sequence, start, index - 1) && verify(sequence, index, end - 1);
    }

}
