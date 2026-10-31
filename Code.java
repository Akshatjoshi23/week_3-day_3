
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// ===================== STRATEGY: interchangeable pricing rules =====================
interface DiscountStrategy {
    double apply(double subtotal);
}

class NoDiscount implements DiscountStrategy {
    public double apply(double subtotal) { return subtotal; }
}

class PercentDiscount implements DiscountStrategy {
    private final double percent;

    PercentDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("percent must be between 0 and 100");
        }
        this.percent = percent;
    }

    public double apply(double subtotal) { return subtotal * (1 - percent / 100); }
}

class FlatDiscount implements DiscountStrategy {
    private final double amount;

    FlatDiscount(double amount) { this.amount = amount; }

    public double apply(double subtotal) { return Math.max(0, subtotal - amount); }
}

// ===================== FACTORY: coupon code -> the right strategy =====================
enum CouponType { NONE, SAVE10, FLAT50 }

class DiscountFactory {
    private DiscountFactory() { }

    static DiscountStrategy create(CouponType type) {
        if (type == null) {
            throw new IllegalArgumentException("coupon type is required");
        }
        switch (type) {
            case NONE:   return new NoDiscount();
            case SAVE10: return new PercentDiscount(10);
            case FLAT50: return new FlatDiscount(50);
            default:     throw new IllegalArgumentException("Unsupported coupon: " + type);
        }
    }
}

// ===================== BUILDER: immutable Order with optional parts =====================
final class Order {
    private static final double EXPRESS_FEE = 40.0;

    private final String customer;
    private final List<String> items;
    private final double subtotal;
    private final boolean express;
    private final String note;
    private final DiscountStrategy discount;       // composition: Order HAS a strategy

    private Order(Builder b) {
        this.customer = b.customer;
        this.items = Collections.unmodifiableList(new ArrayList<>(b.items));
        this.subtotal = b.subtotal;
        this.express = b.express;
        this.note = b.note;
        this.discount = b.discount;
    }

    static Builder builder(String customer) { return new Builder(customer); }

    double total() {
        double total = discount.apply(subtotal);
        return express ? total + EXPRESS_FEE : total;
    }

    @Override
    public String toString() {
        return "Order{customer=" + customer + ", items=" + items + ", subtotal=" + subtotal
                + ", express=" + express + ", note=" + note + ", total=" + total() + "}";
    }

    static class Builder {
        private final String customer;                          // required
        private final List<String> items = new ArrayList<>();
        private double subtotal;
        private boolean express;                                // optional
        private String note = "none";                           // optional
        private DiscountStrategy discount = new NoDiscount();   // optional, safe default

        private Builder(String customer) { this.customer = customer; }

        Builder addItem(String name, double price) {
            if (name == null || name.isBlank() || price <= 0) {
                throw new IllegalArgumentException("item needs a name and a positive price");
            }
            items.add(name);
            subtotal += price;
            return this;
        }

        Builder express()               { this.express = true; return this; }
        Builder note(String note)       { this.note = note;    return this; }

        Builder discount(DiscountStrategy discount) {
            this.discount = Objects.requireNonNull(discount, "discount is required");
            return this;
        }

        Order build() {
            if (customer == null || customer.isBlank()) {
                throw new IllegalStateException("customer is required");
            }
            if (items.isEmpty()) {
                throw new IllegalStateException("at least one item is required");
            }
            return new Order(this);
        }
    }
}

public class Code {
    public static void main(String[] args) {
        // Coupon text arrives as a String -> FACTORY picks the STRATEGY -> BUILDER assembles the Order
        DiscountStrategy save10 = DiscountFactory.create(CouponType.valueOf("SAVE10"));

        Order o1 = Order.builder("Asha")
                .addItem("Burger", 200)
                .addItem("Fries", 100)
                .express()
                .note("No onions")
                .discount(save10)
                .build();
        System.out.println(o1);

        Order o2 = Order.builder("Riya")
                .addItem("Pizza", 400)
                .discount(DiscountFactory.create(CouponType.FLAT50))
                .build();
        System.out.println(o2);

        // A brand-new rule with no new class: a lambda is a strategy
        Order o3 = Order.builder("Meera")
                .addItem("Cake", 800)
                .discount(subtotal -> subtotal * 0.75)    // festival 25% off
                .build();
        System.out.println(o3);

        // Edge cases fail fast with clear messages
        try {
            DiscountFactory.create(CouponType.valueOf("FREEALL"));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid coupon: FREEALL");
        }
        try {
            Order.builder("Riya").build();
        } catch (IllegalStateException e) {
            System.out.println("Cannot build: " + e.getMessage());
        }
    }
}


