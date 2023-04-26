
import java.util.Scanner;


public class TUGAS_ANTRIAN {
    static final int MAX_SIZE = 10;
    static int[] queue1 = new int[MAX_SIZE];
    static int[] queue2 = new int[MAX_SIZE];
    static int rear1 = -1, front1 = -1, rear2 = -1, front2 = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, data, pos;
        while (true) {
            System.out.println("\n === BANK MANGKIRI ===");
            System.out.println("1. Tambah Data Antrian");
            System.out.println("2. Hapus Antrian Elemen Pertama");
            System.out.println("3. Hapus Antrian di Posisi Tertentu");
            System.out.println("4. Hapus Semua Elemen");
            System.out.println("5. Tampilkan Data");
            System.out.println("6. Keluar");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan data: ");
                    data = sc.nextInt();
                    enqueue(data);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    System.out.print("Masukkan posisi data yang akan dihapus : ");
                    pos = sc.nextInt();
                    dequeue(pos);
                    break;
                case 4:
                    clear();
                    break;
                case 5:
                    display();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
            System.out.println();
        }
    }

    static void enqueue(int data) {
        int choice;
        Scanner sc = new Scanner(System.in);

        System.out.println("Pilih jalur antrian :1 / 2: ");
        choice = sc.nextInt();

        if (choice == 1) {
            if (rear1 == MAX_SIZE - 1) {
                System.out.println("Antrian 1 penuh!");
            } else {
                if (rear1 == -1) {
                    front1 = 0;
                }
                rear1++;
                queue1[rear1] = data;
                System.out.println("Data " + data + " telah ditambahkan ke antrian 1.");
            }
        } else if (choice == 2) {
            if (rear2 == MAX_SIZE - 1) {
                System.out.println("Antrian 2 penuh!");
            } else {
                if (rear2 == -1) {
                    front2 = 0;
                }
                rear2++;
                queue2[rear2] = data;
                System.out.println("Data " + data + " telah ditambahkan ke antrian 2.");
            }
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }

    static void dequeue() {
        int choice;
        Scanner sc = new Scanner(System.in);

        System.out.println("Pilih jalur antrian : 1 / 2 ");
        choice = sc.nextInt();

        if (choice == 1) {
            if (front1 == -1) {
                System.out.println("Antrian 1 kosong!");
            } else {
                System.out.println("Elemen pertama dengan data " + 
                        queue1[front1] + " telah dihapus dari antrian 1.");
                if (front1 == rear1) {
                    front1 = -1;
                    rear1 = -1;
                } else {
                    front1++;
                }
            }
        } else if (choice == 2) {
            if (front2 == -1) {
                System.out.println("Antrian 2 kosong!");
            } else {
                System.out.println("Elemen pertama dengan data " + 
                        queue2[front2] + " telah dihapus dari antrian 2.");
                if (front2 == rear2) {
                    front2 = -1;
                    rear2 = -1;
                } else {
                    front2++;
                }
            }
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }
    
    static void dequeue(int pos) {
    if (front1 == -1 && front2 == -1) {
        System.out.println("Antrian kosong!");
    } else {
        int i, count = 0;
        for (i = front1; i <= rear1; i++) {
            count++;
            if (count == pos) {
                System.out.println("Data " + queue1[i] + " telah dihapus dari antrian 1.");
                if (i == rear1) {
                    rear1--;
                } else if (i == front1) {
                    front1++;
                } else {
                    for (int j = i; j < rear1; j++) {
                        queue1[j] = queue1[j + 1];
                    }
                    rear1--;
                }
                return;
            }
        }
        count = 0;
        for (i = front2; i <= rear2; i++) {
            count++;
            if (count == pos - (rear1 - front1 + 1)) {
                System.out.println("Data " + queue2[i] + " telah dihapus dari antrian 2.");
                if (i == rear2) {
                    rear2--;
                } else if (i == front2) {
                    front2++;
                } else {
                    for (int j = i; j < rear2; j++) {
                        queue2[j] = queue2[j + 1];
                    }
                    rear2--;
                }
                return;
            }
        }
        System.out.println("Posisi data tidak ditemukan!");
    }
}

static void clear() {
    front1 = -1;
    rear1 = -1;
    front2 = -1;
    rear2 = -1;
    System.out.println("Antrian berhasil dihapus!");
}

static void display() {
    if (front1 == -1 && front2 == -1) {
        System.out.println("Antrian kosong!");
    } else {
        int i;
        System.out.println("Data dalam antrian 1: ");
        if (front1 <= rear1) {
            for (i = front1; i <= rear1; i++) {
                System.out.print(queue1[i] + " ");
            }
        } else {
            for (i = front1; i < MAX_SIZE; i++) {
                System.out.print(queue1[i] + " ");
            }
            for (i = 0; i <= rear1; i++) {
                System.out.print(queue1[i] + " ");
            }
        }

        System.out.println("\nData dalam antrian 2: ");
        if (front2 <= rear2) {
           for (i = front2; i <= rear2; i++) {
               System.out.print(queue2[i] + " ");
           }
        } else {
            for (i = front2; i < MAX_SIZE; i++) {
                System.out.print(queue2[i] + " ");
            }
            for (i = 0; i <= rear2; i++) {
                System.out.print(queue2[i] + " ");
            }
        }
        System.out.println();
    }
}
}