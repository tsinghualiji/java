public class Array
{
    public static int[] random(int n)                      //产生n个随机数，返回整型数组
    {
        if (n>0)
        {
            int table[] = new int[n];
            for (int i=0; i<table.length; i++)
                table[i] = (int)(Math.random()*100);       //产生一个0～100之间的随机数
            return table;                                  //返回一个数组
        }
        return null;
    }

    public static void print(int[] table)                  //输出数组元素
    {
        if (table!=null)
            for (int i=0; i<table.length; i++)
                System.out.print(" "+table[i]);
        System.out.println();
    }

    public static void insertSort(int[] table)             //直接插入排序
    {                                                      //数组是引用类型，元素值将被改变
        System.out.println("直接插入排序");
        for (int i=1; i<table.length; i++)                  //n-1趟扫描
        {
            int temp=table[i], j;                          //每趟将table[i]插入到前面已排序的序列中
//          System.out.print("移动");
            for (j=i-1; j>-1 && temp<table[j]; j--)        //将前面较大元素向后移动
            {
//                System.out.print(table[j]+", ");
                table[j+1] = table[j];
            }
            table[j+1] = temp;                             //temp值到达插入位置
            System.out.print("第"+i+"趟: ");
            print(table);
        }
    }

    public static void shellSort(int[] table)              //希尔排序
    {
        System.out.println("希尔排序");
        for (int delta=table.length/2; delta>0; delta/=2)  //控制增量，增量减半，若干趟扫描
        {
            for (int i=delta; i<table.length; i++)         //一趟中若干组，每个元素在自己所属组内进行直接插入排序
            {
                int temp = table[i];                       //当前待插入元素
                int j=i-delta;                             //相距delta远
                while (j>=0 && temp<table[j])              //一组中前面较大的元素向后移动
                {
                    table[j+delta] = table[j];
                    j-=delta;                              //继续与前面的元素比较
                } 
                table[j+delta] = temp;                     //插入元素位置
            }
            System.out.print("delta="+delta+"  ");
            print(table);
        }
    }

    private static void swap(int[] table, int i, int j)     //交换数组中下标为i、j的元素
    { 
        if (i>=0 && i<table.length && j>=0 && j<table.length && i!=j)   //判断i、j是否越界
        {
            int temp = table[j];
            table[j] = table[i];
            table[i] = temp;
        }
    }

    public static void bubbleSort(int[] table)             //冒泡排序
    {
        System.out.println("冒泡排序");
        boolean exchange=true;                             //是否交换的标记
        for (int i=1; i<table.length && exchange; i++)     //有交换时再进行下一趟，最多n-1趟
        {
            exchange=false;                                //假定元素未交换 
            for (int j=0; j<table.length-i; j++)           //一次比较、交换
                if (table[j]>table[j+1])                   //反序时，交换
                {
                    int temp = table[j];
                    table[j] = table[j+1];
                    table[j+1] = temp;
                    exchange=true;                         //有交换 
                }
            System.out.print("第"+i+"趟: ");
            print(table);
        }
    }

    public static void quickSort(int[] table)              //快速排序
    {
        quickSort(table, 0, table.length-1);
    }

    private static void quickSort(int[] table, int low, int high) //一趟快速排序，递归算法
    {                                                      //low、high指定序列的下界和上界
        if (low<high)                                      //序列有效
        {
             int i=low, j=high;
             int vot=table[i];                             //第一个值作为基准值
             while (i!=j)                                  //一趟排序
             {
                 while (i<j && vot<=table[j])              //从后向前寻找较小值
                     j--;
                 if (i<j)
                 {
                     table[i]=table[j];                    //较小元素向前移动
                     i++;
                 }     
                 while (i<j && table[i]<vot)               //从前向后寻找较大值
                     i++;
                 if (i<j)
                 {
                     table[j]=table[i];                    //较大元素向后移动
                     j--;
                 }     
             }
            table[i]=vot;                                  //基准值的最终位置
            System.out.print(low+".."+high+",  vot="+vot+"  ");
            print(table);
            quickSort(table, low, j-1);                    //前端子序列再排序
            quickSort(table, i+1, high);                   //后端子序列再排序
        }
    }

    public static void selectSort(int[] table)             //直接选择排序
    {
        System.out.println("直接选择排序");
        for (int i=0; i<table.length-1; i++)               //n-1趟排序
        {                                                  //每趟在从table[i]开始的子序列中寻找最小元素
            int min=i;                                     //设第i个数据元素最小
            for (int j=i+1; j<table.length; j++)           //在子序列中查找最小值
                if (table[j]<table[min])
                     min = j;                              //记住最小元素下标

            if (min!=i)                                    //将本趟最小元素交换到前边
            {
                int temp = table[i];
                table[i] = table[min];
                table[min] = temp;
            }
            System.out.print("第"+i+"趟: ");
            print(table);
        }
    }

    private static void sift(int[] table, int low, int high) //将以low为根的子树调整成最小堆
    {                                                      //low、high是序列下界和上界
        int i=low;                                         //子树的根
        int j=2*i+1;                                       //j为i结点的左孩子
        int temp=table[i];                                 //获得第i个元素的值
        while (j<=high)                                    //沿较小值孩子结点向下筛选
        {                                                  
            if (j<high && table[j]>table[j+1])             //数组元素比较（改成<为最大堆）
                j++;                                       //j为左右孩子的较小者
            if (temp>table[j])                             //若父母结点值较大（改成<为最大堆）
            {
                table[i]=table[j];                         //孩子结点中的较小值上移
                i=j;                                       //i、j向下一层
                j=2*i+1;
            }
            else
                j=high+1;                                  //退出循环
        }
        table[i]=temp;                                     //当前子树的原根值调整后的位置
        System.out.print("sift  "+low+".."+high+"  ");
        print(table);
    }

    public static void heapSort(int[] table)
    {
        System.out.println("堆排序");
        int n=table.length;
        for (int j=n/2-1; j>=0; j--)                       //创建最小堆
            sift(table, j, n-1);
//        System.out.println("最小堆？ "+isMinHeap(table));
            
        for (int j=n-1; j>0; j--)                          //每趟将最小值交换到后面，再调整成堆
        {
            int temp = table[0];
            table[0] = table[j];
            table[j] = temp;
            sift(table, 0, j-1);
        }
    }

    public static void mergeSort(int[] X)                  //归并排序
    {
        System.out.println("归并排序");
        int n=1;                                           //已排序的子序列长度，初值为1
        int[] Y = new int[X.length];                       //Y数组长度同X数组
        do
        {
            mergepass(X, Y, n);                            //一趟归并，将X数组中各子序列归并到Y中
            print(Y);
            n*=2;                                          //子序列长度加倍

            if (n<X.length)
            {
                mergepass(Y, X, n);                        //将Y数组中各子序列再归并到X中
                print(X);
                n*=2;
            }
        } while (n<X.length);
    }
    
    private static void mergepass(int[] X, int[] Y, int n) //一趟归并
    {
        System.out.print("子序列长度n="+n+"  ");
        int i=0;
        while (i<X.length-2*n+1)
        {
            merge(X,Y,i,i+n,n);
            i += 2*n;
        }
        if (i+n<X.length)
            merge(X,Y,i,i+n,n);                            //再一次归并
        else  
            for (int j=i; j<X.length; j++)                 //将X剩余元素复制到Y中
                Y[j]=X[j];
    }

    private static void merge(int[] X, int[] Y, int m, int r, int n)   //一次归并
    {
        int i=m, j=r, k=m;
        while (i<r && j<r+n && j<X.length)                 //将X中两个相邻子序列归并到Y中
            if (X[i]<X[j])                                 //较小值复制到Y中
                Y[k++]=X[i++];
            else
                Y[k++]=X[j++];

        while (i<r)                                        //将前一个子序列剩余元素复制到Y中
            Y[k++]=X[i++];
        while (j<r+n && j<X.length)                        //将后一个子序列剩余元素复制到Y中
            Y[k++]=X[j++];
    }
    
    public static boolean isMinHeap(int[] table)           //判断一个数据序列是否为最小堆
    {
        if (table==null)
            return false; 

        int i = table.length/2 -1;                         //最深一棵子树的根结点
        while (i>=0)
        {
            int j=2*i+1;                                   //左孩子
            if (j<table.length) 
                if (table[i]>table[j])
                    return false;
                else 
                    if (j+1<table.length && table[i]>table[j+1])       //右孩子
                        return false; 
            i--;
        }
        return true;
    }


    
    public static void main(String[] args)
    {
        int[] table = {52,26,97,19,66,8,49};//Array.random(9);{49,65,13,81,76,97,38,49};////{85,12,36,24,47,30,53,91,76};//;//{4,5,8,1,2,7,3,6};// {32,26,87,72,26,17};//
        //        int[] table = {13,27,38,49,97,76,49,81};        //最小堆
        System.out.print("关键字序列: ");
        Array.print(table);
        Array.insertSort(table);
        Array.shellSort(table);
        Array.bubbleSort(table);
        Array.quickSort(table);
        Array.selectSort(table);
        Array.heapSort(table);
        Array.mergeSort(table);

        System.out.println("最小堆序列? "+Array.isMinHeap(table));
    }
    
}