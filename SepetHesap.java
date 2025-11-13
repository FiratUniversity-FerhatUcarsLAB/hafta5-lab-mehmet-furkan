/*
 * Ad Soyad: Mehmet Furkan AKYAR
 * Ogrenci No: 240541056
 * Tarih: 13/11/2025
 * Aciklama: Gorev 3 - E-Ticaret Sepet Hesaplayici
 *
 * Bu program 3 adet urunun sepet tutarini
 * KDV, indirim ve kargo dahil hesaplar.
 */

import java.util.Scanner;

public class SepetHesap {

    // Sabitler
    final static double VAT_RATE = 0.18;       // KDV Oranı (%18)
    final static double SHIPPING_FEE = 29.99;  // Sabit Kargo Ücreti (TL)

    // METOT 1: Bir ürünün toplam fiyatını hesaplar (fiyat * adet)
    public static double calculateLineTotal(double price, int quantity) {
        // Satır Toplamı = fiyat * adet
        return price * quantity;
    }

    // METOT 2: Sepetteki 3 ürünün ara toplamını hesaplar
    public static double calculateSubtotal(double line1, double line2, double line3) {
        // Ara Toplam = urun1 + urun2 + urun3
        return line1 + line2 + line3;
    }

    // METOT 3: İndirim tutarını hesaplar
    public static double calculateDiscountAmount(double subtotal, double discountPercentage) {
        // İndirim Tutarı = araToplam * (indirimYuzdesi / 100)
        return subtotal * (discountPercentage / 100.0);
    }

    // METOT 4: İndirimli fiyatı hesaplar (aratoplam - indirimtutari)
    public static double applyDiscount(double subtotal, double discountAmount) {
        // İndirimli Toplam = araToplam - indirimTutari
        return subtotal - discountAmount;
    }

    // METOT 5: KDV tutarını hesaplar (indirimliTutar * kdvOrani)
    public static double calculateVAT(double discountedTotal, double vatRate) {
        // KDV Tutarı = indirimliTutar * VAT_RATE
        return discountedTotal * vatRate;
    }

    // METOT 6: Genel Toplamı hesaplar (indirimliTutar + kdv + kargo)
    public static double calculateGrandTotal(double discountedTotal, double vatAmount, double shippingFee) {
        // Genel Toplam = indirimliTutar + kdvTutari + kargoUcreti
        return discountedTotal + vatAmount + shippingFee;
    }

    //------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== E-TİCARET SEPET HESAPLAYICI ===");
        System.out.println("\nLütfen 3 ürünün bilgilerini girin:");

        // ÜRÜN 1 Bilgileri
        System.out.println("\nÜRÜN 1:");
        System.out.print("* Birim Fiyat (TL): ");
        double price1 = input.nextDouble();
        System.out.print("* Adet: ");
        int qty1 = input.nextInt();

        // ÜRÜN 2 Bilgileri
        System.out.println("\nÜRÜN 2:");
        System.out.print("* Birim Fiyat (TL): ");
        double price2 = input.nextDouble();
        System.out.print("* Adet: ");
        int qty2 = input.nextInt();

        // ÜRÜN 3 Bilgileri
        System.out.println("\nÜRÜN 3:");
        System.out.print("* Birim Fiyat (TL): ");
        double price3 = input.nextDouble();
        System.out.print("* Adet: ");
        int qty3 = input.nextInt();

        // İNDİRİM Bilgisi
        System.out.print("\nİndirim Kuponu Yüzdesi (%): ");
        double discountPercent = input.nextDouble();

       
        // 1. Ürünlerin satış toplamlarını hesapla
        double line1Total = calculateLineTotal(price1, qty1);
        double line2Total = calculateLineTotal(price2, qty2);
        double line3Total = calculateLineTotal(price3, qty3);

        // 2. Ara toplamı hesapla
        double subtotal = calculateSubtotal(line1Total, line2Total, line3Total);

        // 3. İndirim tutarını hesapla
        double discountAmount = calculateDiscountAmount(subtotal, discountPercent);

        // 4. İndirimli toplamı hesapla
        double discountedTotal = applyDiscount(subtotal, discountAmount);

        // 5. KDV tutarını hesapla (İndirimli toplam üzerinden)
        double vatAmount = calculateVAT(discountedTotal, VAT_RATE);

        // 6. Genel toplamı hesapla
        double grandTotal = calculateGrandTotal(discountedTotal, vatAmount, SHIPPING_FEE);

        //-----------------------------------------------------------------------------------------------

        // SONUÇLARI YAZDIR
        System.out.println("\n==================================");
        System.out.println("          SİPARİŞ ÖZETİ");
        System.out.println("====================================");
        System.out.printf("Ürün 1 Toplam (%.2f TL x %d): %.2f TL\n", price1, qty1, line1Total);
        System.out.printf("Ürün 2 Toplam (%.2f TL x %d): %.2f TL\n", price2, qty2, line2Total);
        System.out.printf("Ürün 3 Toplam (%.2f TL x %d): %.2f TL\n", price3, qty3, line3Total);
        System.out.println("------------------------------------");
        System.out.printf("Ara Toplam                  : %.2f TL\n", subtotal);
        System.out.printf("İndirim (%%%1.0f)              : -%.2f TL\n", discountPercent, discountAmount);
        System.out.printf("İndirimli Toplam            : %.2f TL\n", discountedTotal);
        System.out.printf("KDV (%%%1.0f)                  : +%.2f TL\n", (VAT_RATE * 100), vatAmount);
        System.out.printf("Kargo Ücreti                : +%.2f TL\n", SHIPPING_FEE);
        System.out.println("------------------------------------");
        System.out.printf("GENEL TOPLAM                : %.2f TL\n", grandTotal);
        System.out.println("====================================");

        input.close();
    }
}
