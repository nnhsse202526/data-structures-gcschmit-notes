/**
   A class to to test the Polynomial class.
*/
public class PolynomialTester
{
   public static void main(String[] args)
   {
      Polynomial p = new Polynomial(new Term(-10, 0));
      p.print();
      System.out.println("\nExpected: - 10.0");
      p.add(new Polynomial(new Term(-1, 1)));
      p.print();
      System.out.println("\nExpected: - 1.0x - 10.0");
      p.add(new Polynomial(new Term(9, 7)));
      p.print();
      System.out.println("\nExpected: 9.0x^7 - 1.0x - 10.0");
      p.add(new Polynomial(new Term(5, 10)));
      p.print();
      System.out.println("\nExpected: 5.0x^10 + 9.0x^7 - 1.0x - 10.0");

      Polynomial q = p.multiply(p);
      q.print();
      System.out.println("\nExpected: 25.0x^20 + 90.0x^17 + 81.0x^14 - 10.0x^11 - 100.0x^10 - 18.0x^8 - 180.0x^7 + 1.0x^2 + 20.0x + 100.0");

      // --- Additional comprehensive tests ---

      // Test: Empty polynomial
      Polynomial empty = new Polynomial();
      System.out.print("Empty: ");
      empty.print();
      System.out.println("\nExpected: 0");

      // Test: Single term, positive coefficient
      Polynomial singlePos = new Polynomial(new Term(3, 4));
      System.out.print("Single positive: ");
      singlePos.print();
      System.out.println("\nExpected: 3.0x^4");

      // Test: Single term, negative coefficient
      Polynomial singleNeg = new Polynomial(new Term(-2, 2));
      System.out.print("Single negative: ");
      singleNeg.print();
      System.out.println("\nExpected: - 2.0x^2");

      // Test: Add polynomials with overlapping powers
      Polynomial a = new Polynomial(new Term(2, 2));
      a.add(new Polynomial(new Term(3, 2)));
      System.out.print("Add overlap: ");
      a.print();
      System.out.println("\nExpected: 5.0x^2");

      // Test: Add polynomials with non-overlapping powers
      Polynomial b = new Polynomial(new Term(1, 3));
      b.add(new Polynomial(new Term(4, 1)));
      System.out.print("Add non-overlap: ");
      b.print();
      System.out.println("\nExpected: 1.0x^3 + 4.0x");

      // Test: Add polynomials that cancel to zero
      Polynomial c = new Polynomial(new Term(5, 5));
      c.add(new Polynomial(new Term(-5, 5)));
      System.out.print("Add cancel: ");
      c.print();
      System.out.println("\nExpected: 0");

      // Test: Multiply by zero polynomial
      Polynomial d = new Polynomial(new Term(2, 2));
      Polynomial zero = new Polynomial();
      Polynomial prodZero = d.multiply(zero);
      System.out.print("Multiply by zero: ");
      prodZero.print();
      System.out.println("\nExpected: 0");

      // Test: Multiply by one (x^0)
      Polynomial e = new Polynomial(new Term(7, 3));
      Polynomial one = new Polynomial(new Term(1, 0));
      Polynomial prodOne = e.multiply(one);
      System.out.print("Multiply by one: ");
      prodOne.print();
      System.out.println("\nExpected: 7.0x^3");

      // Test: Chained adds
      Polynomial chain = new Polynomial(new Term(1, 1));
      chain.add(new Polynomial(new Term(2, 2)));
      chain.add(new Polynomial(new Term(3, 3)));
      chain.add(new Polynomial(new Term(4, 4)));
      System.out.print("Chained adds: ");
      chain.print();
      System.out.println("\nExpected: 4.0x^4 + 3.0x^3 + 2.0x^2 + 1.0x");

      // Test: Chained multiplies
      Polynomial m1 = new Polynomial(new Term(2, 1));
      Polynomial m2 = new Polynomial(new Term(3, 0));
      Polynomial m3 = new Polynomial(new Term(4, 0));
      Polynomial prodChain = m1.multiply(m2).multiply(m3);
      System.out.print("Chained multiplies: ");
      prodChain.print();
      System.out.println("\nExpected: 24.0x");

      // Test: Negative exponents (should not be allowed, but check behavior)
      Polynomial negExp = new Polynomial(new Term(2, -2));
      System.out.print("Negative exponent: ");
      negExp.print();
      System.out.println("\nExpected: 2.0x^-2 or error");
   }
}
