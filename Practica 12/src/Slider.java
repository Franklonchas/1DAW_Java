
import java.awt.*;
import java.awt.event.*;

public class Slider extends Frame {

    private Panel pColor, pAbajo, pRed, pGreen, pBlue;
    private Scrollbar sRed, sGreen, sBlue;
    private Label lRed, lGreen, lBlue;
    private Color color;

    public Slider(String title) {
        super(title);

        setLayout(new GridLayout(2, 1));

        pColor = new Panel();
        color = new Color(0, 0, 0);
        pColor.setBackground(color);
        add(pColor);

        pAbajo = new Panel(new GridLayout(3, 1));

        pRed = new Panel();
        sRed = new Scrollbar(Scrollbar.HORIZONTAL, 0, 0, 0, 256);
        lRed = new Label("Rojo = " + sRed.getValue() + "    ");

        pRed.add(sRed);
        pRed.add(lRed);

        pGreen = new Panel();
        sGreen = new Scrollbar(Scrollbar.HORIZONTAL, 0, 0, 0, 256);
        lGreen = new Label("Verde = " + sGreen.getValue() + "    ");

        pGreen.add(sGreen);
        pGreen.add(lGreen);

        pBlue = new Panel();
        sBlue = new Scrollbar(Scrollbar.HORIZONTAL, 0, 0, 0, 256);
        lBlue = new Label("Azul = " + sBlue.getValue() + "    ");

        pBlue.add(sBlue);
        pBlue.add(lBlue);

        pAbajo.add(pRed);
        pAbajo.add(pGreen);
        pAbajo.add(pBlue);

        add(pAbajo);

        addWindowListener(new ControlVentana());
        sRed.addAdjustmentListener(new ControlScroll());
        sGreen.addAdjustmentListener(new ControlScroll());
        sBlue.addAdjustmentListener(new ControlScroll());

    }

    public Slider() {
        this("");
    }

    class ControlVentana extends WindowAdapter {

        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    }

    class ControlScroll implements AdjustmentListener {

        public void adjustmentValueChanged(AdjustmentEvent ae) {
            if (ae.getSource() == sRed) {
                color = new Color(ae.getValue(), sGreen.getValue(), sBlue.getValue());
                pColor.setBackground(color);
                lRed.setText("Rojo = " + ae.getValue() + "    ");
            }
            if (ae.getSource() == sBlue) {
                color = new Color(sRed.getValue(), sGreen.getValue(), ae.getValue());
                pColor.setBackground(color);
                lBlue.setText("Azul = " + ae.getValue() + "    ");
            }
            if (ae.getSource() == sGreen) {
                color = new Color(sRed.getValue(), ae.getValue(), sBlue.getValue());
                pColor.setBackground(color);
                lGreen.setText("Verde = " + ae.getValue() + "    ");
            }
        }
    }
}
