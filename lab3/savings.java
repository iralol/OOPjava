
public class savings {
    // =========================
    // Private gishuun ogogdol
    // =========================
    private String name;        // hadgalamjin ner
    private String currency;    // valiut
    private double annualRate;  // jilin huu (%)
    private int months;         // hugatsaa (sar)
    private double initialBalance; // ehni uldegdel

    // Constructor
    // =========================
    public savings(String name, String currency, double annualRate, int months, double initialBalance) {
        this.name = name;
        this.currency = currency;
        this.annualRate = annualRate;
        this.months = months;
        this.initialBalance = initialBalance;
    }

    // ==========================================
    // Private function - hurimtlagdsn huu bodoh
    // ==========================================
    private double savingsCalcAccrued() {
        return initialBalance * (annualRate / 12) * months / 100;
    }

    // ==========================================
    // Private function - etsesin uldegdel bodoh
    // ==========================================
    private double savingsCalc() {
        return initialBalance + savingsCalcAccrued();
    }

    // ==========================================
    // Public function - tailan hevleh
    // ==========================================
    public void savingsReport() {

        double accruedInterest = savingsCalcAccrued();
        double finalBalance = savingsCalc();

        System.out.printf("ta \"%s\"-d %,.1f%s-iig %d -n sarin hugatsaatai, jilin %.1f%%-iin huute hadgaluulbal:\n",
                name, initialBalance, currency, months, annualRate);

        System.out.printf("hadgalamjin uldegdel: %,.1f%s boln.\n",
                finalBalance, currency);

        System.out.printf("hurimtlagdsn huu: %,.1f%s baina.\n",
                accruedInterest, currency);
    }
}
