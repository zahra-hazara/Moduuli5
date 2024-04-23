package UnitTesting;
public class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");

        private final String color;

        Color(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return color;
        }
    }

    private Color currentColor;
    private boolean capped;

    public Pen() {
        this.currentColor = Color.RED; // Default color is RED
        this.capped = true; // Initially capped
    }

    public Pen(Color color) {
        this.currentColor = color;
        this.capped = true; // Initially capped
    }

    public String draw() {
        if (!capped) {
            return "Drawing " + currentColor;
        }
        return "";
    }

    public void capOff() {
        capped = false;
    }

    public void capOn() {
        capped = true;
    }

    public void changeColor(Color color) {
        if (!capped) {
            this.currentColor = color;
        }
    }
}

