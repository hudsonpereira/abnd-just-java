package br.com.hudsonpereira.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox addWhippedCream = findViewById(R.id.whipped_cream);
        CheckBox chocolate = findViewById(R.id.chocolate);
        EditText nameEditText = findViewById(R.id.name_edit_text);

        String priceMessage = "Name: " +  nameEditText.getText().toString() + "\n" +
                "Add whipped cream? " + addWhippedCream.isChecked() + "\n" +
                "Add chocolate? " + chocolate.isChecked() + "\n" +
                "Quantity: " + quantity + "\n" +
                "Total: " + (quantity * 5) + "\n" +
                "Thank you!";

        displayMessage(priceMessage);
    }

    public void increment(View view) {
        display(++quantity);
    }

    public void decrement(View view) {
        display(--quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(number + "");
    }

    private void displayPrice(int number) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}
