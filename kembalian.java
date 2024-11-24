import java.util.Arrays;
import java.util.Scanner;

class Kembalian {
    // Fungsi untuk mencari jumlah minimum koin yang dibutuhkan untuk kembalian
    public static int minKoin(int jumlah) {
        // Daftar koin yang tersedia
        int[] koin = { 2, 3, 5, 10, 15 };
        // Array untuk menyimpan jumlah minimum koin yang dibutuhkan untuk kembalian
        int[] dp = new int[jumlah + 1];

        // Inisialisasi array dp dengan nilai yang sangat besar untuk kembalian
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // Proses untuk mencari jumlah minimum koin
        for (int i = 1; i <= jumlah; i++) {
            for (int k : koin) {
                if (i - k >= 0 && dp[i - k] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - k] + 1);
                }
            }
        }

        return dp[jumlah] == Integer.MAX_VALUE ? -1 : dp[jumlah];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah yang ingin dikembalikan: ");
        int jumlah = scanner.nextInt();

        int result = minKoin(jumlah);

        if (result != -1) {
            System.out.println("Jumlah koin minimum yang dibutuhkan untuk " + jumlah + " adalah: " + result);
        } else {
            System.out.println("maaf anda tidak mendapatkan kembalian dengan jumlah koin tersebut karena tidak tersedi.");
        }

        scanner.close();
    }
}