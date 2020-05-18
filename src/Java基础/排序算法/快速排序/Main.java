package 基本问题.排序算法.快速排序;

import java.util.Arrays;

/**
 * @description：
 * 选择第一个数为p作为中心轴，小于p的数放在左边，大于p的数放在右边。
 * 递归的将p左边和右边的数都按照第一步进行一次递归，直到不能递归。
 * 我们定义两个审核指针，一个从左到右遍历，找比p大的数字（比p小不是目的，继续右移），就把该数字放在右边去（右指针的位置）然后右指针继续左移一位；
 * 一个从右到左遍历，找比p小的数字（比p大不是目的，继续左移），并放在左边（左指针的位置），然后右指针继续左移一位。
 * 直到两个指针相遇，把p放在相遇的位置，完成第一次排序；
 * 第二次排序，记录第一次排序的相遇位置，以其为边界，对左边和右边的数字分别又进行递归比较，重复进行
 * 对所有递归结束的条件都是start==right，
 * 为了方便，默认选取需要排序区间的第一个数作为中心轴
 * * 快排的性能在所有排序算法里面是最好的，数据规模越大快速排序的性能越优。快排在极端情况下会退化成 [公式] 的算法，
 * 因此假如在提前得知处理数据可能会出现极端情况的前提下，可以选择使用较为稳定的归并排序。
 *
 * 先右寻再左寻，还是先左寻再右寻，这个顺序跟你中心轴的选取有关系，如果你的中心轴选end，
 * 那么就应该先右指针左寻，因为此时左寻退出循环之后，
 * 那个赋值说给中心轴的，中心轴的值本来就有保存，所以没影响；相反也是可以的
 *  更详细的查看：https://blog.csdn.net/csdnqixiaoxin/article/details/89429528?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
 * @url： https://zhuanlan.zhihu.com/p/93129029
 * @限制： 要求时间最快时
 * @author：Jack
 * @createTime：2020/3/24 22:05
 * @level：
 */
public class Main {
    public static void main(String[] args) {
        int []arr = {6,1,2,7,9};
        QuickSort1(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void QuickSort1(int arr[], int start, int end){
        int l=start,r=end;
        if(l<r){
            int pivot=arr[l];
            while (l!=r){
                while (l<r&&arr[r]>=pivot)
                    r--;
                arr[l]=arr[r];
                while (l<r&&arr[l]<=pivot)
                    l++;
                arr[r]=arr[l];
            }
            arr[l]=pivot;
            QuickSort(arr,start,l-1);
            QuickSort(arr,l+1,end);
        }
    }

    static void QuickSort(int arr[], int start, int end){

        int l=start;
        int r=end;
        if(l<r){
//            int pivot=arr[end];  //中心轴选取第一个
//            while (l!=r){
//                while (l<r&&arr[l]<=pivot)
//                    l++;
//                arr[r]=arr[l];
//
//                while (l<r&&arr[r]>=pivot)
//                    r--;
//                arr[l]=arr[r];
//            }
            //或
            int pivot=arr[start];  //中心轴
            while (l!=r){

                while (l<r&&arr[r]>=pivot)
                    r--;
                arr[l]=arr[r];

                while (l<r&&arr[l]<=pivot)
                    l++;
                arr[r]=arr[l];
            }
            arr[l]=pivot; //中心轴定位
            QuickSort(arr,start,l-1);
            QuickSort(arr,l+1,end);
        }
    }
}
