/*
 * Ad Soyad: Mehmet Furkan AKYAR
 * Ogrenci No: 240541056
 * Tarih: 13/11/2025 
 * Aciklama: Gorev 1 - Geometrik Sekil Hesaplayici
 * 
 * Bu program temel geometrik sekillerin alan ve
 * cevre hesaplamalarini yapar.
 */

import java.util.Scanner;

public class GeometriHesap {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        final double PI = 3.14;

        System.out.print("Karenin kenar uzunluğunu giriniz: ");
        double kareKenar = in.nextDouble();

        System.out.print("Dikdörtgenin genişliğini giriniz: ");
        double dikdortgenGenislik = in.nextDouble();

        System.out.print("Dikdörtgenin yüksekliğini giriniz: ");
        double dikdortgenYukseklik = in.nextDouble();

        System.out.print("Dairenin yarıçapını giriniz: ");
        double daireYaricap = in.nextDouble();

        System.out.print("Üçgenin yüksekliğini giriniz: ");
        double ucgenYukseklik = in.nextDouble();

        System.out.print("Üçgenin taban uzunluğunu giriniz: ");
        double ucgenTabanu = in.nextDouble();

        System.out.println("Üçgenin kenar uzunluklarını giriniz ");
        System.out.println("a kenarının uzunluğunu giriniz: ");
        double a = in.nextDouble();
        System.out.println("b kenarının uzunluğunu giriniz: ");
        double b = in.nextDouble();
        System.out.println("c kenarının uzunkupunu giriniz: ");
        double c = in.nextDouble();

        //--------------------------------------------------------------------------------------------

        double kareAlan = calculateSquareArea(kareKenar);
        double kareCevre = calculateSquarePerimeter(kareKenar);

        double dikdortgenAlan = calculateRectangleArea(dikdortgenGenislik, dikdortgenYukseklik);
        double dikdortgenCevre = calculateRectanglePerimeter(dikdortgenGenislik, dikdortgenYukseklik);

        double daireAlan = calculateCircleArea(daireYaricap);
        double daireCevre = calculateCircleCircumference(daireYaricap);

        double ucgenAlan =  calculateTriangleArea(ucgenYukseklik , ucgenTabanu);
        double ucgenCevre = calculateTrianglePerimeter(a, b, c);

        System.out.println("--- GEOMETRİK SEKIL HESAPLIYICI ---");
        System.out.printf("\nKARE (kenar %.2f cm):\n",  kareKenar);
        System.out.println("Karenin alanı: " + kareAlan);
        System.out.println("Karenin çevresi: " + kareCevre);

        System.out.printf("\nDIKDORTGEN (%.2f * %.2f cm):\n", dikdortgenYukseklik, dikdortgenGenislik);
        System.out.println("Dikdörtgenin alanı: " + dikdortgenAlan);
        System.out.println("Dikdörtgenin çevresi: " + dikdortgenCevre);

        System.out.printf("\nDAIRE (yaricap: %.2f cm):\n", daireYaricap);
        System.out.println("Dairenin alanı: " + daireAlan);
        System.out.println("Dairenin cevresi: " + daireCevre);

        System.out.printf("\nUCGEN (taban: %.2f, yukseklik: %.2f)\n" ,ucgenTabanu, ucgenYukseklik);
        System.out.println("Üçgenin alanı: " + ucgenAlan);
        System.out.println("Üçgenin çevresi: " + ucgenCevre);

        in.close();
    }

    //-----------------------------------------------------------------------------------------------

    public static double calculateSquareArea(double kenarUzunlugu) {
        return Math.pow(kenarUzunlugu, 2);
    }

    public static double calculateSquarePerimeter(double kenarUzunlugu) {
        return 4 * kenarUzunlugu;
    }

    public static double calculateRectangleArea(double width, double height) {
        return width * height;
    }

    public static double calculateRectanglePerimeter(double width, double height) {
        return 2 * (width + height);
    }

    public static double calculateCircleArea(double radius) {
        return Math.pow(radius , 2);
    }

    public static double calculateCircleCircumference(double radius) {
        return 2 * Math.PI * radius;

    }
    public static double calculateTriangleArea(double base , double height) {
        return base * height / 2.0;

    }
    public static double calculateTrianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }
    
}

