public class Fraction {
  private int n;
  private int d;

  private static int active;

  public Fraction() {

    this(1, 1);
  }

  public Fraction(int n, int d) {

    if (n > 0) {

      this.n = n;

    } else {
      this.n = 1;
    }

    if (d > 0) {

      this.d = d;

    } else {
      this.d = 1;
    }

    active++;
  }

  // Accessor Methods
  public int getNumerator() {
    return n;
  }

  public int getDenominator() {
    return d;
  }

  public static int getNumFractions() {

    return active;
  }

  public String toString() {
    return n + "/" + d;
  }

  public String mixedNumber() {

    int full = n / d;
    int remainder = n % d;

    if (n < d) {
      return n + "/" + d;
    } else if (remainder == 0) {
      return String.valueOf(full);
    } else {
      return full + " " + remainder + "/" + d;
    }
  }
  // Mutator Methods

  public void setNumerator(int n) {

    if (n > 0) {

      this.n = n;
    }
  }

  public void setDenominator(int d) {

    if (d > 0) {

      this.d = d;
    }
  }

  // (n*this.d + this.n*d)/(d*this.d).
  public void add(int n, int d) {

    if (d > 0 && n > 0) {

      this.n = (n * this.d + this.n * d);
      this.d = d * this.d;
    }
  }

  public void add(Fraction other) {

    int n = other.getNumerator();
    int d = other.getDenominator();

    if (d > 0 && n > 0) {

      this.n = (n * this.d + this.n * d);
      this.d = d * this.d;
    }
  }

  public void multiply(int n, int d) {

    if (d > 0 && n > 0) {
      this.n = this.n * n;
      this.d = this.d * d;
    }
  }

  public void multiply(Fraction other) {

    int d = other.getDenominator();
    int n = other.getNumerator();

    if (d > 0 && n > 0) {
      this.n = this.n * n;
      this.d = this.d * d;
    }
  }
}
