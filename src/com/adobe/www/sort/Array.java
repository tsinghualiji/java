public class Array
{
    public static int[] random(int n)                      //����n���������������������
    {
        if (n>0)
        {
            int table[] = new int[n];
            for (int i=0; i<table.length; i++)
                table[i] = (int)(Math.random()*100);       //����һ��0��100֮��������
            return table;                                  //����һ������
        }
        return null;
    }

    public static void print(int[] table)                  //�������Ԫ��
    {
        if (table!=null)
            for (int i=0; i<table.length; i++)
                System.out.print(" "+table[i]);
        System.out.println();
    }

    public static void insertSort(int[] table)             //ֱ�Ӳ�������
    {                                                      //�������������ͣ�Ԫ��ֵ�����ı�
        System.out.println("ֱ�Ӳ�������");
        for (int i=1; i<table.length; i++)                  //n-1��ɨ��
        {
            int temp=table[i], j;                          //ÿ�˽�table[i]���뵽ǰ���������������
//          System.out.print("�ƶ�");
            for (j=i-1; j>-1 && temp<table[j]; j--)        //��ǰ��ϴ�Ԫ������ƶ�
            {
//                System.out.print(table[j]+", ");
                table[j+1] = table[j];
            }
            table[j+1] = temp;                             //tempֵ�������λ��
            System.out.print("��"+i+"��: ");
            print(table);
        }
    }

    public static void shellSort(int[] table)              //ϣ������
    {
        System.out.println("ϣ������");
        for (int delta=table.length/2; delta>0; delta/=2)  //�����������������룬������ɨ��
        {
            for (int i=delta; i<table.length; i++)         //һ���������飬ÿ��Ԫ�����Լ��������ڽ���ֱ�Ӳ�������
            {
                int temp = table[i];                       //��ǰ������Ԫ��
                int j=i-delta;                             //���deltaԶ
                while (j>=0 && temp<table[j])              //һ����ǰ��ϴ��Ԫ������ƶ�
                {
                    table[j+delta] = table[j];
                    j-=delta;                              //������ǰ���Ԫ�رȽ�
                } 
                table[j+delta] = temp;                     //����Ԫ��λ��
            }
            System.out.print("delta="+delta+"  ");
            print(table);
        }
    }

    private static void swap(int[] table, int i, int j)     //�����������±�Ϊi��j��Ԫ��
    { 
        if (i>=0 && i<table.length && j>=0 && j<table.length && i!=j)   //�ж�i��j�Ƿ�Խ��
        {
            int temp = table[j];
            table[j] = table[i];
            table[i] = temp;
        }
    }

    public static void bubbleSort(int[] table)             //ð������
    {
        System.out.println("ð������");
        boolean exchange=true;                             //�Ƿ񽻻��ı��
        for (int i=1; i<table.length && exchange; i++)     //�н���ʱ�ٽ�����һ�ˣ����n-1��
        {
            exchange=false;                                //�ٶ�Ԫ��δ���� 
            for (int j=0; j<table.length-i; j++)           //һ�αȽϡ�����
                if (table[j]>table[j+1])                   //����ʱ������
                {
                    int temp = table[j];
                    table[j] = table[j+1];
                    table[j+1] = temp;
                    exchange=true;                         //�н��� 
                }
            System.out.print("��"+i+"��: ");
            print(table);
        }
    }

    public static void quickSort(int[] table)              //��������
    {
        quickSort(table, 0, table.length-1);
    }

    private static void quickSort(int[] table, int low, int high) //һ�˿������򣬵ݹ��㷨
    {                                                      //low��highָ�����е��½���Ͻ�
        if (low<high)                                      //������Ч
        {
             int i=low, j=high;
             int vot=table[i];                             //��һ��ֵ��Ϊ��׼ֵ
             while (i!=j)                                  //һ������
             {
                 while (i<j && vot<=table[j])              //�Ӻ���ǰѰ�ҽ�Сֵ
                     j--;
                 if (i<j)
                 {
                     table[i]=table[j];                    //��СԪ����ǰ�ƶ�
                     i++;
                 }     
                 while (i<j && table[i]<vot)               //��ǰ���Ѱ�ҽϴ�ֵ
                     i++;
                 if (i<j)
                 {
                     table[j]=table[i];                    //�ϴ�Ԫ������ƶ�
                     j--;
                 }     
             }
            table[i]=vot;                                  //��׼ֵ������λ��
            System.out.print(low+".."+high+",  vot="+vot+"  ");
            print(table);
            quickSort(table, low, j-1);                    //ǰ��������������
            quickSort(table, i+1, high);                   //���������������
        }
    }

    public static void selectSort(int[] table)             //ֱ��ѡ������
    {
        System.out.println("ֱ��ѡ������");
        for (int i=0; i<table.length-1; i++)               //n-1������
        {                                                  //ÿ���ڴ�table[i]��ʼ����������Ѱ����СԪ��
            int min=i;                                     //���i������Ԫ����С
            for (int j=i+1; j<table.length; j++)           //���������в�����Сֵ
                if (table[j]<table[min])
                     min = j;                              //��ס��СԪ���±�

            if (min!=i)                                    //��������СԪ�ؽ�����ǰ��
            {
                int temp = table[i];
                table[i] = table[min];
                table[min] = temp;
            }
            System.out.print("��"+i+"��: ");
            print(table);
        }
    }

    private static void sift(int[] table, int low, int high) //����lowΪ����������������С��
    {                                                      //low��high�������½���Ͻ�
        int i=low;                                         //�����ĸ�
        int j=2*i+1;                                       //jΪi��������
        int temp=table[i];                                 //��õ�i��Ԫ�ص�ֵ
        while (j<=high)                                    //�ؽ�Сֵ���ӽ������ɸѡ
        {                                                  
            if (j<high && table[j]>table[j+1])             //����Ԫ�رȽϣ��ĳ�<Ϊ���ѣ�
                j++;                                       //jΪ���Һ��ӵĽ�С��
            if (temp>table[j])                             //����ĸ���ֵ�ϴ󣨸ĳ�<Ϊ���ѣ�
            {
                table[i]=table[j];                         //���ӽ���еĽ�Сֵ����
                i=j;                                       //i��j����һ��
                j=2*i+1;
            }
            else
                j=high+1;                                  //�˳�ѭ��
        }
        table[i]=temp;                                     //��ǰ������ԭ��ֵ�������λ��
        System.out.print("sift  "+low+".."+high+"  ");
        print(table);
    }

    public static void heapSort(int[] table)
    {
        System.out.println("������");
        int n=table.length;
        for (int j=n/2-1; j>=0; j--)                       //������С��
            sift(table, j, n-1);
//        System.out.println("��С�ѣ� "+isMinHeap(table));
            
        for (int j=n-1; j>0; j--)                          //ÿ�˽���Сֵ���������棬�ٵ����ɶ�
        {
            int temp = table[0];
            table[0] = table[j];
            table[j] = temp;
            sift(table, 0, j-1);
        }
    }

    public static void mergeSort(int[] X)                  //�鲢����
    {
        System.out.println("�鲢����");
        int n=1;                                           //������������г��ȣ���ֵΪ1
        int[] Y = new int[X.length];                       //Y���鳤��ͬX����
        do
        {
            mergepass(X, Y, n);                            //һ�˹鲢����X�����и������й鲢��Y��
            print(Y);
            n*=2;                                          //�����г��ȼӱ�

            if (n<X.length)
            {
                mergepass(Y, X, n);                        //��Y�����и��������ٹ鲢��X��
                print(X);
                n*=2;
            }
        } while (n<X.length);
    }
    
    private static void mergepass(int[] X, int[] Y, int n) //һ�˹鲢
    {
        System.out.print("�����г���n="+n+"  ");
        int i=0;
        while (i<X.length-2*n+1)
        {
            merge(X,Y,i,i+n,n);
            i += 2*n;
        }
        if (i+n<X.length)
            merge(X,Y,i,i+n,n);                            //��һ�ι鲢
        else  
            for (int j=i; j<X.length; j++)                 //��Xʣ��Ԫ�ظ��Ƶ�Y��
                Y[j]=X[j];
    }

    private static void merge(int[] X, int[] Y, int m, int r, int n)   //һ�ι鲢
    {
        int i=m, j=r, k=m;
        while (i<r && j<r+n && j<X.length)                 //��X���������������й鲢��Y��
            if (X[i]<X[j])                                 //��Сֵ���Ƶ�Y��
                Y[k++]=X[i++];
            else
                Y[k++]=X[j++];

        while (i<r)                                        //��ǰһ��������ʣ��Ԫ�ظ��Ƶ�Y��
            Y[k++]=X[i++];
        while (j<r+n && j<X.length)                        //����һ��������ʣ��Ԫ�ظ��Ƶ�Y��
            Y[k++]=X[j++];
    }
    
    public static boolean isMinHeap(int[] table)           //�ж�һ�����������Ƿ�Ϊ��С��
    {
        if (table==null)
            return false; 

        int i = table.length/2 -1;                         //����һ�������ĸ����
        while (i>=0)
        {
            int j=2*i+1;                                   //����
            if (j<table.length) 
                if (table[i]>table[j])
                    return false;
                else 
                    if (j+1<table.length && table[i]>table[j+1])       //�Һ���
                        return false; 
            i--;
        }
        return true;
    }


    
    public static void main(String[] args)
    {
        int[] table = {52,26,97,19,66,8,49};//Array.random(9);{49,65,13,81,76,97,38,49};////{85,12,36,24,47,30,53,91,76};//;//{4,5,8,1,2,7,3,6};// {32,26,87,72,26,17};//
        //        int[] table = {13,27,38,49,97,76,49,81};        //��С��
        System.out.print("�ؼ�������: ");
        Array.print(table);
        Array.insertSort(table);
        Array.shellSort(table);
        Array.bubbleSort(table);
        Array.quickSort(table);
        Array.selectSort(table);
        Array.heapSort(table);
        Array.mergeSort(table);

        System.out.println("��С������? "+Array.isMinHeap(table));
    }
    
}