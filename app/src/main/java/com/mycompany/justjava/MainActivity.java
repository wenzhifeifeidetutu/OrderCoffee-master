package com.mycompany.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int numberOfCoffees = 0;
    int moneyOfCoffee ;
    String names ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view){
       switch (view.getId()){
           case R.id.increment:
               numberOfCoffees++;
               break;
           case R.id.decrement:
               numberOfCoffees--;
               if (numberOfCoffees <0 ) {
                   numberOfCoffees = 0;
                   Toast.makeText(this,"Prices is not < 0", Toast.LENGTH_SHORT).show();
               }
               break;
           case R.id.order_it:
               orderdispay();
               break;
           case R.id.get_name:
               EditText name = (EditText)findViewById(R.id.input_name);
               if (name.getText() !=null){
                   names =name.getText().toString();
                   changeName(names);
               }
               break;
           default:
               break;

       }
        display(numberOfCoffees);
        displayPrice(moneyOfCoffee(numberOfCoffees));


    }

    private void display(int i) {
        TextView textview = (TextView)findViewById(R.id.quantity_text_view);
        textview.setText(i+"");
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text);
        quantityTextView.setText("Quantity:"+i);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText("Total:"+NumberFormat.getCurrencyInstance().format(number));

    }

    private int moneyOfCoffee(int numberOfCoffees){
        moneyOfCoffee = 5*numberOfCoffees;
        return moneyOfCoffee;
    }

    private void changeName(String names){
       TextView ordername = (TextView)findViewById(R.id.order);
        ordername.setText("Name :"+names);
    }

    private void orderdispay() {
        CheckBox whippedCream = (CheckBox)findViewById(R.id.whipped_cream);
        CheckBox choclate = (CheckBox)findViewById(R.id.Chocolate);


        View orderview = findViewById(R.id.order_views);

        TextView whippedCreamText = (TextView)findViewById(R.id.whipped_cream_is);
        if (whippedCream.isChecked()){

            whippedCreamText.setText("Whipped Cream: true");
        }else {
            whippedCreamText.setText("Whipped Cream: false");
        }
        TextView choclatetext = (TextView)findViewById(R.id.Chocolate_is);
        if (choclate.isChecked()){

            choclatetext.setText("Chocolate: true");

        }else {
            choclatetext.setText("Chocolate: false");
        }

        orderview.setVisibility(View.VISIBLE);





        display(numberOfCoffees);
        displayPrice(moneyOfCoffee(numberOfCoffees));

    }
}
