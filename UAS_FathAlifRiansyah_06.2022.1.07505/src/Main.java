import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Kambing {
    public String nama;
    public double berat;
    public double tinggi;
    public double panjang;
    public boolean sudahDijual = false;
    public Map<Integer, Perkembangan> perkembanganMap = new HashMap<>();

    public Kambing(String nama, double beratAwal, double tinggiAwal, double panjangAwal) {
        this.nama = nama;
        this.berat = beratAwal;
        this.tinggi = tinggiAwal;
        this.panjang = panjangAwal;
    }

    public void updatePerkembangan(int bulan, double beratTambahan, double tinggiTambahan, double panjangTambahan) {
        perkembanganMap.put(bulan, new Perkembangan(beratTambahan, tinggiTambahan, panjangTambahan));
        this.berat += beratTambahan;
        this.tinggi += tinggiTambahan;
        this.panjang += panjangTambahan;
    }

    public void jualKambing() {
        sudahDijual = true;
    }

    public boolean isSudahDijual() {
        return sudahDijual;
    }

    public void tampilkanInfo() {
        System.out.println("Data Kambing " + this.nama + ":");
        System.out.println("Berat: " + this.berat + " kg");
        System.out.println("Tinggi: " + this.tinggi + " cm");
        System.out.println("Panjang: " + this.panjang + " cm");
        System.out.println("Sudah Dijual: " + (sudahDijual ? "Ya" : "Belum"));
        System.out.println("Perkembangan:");
        for (Map.Entry<Integer, Perkembangan> entry : perkembanganMap.entrySet()) {
            int bulan = entry.getKey();
            Perkembangan perkembangan = entry.getValue();
            System.out.println("Bulan " + bulan + ": Berat +" + perkembangan.beratTambahan + " kg, Tinggi +" + perkembangan.tinggiTambahan + " cm, Panjang +" + perkembangan.panjangTambahan + " cm");
        }
        System.out.println();
    }

    public class Perkembangan {
        double beratTambahan;
        double tinggiTambahan;
        double panjangTambahan;

        Perkembangan(double beratTambahan, double tinggiTambahan, double panjangTambahan) {
            this.beratTambahan = beratTambahan;
            this.tinggiTambahan = tinggiTambahan;
            this.panjangTambahan = panjangTambahan;
        }
    }
}

class PemilikKambing {
    public String namaPemilik;
    public ArrayList<Kambing> daftarKambing = new ArrayList<>();

    public PemilikKambing(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public void tambahKambing(Kambing kambing) {
        daftarKambing.add(kambing);
    }

    public void tampilkanInfoKambing() {
        System.out.println("Info Kambing milik " + this.namaPemilik + ":");
        for (Kambing kambing : daftarKambing) {
            kambing.tampilkanInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PemilikKambing pakSlamet = new PemilikKambing("Bapak Haji Slamet");

        Kambing kambing1 = new Kambing("Kambing Madura", 10, 80, 100);

        pakSlamet.tambahKambing(kambing1);


        // Update perkembangan kambing setiap bulan
        kambing1.updatePerkembangan(1, 2, 5, 10);
        kambing1.updatePerkembangan(2, 3, 6, 8);
        kambing1.updatePerkembangan(3, 1, 3, 5);

        // Kambing dijual
        kambing1.jualKambing();

        pakSlamet.tampilkanInfoKambing();
    }
}
