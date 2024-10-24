import java.util.Scanner;
import java.util.Locale;

class Buah {
    String nama;
    double harga;

    Buah(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    double getHarga(int jumlah) {
        if (this.nama.equalsIgnoreCase("Mangga") && jumlah == 1) {
            return 10000;
        }
        return this.harga;
    }
}

class ItemBelanja {
    Buah buah;
    int jumlah;

    ItemBelanja(Buah buah, int jumlah) {
        this.buah = buah;
        this.jumlah = jumlah;
    }

    double getSubtotal() {
        return buah.getHarga(jumlah) * jumlah;
    }

    double getHargaPerItem() {
        return buah.getHarga(jumlah);
    }
}

public class BuahArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        Buah[] daftarBuah = {
            new Buah("Apel", 35000),
            new Buah("Jeruk", 50000),
            new Buah("Mangga", 25000),
            new Buah("Duku", 15000),
            new Buah("Semangka", 20000)
        };

        ItemBelanja[] keranjang = new ItemBelanja[100];
        int itemCount = 0;

        int pilihan;
        do {
            System.out.println("Menu:");
            System.out.println("1. Beli Buah");
            System.out.println("2. Lihat Struk");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();

            if (pilihan == 1) {
                String lanjut;
                do {
                    System.out.println("Pilih Buah (0-4):");
                    for (int i = 0; i < daftarBuah.length; i++) {
                        System.out.println(i + ". " + daftarBuah[i].nama + " - Rp" + daftarBuah[i].harga);
                    }

                    System.out.print("Masukkan pilihan buah: ");
                    int pilihanBuah = scanner.nextInt();
                    System.out.print("Masukkan jumlah: ");
                    int jumlah = scanner.nextInt();

                    keranjang[itemCount] = new ItemBelanja(daftarBuah[pilihanBuah], jumlah);
                    itemCount++;

                    System.out.print("Input lagi? (y/n): ");
                    lanjut = scanner.next();
                } while (lanjut.equalsIgnoreCase("y"));
            } else if (pilihan == 2) {
                if (itemCount == 0) {
                    System.out.println("Keranjang belanja Anda kosong.");
                } else {
                    System.out.println("Daftar Belanja Anda:");
                    System.out.println("===================================================");
                    System.out.printf("%-3s %-10s %-7s %-10s %-10s\n", "No", "Nama", "Jumlah", "Harga", "Subtotal");

                    double totalHarga = 0;
                    for (int i = 0; i < itemCount; i++) {
                        ItemBelanja item = keranjang[i];
                        double hargaPerItem = item.getHargaPerItem();
                        double subtotal = item.getSubtotal();
                        System.out.printf("%-3d %-10s %-7d Rp%-9.0f Rp%-10.0f\n", (i + 1), item.buah.nama, item.jumlah, hargaPerItem, subtotal);
                        totalHarga += subtotal;
                    }

                    System.out.println("===================================================");
                    System.out.printf("Total harga: Rp%.0f\n", totalHarga);

                    double diskon = totalHarga * 0.15;
                    double totalBayar = totalHarga - diskon;
                    System.out.printf("Diskon (15%%): Rp%.0f\n", diskon);
                    System.out.printf("Total bayar: Rp%.0f\n", totalBayar);
                    System.out.println("--------------------");
                }
            } else if (pilihan != 3) {
                System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 3);

        System.out.println("Terima kasih sudah berbelanja!");
        scanner.close();
    }
}

