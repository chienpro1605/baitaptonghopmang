import java.util.Scanner;

public class baitaptonghopmang {
    public static void main(String[] args) {
        int choice;
        int [] arr = new int[100];
        int size = 0;

        Scanner scanner = new Scanner(System.in);
        do {
            menu();
            System.out.println("nhập lựa chọn: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    size = inputSize();
                    inputArray(arr,size);
                    break;
                case 2:
                    displayArray(arr,size);
                    break;
                case 3:
                    System.out.println("số chẵn lớn nhất trong mảng là: " +  findMaxEven(arr, size));
                    break;
                case 4:
                    System.out.println("danh sách các số chẵn trong mảng là:");
                    listEven(arr, size);
                    break;
                case 5:
                    System.out.println("tổng các số chẵn trong mảng là:"+ countSumEven(arr,size));
                    break;
                case 6:
                    chenViTri(arr,size);
                    System.out.println("mảng mới là:");
                    displayArray(arr,size+1);
                    break;
                case 7:
                    System.out.println("nhập giá trị cần xóa:");
                    int x = scanner.nextInt();
                    int count = 0;
                    while (viTriXoa(arr, size, x) != -1){
                        for (int i = viTriXoa(arr, size, x); i<size-count; i++){
                            arr[i] = arr[i+1];
                        }
                        count++;
                    }
                    System.out.println("mảng mới là: ");
                    displayArray(arr,size-count);
                    break;
                case 8:
                    System.out.println("mảng đảo ngược là:");
                    daonguocArr(arr,size);
                    displayArray(arr,size);
                    break;
                case 9:
                    System.out.println("danh sách các số nguyên tố là:");
                    displaysonguyento(arr,size);
                    break;
                case 10:
                    System.out.println("mảng theo thứ tự giảm dần là: ");
                    sapxeparr(arr, size);
                    break;
                case 11:
                    System.exit(0);
                    break;
            }

        }while (choice>=1 && choice<=11);

    }
    static void menu(){
        System.out.println("\n========MENU===========");
        System.out.println("1. Nhập mảng có kích thước N (0<N<100)");
        System.out.println("2. Hiển thị mảng vừa nhập");
        System.out.println("3. Tìm số chẵn lớn nhất trong mảng");
        System.out.println("4. Liệt kê danh sách các số chẵn trong mảng");
        System.out.println("5. Tính tổng các số chẵn trong mảng");
        System.out.println("6. Nhập vào giá trị và vị trí cần chèn của giá trị đó trong mảng, chèn giá trị đó vào mảng");
        System.out.println("7. Xoá tất cả các phần tử có giá trị bằng X (được nhập từ bàn phím) khỏi mảng");
        System.out.println("8. Đảo ngược mảng ban đầu");
        System.out.println("9. Hiển thị danh sách các số nguyên tố trong mảng");
        System.out.println("10. Sắp xếp mảng theo thứ tự giảm dần");
        System.out.println("11. Thoat");

    }
    static int inputSize(){
        int N;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("nhập kích thước của mảng");
            N = scanner.nextInt();
        }while (N<=0 || N>=100);
        return N;
    }
    static void inputArray(int[] arr, int N){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập mảng có N phần tử: ");
        for (int i = 0; i<N;i++){
            System.out.print("arr["+i+"]=");
            arr[i]= scanner.nextInt();
        }
    }
    static void displayArray(int[] arr, int N){
        System.out.println("các phần tử của mảng là: ");
        for (int i=0; i<N; i++){
            System.out.println(arr[i]+ " ");
        }
    }
    static int findMaxEven(int[] arr, int N){
        int max=arr[0];
        for (int i = 0; i<N; i++){
            if (arr[i]%2==0 && max < arr[i]){
                max = arr[i];
            }
        }
        return max;

    }
    static void listEven(int[] arr, int N){
        for (int i = 0; i<N; i++){
            if (arr[i]%2 == 0){
                System.out.println(arr[i]+" ");
            }
        }
    }
    static int countSumEven(int[] arr, int N){
        int sum = 0;
        for (int i=0; i<N; i++){
            if (arr[i]%2==0){
                sum += arr[i];
            }
        }
        return sum;
    }
    static void chenViTri(int[] arr, int N){
        Scanner scanner = new Scanner(System.in);
        int number, vitri;
        System.out.println("giá trị number cần chèn là: ");
        number = scanner.nextInt();
        System.out.println("vị trí cần chèn là: ");
        vitri = scanner.nextInt();
        while (vitri>N || vitri<0){
            System.out.println("nhập lại vị trí:");
            vitri = scanner.nextInt();
        }
        for (int i = N -1; i>=vitri; i--){
            arr[i+1]=arr[i];
        }
        arr[vitri] = number;
    }
    static int viTriXoa(int []arr,int N, int x) {
        int vitri = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] == x) {
                vitri = i;
            }
        }

        return vitri;
    }
    static void daonguocArr(int[] arr, int N){
        int x =0;
        int y =N-1;
        while (x<=y){
            int a= arr[x];
            arr[x] = arr[y];
            arr[y] = a;
            x++;
            y--;
        }
    }
    static boolean checkSonguyento(int x){
       boolean songuyento = true;
       if (x<2){
           songuyento = false;
       }else {
           for (int i = 2; i<x; i++){
               if (x%i ==0){
                   songuyento = false;
                   break;
               }
           }
       }
       return songuyento;
    }
    static void displaysonguyento(int[] arr, int N){
        for (int i =0; i<N; i++){
            if (checkSonguyento(arr[i])){
                System.out.println(arr[i]+ "  ");
            }
        }
        System.out.println();
    }
    static void sapxeparr(int[] arr, int N){
        int x = 0;
       for (int i = 0; i<N; i++){
           for (int j = i+1; j<N; j++){
               if (arr[i]<arr[j]){
                   x = arr[j];
                   arr[j] = arr[i];
                   arr[i] = x;
               }
           }
           System.out.println(arr[i]+ " ");
       }


    }

}
