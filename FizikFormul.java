/*
 * Ad Soyad: Mehmet Furkan AKYAR
 * Ogrenci No: 240541056
 * Tarih: 13/11/2025
 * Aciklama: Gorev 2 - Fizik Formulu Asistani
 *
 * Bu program temel fizik formullerini kullanarak
 * hesaplamalar yapar.
 */

import java.util.Scanner;

public class FizikFormul {

    // Sabit: Yerçekimi ivmesi (m/s²)
    final static double GRAVITY = 9.81;

    // METOT 1: Hız hesapla (v = s / t)
    public static double calculateVelocity(double distance, double time) {
        return distance / time;
    }

    // METOT 2: İvme hesapla (a = Δv / t)
    public static double calculateAcceleration(double velocityChange, double time) {
        return velocityChange / time;
    }

    // METOT 3: Kuvvet hesapla (F = m * a)
    public static double calculateForce(double mass, double acceleration) {
        return mass * acceleration;
    }

    // METOT 4: İş hesapla (W = F * d)
    public static double calculateWork(double force, double distance) {
        return force * distance;
    }

    // METOT 5: Güç hesapla (P = W / t)
    public static double calculatePower(double work, double time) {
        return work / time;
    }

    // METOT 6: Kinetik enerji (KE = 0.5 * m * v^2)
    public static double calculateKineticEnergy(double mass, double velocity) {
        // KE = 0.5 * kütle * (hız * hız)
        // Math.pow(velocity, 2)
        return 0.5 * mass * Math.pow(velocity, 2);
    }

    // METOT 7: Potansiyel enerji (PE = m * g * h)
    public static double calculatePotentialEnergy(double mass, double gravity, double height) {
        // PE = kütle * yerçekimi * yükseklik
        return mass * gravity * height;
    }

    // METOT 8: Momentum (p = m * v)
    public static double calculateMomentum(double mass, double velocity) {
        // p = kütle * hız
        return mass * velocity;
    }

    //------------------------------------------------------------------------------------------------
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== FİZİK FORMÜL ASİSTANI ===");
        System.out.println();

        System.out.println("TEMEL ÖLÇÜMLER:");
        System.out.print("Kütle (kg): ");
        double mass = input.nextDouble();

        System.out.print("Mesafe (m): ");
        double distance = input.nextDouble();

        System.out.print("Zaman (s): ");
        double time = input.nextDouble();

        System.out.print("Hız Değişimi (m/s): ");
        double velocityChange = input.nextDouble();

        System.out.print("Yükseklik (m): ");
        double height = input.nextDouble();


        // 1. Temel hareket hesaplamaları
        double velocity = calculateVelocity(distance, time);
        double acceleration = calculateAcceleration(velocityChange, time);

        // 2. Kuvvet (İvme'ye bağlı)
        double force = calculateForce(mass, acceleration);

        // 3. İş (Kuvvet'e bağlı)
        double work = calculateWork(force, distance);

        // 4. Güç (İş'e bağlı)
        double power = calculatePower(work, time);

        // 5. Enerji ve Momentum (Hız'a bağlı)
        double kineticEnergy = calculateKineticEnergy(mass, velocity);
        double potentialEnergy = calculatePotentialEnergy(mass, GRAVITY, height);
        double momentum = calculateMomentum(mass, velocity);

        // Toplam enerji (KE + PE)
        double totalEnergy = kineticEnergy + potentialEnergy;

        //------------------------------------------------------------------------------------------------
        
        // SONUÇLARI YAZDIR
        System.out.println("\n==================================");
        System.out.println("       HESAPLAMA SONUÇLARI");
        System.out.println("====================================");

        System.out.println("\nHIZ ve HAREKET:");
        System.out.printf("* Hız (v = s/t)            : %.2f m/s\n", velocity);
        System.out.printf("* İvme (a = Δv/t)          : %.2f m/s²\n", acceleration);

        System.out.println("\nKUVVET ve İŞ:");
        System.out.printf("* Kuvvet (F = m*a)         : %.2f N\n", force);
        System.out.printf("* İş (W = F*d)             : %.2f J\n", work);
        System.out.printf("* Güç (P = W/t)            : %.2f W\n", power);

        System.out.println("\nENERJİ:");
        System.out.printf("* Kinetik Enerji (KE)      : %.2f J\n", kineticEnergy);
        System.out.printf("* Potansiyel Enerji (PE)   : %.2f J\n", potentialEnergy);
        System.out.printf("* Toplam Enerji            : %.2f J\n", totalEnergy);

        System.out.println("\nMOMENTUM:");
        System.out.printf("* Momentum (p = m*v)       : %.2f kg·m/s\n", momentum);

        System.out.println("\n==================================");

        input.close();
    }
}
