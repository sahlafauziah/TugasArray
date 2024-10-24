import java.util.Scanner;

public class NilaiMahasiswaArray {
    public static void main (String [] args) {
        Scanner inputan = new Scanner (System.in);
        System.out.print("Masukan Jumlah data : ");
        int n = inputan.nextInt ();
        String[][] data = new String [n][2];

        for (int i =0; i<n; i++) {
            System.out.println ("_______________________");
            System.out.println("Mahasiswa ke : " + (i+1));
            System.out.print ("Nama : ");
            data[i][0] = inputan.next();
            System.out.print("Nilai : ");
            data[i][1] = inputan.next();

        }
        double jumlah = 0;

        System.out.println("DAFTAR NILAI MAHASISWA ");
        System.out.println("====================================");
        System.out.println("No\tNama\tNilai\tStatus");
        for (int i=0; i<n; i++) {
            String status;
            int nilaiInt = Integer.parseInt (data[i][1]);
            if (nilaiInt >=60) {
                status = "Lulus";
            }else {
                status = "Tidak Lulus";
            }
            jumlah += nilaiInt;
            System.out.println ((i+1) + "\t"+data[i][0]+"\t"+data[i][1]+"\t"+status);
        }
        double rata_rata = (double) jumlah/n;
        System.out.println ("============================");
        System.out.println("jumlah :" +jumlah);
        System.out.println("Nilai Rata-Rata : "+rata_rata);
        inputan.close();
    }
}

